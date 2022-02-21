let location = new Map([
  ["101", "USA"],
  ["102", "India"],
  ["103", "UK"],
]);

itr = location.keys();

for (let item of location) {
  console.log(itr.next());
}

itr2 = location.entries();
for (let item of location) {
  console.log(itr2.next());
}
