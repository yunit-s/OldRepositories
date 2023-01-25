
function searchBtn() {
    // 날짜 데이터를 가져와서, AJAX를 호출하자.
    $.ajax({
        async: true, // 비동기 처리
        url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json', // 서버쪽 프로그램에 대한 주소
        type: 'GET',
        timeout: 3000, // 1/1000 초 단위로 초를 적는다.
            // 이 시간 안에 성공이 되지 않으면, 실패로 처리한다.
        data: {
            // 서버에 보내야하는 데이터를 객체 형태로 보내준다.
            key: 'e8b19160d24b80d241f860153813316d', // 영화진흥위원회 오픈API에서 발급받은 key 입력
            targetDt: ($('[type=date]').val()).replace(/-/g, '') // type이 data인 태그에서 그 안에 있는 값 받아오기.
                // val() 그대로만 쓰면 '-'가 포함돼서 받아진다. 우리가 서버에 보내야 하는 형식은 '-'가 없는 YYYYMMDD 형식이어야 한다.
                // java script 문자열 치환을 하자. 대쉬를 공백으로 바꾸자.
                //      /-/ : 정규 표현식. 두 / / 사이에 있는 -를 찾아서 '' 로 바꾸기
        },
        dataType: 'json', // default 값이 json. 지금같은 경우는 안 적어도 된다.
        success: function(data) {
            $('tbody').empty(); // 기존 tbody의 내용 비우기
            // alert('ajax success!');

            // 성공하면, 서버는 그 결과값을 JSON 문자열로 전달한다.
            //      이렇게 받은 문자열을 분석해서 결과처리를 해야 한다.
            //      이 JSON 문자열 처리가 쉽지 않다.
            //      이걸 객체로 변경해서 우리에게 함수의 인자(우리가 설정한 인자이름 data)로 전달해준다.

            // 이제 이 JSON을 분석하자.
            //      이 결과물의 예시를 영화진흥위원회 오픈API 쪽에서 보여주고 있다.
            //      http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101
            //      object {1} : 최상위 객체의 property가 한 개 있다.
            //      boxOfficeResult {3} : 이 안에 property 를 보니, 이 키가 존재한다. 얘도 객체고, 이 안에 property를 3개 가지고 있다.
            //      boxofficeType, showRange, dailyBoxOfficeList
            //      이 중 dailyBoxOfficeList를 가져올 건데, 대괄호 [10] 가 있네? 데이터 10개를 가지고 있는 배열이라는 의미다.
            let arr = data.boxOfficeResult.dailyBoxOfficeList;
            // 배열 안의 각 요소에 대해서 특정 기능을 반복해서 처리하려 한다.
            //      이를 함수로 만들어서 호출(callback)하자.
            $.each(arr, function(idx, item) {
                // idx : 첨자. 인덱스. 반복할 때마다 숫자가 증가하는 index
                // item : 반복할 때마다 추출되는 배열 안에 있는 원소

                // 데이터 잘 가져오는 지 확인해보기
                // console.log(item.movieNm);

                // 가져온 데이터를 이용해서 화면처리하기
                // AJAX의 장점 : round trip 방식이 아니라서 현재 클라이언트가 보는 화면은 그대로 남아있다. 딱 필요한 부분만 바뀌게 되는 것.

                // 새로운 태그 만들기
                // <tr>
                //     <td>1,001</td>
                //     <td><img src="주소"></td>
                //     <td>random</td>
                //     <td>data</td>
                //     <td>placeholder</td>
                //     <td>text</td>
                //     <td><button class="btn btn-danger">삭제</button></td>
                // </tr>
                // JQuery가 가진 문제점
                //      새로운 html 태그를 만들 때, 그 html 코드들을 구현하는 데 필요한 노동이 너무 심하다.
                //      이런 방식은 사실 좋지 않다. 만들어낼 내용이 적어서 괜찮아 보이지만, 규모가 커지면 아주 노동집약적인 방식이지.
                let tr = $("<tr></tr>"); // <tr></tr>
                let ranktd = $("<td></td>").text(item.rank); // <td>1</td>
                let postertd = $("<td></td>");
                let posterImg = $("<img />");
                postertd.append(posterImg);

                // 이미지를 가져오기 위한 AJAX 호출하기
                $.ajax({
                    async: true,
                    // 카카오 이미지 검색. 구글에서 kakao developer 검색하기
                    //      로그인 - 내 애플리케이션 - REST API 키 복사
                    //          e5511dcd4332e8a8fb811afe1f102815
                    //      문서 - Daum 검색 - REST API - Sample 보고 만들기
                    //          url : "https://dapi.kakao.com/v2/search/image"
                    url: 'https://dapi.kakao.com/v2/search/image',
                    type: 'GET',
                    data: {
                        // parameter 완성하기. Required 는 필수로 들어가야 한다.
                        // ajax() 도 함수이기 때문에, 상위 함수 스코프에 있던 item을 활용할 수 있다.
                        query: item.movieNm + ' 포스터'
                    },
                    headers: {
                        // 인증에 대한 정보 입력
                        // Authorization: 'KakaoAK ${REST_API_KEY}'
                        Authorization: 'KakaoAK e5511dcd4332e8a8fb811afe1f102815'
                    },
                    success: function(data) {
                        console.log('영화 포스터 검색 성공');

                        // sample에 보면, meta 와 documents 라는 키값이 있다. 여기에서 사진 정보를 가져오자.
                        let imgurl = data.documents[0].thumbnail_url;
                        posterImg.attr('src', imgurl); // src 속성에 imgurl 값 넣어주기

                        // 사실, 여기서 closure 특성을 활용하게 된다.
                        //      posterImg 라는 지역변수는 사실, 함수를 새로 호출할 때마다 초기화된다.
                        //      그런데 클로저의 특성으로 인해, 기존에 이용됐던 posterImg 라는 지역변수에 대한 링크를 유지할 수 있게 된다.
                    },
                    error: function() {
                        console.log('영화 포스터 검색 실패');
                    }
                });
                let titletd = $("<td></td>").text(item.movieNm);
                let audtd = $("<td></td>").text(item.audiCnt);
                let opentd = $("<td></td>").text(item.openDt);
                let deltd = $("<td></td>");
                let delBtn = $("<button></button>").text('삭제').addClass('btn btn-danger');
                deltd.append(delBtn);
                // delBtn.on('click); // 삭제 버튼에 클릭 이벤트에 대한 이벤트 핸들러(이벤트 처리 함수)를 등록하기
                // delBtn.click(); // 윗 줄의 축약형 표현
                delBtn.click(function() {
                    // 여기에 이벤트를 붙일 때는 onclick 속성보다는, jQuery 이벤트 방식을 활용하는 것이 좋다.
                    //      훨씬 간단하고 좋다.

                    // jQuery event 처리 방식에서(일반 javascript에서는 안 이런다.) 이벤트 핸들러에 this가 등장하면,
                    //      이 this는 event source 문서 객체를 지칭한다.
                    // $(this); // 이렇게 쓰면, 여기서 this 는 <button class="btn btn-danger">삭제</button> 를 가리킨다.
                    //      이 this의 부모는 <td>고, 부모의 부모가 <tr>이 된다.
                    
                    $(this).parent().parent().remove(); // 해당 줄 지우기
                        // parent() : 자기 부모에 대한 객체 리턴. jQuery 함수다.
                        // remove() : 삭제
                });
                tr.append(ranktd); // 자식으로 붙이기
                tr.append(postertd);
                tr.append(titletd);
                tr.append(audtd);
                tr.append(opentd);
                tr.append(deltd);
                $('tbody').append(tr);

            });
        },
        error: function() {
            alert('ajax error!');
        }
    });

    // 여기서, 우리가 클릭한 건 <a> 태그다. 즉, 링크야.
    //      href에 적힌 url로 페이지를 전환한다.
    //      <a>는 default event를 가지고 있다.
    //      그래서 default event를 막아줘야 한다.
    event.preventDefault(); // default event 막기

}