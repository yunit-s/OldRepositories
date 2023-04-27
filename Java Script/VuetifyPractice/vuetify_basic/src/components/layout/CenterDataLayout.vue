<template>
  <div class="centerdatalayout">
    <v-card style="min-height: 350px">

      <v-tabs
        fixed-tabs
        v-model="tab"
        bg-color="yellow-lighten-4"
      >
        <v-tab :value="1">기본정보</v-tab>
        <v-tab :value="2">상세정보</v-tab>
        <v-tab :value="3">평가등급</v-tab>
        <v-tab :value="4">카페 리뷰 분석</v-tab>
        <v-tab :value="5">센터 현황</v-tab>
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
            <center-cafe-review />
          </v-container>

          <v-container fluid v-if="n === 5">
            <center-status />
          </v-container>
        </v-window-item>

      </v-window>

    </v-card>
  </div>
</template>

<script>
import CenterBasicInfo from '../body/CenterData/CenterBasicInfo.vue'
import CenterDetailInfo from '../body/CenterData/CenterDetailInfo.vue'
import CenterEvalGrade from '../body/CenterData/CenterEvalGrade.vue'
import CenterCafeReview from '../body/CenterData/CenterCafeReview.vue'
import CenterStatus from '../body/CenterData/CenterStatus.vue'

export default {
  name: 'CenterDataLayout',
  components: { CenterBasicInfo, CenterDetailInfo, CenterEvalGrade, CenterCafeReview, CenterStatus },
  data: () => ({
    tab: null,
  }),

}

</script>

<style scoped>

.centerdatalayout {
  background-color: honeydew;
  min-height: 350px;
}

</style>