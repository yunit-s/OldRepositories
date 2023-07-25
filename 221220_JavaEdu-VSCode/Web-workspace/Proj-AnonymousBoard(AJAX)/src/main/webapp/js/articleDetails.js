/**
 * 
 */

// event functions
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
            // console.log('!! AJAX 호출 success');
			
            $('#bLikeNumTbl').text(data.bLikeNum);
			if (data.isLiked == false) {
				$('#likeBtnId').text(noliked);
			} else {
				$('#likeBtnId').text(liked);
			}
        },
        error: function() {
            console.log('!! AJAX 호출 error - likeBtnFunc()');
        }
    });
}

function editCommentBtnFunc(cNum) {
	console.log('!! articleDetails.js.editCommentBtnFunc() 실행');
	
	// 댓글 내용 칸을 <input> 으로 변경
	// 기존 댓글 내용은 hidden으로 가지고 있을 것
	let cContentTdText = $('#cContentTdId' + cNum).text();
	let cContentTagsStr = "";
	cContentTagsStr += '<input type="hidden" id="cContentPrev' + cNum + '" value="' + cContentTdText + '">';
	cContentTagsStr += '<input ';
	cContentTagsStr += 'type="text" ';
	cContentTagsStr += 'id="cContentInputId' + cNum + '" ';
	cContentTagsStr += 'value="' + cContentTdText + '">';
	let cContentTags = [];
	cContentTags.push(cContentTagsStr);
	$('#cContentTdId' + cNum).empty();
	$('#cContentTdId' + cNum).append(cContentTags);
	
	
	// 출력 버튼 변경 - 수정+삭제 -> 수정+취소
	let editCommentCompleteBtnTags = getMakingBtnTags(
		'editCommentCompleteBtnId' + cNum, 'editCommentCompleteBtnFunc(' + cNum + ')', '완료');
	let editCommentCancelBtnTags = getMakingBtnTags(
		'editCommentCancelBtnId' + cNum, 'editCommentCancelBtnFunc(' + cNum + ')', '취소');
	$('#editCommentTdId' + cNum).empty();
	$('#editCommentTdId' + cNum).append(editCommentCompleteBtnTags);
	$('#editCommentTdId' + cNum).append(' ');
	$('#editCommentTdId' + cNum).append(editCommentCancelBtnTags);
}

function editCommentCompleteBtnFunc(cNum) {
	console.log('!! articleDetails.js.editCommentCompleteBtnFunc() 실행');
	
	// 입력한 내용을 AJAX로 데이터 전달
	let cAuthor = $('#cAuthorTdId' + cNum).text(); // 필요한 정보는 아님
	let cContent = $('#cContentInputId' + cNum).val();
	let cDate = $('#cDateTdId' + cNum).text(); // 필요한 정보는 아님

	$.ajax({
        url: 'editCommentCompleteBtnClickedAJAX',
        async: true,
        data: {
            cNum,
			cAuthor, // 필요한 정보는 아님
			cContent,
			cDate // 필요한 정보는 아님
        },
        type: 'POST',
        dataType: 'json',
        success: function(data) {
            // console.log('!! AJAX 호출 success');

			if (data.result > 0) {
				// edit 성공 시
				// 내용 칸 수정
				$('#cContentTdId' + cNum).empty();
				$('#cContentTdId' + cNum).append(cContent);

				// 출력 버튼 변경 - 수정+취소 -> 수정+삭제
				let editCommentBtnTags = getMakingBtnTags(
					'editCommentBtnId' + cNum, 'editCommentBtnFunc(' + cNum + ')', '수정');
				let delCommentBtnTags = getMakingBtnTags(
					'delCommentBtnId' + cNum, 'delCommentBtnFunc(' + cNum + ')', '삭제');
				$('#editCommentTdId' + cNum).empty();
				$('#editCommentTdId' + cNum).append(editCommentBtnTags);
				$('#editCommentTdId' + cNum).append(' ');
				$('#editCommentTdId' + cNum).append(delCommentBtnTags);

			} else {
				// edit 실패 시
				// 아무 변화 없음
			}
            
        },
        error: function() {
            console.log('!! AJAX 호출 error - editCommentCompleteBtnFunc()');
        }
    });
}

function editCommentCancelBtnFunc(cNum) {
	console.log('!! articleDetails.js.editCommentCancelBtnFunc() 실행');

	// 내용 칸 되돌리기
	let cContentPrev = $('#cContentPrev'+ cNum).val();
	$('#cContentTdId' + cNum).empty();
	$('#cContentTdId' + cNum).append(cContentPrev);

	// 출력 버튼 변경 - 수정+취소 -> 수정+삭제
	let editCommentBtnTags = getMakingBtnTags(
		'editCommentBtnId' + cNum, 'editCommentBtnFunc(' + cNum + ')', '수정');
	let delCommentBtnTags = getMakingBtnTags(
		'delCommentBtnId' + cNum, 'delCommentBtnFunc(' + cNum + ')', '삭제');
	$('#editCommentTdId' + cNum).empty();
	$('#editCommentTdId' + cNum).append(editCommentBtnTags);
	$('#editCommentTdId' + cNum).append(' ');
	$('#editCommentTdId' + cNum).append(delCommentBtnTags);
}

function delCommentBtnFunc(cNum) {
	console.log('!! articleDetails.js.delCommentBtnFunc() 실행');

	$.ajax({
		url: 'delCommentBtnClickedAJAX',
		async: true,
		data: {
			cNum
		},
		type: 'POST',
		dataType: 'json',
		success: function(data) {
            // console.log('!! AJAX 호출 success');

			if (data.result > 0) {
				// delete 성공 시
				// 해당 row 삭제
				$('#commentTrId' + cNum).remove();
			} else {
				// delete 실패 시
				// 아무 변화 없음
			}
		},
		error: function() {
            console.log('!! AJAX 호출 error - delCommentBtnFunc()');
		}
	});
}

function addCommentBtnFunc() {
	console.log('!! articleDetails.js.addCommentBtnFunc() 실행');
	
	let bNum = $('#bNum').val();
	let newCommentContent = $('#addCommentInputId').val();

	$.ajax({
		url: 'addCommentBtnClickedAJAX',
		async: true,
		data: {
			bNum,
			newCommentContent
		},
		type: 'POST',
		dataType: 'json',
		success: function(data) {
            // console.log('!! AJAX 호출 success');

			$('#commentTbodyId').append(getMakingCommentRowTags(data.cNum, data.cAuthor, data.cContent, data.cDate));
		},
		error: function() {
            console.log('!! AJAX 호출 error - addCommentBtnFunc()');
		}
	});
}





// general functions
function getMakingBtnTags(id, eventFunc, content) {
	// .text() 로는 태그 문자열을 넣어도 HTML 코드로 인식되지 않는다.
	// jQuery로는 .jsp에서 <%= %> 표현식 적용 안 됨
	let makingBtnTagsStr = "";
	makingBtnTagsStr += '<button ';
	makingBtnTagsStr += 'id="' + id + '" ';
	makingBtnTagsStr += 'onclick="' + eventFunc + '">';
	makingBtnTagsStr += content;
	makingBtnTagsStr += '</button>';
	let makingBtnTags = [];
	makingBtnTags.push(makingBtnTagsStr);
	return makingBtnTags;
}

function getMakingCommentRowTags(cNum, cAuthor, cContent, cDate) {
	let makingCommentRowTagsStr = "";
	makingCommentRowTagsStr += '<tr id="commentTrId' + cNum + '">';
	makingCommentRowTagsStr += '<td id="cAuthorTdId' + cNum + '">' + cAuthor + '</td>';
	makingCommentRowTagsStr += '<td id="cContentTdId' + cNum + '">' + cContent + '</td>';
	makingCommentRowTagsStr += '<td id="cDateTdId' + cNum + '" style="text-align: center">' + cDate + '</td>';
	makingCommentRowTagsStr += '<td id="editCommentTdId' + cNum + '" style="text-align: center">';
	makingCommentRowTagsStr += getMakingBtnTags('editCommentBtnId' + cNum, 'editCommentBtnFunc(' + cNum + ')', '수정');
	makingCommentRowTagsStr += ' ';
	makingCommentRowTagsStr += getMakingBtnTags('delCommentBtnId' + cNum, 'delCommentBtnFunc(' + cNum + ')', '삭제');
	makingCommentRowTagsStr += '</td></tr>';
	let makingCommentRowTags = [];
	makingCommentRowTags.push(makingCommentRowTagsStr);
	return makingCommentRowTags;
}