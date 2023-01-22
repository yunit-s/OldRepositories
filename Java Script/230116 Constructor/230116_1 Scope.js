
// local scope, global scope
console.log('---------- local scope, global scope');

var x = "Hello"; // 전역변수 x. global scope 안에 있다.

// 함수 선언문을 활용하여 함수 선언
function foo() {
    var x = "World"; // 지역변수 x. local scope에 있다.

    function bar() {
        var x = "haha"; // 지역변수. local scope
        console.log('x = ' + x);
        console.log('y = ' + y);
    }

    console.log('x = ' + x);; // JavaScript는 이 x를 어떤 x로 판단할까?
        // identifier resolution(식별자 결정) => Scope
        // 두 개의 x는 이름은 같지만 scope가 다르다. 서로 다른 변수임.
        // scope는 namespace의 역할을 한다. 이름을 구분해주기 위한 것
    var y = 2;
    bar();
}
foo();





// 함수의 상위 스코프 결정 방식 - Dynamic scope, Lexical scope
console.log('---------- 함수의 상위 스코프 결정 방식');

var x2 = 1;
function foo2() {
    var x2 = 10;
    bar();
}
function bar() {
    console.log(x2);
}
foo2();
    // 이 때 찾으려는 x2는 어떤 x2일까?
    // 1 출력됨
    // bar() 함수의 상위 스코프는 전역함수다.