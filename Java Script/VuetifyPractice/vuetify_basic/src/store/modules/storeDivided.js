// 작성 방식 1

const storeDivided = {
  state: {
    dividedCount: 22,
  },
  getters: {
    // getters는 뭔가 적용이 안 된다. 왜지?
    getDividedCount(state) {
      console.log("@@ storeDivided - getters");
      return state.dividedCount;
    },
  },
  mutations: {
    setDividedCountMutation(state, newDividedCount) {
      console.log("@@ storeDivided - mutations");
      state.dividedCount = newDividedCount;
    },
  },
  actions: {
    setDividedCount({ commit }, newDividedCount) {
      console.log("@@ storeDivided - actions");
      commit("setDividedCountMutation", newDividedCount);
    },
  },
};

export default storeDivided;

/////////////////

// 작성 방식 2

// const state = {
//   dividedCount: 22,
// };

// const getters = {
//   getDividedCount(state) {
//     console.log("@@ storeDivided - getters");
//     return state.dividedCount;
//   },
// };

// const mutations = {
//   setDividedCountMutation(state, newDividedCount) {
//     console.log("@@ storeDivided - mutations");
//     state.dividedCount = newDividedCount;
//   },
// };

// const actions = {
//   setDividedCount({ commit }, newDividedCount) {
//     console.log("@@ storeDivided - actions");
//     commit("setDividedCountMutation", newDividedCount);
//   },
// };

// export default {
//   state,
//   getters,
//   mutations,
//   actions,
// };