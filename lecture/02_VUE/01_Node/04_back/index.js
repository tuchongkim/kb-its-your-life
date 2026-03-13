const express = require('express');
const app = express();
const port = 3000;

const cors = require('cors');
app.use(cors());

app.get('/', (req, resp) => {
  resp.send('WELCOME');
});

/* 요청ContentType이 x-www-form-urlencoded인 경우
요청의 body사용하고 싶다면 아래 함수를 사용하세요 */
app.use(express.urlencoded({ extended: true }));

app.post('/signup', (req, resp) => {
  console.log(req);
  resp.send('가입성공');
});

app.get('/product', (req, resp) => {
  let responseObj = [
    { prodNo: 'C001', prodName: '아메리카노', prodPrice: 1500 },
    { prodNo: 'C002', prodName: '아이스아메리카노', prodPrice: 1500 },
    { prodNo: 'C003', prodName: '라떼', prodPrice: 1500 },
  ];
  resp.json(responseObj);
});

app.listen(port, () => {
  console.log('3000번 포트에서 백엔드 서버 실행 중');
});
