<template>
  <div id="BoxOfficeRank">
    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <h2>영화 순위</h2>
      <p align="right">
        <button v-on:click="delSelBtnClicked" class="btn btn-secondary">
          선택 삭제
        </button>
        <button v-on:click="delAllBtnClicked" class="btn btn-danger">
          전체 삭제
        </button>
      </p>

      <!-- movie list table -->
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col" width="50px">선택</th>
              <th scope="col" width="50px">순위</th>
              <th scope="col" width="120px">포스터</th>
              <th scope="col" width="400px">영화제목</th>
              <th scope="col" width="100px">총 관람객</th>
              <th scope="col" width="120px">개봉일</th>
              <th scope="col" width="80px">삭제</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in movieListRoot" :key="index">
              <td style="text-align: center">
                <input type="checkbox" v-bind:id="'chkbox' + (index + 1)" />
              </td>
              <td style="text-align: center">{{ item.rank }}</td>
              <td style="text-align: center">
                <img v-bind:src="item.thumbnailUrl" />
              </td>
              <!-- <td style="text-align:left">{{ item.movieNm }}</td> -->
              <td style="text-align: left" text-align="left">
                <a
                  href="#"
                  data-bs-toggle="modal"
                  data-bs-target="#exampleModal"
                  v-on:click="emitEvt_getMovieDetails(item.movieCd)"
                  >{{ item.movieNm }}</a
                >
              </td>
              <td style="text-align: center">{{ item.audiAcc }}</td>
              <td style="text-align: center">{{ item.openDt }}</td>
              <td style="text-align: center">
                <button
                  v-on:click="delBtnClicked(index, $event)"
                  v-bind:id="'delBtn' + (index + 1)"
                  class="btn btn-warning"
                >
                  삭제
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</template>

<script>
import { EventBus } from "./EventBus";
export default {
  name: "BoxOfficeRank",
  data() {
    return {
      movieListRoot: [], // 박스오피스 정보
    };
  },
  methods: {
    // Delete one movie data
    delBtnClicked: function (index) {
      console.log("delBtnClicked() 실행");
      this.movieListRoot.splice(index, 1); // 영화리스트 배열에서 index 위치의 요소 1개 삭제
    },
    // Delete checked movie data from movie list
    delSelBtnClicked: function () {
      console.log("delSelBtnClicked() 실행");
      for (let i = this.movieListRoot.length - 1; i >= 0; i--) {
        // 삭제 방식이 index에 대해 한 개씩 삭제하는 로직이라서 역순으로 삭제해야 한다.
        let cbidx = "#chkbox" + (i + 1);

        // jQuery로 체크박스 체크 여부 확인하기
        //    기존 방식
        // if($(cbidx).is(':checked')) {
        //     this.movieListG2.splice(i, 1); // 영화리스트 배열에서 index가 i인 위치의 요소 1개 삭제
        // }
        //    1.6버전 이상일 때 권장하는 방식
        if ($(cbidx).prop("checked")) {
          $(cbidx).prop("checked", false); // 체크박스 체크 해제
          this.movieListRoot.splice(i, 1); // 영화리스트 배열에서 index가 i인 위치의 요소 1개 삭제
        }
      }
    },
    // Delete all movie data from movie list
    delAllBtnClicked: function () {
      console.log("delAllBtnClicked() 실행");
      this.movieListRoot.splice(0); // 영화리스트 배열에 있는 모든 요소 삭제
    },
    // Emit event when click movie title
    emitEvt_getMovieDetails: function (movieCode) {
      console.log("emitEvt_getMovieDetails() 실행");
      EventBus.$emit("Evt_getMovieDetails", movieCode); // 이벤트버스를 통해 occurDetailsEvt라는 이름의 이벤트 발생시키기
    },
    // Get box office data
    getBoxOfficeData: function (inputDate) {
      console.log("getBoxOfficeData() 실행");
      // console.log(inputDate);
      let date = inputDate.replace(/-/g, "");
      // inputDate를 그대로만 쓰면 '-'가 포함돼서 받아진다.
      //    우리가 서버에 보내야 하는 형식은 '-'가 없는 YYYYMMDD 형식이어야 한다.
      // replace() : java script 문자열 치환. 대쉬를 공백으로 바꾸기.
      //    /-/g : 대쉬 '-'를 global 범위에서 찾는다.
      //    두 번째 인자 : 찾은 문자열을 해당 문자열로 치환한다.
      console.log("검색 날짜 = " + date);
      this.axiosBoxOffice(date);
    },
    // Execute axios to get box office data
    axiosBoxOffice: function (date) {
      console.log("axiosBoxOffice() 실행");

      // Get box office data from online open API
      axios({
        url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
        method: "GET",
        params: {
          key: "e8b19160d24b80d241f860153813316d",
          targetDt: date,
        },
        responseType: "json",
      })
        .then((result) => {
          // 여기서 then()의 매개변수를 단순히 function(result) {}으로 하면 안 된다.
          //    function()으로 했을 때와 Arrow function '=>' 으로 구현했을 때의
          //    this가 가리킬 수 있는 객체가 달라지기 때문

          console.log("박스오피스 검색 axios 호출 성공");
          // console.log(result);
          // console.log(result.data);

          this.movieListRoot = result.data.boxOfficeResult.dailyBoxOfficeList;
          // dailyBoxOfficeList만 Array이고, 나머진 Object다.
          // Array가 활용하기 더 좋은 듯.
          console.log("this.movieListRoot = ");
          console.log(this.movieListRoot);

          // put poster url in movie list
          this.movieListRoot.forEach((item) => {
            // forEach()
            //    자바스크립트의 배열에서 활용 가능한 반복문.
            //    인자는 자동으로 배열의 요소들을 하나씩 가져오게 된다.
            this.axiosMoviePoster(item);
          });
        })
        .catch((error) => {
          console.log("박스오피스 검색 axios 호출 실패");
        })
        .finally(function (result) {
          console.log("박스오피스 검색 finally 호출");
        });
    },
    // Execute axios to get movie poster
    axiosMoviePoster: function (item) {
      console.log("axiosMoviePoster() 실행");

      // Get movie poster from kakao search
      axios({
        url: "https://dapi.kakao.com/v2/search/image",
        method: "GET",
        params: {
          // 검색어
          query: item.movieNm + " 포스터",
        },
        headers: {
          // 인증에 대한 정보 입력
          // Authorization: 'KakaoAK ${REST_API_KEY}'
          Authorization: "KakaoAK e5511dcd4332e8a8fb811afe1f102815",
        },
        responseType: "json", // 받아올 데이터의 자료 구조
      })
        .then((imageList) => {
          console.log("포스터 검색 axios 호출 성공");

          // 이미지 데이터 저장하기
          //    Vue.set()을 쓰지 않으면 화면 갱신이 자동으로 이루어지지 않음.
          //    Vue.set() 관련 정보 : https://v2.vuejs.org/v2/api/#Vue-set
          // item.thumbnailUrl = imageList.data.documents[0].thumbnail_url;
          Vue.set(
            item,
            "thumbnailUrl",
            imageList.data.documents[0].thumbnail_url
          );
        })
        .catch((error) => {
          console.log("포스터 검색 axios 호출 실패");
        });
        // .finally(function (result) {
        //   // 성공 여부에 상관없이 마지막으로 실행되는 부분
        //   console.log("포스터 검색 finally 호출");
        // })
    },
  },
  created: function () {
    console.log("Rank-created() 실행");
    // event bus에 대한 이벤트 등록해두기
    // 만약 다른 곳에서도 똑같은 이름의 이벤트 버스 함수를 만들면, 해당하는 모든 함수가 실행된다.
    //    상위 컴포넌트의 이벤트 함수가 먼저 실행됨

    // event bus에서 this 활용하기
    //    event bus에서 this를 쓰면, event bus 자신을 가리키게 된다.
    //    우리가 흔히 생각하는, created를 포함한 컴포넌트를 가리키기 위해서는 function에 .bind(this)를 붙이거나,
    //    혹은, 이벤트 함수를 arrow function으로 잡아주면 된다.

    // .bind(this)을 사용하는 방법
    // EventBus.$on(
    //   "Evt_getBoxOfficeData",
    //   function (inputDate) {
    //     console.log("Evt_getBoxOfficeData() 실행");
    //     this.getBoxOfficeData(inputDate);
    //   }.bind(this)
    // );

    // Arrow function을 사용하는 방법
    EventBus.$on("Evt_getBoxOfficeData", (inputDate) => {
      console.log("Evt_getBoxOfficeData() 이벤트발생");
      this.getBoxOfficeData(inputDate);
    });
  },
};
</script>

<style scoped>
</style>
