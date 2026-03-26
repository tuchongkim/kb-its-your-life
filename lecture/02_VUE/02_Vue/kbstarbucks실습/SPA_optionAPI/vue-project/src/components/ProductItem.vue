<template>
  <tr>
    <td></td>
    <td>{{ childProduct.prodNo }}</td>
    <td>{{ childProduct.prodName }}</td>
    <td>{{ childProduct.prodPrice }}</td>
  </tr>
</template>

<script>
export default {
  name: 'ProductItem',
  props: {
    childProduct: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
tr:hover {
  filter: invert(1);
}
</style>
