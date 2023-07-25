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
      
    </v-container>
  </v-main>
</template>

<script>
// Components
import { defineComponent } from 'vue';
import MainContentsLayout from '@/components/layout/Home/HomeContentsLayout.vue';
import MainSideLayout from '@/components/layout/Home/HomeSideLayout.vue';
import CenterDataLayout from '@/components/layout/Home/HomeCenterDataLayout.vue';

export default defineComponent({
  components: { MainContentsLayout, MainSideLayout, CenterDataLayout },

  data () {
    return {

    }
  },
});
</script>

<style scoped>

</style>