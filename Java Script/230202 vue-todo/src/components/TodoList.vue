<template>
    <!--
        section 태그
        내용을 표현하는 곳에 사용. 기능은 div와 동일하다.
    -->
    <section>
        <ul>
            <li v-for="(todoItem, index) in todoItems" :key="todoItem" class="shadow">
                <!--
                    index를 잡은 이유
                        ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ

                    key를 잡아둔 이유
                        ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
                -->

                <i class="checkBtn fa fa-check" aria-hidden="true"></i>
                {{ todoItem }}
                    <!-- @click은 v-on:click과 동일하게 동작합니다. 
                        추가적으로 @click="[method1(), method2()]" 와 같이 사용하면
                        클릭이벤트를 여러개 설정할 수 있습니다.
                    -->
                <span
                    class="removeBtn"
                    type="button"
                    @click="removeTodo(todoItem, index)"
                >
                    <i class="fa fa-trash" aria-hidden="true"></i>
                </span>
            </li>
        </ul>
    </section>
</template>

<script>
export default {
    props: {
        todoItems: Array
    },
    data() {
        return {
            // todoItems: []
        };
    },
    methods: {
        removeTodo(todoItem, index) {
            console.log('TodoList-removeTodo() 실행');
            localStorage.removeItem(todoItem);
            // splice() 함수는 JavaScript 내장 함수로, 특정 인덱스에서 부여한 숫자만큼의 인덱스를 삭제한다.
            this.todoItems.splice(index, 1);
        }
    },
    // created 사용처
    // ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
    created: function() {

    }
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}

.removeBtn {
  margin-left: auto;
  color: #de4343;
}
</style>