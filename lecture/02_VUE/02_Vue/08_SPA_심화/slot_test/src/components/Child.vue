<template>
  <h1>Child컴포넌트입니다</h1>
  슬롯은 부모 컴포넌트에서 자식 컴포넌트로 템플릿을 전달하는 방법입니다. 슬롯의
  목적 : 자식 컴포넌트의 틀은 유지, 내용을 바꿀 수 있게 하는 것
  <hr />
  <slot> </slot>
  <hr />
  <slot name="second"></slot>
</template>

<script>
export default {
  name: 'Child',
};
</script>
