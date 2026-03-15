const users = require('./10_users-1');

for (let key in users) {
  console.log(`${users[key]}님, 안녕하세요?`);
}
