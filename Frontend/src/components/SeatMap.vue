<template>
  <div class="container">
    <h1>座位列表</h1>
    <div class="seat-grid">
      <div
        v-for="seat in seats"
        :key="seat.id"
        :class="['seat', seat.status]"
        @click="toggleSeat(seat)"
      >
        {{ seat.floor }}樓：座位{{ seat.number }}
      </div>
    </div>

    <div class="legend">
      <div><span class="box empty"></span> 空位</div>
      <div><span class="box occupied"></span> 已佔用</div>
      <div><span class="box selected"></span> 請選擇</div>
    </div>

    <button class="submit-btn">送出</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      seats: [],
      selectedSeats: null
    }
  },
  mounted() {
    // 模擬資料（4樓、每層4座位，共16個）
    for (let floor = 1; floor <= 4; floor++) {
      for (let number = 1; number <= 4; number++) {
        this.seats.push({
          id: `${floor}-${number}`,
          floor,
          number,
          status: 'empty' // 'empty' | 'occupied' | 'selected'
        })
      }
    }

    // 假設某些座位被佔用
    this.seats[2].status = 'occupied'
    this.seats[6].status = 'occupied'
    this.seats[8].status = 'occupied'
    this.seats[9].status = 'occupied'
    this.seats[11].status = 'occupied'
    this.seats[14].status = 'occupied'
  },
  methods: {
    toggleSeat(seat) {
  if (seat.status === 'occupied') return

  // 如果已經有選取的座位，並且不是目前點擊的座位，則取消之前的選取狀態
  if (this.selectedSeatId && this.selectedSeatId !== seat.id) {
    const previouslySelectedSeat = this.seats.find(s => s.id === this.selectedSeatId)
    if (previouslySelectedSeat) {
      previouslySelectedSeat.status = 'empty'
    }
  }

  // 切換目前點擊座位的狀態
  if (seat.status === 'selected') {
    seat.status = 'empty'
    this.selectedSeatId = null // 沒有座位被選取
  } else {
    seat.status = 'selected'
    this.selectedSeatId = seat.id // 設定目前座位為已選取
  }
}
  }
}
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 0 auto;
  font-family: sans-serif;
  text-align: center;
}

.seat-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 10px;
  margin-top: 20px;
}

.seat {
  border: 1px solid #ccc;
  padding: 15px;
  border-radius: 8px;
  cursor: pointer;
}

.seat.empty {
  background-color: white;
}

.seat.occupied {
  background-color: #ff4d4d;
  color: white;
  cursor: not-allowed;
}

.seat.selected {
  background-color: #b2f2bb;
}

.legend {
  margin-top: 30px;
  text-align: left;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.box {
  display: inline-block;
  width: 20px;
  height: 20px;
  margin-right: 8px;
  vertical-align: middle;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.box.empty {
  background-color: white;
}

.box.occupied {
  background-color: #ff4d4d;
}

.box.selected {
  background-color: #b2f2bb;
}

.submit-btn {
  margin-top: 30px;
  padding: 10px 30px;
  background-color: #007bff;
  color: white;
  font-weight: bold;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  float: left
}

.submit-btn:hover {
  background-color: #0056b3;
}
</style>
