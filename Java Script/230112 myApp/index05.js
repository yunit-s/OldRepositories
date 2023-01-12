
// let의 특징 - 초기화 필수
console.log(x); // error
let x = 100;
// let으로 선언된 경우, hoisting이 일어나긴 했지만, 초기화가 되기 전까지는 사용할 수 없다.
// Temporal Dead Zone(TDZ) : hoisting에 의해 선언은 되어 있지만, 초기화되기 전까지 사용하지 못하는 구간
//      여기서는 console.log(x) 에서 let x = 100; 전까지를 가리킨다.
