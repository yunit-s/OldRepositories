
// 230118_jQuery01.html 에서 읽혀짐

// alert('window 객체가 가지고 있는 함수'); // window.alert() 이거임.
    // blocking 함수. 확인을 누르기 전까지 시스템이 일단 멈춘다.

// 함수선언문으로 만든 일반함수
function myFunc() {
    console.log('input type="button" 누르면 실행되는 함수');
}





// jQuery의 기본 사용방법
//      원래는 맨 앞에 jQuery가 오면 되는데, 너무 기니가 $()로 표현한다.
//      $가 맨 처음에 나오면, jQuery를 사용하겠다고 이해하면 된다.
// 1. 기본 사용법
//      $('selector').method()
//      selector : CSS에서 사용하는 특수한 표기법
//      $('h1') : h1 element를 찾으라는 의미
//      method : jQuery에서 정해져있는 method. 특수한 기능 수행

function myFunc1() {
    // jQuery로 작업을 수행해보자.

    // 1. 전체 선택자(Universal selector) -> *
    $('*').css('color', 'red'); // 모든 element를 선택 -> 색상을 red로 변경

    // 2. 타입 선택자(Type selector) -> tag 이름으로 선택
    $('h1').remove(); // h1 태그들을 선택해서, 지운다.

    // 3. 아이디 선택자(ID selector) -> #id명 으로 선택
    //      모든 tag에는 id라는 속성이 붙을 수 있다.
    //      id의 중복은 허용되지 않는데, 사실 중복으로 만들어도 실행하는데 있어 오류가 발생하지는 않는다.
    console.log($('#kang').text()); // text() : 시작태그와 끝태그 사이의 문자값을 알아내는 method.

    // 4. 클래스 선택자(class selector) -> .class명으로 선택
    //      모든 tag에는 class라는 속성이 붙을 수 있다.
    //      class의 값은 중복을 허용한다.
    //      class는 기본적으로 style을 지정할 때 사용하는 속성이다. id와는 달리 목적이 정해져있는 속성.
    $('.class1').css('background-color', 'yellow'); // background-color : 배경색 바꾸기

    // 5. 구조 선택자(자식 선택자와 후손 선택자)
    //      자식 선택자 : > 기호를 활용한다. 다른 선택자와 함께 사용한다.
    $('div>div').text('div텍스트 변경하기'); // text('내용') : 값을 '내용'으로 변경하는 method. 이때는 log로 이상한 거 찍힌다.
    //      후손 선택자 : 공백
    $('div li').css('font-size', 12);

    // 6. 동위 선택자(+, ~)
    //      + : 바로 뒤에 나오는 형제를 지칭
    //      ~ : 내 뒤쪽에 나오는 모든 형제를 지칭
    // alert($('#kang + li').text());
    console.log($('#kang + li').text());
    $('#shin ~ *').css('color', 'blue');

    // 7. 속성 선택자 -> []
    //      속성으로 찾을 수 있다.
    console.log($('[type]').attr('value'));
        // type이라는 속성이 있는 값을 다 찾는다. 그리고 그 중 value라는 속성의 값을 알아낼 수 있다.

}

// 2. 또 다른 사용법
//      $