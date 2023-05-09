<template>
  <div>
    <h1>위치 설정하기</h1>

    <v-text-field v-model="baseCenterNum" style="width: 80px;"></v-text-field>
    <v-btn @click="searchCenters()">센터데이터가져오기</v-btn>
    <br><br>
    <v-divider></v-divider>
    <br>
    <v-divider></v-divider>

    <div v-for="searchedCenter in searchedCentersVuex"
      :key="searchedCenter.centerNum"
      @click="displayClickedCenterDetail(searchedCenter)">
      <h2>{{ searchedCenter.centerName }}</h2>
      <p>
        cNum:{{ searchedCenter.centerNum }} / 
        공석:{{ searchedCenter.centerDetailRegularperson - searchedCenter.centerDetailCurrentperson }} / 
        차량:{{ searchedCenter.centerDetailVehicle }} / 
        연장:{{ searchedCenter.centerExtendcare }} / 

      </p>
      <v-divider />
    </div>

    <h3></h3>

  </div>
</template>

<script>

export default {
  data() {
    return {
      baseCenterNum: 99,
    };
  },
  computed: {
    searchedCentersVuex() {
      console.log("@@@ Recomm-computed-searchedCenters 실행");
      return this.$store.getters.getSearchedCenters;
    },

  },
  methods: {
    searchCenters() {
      console.log("@@ searchCenters 실행");

      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/center/list/${this.baseCenterNum}`
        )
        .then((response) => {
          console.log("@@@ axios 성공", response);
          this.$store.dispatch('setSearchedCenters', response.data);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    displayClickedCenterDetail(searchedCenter) {
      console.log("@@ displayClickedCenterDetail 실행");
      this.$store.dispatch('setClickedCenter', searchedCenter);
    }
  }
}
</script>
