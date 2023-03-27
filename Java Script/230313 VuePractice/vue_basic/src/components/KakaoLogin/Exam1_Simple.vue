<template>
  <div class="exam1_simple">
    <h3>Exam1_Simple.vue 출력</h3>
    <div>참고 사이트</div>
    <div>카카오 공식 api : <a href="https://archijude.tistory.com/425">https://archijude.tistory.com/425</a></div>
    <div>javascript로 구현 : <a href="https://tyrannocoding.tistory.com/49">https://tyrannocoding.tistory.com/49</a></div>
    <div>Vue.js 예제 소스코드 : <a href="https://archijude.tistory.com/425">https://archijude.tistory.com/425</a></div>
    <div>카카오 아이디 사용자 동의사항 해제 : <a href="https://accounts.kakao.com/weblogin/account/info">https://accounts.kakao.com/weblogin/account/info</a></div>

    <button @click="kakaoLogin()">kakaoLogin()</button> |
    <button @click="kakaoLogout()">kakaoLogout()</button>
    <div>Arrow function으로 안 하면 데이터 활용이 어렵다..! exam2 꼭 참고할 것</div>
  </div>
</template>

<script>
export default {
  name: "Exam1_Simple",
  data() {
    return {
    };
  },
  setup() {},
  created() {},
  mounted() {
    console.log("@@ mounted() 실행");
    // api 스크립트 소스 불러오기 및 지도 출력
    if (!window.Kakao) {
      this.loadKakaoScript();
    }
  },
  unmounted() {},
  methods: {
    loadKakaoScript() {
      // api 불러오기
      console.log("@@ loadKakaoScript() 실행");
      const script = document.createElement("script");
      script.src = "//developers.kakao.com/sdk/js/kakao.js";
      document.head.appendChild(script);
    },
    kakaoInit() {
      console.log("@@ kakaoInit() 실행");
      window.Kakao.init(process.env.VUE_APP_KAKAO_KEY_JAVASCRIPT); //발급받은 키 중 javascript키를 사용해준다.
      // sdk초기화여부판단
      if (window.Kakao.isInitialized() == true) {
        console.log("SDK 초기화 성공");
      }
    },
    kakaoLogin() {
      console.log("@@ kakaoLogin() 실행");
      if (window.Kakao.isInitialized() == false) {
        this.kakaoInit();
      }
      window.Kakao.Auth.login({
        success: function (response) {
          console.log(response); // access token 정보
          window.Kakao.API.request({
            url: '/v2/user/me',
            success: function (response) {
              console.log(response); // kakao 계정 정보
              console.log(response.kakao_account.email);
              console.log(response.kakao_account.profile.nickname);
            },
            fail: function (error) {
              console.log(error);
            },
          })
        },
        fail: function (error) {
          console.log(error);
        },
      })
    },
    kakaoLogout() {
      console.log("@@ kakaoLogout() 실행");
      if (window.Kakao.Auth.getAccessToken()) {
        window.Kakao.API.request({
          url: '/v1/user/unlink',
          success: function (response) {
            console.log(response); // logout되는 id
          },
          fail: function (error) {
            console.log(error);
          },
        })
        window.Kakao.Auth.setAccessToken(undefined)
      } else {
        console.log("@@ access token 없음");
      }
    }
  }
};
</script>

<style lang="scss">

</style>