
function btnOnClickFunc() {
    $('ul > li').each(function(idx, item) {
        // each : 각각 반복하란 뜻. callback 함수다.
        // idx : 순번. 0부터 시작해서 호출될 때마다 1씩 증가
        // item : 현재 사용되는 문서 객체(document object)
        console.log(idx, $(item).text());
    });
}
function removeBtn() {
    // button[disabled] : button인데 속성 중에 disabled 속성을 가지고 있는 것
    // removeAttr() : 특정 속성을 삭제시키기
    $('button[disabled]').removeAttr('disabled');
}
function btnOnClickFunc2() {
    alert($('button[disabled]').attr('data-author')); // attr(인자 1개) : 속성의 값 알아내기
    alert($('button[disabled]').attr('data-author', '신사임당')); // attr(인자 2개) : 속성의 값 변경하기
}