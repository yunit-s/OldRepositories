<template>
  <div class="parentcomp">
    <h1>부모 컴포넌트</h1>
    <div class="pcomp-body">
      <h2>선언적 방식으로 컴포넌트 전환</h2>
      <div>url 설정을 "부모path/자식path" 로 적으면 된다.</div>
      <router-link to="/subcomptest/parentcomp/childcomp1">라우터링크-ChildComp1</router-link> |
      <router-link to="/subcomptest/parentcomp/childcomp2">라우터링크-ChildComp2</router-link> |
      <router-link to="/subcomptest/parentcomp/childcomp3">라우터링크-ChildComp3</router-link> <br><br>
      <h2>프로그래밍 방식으로 컴포넌트 전환</h2>
      <button v-on:click="moveTo('1')">라우터링크-ChildComp1</button>
      <button @click="moveTo('2')">라우터링크-ChildComp2</button>
      <button @click="moveTo('3')">라우터링크-ChildComp3</button>

      <div class="pcomp-display">
        <router-view ref="childcomp1"/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ParentComp',
  methods: {
    moveTo (kind) {
      console.log('moveTo(' + kind + ')')
      this.$router.push(`/subcomptest/parentcomp/childcomp${kind}`).catch(() => {})
    }
  }
}
</script>
