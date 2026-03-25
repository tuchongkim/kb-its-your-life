<template>
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: ['name', 'checked'],
  //   data() {
  //     return {
  //       checked: false,
  //     };
  //   },
};
</script>
