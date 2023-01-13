
// literal
// 문자열

var tmp = '소리없는 아우성!'
tmp = "소리없는 아우성!"
tmp = `소리없는 아우성!` // 특수 기능이 포함된 문자열

if (true) { } // 이런 {}는 literal 아님

// 객체 literal
// 객체도 값이니까 하나의 변수에 저장할 수 있다.
tmp = {
    myName: '홍길동',
    myAddress: '서울'
}

// 함수 또한 literal이고, 값이니까 하나의 변수에 저장할 수 있다.
var tmp1 = function myFunc() {
    console.log("깔깔깔!");
}

