const fs = require('fs').promises;

async function readDirAsyn() {
  try {
    const files = await fs.readdir('./');
    console.log(files);
  } catch (err) {
    console.error(err);
  }
}

readDirAsyn();
