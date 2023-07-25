<template>
  <v-container>
    <h1>Yunit 테스트 페이지</h1>
    <p>Lumos 프로젝트 관련 실험방</p>

    <v-btn @click="setSearchedCenterVuex()">set searchedCenterVuex</v-btn>
    <p>searchedCenterVuex : {{ searchedCenterVuex }}</p>
    <v-btn @click="printLog()">printLog</v-btn>
    <v-divider />
    <h2>지도에 마커 띄우기</h2>
    <v-btn @click="setMarkerPositionsVuex()">set markerPositionsVuex</v-btn>
    <p>markerPositionsVuex : {{ markerPositionsVuex }}</p>
  </v-container>
</template>

<script>

export default {
  computed: {
    searchedCenterVuex() {
      return this.$store.getters.getSearchedCenter;
    },
    markerPositionsVuex() {
      return this.$store.getters.getMarkerPositions;
    },
  },
  data() {
    return {

    }
  },
  methods: {
    setSearchedCenterVuex() {
      console.log("@@ setSearchedCenterVuex 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/center/1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          this.$store.dispatch('editSearchedCenter', response.data);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    printLog() {
      console.log(this.searchedCenterVuex);
      console.log(this.searchedCenterVuex[0], this.searchedCenterVuex[1]);
      console.log(this.searchedCenterVuex.centerName);
    },
    setMarkerPositionsVuex() {
      console.log("@@ setMarkerPositionsVuex 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/kidsdata_detail/1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          // markerPositionsVuex에 위경도 데이터 저장
          // const position = [response.data.centerDetailLatitude, response.data.centerDetailLongitude].map(Number);
          const position = [
            [37.5709602435767, 126.98144024815856],
            [37.572274074637356, 126.97098987226795]
          ];
          this.$store.dispatch('editMarkerPositions', position);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },

  }
}
</script>

<style scoped>

</style>