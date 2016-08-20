/**
 * INSPINIA - Responsive Admin Theme
 *
 * Main controller.js file
 * Define controllers with data used in Inspinia theme
 *
 *
 * Functions (controllers)
 *  - MainCtrl
 *  - dashboardFlotOne
 *  - dashboardFlotTwo
 *  - dashboardMap
 *  - flotChartCtrl
 *  - rickshawChartCtrl
 *  - sparklineChartCtrl
 *  - widgetFlotChart
 *  - modalDemoCtrl
 *  - ionSlider
 *  - wizardCtrl
 *  - CalendarCtrl
 *  - chartJsCtrl
 *  - GoogleMaps
 *  - ngGridCtrl
 *  - codeEditorCtrl
 *  - nestableCtrl
 *  - notifyCtrl
 *  - translateCtrl
 *  - imageCrop
 *  - diff
 *  - idleTimer
 *  - liveFavicon
 *  - formValidation
 *  - agileBoard
 *  - draggablePanels
 *  - chartistCtrl
 *  - metricsCtrl
 *  - sweetAlertCtrl
 *
 */

/**
 * MainCtrl - controller
 * Contains severals global data used in diferent view
 *
 */
function UploadController($scope,$http){
$scope.image = {};
$scope.image['properties'] = {};


  $scope.bytes = {};
  $scope.upload = function(el, index) {
	$scope.bytes = el.files[0];
	console.log($scope.bytes);
  };
$scope.uploadImages = function(image){

	var JSONData = {}
	JSONData['class'] = ["CategoryImagesRepresentation"];
	JSONData['rel'] = ["item"];
	JSONData['properties'] = {};
	JSONData['properties']['categoryId'] = "C1";
	JSONData['properties']['imageName'] = image.imageName;
	JSONData['properties']['imageType'] = image.imageType;
	JSONData['properties']['bytes'] = JSON.stringify($scope.bytes);
	JSONData['properties']['$siren4j.class'] = "com.hungry.representation.siren.CategoryImagesRepresentation";
   var formData = new FormData();
   var fileLocation = document.getElementById("fileUpload");

   formData.append('file', $scope.bytes);
   formData.append('fileName', $scope.bytes.name);
   formData.append('fileLocation', $scope.bytes.name);
   /*console.log(formData.serializeArray());*/
   /* $http({
			url : "/upload/uploadFile",
			method : "POST",
			data : formData,
			headers : {
				'Content-Type' : false,
				'Accept' : "application/json",
				'processData': false,

			},


		}).success(function(){

			alert("success");

		}).error(function(){
			alert("failure")
		});*/


 $.ajax({
		type: "POST",
	//url: Config.baseURL+'/categoryCatalogs/create',
	url: '/upload/uploadFile',
	//contentType: "application/vnd.siren+json",
	//accept:"application/vnd.siren+json",
	beforeSend: function(req) {
			 req.setRequestHeader("Accept", "application/json");

		  },

 data:formData,
 processData: false,
	  contentType: false,
	success: function(response) {
		alert("success")
	},
	error:function(){
		alert("failure");
	}
});




}
}


function MainCtrl($scope,$rootScope) {
   // $rootScope.orderData={};
   var socket = new SockJS('/sankar');
			stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame) {
				//setConnected(true);
				console.log('Connected: ' + frame);
				stompClient.subscribe('/orders/subOrders/'+window.sessionStorage.getItem('branchId'), function(notificationResponse){
					//alert(notificationResponse.body)
					console.log(JSON.parse(notificationResponse.body));
					var audio = new Audio('./Restaurants/Dashboard/2.mp3');
																			audio.play();
					var subOrder = {};
					subOrder = JSON.parse(notificationResponse.body);
					var notificationOrderItems = subOrder.orderItemModels
					for(var orderItem in notificationOrderItems){
						$scope.setOrderItemsVariables(subOrder.id,
						subOrder.subOrderCode,
						notificationOrderItems[orderItem].restaurantItemName,
						notificationOrderItems[orderItem].id,
						notificationOrderItems[orderItem].units,
						notificationOrderItems[orderItem].orderTimeCode,
						notificationOrderItems[orderItem].startTimeInterval+'-'+notificationOrderItems[orderItem].endTimeInterval,
						notificationOrderItems[orderItem].orderItemStatus);

					
					}
				  //  showGreeting(JSON.parse(greeting.body).content);
				});
				/*  stompClient.subscribe('/orders/greeting/html', function(greeting){
				   showMessage(greeting.body)
				}); */
			});
	$rootScope.orderItemData={};
	$scope.setSessionVariables=function(userId,userName,branchId,branchName){
		// alert(userId);
		// console.log(userName);
		// console.log(branchId);
		// console.log(branchName);
		if(window.sessionStorage){
			window.sessionStorage.setItem('userId',userId);
			window.sessionStorage.setItem('userName',userName);
			window.sessionStorage.setItem('branchId',branchId);
			window.sessionStorage.setItem('branchName',branchName);
		}

		if(window.sessionStorage.userId==null){
			window.location.href="/restaurant/logout";
		}
	}

	$scope.setOrderPrint=function(order,items){
		// console.log(order);
		// console.log(items)
	}
	 var subOrderData = {};
	$scope.setOrderItemsVariables=function(subOrderId,subOrderCode,itemName,itemId,unit,orderItemCode,startTime,endTime,timingName,itemStatus,itemPrice,orderItemTotalPrice,orderId,itemTaxValue,totalTaxValue,totalDiscount,totalPrice){
		console.log(timingName);
	   /*$rootScope.subOrderData={};*/

		/*$rootScope.subOrderData[orderId]={
			'orderCode': orderCode,
			'orderId': orderId,
			'deliveryTime': deliveryTime,
			'orderTimeCode': timeCode,
			'properties':$scope.orderItems
		}


		if($rootScope.subOrderData[orderId].orderCode==orderCode){
			$scope.orderItems=[];
		 $.each($rootScope.subOrderData,function(key,value){
			$scope.orderItems.push({'itemName': itemName,'itemId': itemId,'orderTimeCode': timeCode,'deliveryTime': deliveryTime,'unit': unit})
		 })
		}*/

		//console.log('+++++++++++++++++++++++++++++++'+orderId+','+orderCode+','+itemName+','+itemId+','+unit+','+timeCode+','+deliveryTime+'++++++++++++++++++++++++++++');

		if(!subOrderData[subOrderId]){
		  subOrderData[subOrderId]={};
		  subOrderData[subOrderId]['properties'] = {};
		  subOrderData[subOrderId]['properties']['subOrderCode'] = subOrderCode;
		  subOrderData[subOrderId]['properties']['startTimeInterval'] =  startTime;
		  subOrderData[subOrderId]['properties']['endTimeInterval'] =  endTime;
		  subOrderData[subOrderId]['properties']['timingName'] =  timingName;
		  subOrderData[subOrderId]['properties']['itemStatus'] =  itemStatus;
		  subOrderData[subOrderId]['properties']['taxValue'] = totalTaxValue;
		  subOrderData[subOrderId]['properties']['discount'] = totalDiscount;
		  subOrderData[subOrderId]['properties']['subOrderTotalPrice'] = totalPrice;
		  subOrderData[subOrderId]['entities'] = [];
		  subOrderData[subOrderId]['entities'].push({'class': ["orderItem"],'properties':{'itemName': itemName,'itemId': itemId,'orderItemCode': orderItemCode,'startTimeInterval':startTime,'endTimeInterval': endTime,'timingName':timingName,'units': unit,'subOrderId':subOrderId,'subOrderCode':subOrderCode,'itemStatus':itemStatus,'price':itemPrice,'orderItemTotalPrice':orderItemTotalPrice,'taxValue':itemTaxValue}});
		

		}else{

		subOrderData[subOrderId]['entities'].push({'class': ["orderItem"],'properties':{'itemName': itemName,'itemId': itemId,'orderItemCode': orderItemCode,'startTimeInterval':startTime,'endTimeInterval': endTime,'timingName':timingName,'units': unit,'subOrderId':subOrderId,'subOrderCode':subOrderCode,'itemStatus':itemStatus,'price':itemPrice,'orderItemTotalPrice':orderItemTotalPrice,'taxValue':itemTaxValue}});
		
		}
		$rootScope.orderData = Object.keys(subOrderData).map(function(k) { return subOrderData[k] });
		$rootScope.orderData = $rootScope.orderData.reverse();
		$rootScope.$digest();
		console.log(JSON.stringify($rootScope.orderData));



	}


	/**
	 * daterange - Used as initial model for data range picker in Advanced form view
	 */
	this.daterange = {startDate: null, endDate: null}

	/**
	 * slideInterval - Interval for bootstrap Carousel, in milliseconds:
	 */
	this.slideInterval = 5000;


	

	/**
	 * addAlert, closeAlert  - used to manage alerts in Notifications and Tooltips view
	 */
	this.addAlert = function() {
		this.alerts.push({msg: 'Another alert!'});
	};

	this.closeAlert = function(index) {
		this.alerts.splice(index, 1);
	};

	/**
	 * randomStacked - used for progress bar (stacked type) in Badges adn Labels view
	 */
	this.randomStacked = function() {
		this.stacked = [];
		var types = ['success', 'info', 'warning', 'danger'];

		for (var i = 0, n = Math.floor((Math.random() * 4) + 1); i < n; i++) {
			var index = Math.floor((Math.random() * 4));
			this.stacked.push({
				value: Math.floor((Math.random() * 30) + 1),
				type: types[index]
			});
		}
	};
	
}



/**
 * CalendarCtrl - Controller for Calendar
 * Store data events for calendar
 */
function CalendarCtrl($scope) {

	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();

	// Events
	$scope.events = [
		{title: 'All Day Event',start: new Date(y, m, 1)},
		{title: 'Long Event',start: new Date(y, m, d - 5),end: new Date(y, m, d - 2)},
		{id: 999,title: 'Repeating Event',start: new Date(y, m, d - 3, 16, 0),allDay: false},
		{id: 999,title: 'Repeating Event',start: new Date(y, m, d + 4, 16, 0),allDay: false},
		{title: 'Birthday Party',start: new Date(y, m, d + 1, 19, 0),end: new Date(y, m, d + 1, 22, 30),allDay: false},
		{title: 'Click for Google',start: new Date(y, m, 28),end: new Date(y, m, 29),url: 'http://google.com/'}
	];


	/* message on eventClick */
	$scope.alertOnEventClick = function( event, allDay, jsEvent, view ){
		$scope.alertMessage = (event.title + ': Clicked ');
	};
	/* message on Drop */
	$scope.alertOnDrop = function(event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view){
		$scope.alertMessage = (event.title +': Droped to make dayDelta ' + dayDelta);
	};
	/* message on Resize */
	$scope.alertOnResize = function(event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view ){
		$scope.alertMessage = (event.title +': Resized to make dayDelta ' + minuteDelta);
	};

	/* config object */
	$scope.uiConfig = {
		calendar:{
			height: 450,
			editable: true,
			header: {
				left: 'prev,next',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			eventClick: $scope.alertOnEventClick,
			eventDrop: $scope.alertOnDrop,
			eventResize: $scope.alertOnResize
		}
	};

	/* Event sources array */
	$scope.eventSources = [$scope.events];
}





/**
 * translateCtrl - Controller for translate
 */
function translateCtrl($translate, $scope) {
	$scope.changeLanguage = function (langKey) {
		$translate.use(langKey);
	};
}



/**
 * idleTimer - Controller for Idle Timer
 */
function idleTimer($scope, Idle, notify) {

	// Custm alter
	$scope.customAlert = false;

	// Start watching idle
	Idle.watch();

	// Config notify behavior
	notify.config({
	   duration: '5000'
	});

	// function you want to fire when the user goes idle
	$scope.$on('IdleStart', function () {
		notify({
			message: 'Idle time - You can call any function after idle timeout.',
			classes: 'alert-warning',
			templateUrl: 'views/common/notify.html'
		});
		$scope.customAlert = true;

	});

	// function you want to fire when the user becomes active again
	$scope.$on('IdleEnd', function () {
		notify({
			message: 'You are back, Great that you decided to move a mouse.',
			classes: 'alert-success',
			templateUrl: 'views/common/notify.html'
		});
		$scope.customAlert = false;
	});

}


/**
 * formValidation - Controller for validation example
 */
function formValidation($scope) {

	$scope.signupForm = function() {
		if ($scope.signup_form.$valid) {
			// Submit as normal
		} else {
			$scope.signup_form.submitted = true;
		}
	}

	$scope.signupForm2 = function() {
		if ($scope.signup_form.$valid) {
			// Submit as normal
		}
	}

};





function restaurantOrdersCtrl($scope,$http,$rootScope,$modal,processReqFactory,$state){
	// on clicking subOrder to display orderItem List
	$scope.subOrder=function(OrderItems,startTime,endTime,tax,discount,finalPrice){
		$scope.finalPrice=0.0;
		$scope.finalPrice = finalPrice;
		$scope.finalTax = tax;
		$scope.finalDiscount = discount;
		$scope.orderDeliveryTime=startTime +'-'+ endTime;
		$scope.subOrderItemsData=OrderItems;
		// console.log(JSON.stringify(OrderItems));
		// $.each($scope.subOrderItemsData,function(k,v){
			// var total = parseInt(v['properties'].price * v['properties'].units);
			// $scope.finalPrice = finalPrice;
			// $scope.orderDeliveryTime=startTime +'-'+ endTime;
		// })	
	}
	// on clicking today button
	$scope.today=function(){
		var date=new Date();
		// $scope.todayDate=date.toLocaleDateString();
		// console.log($scope.todayDate)
		var localDate=date.toLocaleDateString();
		var current= localDate.split("/");
		var currentDate=current[0];
		var month=current[1];
		var year=current[2];
		$scope.totalDate=year+'-'+month+'-'+currentDate;
		$http({
		  method: "GET",
		  url: '/subOrder/branch/'+window.sessionStorage.branchId+'/day/'+$scope.totalDate+'/timing/ALL/status/SUBORDERPLACED',
		  data: '',
		  headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

		}).success(function(data) {
			if(data.entities){
				$rootScope.orderData=data.entities
			}
		}).error(function(error){
		  $scope.error = error;
		});
	}
	// on clicking tomorrow button
	$scope.tomorrow=function(){
		var currentDate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
		var day = currentDate.getDate()
		var month = currentDate.getMonth() + 1
		var year = currentDate.getFullYear()
		$scope.totalDate=year + "-" + month + "-" + day;
		$http({
		  method: "GET",
		  url: '/subOrder/branch/'+window.sessionStorage.branchId+'/day/'+$scope.totalDate+'/timing/ALL/status/SUBORDERPLACED',
		  data: '',
		  headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

		}).success(function(data) {
			if(data.entities){
				$rootScope.orderData=data.entities
			}
		}).error(function(error){
		  $scope.error = error;
		});
	}
	// on clicking lunch,snack,dinner
	$scope.timingName=function(details){
		$http({
		  method: "GET",
		  url: '/subOrder/branch/'+window.sessionStorage.branchId+'/day/'+$scope.totalDate+'/timing/'+details+'/status/SUBORDERPLACED',
		  data: '',
		  headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

		}).success(function(data) {
			if(data.entities){
				$rootScope.orderData=data.entities
			}
		}).error(function(error){
		  $scope.error = error;
		});
	}
	// Modal Window Open
	// $scope.openModal = function (data) {
	// 	var modalInstance = $modal.open({
	// 		templateUrl: '/Restaurants/Dashboard/views/modal_example1.html',
	// 		controller: ModalInstanceCtrl
	// 	});
	// 	$rootScope.OrdersItemsData=data;
	// };
	// on clicking date button
	$scope.dateChange=function(date){
		var localDate=date.toLocaleDateString();
		var current= localDate.split("/");
		var currentDate=current[0];
		var month=current[1];
		var year=current[2];
		$scope.totalDate=year+'-'+month+'-'+currentDate;
		$http({
		  method: "GET",
		  url: '/subOrder/branch/'+window.sessionStorage.branchId+'/day/'+$scope.totalDate+'/timing/ALL/status/SUBORDERPLACED',
		  data: '',
		  headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

		}).success(function(data) {
			$rootScope.orderData=data.entities
			// if(data.entities){
			// 	$.each(data.entities,function(k,v){
			// 		$rootScope.orderData=v;
			// 	})
			// }
		}).error(function(error){
		  $scope.error = error;
		});
	}
	// console.log($scope.currentDate)

	// Confirming the Order
	$scope.confirmOrder = function (OrderItems) {
		var ItemOrderEntity=[];
		console.log(JSON.stringify(OrderItems));
		if(OrderItems != undefined){
			$.each(OrderItems,function(k,v){
				$scope.orderId=v.orderId;
				var itemOrderObj=
				{
					"class": [
						"orderItem"
					],
					"rel": [
						"orderItemRep"
					],
					"properties": {
						"$siren4j.class": "com.hungry.representation.siren.OrderItemRepresentation",
						"id": v.itemId,
						"units": parseInt(v.unit),
						"orderItemStatus": "Confirmed"
					}
				}
				ItemOrderEntity.push(itemOrderObj);
			});
			var jsonConfirm=
				{
					"class": ["OrderRepresentation"],
					"rel": ["item"],
					"properties": {
						"$siren4j.class": "com.hungry.representation.siren.OrderRepresentation",
						"id":$scope.orderId,
						"userId": window.sessionStorage.userId
					},
					"entities": ItemOrderEntity
				}
			console.log(JSON.stringify(jsonConfirm));
			processReqFactory.processReq('/order/'+$scope.orderId+'/edit','POST',jsonConfirm,function(){
				//$modalInstance.close();
				location.reload();
				$state.go('dashboards.orders');
			},function(){});
		}else{
		alert('No Items are Placed');
		}
	}
}

function HeaderCtrl($scope,$rootScope){
	$scope.restaurantName=window.sessionStorage.branchName;
	// $scope.timingChange=function(time){
	// 	//alert(time);
	// 	$rootScope.foodTimings=time;
	// }
}
function HeaderRoutesCtrl($scope){

}
function ModalInstanceCtrl ($scope, $modalInstance,$rootScope,processReqFactory,$state) {
	//$scope.OrderItems=[];
	$scope.OrderItems =$rootScope.OrdersItemsData;
	console.log(JSON.stringify($scope.OrderItems));
	$scope.ok = function (OrderItemsData) {
		var ItemOrderEntity=[];
		console.log(JSON.stringify(OrderItemsData));
		if(OrderItemsData != undefined){
			$.each(OrderItemsData,function(k,v){
				$scope.orderId=v.orderId;
				var itemOrderObj=
					{
						"class": [
							"orderItem"
						],
						"rel": [
							"orderItemRep"
						],
						"properties": {
							"$siren4j.class": "com.hungry.representation.siren.OrderItemRepresentation",
							"id": v.itemId,
							"units": parseInt(v.unit),
							"orderItemStatus": "Confirmed"
						}
					}
					ItemOrderEntity.push(itemOrderObj);
			});
			var jsonConfirm=
				{
					"class": ["OrderRepresentation"],
					"rel": ["item"],
					"properties": {
						"$siren4j.class": "com.hungry.representation.siren.OrderRepresentation",
						"id":$scope.orderId,
						"userId": window.sessionStorage.userId
					},
					"entities": ItemOrderEntity
				}
			console.log(JSON.stringify(jsonConfirm));
			processReqFactory.processReq('/order/'+$scope.orderId+'/edit','POST',jsonConfirm,function(){
				$modalInstance.close();
				location.reload();
				$state.go('dashboards.orders');
			},function(){});
		}else{
		alert('No Items are Placed');
		}
	};
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
	$scope.decline=function(itemnumber){
		//alert(itemnumber);
		$scope.OrderRemainItems={};
		 $scope.OrderRemainItems=$scope.OrderItems.items.filter(function(el){
			return el.itemName !==itemnumber;
		  })

		 $scope.OrderItems['items']=$scope.OrderRemainItems;
		 console.log(JSON.stringify($scope.OrderItems));
		 $scope.$parent.$state.reload();
	};

}
function ConfirmOrdersController($scope,$http,$rootScope,$state,processReqFactory){
	$scope.confirmOrderItems={};
	//$state.reload();
	$http({
	  method: "GET",
	  url: '/orderItem/restaurantBranch/'+window.sessionStorage.branchId+'/'+$rootScope.foodTimings+'/Confirmed/cartItems',
	  data: '',
	  headers: {
		   'Content-Type': "application/vnd.siren+json",
		   'Accept': "application/vnd.siren+json"
		}

	}).success(function(data) {
		if(data.entities){
	  $.each(data.entities,function(k,v){
		if(!$scope.confirmOrderItems[v['properties'].orderTimeCode]){
			$scope.confirmOrderItems[v['properties'].orderTimeCode]={};
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['timingName']=v['properties'].timingName
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['address']=v['properties'].addressRep
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['deliveryTime']=v['properties'].deliveryTime
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['orderTimeCode']=v['properties'].orderTimeCode
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['createdDate']=v['properties'].createdDate
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['items']=[];
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['items'].push(v.properties);
		}else{
			$scope.confirmOrderItems[v['properties'].orderTimeCode]['items'].push(v.properties);
		}
	  })
	  console.log(JSON.stringify($scope.confirmOrderItems));
	// $scope.confirmedItemsData=[];
	//   $.each($scope.confirmOrderItems,function(korder,vorder){
	//     $.each(vorder.items,function(kitem,vitem){
	//     $scope.confirmedItemsData.push(vitem);
	// });
	// })
	//console.log(JSON.stringify($scope.confirmedItemsData));
	}
	}).error(function(error){
	  $scope.error = error;
	});

	$scope.deliverOrder=function(orderedData){
		console.log(JSON.stringify(orderedData));
		 var ItemOrderDeliverEntity=[];
		//console.log(JSON.stringify(OrderItems));
		$.each(orderedData.items,function(k,v){
			$scope.orderId=v.orderId;
			// $scope.itemId=v.itemId;
			// $scope.unit=v.unit;
			var itemOrderObj={
							"class": [
								"orderItem"
							],
							"rel": [
								"orderItemRep"
							],
							"properties": {
								"$siren4j.class": "com.hungry.representation.siren.OrderItemRepresentation",
								"id": v.id,
								"units": parseInt(v.units),
								"orderItemStatus": "Delivery"
							}
						}

		ItemOrderDeliverEntity.push(itemOrderObj);
		});
		var jsonDelivery={
					"class": ["OrderRepresentation"],
					"rel": ["item"],
					"properties": {
						"$siren4j.class": "com.hungry.representation.siren.OrderRepresentation",
						"id":$scope.orderId,
						"userId": window.sessionStorage.userId
					},
					"entities": ItemOrderDeliverEntity
				}
		console.log(JSON.stringify(jsonDelivery));
			processReqFactory.processReq('/order/'+$scope.orderId+'/edit','POST',jsonDelivery,function(){
				//$modalInstance.close();
				//location.reload();
				$state.go('dashboards.deliveredOrders',{url:'/deliveredOrders'});
			},function(){});
	}
}
function DeliveryOrdersController($scope,$http,$rootScope,$state,processReqFactory){
 $scope.deliveryOrderItems={};
	//$state.reload();
	$http({
	  method: "GET",
	  url: '/orderItem/restaurantBranch/'+window.sessionStorage.branchId+'/'+$rootScope.foodTimings+'/Delivery/cartItems',
	  data: '',
	  headers: {
		   'Content-Type': "application/vnd.siren+json",
		   'Accept': "application/vnd.siren+json"
		}

	}).success(function(data) {
		if(data.entities){
	  $.each(data.entities,function(k,v){
		if(!$scope.deliveryOrderItems[v['properties'].orderTimeCode]){
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]={};
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['timingName']=v['properties'].timingName
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['deliveryTime']=v['properties'].deliveryTime
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['orderTimeCode']=v['properties'].orderTimeCode
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['createdDate']=v['properties'].createdDate
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['items']=[];
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['items'].push(v.properties);
		}else{
			$scope.deliveryOrderItems[v['properties'].orderTimeCode]['items'].push(v.properties);
		}
	  })
	  console.log(JSON.stringify($scope.deliveryOrderItems));
	$scope.deliveryItemsData=[];
	  $.each($scope.deliveryOrderItems,function(korder,vorder){
		$.each(vorder.items,function(kitem,vitem){
		$scope.deliveryItemsData.push(vitem);
	});
	})
	console.log(JSON.stringify($scope.deliveryItemsData));
	}
	}).error(function(error){
	  $scope.error = error;
	});

	// $(document).ready(function(){
	// $('.footable-row-detail-inner').find('.footable-row-detail-value').addClass('col-lg-4');

// })
}
function restaurantItemsController($scope,$http,$rootScope){
	$scope.categories={};
	$http({
	  method: "GET",
	  url: '/restaurantItem/restaurantBranch/'+window.sessionStorage.branchId+'/ALL',
	  data: '',
	  headers: {
		   'Content-Type': "application/vnd.siren+json",
		   'Accept': "application/vnd.siren+json"
		}

	}).success(function(data) {
		//console.log(JSON.stringify(data));
		$scope.restaurantsItemsList=[];
		$scope.restaurantsItems=data.entities;
		$.each($scope.restaurantsItems,function(k,v){
			if(v.class=="restaurantItem"){
			$scope.restaurantsItemsList.push(v['properties']);
			}
			// alert(v['properties'].categoryName);
			if(!$scope.categories[v['properties'].categoryId]){
				$scope.categories[v['properties'].categoryId]={};
				$scope.categories[v['properties'].categoryId]['category']=[];
				$scope.categories[v['properties'].categoryId]['category'].push({'categoryName':v['properties'].categoryName,'categoryId':v['properties'].categoryId});
			}
		});
		$scope.categoryData=[];
		 console.log(JSON.stringify($scope.categories));
		$.each($scope.categories,function(k,v){
		   // console.log(JSON.stringify(v.category));
			$.each(v.category,function(catk,catv){
			$scope.categoryData.push(catv);
			});
		});


	}).error(function(error){
	  $scope.error = error;
	});
	$scope.itemEdit=function(option,itemdata){
		alert(option);
		alert(itemdata);

		 console.log(JSON.stringify($scope.restaurantsItemsList));
		// var jsonDelivery={
		//             "class": ["OrderRepresentation"],
		//             "rel": ["item"],
		//             "properties": {
		//                 "$siren4j.class": "com.hungry.representation.siren.OrderRepresentation",
		//                 "id":$scope.orderId,
		//                 "userId": window.sessionStorage.userId
		//             },
		//             "entities": ItemOrderDeliverEntity
		//         }
		// console.log(JSON.stringify(jsonDelivery));
		//     processReqFactory.processReq('/restaurantItem/'+$scope.orderId+'/edit','POST',jsonDelivery,function(){
		//         //$modalInstance.close();
		//         //location.reload();
		//         $state.go('dashboards.deliveredOrders',{url:'/deliveredOrders'});
		//     },function(){});
	}
	$scope.changeItem=function(category){
		//console.log(category);
		//alert($scope.category.categoryId);
	$http({
	  method: "GET",
	  url: '/restaurantItem/restaurantBranch/'+window.sessionStorage.branchId+'/'+category,
	  data: '',
	  headers: {
		   'Content-Type': "application/vnd.siren+json",
		   'Accept': "application/vnd.siren+json"
		}

	}).success(function(data) {
		console.log(JSON.stringify(data));
		$scope.restaurantsItemsList=[];
		$scope.restaurantsItems=data.entities;
		$.each($scope.restaurantsItems,function(k,v){
			if(v.class=="restaurantItem"){
			$scope.restaurantsItemsList.push(v['properties']);
			}
			// alert(v['properties'].categoryName);
			if(!$scope.categories[v['properties'].categoryId]){
				$scope.categories[v['properties'].categoryId]={};
				$scope.categories[v['properties'].categoryId]['category']=[];
				$scope.categories[v['properties'].categoryId]['category'].push({'categoryName':v['properties'].categoryName,'categoryId':v['properties'].categoryId});
			}
		});
		$scope.categoryData=[];
		$.each($scope.categories,function(k,v){
		   // console.log(JSON.stringify(v.category));
			$.each(v.category,function(catk,catv){
			$scope.categoryData.push(catv);
			});
		});


	}).error(function(error){
	  $scope.error = error;
	});
	}
}
function UploadFileController($scope){
			$scope.itemMainImage={imageType:"170X139"};
		$scope.image = {};
		$scope.image['properties'] = {};
		$scope.bytes = {};
		$scope.upload = function(el, index) {
		  $scope.bytes = el.files[0];
		  var imageType=$scope.bytes.type;
		  var imgType=imageType.substring(0,5);
		  console.log($scope.bytes);
		  console.log(el.name);
		  var formData = new FormData();
		  formData.append('file', $scope.bytes);
		  formData.append('fileName', $scope.bytes.name);
		  formData.append('fileLocation', $scope.bytes.name);
		  formData.append('folder', 'Item');
		  console.log(JSON.stringify(formData));
		  if(imgType == "image"){
			//$scope.categoryThumbImage={};
			$.ajax({
			type: "POST",
			url: 'http://192.168.0.111:8085/upload/uploadFile',
			beforeSend: function(req) {
			  req.setRequestHeader("Accept", "application/json");
			},
			data:formData,
			processData: false,
			contentType: false,
			success: function(response) {
				//alert(response);
				console.log(JSON.stringify(response));
				if(el.name=="itemMainImage"){
				  $scope.itemMainImage['itemMainImage']=response.replace(/\\/g,"/");
				  $scope.RestItemImagePathData.push($scope.itemMainImage);
				  $('.itemMainImgPath').html('<img src="'+$scope.itemMainImage['itemMainImage']+'" alt="imageLocationThumb"  width="100%" height="100px"/>');
				}

				console.log(JSON.stringify($scope.RestItemImagePathData));
			},
			error:function(){
				alert("failure");
			}
		  });
		  }else{
			alert('Please Upload Image');
		  }

		}
}
/**
 *
 * Pass all functions into module
 */
angular
	.module('HUNGRY')
	.controller('MainCtrl', MainCtrl)
	.controller('HeaderCtrl', HeaderCtrl)
	.controller('HeaderRoutesCtrl',HeaderRoutesCtrl)
	.controller('CalendarCtrl', CalendarCtrl)
	.controller('translateCtrl', translateCtrl)
	.controller('idleTimer', idleTimer)
	/*.controller('liveFavicon', liveFavicon)*/
	.controller('formValidation', formValidation)
	.controller('restaurantOrdersCtrl', restaurantOrdersCtrl)
	.controller('ImageUploadController', UploadController)
	.controller('ConfirmOrdersController',ConfirmOrdersController)
	.controller('DeliveryOrdersController',DeliveryOrdersController)
	.controller('restaurantItemsController',restaurantItemsController)
	.controller('UploadFileController',UploadFileController)




// function SessionCtrl($scope){

// }
