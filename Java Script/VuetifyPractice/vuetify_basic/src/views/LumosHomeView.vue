<template>
  <v-main class="mainlayout">
    <v-container>
      <v-row>
        <v-col cols="8">
          <main-contents-layout />
        </v-col>
        <v-col cols="4">
          <main-side-layout />
        </v-col>
      </v-row>

      <v-row>
        <center-data-layout />
      </v-row>
      
      <v-row>
        <footer-layout />
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
// Components
import { defineComponent } from 'vue';
import MainContentsLayout from '@/components/frame/MainContentsLayout.vue';
import MainSideLayout from '@/components/frame/MainSideLayout.vue';
import CenterDataLayout from '@/components/frame/CenterDataLayout.vue';
import FooterLayout from '@/components/frame/FooterLayout.vue';

export default defineComponent({
  // components: { MainContentsLayout },
  components: { MainContentsLayout, MainSideLayout, CenterDataLayout, FooterLayout },
  name: 'LumosHomeView',

  data () {
    return {

    }
  },
});
</script>

<style scoped>

</style>