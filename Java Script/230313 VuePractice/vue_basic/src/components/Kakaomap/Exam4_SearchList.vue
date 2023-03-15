<template>
  <div class="exam4_searchlist">
    <h3>Exam4_SearchList.vue 출력</h3>
    <div>Exam3 코드를 베이스로, 카카오 기본 예제 추가하기</div>
    <div>
      참고 사이트 :
      <a href="https://apis.map.kakao.com/web/sample/"
        >https://apis.map.kakao.com/web/sample/</a
      >
    </div>
    <div class="button-group">
      <button @click="changeSize(0)">Hide</button>
      <button @click="changeSize(600)">show</button>
      <button @click="displayMarker(markerPositions1)">marker set 1</button>
      <button @click="displayMarker(markerPositions2)">marker set 2</button>
      <button @click="displayMarker([])">marker set 3 (empty)</button>
      <button @click="displayInfoWindow">infowindow</button>
    </div>
    <div class="map_wrap">
      <div
        id="map"
        style="width: 100%; height: 100%; position: relative; overflow: hidden"
      ></div>

      <div id="menu_wrap" class="bg_white">
        <div class="option">
          <div>
            <!-- <form onsubmit="searchPlaces(); return false;"> -->
              키워드 :
              <input type="text" value="이태원 맛집" id="keyword" size="15" />
              <!-- <button type="submit">검색하기</button> -->
            <!-- </form> -->
            <button @click="searchPlaces()">검색하기</button>
          </div>
        </div>
        <hr />
        <ul id="placesList"></ul>
        <div id="pagination"></div>
      </div>
    </div>
  </div>
</template>

<script src="./js/Exam4_SearchList.js"></script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
@import "./scss/Exam4_SearchList.scss";

</style>
