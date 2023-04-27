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
        <v-col>
          <center-data-layout />
        </v-col>
      </v-row>
      
      <v-row>
        <v-col>
          <footer-layout />
        </v-col>
      </v-row>
    </v-container>
  </v-main>
</template>

<script>
// Components
import { defineComponent } from 'vue';
import MainContentsLayout from '@/components/layout/MainContentsLayout.vue';
import MainSideLayout from '@/components/layout/MainSideLayout.vue';
import CenterDataLayout from '@/components/layout/CenterDataLayout.vue';
import FooterLayout from '@/components/layout/FooterLayout.vue';

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