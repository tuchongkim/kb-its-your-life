import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0);
  const doubleCount = computed(() => count.value * 2);
  function increment() {
    count.value++;
  }

  // count를 직접 return하는 것은 비권장 -> 외부에서 값을 고칠 수 있기 때문에
  return { count, doubleCount, increment };
});
