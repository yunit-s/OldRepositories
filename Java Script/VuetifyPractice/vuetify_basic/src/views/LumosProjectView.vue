<template>
  <div>

    <router-view />
    <footer-layout />
    
  </div>
</template>

<script>
// Components
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'LumosProjectView',
  components: { FooterLayout },

  data () {
    return {

    }
  },
});
</script>

<style scoped>

</style>