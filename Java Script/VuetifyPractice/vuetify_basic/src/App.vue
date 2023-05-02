<template>
  <v-app>

    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/dividelayoutview">Divide</router-link> |
      <router-link to="/tabview">Tab</router-link> |
      <router-link to="/lumosprojectview">Lumos</router-link> |
      <router-link to="/vuexview">Vuex</router-link> |
      <router-link to="/lifecycleview">Lifecycle</router-link> |
    </nav>
    <router-view />
    
  </v-app>
</template>

<script>

export default {
  name: 'App',

}
</script>

<style lang="scss">

nav {
  text-align: center;
  // padding: 10px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

</style>