export default {
  computed: {
    searchedCentersVuex() {
      console.log("@@@ computed-searchedCentersVuex 실행");
      return this.$store.getters.getSearchedCenters;
    },
  },
  data() {
    return {
      markers: [],
      infowindow: null,
    };
  },
  mounted() {
    console.log("@@ mounted 실행");
    console.log(window.kakao);
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      this.createMapScript();
    }
  },
  methods: {
    btnTest() {
      console.log("@@ btnTest 실행");
    },
    // 지도 스크립트 생성
    createMapScript() {
      console.log("@@ createMapScript 실행");
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
    // 지도 초기화
    initMap() {
      console.log("@@ initMap 실행");
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    // 지도에 마커 표시하기
    displayMarker(markerPositions) {
      console.log("@@ displayMarker 실행");

      // 기존 마커 지우기
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      // markerPositions에 저장된 위경도 배열 데이터를 kakao의 LatLng 객체 배열로 변환
      // position : markerPositions 배열의 각 원소
      // LatLng : 위도, 경도 좌표값 저장 객체
      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        // 마커 정보 저장
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        // positions 배열의 데이터를 LatLngBounds 단일 객체에 포함시키기
        const bounds = positions.reduce(
          // callback : 지정한 위치를 포함하는 최소 박스 경계영역 데이터 저장
          (bounds, latlng) => bounds.extend(latlng),
          // initail value : LatLngBounds 객체 생성
          new kakao.maps.LatLngBounds()
        );

        // 지도 영역의 경계 정의
        this.map.setBounds(bounds);
      }
    },
  },
  watch: {
    searchedCentersVuex(newVal, oldVal) {
      console.log("@@@ watch-searchedCentersVuex 실행", newVal, oldVal);
      // console.log(newVal, oldVal);

      // 마커 정보 저장하고 지도에 출력
      let positions = [];
      for (let i = 0; i < newVal.length; i++) {
        positions.push([newVal[i].centerDetailLatitude,
          newVal[i].centerDetailLongitude]);
      }
      this.displayMarker(positions);

      // 마커마다 센터 번호 저장하고, 클릭하면 상세정보 보기

    },
  },
}