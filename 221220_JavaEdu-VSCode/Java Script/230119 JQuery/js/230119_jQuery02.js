
// event handler (이벤트를 처리하는 JavaScript 함수)
function onMouseEnterFunc() {
    // 1. 이벤트가 발생한 객체 찾기
    // event //deprecated 의 표시인데, vscode에서 이렇게 만들어뒀다. 신경쓰지 말자.
    // event.target : 이벤트 소스. 여기서는 li 문서객체가 된다.
    // li : 문서 객체
    // $() 로 묶어야 jQuery 객체가 된다.
    $(event.target).css('color', 'red');
    $(event.target).css('background-color', 'yellow');

}
function onMouseLeaveFunc() {
    $(event.target).css('color', 'black'); // CSSOM을 바꾼다.
    $(event.target).css('background-color', 'white');   
}

// jQuery의 css() 함수 대신 addClass() 를 활용해보자.
function onMouseEnterFunc2() {
    // addClass 미리 만들어둔 CSS를 한 번에 적용시키는 함수
    $(event.target).addClass('myEnterStyle');

}
function onMouseLeaveFunc2() {
    $(event.target).removeClass('myEnterStyle');
}

// div 이벤트 핸들러
function divOnClickFunc() {
    alert('div 클릭됨')
}

// 버튼 이벤트 핸들러
function btnOnClickFunc() {
    alert('버튼 클릭됨');
    // Event Propagation 현성
    // div 영역과 겹치기 떄문에, divOnClickFunc() 도 실행되게 된다.
}
