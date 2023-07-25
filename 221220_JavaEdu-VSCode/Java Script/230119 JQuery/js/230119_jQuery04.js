
function btnOnClickFunc() {
    // 구성요소 삭제하기
    // $('#innerDiv').remove(); // 대상 삭제. html 코드 안에서 아예 그 코드가 삭제된다.

    // 구성요소 숨기기, 나타내기
    // $('#innerDiv').hide(); // 대상 숨김. html 코드 안에 style="display: none;" 이라는 속성이 추가된다.
    // $('#innerDiv').show(); // 숨겨진 대상 나타내기

    // 구성요소의 후손만 삭제하기
    $('#innerDiv').empty(); // 대상의 후손만 코드가 삭제된다.
}
function display_inputtext() {
    alert($('#textIDbootstrap').val()); // 입력상자 안의 값을 가져와서 알림창에 띄우기
}