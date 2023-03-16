<template>
  <div class="exam1_axios">
    <h3>Exam1_Axios.vue 출력</h3>
    <button @click="simpleCall()">simpleCall()</button> |
    <button @click="getCall()">getCall()</button> |
    <button @click="postCall()">postCall()</button>
  </div>
</template>

<script>
export default {
  name: "Exam1_Axios",
  data() {
    return {
      // 지역변수
    };
  },
  methods: {
    simpleCall() {
      console.log("@@ simpleCall() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/article/photo";
      this.$axios
        .get(`http://${serverIP}:${serverPort}/${pageUrl}`)
        .then((res) => {
          console.log("axios 성공");
          console.log(res);
        })
        .catch((err) => {
          console.log("axios 실패");
          console.log(err);
        });
    },
    getCall() {
      console.log("@@ getCall() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/article/photo";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "GET",
        params: {
          // 인자
        },
        responseType: "json",
      })
        .then((result) => {
          console.log("axios 성공");
          console.log(result);
        })
        .catch((error) => {
          console.log("axios 실패");
          console.log(error);
        })
        .finally(() => {
          console.log("axios finally 실행");
        });
    },
    postCall() {
      console.log("@@ postCall() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/article/photopost";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "POST",
        params: {
          // 인자
        },
        responseType: "json",
      })
        .then(function(result) {
          console.log("axios 성공");
          console.log(result);
        })
        .catch(function(error) {
          console.log("axios 실패");
          console.log(error);
        })
        .finally(function() {
          console.log("axios finally 실행");
        });
    },
  },
};
</script>

<style lang="scss">
</style>