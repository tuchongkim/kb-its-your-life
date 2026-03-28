<script setup>
// 무조건 컴포넌트 인스턴스 생성
// import CalcOptionAPI from './components/CalcOptionAPI.vue';
// import CalcCompositionAPI from './components/CalcCompositionAPI.vue';
// import CalcCompositionAPI_scriptsetup from './components/CalcCompositionAPI_scriptsetup.vue';

// 비동기 컴포넌트 인스턴스 생성
import { defineAsyncComponent } from 'vue';
const CalcOptionAPI = defineAsyncComponent(() =>
  import('./components/CalcOptionAPI.vue')
);
const CalcCompositionAPI = defineAsyncComponent(() =>
  import('./components/CalcCompositionAPI.vue')
);
const CalcCompositionAPI_scriptsetup = defineAsyncComponent(() =>
  import('./components/CalcCompositionAPI_scriptsetup.vue')
);
</script>

<template>
  <main>
    <!-- <CalcOptionAPI></CalcOptionAPI> -->
    <!-- <CalcCompositionAPI></CalcCompositionAPI> -->
    <CalcCompositionAPI_scriptsetup></CalcCompositionAPI_scriptsetup>
  </main>
</template>
