
// hoisting은 var, let, const 모두 적용되는 특성이다.
let myVar = 1; // 전역변수(global variable)
{
    console.log(myVar); // 1 출력
}

let myVar2 = 1; // 전역변수(global variable)
{
    console.log(myVar2); // hoisting으로 인해, 지역변수를 가리키게 된다. 초기화가 안 된 것으로 인식하고 오류
    let myVar2 = 100; // hoisting이 일어난다.
}