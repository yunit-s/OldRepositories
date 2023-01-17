
// 일반객체와 함수의 세부 내용 비교
console.log('---------- 일반객체와 함수의 세부 내용 비교');

// 일반객체. 리터럴 형태로 만들어보자.
var obj = {
    name: '홍길동'
}
console.dir(obj); // 출력 : Object

// 함수 선언문
function myFunc(number) {
    return 2 * number;
}
console.dir(myFunc); // 출력 : ƒ myFunc(number)
    // 여기서의 myFunc는 함수 객체를 가리키는 레퍼런스 변수임. 실제 함수 이름 그 자체는 아니다.





// arguments 유사 배열 객체
console.log('---------- arguments 유사 배열 객체');

function myFunc1(a, b) {
    // 함수 객체는 property로 arguments 유사배열객체를 가지고 있다.

    // return a + b; // 보편적인 방법
    return arguments[0] + arguments[1] + arguments[2] + arguments[3]; // arguments를 활용하는 방법. 오류 아님.
}
console.log(myFunc1(10, 20, 30, 40)); // 출력 : 100
    // 10은 a에, 20은 b에 전달된다. 30, 40은 함수 내부의 arguments 유사배열객체에 들어간다.

// 유사배열객체는 가변인자함수를 구현하기 위해서 사용한다.
function sum() {
    let result = 0;
    for (let i = 0; i < arguments.length; i++) {
        result += arguments[i];
    }
    return result;
}
console.log(sum(10, 20, 30)); // 출력 : 60. 오류 아님
console.log(sum(10, 20, 30, 40)); // 출력 : 100. 오류 아님

// 유사 배열 객체는 배열과 생긴 것은 똑같고, 사용도 비슷하게 할 수 있다.
// 다만, 진짜 배열은 아니기 때문에, 배열이 가지는 여러 기능을 똑같이 가지고 있지 않다.





// Rest parameter
console.log('---------- Rest parameter');

// ES6에 들어오면서 별도의 parameter라는 것이 도입했다.
// Arrow function은 arguments가 없기 때문에, Rest parameter만 사용할 수 있다.
function sum1(...args) {
    // Rest parameter를 활용한 args는 진짜 배열(Array)이다. 배열의 기능을 활용 가능하다.
    
    let result = 0;
    for (let i = 0; i < args.length; i++) {
        result += args[i];
    }
    return result;
}





// prototype 객체에 함수 저장하기
console.log('---------- prototype 객체에 함수 저장하기');

// 일반적인 함수 선언 방법
// 함수 선언문 - 생성자 함수
function Circle(radius) {
    this.radius = radius; // 왼쪽은 property, 오른쪽은 지역변수
    // getArea라는 property에, 함수 객체를 value로 넣어주기
    this.getArea = function() {
        return Math.PI * this.radius ** 2; // ** : 제곱
            // Math : 함수긴 함수인데, 생성자 함수는 아니다.
            //      얘가 가진 property 중에 PI라는 property가 있어서 그거 사용
    }
}
const circle1 = new Circle(2);
const circle2 = new Circle(5);

// Prototype 활용하기
// 함수 선언문 - 생성자 함수
function Circle1(radius) {
    this.radius = radius;
    Circle1.prototype.getArea = function() {
        return Math.PI * this.radius ** 2;
    }
}
const circle3 = new Circle1(2);
const circle4 = new Circle1(5);
// 비교 연산자 == : 내용이 같은지 비교한다. 단, 타입이 다른 경우, 타입부터 맞춘 다음 비교한다.
// 비교 연산자 === : 타입도 같고 내용도 같은지 비교. 타입 다르면 다른 거.
console.log(circle3.radius === circle4.radius); // 출력 : false
console.log(circle3.getArea === circle4.getArea); // 출력 : true





// prototype 객체에 변수 저장하기
console.log('---------- prototype 객체에 변수 저장하기');

function Circle2(radius) {
    this.radius = radius;
    Circle2.prototype.getArea = function() {
        return Math.PI * this.radius ** 2;
    }
    Circle2.prototype.name = '홍길동'
}
const circle5 = new Circle2(2);
const circle6 = new Circle2(5);
console.log(circle5.name, circle6.name); // 출력 : 홍길동 홍길동
circle5.name = '신사임당'; // 객체 안에 name이라는 property가 없기 떄문에, 새로 만든다.
console.log(circle5.name, circle6.name); // 출력 : 신사임당 홍길동
circle5.__proto__.name = '강감찬';
console.log(circle5.name, circle6.name); // 출력 : 신사임당 강감찬

// 프로토타입의 constructor
console.log(circle5.constructor === Circle2); // 출력 : true
    // circle5에서 constuctor 있어? 없지?
    // 그럼 프로토타입에서 constructor 를 찾아. 있네?
    // 그 constructor가 가리키는 게 뭐야? 생성자 함수지? 그게 여기선 Circle2지?
    // 그 두 개가 같으니까 true가 된다.

// Circle2의 객체에 대한 property를 보자.
console.dir(circle5); // 출력 : Circle2
    // [[Prototype]]: Object
    //      그 중에 constructor: ƒ Circle2(radius)
    //      그 중에 [[Prototype]]: 얘도 프로토타입 객체야.
    //          얘의 constructor: ƒ Object(). Object()라는 생성자 함수.





// 객체 레벨에서 동적으로 상속 구조도 변경하기
console.log('---------- 객체 레벨에서 동적으로 상속 구조도 변경하기');

// prototype은 결국 상속구조를 나타내기 위한 방법
const obj1 = {} // 객체 literal 로 만든 빈 객체
const parent = { x : 1 };
obj1.__proto__ = parent; // 우리가 직접 prototype 객체 설정하기
console.log(obj1.x); // 출력 : 1

// literal을 이용한 객체 생성
var obj2 = {
    name : '홍길동'
}
console.dir(obj2); // 출력 : Object

// 생성자 함수를 이용한 객체 생성
function Circle3(radius) {
    this.radius = radius;
}
const circle7 = new Circle3(1);
console.dir(circle7);





// 객체 생성 중 prototype을 설정하는 좀 특별한 방법
console.log('---------- 객체 생성 중 prototype을 설정하는 좀 특별한 방법');

// 객체를 만들 때 이렇게도 만들 수 있다. (유일한 예외적인 경우)
const obj3 = Object.create(null);
    // 객체를 만들 때 내가 상위 prototype 객체를 지정해서 만들 수 있다.
    // null을 주면, 상위 prototype 객체를 사용하지 않는다는 의미
    // 이렇게 하면 [[Prototype]] 을 통한 chain이 존재하지 않게 된다.
    // __proto__ 를 아예 사용할 수 없게 되는 것.
    // 따라서 만약에 코드 안에 __proto__가 존재하게 되면 오류를 야기할 수도 있게 되므로,
    //      가급적 이 코드를 직접 사용하는 것은 권장되지 않는다.

// Object.create() 의 대체제 - Object.setPrototypeOf()
// 객체 literal로 생성
const obj4 = {};
const parent1 = {
    x : 1
}
Object.getPrototypeOf(obj4); // prototype 객체 리턴
Object.setPrototypeOf(obj4, parent1); // obj4의 prototype 객체를 parent1로 설정
console.log(obj4.x); // 출력 : 1





// non-constructor에는 존재하지 않는 prototype
console.log('---------- non-constructor에는 존재하지 않는 prototype');

// Arrow function을 활용하여 함수객체 생성
const person = (name) => {
    this.name = name;
}
console.log(person.prototype); // 출력 : undefined
    // prototype이라는 property가 없기 때문





// 지금까지 학습한 내용을 바탕으로 전체적인 그림 그려보기
console.log('---------- 강의 내용 종합해서 예시 코드 만들어보기');

function Circle4(radius) {
    this.radius = radius
}
Circle4.age = 20;
const circle8 = new Circle4(5);
console.dir(circle8); // 출력 : Circle4
console.log(circle8.age); // 출력 : undefined
    // property chain이 다르기 때문에 접근할 수 없다.





// Strict mode
console.log('---------- Strict mode');


function foo() {
    x = 10;
}
foo();
console.log(x); // 출력 : 10
    // 원래대로라면, x가 선언된 곳이 없기 때문에 찾을 수 없어야 한다.
    // 그런데 x가 아무데도 선언된 곳이 없기 때문에, foo() 에 있던 x를 전역변수로 바꾼다.
    // window객체의 property로 등록하는 것.
    // 이를 암묵적 전역(Implicit Global) 이라고 한다.
    // 자바 스크립트 특유의 특징이다.
// 이 특성때문에 JavaScript 초창기 교재는 변수 선언을 안 해도 된다고 적혀있었다.
// 틀린 얘기는 아니지만, 당연한 것은 아니다.
// 유지보수에도 도움이 안 되니까, 좀 더 정상적인 규칙으로 작성해보자.
// 'use strict';
// 위 문장을 전역에서 제일 위 혹은, 함수 안에서 제일 위애 적어둔다.
// 그러면 그 안에 있는 것들은 엄격하고 진지하게 검사하게 된다.
// 이상한 것들은 문법 오류가 잘 난다.
// 교수님은 쓰는 게 좋다고 생각하심.





// execution context stack 
console.log('---------- execution context stack ');

const x1 = 1; // 전역 코드 실행해야 하니 전역 실행 컨텍스트가 생성되고 실행된다.
function foo1() {
    const y = 2;
    function bar() {
        const z = 3;
        console.log(x1 + y + z);
    }
    bar();
}
foo1(); // 출력 : 6
// 전역 코드 : const x1 = 1; / function foo1() / foo1()
// 함수 코드 : const y = 2; / function bar() / bar()
// 그 안의 함수 코드 : const z = 3; / console.log(x1 + y + z);





// closure(클로저) 상황에서의 함수의 동작
console.log('---------- closure(클로저) 상황에서의 함수의 동작');

const x2 = 1;
function outer() {
    const x2 = 10; // 바깥의 x1과 다른 변수다. scope가 다르잖아.
    const inner = function() {
        // 함수 리터럴을 이용해서 함수 정의하는 함수 표현식
        console.log(x2); // lexical scope에 의해, x2가 가리키는 것은 지역변수 x2 이다.
    }
    return inner; // 함수가 함수를 리턴한다.
}
const result = outer();
result(); // 출력 : 10
    // 우리가 지금까지의 수업 내용을 제대로 이해했다면, 출력은 1 이라고 생각하는 것이 맞다.
    // 결국 남는 정보는 x2를 출력하라는 코드밖에 안 남았고, x2 정보는 전역 변수 x2만 남으니까.
    // 이런 현상을 closure 라고 부른다.
    // 이유를 알아보자.
    // inner() 함수는 리턴되면서 살아있는데, x2에 대한 reference가 아직 살아있다.
    //      lexical scope로 x2를 계속 가리키고 있어.
    //      이러면 stack에서 할당 해제될 떄, x2는 메모리에서 삭제되지 않는다.
    //      execution context에서는 빠질지언정, x2는 메모리에 계속 존재하는 거지.
    //      그래서 x2의 값이 계속 유지된다.
console.log(x2); // 출력 : 1

// 또 다른 예제
function foo2() {
    const x = 1;
    const y = 2;

    function bar() {
        const z = 3;
        // console.log(z); // 이렇게 하면, closure 아님
        console.log(x + z); // 이렇게 하면, closure 맞음
    }
    return bar;
}
const result1 = foo2();
result1(); // 출력 : 4





// closure 응용 예시
console.log('---------- closure 응용 예시 - 카운터');

let num = 0;
// 함수 리터럴을 이용한 함수 한 개 선언
const increase = function() {
    return ++num;
}
console.log(increase()); // 출력 : 1
console.log(increase()); // 출력 : 2
console.log(increase()); // 출력 : 3

// 이 카운터 값인 num을 외부에서 함부로 변경 못 하게 하고 싶어.
// 정보 은닉이라는 객체지향의 개념을 적용시켜보자.
// 우선 num 변수를 함수 안으로 넣어보자.
const increase1 = function() {
    let num1 = 0;
    return ++num1;
}
console.log(increase1()); // 출력 : 1
console.log(increase1()); // 출력 : 1
console.log(increase1()); // 출력 : 1
    // num1의 값이 증가가 안 돼. 초기화가 계속 일어나니까.
    // 지역 변수인데 계속 유지가 되게 하려면 어떻게 해야 할까?

// 함수를 리턴하자.
const increase2 = function() {
    let num2 = 0;
    return function() {
        return ++num2; // 
    };
}; // increase2 안에는 리턴되는 function()이 들어간다.
console.log(increase2()()); // 출력 : 1
console.log(increase2()()); // 출력 : 1
console.log(increase2()()); // 출력 : 1
// QQQ) 이거 왜 ()() 두 번 써야해?
    // A) ()만 썼을 때는 increase2() 를 실행시키고 리턴받은 함수 자체를 가리키는 거지, num2를 가리키는 것이 아니다.
    // ()()을 썼을 때는, 리턴받은 함수를 실행시켜서 다시 리턴받은 num2를 가리킨다.
// QQQ) 이거 왜 카운트 제대로 안 되지?
    // A) increase2() 함수를 실행시킬 때마다 num2가 새로 할당되기 때문

// 즉시 실행 함수로 만들자.
const increase3 = (function() {
    let num3 = 0;
    return function() {
        return ++num3; // 
    };
}()); // increase3 안에는 리턴되는 function()이 들어간다.
console.log(increase3()); // 출력 : 1
console.log(increase3()); // 출력 : 2
console.log(increase3()); // 출력 : 3
