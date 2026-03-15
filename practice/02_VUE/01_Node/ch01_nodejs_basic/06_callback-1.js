const order = (coffeeType, callback) => {
  console.log(`${coffeeType} 주문 접수`);
  setTimeout(() => {
    callback(coffeeType);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

order('아메리카노', display);
