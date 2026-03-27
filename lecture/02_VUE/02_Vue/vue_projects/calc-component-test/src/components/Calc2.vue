<template>
  <div>
    X : <input type="text" v-model.nubmer="x" /> <br />
    Y : <input type="text" v-model.nubmer="y" /> <br />
  </div>
  <button @click="calcAdd">계산</button><br />
  <div>결과 : {{ result }}</div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'Calc2',
  setup() {
    // 초기값 할당
    // 모든 것을 const로 선언하는 이유? -> 많이하는 실수 방지 (x=2)
    // let을 써도 괜찮긴 하지면 비권장이다 (실수의 가능성)
    const x = ref(10);
    const y = ref(20);
    const result = ref(x.value + y.value);

    // 이벤트 핸들러
    const calcAdd = () => {
      // 내부 함수에서 외부함수의 지역변수 접근 (cf.클로저)
      result.value = x.value + y.value;
    };

    // 잊지말고 return 객체에 template에서 필요한 것들을 넣어줘야 한다.
    // 내부함수를 return이 되고, 내부함수에서 x.value, y.value를 사용하고 있다 (closure)
    // x.value, y.value 모두 클로저에 있다.
    // setup() 함수가 끝나도 calcAdd()로 인해 클로저 내부에 변수들이 존재한다
    // this가 필요없는 이유다
    return { x, y, result, calcAdd };
  },
};
</script>
