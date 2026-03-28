<!-- script와 template의 위치는 중요하지 않다. -->

<template>
  <Search @searchProductEvent="searchProductHandler"></Search>
  <table class="table table-hover w-50">
    <!-- w-50 : 부모 영역의 50퍼센트만 사용 -->
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
      v-for="p in pagedProduct"
      :key="p.prodNo"
      v-bind:childProduct="p"
    ></ProductItem>
  </table>
  <div class="container-fluid">
    <ul class="pagination">
      <li class="page-item">
        <span class="page-link" href="#">Previous</span>
      </li>
      <li class="page-item"><span class="page-link" href="#">4</span></li>
      <li class="page-item"><span class="page-link" href="#">5</span></li>
      <li class="page-item"><span class="page-link" href="#">6</span></li>
      <li class="page-item"><span class="page-link" href="#">Next</span></li>
    </ul>
  </div>
</template>

<script setup>
import { computed, onMounted, reactive, ref } from 'vue';
import ProductItem from './ProductItem.vue';
import Search from './Search.vue';

const state = reactive({ product: [] });
const currentPage = ref(1);
const pageSize = ref(5);

onMounted(async () => {
  state.product = await requestProduct();
});

const pagedProduct = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  return state.product.slice(start, start + pageSize.value);
});

async function requestProduct() {
  const url = 'http://localhost:3000/product';
  return fetch(url).then((response) => {
    return response.json();
  });
}

function searchProductHandler(e) {
  alert(e);
}
</script>
