----------------------------------------------------------------------------------------
-------------------------------- Creación de las tablas --------------------------------
----------------------------------------------------------------------------------------

-------------------------------------- taskStatus --------------------------------------

CREATE TABLE IF NOT EXISTS "task_status" (
    "id_task_status" BIGSERIAL NOT NULL,
    "name" VARCHAR(11) NOT NULL UNIQUE,
    PRIMARY KEY ("id_task_status")
);

----------------------------------------------------------------------------------------

--------------------------------------- voluntary --------------------------------------

CREATE TABLE IF NOT EXISTS "voluntary" (
    "rut" VARCHAR(10) NOT NULL,
    "name" VARCHAR(30) NOT NULL,
    "lastnames" VARCHAR(60) NOT NULL,
    "email" VARCHAR(255) NOT NULL UNIQUE,
    "password" VARCHAR(255) NOT NULL,
    "phone" VARCHAR(12) NOT NULL,
    "avaible" BOOLEAN NOT NULL,
    PRIMARY KEY ("rut")
);

----------------------------------------------------------------------------------------

-------------------------------------- institution --------------------------------------

CREATE TABLE IF NOT EXISTS "institution" (
    "id_institution" BIGSERIAL NOT NULL,
    "name" VARCHAR(60) NOT NULL UNIQUE,
    PRIMARY KEY ("id_institution")
);

----------------------------------------------------------------------------------------

-------------------------------------- emergency --------------------------------------

CREATE TABLE IF NOT EXISTS "emergency" (
    "id_emergency" BIGSERIAL NOT NULL,
    "description" TEXT NOT NULL,
    "date" TIMESTAMP NOT NULL,
    "active" BOOLEAN NOT NULL,
    "id_institution" BIGINT NOT NULL,
    PRIMARY KEY ("id_emergency"),
    FOREIGN KEY ("id_institution") REFERENCES "institution"("id_institution")
);

----------------------------------------------------------------------------------------

----------------------------------------- task -----------------------------------------

CREATE TABLE IF NOT EXISTS "task" (
    "id_task" BIGSERIAL NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "description" TEXT,
    "id_task_status" BIGINT NOT NULL,
    "id_emergency" BIGINT NOT NULL,
    PRIMARY KEY ("id_task"),
    FOREIGN KEY ("id_task_status") REFERENCES "task_status"("id_task_status"),
    FOREIGN KEY ("id_emergency") REFERENCES "emergency"("id_emergency")
);

----------------------------------------------------------------------------------------

---------------------------------------- ranking ---------------------------------------

CREATE TABLE IF NOT EXISTS "ranking" (
    "id_ranking" BIGSERIAL NOT NULL,
    "score" INT NOT NULL,
    "rut_voluntary" VARCHAR(10) NOT NULL,
    "id_task" BIGINT NOT NULL,
    PRIMARY KEY ("id_ranking"),
    FOREIGN KEY ("rut_voluntary") REFERENCES "voluntary"("rut"),
    FOREIGN KEY ("id_task") REFERENCES "task"("id_task")
);

----------------------------------------------------------------------------------------

-------------------------------------- requirement -------------------------------------

CREATE TABLE IF NOT EXISTS "requirement" (
    "id_requirement" BIGSERIAL NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "description" TEXT NOT NULL,
    PRIMARY KEY ("id_requirement")
);

----------------------------------------------------------------------------------------

--------------------------------- voluntary_requirement --------------------------------

CREATE TABLE IF NOT EXISTS "voluntary_requirement" (
    "id_voluntary_requirement" BIGSERIAL NOT NULL,
    "rut_voluntary" VARCHAR(10) NOT NULL,
    "id_requirement" BIGINT NOT NULL,
    PRIMARY KEY ("id_voluntary_requirement"),
    FOREIGN KEY ("rut_voluntary") REFERENCES "voluntary"("rut"),
    FOREIGN KEY ("id_requirement") REFERENCES "requirement"("id_requirement")
);

----------------------------------------------------------------------------------------

--------------------------------- emergency_requirement --------------------------------

CREATE TABLE IF NOT EXISTS "emergency_requirement" (
    "id_emergency_requirement" BIGSERIAL NOT NULL,
    "id_emergency" BIGINT NOT NULL,
    "id_requirement" BIGINT NOT NULL,
    PRIMARY KEY ("id_emergency_requirement"),
    FOREIGN KEY ("id_emergency") REFERENCES "emergency"("id_emergency"),
    FOREIGN KEY ("id_requirement") REFERENCES "requirement"("id_requirement")
);

----------------------------------------------------------------------------------------

------------------------------------ task_requirement ----------------------------------

CREATE TABLE IF NOT EXISTS "task_requirement" (
    "id_task_requirement" BIGSERIAL NOT NULL,
    "id_task" BIGINT NOT NULL,
    "id_requirement" BIGINT NOT NULL,
    PRIMARY KEY ("id_task_requirement"),
    FOREIGN KEY ("id_task") REFERENCES "task"("id_task"),
    FOREIGN KEY ("id_requirement") REFERENCES "requirement"("id_requirement")
);

----------------------------------------------------------------------------------------

------------------------------------ trigger table Queries  ---------------------------

CREATE TABLE IF NOT EXISTS "query_log" (
    "id" BIGSERIAL PRIMARY KEY,
    "username" VARCHAR(50) NOT NULL,
    "query_text" VARCHAR(255) NOT NULL,
    "table_name" VARCHAR(50) NOT NULL,
    "date" TIMESTAMP NOT NULL,
    PRIMARY KEY ("id")
    );


CREATE OR REPLACE FUNCTION log_query()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO query_log (username, query_text, table_name, date)
        VALUES (current_user, 'INSERT', TG_TABLE_NAME, now());
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO query_log (username, query_text, table_name, date)
        VALUES (current_user, 'UPDATE', TG_TABLE_NAME, now());
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO query_log (username, query_text, table_name, date)
        VALUES (current_user, 'DELETE', TG_TABLE_NAME, now());
END IF;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER task_status_query_log
    AFTER INSERT OR UPDATE OR DELETE ON task_status
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER voluntary_query_log
    AFTER INSERT OR UPDATE OR DELETE ON voluntary
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER institution_query_log
    AFTER INSERT OR UPDATE OR DELETE ON institution
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER emergency_query_log
    AFTER INSERT OR UPDATE OR DELETE ON emergency
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER task_query_log
    AFTER INSERT OR UPDATE OR DELETE ON task
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER requirement_query_log
    AFTER INSERT OR UPDATE OR DELETE ON requirement
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER voluntary_requirement_query_log
    AFTER INSERT OR UPDATE OR DELETE ON voluntary_requirement
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER emergency_requirement_query_log
    AFTER INSERT OR UPDATE OR DELETE ON emergency_requirement
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();


CREATE TRIGGER task_requirement_query_log
    AFTER INSERT OR UPDATE OR DELETE ON task_requirement
    FOR EACH STATEMENT
    EXECUTE FUNCTION log_query();

----------------------------------------------------------------------------------------

------------------------------------ stored procedure  ---------------------------

CREATE OR REPLACE FUNCTION generate_query_report()
    RETURNS TABLE (username VARCHAR(50), query_count INT, query_texts TEXT[]) AS $$
BEGIN
    RETURN QUERY
        SELECT
            username,
            COUNT(*) AS query_count,
            ARRAY_AGG(query_text) AS query_texts
        FROM
            query_log
        WHERE
                query_text LIKE '%INSERT%' OR
                query_text LIKE '%UPDATE%' OR
                query_text LIKE '%DELETE%'
        GROUP BY
            username
        ORDER BY
            query_count DESC;
END;
$$ LANGUAGE plpgsql;


-- SELECT * FROM generate_query_report();

----------------------------------------------------------------------------------------


------------------------------------ trigger voluntary Queries  ---------------------------

CREATE TABLE IF NOT EXISTS "query_voluntary_log" (
    "id_query" BIGSERIAL NOT NULL ,
    "task_id" BIGINT NOT NULL,
    "volunteer_id" VARCHAR(10) NOT NULL,
    "action_type" VARCHAR(50) NOT NULL,
    "action_timestamp" TIMESTAMP NOT NULL,
    PRIMARY KEY ("id_query")
    );

