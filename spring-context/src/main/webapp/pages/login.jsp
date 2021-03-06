<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>login</title>
</head>
<body>
	
	<!-- <div id="modal_addUserConfirm"></div> -->
	<div class="container ">
		<div class="row">
			<div class="col-sm-4 col-sm-push-4">
				<h2 class="text-center">Login</h2>
			</div>
		</div>
		<div class="row ">
			<div class="col-sm-4 col-sm-push-4 jumbotron">
				<form id="login" role="form">
					<div class="form-group">
						<label for="username">UserName</label>
						<input type="text" name="username" class="form-control username"/>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" name="password" class="form-control password"/>
					</div>
					
					<div class="form-group col-sm-push-4">
						<div class="col-sm-3 ">
							<button id="add" type="button" class="btn btn-link" >add an account</button> 
							<!-- <a href="">add an account</a> -->
						</div>
						<div class="col-sm-3 col-sm-offset-3">
							<button id="submit" type="button" class="btn btn-success btn-sm">Submit</button>
						</div>
						<div class="col-sm-3">
							<button type="reset" class="btn default-btn btn-sm">Reset</button>
						</div>
					</div>
				</form>
			</div>
		</div>	
	</div>
	<!-- <div id="modal_addUser"></div> -->
	<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="/spring-context/pages/user/js/user.js"></script>
	
	<script>
	$(function(){
		// 加载模态框html
		loadModal(getRootPath()+'/pages/user',"addUserModal");
		
		$('#login').find('#add').click(function(event) {
			/* Act on the event */
			addUserModal.show();
			
		});
				

		$('#login').find('#submit').click(function(event) {
			/* Act on the event */
			if (!validateInputValue('login')){
				console.log("ERROR:username or password is empty!");
			}else{
				console.log("INFO:check success!");
				console.log($('#login').serialize());
				var contextPath = window.location.pathname;
				console.log(contextPath);
				$.ajax({
					url: contextPath+'user/login',
					type: 'post',
					dataType: 'json',
					data: $('#login').serialize()
				})
				.done(function(data) {
					
					var $responseObj = $.parseJSON(data);
					console.log("done");
					
					if ($responseObj.flag){
						
						$(location).attr('href', window.location.pathname+'pages/user/userInit.jsp');
					}
					else
						console.log($responseObj.message);
				})
				.fail(function() {
					console.log("error");
					
				})
				.always(function() {
					console.log("complete");
				});
				}
			});
		
		function validateInputValue(id){
			$('#'+id).find('input.username').each(function(index, el) {
				if($(el).val == '') return false;
			});

			$('#'+id).find(':password').each(function(index, el) {
				if($(el).val == '') return false;
			});

			return true;
		}



			
		
	});
	</script>
</body>
</html>