<template>
  <div id="BoxOfficeHeader">
    <header
      class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow"
    >
      <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#"
        >Box Office</a
      >
      <button
        class="navbar-toggler position-absolute d-md-none collapsed"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#sidebarMenu"
        aria-controls="sidebarMenu"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- 검색어 입력 -->
      <!-- 기존 텍스트 입력 방식 -->
      <!-- <input class="form-control form-control-dark w-100 rounded-0 border-0" type="text" placeholder="Search"
        aria-label="Search"> -->
      <!-- 달력으로 날짜 입력 방식 -->
      <input
        class="form-control form-control-dark w-100 rounded-0 border-0"
        type="date"
        placeholder="Search"
        aria-label="Search"
        v-model="inputDate"
      />

      <!-- 검색 버튼 -->
      <div class="navbar-nav">
        <div class="nav-item text-nowrap">
          <a
            class="nav-link px-3"
            href="#"
            v-on:click="emitEvt_getBoxOfficeData"
            >Search!!</a
          >
          <!--
            href 를 # 으로 했다? : 자기 자신을 다시 부르는 개념이다.
            html inline event model 을 이용해서 쉽게 진행해보자.
          -->
        </div>
      </div>
    </header>
  </div>
</template>

<script>
import { EventBus } from "./EventBus";
export default {
  name: "BoxOfficeHeader",
  props: {},
  data() {
    return {
      inputDate: "", // 검색창에 입력된 date양식의 날짜. '-'를 포함한다.
    };
  },
  methods: {
    emitEvt_getBoxOfficeData: function () {
      console.log("emitEvt_getBoxOfficeData() 실행");
      EventBus.$emit("Evt_getBoxOfficeData", this.inputDate);
    },
  },
};
</script>

<style scoped>
</style>
