<template>
  <div>
    <h1>위치 설정하기</h1>

    <v-row>
      <v-col cols="9">
        <v-text-field v-model="searchingKeyword"></v-text-field>
      </v-col>
      <v-col cols="3">
        <v-btn @click="searchCenters()" icon="mdi-magnify"></v-btn>
      </v-col>
    </v-row>
    
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

  </div>
</template>

<script>

export default {
  data() {
    return {
      searchingKeyword: "혜화",
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
          // `${serverUrl}/searchMap/center/list/${this.baseCenterNum}`
          `${serverUrl}/searchMap/center/list/name/${this.searchingKeyword}`
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
