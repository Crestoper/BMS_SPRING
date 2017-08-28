function gohome(){
	var url = document.location.href;
	
	if(url != "http://localhost:8081/bms/home"){
		window.location = "home";
		return false;
	}
}