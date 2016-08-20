function baseURL($http){
	 return {
		IP:"http://192.168.0.72:8082",
		userId: localStorage.getItem("userId"),
		sellerBranchId: localStorage.getItem("sellerBranchId")
	}
}
function processReqFactory($http){
	return {
		processReq:function(url,type,data,success,error){
			$http({
			url:url,
			method:type,
			data:data,
			headers:{
						  'Content-Type': "application/vnd.siren+json",
						  'Accept': "application/vnd.siren+json"
					}
			}).success(success)
			.error(error);
		},
		search:function(){

		}
	}
}

function webSocketService(baseURL){
	this.stompClient=null;

	this.webSocketConnect=function(){
		// var socket = $websocket('ws://192.168.0.119:8082/arthvedi');
		var socket =  new SockJS('http://192.168.0.72:8082/arthvedi');
		// var socket = new SockJS('ws://192.168.0.119:8082/arthvedi/494/u03vb3f_/websocket');
		this.stompClient = Stomp.over(socket);
		return this.stompClient;
	}    
}

function compareTo() {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function(scope, element, attributes, ngModel) {
             
            ngModel.$validators.compareTo = function(modelValue) {
                return modelValue == scope.otherModelValue;
            };
 
            scope.$watch("otherModelValue", function() {
                ngModel.$validate();
            });
        }
    };
};

function alertMsg($ionicPopup,$timeout){
	return{
		alertPopup:function(message){
			var MsgPopup = $ionicPopup.alert({
	     template: message
	   	});

	   	MsgPopup.then(function(res) {
	    	MsgPopup.close();
	   	});

		  $timeout(function() {
		      MsgPopup.close(); //close the popup after 3 seconds for some reason
		  }, 3000);
   }
	}
}

angular
	.module('NonVeg')
	.service('baseURL',baseURL)
	.factory('processReqFactory',processReqFactory)
	.service('webSocketService',webSocketService)
	.service('alertMsg',alertMsg)
	.directive("compareTo", compareTo);