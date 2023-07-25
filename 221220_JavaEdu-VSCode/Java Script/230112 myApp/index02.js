
console.log(x);
x = 100;
console.log(x);
var x = 1;





// 스코프 테스트
console.log(x2);
x2 = 100;
console.log(x2);
function myFunc2() {
    console.log(x2);
    var x2;
}
myFunc2();
// 동작 순서
// 1 creation phase
// myFunc만 식별자네. myFunc 라는 변수의 공간을 할당하고, undefined 값 저장하고 1페이즈 종료.
// 2 execution phase
// x1...? 1페이즈때 없었어. 그러니까 이거 못 찾아서 오류.





// 스코프 테스트
x3 = 100; // 이거는 오류 아님. 암묵적 전역에 의해서 자동으로 변수 선언됨. 좋은 방식의 코드는 아니다.
console.log(x3);
function myFunc3() {
    console.log(x3);
    var x3;
}
myFunc3();
