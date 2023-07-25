<template>
  <v-container>
    <h1>기본정보</h1>
    <p>아래는 내용 출력</p>
    
    <div>
      <button @click="getTestData">Get Data</button>
      {{ state.testData }}
    </div>
  </v-container>
</template>

<script>
import { reactive, watch } from "vue";
import axios from "axios";

export default {
  setup() {
    const state = reactive({
      center_num: "1",
      testData: null,
    });

    const getTestData = () => {
      axios
        .get(
          `http://localhost/kindergartendetail/${state.center_num}/information`
        )
        .then((response) => {
          state.testData = response.data;
          console.log(state.testData);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    watch(
      () => state.testData,
      (newVal, oldVal) => {
        console.log("testData changed: ", newVal, oldVal);
      }
    );

    return {
      state,
      getTestData,
      testData: state.testData,
    };
  },
};
</script>