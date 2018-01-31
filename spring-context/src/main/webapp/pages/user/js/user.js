/**
 * 
 */

	function getRootPath(){      
	    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp      
	    var curWwwPath=window.document.location.href;      
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp      
	    var pathName=window.document.location.pathname;      
	    var pos=curWwwPath.indexOf(pathName);      
	    //获取主机地址，如： http://localhost:8083      
	    var localhostPaht=curWwwPath.substring(0,pos);      
	    //获取带"/"的项目名，如：/uimcardprj      
	    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);      
	    return(localhostPaht+projectName);  
	}  
	/*
	 * 参数
	 * 1.url 指定html页面的位置
	 * 2.ModalName 指定模态框的名称
	 * 要求：
	 * 1.每个模态框必须有对应的js文件，且JS文件中必须有以模态框名称命名的模态框对象。
	 * 2.js文件位置必须在url下建立的js文件夹中。
	 * 
	 */
	function loadModal(url,modalName){
		loadHtml(url,modalName);
		
		
	}
	function loadHtml(url,ModalName){
		var div = document.createElement("div");
		var modalId = hashCode(url+ModalName);
		$(div).attr('id',modalId);
		$('body').append(div);
				
		$(div).load(url+'/'+ModalName+'.html',function(response,status,xhr){
			$("#"+modalId).html(response);
			loadJs(url,ModalName);
		});
	}
	function loadJs(url,ModalName){
		var script = document.createElement("script");
		$('body').append(script);
		$(script).attr('src',url+'/js'+'/'+ModalName+'.js');
	}
	function hashCode(str){
	    var hash = 0;
	    if (str.length == 0) return hash;
	    for (i = 0; i < str.length; i++) {
	        char = str.charCodeAt(i);
	        hash = ((hash<<5)-hash)+char;
	        hash = hash & hash; // Convert to 32bit integer
	    }
	    return hash;
	}
$(function(){
	
	
	
});