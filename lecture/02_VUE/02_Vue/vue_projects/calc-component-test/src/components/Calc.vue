<template>
  <div>
    X : <input type="text" v-model.number="x" /> <br />
    Y : <input type="text" v-model.number="y" /> <br />
  </div>
</template>

<script>
import { ref } from 'vue';
// 객체를 참조할 때 쓰는 용어: ref
// 반응형 데이터를 만드는 메서드: ref

export default {
  name: 'Calc',
  setup() {
    const x = ref(10);
    const y = ref(20);

    // 단순 데이터가 아니라 RefImpl(Reference Implementation, 레퍼런스 구현체)다
    console.log(x);
    console.log(y);

    return { x, y }; //중요한 부분
    // 무엇을 return 해야 하는가? -> template에서 사용할 것
    // 비즈니스 로직이 복잡해지면, 지역변수, 내부처리 함수 등 많아진다
    // 그 중에서 template에서 쓸 것들만 모아서 객체로 리턴한다
    // 마치 data() 함수에서 객체를 리턴하는 것과 비슷하다
  },
};
</script>
