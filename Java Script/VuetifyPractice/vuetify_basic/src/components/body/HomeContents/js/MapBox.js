export default {
    data() {
      return {

      };
    },
    mounted() {
      console.log("@@ mounted() 실행");
      console.log(window.kakao);
      if (window.kakao && window.kakao.maps) {
        this.initMap();
      } else {
        this.createMapScript();
      }
    },
    methods: {
      btnTest() {
        console.log("@@ btnTest() 실행");
      },
      createMapScript() {
        console.log("@@ createMapScript() 실행");
        const script = document.createElement("script");
        /* global kakao */
        script.onload = () => kakao.maps.load(this.initMap);
        script.src =
          "//dapi.kakao.com/v2/maps/sdk.js?appkey=" +
          process.env.VUE_APP_KAKAO_API_KEY +
          "&autoload=false" +
          "&libraries=services";
        document.head.appendChild(script);
      },
      initMap() {
        console.log("@@ initMap() 실행");
        const container = document.getElementById("map");
        const options = {
          center: new kakao.maps.LatLng(33.450701, 126.570667),
          level: 5,
        };
  
        //지도 객체를 등록합니다.
        //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
        this.map = new kakao.maps.Map(container, options);
      },
    },
  }