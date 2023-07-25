<template>
  <v-container>

    <v-row>
      <v-col>
        <h1>Axios 테스트</h1>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-text-field v-model="text1" style="width: 200px;"></v-text-field>
        <v-btn @click="btnFunc1()">axios 호출 1</v-btn>
        text1 : {{ text1 }}
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-btn @click="axiosGetTest()">axiosGetTest</v-btn>
        <v-btn @click="axiosPutTest()">axiosPutTest</v-btn>
        <v-btn @click="axiosPostTest()">axiosPostTest</v-btn>
        <v-btn @click="axiosDeleteTest()">axiosDeleteTest</v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-btn @click="getCenterOne()">getCenterOne</v-btn>
        <v-btn @click="getChildcareEvalOne()">getChildcareEvalOne</v-btn>
        <v-btn @click="getChildcareViolationOne()">getChildcareViolationOne</v-btn>
        <v-btn @click="getKidsdataDetailOne()">getKidsdataDetailOne</v-btn>
      </v-col>
    </v-row>
    
    <v-row>
      <v-col>
        <h2>JSON 데이터 출력하기</h2>
        <p>jsonData.centerNum : {{ jsonData.centerNum }}</p>
        <p>jsonData : {{ jsonData }}</p>
      </v-col>
    </v-row>

    
  </v-container>
</template>

<script>

export default {
  data() {
    return {
      text1: "textfield",
      jsonData: ""
    }
  },
  methods: {
    btnFunc1() {
      console.log("@@ btnFunc1 실행");
      console.log(this.text1);
    },
    axiosGetTest() {
      console.log("@@ axiosGetTest 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/sample/list/` + this.text1
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    axiosPutTest() {
      console.log("@@ axiosPutTest 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .put(
          `${serverUrl}/sample/newsample`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    axiosPostTest() {
      console.log("@@ axiosPostTest 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .post(
          `${serverUrl}/sample/postmethod1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    axiosDeleteTest() {
      console.log("@@ axiosDeleteTest 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .delete(
          `${serverUrl}/sample/delmethod`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    getCenterOne() {
      console.log("@@ getCenterOne 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/center/1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          this.jsonData = response.data;
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    getChildcareEvalOne() {
      console.log("@@ getChildcareEvalOne 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/childcare_eval/1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          this.jsonData = response.data;
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    getChildcareViolationOne() {
      console.log("@@ getChildcareViolationOne 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/childcare_violation/14`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          this.jsonData = response.data;
        })
        .catch((error) => {
          console.log("@@@ axios 실패");
          console.log(error);
        });
    },
    getKidsdataDetailOne() {
      console.log("@@ getKidsdataDetailOne 실행");
      console.log(this.$axios);
      
      let serverUrl = process.env.VUE_APP_SERVER_URL;
      this.$axios
        .get(
          `${serverUrl}/searchMap/kidsdata_detail/1`
        )
        .then((response) => {
          console.log("@@@ axios 성공");
          console.log(response);
          this.jsonData = response.data;
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