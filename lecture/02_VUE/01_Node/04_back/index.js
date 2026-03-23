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
    { prodNo: 'C001', prodName: '아메리카노', prodPrice: 1500 },
    { prodNo: 'C002', prodName: '아이스아메리카노', prodPrice: 1500 },
    { prodNo: 'C003', prodName: '라떼', prodPrice: 1500 },
  ];
  resp.json(responseObj);
});

app.listen(port, () => {
  console.log('3000번 포트에서 백엔드 서버 실행 중');
});
