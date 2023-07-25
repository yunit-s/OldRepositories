
/*
// 초기 환경설정 테스트

// node.js를 이용해서 그냥 JavaScript code를 실행시키자.

// 자바스크립트는 ArrayList가 없다.
// java때는 프로그램의 entry point가 명확해. 그런데 js는 그런게 없어. 그냥 위에서부터 시작해.
// Javascript의 기본 자료구조는 Array(배열) 이다.

const myArray = [1,2,3,4]

// 기본 for 구문. 이거 되긴 하는데, 잘 안 쓴다.
for (var i=0; i<10; i++) {

}

// forEach 구문 사용
myArray.forEach(function(data) {
    console.log('바뀌었어요 : ' + data) // 세미콜론은 찍어도 되고 안 찍어도 된다.
})
*/





/*
// alert()
// 경고창 띄우기
// alert() 은 browser가 가지고 있는 API이다.
alert('소리없는 아우성') // blocking 함수
*/





// 변수 선언하기
var result = 100;





// JavaScript 변수는 특이한 성질을 가지고 있어요!
// hoisting 특성
console.log(num1); // Error 안 생김
var num1;
// num1 선언이 아래에 있어도 JavaScript에서는 Error가 아니다.
// 그 이유가 바로 Hoisting 특성이다.
// JavaScript의 실행은 2개의 Phase로 실행된다.
// 1 phase : Creating Phase
//      모든 선언 구문을 찾는다. 식별자를 메모리에 맵핑한다.(변수화시키기)
// 2 phase : Execution Phase
//      처음으로 돌아가서 코드를 실행한다.

