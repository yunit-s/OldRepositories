<template>
    <div>
        <input type="text" placeholder="할 일을 입력하세요" v-model="newTodoItem"
            v-on:keyup.enter="addTodo">
            <!--
                placeholder : 입력상자에 넣을 수 있는 hint 출력
                v-on:keyup="" : 키보드를 눌렀을 때
                v-on:keydown="" : 키보드를 뗐을 때
                v-on:press="" : 키보드를 눌렀다 뗐을 때
                v-on:keyup.enter="" : enter 키를 눌렀을 때
            -->

        <!--
            이벤트 처리하기
                v-on 방식
                @ 방식
                    비슷하긴 한데 좀 다르다.
                    한 번에 여러 메소드를 실행시킬 수도 있음.
        -->
        <!-- <button v-on:click="addTodo">추가</button> -->
        <!-- <button @click="addTodo">추가</button> -->
        <!-- 한 번에 여러 메소드 실행시키기 -->
        <!-- <button @click="[addTodo(), callTestFunc()]">추가</button> -->

        <!-- 디자인된 아이콘으로 구현 -->
        <span class="addContainer" v-on:click="addTodo">
            <i class="addBtn fa fa-plus" aria-hidden="true"></i>
        </span>
    </div>
</template>

<script>
export default {
    props: {
        todoItems: Array
    },
    data() {
        return {
            newTodoItem: ''
        }
    },
    methods: {
        addTodo: function() {
            console.log('TodoInput-addTodo() 실행');
            // 현재 입력한 할 일 목록 저장하기
            // 지금은 서버 프로그램에 연결을 할 수 없다.
            // 서버쪽 데이터베이스에 해당 정보를 저장할 수 없다.
            // 그래서 browser가 가지고 있는 저장 장소를 이용할 예정
            // browser 내부 저장장소 2가지
            //      Storage (우리는 이거 사용)
            //          LocalStorage (우리는 이거 사용)
            //          SessionStorage
            //      IndexedDB
            // LocalStorage
            //      가장 일반적인 방법
            //      데이터는 Map 형태로 저장 가능하다.(key, value 쌍)
            //      여러 프로그램에 의해 데이터가 중복되는 것을 방지하기 위해,
            //      각각의 데이터는 domain으로 구분되어 저장된다.
            // 저장된 데이터를 확인하는 방법
            //      browser - f12 - Application
            //          - Storage - Local Storage - http://localhost:8080/
            // 특징
            //      보안성이 없다.
            //      우리가 직접 지울 수도 있고, 바꿀 수도 있다.
            //      여기서 id나 pw를 처리하면 문제가 생길 수 있다.

            if (this.newTodoItem !== "") {
                // 입력칸에 공백이 아닐 때만 값을 저장하자

                // localStorage : 이미 내부에 선언되어 있는 키워드
                // localStorage.setItem('키값', '변수값');
                localStorage.setItem(this.newTodoItem, this.newTodoItem);
                this.todoItems.push(this.newTodoItem);
                this.newTodoItem = ""; // 입력상자 초기화하기

                // // 이벤트 발생
                // console.log('emit으로 이벤트 발생');
                // this.$emit('emitAddTodo', newTodoItem);
            }
        },
        callTestFunc() {
            console.log('callTestFunc() 실행');
        }
    }
}
</script>

<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478fb, #8763fb);
  display: inline-block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>