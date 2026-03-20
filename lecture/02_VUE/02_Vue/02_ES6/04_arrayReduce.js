const arr = [20, 30, 10];
let total = 0; //합
arr.forEach((value, index, array) => {
  total += value;
  console.log(`[${index}]값은 ${value}, 합은${total}`);
});
console.log(`forEach()이용한 20, 30, 10 합은 ${total}`);
console.log('---------------------');

let result = arr.reduce((previousValue, currentValue, currentIndex, array) => {
  previousValue += currentValue;
  console.log(`[${currentIndex}]값은 ${currentValue}, 합은${previousValue}`);
  return previousValue;
}); //If you don’t pass in an initial value, reduce will assume the first item in your array is your initial value
console.log(`초기값없이 reduce()이용한 20, 30, 10 합은 ${result}`);
console.log('---------------------');

let initialValue = 0;
result = arr.reduce((previousValue, currentValue, currentIndex, array) => {
  previousValue += currentValue;
  console.log(`[${currentIndex}]값은 ${currentValue}, 합은${previousValue}`);
  return previousValue;
}, initialValue);
console.log(`초기값있는 reduce()이용한 20, 30, 10 합은 ${result}`);
console.log('---------------------');

const staffs = [
  { name: 'Susan', age: 14, salary: 10 },
  { name: 'Daniel', age: 16, salary: 20 },
  { name: 'Bruno', age: 56, salary: 30 },
  { name: 'Jacob', age: 15, salary: 40 },
  { name: 'Sam', age: 64, salary: 50 },
  { name: 'Dave', age: 56, salary: 60 },
  { name: 'Neils', age: 65, salary: 70 },
];
let totalSalary = 0;
let avg = 0;
staffs.forEach((staff, index, array) => {
  totalSalary += staff.salary;
  if (index == array.length - 1) {
    avg = totalSalary / array.length;
  }
});
console.log(`forEach()이용한 총급여 ${totalSalary}, 평균급여 ${avg}`); //총급여 280, 평균:40
console.log('---------------------');

const callback = (previousValue, currentValue, currentIndex, array) => {
  result.total += currentValue.salary;
  if (currentIndex == array.length - 1) {
    previousValue.avg = previousValue.total / array.length;
  }
  return previousValue;
};
console.log(`초기값없이 reduce()이용한 총급여와 평균`);
const reduceResult1 = staffs.reduce(callback); //콜백함수, result 초기값
console.log(`총급여 ${reduceResult1.total}, 평균:${reduceResult1.avg}`); //총급여 NaN, 평균:NaN
console.log('---------------------');

console.log(`초기값있는 reduce()이용한 총급여와 평균`);
const reduceResult2 = staffs.reduce(callback, { total: 0, avg: 0 }); //콜백함수, result 초기값
console.log(` 총급여 ${reduceResult2.total}, 평균:${reduceResult2.avg}`); //총급여 280, 평균:40
console.log('---------------------');

function increment(input) {
  return input + 1;
}
function decrement(input) {
  return input - 1;
}
function double(input) {
  return input * 2;
}
function halve(input) {
  return input / 2;
}

console.log(`((10+1)*2)-1)는 `);
let pipelineResult = 10;
pipelineResultInc = increment(pipelineResult);
pipelineResultDob = double(pipelineResultInc);
pipelineResultDec = decrement(pipelineResultDob);
console.log(`${pipelineResultDec}`);

console.log(`reduce()이용한 ((10+1)*2)-1)는 `);
let pipeline = [increment, double, decrement];
let pipelineResult1 = pipeline.reduce((result, func) => {
  return func(result);
}, 10);
console.log(`${pipelineResult1}`);

/*
순회 횟수 감소 (Performance)
filter().map() 체이닝은 배열을 두 번 순회하며, 중간에 필터링된 새로운 임시 배열을 생성합니다.
reduce()는 단 한 번의 순회로 조건 검사(필터)와 값 변환(맵)을 동시에 처리하여 대용량 데이터 처리 시 성능이 더 우수합니다.
메모리 효율성
중간 단계에서 생성되는 가짜 배열(intermediate array)이 없으므로 가비지 컬렉션의 부담을 줄일 수 있습니다.
*/
const numbers = [2, 8, 4, 10, 3];
/*
const result = numbers
  .filter((n) => n > 5) // [8, 10] 생성
  .map((n) => n * 2); // [16, 20] 생성
*/

const reduceResult3 = numbers.reduce((previousValue, currentValue) => {
//   console.log(previousValue); [], [], [16], [16], [16, 20], [16, 20]
  if (currentValue > 5) {
    previousValue.push(currentValue * 2); // 조건(filter)과 변환(map)을 한 번에!
  }
  return previousValue;
}, []); // 초기값으로 빈 배열 설정
console.log(reduceResult3);
