const fs = require('fs');

fs.readFile('./example.txt', data, (err) => {
  if (err) {
    console.log(err);
  }
  console.log('text-2.txt is saved!');
});
