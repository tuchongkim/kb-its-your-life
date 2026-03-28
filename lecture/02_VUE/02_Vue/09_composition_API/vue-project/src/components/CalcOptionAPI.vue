<template>
  <!-- TODO 1. composition api로 data옵션과 이벤트 처리용 메서드로 구성합니다-->
  <div>
    <h1>Option API</h1>
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
export default {
  name: 'Calc',

  data() {
    return {
      // TODO 1 (이벤트 방식)
      rate1: 1509.13,
      usd1: 1,
      krw1: 1,

      // TODO 2 (computed 방식)
      rate2: 1509.13,
      usd2: 1,
    };
  },

  methods: {
    // 이벤트 기반 계산
    calcToKrW(e) {
      this.krw1 = Math.round(e.target.value * this.rate1 * 100) / 100;
    },

    calcToUsD(e) {
      this.usd1 = Math.round((e.target.value / this.rate1) * 100000) / 100000;
    },
  },

  //TODO 2. 계산된 속성 중  getter/ setter가 있는 양방향 computed입니다
  computed: {
    // 양방향 computed
    krw2: {
      get() {
        console.log(
          `krw2 값을 사용(usd2 -> krw2로 계산)할 때 get호출됨
            ex: 
            <input v-model.number="krw2" /> 또는 
            console.log(krw2.value);`
        );
        return Math.round(this.usd2 * this.rate2 * 100) / 100;
      },

      set(value) {
        console.log('krw2에 값을 대입(krw2 -> usd2로 계산)할 때 호출됨');
        this.usd2 = Math.round((value / this.rate2) * 100000) / 100000;
      },
    },
  },
};
</script>
