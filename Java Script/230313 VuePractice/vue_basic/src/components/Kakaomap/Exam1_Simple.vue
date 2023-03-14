<template>
  <div class="exam1_simple">
    <h3>Exam1_Simple.vue 출력</h3>
    <div>참고 사이트 : <a href="https://soa-memo.tistory.com/41">https://soa-memo.tistory.com/41</a></div>
    <div id="map" style="width:700px;height:400px;"></div>
  </div>
</template>

<script>
export default {
  name: "Exam1_Simple",
  data() {
    return {
      // map 객체 설정
      map: null,
    };
  },
  setup() {},
  created() {},
  mounted() {
    console.log("@@ mounted() 실행");
    // api 스크립트 소스 불러오기 및 지도 출력
    if (window.kakao && window.kakao.maps) {
      this.loadMap();
    } else {
      this.loadScript();
    }
  },
  unmounted() {},
  methods: {
    // api 불러오기
    loadScript() {
      console.log("@@ loadScript() 실행");
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" + process.env.VUE_APP_KAKAOMAP_KEY_JAVASCRIPT + "&autoload=false"; 
      script.onload = () => window.kakao.maps.load(this.loadMap); 

      document.head.appendChild(script);
    },
    // 맵 출력하기
    loadMap() {
      console.log("@@ loadMap() 실행");
      const container = document.getElementById("map"); 
      const options = {
        center: new window.kakao.maps.LatLng(33.450701, 126.570667), 
        level: 3
      };

      this.map = new window.kakao.maps.Map(container, options); 
      this.loadMaker();
    },
    // 지정한 위치에 마커 불러오기
    loadMaker() {
      console.log("@@ loadMaker() 실행");
      const markerPosition = new window.kakao.maps.LatLng(
        33.450701,
        126.570667
      );

      const marker = new window.kakao.maps.Marker({
        position: markerPosition,
      });

      marker.setMap(this.map);
    },

  },
};
</script>

<style lang="scss">

</style>