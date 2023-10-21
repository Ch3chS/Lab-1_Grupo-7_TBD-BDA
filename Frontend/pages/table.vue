<template>
    <div>
      <table>
        <thead>
          <tr>
            <th>Emergencia</th>
            <th>Tarea</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="emergency in emergencies" :key="emergency.id_emergency">
            <td @click="selectedEmergency = emergency.id_emergency">{{ emergency.description }}</td>
            <td v-if="selectedEmergency === emergency.id_emergency">
              <table>
                <tr v-for="task in tasks[selectedEmergency]" :key="task.id">
                  <td>{{ task.name }}</td>
                </tr>
              </table>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  
  export default {
    data() {
      return {
        emergencies: [],
        tasks: {},
        selectedEmergency: null
      }
    },
    methods: {
      async getEmergencies() {
        try {
          const response = await axios.get('/api/emergencies')
          this.emergencies = response.data
          for (const emergency of this.emergencies) {
            await this.getTasks(emergency.id_emergency)
          }
        } catch (error) {
          console.error(error)
        }
      },
      async getTasks(id_emergency) {
        try {
          const response = await axios.get(`/api/tasks/byEmergency/${id_emergency}`)
          this.$set(this.tasks, id_emergency, response.data)
        } catch (error) {
          console.error(error)
        }
      }
    },
    mounted() {
      this.getEmergencies()
    }
  }
  </script>
  
  <style scoped>
  table {
    width: 100%;
    border-collapse: collapse;
  }
  
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
  }
  
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
  
  th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
  }
  </style>
  