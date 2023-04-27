<template>
  <v-container>
    
    <!-- <v-btn @click="btnTest">버튼</v-btn> -->

    <div class="map_wrap">
      <div
        id="map"
        style="width: 100%; height: 100%; position: relative; overflow: hidden"
      ></div>
    </div>

  </v-container>
</template>

<script src="./js/MapBox.js"></script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
@import "./scss/MapBox.scss";
</style>