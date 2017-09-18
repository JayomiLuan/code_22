function getRequest(){
	try{
		req = new XMLHttpRequest();
	}catch(tryMS){
		try{
			req = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(otherMS){
			try{
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(failed){
				req = null;
			}
		}
	}
	return req;
}