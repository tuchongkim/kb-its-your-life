const fs = require('fs');

fs.readdir('./', (err, files) => {
  if (err) {
    console.err(err);
    return;
  }
  console.log(files);
});
