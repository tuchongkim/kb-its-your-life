//배열 및 객체 분해
const fruits = ['Mango', 'Pineapple', 'Orange', 'Lemon', 'Apple'];
const [f1, f2, f3] = fruits;
console.log(f1, f2, f3); //Mango Pineapple Orange
//일부 반환값 무시하기
const [, , , f4, f5] = fruits;
console.log(f4, f5); //Lemon Apple

const Susan = {
  firstName: 'Susan',
  lastName: 'Steward',
  age: 14,
  hobbies: ['singing', 'dancing'],
  contact: {
    phone: 114,
    email: 'a@b.com',
  },
};
const { firstName, age } = Susan;
console.log(firstName, age); //"Susan", 14

const { firstName: fn, age: a } = Susan;
console.log(fn, a); //"Susan", 14

const { lastName, address = 'NY' } = Susan;
console.log(lastName, address); //"Steward", "NY"

const {
  hobbies: [h0, h1],
} = Susan;
console.log(h0, h1); //"singing", "dancing"

const {
  contact: { email },
} = Susan;
console.log(email); //"a@b.com"
