const fs = require('fs');

const rs = fs.createReadStream('./readMe.txt');

rs.on('data', (chunck) => {
  console.log('new chunk received:');
  console.log(chunck.length, chunck);
})
  .on('end', () => {
    console.log('finished reading data');
  })
  .on('error', (err) => {
    console.error(`Error reading the file: ${err}`);
  });
