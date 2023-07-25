<template>
  <v-container>
    <h1>상세정보</h1>
    <p>아래는 내용 출력</p>

    <div>
      유
      <button @click="getDetailData">Get DetailData</button>
      {{ state.testData }}
    </div>
    <div>sharethis</div>
    <div class="sharethis-inline-share-buttons">sd</div>
    <div id="app">
      <div class="kakao-share" @click="kakaoShare">카카오 공유하기</div>
    </div>

  </v-container>
</template>

<script>
import { reactive } from "vue";
import axios from "axios";

export default {
  setup() {
    const kakaoShare = () => {
      window.Kakao.Share.sendCustom({
        templateId: 92638,
        // 카카오톡이 설치 되지 않았을때 마켓으로 이동
        installTalk: true,
      });
    };

    const state = reactive({
      center_num: "1",
      testData: null,
    });

    const getDetailData = () => {
      axios
        .get(`http://localhost/kindergartendetail/${state.center_num}/detail`)
        .then((response) => {
          state.testData = response.data;
          console.log(state.testData);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    return {
      kakaoShare,
      state,
      getDetailData,
      testData: state.testData,
    };
  },
};
</script>

<style scored>
* {
  margin: 0;
  padding: 0;
}

.sharethis-inline-share-buttons {
  line-height: 50px;
  font-size: 12px;
  margin-top: auto;
}

.kakao-share {
  width: 150px;
  height: 40px;
  line-height: 50px;
  color: black;
  text-align: center;
  background: #ffe812;
  font-size: 12px;
  cursor: pointer;
}
</style>
