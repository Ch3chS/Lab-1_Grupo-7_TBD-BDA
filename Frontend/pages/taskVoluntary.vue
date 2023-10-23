<template>
  <div class="task-voluntary">
    <h1><b>Tareas disponibles para voluntarios</b></h1>
    <table class="task-table">
      <thead>
      <tr>
        <th>Nombre de la tarea</th>
        <th>Descripción de la tarea</th>
        <th>Acepta tarea</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="task in tasks" :key="task.id_task">
        <td>{{ task.name }}</td>
        <td>{{ task.description }}</td>
        <td>
          <button @click="acceptTask(task.id_task)">Aceptar</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: 'TaskVoluntary',
  data() {
    return {
      tasks: [] // Inicialmente, la lista de tareas estará vacía
    };
  },
  async asyncData({ params }) {
    const voluntaryRut = params.voluntaryRut;
    let tasks = [];

    if (process.client) {
      const voluntaryRut = this.getCookie('voluntaryRut');
      if (voluntaryRut) {
        tasks = await this.loadTasks(voluntaryRut);
      }
    }

    return { tasks };
  },
  methods: {
    async loadTasks(voluntaryRut) {
      try {
        const response = await fetch(`/api/availableTasksForVoluntary/${voluntaryRut}`);
        if (response.ok) {
          return await response.json();
        } else {
          console.error('Error al cargar las tareas');
          return [];
        }
      } catch (error) {
        console.error('Error al cargar las tareas:', error);
        return [];
      }
    },
    getCookie(name) {
      if (process.client) {
        const value = `; ${document.cookie}`;
        const parts = value.split(`; ${name}=`);
        if (parts.length === 2) {
          return parts.pop().split(';').shift();
        }
      }
      return null;
    },
    acceptTask(taskId) {
      // Aquí puedes agregar la lógica para aceptar la tarea con el taskId proporcionado
      // Por ejemplo, puedes realizar una solicitud a la API para aceptar la tarea.
      // Después de aceptar la tarea, puedes actualizar la lista de tareas si es necesario.
    }
  }
};
</script>

<style scoped>
.task-voluntary {
  background: #262626;
  font-family: sans-serif;
  padding: 16px;
}

h1 {
  text-align: center;
  color: white;
  font-size: 24px;
  margin-bottom: 16px;
}

.task-table {
  width: 100%;
  border-collapse: collapse;
}

thead {
  background-color: #009879;
  color: white;
}

thead th {
  padding: 10px;
}

tbody {
  background-color: #fff;
}

tr:hover {
  background: #e84393;
  color: #fff;
}

td {
  padding: 10px;
  text-align: center;
}

button {
  background-color: #007BFF;
  color: white;
  border: none;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}
</style>
