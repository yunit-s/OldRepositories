<template>
  <div class="parentcomp">
    <h1>부모 컴포넌트</h1>
    <div class="pcomp-body">
      <h3>선언적 방식으로 컴포넌트 전환</h3>
      <div>url 설정을 "부모path/자식path" 로 적으면 된다.</div>
      <router-link to="/subcomponent/parentcomp/childcomp1">라우터링크-ChildComp1</router-link> |
      <router-link to="/subcomponent/parentcomp/childcomp2">라우터링크-ChildComp2</router-link> |
      <router-link to="/subcomponent/parentcomp/childcomp3">라우터링크-ChildComp3</router-link> <br><br>
      <h3>프로그래밍 방식으로 컴포넌트 전환</h3>
      <button v-on:click="moveTo('1')">라우터링크-ChildComp1</button>
      <button @click="moveTo('2')">라우터링크-ChildComp2</button>
      <button @click="moveTo('3')">라우터링크-ChildComp3</button> <br><br>

      <h1>자식 router-view</h1>
      <div>외부에서 부모 컴포넌트에 새로 접근했을 때, 자식 router-view에 처음 뜨는 컴포넌트는 redirect를 활용해서 설정할 수 있다.</div>
      <div class="pcomp-display">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ParentCompView',
  methods: {
    moveTo (kind) {
      console.log('@@ moveTo(' + kind + ')')
      this.$router.push(`/subcomponent/parentcomp/childcomp${kind}`).catch(() => {})
    }
  }
}
</script>
