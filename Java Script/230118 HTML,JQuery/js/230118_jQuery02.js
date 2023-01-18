
/*
    연습문제
    버튼을 클릭하면, 다음과 같은 순서대로 console에 출력하세요.
    
    사과
    파인애플
    참외
    myID
    고양이
    호랑이
    강아지
*/

function button() {
    console.log($('#apple').text()); // 출력 : 사과
    console.log($('#apple + li').text()); // 출력 : 파인애플
    console.log($('ul > li.myList').text()); // 출력 : 참외
    console.log($('form > input').attr('id')); // 출력 : myID

    console.log($('ol > li:first').text()); // 출력 : 고양이
    console.log($('ol > li:first + li').text()); // 출력 : 호랑이
    console.log($('ol > li:last').text()); // 출력 : 강아지

}