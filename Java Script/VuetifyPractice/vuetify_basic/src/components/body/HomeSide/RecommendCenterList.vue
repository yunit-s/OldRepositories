<template>
  <div>
    <h1>위치 설정하기</h1>

    <v-text-field v-model="targetCenterNum" style="width: 80px;"></v-text-field>
    <v-btn @click="getSearchedCentersVuex()">센터데이터가져오기</v-btn>
    <br><br>
    <v-divider></v-divider>
    <br>
    <v-divider></v-divider>

    <div v-for="searchedCenter in searchedCentersVuex" :key="searchedCenter.centerNum">
      <h2>{{ searchedCenter.centerDetailPhone }}</h2>
      <p>센터 번호 : {{ searchedCenter.centerNum }}</p>
      <v-divider />
    </div>

  </div>
</template>

<script>

export default {
  data() {
    return {
      targetCenterNum: 99,
    };
  },
  computed: {
    searchedCentersVuex() {
      console.log("@@@ Recomm-computed-searchedCenters 실행");
      return this.$store.getters.getSearchedCenters;
    }
  },
  methods: {
    getSearchedCentersVuex() {
      console.log("@@ getSearchedCentersVuex 실행");

      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/kidsdata_detail/list/${this.targetCenterNum}`
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
  }
}
</script>
