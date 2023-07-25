<template>
    <div class="clearAllContainer">
        <span class="clearAllBtn" @click="clearTodo">모두 삭제</span>
    </div>
</template>

<script>
export default {
    props: {
        todoItems: Array
    },
    methods: {
        clearTodo() {
            localStorage.clear();
            this.todoItems.splice(0);
        }
    }
}
</script>

<style scoped>
.clearAllContainer {
  width: 8.5rem;
  height: 50px;
  line-height: 50px;
  background-color: white;
  border-radius: 5px;
  margin: 0 auto;
}

.clearAllBtn {
  color: #e20303;
  display: block;
}
</style>