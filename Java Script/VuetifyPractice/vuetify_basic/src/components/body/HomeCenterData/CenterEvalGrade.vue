<template>
  <v-container>
    <h1>평가등급</h1>
    <p>아래는 내용 출력</p>
    
    <div>
      유
      <button @click="getGradeData">Get GradeData</button>
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
      center_num: "12",
      testData: null,
    });

    const getGradeData = () => {
      axios
        .get(`http://localhost/kindergartendetail/${state.center_num}/grade`)
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
      getGradeData,
      testData: state.testData,
    };
  },
};
</script>