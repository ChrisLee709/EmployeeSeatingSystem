<template>
  <div>
    <h2>員工座位列表</h2>
    <ul>
      <li v-for="emp in employees" :key="emp.id">
        {{ emp.employeeId }} - {{ emp.name }} - {{ emp.seatNumber }}
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const employees = ref([])

onMounted(async () => {
  const res = await axios.get('http://localhost:8080/api/employees')
  employees.value = res.data
})
</script>
