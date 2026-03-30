<template>
  <div class="row">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          name="msg"
          placeholder="할일을 여기에 입력!"
          v-model.trim="newTodo"
          @keyup.enter="addTodoHandler"
        />
        <button class="btn btn-primary" @click="addTodoHandler">추가</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'InputTodo',
  data() {
    return {
      newTodo: '',
    };
  },
  methods: {
    addTodoHandler() {
      if (this.newTodo.length >= 3) {
        this.$emit('add-todo', this.newTodo);
        this.newTodo = '';
      }
    },
  },
};
</script>
