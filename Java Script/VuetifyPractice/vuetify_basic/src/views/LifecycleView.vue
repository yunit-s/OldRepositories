<template>
  <v-container>

    <div>
      <h1>라이프 사이클 테스트</h1>
    </div>

    <div>
      <h2>setup</h2>
      <p>: Vue 3에서 도입된 속성으로, 컴포넌트 인스턴스 생성 이전에 호출됩니다. 주로 reactive 함수를 사용하여 상태 관리를 처리합니다.</p>
      <p>* methods 사용 불가</p>
    </div>

    <div>
      <h2>created</h2>
      <p>: Vue 인스턴스가 생성된 후, DOM과 연결되기 전에 호출됩니다. 데이터, 컴포넌트의 감시자(watcher), 이벤트 리스너 등을 설정할 수 있습니다.</p>
      <p>* methods 사용 가능</p>
      <p>* data 사용 불가</p>
      <p>* vuex 사용 가능</p>
    </div>

    <div>
      <h2>mounted</h2>
      <p>: Vue 인스턴스가 DOM에 마운트된 직후에 호출됩니다. DOM을 조작하거나 외부 라이브러리와 연동하는 등의 작업을 수행할 수 있습니다.</p>
      <p>* methods 사용 가능</p>
      <p>* data 사용 가능</p>
      <p>* vuex 사용 가능</p>
    </div>

    <div>
      <h2>unmounted</h2>
      <p>: Vue 인스턴스가 DOM에서 언마운트된 직후에 호출됩니다. 이벤트 리스너 등의 리소스를 정리하는 작업을 수행할 수 있습니다.</p>
      <p>router에 의해 페이지 변경될 때도 호출됨</p>
    </div>

    
  </v-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";

export default {
  data() {
    return {
      str1: "string data"
    };
  },
  setup() {
    console.log("@@ setup 실행");
    // this.func(); // 실행 불가
  },
  created() {
    console.log("@@ created 실행");
    this.func(); // 실행 가능
    // this.printData(); // 실행 불가
    this.printVuexState(); // 실행 가능
  },
  mounted() {
    console.log("@@ mounted 실행");
    this.func(); // 실행 가능
    this.printData(); // 실행 가능
    this.printVuexState(); // 실행 가능
  },
  unmounted() {
    console.log("@@ unmounted 실행");
    this.func(); // 실행 가능
    this.printData(); // 실행 가능
    this.printVuexState(); // 실행 가능
  },
  computed: {
    ...mapGetters(["counter"])
  },
  methods: {
    func() {
      console.log("@@ func 실행");
    },
    printData() {
      console.log("@@ printData 실행 : " + this.str1);
    },
    printVuexState() {
      console.log("@@ printVuexState 실행 : " + this.$store.getters.getCount);
    },
    ...mapActions(["addCounter", "subCounter"])
  },
}
</script>

<style scoped>

</style>