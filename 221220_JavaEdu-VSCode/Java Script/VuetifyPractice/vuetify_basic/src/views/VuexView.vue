<template>
  <div>
    <v-row>
      <v-col>
        <h2>Vuex에 저장된 state 값 접근하기 1</h2>
        <p>counter: {{ counter }}</p>
        <v-btn @click="addCounter">addCounter</v-btn>
        <v-btn @click="subCounter">subCounter</v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <h2>Vuex에 저장된 state 값 접근하기 2</h2>
        <p>count: {{ count1 }}</p>
        <v-btn @click="incrementCount">Increment</v-btn>
        <v-btn @click="decrementCount">Decrement</v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <h2>Text field에 입력해서 count 값 바꾸기</h2>
        <p>두 버튼 모두 동일하게 동작함</p>
        <p>문자열도 입력 가능은 하다.</p>
        <v-text-field v-model="message" style="width: 150px;"></v-text-field>
        <v-btn @click="setVuexStateCount1">setVuexStateCount1</v-btn>
        <v-btn @click="setVuexStateCount2()">setVuexStateCount2</v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <h2>배열단위로 요소 여러 개 한 번에 다루기</h2>
        <p>한 번 vuex와 바인딩되면, text-field에 입력되는 문자열이 실시간으로 vuex에 전달되네</p>
        <p>strArr[0]: {{ strArr[0] }}</p>
        <p>strArr[1]: {{ strArr[1] }}</p>
        <p>strArr[2]: {{ strArr[2] }}</p>
        <v-text-field v-model="strArrData[0]" style="width: 150px;"></v-text-field>
        <v-text-field v-model="strArrData[1]" style="width: 150px;"></v-text-field>
        <v-text-field v-model="strArrData[2]" style="width: 150px;"></v-text-field>
        <v-btn @click="multipleParam">multipleParam</v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <h2>computed 말고 data에 Vuex 데이터 저장하고 불러오기</h2>
        <p>불가능한 듯...</p>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <h2>JSON 데이터 저장하고 출력하기</h2>
        <p>json 배열도 잘 되네</p>
        <p>jsonDataVuex : {{ jsonDataVuex }}</p>
        <v-btn @click="setJsonData">setJsonData</v-btn>
      </v-col>
    </v-row>
    <v-divider />

    <v-row>
      <v-col>
        <h2>Store 파일 모듈화하기</h2>
        <p>storeDivided.js 파일에 작성한 state 다루기</p>
        <p>Divided - count : {{ dividedCountVuex }}</p>
        <v-text-field v-model="dividedCount" style="width: 100px;" />
        <v-btn @click="setDividedCount()">setDividedCount</v-btn>
      </v-col>
    </v-row>

  </div>
</template>

<script>
// vuex 사용방법 1
import { mapActions, mapGetters } from "vuex";

export default {
  computed: {
    // vuex 변수 읽는 방법 1
    ...mapGetters(["counter"]),
    // vuex 변수 읽는 방법 2
    count1() {
      return this.$store.getters.getCount;
    },
    strArr() {
      return this.$store.getters.getStrArr;
    },
    jsonDataVuex() {
      return this.$store.getters.getJsonData;
    },
    dividedCountVuex() {
      return this.$store.state.storeDivided.dividedCount;
    },
  },
  data() {
    return {
      message: '',
      strArrData: [],
      jsonDataSample: [
        {
          0: "json 0번 데이터",
          1: "json 1번 데이터",
          2: "json 2번 데이터"
        },
        {
          3: "json 3번 데이터",
          4: "json 4번 데이터",
          5: "json 5번 데이터"
        },
        {
          6: "json 6번 데이터",
          7: "json 7번 데이터",
          8: "json 8번 데이터"
        },
      ],
      dividedCount: 12,
    };
  },
  methods: {
    // vuex 메서드 사용 방법 1
    ...mapActions(["addCounter", "subCounter"]),
    // vuex 메서드 사용 방법 2
    incrementCount() {
      this.$store.dispatch('addCount');
    },
    decrementCount() {
      this.$store.dispatch('subCount');
    },
    setVuexStateCount1() {
      this.$store.dispatch('setCount1', this.message);
    },
    setVuexStateCount2() {
      this.$store.dispatch('setCount2', this.message);
    },
    multipleParam() {
      this.$store.dispatch('multipleStatesSet', this.strArrData);
    },
    setJsonData() {
      this.$store.dispatch('setJsonData', this.jsonDataSample);
    },
    // 모듈화한 vuex 데이터 actions 호출
    // 특별한 것 없이 actions에 정의한 이름 호출하면 된다.
    setDividedCount() {
      this.$store.dispatch('setDividedCount', this.dividedCount);
    },
  }
}
</script>