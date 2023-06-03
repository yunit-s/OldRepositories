<template>
  <v-card>
    <v-card-title>
      부모 컴포넌트
    </v-card-title>
    <v-card-text>
      <!-- 다른 컴포넌트 출력 -->
      <comp-on-comp-child>
        <template v-slot:default>
          <div>부모 컴포넌트에서 작성한 내용</div>
        </template>
      </comp-on-comp-child>
    </v-card-text>
  </v-card>
</template>

<script>
import CompOnCompChild from '../components/CompOnCompChild.vue';

export default {
  components: {
    CompOnCompChild
  }
};
</script>
