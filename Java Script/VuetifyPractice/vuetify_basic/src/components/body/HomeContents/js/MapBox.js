export default {
  computed: {
    searchedCenterVuex() {
      return this.$store.getters.getSearchedCenter;
    },
    markerPositionsVuex() {
      console.log("@@@ MapBox Marker 테스트");
      let markerPositions = this.$store.getters.getMarkerPositions;
      this.displayMarkerVuex(markerPositions);
      return markerPositions;
      // return this.$store.getters.getMarkerPositions;
    },
    markersVuex() {
      return this.$store.getters.getMarkers;
    },
  },
  data() {
    return {
      markerPositions1: [
        [33.452278, 126.567803],
        [33.452671, 126.574792],
        [33.451744, 126.572441],
      ],
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
    displayMarkerVuex(markerPositions) {
      console.log("@@ displayMarkerVuex 실행");

      // 기존 마커 지우기
      if (this.markersVuex.length > 0) {
        this.markersVuex.forEach((marker) => marker.setMap(null));
      }

      // markerPositions에 저장된 배열 데이터를 kakao의 LatLng 객체 배열로 변환
      // position : markerPositions 배열의 각 원소
      // LatLng : 위도, 경도 좌표값 저장 객체
      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        // 마커 정보 저장
        this.markersVuex = positions.map(
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
}