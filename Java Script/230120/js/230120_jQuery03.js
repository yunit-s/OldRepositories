
function addImg() {
    // KAKAO 이미지 검색을 해서, 그 중 첫 번째 이미지를 이용해서 DIV에 붙이기
    // 
    console.log('addImg 실행됨');
    $.ajax({
        async: true, // 뭔지는 모르지만 일단 기본값 잡자.
        url: "https://dapi.kakao.com/v2/search/image", // 서버 url
        type: 'GET', // 클라이언트가 서버쪽에 AJAX를 보내는 방식
        // sample 코드에서 -H : 헤더에 포함시키라는 의미
        headers: {
            // 인증하기
            // Authorization: 'KakaoAK ${REST_API_KEY}'
            Authorization: 'KakaoAK e5511dcd4332e8a8fb811afe1f102815'
        },
        data: {
            query: '아바타2' // 검색어
        },
        dataType: 'json',
        success: function(data) {
            alert('addImg() success');

            // kakao 예시 보면, documents 뒤에 [] 가 있다? -> 배열이다.
            let imgurl = data.documents[0].thumbnail_url;
            let myImg = $('<img />').attr('src', imgurl); // 새롭게 붙일 태그 정보 저장
            $('div').append(myImg); // 화면에 붙이기
        },
        error: function() {
            alert('addImg() error');
        }
    });
}
