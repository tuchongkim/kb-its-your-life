<template>
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: {
    id: ['name', 'checked'],
    name: String,
    checked: {
      type: Boolean,
      required: false,
      default: false,
    },
  },
};
</script>
