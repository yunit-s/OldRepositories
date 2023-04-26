<template>
  <v-container>
    <v-row class="selectboxlayout">
      여기는 선택상자 넣을 부분
    </v-row>

    <v-row class="maplayout">
      여기는 지도 표시할 부분
    </v-row>

  </v-container>
</template>

<script>

export default {
  name: 'MainContentsLayout',

}
</script>

<style scoped>

.selectboxlayout {
  height: 40px;
  background-color: aquamarine;
}
.maplayout {
  background-color: blanchedalmond;
  height: 700px;
}

</style>