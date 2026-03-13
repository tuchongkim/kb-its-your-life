let showtime = (msg) => {
  let dt = new Date();
  console.log(
    `${msg} 현재시간 : ${dt.getHours()}시 ${dt.getMinutes()}분 ${dt.getSeconds()}초`,
  );
};

console.log('<<시작>>');

setTimeout(() => {
  showtime('3초 후');
}, 3000);

setTimeout(() => {
  showtime('5초 후');
}, 5000);

setTimeout(() => {
  showtime('1초 후');
}, 1000);

console.log('<<종료>>');
