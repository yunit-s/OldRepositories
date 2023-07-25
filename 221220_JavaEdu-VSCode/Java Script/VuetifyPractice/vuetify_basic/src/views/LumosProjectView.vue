<template>
  <div>

    <div  style="min-height: calc(100vh - 92px)">
      <router-view />
    </div>
    <div style="height: 92px">
      <footer-main />
    </div>

  </div>
</template>

<script>
// Components
import { defineComponent } from 'vue';
import FooterMain from '@/components/footer/FooterMain.vue';


export default defineComponent({
  components: {
    FooterMain,
  },

  data () {
    return {

    }
  },
});
</script>

<style scoped>

</style>