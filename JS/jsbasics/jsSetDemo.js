let city = new Set(['Chicago','Delhi','London','Tokyo','Paris','Delhi']);

console.log(city.size);
console.log(city);

console.log(city.delete('Delhi'));

console.log(city.size);
console.log(city);

city.add('Chennai');

console.log(city.size);
console.log(city);