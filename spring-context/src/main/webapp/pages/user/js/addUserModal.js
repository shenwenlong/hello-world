/**
 * required jQuery
 */
var addUserModal={
	modalId: 			"addUserModal",
	modalPath: 			"/pages/user/",
	modalHtmlLocation: 	"/pages/user/addUserModal.html",
	modalJsLocation:	"/pages/user/js/addUserModal.js",
	show: 				function(){
		console.log(this.modalId);
		var modalIdJs = document.getElementById(this.modalId);
		$(modalIdJs).modal("show");
	},
	hidden:				function(){
		document.getElementById(this.modalId).modal("hidden");
		var modalIdJs = document.getElementById(this.modalId);
		$(modalIdJs).modal("hidden");
	}
	
};

$(function(){
	
	
	loadModal(getRootPath()+'/pages/user/','addUserConfirmModal');
	
	
	$('#'+addUserModal.modalId).find('#addUserConfirmButton').on('click',function(){
		addUserConfirmModal.show();
	});
	
});

