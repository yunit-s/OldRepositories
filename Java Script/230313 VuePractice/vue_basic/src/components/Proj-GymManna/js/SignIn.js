export default {
  name: "SignIn",
  data() {
    return {
      // 지역변수
      id: "",
      pw: "",
      name: "",
      phone: "",
      nickname: "",
    };
  },
  methods: {
    func() {
      console.log("@@ func() 실행");
    },
    login() {
      console.log("@@ login() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/user/login";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "GET",
        params: {
          userId: this.id,
          userPw: "1234"
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
    },
    register() {
      console.log("@@ register() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/user/register";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "POST",
        params: {
          userId: this.id,
          userPassword: this.pw,
          userName: this.name,
          userPhone: this.phone,
          userNickname: this.nickname,
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
    },


    update() {
      console.log("@@ update() 실행");
      var serverIP = process.env.VUE_APP_SERVER_IP,
        serverPort = process.env.VUE_APP_SERVER_PORT,
        pageUrl = "mygym/user/update";
      this.$axios({
        url: `http://${serverIP}:${serverPort}/${pageUrl}`,
        method: "POST",
        params: {
          userId: "jjjjj",
          userPw: "1234"
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
    },

  },
};