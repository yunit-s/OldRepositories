<template>
  <v-container class="centerdatalayout">
    <v-row>
      <v-col>
        <v-btn to="/centerdatalayout/centerbasicinfo">기본 정보</v-btn>
      </v-col>
      <v-col>
        <v-btn to="/centerdatalayout/centerdetailinfo">상세 정보</v-btn>
      </v-col>
      <v-col>
        <v-btn to="/centerdatalayout/centerevalgrade">평가등급</v-btn>
      </v-col>
      <v-col>
        <v-btn to="/centerdatalayout/centercafereview">카페 리뷰 분석</v-btn>
      </v-col>
      <v-col>
        <v-btn to="/centerdatalayout/centerstatus">센터 현황</v-btn>
      </v-col>
    </v-row>

    <v-divider></v-divider>
    <v-row>
      <v-col>
        <router-view />
      </v-col>
    </v-row>
  </v-container>
    
</template>

<script>

export default {
  name: 'CenterDataLayout',

}
</script>

<style scoped>

.centerdatalayout {
  background-color: honeydew;
  min-height: 350px;
}

</style>