export default {
  name: 'MapBox',
  data() {
    return {
      markerPositions1: [
        [33.452278, 126.567803],
        [33.452671, 126.574792],
        [33.451744, 126.572441],
      ],
      markerPositions2: [
        [37.499590490909185, 127.0263723554437],
        [37.499427948430814, 127.02794423197847],
        [37.498553760499505, 127.02882598822454],
        [37.497625593121384, 127.02935713582038],
        [37.49629291770947, 127.02587362608637],
        [37.49754540521486, 127.02546694890695],
        [37.49646391248451, 127.02675574250912],
      ],
      markers: [],
      infowindow: null,
      ps: null, // 장소 검색 객체
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
      // let kakao_key = process.env.VUE_APP_KAKAO_KEY_JAVASCRIPT;
      // console.log(kakao_key);
    },
    createMapScript() {
      console.log("@@ createMapScript() 실행");
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=" +
        process.env.VUE_APP_KAKAO_KEY_JAVASCRIPT +
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
    changeSize(size) {
      console.log("@@ changeSize() 실행");
      const container = document.getElementById("map");
      container.style.width = `${size}px`;
      container.style.height = `${(size * 2) / 3}px`;
      this.map.relayout();
    },
    displayMarker(markerPositions) {
      console.log("@@ displayMarker() 실행");
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
    // displayInfoWindow() {
    //   console.log("@@ displayInfoWindow() 실행");
    //   if (this.infowindow && this.infowindow.getMap()) {
    //     //이미 생성한 인포윈도우가 있기 때문에 지도 중심좌표를 인포윈도우 좌표로 이동시킨다.
    //     this.map.setCenter(this.infowindow.getPosition());
    //     return;
    //   }

    //   var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    //     iwPosition = new kakao.maps.LatLng(33.450701, 126.570667), //인포윈도우 표시 위치입니다
    //     iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

    //   this.infowindow = new kakao.maps.InfoWindow({
    //     map: this.map, // 인포윈도우가 표시될 지도
    //     position: iwPosition,
    //     content: iwContent,
    //     removable: iwRemoveable,
    //   });

    //   this.map.setCenter(iwPosition);
    // },
    // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
    // 인포윈도우에 장소명을 표시합니다
    displayInfowindow(marker, title) {
      console.log("@@ displayInfowindow() 실행");
      if (!this.infowindow) {
        // 인포 윈도우가 없으면 생성. 컴포넌트가 전환되기 전까지 딱 한 번 실행됨
        // console.log("@@ infowindow 생성");
        this.infowindow = new kakao.maps.InfoWindow({zIndex:1});
      }
      
      var content = '<div style="padding:5px;z-index:1;">' + title + "</div>";
      this.infowindow.setContent(content);
      this.infowindow.open(this.map, marker);
    },
    // 키워드 검색을 요청하는 함수입니다
    searchPlaces() {
      console.log("@@ searchPlaces() 실행");
      // console.log("@@ kakao.maps.services");
      // console.log(kakao.maps.services);
      var keyword = document.getElementById("keyword").value;

      if (!keyword.replace(/^\s+|\s+$/g, "")) {
        // alert("키워드를 입력해주세요!");
        console.log("@@키워드를 입력해주세요!");
        return false;
      }

      // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
      if (!this.ps) {
        // 장소검색 객체(ps)가 없으면 생성. 컴포넌트가 전환되기 전까지 딱 한 번 실행됨
        // console.log("@@ ps객체 생성");
        this.ps = new kakao.maps.services.Places();
      }
      this.ps.keywordSearch(keyword, this.placesSearchCB);
    },
    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    placesSearchCB(data, status, pagination) {
      console.log("@@ placesSearchCB() 실행");
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        this.displayPlaces(data);

        // 페이지 번호를 표출합니다
        this.displayPagination(pagination);
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // alert("검색 결과가 존재하지 않습니다.");
        console.log("@@ 검색 결과가 존재하지 않습니다.");
        return;
      } else if (status === kakao.maps.services.Status.ERROR) {
        // alert("검색 결과 중 오류가 발생했습니다.");
        console.log("@@ 검색 결과 중 오류가 발생했습니다.");
        return;
      }
    },
    // 검색 결과 목록과 마커를 표출하는 함수입니다
    displayPlaces(places) {
      console.log("@@ displayPlaces() 실행");
      var listEl = document.getElementById("placesList"),
        menuEl = document.getElementById("menu_wrap"),
        fragment = document.createDocumentFragment(),
        bounds = new kakao.maps.LatLngBounds();
        // listStr = "";
      // console.log(listStr);

      // 검색 결과 목록에 추가된 항목들을 제거합니다
      this.removeAllChildNods(listEl);

      // 지도에 표시되고 있는 마커를 제거합니다
      this.removeMarker();

      for (var i = 0; i < places.length; i++) {
        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
          marker = this.addMarker(placePosition, i),
          itemEl = this.getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        ((marker, title) => {
          // 지도 위 마커
          kakao.maps.event.addListener(marker, "mouseover", () => {
            this.displayInfowindow(marker, title);
          });
          kakao.maps.event.addListener(marker, "mouseout", () => {
            this.infowindow.close();
          });

          // 검색리스트
          itemEl.onmouseover = () => {
            this.displayInfowindow(marker, title);
          };
          itemEl.onmouseout = () => {
            this.infowindow.close();
          };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
      }

      // 검색결과 항목들을 검색결과 목록 Element에 추가합니다
      listEl.appendChild(fragment);
      menuEl.scrollTop = 0;

      // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
      this.map.setBounds(bounds);
    },
    // 검색결과 항목을 Element로 반환하는 함수입니다
    getListItem(index, places) {
      // console.log("@@ getListItem() 실행");
      var el = document.createElement("li"),
        itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
          '<div class="info">' +
          "   <h5>" + places.place_name + "</h5>";

      if (places.road_address_name) {
        itemStr += "    <span>" + places.road_address_name + "</span>" +
          '   <span class="jibun gray">' + places.address_name + "</span>";
      } else {
        itemStr += "    <span>" + places.address_name + "</span>";
      }

      itemStr += '  <span class="tel">' + places.phone + "</span>" + "</div>";

      el.innerHTML = itemStr;
      el.className = "item";

      return el;
    },
    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
    // addMarker(position, idx, title) {
    // title이 왜 기본 매개변수로 잡혀있지?
    addMarker(position, idx) {
      // console.log("@@ addMarker() 실행");
      // console.log(title);
      var imageSrc =
          "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
        imgOptions = {
          spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
          spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(13, 37), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imgOptions
        ),
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });

      marker.setMap(this.map); // 지도 위에 마커를 표출합니다
      this.markers.push(marker); // 배열에 생성된 마커를 추가합니다

      return marker;
    },
    // 지도 위에 표시되고 있는 마커를 모두 제거합니다
    removeMarker() {
      console.log("@@ removeMarker() 실행");
      for (var i = 0; i < this.markers.length; i++) {
        this.markers[i].setMap(null);
      }
      this.markers = [];
    },
    // 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
    displayPagination(pagination) {
      console.log("@@ displayPagination() 실행");
      var paginationEl = document.getElementById("pagination"),
        fragment = document.createDocumentFragment(),
        i;

      // 기존에 추가된 페이지번호를 삭제합니다
      while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild(paginationEl.lastChild);
      }

      for (i = 1; i <= pagination.last; i++) {
        var el = document.createElement("a");
        el.href = "#";
        el.innerHTML = i;

        if (i === pagination.current) {
          el.className = "on";
        } else {
          el.onclick = (function (i) {
            return function () {
              pagination.gotoPage(i);
            };
          })(i);
        }

        fragment.appendChild(el);
      }
      paginationEl.appendChild(fragment);
    },
    // 검색결과 목록의 자식 Element를 제거하는 함수입니다
    removeAllChildNods(el) {
      console.log("@@ removeAllChildNods() 실행");
      while (el.hasChildNodes()) {
        el.removeChild(el.lastChild);
      }
    },
  },
}