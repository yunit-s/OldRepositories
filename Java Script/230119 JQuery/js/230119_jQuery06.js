
console.log('js코드 실행');

// document 문서객체
//      javascript가 제공해준다.
//      DOM을 지칭한다.

// $(document).on('ready')
    // document가 ready가 되었다?
    //      DOM 객체가 생성이 되었다는 의미
    //      브라우저가 html을 모두 읽어서 파싱까지 끝냈다는 의미
    //      즉, 브라우저가 html을 모두 읽은 시점을 의미

// 원형으로 작성했을 경우
// 이거 동작 안 되네. 지금 우리가 쓰는 게 jQuery 3.0인데, 3.0 되면서 이거 동작 안 되게 바뀐 듯...
// $(document).on('ready', function() {});

// 축약형으로 작성했을 경우
// $(document).ready(function() {
//     // click에 의한 핸들러 추가하기
//     $('ul > li').click(function() {
//         alert('클릭됨');
//     });
// });

// 이러한 코드가 워낙 많이 사용되니까 더 축약형 코드가 있다.
//      $()
//      그냥 이렇게 쓰고, 이 안에 그 내용을 적으면 된다.
$(function() {
    console.log('document 준비됨');
    $('ul > li').click(function() {
        // JavaScript에서 this의 의미는 크게 3가지
        //  1. 일반 함수에서 this
        //      -> window 객체 (전역 객체)
        //  2. 객체의 함수에서 this
        //      -> 함수를 호출한 객체를 지칭
        //  3. 생성자 함수에서 this
        //      -> 생성자 함수가 생성하는 객체를 지칭

        // jQuery event 처리와 관련해서
        // event handler 안에 this가 나오면, 그 this는 event source에 대한 문서 객체를 가리킨다.
        alert($(this).text());
    });
});

function anchorOnClickFunc() {
    alert('링크가 클릭됨');

    // default event 실행 중지시키기
    event.preventDefault();
}