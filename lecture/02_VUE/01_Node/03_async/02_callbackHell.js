let showtime = (msg) => {
  let dt = new Date();
  console.log(
    `${msg} 현재시간 : ${dt.getHours()}시 ${dt.getMinutes()}분 ${dt.getSeconds()}초`,
  );
};

//시작 -> 3초후 -> 5초후 -> 1초후 순서대로 실행하고 싶다면
console.log('<<시작>>');

setTimeout(() => {
  showtime('3초 후');
  setTimeout(() => {
    showtime('5초 후');
    setTimeout(() => {
      showtime('1초후');
      console.log('<<종료>>');
    }, 1000);
  }, 5000);
}, 3000);
