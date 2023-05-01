<template>
  <div>
    <v-card style="height: 740px">

      <v-tabs
        fixed-tabs
        v-model="tab"
        bg-color="orange-lighten-4"
      >
        <v-tab :value="1">추천받기</v-tab>
        <v-tab :value="2">검색하기</v-tab>
      </v-tabs>

      <v-window v-model="tab">
        <v-window-item v-for="n in 2" :key="n" :value="n">

          <v-container fluid v-if="n === 1">
            <recommend-center-list />
          </v-container>

          <v-container fluid v-if="n === 2">
            <search-center-list />
          </v-container>
        </v-window-item>

      </v-window>

    </v-card>
  </div>
</template>

<script>
import RecommendCenterList from '@/components/body/HomeSide/RecommendCenterList.vue'
import SearchCenterList from '@/components/body/HomeSide/SearchCenterList.vue'

export default {
  components: { RecommendCenterList, SearchCenterList },
  data: () => ({
    tab: null,
  }),

}
</script>
