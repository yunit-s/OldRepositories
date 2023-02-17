/**
 * 
 */

let flag = true;
function likeBtnFunc() {
	console.log("!! articleDetails.js.likeBtnFunc() 실행");
	
	let liked = "누르면 싫어함ㅠ";
	let noliked = "누르면 좋아함!!";
	
	$.ajax({
        url: "likeBtnClickedAJAX",
        async: true,
        data: {
            boardNum: $("#bNum").val()
        },
        type: "POST",
        dataType: "json",
        success: function(data) {
            // console.log("AJAX 호출 success");
            // console.log(data);
            $("#bLikeNumTbl").text(data.bLikeNum);
			if (data.isLiked == false) {
				$("#likeBtnId").text(noliked);
			} else {
				$("#likeBtnId").text(liked);
			}
        },
        error: function() {
            // console.log("AJAX 호출 error");
        }
    })
	
}