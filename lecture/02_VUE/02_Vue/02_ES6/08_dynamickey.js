let lion = {};
lion.first_name = 'Mufasa';
//js의 사용가능특수문자: _, $만 가능합니다
//lion.last-name = 'King' //error

//객체의 키이름(속성명)으로
//그외의 특수문자를 포함하고 싶다면
//키이름을 ''로 둘러쌉니다
//ex) lion['last-name'] = ~~~
//ex) let lion2 = { 'last-name': ~~~}

lion['last-name'] = 'King'; //OK
console.log(lion.first_name + ', ' + lion['last-name']);

//변수의 값을 객체의 키이름으로 만들려면 [변수명]을 사용합니다
let prop = 'category';
lion[prop] = 'animal'; //lion.category = 'animal'

let lion2 = {
  first_name: 'Simba',
  'last-name': 'King',
  [prop]: 'animal',
};
console.log(lion2);
