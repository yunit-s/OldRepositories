
// let과 const
console.log('---------- let과 const');

// 객체 리터럴을 이용해서 객체 만들기
// 객체를 만들 때는 let이 아니라 const를 사용한다.
// let과 const는 딱 한 가지가 다르다.
// const는 재할당이 안 된다. constant(상수)
// constant라고 해도, 그 객체 자체를 가리키는 게 안 변하는 것 뿐이고, 그 내용은 변경될 수 있다.
// 객체는 객체 자체를 아예 새로 덮어씌우는 일이 잘 없다. 그래서 그럴 때 const를 사용하는 것.
const obj = {
    // property
    myName: '홍길동',
    myAge: 20
}





// internal slot(내부 슬롯), internal method(내부 메소드)
console.log('---------- 내부 슬롯, 내부 메소드');

console.log(obj); // 출력 : {myName: '홍길동', myAge: 20}
console.log(obj.myName); // 출력 : 홍길동
// console.log(obj.[[Prototype]]); // 오류 발생
console.log(obj.__proto__);
    // 출력 : {constructor: ƒ, __defineGetter__: ƒ, __defineSetter__: ƒ, hasOwnProperty: ƒ, __lookupGetter__: ƒ, …}
    // 정상 출력됨. 이런 식으로 접근할 수 있다.





// Object 생성자 함수
console.log('---------- Object 생성자 함수');

const person = {
    name: '홍길동',
    age: 20
}
console.log(person); // 출력 : {name: '홍길동', age: 20}
console.log(Object.getOwnPropertyDescriptors(person)); // 출력 : {name: {…}, age: {…}}
    // property마다 설정된 상세 정보를 확인할 수 있다.
    // 직접 설정하지 않은 여러 설정값들은 디폴트로 true가 들어간 것.

// 객체를 다른 방식으로 반들어보자.
// 메소드를 이용해서 특정 객체의 property를 설정해보자.
const person1 = {}
Object.defineProperty(person1, 'firstName', {
    // property의 attribute를 설정해야하니까 4개의 인자를 줘야해.
    // 인자에 여러 개를 전부 나열하려면 힘드니까, attribute를 하나의 객체로 전달하자.
    value: '홍',
    writable: true,
    enumerable: true, // 나열될 수 있다? 이건 무슨 말일까?
    configurable: true // 다시 재정의할 일이 없기 때문에 이 property는 신경 안 써도 된다.
});

// 위 person1과 똑같은 코드가 아래 코드다.
const person2 = {
    firstName: '홍',
    lastName: '길동'
}
console.log(person1.firstName); // 출력 : 홍
console.log(person1.value); // 출력 : undefined
person1.firstName = '최';
console.log(person1.firstName); // 출력 : 최
console.log(person1); // 출력 : {firstName: '최'}
for (let key in person2) {
    console.log(key, person2[key]);
        // 출력
        // firstName 홍
        // lastName 길동
}





// Built-in 생성자 함수
console.log('---------- Built-in 생성자 함수');

// new 라는 키워드로 생성자 함수를 호출할 수 있다.
// Object 생성자 함수
const person3 = new Object() // {}
person3.name = '홍길동'; // property가 추가된다.
    // 자동으로 property에 대한 attribute는 디폴트로 true가 입력된다.
person3.age = 20;
console.log(person3); // 출력 : {name: '홍길동', age: 20}

// String 생성자 함수
const strObj = new String('소리없는 아우성!');
console.log(typeof strObj); // 출력 : object
console.log(strObj); // 출력 : String {'소리없는 아우성!'}
    // String 생성자함수로 만들었더니 뭔가 달라졌다!
    // property를 들여다보면, 문자 하나마다 key가 숫자로 지정되어 있다.
    // 문자열은 아니다. 그냥 여러 개의 property를 가지고 있는 것.
    // 마치 배열처럼 생겼으니까, 이걸 '유사 배열 객체' 라고 부른다.
    // 진짜 배열과는 다름. 함수를 가지고 있지 않아서 배열이 가지고 있는 기능들은 활용할 수 없다. split같은 것들.
    // index같은 기능은 활용할 수 있다.
    // 얘도 객체니까, [[Prototype]]이라는 내부 슬롯을 가지고 있다.
    // 그리고 얘는 [[PrimitiveValue]] 라는 다른 내부 슬롯도 가지고 있다.
    // [[PrimitiveValue]]는 문자열 값을 저장한다. 당연히 직접 access는 불가능하다.
// 비교해보자
const strObj1 = {
    name: '홍길동'
}
console.log(typeof strObj1); // 출력 : object
console.log(strObj1); // 출력 : {name: '홍길동'}
    // 생성자 함수로 만든 strObj 와는 달리, 단순하게 key와 value를 출력해줌.

// Number 생성자 함수
const numObj = new Number(100);
console.log(numObj); // 출력 : Number {100}
// 객체인데 key가 안 나오고 값만 표현된다.
const numObj1 = new Number();
numObj1.num1 = 10;
numObj1.num2 = 20;
console.log(numObj1); // 출력 : Number {0, num1: 10, num2: 20}
    // 0 : [[PrimitiveValue]]

// Date 생성자 함수
const dateObj = new Date(); // 현재 시간을 가지고 객체를 생성한다.
console.log(dateObj); // 출력 : Mon Jan 16 2023 12:32:02 GMT+0900 (한국 표준시)
console.log(dateObj.getDate()); // 출력 : 16
console.log(dateObj.toLocaleString()); // 출력 : 2023. 1. 16. 오후 12:32:02





// 사용자 정의 생성자 함수
console.log('---------- 사용자 정의 생성자 함수');

// 일반 함수 리터럴?? 활용하는 방법
// 너무 노동집약적 방식...
let obj1 = {
    name: '홍길동',
    age: 20
}
let obj2 = {
    name: '홍길동',
    age: 20
}
let obj3 = {
    name: '홍길동',
    age: 20
}

// 생성자 함수는 관용적으로 첫 글자를 대문자로 쓴다.
// 함수 선언문
// 이럴 때는 2가지 형태로 사용할 수 있다.
//      1. 일반 함수 방식
//      2. 생성자 함수 활용
function Person() {
}
const person4 = new Person(); // 함수 선언문을 활용해서 객체 생성
const person5 = {} // literal을 활용한 객체 생성
console.log(person4); // 출력 : Person {}
console.log(person5); // 출력 : {}

// 일반적인 생성자 함수의 형태 특징
// 1. this keyword가 사용된다.
//      this 키워드 : 이 생성자 함수로 만들어지는 객체를 가리킨다.
// 2. return 구문이 없다.
//      묵시적으로, 생성된 객체를 리턴한다. 그래서 return을 쓰지 않는다.
function Circle(radius) {
    this.radius = radius; // 앞의 radius : property. 뒤의 radius : 인자로 들어온 radius
    this.getDiameter = function() {
        return 2 * 3.14 * radius;
    }
}
let circle1 = new Circle(5); // 객체 생성
let circle2 = new Circle(10); // 객체 생성
console.log(circle1); // 출력 : Circle {radius: 5, getDiameter: ƒ}. 객체의 정보 출력하기
console.log(circle1.getDiameter()); // 출력 : 31.400000000000002. 객체 안의 함수 호출하기





// this 키워드
console.log('---------- this 키워드');

// 함수 선언문
function foo3() {
    console.log(this);
}
// 위 foo3 정도의 코드만 놓고 보면, 이게 생성자 함수인지 일반 함수인지 논할 수 없다.
// 이걸 호출하는 곳에서 생성자 함수처럼 사용하면 생성자 함수고, 아니면 일반 함수처럼 쓰게 되는 것.
foo3(); // 출력 : Window {window: Window, self: Window, document: document, name: '', location: Location, …}
    // 일반 함수로 호출하기
    // 여기서의 this는 전역 객체(window 객체)를 가리킨다.
const obj4 = {
    // foo3: foo3
        // 앞의 foo3 : property의 key
        // 뒤의 foo3 : 밖에 있는 foo3함수를 가리키는 레퍼런스 변수
    
    // key와 value가 완전히 동일한 경우 이를 축약시키는 방법
    foo3 // 'foo3: foo3' 를 축약시킨 표현 방법. ES6부터 가능하다.
        // 이렇게 축약표현으로 되어 있는 함수를 메소드라고 부른다.
        // ES6에서는 메소드 라고 부르는 경우가 한정되어 있다. 두 가지가 있음.
        //      1.
        //      2.
}
obj4.foo3(); // 출력 : {foo3: ƒ}
    // foo3는 메소드
    // 메소드를 실행시켰기 때문에, 여기서의 this는 뭘 가리킬까? -> obj4를 가리킨다.
const obj5 = new foo3(); // 출력 : foo3 {}





// return에 따라 달라지는 생성자 함수
console.log('---------- return에 따라 달라지는 생성자 함수');

// 생성자 함수는 new 키워드와 함께 사용되고, 그 안에 return 구문이 없다.
// 그럼에도 불구하고 만들어진 객체가 묵시적으로 리턴된다.
function Circle1(radius) {
    this.radius = radius;
}
const circle4 = Circle1(10); // 일반함수로 호출. 따라서 Circle1() 안의 this는 전역객체.
console.log(circle4); // undefined 출력됨. Circle1()의 리턴이 없었기 때문에 undefined가 리턴된 것.
const circle5 = new Circle1(10); // 생성자 함수로 호출. 객체를 만들고, 객체에 property 붙여서 그 객체를 리턴한다.
console.log(circle5); // Circle1 {radius: 10} 출력됨
// 리턴으로 다른 값을 적은 함수는 어떻게 될까?
function Circle2(radius) {
    this.radius = radius;
    return 100; // primitive value를 리턴
    // return this; // 생성자 함수에서는 window 객체를 리턴하게 된다.
}
const circle6 = new Circle2(10);
console.log(circle6); // Circle2 {radius: 10} 출력됨
    // 리턴 구문이 객체를 리턴하는지, primitive value를 리턴하는지에 따라, 생성자 함수로 호출한 그 결과가 달라진다.
    // 이렇게 되면, 결국 일반 함수로도 쓸 수 있고, 생성자 함수로도 쓸 수 있게 된다.





// window 객체의 property로 등록되는 변수
console.log('---------- window 객체의 property로 등록되는 변수');
// window 객체의 입장에서 var과 let의 차이
var myName = '홍길동'; // window객체의 property로 등록
let myAge = 20; // scope는 전역이지만, window 객체에 등록되지는 않는다.

console.log(myName); // 출력 : 홍길동
console.log(window.myName); // 출력 : 홍길동
console.log(window.myAge); // 출력 : undefined. window객체의 property로 등록되지 않았기 때문.
window.myAge = 10;
console.log(window.myAge); // 출력 : 10
function foo4() {
    console.log(this);
}
foo4(4); // 출력 : Window {window: Window, self: Window, document: document, name: '', location: Location, …}

// 일반 함수에서의 this
function Circle3(radius) {
    this.radius = radius;
}
const circle7 = Circle3(10);
console.log(radius); // 출력 : 10
    // this.radius 를 호출할 때, this가 window객체를 가리키기 때문
    // console.log(window.radius); 에서 번거로우니까 window를 생략했다고 생각하면 된다.





// 함수에 property 등록하기
console.log('---------- 함수에 property 등록하기');

// 함수 선언문
function foo5() {
    k: 10
}
// 첫 번째 phase에서 foo5 라는 변수가 생성된다.(묵시적으로)
// 함수 자체가 객체니까, 함수에 property를 붙일 수 있다.
foo5.myName = '홍길동';
foo5.myFunc = function() {
    console.log(this);
}
console.log(foo5.myName); // 홍길동
foo5.myFunc(); // ƒ foo5() { k: 10 } 출력됨
    // 생성자 함수 호출? 아니야. 일반 함수 호출? 그것도 아니야.
    // 여기서의 this는 그 함수를 호출하는 객체를 가리키게 된다.





// 내부 메소드 [[Call]], [[Construct]]
console.log('---------- 내부 메소드 [[Call]], [[Construct]]');

function foo6() {
    // 함수 선언문
}
// foo6는 일반함수로 호출이 가능하기 때문에 기본적으로 [[Call]] 를 가지고 있는 함수이다.
// foo6는 callable
foo6(); // 이렇게 호출하면, 내부적으로 [[Call]] 이 호출된다.
var myVar = 100;
// myVar(); // 오류 발생. [[Call]] 이 없기 때문에 오류가 발생한다.
var myVar1 = {};
// myVar1(); // 오류 발생. [[Call]] 이 없기 때문에 오류가 발생한다.

// 내부 메소드 [[Construct]]
// 함수 객체에 붙을 수 있다.
// 1. [[Construct]] 내부 메소드가 붙은 경우
//      : 함수 선언문으로 만든 경우, 함수 표현식으로 만든 경우, 클래스
//      세 가지 공통점 : 객체를 생성할 수 있는 함수 형태. new 키워드를 붙여서 인스턴스를 만들 수 있는 경우.
//          이를 constructor 라고 부른다.
//      constructor : 객체를 생성할 수 있는 함수 형태
function myFunc() {
    // 함수 선언문
}
var myFunc1 = function() {} // literal을 이용하여 함수 표현식으로 작성한다. 가독성을 위해 이름을 쓰지 않는다.
class MyFunc {
    // 클래스
}
myFunc(); // [[Call]] 내부 메소드가 호출됨
new myFunc(); // [[Constructor]] 내부 메소드가 호출됨

// 2. [[Construct]] 내부 메소드가 없는 경우
//      메소드인 경우(ES6의 메소드 표현식), Arrow-Function
//      공통점 : 객체를 생성할 수 없다. new 키워드를 붙일 수 없다.
//          이를 non-constructor 라고 부른다.

// 함수 선언문
// callable([[Call]] 을 가지고 있음)
// constructor([[Constructor]] 을 가지고 있음). 함수 선언문이니까 new 키워드와 함께 객체를 생성할 수 있음.
function foo7() {
    // 함수 선언문
}
foo7(); // 호출 가능
new foo7(); // 객체 생성 가능

// 함수 표현식
// 함수 표현식도 일반 함수로도, 생성자 함수로도 사용할 수 있다.
const bar = function() {
    // 함수 표현식
}
bar(); // 호출 가능
new bar(); // 객체 생성 가능

//
// 오브젝트라고 불리는 객체에 property 추가하기
const obj6 = {
    x: function() {} // 메소드 아님. key와 value로 구성된 정상적인 형태의 선언이기 때문
        // 일반론적인 시각으로는 메소드라고 부르긴 함
}
new obj6.x(); // 함수 리터럴을 가지고 만든 함수 표현식으로, 객체 생성하기.
    // 메소드가 아니기 때문에 오류 아님. 객체 생성 가능하다. constructor임.

// Arrow-Function
const myFunc2 = (a, b) => {return a + b}
myFunc2(); // 호출 가능. [[Call]] 있기 때문에 callable.
// new myFunc2(); // 오류 발생. Arrow-Function은 constructor가 아니다.

var obj7 = {
    // myFunc: function() {} // 정석적인 선언 방법
    // Java처럼 표기하는 방법
    // 이 형태가 축약형이고, 메소드라고 부른다.
    myFunc() {

    },
    name: '홍길동'
}
// new obj7.myFunc(); // 오류 발생. 객체 생성 안 된다.





// -----
console.log('---------- ?????????????');

// 함수 선언문 - constructor
function add(x, y) {
    return x + y;
}
let instance = new add(); // 객체 생성 가능
console.log(instance); // add {} 출력됨. 빈 객체 생성.
// 함수 선언문
function createUser(name, age) {
    // this.name = name;
    // this.age = age;
    // return {name: name, age: age}
    return {name, age} // 위 내용 축약형
}
let inst = new createUser('홍길동', 20);
    // 엄밀히 말하면, 생성자 함수로 만든 인스턴스가 저장된 게 아니다.
    // 리턴받은 {name, age} 객체가 저장된 거지
console.log(inst); // {name: '홍길동', age: 20} 출력됨

// 함수 선언문 - 생성자 함수
function Circle4(radius) {
    this.radius = radius;
    this.getDiameter = function() {} // 이거 메소드 아님. 객체의 property로 함수가 붙어있는 것 뿐.
}
const circle8 = Circle4(10); // 일반함수 호출. this는 window객체. return 이 없으므로 undefined 리턴.
console.log(circle8); // undefined 출력됨
console.log(radius); // 10 출력됨
function Circle5(radius) {
    this.radius = radius;
    this.getDiameter = function() {
        console.log('haha');
    }
}
const circle9 = Circle5(20);
console.log(radius); // 20 출력됨
// circle9.getDiameter(); // 오류.





// console.dir() : 상세 보기
console.log('---------- console.dir() : 상세 보기');

// console.dir() 써보기
var obj8 = {
    name: '홍길동'
}
console.log(obj8); // 내용을 문자열로 표현해주는 것이 주요 기능이다.
console.dir(obj8); // 내용을 직접 열어서 자세하게 정보를 볼 수 있게 하기 위한 것
function square(number) {
    return number * number;
}
console.log(square); // 함수의 내용을 문자열로 출력해주고 끝
console.dir(square); // 함수의 상세 정보를 볼 수 있음
