<template>

  <div class="text-center">
    <v-dialog
      v-model="dialog"
      width="auto"
    >
      <template v-slot:activator="{ props }">
        <v-btn
          color="primary"
          v-bind="props"
        >
          Dialog 열기
        </v-btn>
      </template>

      <v-card style="width: 100vh; height: 500px;">
        <v-card-text>
          Dialog에 띄울 내용
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" block @click="dialog = false">Dialog 닫기</v-btn>
        </v-card-actions>
      </v-card>
      
    </v-dialog>
  </div>

</template>

<script>
  export default {
    data () {
      return {
        dialog: false,
      }
    },
  }
</script>