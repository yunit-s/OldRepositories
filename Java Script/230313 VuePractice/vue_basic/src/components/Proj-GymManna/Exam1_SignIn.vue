<template>
  <div class="exam1_signin">
    <h3>Exam1_SignIn.vue 출력</h3>
    <button @click="login()">login()</button> |
    <button @click="register()">register()</button> |
    <button @click="func()">func()</button> |
    <button @click="func()">func()</button>

    <br><br>
    <div> <span>ID : </span> <input type="text" placeholder="ID" v-model="id"> </div>
    <div> <span>PW : </span> <input type="password" placeholder="password" v-model="pw"> </div>
    <div> <span>name : </span> <input type="text" placeholder="name" v-model="name"> </div>
    <div> <span>phone : </span> <input type="text" placeholder="phone" v-model="phone"> </div>
    <div> <span>nickname : </span> <input type="text" placeholder="nickname" v-model="nickname"> </div>

  </div>
</template>

<script src="./js/Exam1_SignIn.js"></script>
<script>

</script>

<style lang="scss">
</style>