<template>
  <v-container class="mainsidelayout">
    <v-row justify="space-between">
      <v-col>
        <v-btn>위치 설정</v-btn>
      </v-col>
      <v-col>
        <v-btn>상호명 검색</v-btn>
      </v-col>
    </v-row>

    <v-divider></v-divider>

    <v-row>
      <v-col>
        
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

export default {
  name: 'MainSideLayout',

}
</script>

<style scoped>

.mainsidelayout {
  height: 740px;
  background-color: azure;
}

</style>