<template>
  <h1>App.vue</h1>
  <!-- <div>
    <Product></Product>
  </div> -->

  <header class="container-fluid sticky-top">
    <nav
      class="navbar navbar-expand-sm bg-white navbar-light align-items-center"
    >
      <a class="navbar-brand d-flex align-items-center" href="#">
        <!-- <img src="./images/logo-75.png" alt="로고" height="75" /> -->
        <img v-bind:src="logo" alt="로고" height="75" />
      </a>

      <!-- 햄버거 버튼 
         class="navbar-toggler"(버튼의 디자인 : 화면이 넓을 때는 숨겨져 있다가, 설정한 지점(예: navbar-expand-sm)보다 화면이 작아지면 나타납니다.) 
         data-bs-toggle="collapse"(클릭했을때의 동작 방식)
        data-bs-target="#collapsibleNavbar" (동작 대상)
         -->
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#collapsibleNavbar"
      >
        <!-- 버튼 안에 들어갈 세 줄 모양 아이콘 -->
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- 
.collapse만 쓰면: 메뉴가 숨겨지긴 하지만, 큰 화면에서도 계속 숨겨져 있습니다.
.navbar-collapse만 쓰면: 메뉴의 모양은 잡히지만, 모바일에서 버튼을 눌렀을 때 부드럽게 열리고 닫히는 애니메이션 동작이 일어나지 않습니다.

navbar-collapse : 반응형 숨기기: 작은 화면(모바일)에서는 메뉴를 자동으로 숨기고, 설정된 지점(예: .navbar-expand-sm인 경우 576px 이상)이 되면 메뉴를 가로로 펼쳐서 보여줍니다.
트랜지션 효과: 햄버거 버튼을 눌렀을 때 메뉴가 부드럽게 아래로 내려오거나 올라가는 애니메이션(Collapse/Expand)을 담당합니다.
그룹화: 로고를 제외한 모든 메뉴 항목(로그인, 가입 등)을 하나의 덩어리로 묶어, 모바일에서 한꺼번에 토글(Toggle)되도록 합니다-->
      <div
        class="collapse navbar-collapse justify-content-end"
        id="collapsibleNavbar"
      >
        <!--navbar-nav:  메뉴 항목들을 가로(데스크톱) 또는 세로(모바일)로 정렬할 수 있게 Flexbox 모델을 적용합니다          
          -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link px-3 text-nowrap" href="#">
              <i class="fa-solid fa-lock-open"></i>로그인</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link px-3 text-nowrap" href="#"
              ><i class="fa-solid fa-user-plus"></i>가입</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link px-3 text-nowrap" href="#"
              ><i class="fa-solid fa-mug-saucer"></i>상품</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link px-3 text-nowrap" href="#"
              ><i class="fa-solid fa-cart-shopping"></i>장바구니</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link px-3 text-nowrap" href="#"
              ><i class="fa-solid fa-list"></i>주문</a
            >
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- d-flex : 두 요소를 가로로 나란히 세웁니다.-->
  <main class="main-container">
    <section class="main-container__content overflow-auto">
      <!-- 내용이 많아지면 이곳에 스크롤이 생깁니다 -->
      <h2>본문 내용</h2>

      <!-- 상품 목록 -->
      <Product></Product>

      <!-- 상품 상세 -->
      <!-- <ProductInfo></ProductInfo> -->
    </section>

    <!-- shrink-0 : flex에서 이 요소의 크기를 절대 줄이지 마라-->
    <aside class="main-container__sidebar shrink-0">
      <h3>사이드바 (20%)</h3>
    </aside>
  </main>

  <footer class="footer">
    <p>
      사업자등록번호 : 201-81-21515 주식회사 에스씨케이컴퍼니 대표이사 : 손정현
      TEL : 1522-3232 개인정보 보호책임자 : 이찬우 ⓒ 2026 Starbucks Coffee
      Company. All Rights Reserved
    </p>
  </footer>
</template>
<script>
import Product from '@/components/Product.vue';
import logo from '@/assets/images/starbucks_logo.png';
import ProductInfo from './components/ProductInfo.vue';
export default {
  name: 'App',
  components: { Product, ProductInfo },
  data() {
    return {
      logo: logo,
    };
  },
};
</script>
<style>
/*
      BEM 구조 
      */
* {
  box-sizing: border-box;
}
/* 전체 레이아웃 구성을 위한 설정 */
/* body { */
#app {
  margin: 0;
  display: flex;
  flex-direction: column; /* 세로배치 */
  height: 100vh; /* 화면 전체 높이 사용 */
}

/* 마우스 호버 시 색상 반전 */
/* .header__menu-link:hover { */
.nav-link:hover {
  background-color: #333; /* 배경 검정 (또는 포인트 컬러) */
  color: #fff; /* 글자 흰색 */
  border-radius: 0.375rem;
}

/* 2. 메인 컨테이너 (section + aside) */
.main-container {
  background-color: red;

  width: 100%;
  display: flex;
  flex: 1; /* 헤더와 푸터를 제외한 나머지 공간 모두 차지 */
  overflow: hidden; /* 자식인 section에서만 스크롤이 발생하도록 제한 */
}
/* 2-1. section 본문 (자동 스크롤) */
.main-container__content {
  /*flex: 1;*/ /* aside(20%)를 제외한 나머지 80% 차지 */
  flex: 4;
  overflow-y: auto; /* 내용이 많으면 자동으로 세로 스크롤 생성 */
  padding: 0px;
  background-color: #f9f9f9;
}

/* 2-2. aside 사이드바 (오른쪽 20%) */
.main-container__sidebar {
  /* width: 20%; */ /*20% 너비 고정 */
  flex: 1;
  padding: 0px;
  margin: 0px;
  background-color: #eee;
  border-left: 1px solid #ddd;
}

/* 3. 푸터 (최대 높이 50px) */
.footer {
  max-height: 50px;
  /*height: 100%;*/ /* 내용에 따라 늘어나되 50px까지만 */
  padding: 0 20px;
  background-color: #333;
  color: #fff;
  text-align: center;
}
</style>
