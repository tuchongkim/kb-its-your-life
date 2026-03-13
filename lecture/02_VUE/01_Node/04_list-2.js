const fs = require('fs');

fs.readdir('./', (err, files) => {
  //여기서 './'는 프로세스의 working directory
  //즉 명령어가 실행된 디렉토리
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});

fs.readdir(__dirname, (err, files) => {
  //__dirname : 현재 실행하고 있는 파일의 디렉토리
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});
