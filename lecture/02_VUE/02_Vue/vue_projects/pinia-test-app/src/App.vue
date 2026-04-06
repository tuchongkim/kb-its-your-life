<script setup>
import { useCounterStore } from '@/stores/counter.js';
import { ref, computed } from 'vue';
import { useTodoListStore } from '@/stores/todoList.js';

const todo = ref('');

const todoListStore = useTodoListStore();
// todoList는 참조형 변수이기 때문에, 구조 분해 할당으로 받더라도 반응성이 유지된다
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;
const doneCount = computed(() => todoListStore.doneCount); //기본 타입에 대해서는 계산된 속성을 다시 작성

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};

/*
const { increment } = useCounterStore();
const store = useCounterStore();
const doubleCount = computed(() => store.doubleCount);
// action 함수는 구조 분해 할당으로 받을 수 있다
// 문제가 되는 건 상태 데이터
//  - 반응성을 잃어버리게 된다
//  - 값이 그냥 복사가 되기 때문
//  - 둘 다 그냥 number 타입이 된다

// console.log(store);
// console.log(store.count);
// store.count = 10;
*/
</script>

<!-- <template>
  count: {{ store.count }}<br />
  doubleCount: {{ doubleCount }} <br />
  <button @click="increment">increment</button>
</template> -->

<template>
  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />
    할일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>
