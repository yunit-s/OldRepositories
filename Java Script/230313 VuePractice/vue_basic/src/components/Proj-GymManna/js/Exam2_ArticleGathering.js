export default {
  name: "Exam2_ArticleGathering",
  data() {
    return {
      // 지역변수
    };
  },
  methods: {
    func() {
      console.log("@@ func() 실행");
    },
    searchList() {
      console.log("@@ searchList() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/article/searchlist/a";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "POST",
        params: {
          centerName: "혜화 헬스장",
          articleGnum: 1
        },
        responseType: "json",
      })
        .then(function (result) {
          console.log("axios 성공");
          console.log(result);
        })
        .catch(function (error) {
          console.log("axios 실패");
          console.log(error);
        })
    },
    searchDetail() {
      console.log("@@ searchDetail() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/article/detail/a";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "POST",
        params: {
          articleGnum: 1
        },
        responseType: "json",
      })
        .then(function (result) {
          console.log("axios 성공");
          console.log(result);
        })
        .catch(function (error) {
          console.log("axios 실패");
          console.log(error);
        })
    },
  },
};