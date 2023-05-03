import { createStore } from 'vuex'

export default createStore({
  state: {
    // 글로벌로 관리될 상태 값 
    counter: 0,
    count: 10,
    strArr: [],
    jsonData: '',
    searchedCenter: [
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
    getSearchedCenter(state) {
      return state.searchedCenter;
    },
    getMarkerPositions(state) {
      return state.markerPositions;
    },
    getMarkers(state) {
      return state.markers;
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
    editCount1Mutation(state, newCount) {
      state.count = newCount;
    },
    editCount2Mutation(state, newCount) {
      state.count = newCount;
    },
    // 배열 다루기
    multipleStatesSetMutation(state, strArrData) {
      console.log("@@ multipleStatesSetMutation 실행");
      console.log(strArrData[0] + ", " + strArrData[1] + ", " + strArrData[2]);
      state.strArr = strArrData;
    },
    editJsonDataMutation(state, newJson) {
      console.log("@@ editJsonDataMutation 실행");
      console.log(newJson);
      state.jsonData = newJson;
    },
    // Lumos 프로젝트
    editSearchedCenterMutation(state, newSearchedCenter) {
      console.log("@@ editSearchedCenterMutation 실행");
      console.log(newSearchedCenter);
      state.searchedCenter = newSearchedCenter;
    },
    editMarkerPositionsMutation(state, newMarkerPositions) {
      console.log("@@ editMarkerPositionsMutation 실행");
      console.log(newMarkerPositions);
      state.markerPositions = newMarkerPositions;
    },
    editMarkersMutation(state, newMarkers) {
      console.log("@@ editMarkersMutation 실행");
      console.log(newMarkers);
      state.markers = newMarkers;
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
    editCount1(context, newCount) {
      context.commit("editCount1Mutation", newCount);
    },
    editCount2({ commit }, newCount) {
      commit("editCount2Mutation", newCount);
    },
    // 배열 다루기
    multipleStatesSet({ commit }, strArrData) {
      commit("multipleStatesSetMutation", strArrData);
    },
    editJsonData({ commit }, newJson) {
      commit("editJsonDataMutation", newJson);
    },
    // Lumos 프로젝트
    editSearchedCenter({ commit }, newSearchedCenter) {
      commit("editSearchedCenterMutation", newSearchedCenter);
    },
    editMarkerPositions({ commit }, newMarkerPositions) {
      commit("editMarkerPositionsMutation", newMarkerPositions);
    },
    editMarkers({ commit }, newMarkers) {
      commit("editMarkersMutation", newMarkers);
    },
  },
  modules: {
  }
})
