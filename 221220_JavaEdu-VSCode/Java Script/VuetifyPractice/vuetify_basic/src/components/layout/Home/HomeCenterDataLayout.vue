<template>
  <div>
    <v-card style="min-height: 350px">

      <v-tabs
        fixed-tabs
        v-model="tab"
        bg-color="yellow-lighten-4"
      >
        <v-tab :value="1">기본정보</v-tab>
        <v-tab :value="2">상세정보</v-tab>
        <v-tab :value="3">평가등급</v-tab>
        <v-tab :value="4">리뷰 분석</v-tab>
        <v-tab :value="5">센터 상태그래프</v-tab>
      </v-tabs>

      <v-window v-model="tab">
        <v-window-item v-for="n in 5" :key="n" :value="n">

          <v-container fluid v-if="n === 1">
            <center-basic-info />
          </v-container>

          <v-container fluid v-if="n === 2">
            <center-detail-info />
          </v-container>

          <v-container fluid v-if="n === 3">
            <center-eval-grade />
          </v-container>

          <v-container fluid v-if="n === 4">
            <center-review-data />
          </v-container>

          <v-container fluid v-if="n === 5">
            <center-status-graph />
          </v-container>
        </v-window-item>

      </v-window>

    </v-card>
  </div>
</template>

<script>
import CenterBasicInfo from '@/components/body/HomeCenterData/CenterBasicInfo.vue'
import CenterDetailInfo from '@/components/body/HomeCenterData/CenterDetailInfo.vue'
import CenterEvalGrade from '@/components/body/HomeCenterData/CenterEvalGrade.vue'
import CenterReviewData from '@/components/body/HomeCenterData/CenterReviewData.vue'
import CenterStatusGraph from '@/components/body/HomeCenterData/CenterStatusGraph.vue'

export default {
  components: {CenterBasicInfo, CenterDetailInfo, CenterEvalGrade, CenterReviewData, CenterStatusGraph},
  data: () => ({
    tab: null,
  }),

}
</script>
