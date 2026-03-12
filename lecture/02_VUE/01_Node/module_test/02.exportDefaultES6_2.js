const base = 1000;
// export default  {
//     add : (x) => base+ x,
//     multiply :  (x) => base * x,
//     test : ()=> console.log('module내부에서 this는 undefined입니다', this)
// }
const add = (x) => base + x;
const multiply = (x) => base * x;
const test = () =>
  console.log('ES6 module내부에서 this는 undefined입니다', this);
export default { add, multiply, test };
