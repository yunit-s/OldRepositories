<template>
  <v-app>
    <v-main>
      <v-container>
        <v-row>
          <v-col cols="8">
            <div class="content">
              <!-- 왼쪽 본문 -->
              <div>여기는 왼쪽본문</div>
              <div>ChatGPT가 만들어준 레이아웃</div>
            </div>
          </v-col>
          <v-col cols="4">
            <div class="sidebar">
              여기는 오른쪽 본문
              <!-- 오른쪽 본문 -->
            </div>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
    <v-footer class="pa-3">
      <span class="text-center">&copy; 2023 My Website</span>
    </v-footer>
  </v-app>
</template>

<style scoped>
@media (min-width: 500px) {
  .content {
    height: calc(100vh - 112px); /* 높이를 계산하여 112px 만큼 footer 공간 확보 */
    overflow-y: auto; /* 내용이 벗어나면 스크롤 표시 */
    background-color: aliceblue;
  }
  .sidebar {
    height: calc(100vh - 112px); /* 높이를 계산하여 112px 만큼 footer 공간 확보 */
    background-color: beige;
  }
  .pa-3 {
    background-color: blanchedalmond;
  }
}
</style>
