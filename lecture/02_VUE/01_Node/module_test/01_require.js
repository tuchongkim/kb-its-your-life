// node 22.12.0(LTS) 부터 호환성 문제 없이 require() 사용 가능
// const { add, test } = require('./01_export.js');
import { add, test } from './01_export.js';
console.log(add(4));
test();
