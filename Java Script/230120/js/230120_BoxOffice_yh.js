
function btnTest() {
    console.log('btnTest() 실행');
    console.log($('header > input').val());
    // console.log($('input[aria-label]').val());

    console.log('체크용');
    $.ajax({
        url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
        async: true,
        data: {
            key: 'e8b19160d24b80d241f860153813316d',
            targetDt: $('input[aria-label]').val()
        },
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log('AJAX 호출 success');
            console.log(data);
            console.log(data.boxOfficeResult.length);

            for (let i = 0; i < 10; i++) {
                // 데이터 가져오기
                let title = data.boxOfficeResult.dailyBoxOfficeList[i].movieNm;
                let rank = data.boxOfficeResult.dailyBoxOfficeList[i].rank;
                let audiCnt = data.boxOfficeResult.dailyBoxOfficeList[i].audiCnt;
                let opendt = data.boxOfficeResult.dailyBoxOfficeList[i].openDt;
    
                // 태그 붙이기
                // <tr>
                //     <td><input type="checkbox"></td>
                //     <td>1,001</td>
                //     <td>random</td>
                //     <td>data</td>
                //     <td>placeholder</td>
                //     <td>text</td>
                //     <td><button class="btn btn-warning" onclick="btnDelete()">삭제</button></td>
                // </tr>
    
                let tr = $("<tr></tr>"); // <tr></tr>
                let cboxtd = $('<td><input type="checkbox"></td>');
                // let inputdate = $("<input>").attr('type', 'checkbox');
                // let cboxtd = $("<td><input></td>");
                // cboxtd.attr('type', 'checkbox');
                let ranktd = $("<td></td>").text(rank) // <td>1</td>
                let imgtd = $("<td></td>").text('imglink');
                let titletd = $("<td></td>").text(title);
                let audiCnttd = $("<td></td>").text(audiCnt);
                let opendttd = $("<td></td>").text(opendt);
                let deleteBtntd = $('<td><button class="btn btn-warning" onclick="btnDelete()">삭제</button></td>');
    
                tr.append(cboxtd);
                tr.append(ranktd);
                tr.append(imgtd);
                tr.append(titletd);
                tr.append(audiCnttd);
                tr.append(opendttd);
                tr.append(deleteBtntd);
    
                $('tbody').append(tr); // 가져온 tr을 화면에 붙이기
            }
            
        },
        error: function() {
            console.log('AJAX 호출 error');
        }
    })
}

function btnDelete() {
    console.log('삭제시키기');
}
