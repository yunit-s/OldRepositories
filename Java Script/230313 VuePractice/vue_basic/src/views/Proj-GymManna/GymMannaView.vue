<template>
  <div class="gymmanna">
    <h1>GYM만나 프로젝트 테스트</h1>
    <div class="gymmanna-body">
      <button v-on:click="moveTo('exam1_signin')">SignIn</button> |
      <button @click="moveTo('exam2_articlegathering')">ArticleGathering</button> |
      <!-- <button @click="moveTo('exam3_')">예제3</button> <br><br> -->

      <h1>자식 router-view</h1>
      <div class="gymmanna-child">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "GymMannaView", // 컴포넌트 이름 지정
  redirect: "/gymmanna/exam1_signin",
  data() {
    return {
      domain: "/gymmanna"
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
