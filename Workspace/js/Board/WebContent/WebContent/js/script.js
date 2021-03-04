function fn_submit(){
		
	if( $("#userid").val().trim() == "" ){
		alert("아이디를 입력해주세요.");
		return false;
	}
	if( $("#pass").val().trim() == ""){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	if( $("#birth").val().trim() == ""){
		alert("생년월일을 입력해주세요.");
		return false;
	}
	if( $("#name").val().trim() == ""){
		alert("이름을 입력해주세요.");
		return false;
	}
	$("#frm").submit();
}
