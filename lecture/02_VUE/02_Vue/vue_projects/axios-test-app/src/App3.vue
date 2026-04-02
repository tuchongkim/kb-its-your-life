<script setup>
import axios from 'axios';

const requestAPI = async () => {
  const url = '/api/todos/1';
  const response = await axios.get(url);
  console.log('# 응답객체 : ', response);
};

requestAPI();
</script>

<template>
  <h1>You did it!</h1>
  <p>
    Visit
    <a href="https://vuejs.org/" target="_blank" rel="noopener">vuejs.org</a> to
    read the documentation
  </p>
</template>

<style scoped></style>
