<template>
  <v-container>
    <v-row class="specselectbox-layout">
      <!-- 여기는 선택상자 넣을 부분 -->
      <spec-select-box />
    </v-row>

    <v-row class="mapbox-layout">
      <!-- 여기는 지도 표시할 부분 -->
      <map-box />
    </v-row>

  </v-container>
</template>

<script>
import MapBox from '../body/MainContents/MapBox.vue'
import SpecSelectBox from '../body/MainContents/SpecSelectBox.vue'

export default {
  components: { SpecSelectBox, MapBox },
  name: 'MainContentsLayout',

}
</script>

<style scoped>

.specselectbox-layout {
  height: 40px;
  background-color: aquamarine;
}
.mapbox-layout {
  background-color: blanchedalmond;
  height: 700px;
}

</style>