<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    Y : <input type="text" v-model.number="state.y" /> <br />
  </div>
  <button @click="calcAdd">계산</button><br />
  <div>결과 : {{ state.result }}</div>
</template>

<script>
import { reactive } from 'vue';

export default {
  name: 'Calc3',
  setup() {
    const state = reactive({ x: 10, y: 20, result: 30 });

    const calcAdd = () => {
      //객체 자체를 수정하는 것이 아니고, 객체의 멤버를 수정하는 것
      //그럼에도 Vue에서는 변화를 감지하고 렌더링한다.
      state.result = state.x + state.y;
    };

    return { state, calcAdd };
  },
};
</script>
