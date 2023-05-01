<template>
  <v-footer class="bg-blue-grey-darken-3">

    <v-row justify="center" no-gutters>

      <v-col class="text-center" cols="12">
        <v-btn color="white" variant="text" class="mx-2" rounded="xl" @click="moveTo('/lumosprojectview')">Home</v-btn>
        <v-btn color="white" variant="text" class="mx-2" rounded="xl" @click="moveTo('/lumosprojectview/loginhomeview')">Login</v-btn>
      </v-col>

      <v-col class="text-center mt-4" cols="12">
        {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
      </v-col>
      
    </v-row>

  </v-footer>
</template>

<script>

export default {
  data: () => ({
    
  }),
  
  methods: {
    moveTo (url) {
      console.log('@@ moveTo(' + url + ')')
      this.$router.push(`${url}`);
    }
  }
}
</script>

<style scoped>

</style>