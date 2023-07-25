
// 함수 선언문 - Event Handler (이벤트를 처리하는 주체)
function btnOnClick() {
    alert('btn 클릭됨');

    // jQuery를 이용해서 AJAX 호출
    // $() : 무언가 태그를 찾거나, 태그를 새로 생성할 때 사용
    //      $ : 그냥 호출만 할 거야
    // $.ajax() // jQuery가 가지고 있는 ajax() 함수 바로 호출하기.
    // 호출할 때 여러 가지 정보 입력하기
    // 그 여러 가지 정보를 객체 literal {}을 이용, 객체로 만들어서 인자로 전달한다.
    $.ajax({
        // url: AJAX 호출할 서버쪽 프로그램 URL
        url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
            // 내가 호출할 서버의 주소. 정해져있는 key값이기 때문에 오타나면 안 된다.
        // async: 비동기방식으로 호출할 것인지 동기방식으로 호출할 것인지의 여부
        //      기본값은 true (비동기 방식)
        async: true,
        // 서버쪽 프로그램에게 전달할 데이터를 명시한다. 여러 개의 데이터를 vvvv전달하기 때문에 객체를 이용한다.
        data: {
            key: 'e8b19160d24b80d241f860153813316d',
            targetDt: '20230119'
        },
        // type : AJAX 호출 방식. GET or POST
        type: 'GET',
        // 호출 결과를 어떤 데이터형식으로 받을 지 결정
        // default 값이 JSON. 이거는 대소문자 구별 없음
        dataType: 'json',
        // 이런 내용을 가지고 호출하면 결국 둘 중 하나다. 성공하던가 에러나던가.
        // 성공할 경우
        //      서버가 보내준 JSON 문자열을 jQuery가 JavaScript객체로 변환하고
        //      그 객체를 success의 실행함수에 인자로 전달한다.
        success: function(data) {
            console.log('호출 success');
            console.log(data);
            // console.log(data.boxOfficeResult.dailyBoxOfficeList[0].movieNm);
            let title = data.boxOfficeResult.dailyBoxOfficeList[0].movieNm;
            console.log(title);
            // $('div > div').text(title);
            $('div > div:after').text(title);

            // 결국 우리가 하는 일련의 과정은
            //      AJAX 호출해서 ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
            // 
            // 

        },
        error: function() {
            console.log('호출 error');
        }

    });
}
