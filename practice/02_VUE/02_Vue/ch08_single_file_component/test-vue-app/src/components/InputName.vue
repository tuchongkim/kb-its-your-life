<template>
  <label for id="name">이름: </label>
  <input type="text" v-model="name" />
  <button @click="this.$emit('nameChanged', { name })">이벤트 발신</button>
</template>

<script>
export default {
  name: 'inputName',
  // emits: ['nameChanged1'], // nameChanged1 이외의 이벤트 발생시 경고창 출력
  emits: {
    nameChanged: (e) => {
      return e.name && typeof e.name === 'string' && e.name.trim().length >= 3
        ? true
        : false;
    },
  },
  data() {
    return {
      name: '',
    };
  },
};
</script>
