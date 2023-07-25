<template>
  <div class="kakaologin">
    <h1>카카오 로그인</h1>
    <div class="kakaologin-body">
      <router-link to="exam1_simple"> <button>exam1_simple</button> </router-link> |
      <button v-on:click="moveTo('exam2_arrowfunction')">exam2_arrowfunction</button> |
      <!-- <button @click="moveTo('exam3_')">예제3</button> | -->
      <!-- <button @click="moveTo('exam4_')">예제4</button> <br><br> -->

      <h1>자식 router-view</h1>
      <div class="kakaologin-child">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "KakaoLoginView", // 컴포넌트 이름 지정
  data() {
    return {
      domain: '/kakaologin'
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
