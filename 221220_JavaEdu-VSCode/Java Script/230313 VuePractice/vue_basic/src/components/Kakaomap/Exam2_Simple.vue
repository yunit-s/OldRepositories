<template>
  <div class="exam2_simple">
    <h3>Exam2_Simple.vue 출력</h3>
    <div>참고 사이트 : <a href="https://goodteacher.tistory.com/432">https://goodteacher.tistory.com/432</a></div>
    <div id="map" style="width:700px;height:400px;"></div>
    <div>마커 기능은 동작이 안 되네... 왜지?</div>
  </div>
</template>

<script>
export default {
  name: "Exam2_Simple",
  data() {
    return {
      map: null,
      markerPositions1: [
        { title: "카카오", latlng: new kakao.maps.LatLng(33.450705, 126.570677) },
        { title: "생태연못", latlng: new kakao.maps.LatLng(33.450936, 126.569477) },
        { title: "텃밭", latlng: new kakao.maps.LatLng(33.450705, 126.570677) },
        { title: "근린공원", latlng: new kakao.maps.LatLng(33.451393, 126.570738) },
      ],
      // 화면에 표시되어있는 marker들
      markers: []
    };
  },
  mounted() {
    console.log("@@ mounted() 실행");
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=` + process.env.VUE_APP_KAKAOMAP_KEY_JAVASCRIPT + `dae3e36f8bdfda4ad966bb4ba125771d`;
      /* global kakao */
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
    } else {
      //console.log("이미 로딩됨: ", window.kakao);
      this.initMap();
    }
  },
  methods: {
    initMap() {
      console.log("@@ initMap() 실행");
      const container = document.getElementById("map");
      const options = {
        // center: new kakao.maps.LatLng(37.2429362, 131.8624647, 16),
        center: new kakao.maps.LatLng(33.450705, 126.570677),
        level: 3,
      };
      this.map = new kakao.maps.Map(container, options);
    },
    displayMarkers(positions) {
      console.log("@@ displayMarkers() 실행");
      // 1. 현재 표시되어있는 marker들이 있다면 marker에 등록된 map을 없애준다.
      if (this.markers.length > 0) {
        this.markers.forEach((item) => {
          item.setMap(null);
        });
      }

      // 2. 마커 이미지 커스터마이징 하기
      // javascript 영역에서 assets의 정보 가져오기
      // const imgSrc = require("@/assets/Kakaomap/map_marker.png");
      // const imgSize = new kakao.maps.Size(24, 35);
      // const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

      // 3. 마커 표시하기
      // positions.forEach((position) => {
      //   const marker = new kakao.maps.Marker({
      //     map: this.map,
      //     position: position.latlng,     // 마커의 위치
      //     title: position.title,         // 마우스 오버 시 표시할 제목 
      //     image: markerImage,            // 마커의 이미지 
      //   });
      //   this.markers.push(marker);
      // });
      positions.forEach((position) => {
        // information window 생성
        const infowindow = new kakao.maps.InfoWindow({
          removable: true,
          content: `<div style="padding:5px;">${position.title}</div>`,
        });

        const marker = new kakao.maps.Marker({
          map: this.map,
          position: position.latlng,
        });
        // 이벤트 등록
        //  kakao.maps.event.addListener(marker, "click", () => {infowindow.open(this.map, marker);});
        kakao.maps.event.addListener(marker, "mouseover", () => {infowindow.open(this.map, marker);});
        kakao.maps.event.addListener(marker, "mouseout", () => {infowindow.close(this.map, marker); });

        this.markers.push(marker);
      });

      // 4. 지도를 이동시켜주기
      // 배열.reduce( (누적값, 현재값, 인덱스, 요소)=>{ return 결과값}, 초기값);
      const bounds = positions.reduce(
        (bounds, position) => bounds.extend(position.latlng),
        new kakao.maps.LatLngBounds()
      );

      this.map.setBounds(bounds);
    },
  },
};
</script>

<style lang="scss">

</style>
