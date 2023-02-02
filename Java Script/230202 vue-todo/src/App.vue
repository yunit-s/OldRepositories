<template>
  <div id="app">
    <TodoHeader></TodoHeader>
    <TodoInput v-on:emitAddTodo="occurAddTodo" v-bind:todoItems="todoItems"></TodoInput>
      <!--
        v-on
          : 하위 컴포넌트 TodoInput에서 emitAddTodo 이벤트가 발생하면,
          occurAddTodo 메소드를 실행한다.
        v-bind:(자식컴포넌트 props이름)="부모컴포넌트 data이름"
          : props를 통해 상위 컴포넌트에서 하위 컴포넌트로 데이터 전달
      -->
    <TodoList v-bind:todoItems="todoItems"></TodoList>
    <TodoFooter v-bind:todoItems="todoItems"></TodoFooter>

    <!-- <p>App.vue 컨텐츠</p> -->
  </div>
</template>

<script>
// 이 부분(export의 바깥 부분)이 root 컴포넌트가 된다.
//    외부 .vue 파일에 있던 자료를 가져와서 특정 이름으로 객체화시키기
import TodoHeader from "./components/TodoHeader.vue"; // TodoHeader.vue 객체를 TodoHeader라는 이름으로 활용하겠다는 의미
import TodoInput from "./components/TodoInput.vue";
import TodoList from "./components/TodoList.vue";
import TodoFooter from "./components/TodoFooter.vue";

export default {
  // 여기는 root가 아니라 일반 component로 취급된다.
  components: {
    TodoHeader, // TodoHeader: TodoHeader 의 축약형 구문
    TodoInput,
    TodoList,
    TodoFooter,
  },
  // 일반적인 data 표현 문법
  // data: function() { return {} }
  // data 표현의 축약형
  data() {
    return {
      // newTodoItem: ''
      todoItems: []
    };
  },
  created: function() {
    console.log('App.vue의 created() 실행');
    console.log(this.todoItems);
        // localStorage에서 데이터를 가져와서 todoItems에 넣기
        for (let i = 0; i < localStorage.length; i++) {
            // localStorage에 이상한 데이터가 하나 있다.
            //      loglevel:webpack-dev-server
            //      이 데이터는 시스템이 추가해두는 거라서, 예외처리로 빼줘야만 한다.
            if(localStorage.key(i) !== 'loglevel:webpack-dev-server') {
                this.todoItems.push(localStorage.key(i)); // 순차적으로 key값 가져오기
            }
        }
  },
  methods: {
    occurAddTodo: function(param) {
      console.log('occurAddTodo() 실행');
      console.log(param);
      this.newTodoItem = param;
    }
  }
};
</script>

<style>
body {
  text-align: center;
  background-color: #f6f6f8;
}

input {
  border-style: groove;
  width: 200px;
}

button {
  border-style: groove;
}

.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}
</style>
