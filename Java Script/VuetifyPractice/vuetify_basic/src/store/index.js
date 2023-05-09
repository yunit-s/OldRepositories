import { createStore } from 'vuex';
import storeDivided from './modules/storeDivided';

export default createStore({
  state: {
    // 글로벌로 관리될 상태 값 
    counter: 0,
    count: 10,
    strArr: [],
    jsonData: '',
    searchedCenters: [
      {
        data1keyNum: "초기값 번호1",
        data1keyName: "데이터 이름1",
        data1keycontents: "데이터 내용1",
        data1keyDetail: "데이터 상세정보1",
        data1keyOther: "데이터 기타정보1",
      },
      {
        data2keyNum: "초기값 번호2",
        data2keyName: "데이터 이름2",
        data2keycontents: "데이터 내용2",
        data2keyDetail: "데이터 상세정보2",
        data2keyOther: "데이터 기타정보2",
      },
    ],
    markerPositions: [
      [37.499590490909185, 127.0263723554437],
      [37.499427948430814, 127.02794423197847],
      [37.498553760499505, 127.02882598822454],
      [37.497625593121384, 127.02935713582038],
      [37.49629291770947, 127.02587362608637],
      [37.49754540521486, 127.02546694890695],
      [37.49646391248451, 127.02675574250912],
    ],
    markers: [],
    kidsdataDetail: [
      {
        centerNum: -1,
        centerDetailState: "초기값",
        centerDetailCity: "초기값",
        centerDetailBame: "초기값",
        centerDetailClassification: "초기값",
        centerDetailCenteropen: "초기값",
        centerDetailOfficenumber: -1,
        centerDetailAddress: "초기값",
        centerDetailPhone: "초기값",
        centerDetailFax: "초기값",
        centerDetailRoomcount: -1,
        centerDetailRoomsize: -1,
        centerDetailPlaygroundcount: "초기값",
        centerDetailTeachercount: -1,
        centerDetailRegularperson: -1,
        centerDetailCurrentperson: -1,
        centerDetailLatitude: 37.49494949,
        centerDetailLongitude: 127.02777777,
        centerDetailVehicle: "초기값",
        centerDetailHompage: "초기값",
        centerDetailEstablish: "초기값",
      },
      {
        centerNum: -2,
        centerDetailState: "초기값",
        centerDetailCity: "초기값",
        centerDetailBame: "초기값",
        centerDetailClassification: "초기값",
        centerDetailCenteropen: "초기값",
        centerDetailOfficenumber: -1,
        centerDetailAddress: "초기값",
        centerDetailPhone: "초기값",
        centerDetailFax: "초기값",
        centerDetailRoomcount: -1,
        centerDetailRoomsize: -1,
        centerDetailPlaygroundcount: "초기값",
        centerDetailTeachercount: -1,
        centerDetailRegularperson: -1,
        centerDetailCurrentperson: -1,
        centerDetailLatitude: 37.49499494,
        centerDetailLongitude: 127.02778888,
        centerDetailVehicle: "초기값",
        centerDetailHompage: "초기값",
        centerDetailEstablish: "초기값",
      }
    ],
    clickedCenter: {},
  },
  getters: {
    // 데이터에 변화를 줄 수는 없음
    counter: state => state.counter,
    getCount(state) {
      return state.count;
    },
    getStrArr(state) {
      return state.strArr;
    },
    getJsonData(state) {
      return state.jsonData;
    },
    getSearchedCenters(state) {
      return state.searchedCenters;
    },
    getMarkerPositions(state) {
      return state.markerPositions;
    },
    getMarkers(state) {
      return state.markers;
    },
    getKidsdataDetail(state) {
      return state.kidsdataDetail;
    },
    getClickedCenter(state) {
      return state.clickedCenter;
    },
  },
  mutations: {
    // 실제 데이터 변화가 일어나는 곳
    increment: state => (state.counter += 1),
    decrement: state => (state.counter -= 1),
    incCount(state) {
      state.count++;
    },
    decCount(state) {
      state.count--;
    },
    setCount1Mutation(state, newCount) {
      state.count = newCount;
    },
    setCount2Mutation(state, newCount) {
      state.count = newCount;
    },
    // 배열 다루기
    multipleStatesSetMutation(state, strArrData) {
      // console.log("@@ multipleStatesSetMutation 실행");
      // console.log(strArrData[0] + ", " + strArrData[1] + ", " + strArrData[2]);
      state.strArr = strArrData;
    },
    setJsonDataMutation(state, newJson) {
      state.jsonData = newJson;
    },
    // Lumos 프로젝트
    setSearchedCentersMutation(state, newSearchedCenters) {
      state.searchedCenters = newSearchedCenters;
    },
    setMarkerPositionsMutation(state, newMarkerPositions) {
      state.markerPositions = newMarkerPositions;
    },
    setMarkersMutation(state, newMarkers) {
      state.markers = newMarkers;
    },
    setKidsdataDetailMutation(state, newKidsdataDetail) {
      state.kidsdataDetail = newKidsdataDetail;
    },
    setClickedCenterMutation(state, newClickedCenter) {
      console.log("@@@@ vuex-setClickedCenterMutation", newClickedCenter);
      state.clickedCenter = newClickedCenter;
    },
  },
  actions: {
    // 비동기 로직을 처리
    // mutaion 을 일으키기 위한 행동. 컴포넌트에서는 actions 를 사용한다
    addCounter: context => context.commit("increment"),
    subCounter: context => context.commit("decrement"),
    addCount(context) {
      context.commit("incCount");
    },
    subCount(context) {
      context.commit("decCount");
    },
    // 아래 두 액션은 동일하게 동작함
    setCount1(context, newCount) {
      context.commit("setCount1Mutation", newCount);
    },
    setCount2({ commit }, newCount) {
      commit("setCount2Mutation", newCount);
    },
    // 배열 다루기
    multipleStatesSet({ commit }, strArrData) {
      commit("multipleStatesSetMutation", strArrData);
    },
    setJsonData({ commit }, newJson) {
      commit("setJsonDataMutation", newJson);
    },
    // Lumos 프로젝트
    setSearchedCenters({ commit }, newSearchedCenters) {
      commit("setSearchedCentersMutation", newSearchedCenters);
    },
    setMarkerPositions({ commit }, newMarkerPositions) {
      commit("setMarkerPositionsMutation", newMarkerPositions);
    },
    setMarkers({ commit }, newMarkers) {
      commit("setMarkersMutation", newMarkers);
    },
    setKidsdataDetail({ commit }, newKidsdataDetail) {
      commit("setKidsdataDetailMutation", newKidsdataDetail);
    },
    setClickedCenter({ commit }, newClickedCenter) {
      commit("setClickedCenterMutation", newClickedCenter);
    },
  },
  modules: {
    storeDivided,
  }
})
