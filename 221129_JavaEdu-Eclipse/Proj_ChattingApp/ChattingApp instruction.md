## App instruction(사용설명서)
1. 서버 구동하기
>- ChatServer.class 를 실행시킨 후, 'Server Start' 버튼 클릭
>- ServerSocket 생성, 새 쓰레드에서 클라이언트 접속을 계속해서 기다림

2. 클라이언트 접속
>- ChatClient.class 를 실행
>- 서버의 IP와 Port 번호, 자신의 이름을 입력 후, 'Connect Server' 버튼 클릭(서버와 연결 이후 자신의 이름 수정 불가)
>- 'send to'에 받을 사람의 이름 적고, 그 오른쪽에 채팅 내역 입력.
>- 자신의 화면에는 `Me>` 로 출력됨.
받는 사람에 `everyone` 입력 시, 모든 사람에게 전송됨.
받는 사람이 접속 중이지 않을 때는 `offline` 오류메시지 출력됨.