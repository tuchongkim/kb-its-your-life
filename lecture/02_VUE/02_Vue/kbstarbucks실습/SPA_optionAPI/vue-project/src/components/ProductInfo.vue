<!-- 상품 상세 페이지
// 요소들
상품번호: C0002
상품명: 아이스 아메리카노
가격: 1500
상세 정보: ~~~
수량: 1이 default, 증가/감소가 가능하도록
장바구니 담기 버튼

// 유의사항
이미지는 왼쪽에 배치, 오른쪽에는 위에 작성되어 있는 정보들을 나열
이미지는 백엔드에서 상품목록에 포함되어 가져온다

// 요구사항
1. 상품 목록에서 하나의 상품을 클릭하면 ProductInfo.vue가 보여질 것이다(아직 구현 x)
보여진다는 가정하에 구현.
2. Back URL을 요청한다 (/product/상품번호값 을 요청)
3. 응답 받은 내용을 <template>의 각 영역에 보여주기
응답 예시) {"prodNo": 'C0002', "prodName": '아이스아메리카노', "prodPrice": }
4. 상세 정보는 일반 예시 텍스트로 채운다
5. 장바구니 담기 버튼을 클릭하면 Back 서버에 전송한다
ex) url: '/cart', method: 'post', content-type: 'json', 전송내용: {"prodNo": 'C0002', "quantity": 1}
-->

<template>
  <div class="product-layout">
    <!-- 왼쪽: 이미지 -->
    <div class="product-image">
      <img :src="product.prodImage" :alt="product.prodName" />
    </div>

    <!-- 오른쪽: 상품 정보 -->
    <div class="product-detail">
      <p>상품번호: {{ product.prodNo }}</p>
      <p>상품명: {{ product.prodName }}</p>
      <p>가격: {{ product.prodPrice }}원</p>
      <p>
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Alias adipisci
        sapiente earum unde, saepe maiores dolores ipsa mollitia sit aliquid
        iste est at fugiat voluptatibus facilis! Architecto at qui asperiores?
      </p>

      <!-- 수량 조절 -->
      <div class="input-group" style="width: 150px">
        <input type="text" class="form-control text-center" :value="quantity" />
        <div class="dec-inc-grp">
          <button class="btn btn-sm btn-outline-secondary" @click="decreaseQty">
            -
          </button>
          <button class="btn btn-sm btn-outline-secondary" @click="increaseQty">
            +
          </button>
        </div>
      </div>

      <!-- 장바구니 담기 -->
      <button class="btn btn-outline-primary mt-3" @click="addToCart">
        장바구니 담기
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ProductInfo',
  props: {
    prodNo: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      product: {},
      quantity: 1,
    };
  },
  async mounted() {
    const url = `http://localhost:3000/product/${this.prodNo}`;
    const response = await fetch(url);
    this.product = await response.json();
  },
  methods: {
    increaseQty() {
      this.quantity++;
    },
    decreaseQty() {
      if (this.quantity > 1) {
        this.quantity--;
      }
    },
    async addToCart() {
      const url = 'http://localhost:3000/cart';
      const body = {
        prodNo: this.product.prodNo,
        quantity: this.quantity,
      };

      try {
        const response = await fetch(url, {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(body),
        });

        if (response.ok) {
          alert('장바구니에 담았습니다.');
        } else {
          alert('장바구니 담기에 실패했습니다.');
        }
      } catch (error) {
        alert('서버와 통신 중 오류가 발생했습니다.');
      }
    },
  },
};
</script>

<style scoped>
.product-layout {
  display: flex;
  gap: 30px;
  padding: 20px;
}

.product-image img {
  width: 300px;
}

.product-detail p {
  margin: 10px 0;
}

.dec-inc-grp {
  display: flex;
  flex-direction: column;
}

.quantity {
  display: flex;
  align-items: center;
  gap: 10px;
  margin: 10px 0;
}
</style>
