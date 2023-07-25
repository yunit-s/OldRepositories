<template>
  <v-container>
    <h1>카페 리뷰 분석</h1>
    <p>아래는 리뷰 내용 출력</p>

    <div>
      유
      <button @click="callFlaskApp">Call Flask App</button>
    </div>
    <v-col cols="12">
      <v-btn @click="getData">유치원 데이터 가져오기</v-btn>
    </v-col>
    <v-row v-if="data.kinderInfo">
      <v-col cols="12">
        <ul v-if="data.kinderInfo.length > 0">
          <li>주소: {{ data.kinderInfo[0].addr }}</li>
          <li>3년제학급수: {{ data.kinderInfo[0].clcnt3 }}</li>
          <li>4년제학급수: {{ data.kinderInfo[0].clcnt4 }}</li>
          <li>5년제학급수: {{ data.kinderInfo[0].clcnt5 }}</li>
          <li>설립일자: {{ data.kinderInfo[0].edate }}</li>
          <li>설립유형: {{ data.kinderInfo[0].establish }}</li>
          <li>전화번호: {{ data.kinderInfo[0].telno }}</li>
          <li>홈페이지 주소: {{ data.kinderInfo[0].hpaddr }}</li>
          <li>교육청명: {{ data.kinderInfo[0].officeedu }}</li>
          <li>운영시간: {{ data.kinderInfo[0].opertime }}</li>
          <li>공학시간: {{ data.kinderInfo[0].pbnttmng }}</li>
          <li>3세급수: {{ data.kinderInfo[0].ppcnt3 }}</li>
          <li>4세급수: {{ data.kinderInfo[0].ppcnt4 }}</li>
          <li>5세급수: {{ data.kinderInfo[0].ppcnt5 }}</li>
          <li>혼합급수: {{ data.kinderInfo[0].mixclcnt }}</li>
          <li>혼합인원수: {{ data.kinderInfo[0].mixppcnt }}</li>
          <li>개원일자: {{ data.kinderInfo[0].odate }}</li>
          <li>소재지 우편번호: {{ data.kinderInfo[0].rppnname }}</li>
          <li>어린이보호구역내 학교여부: {{ data.kinderInfo[0].shclcnt }}</li>
          <li>어린이보호구역내 유치원여부: {{ data.kinderInfo[0].shppcnt }}</li>
          <li>교육지원청명: {{ data.kinderInfo[0].subofficeedu }}</li>
        </ul>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import { reactive } from "vue";

export default {
  setup() {
    const data = reactive({
      kinderInfo: [],
      response: "",
    });

    async function callFlaskApp() {
      try {
        const response = await fetch("http://localhost:5000/similarity", {
          method: "POST",
        });
        const responseData = await response.json();
        data.response = responseData;
        console.log(responseData);
      } catch (error) {
        console.error(error);
      }
    }

    const getData = () => {
      axios
        .get(
          "/api?key=" +
            process.env.VUE_APP_KINDERGARTEN_API_KEY +
            "&sidoCode=27&sggCode=27140"
        )
        .then((response) => {
          data.kinderInfo = response.data.kinderInfo;
          console.log("됨");
          console.log(response.data.kinderInfo);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    return { data, getData, callFlaskApp };
  },
};
</script>

<style scoped>

</style>