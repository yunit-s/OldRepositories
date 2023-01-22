
// primitive data type

// 1. number type
//      정수와 실수를 구분하지 않는다.
let myVar = 1.0 // 실수 -> number
console.log(myVar == 1); // true
console.log(3 / 2); // 1.5
console.log(10 / 0); // Infinity(무한대)
    // Java 에서는 오류. exception 발생
    // Java Script에서는 Infinity 라는 값이 존재한다. 무한대를 가리키는 상수값이 존재함
console.log(10 * 'Hello'); // NaN(Not A Number)
    // 숫자가 아니다? 즉, 산술 연산이 불가하다는 뜻. NaN이라는 값이 존재하는 것.

// 2. string type
//      문자열 타입
var myStr = '아우성!!'; // 문자열 사용하는 일반적인 형태
myStr = "소리없는"; // 이것도 사용 가능
myStr = `이것은 \n소리없는 \n아우성!` // 백틱을 썼을 때는 추가 기능을 적용할 수 있다.
myStr = `이것은
소리없는
아우성!`; // 이렇게도 사용 가능하다. (문자열을 여러 줄로 표현 가능하다.)

let test = 100;
myStr = `현재 test의 값은 ${test} 입니다.`;
myStr = `현재 test의 값은 ` + test + `입니다.`;

console.log(myStr);

// 3. boolean type - true, false 두 개의 값만 제공
var test1 = true

// 4. undefined type - 사용할 수 있는 값이 undefined만 있다.
// 이 값은 우리가 사용하는 값이 아니다.
// Java Script Engine에 의해서 사용이 된다.

// 5. null type - 사용할 수 있는 값이 null 만 있다.
// 이 값은 우리가 사용하는 값이다.
test = null;

// 6. Symbol type
// ES6 (ECMA Script 2015) 에 추가된 타입이다.
// 다른 값과 중복되지 않는 unique 한 값을 표현

let mySymbol = Symbol();
console.log(mySymbol); // Symbol() 이라고 출력되고, 실제로 어떤 값을 가지고 있는 지는 우리는 모른다.
    // 유일한 값은 맞는데, 진짜 그 값이 무엇인지는 확인할 수 없다.

let mySymbol1 = Symbol("소리없는 아우성!");
let mySymbol2 = Symbol("소리없는 아우성!");
console.log(mySymbol1 == mySymbol2); // false

// Reference Type(함수, 객체, 배열)은 수업이 진행되면서 알아보자.



let str = 'hello';
console.log(str[0]); // h 출력
    // 이게 어떻게 가능한 걸까? 단순 문자열 primitive type인데, 이걸 어떻게 배열(객체) 처럼 쓰는 걸까?
console.log(str.length); // 5 출력
console.log(str.toUpperCase()); // HELLO 출력

// 자바스크립트는 primitive value에 대해 객체처럼 사용하면,
//      primitive value를 감싸는 wrapper object가 생성된다.
let str1 = 'hello';
str1[0] = 'H'; // 이거 바꿔줄 때만 잠시 만들어졌다가, 특정 작업을 수행 후 원래 상태로 돌아간다. primitive type 이니까 불변이야.
console.log(str1); // hello 출력됨. Hello 로 출력되지 않는다. 맨 앞 단어가 대문자로 바뀌지 않는다.

// 객체 생성하기
let myObj = {
    'name': '홍길동',
    'age': 20,
    'address': '서울',
    'myInfo': function myFunc() {
        console.log('소리없는 아우성!');
    }
}

console.log(myObj.name); // 홍길동
console.log(myObj.myInfo); // [Function: myInfo]
myObj.myInfo(); // '()' : 코드를 실행시키라는 의미



// 객체 literal
let obj = {
    // 'name': '홍길동'
    name: '홍길동', // key값에는 '' 작은 따옴표 안 적어도 문자열로 받아들임
    10: 200 // 10 도 key값이니까, 숫자가 아니라 문자열로 변환된다.
}

console.log(obj); // { '10': 200, name: '홍길동' }
console.log(obj.name); // 홍길동
// console.log(obj.'10'); // 이런 문법 없어
// 연관 배열
console.log(obj['name']); // 배열 안에 적힌 문자열로 key값을 명시해주는 방법
console.log(obj['10']); // 

// 객체 안에 이상한 접근
obj.address = '서울'; // 객체가 가지는 property 중에 address가 없으니, 객체 안에 새로 만들어넣는다.
    // 근데 이게 문제가 있다. 만약 address를 addrass 로 오타를 입력하게 되면,
    // 동작은 되는데 오류 메시지가 안 나는 것.



// typeof 연산자
// 값의 데이터 타입을 알려준다.
console.log(typeof 100); // number 출력됨
console.log(typeof 'Hello'); // string 출력됨
console.log(typeof undefined); // undefined 출력됨
console.log(typeof true); // boolean 출력됨
console.log(typeof Symbol()); // symbol 출력됨
console.log(typeof [1,2,3]); // object 출력됨. reference type은 object로 출력된다.

// 예외 상황
console.log(typeof null); // object 출력됨
    // null이 나와야 하는데 이상하지? ECMA도 이 오류를 아는데, 고치면 이미 존재하는 여러 프로그램들이 고장날까봐 일부러 안 고치는 것.
// let myFunc = function aa() {} // 원래 aa 처럼 함수의 이름을 붙이는 게 정상인데, 여기서는 의미 없으니까 이름란을 비워도 된다.
let myFunc = function () {

}
console.log(typeof myFunc); // function 출력됨
    // reference type이라서 object라고 나와야 하는데, function으로 출력된다.
    // 진짜 data type과 리턴 타입이 정확하게 매칭되는 것은 아니다.





// 함수를 정의하는 방법
// 1. 함수 선언문 -> 함수를 변수에 저장하지 않는다.
function myFunc1(a, b) {
    return a + b;
}
// 2. 함수 표현식
let aa = function() {

}
// 3. Function 생성자 함수를 이용한 함수 생성 방식
let bb = new Function('x', 'y', 'return x + y');



// 화살표 함수(Arrow Function)
// 이거는 원래 함수형 언어에 존재하던 방법인데, Java에서 표현되는 람다 표현식의 유래가 이 방식이다.
let cc = (x, y) => {
    return x + y;
}



// 함수 선언문
function myFunc2(a, b) {
    return a + b;
}
console.log(myFunc2(10, 20)); // 30 출력됨

// 선언문을 ()소괄호로 묶으면 어떻게 될까?
(function myFunc3(a, b) {
    return a + b;
}) // ()괄호를 치면, () 안에 있는 게 값이 오는 거니까, 함수 선언문이 갑자기 함수 literal(값)이 되면서 myFunc3() 을 호출하는 게 불가능해진다.



// 함수 선언문과 함수 표현식에 따라 달라지는 활용 방식
console.log(myFunc4(10, 20)); // 30 출력됨
// console.log(myFunc5(10, 20)); // Error. 1phase때 선언만 됐지, 2phase 들어와서 아직 내용 코드가 저장되지 않았기 때문
// 함수 선언문
function myFunc4(a,b) {
    return a + b;
}
// 함수 표현식
let myFunc5 = function(a, b) {
    return a + b;
}



// 
function add(x, y) {
    // 함수는 내장 배열을 하나 가지고 있다. 그 이름이 arguments
    // arguments[] => [10, 20, 30, 40]
    // 정확히 말하면 배열은 아니고 유사 배열 객체
    // 역할은 넘어온 인자를 전부 저장해주는 것.
    // return x + y;
    return arguments[0] + arguments[1];
}

console.log(add(10, 20)); // 30 출력됨
console.log(add(10)); // NaN 출력됨
    // 인자를 전부 전달해주지 않은 상황
    // Java에서는 error지만, JavaScript에서는 이름만 맞으면 인자의 개수와 상관없이 무조건 call이 된다.
    // x -> 10, y -> undefined
    // 숫자와 undefined를 더할 수 없으므로, NaN(산술 연산 불가)이 출력된다.
console.log(add(10, 20, 30, 40)); // 30 출력됨
    // x -> 10, y -> 20, 30, 40은 parameter로 받지는 못한다.
    // arguments[] => [10, 20, 30, 40]


// console.log(add(10, 20, 30, 40)); // 30 출력됨



// IIFE(즉시 실행 함수)
// 일반적인 방법
function add() {
    let x = 10;
    let y = 20;
    console.log(x + y);
}
// add(); // 원래는 이렇게 호출해야 한다.
// IIFE 적용한 방법
// 함수를 선언함과 동시에 바로 수행하는 것
// 이름을 적어봤자 의미가 없기 떄문에 이름을 적지 않는다. anonymous로 만든다.
// 이 함수는 한 번 사용되고 바로 버려진다. 다시는 이 함수를 사용할 수 없다.
(function () {
    let x = 10;
    let y = 20;
    console.log(x + y);
}());
// IIFE를 사용하는 이유
// 변수의 scope를 제어할 수 있다.
// Java Script의 특성인 전역 scope의 공유 문제를 해결할 수 있다.



// 중첩 함수
// 선언적 함수
function outer() {
    let x = 1;

    // 중첩 함수 선언
    function inner() {
        let y = 2;
        console.log(x + y);
    }
    inner();
}
// inner(); // 사용 불가. inner()가 존재할 수 있는 스코프 영역이 아니다.
outer();



// Callback 함수
// 숫자 하나를 입력받고, 0부터 해당 숫자까지 console에 출력하는 프로그램
function repeat(n) {
    for (let i = 0; i < n; i++) {
        console.log(i);
    }
}
repeat(3);
// 위 함수에 기능을 추가해보자.
// 숫자 하나를 입력받았는데, 0부터 해당 숫자까지 홀수만 출력하는 기능으로 변경하는 것.
// 이미 잘 돌아가고 있는 함수 코드는 어디서 또 쓰일지 모르기 때문에 잘 안 건든다.
// 그러므로 이미 있던 함수를 활용해서 새 함수를 구현한다.
function repeat_odd(n) {
    for (let i = 0; i < n; i++) {
        if(i % 2 == 1)
            console.log(i);
    }
}
repeat_odd(10);

// 일급시민. first-class citizen.
// 프로그래밍 언어에서 사용되는 언어다. 그런데 이거 말고 더 자주 사용하는 용어가 있다.
// 일급객체. first-class Object
//      4가지 특성을 만족하는 객체.
//          1. 익명의 literal 로 생성이 가능하다.
//          2. 변수에 저장될 수 있어야 한다. 객체이기 때문. ('값' 으로 판단될 수 있어야 한다.)
//          3. 함수의 인자로 전달될 수 있어야 한다.
//          4. 함수의 리턴값으로 사용할 수 있어야 한다.

// JavaScript에서의 함수 특징
//      1. 익명으로 리터럴로 만들 수 있다.
//      2. 변수에 저장이 가능하다. (값으로 사용!)
//      3. 인자로 전달이 가능하다. (값이니까)
//      4. 함수의 리턴값으로 사용이 가능하다. (값이니까)
// ㄴ> 결국, JavaScript에서의 함수는 일급 객체다.

// 일급 객체 실습
// 함수를 인자로 받기
// 공통 로직을 작성하고, 경우에 따라 변화되는 로직을 추상화해서 외부 함수로 대체

// Higher-Order Function (고차 함수)
function repeat1(n, f) {
    for (let i = 0; i < n; i++) {
        f(i);
    }
}

// callback function
// 이 함수가 다른 함수에 기어들어가서 동작하게 된다는 것
let printAll = function(i) {
    console.log(i);
}
let printOdd = function(i) {
    if (i % 2 == 1) console.log(i);
}
let printEven = function(i) {
    if (i % 2 == 0) console.log(i);
}
repeat1(10, printEven);

var myArr = [1, 2, 3]
myArr.forEach(function() {}); // 여기서는 forEach가 higher-order function 이고, 안에 있는 것이 callback function이다.

