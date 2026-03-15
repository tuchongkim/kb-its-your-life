const fs = require('fs');

if (fs.existsSync('./test')) {
  console.log('folder already exists');
} else {
  fs.mkdir('./text', (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('folder created');
  });
}
