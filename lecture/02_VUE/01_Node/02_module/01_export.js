let base = 100;
const a = (x) => base + x;
const t = () => {
  console.log('module내부에서 this는', this);
};

export { a as add, t as test };
// module.exports = { add: a, test: t };
