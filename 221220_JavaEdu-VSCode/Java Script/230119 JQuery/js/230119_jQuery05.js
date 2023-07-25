
function btnOnClickFunc() {
    // jQuery를 이용해서 새로운 element 생성하기
    // let newli = $('<li></li>').text('이순신');
        // <li>이순신</li>
    // let newli = $('<li></li>').text('이순신').attr('id', 'btnID').addClass('btnStyle');
        // <li id="btnID" class='btnStyle'>이순신</li>

    // 생성한 jQuery객체를 내가 원하는 곳에 부착시키기
    // 방식은 총 4가지
    //      1. append() : 자식 중 제일 마지막 자식으로 붙이기
    // $('ul').append(newli);
    //      2. prepend() : 자식 중 제일 앞 자식으로 붙이기
    // $('ul').prepend(newli);
    //      3. before() : 형제 중 바로 앞 형제로 붙이기
    // $('ul > li:last').before(newli);
    //      4. after() : 형제 중 바로 뒤 형제로 붙이기
    // $('ul > li:first').after(newli);
    
    // 새 이미지 부착하기
    // img 태그에는 끝 태그가 없기 때문에 대신에 태그 마지막에 /를 붙인다.
    let newimg = $('<img />').attr('src', './image/coffee.jpg'); // <img src='./image/coffee.jpg' />
    $('ul').after(newimg);

}
function btnAddHandler() {
    // 기본 코드
    // 1. 이벤트 핸들러를 붙일 element 찾기
    //      <li>강감찬<li>
    // 2. 이벤트 핸들러를 특정 이벤트에 등록하기
    // $('ul > li:last').on('click', function() {
    //     // 이벤트 처리 내용
    //     console.log('강감찬 클릭됨');
    //     // 여기서 {} 는 callback 메소드
    // });

    // 축약형 코드
    $('ul > li:last').click(function() {
        console.log('강감찬 클릭됨-축약형');
    });

    // 이벤트는 이렇게 jQuery로 등록하고 사용하는 방식으로 구현해서
    //      html의 코드에 속성을 명시하는 경우가 더 적다.
    //      JavaScript code로 표현하는 경우가 더 많음. 이게 작성하기도 더 쉽다.

    // 주의할 점 3가지

}