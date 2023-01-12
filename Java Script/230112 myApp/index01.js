
// var keyword는 같은 scope 내에서 중복선언이 가능하다.
var x = 100;
var y = 200;

var x = 300; // 코드 에러 아님. 단순히 var 을 무시하고, x = 300; 으로 해석한다.
var y; // 아무 의미 없는 코드




// var keyword는 function level scope만을 local scope로 인정한다.
var x = 1;
if (true) {
    var x = 100; // if문은 함수 단위로 보지 않는다. 따라서 변수의 스코프가 구분되지 않는다.
}
console.log(x); // x = 100 출력됨. x가 function level scope이기 때문.

var x = 1;
function myFunc() {
    // Java는 함수가 없고 method가 있다.
    // Java의 method는 class 안에 위치한다.
    // JavaScript는 함수형 언어다. 그래서 함수라는 개념이 존재한다.
    // method와 같은 기능을 하는데, class가 필요한 Java와 달리 독립적으로 존재한다.
    // 함수를 만들 때는 function 이라는 키워드를 명시해야 한다.
    // 함수 이름에는 식별자를 붙여 준다.
    // () 안에는 인자(parameter)가, {} block 안에는 실행 코드가 표현된다.
    // JavaScript는 함수 레벨 스코프 이기 때문에, myFunc() 안에 새로 선언한 변수는 밖에 있는 변수와 별개로 취급된다.
    var x = 200;
    console.log(x);
}

console.log(x); // 1 출력
myFunc(); // 200 출력
console.log(x); // 1 출력

