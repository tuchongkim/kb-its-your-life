let showtime = (msg) => {
  let dt = new Date();
  console.log(
    `${msg} 현재시간 : ${dt.getHours()}시 ${dt.getMinutes()}분 ${dt.getSeconds()}초`,
  );
};

let cnt = 0;
const delay = (ms) =>
  new Promise((resolve, reject) => {
    ms < 0
      ? reject('시간은 음수일 수 없습니다.')
      : setTimeout(() => resolve(`${++cnt} : ${ms / 1000}초 후`), ms);
  });

async function run() {
  try {
    console.log('<<시작>>');

    const msg1 = await delay(3000);
    showtime(msg1);

    const msg2 = await delay(5000);
    showtime(msg2);

    const msg3 = await delay(1000);
    showtime(msg3);

    await delay(-5000);
  } catch (rejectedMsg) {
    console.log(rejectedMsg);
  } finally {
    console.log('<<종료>>');
  }
}

run();
