<template>
  <div class="vuex">
    <h1>Vuex 테스트</h1>
    <div class="vuex-body">
      <button v-on:click="moveTo('exam1_actions')">Exam1</button> |
      <button @click="moveTo('exam2_getters')">Exam2</button> |
      <!-- <button @click="moveTo('exam3_')">예제3</button> <br><br> -->

      <h1>자식 router-view</h1>
      <div class="vuex-child">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "VuexView", // 컴포넌트 이름 지정
  data() {
    return {
      domain: "/Vuex"
    };
  },
  methods: {
    // 뷰 컴포넌트 전환
    moveTo (page) {
      console.log("@@ moveTo(" + page + ")")
      this.$router.push(this.domain + `/${page}`).catch(() => {})
    }
  }
}
</script>

<style lang="scss">

</style>
