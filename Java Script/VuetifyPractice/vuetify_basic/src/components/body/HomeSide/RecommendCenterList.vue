<template>
  <div>
    <h1>위치 설정하기</h1>
    <v-btn @click="setMarkerPositionsVuex(0)">세트0</v-btn>
    <v-btn @click="getKidsdataDetailList()">데이터가져오기</v-btn>
    <v-divider></v-divider>
    <h2>추천 리스트 1</h2>
    <p>내용</p>
    <v-divider></v-divider>
    <h2>추천 리스트 1</h2>
    <p>내용</p>
    <v-divider></v-divider>
    <p>markerPositionsVuex : {{ markerPositionsVuex }}</p>
  </div>
</template>

<script>

export default {
  data() {
    return {
      
      }
  },
  computed: {
    markerPositionsVuex() {
      console.log("@@@ Recomm computed 실행");
      return this.$store.getters.getMarkerPositions;
    },
  },
  methods: {
    
    setMarkerPositionsVuex(num) {
      console.log("@@ setMarkerPositionsVuex 실행");
      console.log(this.$axios);
      console.log(num);
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/kidsdata_detail/list/1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          console.log(response.data.length);
          // markerPositionsVuex에 위경도 데이터 저장
          // const position = [response.data.centerDetailLatitude, response.data.centerDetailLongitude].map(Number);
          let positions = [];
          for (let i = 0; i < response.data.length; i++) {
            positions.push([response.data[i].centerDetailLatitude, response.data[i].centerDetailLongitude])
          }
          console.log(positions);
          this.$store.dispatch('setMarkerPositions', positions);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    getKidsdataDetailList() {
      console.log("@@ getKidsdataDetailList 실행");

      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/kidsdata_detail/list/3`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          console.log(response.data.length);
          // markerPositionsVuex에 위경도 데이터 저장
          let positions = [];
          for (let i = 0; i < response.data.length; i++) {
            positions.push([response.data[i].centerDetailLatitude, response.data[i].centerDetailLongitude])
          }
          console.log(positions);
          this.$store.dispatch('setMarkerPositions', positions);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    }
  }
}
</script>
