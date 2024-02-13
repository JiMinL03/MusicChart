const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
	container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
	container.classList.remove("active");
});

function registerFormM() {
	var userName = document.forms["registerForm"]["userName"].value;
	var userEmail = document.forms["registerForm"]["userEmail"].value;
	var userId = document.forms["registerForm"]["userId"].value;
	var userPassword = document.forms["registerForm"]["userPassword"].value;
	var userRPassword = document.forms["registerForm"]["userRPassword"].value;

	if (userName === "" || userEmail === "" || userId === "" || userPassword === "" || userRPassword === "") {
		alert("모든 필수 항목을 입력하세요.");
		return false;
	}

	if (userPassword !== userRPassword) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	}
	else
		return true;
}

function loginFormM() {
	var userId = document.forms["loginForm"]["userId"].value;
	var userPassword = document.forms["loginForm"]["userPassword"].value;

	if (userId === "" || userPassword === "") {
		alert("모든 필수 항목을 입력하세요.");
		return false;
	}

	if (userPassword !== userRPassword) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	}
	else
		return true;
}
// 웹소켓 연결 코드
var socket = new SockJS('/gs-guide-websocket');
var stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame) {
    console.log('Connected: ' + frame);
    
    // /topic/registration 주제를 구독
    stompClient.subscribe('/topic/registration', function(message) {
        // 받은 메시지를 처리하여 페이지에 실시간으로 업데이트
        console.log('Received WebSocket message: ' + message.body);
        updatePage(message.body);
    });
});
// 페이지 업데이트 함수
function updatePage(message) {
    // 메시지를 사용하여 페이지 업데이트 로직을 수행
    console.log('Received message: ' + message);
    if(message==="이미 존재하는 아이디입니다."){
		document.getElementById('label').innerText = message;
	}else{
		alert(message);
	}
}

document.getElementById('connect').addEventListener('click', function() {
    stompClient.send("/app/hello", {}, JSON.stringify({}));
});
document.getElementById('disconnect').addEventListener('click', function(){
	if (socket) {
        // 웹소켓 연결 종료
        socket.close();
        
        // 연결이 종료되었음을 콘솔에 로그
        console.log('WebSocket connection closed');
    } else {
        // 연결이 없다면 콘솔에 로그
        console.log('WebSocket connection not established');
    }
});
document.getElementById('connect').addEventListener('click', function(event) {
    event.preventDefault();  // 기본 제출 동작 중지

    // 폼 데이터 가져오기
    var formData = new FormData(document.forms['registerForm']);

    // Fetch API를 사용하여 서버로 데이터 전송
    fetch('/register', {
        method: 'POST',
        body: formData
    })
    .catch(error => console.error('Error:', error));
});