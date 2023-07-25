
function innerFunc() {
    alert('버튼 클릭됨. innerFunc() 실행됨');
    
    // propagation 현상 중지시키기
    //      이를 통해, 상위 컴포넌트에게 이벤트가 전달되는 것을 막을 수 있다.
    event.stopPropagation();
}
function outerFunc() {
    alert('div가 클릭됨. outerFunc() 실행됨.');
}