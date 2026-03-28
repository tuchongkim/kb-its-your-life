<template>
  <!-- TODO 1. composition api로 data옵션과 이벤트 처리용 메서드로 구성합니다-->
  <div>
    <h1>Composition API</h1>
    <h2>환율 계산기 (이벤트 처리용 메서드)</h2>
    <h3>{{ rate1 }} 대한민국 원</h3>
    <div></div>
    <input type="text" v-model.number="usd1" @keyup="calcToKrW" /><span
      >미국 달러</span
    ><br />
    <input type="text" v-model.number="krw1" @keyup="calcToUsD" /><span
      >대한민국 원</span
    ><br />
  </div>

  <!-- TODO 2. option api로 data옵션과 computed로 구성합니다-->
  <div style="margin-top: 20px">
    <h2>환율 계산기 (computed)</h2>
    <h3>{{ rate2 }} 대한민국 원</h3>
    <div></div>
    <input type="text" v-model.number="usd2" /><span>미국 달러</span><br />
    <input type="text" v-model.number="krw2" /><span>대한민국 원</span><br />
  </div>
</template>

<script>
import { ref, computed } from 'vue';

export default {
  name: 'Calc',
  setup() {
    const rate1 = 1509.13;
    const usd1 = ref(1);
    const krw1 = ref(1);

    const rate2 = 1509.13;
    const usd2 = ref(1);

    // 이벤트 기반 계산
    const calcToKrW = (e) => {
      krw1.value = Math.round(e.target.value * rate1 * 100) / 100;
    };

    const calcToUsD = (e) => {
      usd1.value = Math.round(e.target.value * rate1 * 10000) / 10000;
    };

    // 양방향 computed
    const krw2 = computed({
      get() {
        console.log(
          `krw2 값을 사용(usd2 -> krw2로 계산)할 때 get호출됨
            ex:
            <input v-model.number="krw2" /> 또는
            console.log(krw2.value);`
        );
        return Math.round(usd2.value * rate2 * 100) / 100;
      },
      set(value) {
        console.log('krw2에 값을 대입(krw2 -> usd2로 계산)할 때 호출됨');
        usd2.value = Math.round((value / rate2) * 100000) / 100000;
      },
    });

    return { usd1, krw1, rate1, calcToKrW, calcToUsD, rate2, usd2, krw2 };
  },
};
</script>
