<template>
  <div id="app">
    <!-- Top layout -->
    <box-office-header></box-office-header>

    <!-- Center layout -->
    <box-office-center></box-office-center>

    <!-- Modal for movie details -->
    <box-office-movie-details></box-office-movie-details>
  </div>
</template>

<script>
import BoxOfficeCenter from "./components/BoxOfficeCenter.vue";
import BoxOfficeHeader from "./components/BoxOfficeHeader.vue";
import BoxOfficeMovieDetails from "./components/BoxOfficeMovieDetails.vue";
export default {
  components: { BoxOfficeHeader, BoxOfficeCenter, BoxOfficeMovieDetails },
  name: "app",
  data() {
    return {};
  },
  methods: {},
};
</script>

<style>
</style>
