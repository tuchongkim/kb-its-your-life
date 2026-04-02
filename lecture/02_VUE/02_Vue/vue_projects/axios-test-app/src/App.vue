<script setup>
import axios from 'axios';

const requestAPI = () => {
  // const url = 'http://localhost:3000/todos/10';
  const url = 'api/todos/1'; //frontend,backend서버가 동일=>origin
  //웹브라우저에서 JS는 통신에 제약이 있다 => HTML파일을 보내준 해당 서버와는 통신 가능(나머지는 불가)
  //예를들어 3000번 포트로부터 데이터를 받았다면, 3001번 포트로부터는 데이터를 받을 수 없다
  //따라서 서버 측에서 설정을 해줘야 한다(Cross-Origin)

  axios.get(url).then((response) => {
    console.log('# 응답객체 : ', response);
    console.log(typeof response.data);
  });
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
