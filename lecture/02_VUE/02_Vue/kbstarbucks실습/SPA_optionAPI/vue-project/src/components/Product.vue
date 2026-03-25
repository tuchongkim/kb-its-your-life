<!-- script와 template의 위치는 중요하지 않다. -->

<template>
  <Search @searchProductEvent="searchProductHandler"></Search>
  <table>
    <thead>
      <tr>
        <td>이미지</td>
        <td>상품번호</td>
        <td>상품명</td>
        <td>상품가격</td>
      </tr>
    </thead>
    <!-- <tr v-for="p in product">
      <td></td>
      <td>{{ p.prodNo }}</td>
      <td>{{ p.prodName }}</td>
      <td>{{ p.prodPrice }}</td>
    </tr> -->
    <!-- 위의 tr태그와 똑같은 효과가 나도록 하위 컴포넌트 ProductItem을 완성하시오. -->
    <ProductItem
      v-for="p in product"
      :key="p.prodNo"
      v-bind:childProduct="p"
    ></ProductItem>
  </table>
</template>

<script>
import ProductItem from './ProductItem.vue';
import Search from './Search.vue';

export default {
  name: 'Product',
  components: { ProductItem, Search },
  async mounted() {
    // life-cycle용 특수 함수, methods와 별개로 작성
    this.product = await this.requestProduct();
  },
  data() {
    return {
      product: [],
    };
  },
  methods: {
    /**
     * 백엔드 서버에게 상품목록을 요청한다.
     */
    requestProduct() {
      const url = 'http://localhost:3000/product';
      return fetch(url).then((response) => {
        return response.json();
      });
    },
    searchProductHandler(e) {
      alert(e);
    },
  },
};
</script>
