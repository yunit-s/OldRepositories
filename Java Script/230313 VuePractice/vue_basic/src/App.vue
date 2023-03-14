<template>
  <div class="rootvue">
    <v-header/>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/comp1">comp1</router-link> |
      <router-link to="/comp2">comp2</router-link> |
      <router-link to="/subcomponent/parentcomp">SubComponent</router-link> |
      <router-link to="/kakaomap/kakaomap">Kakaomap</router-link>
    </nav>
    <router-view/>
    <v-footer/>
  </div>
</template>

<script>
import VHeader from "./components/layout/VHeader.vue";
import VFooter from "./components/layout/VFooter.vue";

export default {
  name: "App",
  components: {
    VHeader,
    VFooter
  }
}
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
