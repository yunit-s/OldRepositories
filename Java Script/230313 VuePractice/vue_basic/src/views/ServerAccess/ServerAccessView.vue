<template>
  <div class="serveraccess">
    <h1>서버 접속하기</h1>
    <div class="serveraccess-body">
      <router-link to="/serveraccess/exam1_axios"> <button>axios 테스트</button> </router-link> |
      <!-- <button v-on:click="moveTo('exam2_')"></button> | -->
      <!-- <button @click="moveTo('exam3_')">예제3</button> | -->
      <!-- <button @click="moveTo('exam4_')">예제4</button> <br><br> -->

      <h1>자식 router-view</h1>
      <div class="serveraccess-child">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ServerAccessView", // 컴포넌트 이름 지정
  data() {
    return {
      domain: '/serveraccess'
    };
  },
  methods: {
    // 뷰 컴포넌트 전환
    moveTo (page) {
      console.log('@@ moveTo(' + page + ')')
      this.$router.push(this.domain + `/${page}`).catch(() => {})
    }
  }
}
</script>

<style lang="scss">

</style>
