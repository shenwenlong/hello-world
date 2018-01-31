/**
 * 
 */
var addUserConfirmModal = {
		modalId: 			"addUserConfirmModal",
		modalPath: 			"/pages/user/",
		modalLocation: 		"/pages/user/addUserConfirmModal.html",
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