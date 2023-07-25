<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax test (jsp)</title>

    <!-- jQuery를 사용하기 위한 CDN 설정  -->
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
        integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
        crossorigin="anonymous">
    </script>

</head>
<body>

	<div>
		<h3>jsp에서 AJAX 호출 테스트</h3>
		<button onclick="btnFunc()">btnFunc() 호출</button>
		<div id="strDiv1"></div>
		<div id="strDiv2"></div>
		<div id="strDiv3"></div>
		<div id="strDiv4"></div>
	</div>
	
	
	
	
	
	<script>
		let str1 = 'ajax 송신 전';
		let str2 = 'str2 데이터';
		let str3 = 'str3 데이터';
		let str4 = 'str4 데이터';
		$('#strDiv1').text(str1);
		$('#strDiv2').text(str2);
		$('#strDiv3').text(str3);
		$('#strDiv4').text(str4);
		function btnFunc() {
			console.log('btnFunc() 실행');
			$.ajax({
		        url: 'AjaxTest',
		        async: true,
		        data: {
		            data1: str1,
		            data2: str2
		        },
		        type: 'POST',
		        dataType: 'json',
		        success: function(data) {
		            console.log('AJAX 호출 success');
		            console.log(data);
		            
		            $('#strDiv1').text(data.data1_str);
		            $('#strDiv2').text(data.data2_str);
		            $('#strDiv3').text(data.data3_arr);
		            $('#strDiv4').text(data.data4_arr);
		        },
		        error: function() {
		            console.log('AJAX 호출 error');
		        }
		    })
		}
	</script>
</body>
</html>