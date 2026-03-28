const express = require('express');
const path = require('path');
const app = express();
const port = 3000;

// 'public' 폴더를 정적 파일 폴더로 지정합니다.
app.use('/static', express.static(path.join(__dirname, 'public')));
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
  resp.json(responseObj); //js배열 -> json문자열로 변환되어 응답
});

app.get('/product/:prodNo', (req, resp) => {
  let responseObj = {};
  console.log(req.params.prodNo);
  switch (req.params.prodNo) {
    case 'C0002':
      responseObj = {
        prodNo: 'C0002',
        prodName: '아이스아메리카노',
        prodPrice: 1500,
        img: 'C0002.jpg',
      };
      break;
    case 'C0001':
      responseObj = {
        prodNo: 'C0001',
        prodName: '아메리카노',
        prodPrice: 1500,
        img: 'C0001.jpg',
      };
      break;
    default:
      responseObj = {
        prodNo: '',
        prodName: '없는 상품',
        prodPrice: 0,
        img: 'empty-64.jpg',
      };
  }
  resp.json(responseObj);
});
app.listen(port, () => {
  console.log('3000번 포트에서 백엔드 서버 실행 중');
});
