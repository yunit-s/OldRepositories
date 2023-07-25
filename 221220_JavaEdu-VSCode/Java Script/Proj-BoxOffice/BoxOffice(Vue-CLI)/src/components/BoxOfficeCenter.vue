<template>
  <div id="BoxOfficeCenter">
    <div class="container-fluid">
      <div class="row">
        <!-- menu -->
        <box-office-menu></box-office-menu>

        <!-- main contents -->
        <box-office-rank></box-office-rank>
      </div>
    </div>
  </div>
</template>

<script>
import BoxOfficeRank from "./BoxOfficeRank.vue";
import BoxOfficeMenu from "./BoxOfficeMenu.vue";
export default {
  components: { BoxOfficeMenu, BoxOfficeRank },
  name: "BoxOfficeCenter",
  data() {
    return {};
  },
};
</script>

<style scoped>
</style>
