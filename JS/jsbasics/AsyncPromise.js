function sum(a, b) {
  return new Promise((resolve, reject) =>
    setTimeout(function () {
      const sumResult = a + b;
      resolve(sumResult);
    }, 5000)
  );
  //console.log("this is sum function");
}

function division(a, b) {
  //console.log("this is division function");
  return new Promise((resolve, reject) =>
    setTimeout(function () {
      const divResult = a / b;
      resolve(divResult);
    }, 5000)
  );
}
const prom = sum(20, 4);

prom.then((sumResult) => {
  division(sumResult, 2).then((avg) => {
    console.log(avg);
  });
});
