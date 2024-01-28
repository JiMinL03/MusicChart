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

