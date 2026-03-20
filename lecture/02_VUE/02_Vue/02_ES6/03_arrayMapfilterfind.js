//배열 선언방법
//1.
let users = [
  { id: 'id1', age: 14, name: '홍길동' },
  { id: 'id2', age: 22, name: '고길동' },
  { id: 'id3', age: 35, name: '홍길동' },
];

console.log(`2. Array.from() : 배열처럼 생긴 것을 진짜 배열로 바꾸기
  유사 배열객체(Array-like object)나 반복 가능한 객체(Iterable object)를 얕게 복사하여 새로운 Array 객체로 만들어주는 메서드`);
Array.from('Hello'); // ['H', 'e', 'l', 'l', 'o']
const arr1 = Array.from({ length: 5 }, (v, i) => i); // [0, 1, 2, 3, 4] 생성
console.log(`Array.from({ length: 5 }, (v, i) => i) : ${arr1}`);
const set = new Set(['foo', 'bar']);
const arr2 = Array.from(set); // ['foo', 'bar']
console.log(`new Set(['foo', 'bar']) : ${arr2}`);

//3. Array.of() : 나열된 값들로 배열 만들기
const arr3 = Array.of(1, 2, 3, 4);
console.log(`Array.of(1, 2, 3, 4) : ${arr3}`);
//---------------------------------------

console.log(`Array.map()는 항상 새 배열을 반환
필터 방식과 비교하여 원래 배열의 크기를 변경하지 안함
새 배열을 만들 때 항상 원래 배열의 값을 사용.`);
let over20Map = users.map((person) => {
  if (person.age > 20) {
    return `<h3 id="${person.id}">${person.age}</h3>`;
  }
});
console.log(over20Map); //[ undefined, '<h3 id="id2">22</h3>', '<h3 id="id3">35</h3>' ]

console.log(`Array.filter : map()과 달리 새 배열의 크기를 변경할 수 있다
조건에 만족하지 않으면 length가 0인 배열을 반환한다`);
const over20Filter = users.filter((person) => person.age > 20);
console.log(over20Filter);
//[ { id: 'id2', age: 22, name: '고길동' },  { id: 'id3', age: 35, name: '홍길동' }  ]

const under10Filter = users.filter((person) => person.age < 10);
console.log(under10Filter);
// 출력: []

console.log(
  'Array.find()로 조건을 충족하는 요소를 찾으면 특정 요소를 반환하고 즉시 루프를 종료합니다.조건에 만족하지 않으면 length가 0인 배열을 반환합니다.',
);
// find 메서드: age가 20 이상인 첫 번째 사용자 찾기
const over20Find = users.find((person) => person.age > 20); //빈배열
console.log(over20Find); // 조건을 만족하는 사람들을 필터링하여 배열 반환. 출력: {id: 'id2', age: 22, name: '고길동'}
const under10Find = users.filter((person) => person.age < 10);
console.log(under10Find); // 출력: []
