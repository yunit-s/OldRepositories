<template>
  <div class="mainsidelayout">
    <v-card style="height: 740px">

      <v-tabs
        fixed-tabs
        v-model="tab"
        bg-color="orange-lighten-4"
      >
        <v-tab :value="1">위치설정</v-tab>
        <v-tab :value="2">검색</v-tab>
      </v-tabs>

      <v-window v-model="tab">
        <v-window-item v-for="n in 2" :key="n" :value="n">

          <v-container fluid v-if="n === 1">
            <h1>위치 설정하기</h1>
            <p>위치 설정하면 아래 리스트 출력</p>
            <v-divider></v-divider>
            <h2>추천 리스트 1</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>추천 리스트 1</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>추천 리스트 1</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>추천 리스트 1</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>추천 리스트 1</h2>
            <p>내용</p>
          </v-container>

          <v-container fluid v-if="n === 2">
            <h1>상호명 검색</h1>
            <p>시군구 입력 후 검색어 입력</p>
            <v-divider></v-divider>
            <h2>검색 리스트 3</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>검색 리스트 3</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>검색 리스트 3</h2>
            <p>내용</p>
            <v-divider></v-divider>
            <h2>검색 리스트 3</h2>
            <p>내용</p>
          </v-container>
        </v-window-item>

      </v-window>

    </v-card>
  </div>
</template>

<script>

export default {
  name: 'MainSideLayout',
  data: () => ({
    tab: null,
  }),

}

</script>

<style scoped>

.mainsidelayout {
  height: 740px;
  background-color: azure;
}

</style>