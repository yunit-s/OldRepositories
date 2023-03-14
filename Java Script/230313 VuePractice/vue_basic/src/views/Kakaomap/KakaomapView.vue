<template>
  <div class="kakaomap">
    <h1>카카오맵 API 활용하기</h1>
    <div class="kakaomap-body">
      <router-link to="/kakaomap/kakaomap/exam1_simple"> <button>단순 맵 출력1</button> </router-link> |
      <button v-on:click="moveTo('exam2_simple')">단순 맵 출력2</button> |
      <button @click="moveTo('exam3_marker')">마커 표시, 제거</button> |
      <button @click="moveTo('exam4_searchlist')">검색 목록 출력</button> <br><br>

      <h1>자식 router-view</h1>
      <div>외부에서 부모 컴포넌트에 새로 접근했을 때, 자식 router-view에 처음 뜨는 컴포넌트는 redirect를 활용해서 설정할 수 있다.</div>
      <div class="kakaomap-child">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "KakaomapView", // 컴포넌트 이름 지정
  methods: {
    // 뷰 컴포넌트 전환
    moveTo (page) {
      console.log('@@ moveTo(' + page + ')')
      this.$router.push(`/kakaomap/kakaomap/${page}`).catch(() => {})
    }
  }
}
</script>

<style lang="scss">

</style>
