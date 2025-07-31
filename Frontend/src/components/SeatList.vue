<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const seats = ref([])

const fetchSeats = async () => {
  try {
    const res = await axios.get('http://localhost:8080/api/seats/all')
    seats.value = res.data
  } catch (error) {
    console.error('取得座位資料失敗:', error)
  }
}

onMounted(() => {
  fetchSeats()
})
</script>

<template>
  <div>
    <h2>座位列表</h2>
    <ul>
      <li v-for="seat in seats" :key="seat.id">
        座位ID: {{ seat.id }}, 樓層: {{ seat.floor }}, 座號: {{ seat.seatNumber }}, 員工ID: {{ seat.employeeId || '空位' }}
      </li>
    </ul>
  </div>
</template>

<style scoped>
ul {
  list-style: none;
  padding: 0;
}
</style>

