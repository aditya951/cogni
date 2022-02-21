const p = 100,
  q = 200;

function sum(a, b, cd) {
  console.log("this is sum function");
  setTimeout(function () {
    cd(a + b);
  }, 5000);
}

function division(a, b, cd) {
  console.log("this is division function");
  setTimeout(function () {
    cd(a / b);
  }, 5000);
}

sum(p, q, function (sumResult) {
  division(sumResult, 2, function (avg) {
    console.log(avg);
    console.log("Async process achieved!!!!");
  });
});
