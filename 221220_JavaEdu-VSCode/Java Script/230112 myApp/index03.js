
// let 키워드로 변수 선언
// ES6부터 도입됨
// var과는 다르게 block level scope이다. 우리가 흔히 알고 있는 변수 선언 방식을 이용한다.
// 같은 scope 내에서는 중복 선언이 불가능하다.
let a = 100;
// let a = 50; // 중복 선언 오류





// block level scope 테스트
let score = 50; // 전역 스코프
{
    let score = 100; // 오류 아님. block이 다르기 때문에 중복으로 생각하지 않는다.
    let myVar = 10;
}
console.log(score); // 50 출력
console.log(myVar); // 오류. myVar의 스코프 밖에 있음.
