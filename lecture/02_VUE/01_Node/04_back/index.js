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

/* 요청ContentType이 json인 경우
요청의 body사용하고 싶다면 아래 함수를 사용하세요 */
app.use(express.json());

// // 요청 URL 예) http://localhost:3000/iddupchk?id=1
// app.get('/iddupchk', (req, resp) => {
//   if (req.query?.id === 'admin') {
//     resp.status(400).send();
//     //resp.send('이미 존재하는 아이디입니다');
//   } else {
//     resp.status(200).send();
//     //resp.send('사용 가능한 아이디입니다');
//   }
// });

// 요청 URL 예) http://localhost:3000/iddupchk/1
app.get('/iddupchk/:id', (req, resp) => {
  // :id -> path variable
  console.log(req.params.id);
  if (req.params.id === 'admin') {
    resp.status(400).send();
  } else {
    resp.sendStatus(200);
  }
});

app.post('/signup', (req, resp) => {
  console.log(req.body);
  const person = req.body;

  resp.send(person.id + '가입성공');
});

app.get('/product', (req, resp) => {
  let responseObj = [
    {
      prodNo: 'C0001',
      prodName: '아메리카노',
      prodPrice: 1500,
      img: 'C0001.jpg',
    },
    {
      prodNo: 'C0002',
      prodName: '아이스아메리카노',
      prodPrice: 1500,
      img: 'C0002.jpg',
    },
    { prodNo: 'C0003', prodName: '라테', prodPrice: 2000, img: 'C0003.jpg' },
    {
      prodNo: 'C0004',
      prodName: '아이스라테',
      prodPrice: 2000,
      img: 'C0004.jpg',
    },
    {
      prodNo: 'C0005',
      prodName: '콜드브루몰트',
      prodPrice: 2500,
      img: 'C0005.jpg',
    },
    {
      prodNo: 'C0006',
      prodName: '카페브레베',
      prodPrice: 3500,
      img: 'C0006.jpg',
    },
    {
      prodNo: 'C0007',
      prodName: '바닐라라떼',
      prodPrice: 3500,
      img: 'C0007.jpg',
    },
  ];
  resp.json(responseObj);
});

app.get('/product/:prodNo', (req, resp) => {
  console.log(req.params.prodNo);
  let responseObj = [
    {
      prodNo: 'C0001',
      prodName: '아메리카노',
      prodPrice: 1500,
      img: 'C0001.jpg',
    },
    {
      prodNo: 'C0002',
      prodName: '아이스아메리카노',
      prodPrice: 1500,
      img: 'C0002.jpg',
    },
    { prodNo: 'C0003', prodName: '라테', prodPrice: 2000, img: 'C0003.jpg' },
    {
      prodNo: 'C0004',
      prodName: '아이스라테',
      prodPrice: 2000,
      img: 'C0004.jpg',
    },
    {
      prodNo: 'C0005',
      prodName: '콜드브루몰트',
      prodPrice: 2500,
      img: 'C0005.jpg',
    },
    {
      prodNo: 'C0006',
      prodName: '카페브레베',
      prodPrice: 3500,
      img: 'C0006.jpg',
    },
    {
      prodNo: 'C0007',
      prodName: '바닐라라떼',
      prodPrice: 3500,
      img: 'C0007.jpg',
    },
  ];
  for (product of responseObj) {
    if (product.prodNo === req.params.prodNo) {
      resp.json(product);
    }
  }
  resp.status(400).send();
});

app.post('/cart', (req, resp) => {
  console.log(req.body);
  resp.status(200).send();
});

app.listen(port, () => {
  console.log('3000번 포트에서 백엔드 서버 실행 중');
});
