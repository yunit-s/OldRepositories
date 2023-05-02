import { createStore } from 'vuex'

export default createStore({
  state: {
    // 글로벌로 관리될 상태 값 
    counter: 0,
    count: 10,
    strArr: [],
    jsonData: '',
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
  },
  modules: {
  }
})
