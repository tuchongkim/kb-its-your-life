<template>
  <div>
    <input
      type="text"
      placeholder="검색할 상품명을 입력하세요"
      v-model="word"
      @keyup.enter="search"
    />
    <button @click="search">검색</button>
  </div>
</template>
<script setup>
import { ref } from 'vue';

const word = ref('');
const emit = defineEmits(['searchProductEvent']);

function search() {
  //word에 해당하는 이름을 포함한 상품을 검색한다
  const eventValue = word.value + '상품을 검색했습니다';
  emit('searchProductEvent', eventValue); //이벤트 강제발생
}
</script>
