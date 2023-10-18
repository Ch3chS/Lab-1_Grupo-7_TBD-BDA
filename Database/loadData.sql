----------------------------------------------------------------------------------------
-------------------------------- Llenado de las tablas --------------------------------
----------------------------------------------------------------------------------------

-------------------------------------- taskStatus --------------------------------------

INSERT INTO "task_status" ("name") VALUES ('Pendiente');
INSERT INTO "task_status" ("name") VALUES ('En Progreso');
INSERT INTO "task_status" ("name") VALUES ('Completada');

----------------------------------------------------------------------------------------

--------------------------------------- voluntary --------------------------------------

INSERT INTO voluntary (rut, name, lastnames, email, password, phone, avaible) VALUES
('12345678-9', 'Juan', 'Perez Gonzalez', 'juan.perez@mail.com', 'password1', '912345678', true),
('23456789-0', 'Maria', 'Rodriguez Lopez', 'maria.rodriguez@mail.com', 'password2', '923456789', true),
('34567890-1', 'Pedro', 'Gomez Ramirez', 'pedro.gomez@mail.com', 'password3', '934567890', false),
('45678901-2', 'Carlos', 'Sanchez Jimenez', 'carlos.sanchez@mail.com', 'password4', '945678901', true),
('56789012-3', 'Ana', 'Martinez Fernandez', 'ana.martinez@mail.com', 'password5', '956789012', false);



----------------------------------------------------------------------------------------

-------------------------------------- institution --------------------------------------

INSERT INTO "institution" ("name") VALUES 
('Centro de Respuesta Rápida a Emergencias'),
('Instituto de Intervención Inmediata'),
('Unidad de Urgencias Unificadas'),
('Sociedad de Salvamento Seguro'),
('Organización de Operaciones de Emergencia'),
('Entidad de Evacuación Eficiente'),
('Alianza de Asistencia en Accidentes'),
('Comunidad de Coordinación de Crisis'),
('Fundación de Fuerzas de Primeros Auxilios'),
('Consejo de Control de Catástrofes'),
('Escuela de Especialistas en Emergencias'),
('Academia de Acción en Desastres'),
('Universidad de Urgencias Únicas'),
('Facultad de Fuerzas de Rescate Rápido'),
('Seminario de Seguridad en Situaciones Severas'),
('Asamblea de Asistencia en Adversidades'),
('Núcleo de Navegación en Emergencias'),
('Zona de Zelosos Zafiros (equipo de rescate acuático)'),
('Grupo de Guardianes del Granizo (equipo de rescate en nieve)'),
('Equipo de Élite en Emergencias');


----------------------------------------------------------------------------------------

-------------------------------------- emergency --------------------------------------

INSERT INTO "emergency" ("description", "date", "active", "id_institution") VALUES 
('Incendio en el centro de la ciudad', '2023-10-18 00:24:30', TRUE, 1),
('Inundación en la zona norte', '2023-10-17 22:00:00', TRUE, 2),
('Accidente de tráfico en la autopista', '2023-10-17 18:45:00', FALSE, 3),
('Deslizamiento de tierra en el parque', '2023-10-17 16:30:00', FALSE, 4),
('Persona perdida en el bosque', '2023-10-17 14:15:00', TRUE, 5),
('Rescate de gato en árbol alto', '2023-10-17 12:00:00', FALSE, 6),
('Derrame de sustancias químicas en fábrica', '2023-10-17 09:45:00', TRUE, 7),
('Apagón en la zona sur de la ciudad', '2023-10-17 07:30:00', FALSE, 8),
('Rescate de montañista lesionado', '2023-10-17 05:15:00', TRUE, 9),
('Evacuación de edificio por amenaza de bomba', '2023-10-17 03:00:00', FALSE, 10),
('Incendio forestal en el parque nacional', '2023-10-17 00:45:00', TRUE, 11),
('Terremoto de magnitud 6.5 en la ciudad', '2023-10-16 22:30:00', FALSE, 12),
('Accidente aéreo cerca del aeropuerto', '2023-10-16 20:15:00', TRUE, 13),
('Derrumbe de edificio en construcción', '2023-10-16 18:00:00', FALSE, 14),
('Fuga de gas en edificio residencial', '2023-10-16 15:45:00', TRUE, 15),
('Naufragio de barco pesquero', '2023-10-16 13:30:00', FALSE, 16),
('Avalancha en pista de esquí', '2023-10-16 11:15:00', TRUE, 17),
('Ataque de abejas en escuela primaria', '2023-10-16 09:00:00', FALSE, 18),
('Rescate de perro atrapado en alcantarilla', '2023-10-16 06:45:00', TRUE, 19),
('Explosión en planta de gas natural', '2023-10-16 04:30:00', FALSE, 20),
('Tornado avistado al oeste de la ciudad','2023-10-16 02:15:00' ,TRUE ,1 ),
('Incendio en restaurante del centro','2023-10-16 01:15:00' ,FALSE ,15 ),
('Inundación por ruptura de presa','2023-10-16 01:05:00' ,TRUE ,12 ),
('Derrame de petróleo en el puerto','2023-10-16 01:01:30' ,FALSE ,20 ),
('Rescate de excursionistas perdidos','2023-10-16 01:01:01' ,TRUE ,1 );


----------------------------------------------------------------------------------------

----------------------------------------- task -----------------------------------------

INSERT INTO "task" ("name", "description", "id_task_status", "id_emergency") VALUES 
('Evacuación del área', 'Coordinar la evacuación segura de todas las personas en el área afectada.', 1, 1),
('Establecer perímetro de seguridad', 'Establecer un perímetro de seguridad alrededor del área afectada para evitar más daños.', 2, 2),
('Búsqueda y rescate', 'Buscar y rescatar a cualquier persona atrapada o herida en el área afectada.', 3, 3),
('Evaluación de daños', 'Evaluar la extensión de los daños causados por la emergencia.', 1, 4),
('Coordinación con servicios médicos', 'Coordinar con los servicios médicos para atender a las personas heridas.', 2, 5),
('Restauración de servicios básicos', 'Trabajar con las autoridades pertinentes para restaurar los servicios básicos en el área afectada.', 3, 6),
('Control de tráfico', 'Controlar el tráfico para permitir el paso de vehículos de emergencia.', 1, 7),
('Distribución de suministros', 'Distribuir suministros esenciales a las personas afectadas.', 2, 8),
('Reparación de infraestructuras', 'Reparar las infraestructuras dañadas por la emergencia.', 3, 9),
('Descontaminación del área', 'Descontaminar el área afectada por la emergencia.', 1, 10),
('Reconstrucción del área', 'Coordinar los esfuerzos de reconstrucción en el área afectada.', 2, 11),
('Asistencia psicológica', 'Proporcionar asistencia psicológica a las personas afectadas por la emergencia.', 3, 12),
('Investigación de la causa', 'Investigar la causa de la emergencia.', 1, 13),
('Educación a la comunidad', 'Educar a la comunidad sobre cómo responder a futuras emergencias.', 2, 14),
('Preparación para futuras emergencias', 'Prepararse para futuras emergencias similares.', 3, 15),
('Coordinación con medios de comunicación', 'Coordinar con los medios de comunicación para informar al público sobre la situación.', 1, 16),
('Recuperación de objetos perdidos', 'Recuperar y devolver objetos perdidos durante la emergencia.', 2, 17),
('Reubicación temporal de personas', 'Reubicar temporalmente a las personas desplazadas por la emergencia.', 3, 18),
('Control de plagas y enfermedades', 'Controlar cualquier plaga o enfermedad que pueda surgir debido a la emergencia.', 1, 19),
('Protección del medio ambiente', 'Tomar medidas para proteger el medio ambiente durante la respuesta a la emergencia.', 2, 20),
('Recogida y eliminación de escombros', 'Recoger y eliminar los escombros generados por la emergencia.', 3, 21),
('Restauración del suministro eléctrico', 'Restaurar el suministro eléctrico en el área afectada.', 1, 22),
('Restauración del suministro de agua', 'Restaurar el suministro de agua en el área afectada.', 2, 23),
('Restauración del servicio de telecomunicaciones', 'Restaurar el servicio de telecomunicaciones en el área afectada.', 3,24 ),
('Apoyo logístico', 'Proporcionar apoyo logístico para las operaciones de respuesta a la emergencia.',1 ,25 ),
('Apoyo financiero','Proporcionar apoyo financiero para las operaciones de respuesta a la emergencia.' ,2 ,1 ),
('Apoyo legal','Proporcionar apoyo legal para las operaciones de respuesta a la emergencia.' ,3 ,2 ),
('Apoyo administrativo','Proporcionar apoyo administrativo para las operaciones de respuesta a la emergencia.' ,1 ,3 ),
('Apoyo técnico','Proporcionar apoyo técnico para las operaciones de respuesta a la emergencia.' ,2 ,4 ),
('Apoyo operativo','Proporcionar apoyo operativo para las operaciones de respuesta a la emergencia.' ,3 ,5 );

----------------------------------------------------------------------------------------

---------------------------------------- ranking ---------------------------------------

INSERT INTO "ranking" ("score", "rut_voluntary", "id_task") VALUES 
(500, '12345678-9', 1),
(250, '23456789-0', 2),
(750, '34567890-1', 3),
(600, '45678901-2', 4),
(350, '56789012-3', 5),
(800, '12345678-9', 6),
(450, '23456789-0', 7),
(900, '34567890-1', 8),
(550, '45678901-2', 9),
(300, '56789012-3', 10),
(700, '12345678-9', 11),
(400, '23456789-0', 12),
(850, '34567890-1', 13),
(500, '45678901-2', 14),
(250, '56789012-3', 15),
(750, '12345678-9', 16),
(600, '23456789-0', 17),
(350, '34567890-1', 18),
(800, '45678901-2', 19),
(450, '56789012-3', 20),
(900, '12345678-9', 21),
(550, '23456789-0', 22),
(300, '34567890-1', 23),
(700, '45678901-2', 24),
(400, '56789012-3', 25),
(850, '12345678-9', 26),
(500, '23456789-0', 27),
(250, '34567890-1', 28),
(750, '45678901-2', 29),
(600, '56789012-3', 30);


----------------------------------------------------------------------------------------

-------------------------------------- requirement -------------------------------------

INSERT INTO "requirement" ("name", "description") VALUES 
('Capacitación en primeros auxilios', 'El voluntario debe tener una capacitación básica en primeros auxilios para poder atender a las personas heridas.'),
('Habilidades de liderazgo', 'El voluntario debe tener habilidades de liderazgo para poder coordinar a un equipo durante la respuesta a la emergencia.'),
('Licencia de conducir', 'El voluntario debe tener una licencia de conducir válida para poder operar vehículos de emergencia si es necesario.'),
('Habilidades de comunicación', 'El voluntario debe tener buenas habilidades de comunicación para poder interactuar eficazmente con las personas afectadas y con otros miembros del equipo de respuesta.'),
('Capacitación en gestión de desastres', 'El voluntario debe tener una capacitación en gestión de desastres para entender cómo responder eficazmente a diferentes tipos de emergencias.'),
('Habilidades de navegación', 'El voluntario debe tener habilidades de navegación para poder moverse eficazmente en áreas desconocidas o difíciles durante la respuesta a la emergencia.'),
('Capacitación en seguridad contra incendios', 'El voluntario debe tener una capacitación en seguridad contra incendios para poder responder eficazmente a las emergencias relacionadas con incendios.'),
('Habilidades de escalada', 'El voluntario debe tener habilidades de escalada para poder acceder a áreas difíciles durante la respuesta a la emergencia.'),
('Capacitación en rescate acuático', 'El voluntario debe tener una capacitación en rescate acuático para poder responder a las emergencias que ocurran en el agua.'),
('Habilidades de búsqueda y rescate', 'El voluntario debe tener habilidades de búsqueda y rescate para poder localizar y rescatar a las personas atrapadas o perdidas durante la emergencia.'),
('Capacitación en manejo de materiales peligrosos', 'El voluntario debe tener una capacitación en manejo de materiales peligrosos para poder manejar sustancias peligrosas de manera segura durante la respuesta a la emergencia.'),
('Habilidades mecánicas', 'El voluntario debe tener habilidades mecánicas para poder reparar o mantener el equipo utilizado durante la respuesta a la emergencia.'),
('Capacitación en soporte vital básico', 'El voluntario debe tener una capacitación en soporte vital básico para poder proporcionar atención médica básica durante la respuesta a la emergencia.'),
('Habilidades de organización', 'El voluntario debe tener habilidades de organización para poder coordinar eficazmente las tareas y recursos durante la respuesta a la emergencia.'),
('Capacitación en gestión del estrés', 'El voluntario debe tener una capacitación en gestión del estrés para poder manejar el estrés y mantener la calma durante la respuesta a la emergencia.'),
('Habilidades informáticas', 'El voluntario debe tener habilidades informáticas para poder utilizar eficazmente las herramientas y tecnologías digitales durante la respuesta a la emergencia.'),
('Capacitación en primeros auxilios psicológicos', 'El voluntario debe tener una capacitación en primeros auxilios psicológicos para poder proporcionar apoyo emocional a las personas afectadas durante la respuesta a la emergencia.'),
('Habilidades multilingües', 'El voluntario debe ser capaz de hablar varios idiomas para poder comunicarse eficazmente con personas que hablen diferentes idiomas durante la respuesta a la emergencia.'),
('Capacitación en logística de emergencias', 'El voluntario debe tener una capacitación en logística de emergencias para entender cómo gestionar y distribuir los recursos durante la respuesta a la emergencia.'),
('Habilidades de supervivencia', 'El voluntario debe tener habilidades de supervivencia para poder sobrevivir y ayudar a otros a sobrevivir en condiciones difíciles durante la respuesta a la emergencia.');


----------------------------------------------------------------------------------------

--------------------------------- voluntary_requirement --------------------------------

INSERT INTO "voluntary_requirement" ("rut_voluntary", "id_requirement") VALUES 
('12345678-9', 1),
('23456789-0', 2),
('34567890-1', 3),
('45678901-2', 4),
('56789012-3', 5),
('12345678-9', 6),
('23456789-0', 7),
('34567890-1', 8),
('45678901-2', 9),
('56789012-3', 10),
('12345678-9', 11),
('23456789-0', 12),
('34567890-1', 13),
('45678901-2', 14),
('56789012-3', 15),
('12345678-9', 16),
('23456789-0', 17),
('34567890-1', 18),
('45678901-2', 19),
('56789012-3', 20),
('12345678-9', 1),
('23456789-0', 2),
('34567890-1', 3),
('45678901-2', 4),
('56789012-3', 5),
('12345678-9', 6),
('23456789-0', 7),
('34567890-1', 8),
('45678901-2', 9),
('56789012-3', 10);


----------------------------------------------------------------------------------------

--------------------------------- emergency_requirement --------------------------------

INSERT INTO "emergency_requirement" ("id_emergency", "id_requirement") VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 1),
(22, 2),
(23, 3),
(24, 4),
(25, 5);


----------------------------------------------------------------------------------------

------------------------------------ task_requirement ----------------------------------

INSERT INTO "task_requirement" ("id_task", "id_requirement") VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 1),
(22, 2),
(23, 3),
(24, 4),
(25, 5),
(26, 6),
(27, 7),
(28, 8),
(29, 9),
(30, 10);


----------------------------------------------------------------------------------------
