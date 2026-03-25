<template>
  <button @click="current = 'first'">1번 버튼</button>
  <button @click="current = 'second'">2번 버튼</button>

  <!-- 자식 컴포넌트 -->
  <Child>
    <template v-if="current === 'first'" v-slot:default>
      <div style="background-color: red">AAAAA</div>
    </template>

    <template v-else v-slot:second>
      <div style="background-color: blue">BBBBB</div>
    </template>
  </Child>
</template>

<script>
import Child from '@/components/Child.vue';
export default {
  name: 'App',
  components: { Child },
  data() {
    return {
      current: 'first',
    };
  },
};
</script>
