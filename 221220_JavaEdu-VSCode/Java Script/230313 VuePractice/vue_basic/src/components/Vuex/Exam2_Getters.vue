<template>
  <div class="exam2_getters">
    <h3>Exam2_Getters.vue 출력</h3>
    <div>참고 사이트 : <a href="https://simplevue.gitbook.io/intro/16.-vuex">https://simplevue.gitbook.io/intro/16.-vuex</a></div>
    <div>getters는 computed: 안에서 활용해야 한다.</div>
    <button @click="addCounter()">addCounter()</button> |
    <button @click="subCounter()">subCounter()</button>
    <div>value: {{ counter }}</div>

  </div>
</template>

<script>
import { mapActions } from "vuex";
import { mapGetters } from "vuex";

export default {
  name: "Exam2_Getters",
  data() {
    return {
    };
  },
  setup() {},
  created() {},
  mounted() {
    console.log("@@ mounted() 실행");
  },
  unmounted() {},
  computed: {
    ...mapGetters(["counter"])
  },
  methods: {
    func() {
      console.log("@@ func() 실행");
    },
    ...mapActions(["addCounter", "subCounter"]),
  },
};
</script>

<style lang="scss">
</style>