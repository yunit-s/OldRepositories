<template>
  <div id="BoxOfficeMovieDetails">
    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="exampleModalLabel">
              {{ movieDetails.movieNm }}
            </h4>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body">
            <ul>
              <li>
                <h5>출연</h5>
                <span v-for="(actor, index) in movieDetails.actors" :key="index"
                  >{{ actor.peopleNm }}, </span
                ><br /><br />
              </li>
              <li>
                <h5>영화감독</h5>
                <span
                  v-for="(director, index) in movieDetails.directors"
                  :key="index"
                  >{{ director.peopleNm }}</span
                ><br /><br />
              </li>
              <li>
                <h5>관련 영화사</h5>
                <div
                  v-for="(company, index) in movieDetails.companys"
                  :key="index"
                >
                  {{ company.companyPartNm }} : {{ company.companyNm }}
                </div>
                <br />
              </li>
              <li>
                <h5>개봉일</h5>
                <!-- <div>{{ movieDetails.openDt }}</div><br> -->
                <div>{{ transDateToKor(movieDetails.openDt) }}</div>
                <br />
              </li>
              <li>
                <h5>상영 시간</h5>
                <div>{{ movieDetails.showTm }}분</div>
                <br />
              </li>
            </ul>
          </div>
          <div class="modal-footer">
            <button
              type="button"
              class="btn btn-secondary"
              data-bs-dismiss="modal"
            >
              닫기
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { EventBus } from "./EventBus";
export default {
  name: "BoxOfficeMovieDetails",
  data() {
    return {
      movieDetails: {},
    };
  },
  methods: {
    // Search movie details
    getMovieDetails: function (movieCode) {
      console.log("getMovieDetails() 실행");

      // Get movie details from online open API
      axios({
        url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
        method: "GET",
        params: {
          key: "e8b19160d24b80d241f860153813316d",
          movieCd: movieCode,
        },
        responseType: "json",
      })
        .then((details) => {
          console.log("영화 상세정보 axios 호출 성공");
          // console.log(details);
          this.movieDetails = details.data.movieInfoResult.movieInfo;
          console.log(this.movieDetails);
        })
        .catch((error) => {
          console.log("영화 상세정보 axios 호출 실패");
        });
    },
    // 날짜 표기방식 변환
    transDateToKor: function (date) {
      // 무작정 date로 date.substring을 쓸 수 없다.
      //      date의 데이터타입이 String일 때만 사용할 수 있기 때문
      // 날짜 검색을 하지 않아도 이 메소드가 한 번씩 실행되는 이유를 모르겠다.
      let dateStr = new String(date);
      return ( dateStr.substring(0, 4) + "년 " +
        dateStr.substring(4, 6) + "월 " +
        dateStr.substring(6, 8) + "일"
      );
    },
  },
  created: function () {
    console.log("MovieDetails-created() 실행");
    EventBus.$on(
      "Evt_getMovieDetails",
      function (movieCode) {
        console.log("Evt_getMovieDetails() 실행");
        this.getMovieDetails(movieCode);
      }.bind(this)
    );
  },
};
</script>

<style scoped>
</style>
