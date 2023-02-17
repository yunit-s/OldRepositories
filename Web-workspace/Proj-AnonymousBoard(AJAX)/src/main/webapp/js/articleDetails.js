/**
 * 
 */

function likeBtnFunc() {
	console.log('!! articleDetails.js.likeBtnFunc() 실행');
	
	let liked = '누르면 싫어함ㅠ';
	let noliked = '누르면 좋아함!!';
	
	$.ajax({
        url: 'likeBtnClickedAJAX',
        async: true,
        data: {
            boardNum: $('#bNum').val()
        },
        type: 'POST',
        dataType: 'json',
        success: function(data) {
            // console.log('AJAX 호출 success');
            // console.log(data);
            $('#bLikeNumTbl').text(data.bLikeNum);
			if (data.isLiked == false) {
				$('#likeBtnId').text(noliked);
			} else {
				$('#likeBtnId').text(liked);
			}
        },
        error: function() {
            // console.log('AJAX 호출 error');
        }
    })
}

function editCommentBtnFunc(cNum) {
	console.log('!! articleDetails.js.editCommentBtnFunc() 실행');
	
	// 댓글 내용 칸을 <input> 으로 변경
	let cContentTdText = $('#cContentTdId' + cNum).text();
	let cContentTagsStr = "";
	cContentTagsStr += '<input ';
	cContentTagsStr += 'type="text" ';
	cContentTagsStr += 'id="cContentInputId' + cNum + '" ';
	cContentTagsStr += 'value="' + cContentTdText + '">';
	let cContentTags = [];
	cContentTags.push(cContentTagsStr);
	$('#cContentTdId' + cNum).empty();
	$('#cContentTdId' + cNum).append(cContentTags);
	
	
	// 수정, 삭제 버튼 대신에 수정완료 버튼 출력
	let editCommentBtnTagsStr = "";
	editCommentBtnTagsStr += '<button ';
	editCommentBtnTagsStr += 'id="editCommentBtnId" ';
	editCommentBtnTagsStr += 'onclick="editCommentCompleteBtnFunc(' + cNum + ')">';
	editCommentBtnTagsStr += '수정완료';
	editCommentBtnTagsStr += '</button>';
	let editBtnTags = [];
	editBtnTags.push(editCommentBtnTagsStr);
	$('#editCommentTdId' + cNum).empty();
	$('#editCommentTdId' + cNum).append(editBtnTags);
	
	// .text() 로는 태그를 넣어도 HTML 코드로 인식되지 않는다.
	// $('#editCommentTdId').text(tags);
}

function editCommentCompleteBtnFunc(cNum) {
	console.log('!! articleDetails.js.editCommentCompleteBtnFunc() 실행');
	
	// 입력한 내용을 AJAX로 데이터 전달
	let cAuthor = $('#cAuthorTdId' + cNum).text();
	let cContent = $('#cContentInputId' + cNum).val();
	let cDate = $('#cDateTdId' + cNum).text();

	console.log(cNum, cAuthor, cContent, cDate);
	// console.log($('#cContentInputId' + cNum).val());

	$.ajax({
        url: 'editCommentCompleteBtnClickedAJAX',
        async: true,
        data: {
            cNum,
			cAuthor,
			cContent,
			cDate
        },
        type: 'POST',
        dataType: 'json',
        success: function(data) {
            console.log('AJAX 호출 success');
            console.log(data);
            // $('#bLikeNumTbl').text(data.bLikeNum);
			// if (data.isLiked == false) {
			// 	$('#likeBtnId').text(noliked);
			// } else {
			// 	$('#likeBtnId').text(liked);
			// }
        },
        error: function() {
            console.log('AJAX 호출 error');
        }
    })
}