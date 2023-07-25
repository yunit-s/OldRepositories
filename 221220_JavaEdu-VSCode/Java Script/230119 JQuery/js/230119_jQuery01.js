
// 이벤트 처리하기

function onClickFunc() {
    // delegation model의 이벤트 핸들러
    // 이 핸들러 안에 event객체가 전달된다.
    // event 객체 : event가 발생되었을 때, event의 세부 정보를 가지고 있는 객체
    console.log('클릭됨'); // 출력 : 클릭됨
    console.log(event); // 출력 : event객체에 대한 정보
        // PointerEvent {isTrusted: true, pointerId: 1, width: 1, height: 1, pressure: 0, …}
        //      여기 안에 있는 것들 중, target 은 div를 가리키고 있어.
        //      event.target 이라고 하면, 그게 바로 event source 를 지칭한다.
    console.log(event.target);
        // 출력 : <div onclick="onClickFunc()">클릭하면 onClickFunc() 실행됨</div>
    console.log($(event.target).text()); // 출력 : 클릭하면 onClickFunc() 실행됨
}
function onDblClickFunc() {
    console.log('더블클릭됨');
}
function onChangeFunc() {
    console.log('select box 변경됨');

    // 셀렉트박스로 선택된 값을 출력하기
    // $('select > option:selected') : 선택된 값을 jQuery 객체로 만듦
    $('div#nameDiv').text($('select#changeSelected > option:selected').text());
}