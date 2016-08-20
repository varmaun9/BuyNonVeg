var HungryHomeTerminal = angular.module("HungryHomeTerminal", []);


/*Location Modal window Controller*/

HungryHomeTerminal.controller('LocationController',function($scope,$http,
		$rootScope,$compile){ 
/*$rootScope.userZone;*/

$scope.showLocationSelect = function(){
	$('#location-target').modal('show');
}
	$scope.cookies = [];
	$scope.insertCookies = function(cookieName){
$scope.cookies.push(cookieName);
	}
$scope.showLocation = function(){
	if($scope.cookies.length<=0){
		$scope.showLocationSelect();
	}
}

 $http({
        method: "GET",
        url:window.location.origin+'/zoneCity/zoneCityZoneOnly/all',
       
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    	}).success(function(data) {
    	 $scope.zonecity=data['entities'];
    	 $scope.zoneCityArray = [];
    	$scope.zoneName={};
    	 $.each(data['entities'],function(k,v){
    	 	 $scope.zoneCityArray.push(v);
    	 	 if(v.entities){
    	 	 	if(!$scope.zoneName[v['properties'].id]){
    	 	 			 $scope.zoneName[v['properties'].id]={};
    	 	 			 $scope.zoneName[v['properties'].id]['zone']=[];
    	 	 			 $.each(v['entities'],function(k1,v1){
    	 	 			 	$scope.zoneName[v['properties'].id]['zone'].push(v1);


    	 	 			 });
    	 	 	}
    	 	 }

    	 })
    	 // console.log(JSON.stringify($scope.zoneName));
    	 $scope.zonesData = $scope.zoneName['402880c85474fa40015475482c2c0072'];
         	$.each($scope.zonesData['zone'],function(k,v){
         		$rootScope.userZone=v['properties'].cityName;
			})
       	
         }).error(function(error){

            $scope.error = error;
         });

         $scope.userZoneDetail={};
         $scope.saveUserDetails=function(user){
         	/*  document.cookie="zid=;";
		document.cookie="zname=;";*/
         		$scope.userLocation=user;
         		console.log($scope.userLocation);
         		$rootScope.userCityLocation=$scope.userLocation.zoneId;
         		sessionStorage.setItem('zid',$scope.userLocation.zoneId);
         		sessionStorage.setItem('zname',$scope.userLocation.zoneName);
         		localStorage.setItem('zid',$scope.userLocation.zoneId);
         		localStorage.setItem('zname',$scope.userLocation.zoneName);
         		$rootScope.userCityName=$scope.userLocation.zoneName;
         		// sessionStorage.cityName=$scope.userLocation.cityName;
         	//	var loc=window.location.origin +window.location.pathname+'/?zid='+$rootScope.userCityLocation;
         		
         	var arr = window.location.search.split("&");
         	var url = window.location.origin+window.location.pathname;
         var queryParam = "";
         	for(var i in arr){
         		arr[i] = arr[i].replace('?','');
         		if(arr[i].indexOf("zid")!=-1 || arr[i].indexOf("zname")!=-1){
         		console.log("");
         		}else{
         			/*if(i==0){
         			url = url+'?'+arr[i];
         			}else{
         				url = url+'&'+arr[i];
         			}*/
         			queryParam = queryParam+'&'+arr[i];
         		}
         		

         	}
         	queryParam = queryParam.substring(1);
         document.cookie="zid="+$rootScope.userCityLocation+";  max-age="+(60*60*24*30);
		document.cookie="zname="+$rootScope.userCityName+"; max-age="+(60*60*24*30);
		window.location.href=url+'?'+queryParam+'&zid='+$rootScope.userCityLocation+'&zname='+$rootScope.userCityName;
		//window.location.reload();
         }

         $scope.zoneChange=function(zoneCityId){
         	$scope.zonesData = $scope.zoneName['40288017527c043e01527c047ec60000'];
         	$.each($scope.zonesData['zone'],function(k,v){
         		$rootScope.userZone=v['properties'].cityName;
			})
         }

});

/*==============  Location Controller   ===================================*/

/*================== Start ForgotPasswordController Controller ============================*/
HungryHomeTerminal.controller('ForgotPasswordController',function($scope,$rootScope,$compile,$http,HTTPService,ToastrService){

$scope.getForgotPassword=function(forgotdata){

		$scope.userforgot={};
						$scope.userforgot['properties'] = forgotdata;
						$scope.userforgot['properties']['$siren4j.class'] = "com.meat.representation.siren.UsersRepresentation";
						
						$scope.userforgot['class'] = [ "user" ];
						$scope.userforgot['rel'] = [ 'item' ];
						var finaldata = JSON.stringify($scope.userforgot);
	


	$http({
		method:"POST",
		url:window.location.origin+"/users/forgotPassword",
		 headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            },
            data:finaldata
	}).success(function(data){
		if(data['entities'][0]['properties'].emailStatus == "INCORRECT"){
			ToastrService.showToastr('error',"No such emailId exists!",'Error!');	
			 $('#forgotId').val('');	
		}else{
		
			ToastrService.showToastr('success','Successfully sent an email to reset your password','Success!');
				 $('#forgotPassword').modal('hide');
				 $('#forgotId').val('');
		}

	}).error(function(error){
ToastrService.showToastr('error','Something went wrong PLease check the deatils!','Error!');		

	});
}


$scope.resetPassword=function(resetdata){
	var password = document.getElementById("newpassword");
  			var confirm_password = document.getElementById("confirmpassword");
					if(password.value != confirm_password.value) {

						$(event.currentTarget).parent().find('#wrg_pass').addClass('show').addClass('error');
    				confirm_password.setCustomValidity("Passwords Don't Match");
							return false;
  					} else {
  						$(event.currentTarget).parent().find('#wrg_pass').removeClass('show').removeClass('error');
    						confirm_password.setCustomValidity('');
  					}
	var userId=window.location.search.substring(1).split('=')[1];
		$scope.resetdata={};
						$scope.resetdata['properties'] = resetdata;
						$scope.resetdata['properties']['$siren4j.class'] = "com.meat.representation.siren.UsersRepresentation";
						$scope.resetdata['properties']['id']=userId;
						$scope.resetdata['class'] = [ "user" ];
						$scope.resetdata['rel'] = [ 'item' ];
						var reset_data = JSON.stringify($scope.resetdata);
	
	
	var reseturl="/users/resetPassword";
	var success=function(data){
		ToastrService.showToastr('success','Successfully Changed Your Password','Success!');
		window.location.href="/login";
		
	}
	var error=function(error){
		ToastrService.showToastr('error','Something went wrong PLease check the deatils!','Error!');		

	}
	HTTPService.processServerRes(reseturl,"POST",success,error,reset_data);
}
	



});


/*================== End ChangePassword Controller ============================*/




HungryHomeTerminal.controller('MainHeaderController', function($scope,$http,
		$rootScope, CartService,$compile,$location,ToastrService,RecentItemsService,$window) {
	$scope.zid=sessionStorage.getItem('zid');
	$scope.zname=sessionStorage.getItem('zname');

	$rootScope.zId=localStorage.getItem('zid');
	$rootScope.zName=localStorage.getItem('zname');

$scope.scrollTop=function(event){
 $('html,body').animate({scrollTop: $(scope.scrollTo).offset().top }, 600,"easeOutBounce");


}
$scope.showLocationSelect = function(){
	$('#location-target').modal('show');
}

	$rootScope.cartItems = CartService.getItemsFromLocalStorage();
	/*
	 * $rootScope.search ={ "key":"" }
	 */

	$rootScope.search = ''
	$scope.getSearchResults = function($event) {
		$scope.searchedItems = {};
		var searchVal = $event.currentTarget.value;
		if (searchVal.length >= 3) {
			$('.searchResultsDiv,.lightbox').removeClass('hide');
			/*$('.searchResultsDiv').addClass('fadeIn');*/
			$('.mid').addClass('white');
			var scope = $scope
			/*$('body').css({"overflow":'none'});*/
			$rootScope.search = $scope.search;
			var url="/productSearch/distinct/"+searchVal+"/items/?zid="+$scope.zid+"&zname="+$scope.zname;
			var req = {
				 method: 'GET',
				 url: url,
				 dataType:'text/html'
				}
				
			$http(req).success(
								function(data) {
										$scope.searchedItems = {};
										var scope = $scope;
									var content = $compile(data)(scope)
									$('.searchResultsDiv').html(content);

								
								}).error(
								function(data, status, headers, config) {
									// called asynchronously if an error occurs
									// or server returns response with an error
									// status.
								});

		} else {
			$scope.lightBoxShow = 'false';
			$('.searchResultsDiv,.lightbox').addClass('hide');
			$('.mid,.side-img').removeClass('white');
		
		}

	}
	$scope.closeSearch=function(e){
	
	$scope.lightBoxShow = 'false';
			$('.searchResultsDiv,.lightbox').addClass('hide');
			$('.mid,.side-img').removeClass('white');
			$('.search_inside_icon').val('');
}

$scope.getHoverEffect=function(event){
	var cur_word = $(event.currentTarget).text().trim(' ');
	var s_word=cur_word.split(' ');
	 
    var html = '';
    $.each(s_word, function() {
        html += '<span class="sr_ltr">'+this.substring(0,1)+'</span>'+this.substring(1) + ' ';
    });
    $(event.currentTarget).html(html);
}
	$scope.setSessionVariables = function(userName, userId) {

		if (window.sessionStorage) {
			window.sessionStorage.setItem('userId', userId)
			window.sessionStorage.setItem('userName', userName)
		}

	}
	$scope.clearSession = function(){
		if(window.sessionStorage){
				window.sessionStorage.removeItem('userId')
			window.sessionStorage.removeItem('userName')
		}
	}
	$scope.showToastrMessage = function(message){
		ToastrService.showToastr('error',message);	
	}

				/*$scope.stickyNavTop = $('.header').offset().top;
				$scope.stickyNav = function(){
					var scrollTop = $(window).scrollTop();
			      
					if (scrollTop > $scope.stickyNavTop) { 
					    $('.header').addClass('sticky');
					} else {
					    $('.header').removeClass('sticky'); 
					}
			};
	$(window).scroll(function(){
	
 	$scope.stickyNav();

	});*/
	$scope.getSubMenu=function(id,event){
		/*$('.bg-y').removeClass('bg-y');*/
		$('.test').removeClass('test');
		$('.test1').removeClass('test1');
		$('.t-c-w').removeClass('t-c-w');
		
		$('.subMenuDiv').addClass('hide');
		$('#'+id+', .lightbox').removeClass('hide')/*.addClass('fadeIn')*/;
		//$('.subMenuDiv,.lightbox').removeClass('hide');
			/*$('.searchResultsDiv').addClass('fadeIn');*/
			$('.mid').addClass('bg-b');/*
			$(event.currentTarget).addClass('zoomIn');*/
			if(event.currentTarget.nodeName=="IMG"){

			
			if($(event.currentTarget).parent().parent().parent().prop('className')=='th'){
				$(event.currentTarget).parent().parent().parent().addClass('test1').addClass('z-10');
				$(event.currentTarget).parents('.bot').find('.r-sub').addClass('b-r-none');
			}else{
			$(event.currentTarget).parent().parent().parent().addClass('test').addClass('z-10');
			
			}
			$(event.currentTarget).find('a').addClass('t-c-w');
			//$(event.currentTarget).parents('.bot').addClass('z-10');
		}
		else{
			$(".bnvn .active").removeClass("active");
			$(event.currentTarget).parent().addClass("active")	
		}

	}
	$scope.leaveSubMenu = function(){
		$('.subMenuDiv,.lightbox').addClass('hide')/*.removeClass('fadeIn')*/;
		/*$('.bg-y').removeClass('bg-y');*/
		$('.mid').removeClass('bg-b');
		$('.test').removeClass('test');
		$(".bnvn .active").removeClass("active");
		
		$('.test1').removeClass('test1');
		$('.t-c-w').removeClass('t-c-w');
		$('.z-10').removeClass('z-10');
	}
$scope.itemUnits=1;
$scope.setSearchedItems = function(itemId,restaurantItemId, restaurantId, restaurantName,itemName, price,
			quantity) {
		$scope.searchedItems[restaurantItemId] = {
				'itemId' : itemId,
				'restaurantId' : restaurantId,
				'units' : $scope.itemUnits,
				'quantity' : quantity,
				'restaurantItemId' : restaurantItemId,
				'itemName' : itemName,
				'restaurantName' : restaurantName,
				'price' : price,
				'totalItemPrice':parseFloat($scope.itemUnits*price)
				}




	}

$scope.addToCart = function(itemId){
			CartService.setCartItems($scope.searchedItems[itemId],'toServer');
	}

	$scope.getBodyCart = function(){
		if(sessionStorage.getItem('userId'))
		{
$scope.carteditems = {};
$scope.cartTotalPrice = 0.0;
			$( 'body' ).toggleClass( 'shop-cart-open' );
		$( '.shop-item' ).toggleClass( 'active' );
		$scope.carteditems = CartService.getItemsFromLocalStorage();
		$scope.cartTotalPrice = CartService.getTotalPrice();
	}else{
		ToastrService.showToastr('warning','Please Login','OOps!')
	}

	}	


$scope.showModal = function(id){


	showQuickModal(id,$('#site-header .bot'),$scope,$http,$compile,CartService,RecentItemsService);
}




});
HungryHomeTerminal.controller('CheckOutController',function($scope,$rootScope,HTTPService,$compile,CartService){

	$scope.selectedAddress = {};
	$scope.setIntialValues =function(key,value){
		$scope.user['properties'][key] = value;
	}
	$scope.setOrderDetails = function(orderId,amount,discount){
		$scope.orderId = orderId;
		$scope.orderTotalPrice = amount;
		$scope.discount = discount;

	}	
	$scope.items = {};
		$scope.setCheckOutItems = function(orderItemId,itemName, itemId,
							restaurantItemId, restaurantName, restaurantId,
							units, price, quantity, deliveryDate, deliveryTime,
							availableTime,timingName,timingDetailsId, itemTimingsArray) {
						deliveryTime = (deliveryTime) ? deliveryTime : "select";
						
						 var orderItem= {
							'orderItemId':orderItemId,
							'itemId' : itemId,
							'restaurantId' : restaurantId,
							'itemName' : itemName,
							'restaurantItemId' : restaurantItemId,
							'units' : parseInt(units),
							'quantity' : quantity,
							'restaurantName' : restaurantName,
							'price' : price,
							'totalItemPrice' : units * price,
							'deliveryDate' : deliveryDate,
							
							'deliveryTime' : deliveryTime,
							'timingName':timingName,
							'timingDetailsId':timingDetailsId,
							'availableTimeSlots' : $scope.availableTimeSlots

						}
						/*if (availableTime != null) {
							item['availableTimings'].unshift("select")
						}*/

						/*CartService.setCartItems(orderItem, 'fromServer');*/
						$scope.items[orderItem.orderItemId] = orderItem;
						/*$scope.orderTotalPrice = CartService.getTotalPrice();*/
					}

$scope.cartItems = {};
$scope.sellerBranch={};

$scope.setCartIItems =function(cartItemId,sellerItemId,quantity,cutType,units,measurementUnit,baseUnit,price,itemTotalPrice,tax,discount,sellerBranchId,minimumOrderTime,minimiumOrderAmount,minimumDeliveryAmount,deliveryCharges,cartStatusFlag){
$scope.cartItems[cartItemId] = {
									"cartItemId":cartItemId,
									"sellerItemId":sellerItemId,
									"quantity":quantity,
									"cutType":cutType,
									"units":units,
									"measurementUnit":measurementUnit,
									"baseUnit":baseUnit,
									"price":price,
									"tax":tax,
									"discount":discount,
									"sellerBranchId":sellerBranchId,
									"itemTotalPrice":itemTotalPrice,
									"cartStatusFlag":cartStatusFlag
}

if(measurementUnit=='KG'){

	$scope.cartItems[cartItemId]['quantity'] = parseInt(units*1000)+' Gms'
}
if($scope.sellerBranch[sellerBranchId]==undefined){
$scope.sellerBranch[sellerBranchId]={};
}
$scope.sellerBranch[sellerBranchId]['orderDeliveryStatus'] = true;//true:Delivery||false:Pickup
$scope.sellerBranch[sellerBranchId]['orderDeliveryTime'] = true;
$scope.sellerBranch[sellerBranchId]['orderDeliveryType'] = true;
$scope.sellerBranch[sellerBranchId]['timeLimit'] = minimumOrderTime;
$scope.sellerBranch[sellerBranchId]['deliveryType']='DELIVERY';
$scope.sellerBranch[sellerBranchId]['deliveryTime'] = 'ORDERNOW';
$scope.sellerBranch[sellerBranchId]['chargesShowStatus'] = false;
$scope.sellerBranch[sellerBranchId]['deliveryCharges'] = parseFloat(deliveryCharges);
$scope.sellerBranch[sellerBranchId]['totalTaxValue'] = parseFloat("0.0");
$scope.sellerBranch[sellerBranchId]['minimumDeliveryAmount'] = minimumDeliveryAmount;
$scope.sellerBranch[sellerBranchId]['chargesTaxValue'] = 0.0;
$scope.sellerBranch[sellerBranchId]['deliveryDate'] = 	((new Date()).getDate())+'/'+((new Date()).getMonth()+1)+'/'+((new Date()).getFullYear());

if($scope.sellerBranch[sellerBranchId]['subOrderSubTotalPrice']!=undefined){
$scope.sellerBranch[sellerBranchId]['subOrderSubTotalPrice'] = parseFloat($scope.sellerBranch[sellerBranchId]['subOrderSubTotalPrice'])+parseFloat(itemTotalPrice);
}else{

$scope.sellerBranch[sellerBranchId]['subOrderSubTotalPrice'] = parseFloat(itemTotalPrice);


} 
}

$scope.orderTimingsNDeliveryType = {};
$scope.selectedSellerBranchTiming = {};
$scope.changeOrderDeliveryType = function(sellerBranchId,deliveryType){
	$scope.orderTotalPrice = 0.0;
	$scope.calculateTotalPrices();
$scope.sellerBranch[sellerBranchId]['deliveryType'] = deliveryType;
//$scope.sellerBranch[sellerBranchId]['orderDeliveryStatus'] =!$scope.sellerBranch[sellerBranchId]['orderDeliveryStatus'];
if(deliveryType=='PICKUP'){
$scope.sellerBranch[sellerBranchId]['orderDeliveryStatus'] = false;
$scope.sellerBranch[sellerBranchId].subOrderTotalPrice-=  $scope.sellerBranch[sellerBranchId].deliveryCharges;
$scope.sellerBranch[sellerBranchId].subOrderTotalPrice-=$scope.sellerBranch[sellerBranchId]['chargesTaxValue'];
$scope.orderTotalPrice -= $scope.sellerBranch[sellerBranchId].deliveryCharges;
$scope.sellerBranch[sellerBranchId]['chargesShowStatus'] = false;
}else{
	$scope.sellerBranch[sellerBranchId]['orderDeliveryStatus'] = true;
}
}
$scope.changeOrderTimings= function(sellerBranchId,OrderTimeStatus){

$scope.sellerBranch[sellerBranchId]['deliveryTime'] =OrderTimeStatus;
if(OrderTimeStatus=="ORDERNOW"){
$scope.sellerBranch[sellerBranchId]['orderDeliveryTime'] = true
}else{
	$scope.sellerBranch[sellerBranchId]['orderDeliveryTime'] = false;
}
}

$scope.orderTotalPrice = 0.0;
$scope.calculateTotalPrices = function(){

for(var id in $scope.sellerBranch){
							if($scope.sellerBranch[id].subOrderSubTotalPrice<$scope.sellerBranch[id].minimumDeliveryAmount){
								$scope.sellerBranch[id].subOrderTotalPrice = Math.round(parseFloat($scope.sellerBranch[id].subOrderSubTotalPrice)+parseFloat($scope.sellerBranch[id].deliveryCharges)+parseFloat($scope.sellerBranch[id].totalTaxValue));
							$scope.sellerBranch[id]['chargesShowStatus'] = true;
							}else{
								$scope.sellerBranch[id].subOrderTotalPrice = Math.round($scope.sellerBranch[id].subOrderSubTotalPrice+parseFloat($scope.sellerBranch[id].totalTaxValue));
						$scope.sellerBranch[id]['chargesShowStatus'] = false;
							}

$scope.orderTotalPrice = Math.floor($scope.orderTotalPrice +parseFloat($scope.sellerBranch[id].subOrderTotalPrice)); 
}


}
/*$scope.sellerBranch[sellerBranchId]['deliveryCharges'] = 0.0;*/
$scope.setSubOrderCharges = function(chargeAmount,sellerBranchId){
	if($scope.sellerBranch[sellerBranchId].subOrderSubTotalPrice<$scope.sellerBranch[sellerBranchId].minimumDeliveryAmount){
	$scope.sellerBranch[sellerBranchId]['deliveryCharges']+=parseFloat(chargeAmount);
}else{
	$scope.sellerBranch[sellerBranchId]['deliveryCharges'] = 0.0;
}
}
$scope.setSubOrderTaxes = function(taxType,taxValue,sellerBranchId){

	var subOrderSubTotalPriceAfterTaxesAndCharges = parseFloat($scope.sellerBranch[sellerBranchId].subOrderSubTotalPrice)+parseFloat($scope.sellerBranch[sellerBranchId]['deliveryCharges']);
	var taxAmount = (subOrderSubTotalPriceAfterTaxesAndCharges*parseFloat(taxValue))/100;

	$scope.sellerBranch[sellerBranchId]['totalTaxValue'] +=parseFloat(taxAmount);
	$scope.sellerBranch[sellerBranchId]['chargesTaxValue'] += (parseFloat($scope.sellerBranch[sellerBranchId]['deliveryCharges'])*parseFloat(taxValue))/100;
}
$scope.showEditModal = function(addressId){
	var url = "/address/"+addressId;


								var success = function(data){
									$scope.selectedAddress.line1 = data['properties'].line1;
									$scope.selectedAddress.zipcode = data['properties'].zipcode;
									$scope.selectedAddress.contactPerson = data['properties'].contactPerson;
									$scope.selectedAddress.city = data['properties'].city;
									$scope.selectedAddress.town = data['properties'].town;
									$scope.selectedAddress.district = data['properties'].district;
									$scope.selectedAddress.state = data['properties'].state;
									$scope.selectedAddress.mobileNo = data['properties'].mobileNo;
									$scope.selectedAddress.id = data['properties'].id;
									$scope.selectedAddress.area  = data['properties'].area;

									$('#myModal').modal('show');
								}	
								var error = function(){
									alert("error");
								}
								HTTPService.processServerRes(url, 'GET', success,error, '');
}
$scope.saveAddress=function(address){

	var addressSaveSuccess = function(response){
		var compiledHTML = $compile(response)($scope)
		$('.orderAddressDiv').html(compiledHTML);
		$('#myModal').modal('hide')
	}
	var success = function(response){
		HTTPService.processServerHTMLRes('/useraddress/address','GET',addressSaveSuccess,error);
		$scope.selectedAddress = {};
	}
	var error= function(){
		alert("error");
		$scope.selectedAddress = {};
	}

	var addressPOSTObject = {};
	addressPOSTObject = {

	"class": ["address"],
	"rel": ["item"]
	}
	addressPOSTObject["properties"] = {
		"$siren4j.class": "com.meat.representation.siren.AddressRepresentation",
      "line1":address.line1,
		"district": address.district,
		"city": address.city,
		"state": address.state,
		"zipcode": address.zipcode,
      "town":address.town,
      "mobileNo":address.mobileNo,
      "contactPerson":address.contactPerson,
      "area":address.area,
      "type":"SHIPPING"


	}
	var url="/address/create";
	if(address.id!=null){
addressPOSTObject["properties"]['id']=address.id;
url = "/address/"+address.id+"/edit";
	}
	
	var data = JSON.stringify(addressPOSTObject);
	HTTPService.processServerRes(url, 'POST', success,
								error, data);
	
}
$scope.deletedeliveryaddress= function(addressId){

	var success =function(data){
		$('#'+addressId).remove();
	}
	var error = function(){
		alert("error");
	}

		swal({
		title: "Are you sure?",
		text: "You will not be able to recover this address!!!!",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: '#DD6B55',
		confirmButtonText: 'Yes, delete it!',
		cancelButtonText: "No, cancel",
		closeOnConfirm: false,
		closeOnCancel: false
	},
	function(isConfirm){
    if (isConfirm){

	var url = "/address/"+addressId+"/delete";
	HTTPService.processServerRes(url, 'GET', success,
								error, '');
	
      swal("Deleted!", "Your address has been deleted!", "success");
    } else {
      swal("Cancelled", "Your address is safe :)", "error");
    }
	});
	/**/

}
$scope.proceedtoaddress = function(){

var i=0;
for(var obj in $scope.sellerBranch){
	if($scope.sellerBranch[obj].deliveryType=="DELIVERY"){
		i=i+1;
	}
}
if(i==0){
		$scope.proceedtopayment($scope.cartItems);

}else{
$('li a[href="#tab2"]').trigger("click");
}



}
$scope.setSelectedAddress = function(addressId){
	$scope.selectedAddressId = addressId;
}
$scope.selectDeliveryAddress = function(addressId){
	$('.address_selc').removeClass('address_selc');

}
$scope.selectdeliveryaddress = function(addressId){
	$('#'+addressId).removeClass('selcting-address');
	$('#'+addressId).addClass('address_selc"');
	$scope.selectedAddressId = addressId;
	$('.Seltd_edress').addClass("hide");
	$('.deliverher').removeClass("hide");
	$('#'+addressId).find('.deliverher').addClass("hide");
	$('#'+addressId).find('.Seltd_edress').removeClass("hide");
	
}
$scope.proceedtopayment = function(cartItems) {


var orderItemList = []; 

cartItems = $scope.cartItems;
	var cartItemsObject = $scope.items;
						var cartPOSTObject = {};
						cartPOSTObject = {
							"class" : [ "orders"],
							"rel" : [ "item" ]
						}
						cartPOSTObject['properties'] = {
						"$siren4j.class": "com.meat.representation.siren.OrdersRepresentation",
        "addressId":$scope.selectedAddressId,
        "status":"PLACED",
        "amount":$scope.orderTotalPrice+'',
        "discount":"0.0"
      
							
						};

						cartPOSTObject['entities'] = [];
						
						for (item in cartItems) {
							var sellerBranchId = cartItems[item]['sellerBranchId'];
							var cartItemObject = {
								"class" : [ "orderItem" ],
								"rel" : [ "orderItemRep" ]
							};
							cartItemObject['properties'] = {


								"$siren4j.class" : "com.meat.representation.siren.OrderItemRepresentation",
								"sellerItemId" : cartItems[item].sellerItemId,
								"quantity" : cartItems[item].quantity,
								"units" : cartItems[item].units+'',
								
								//"deliveryTime" : cartItems[item].deliveryTime,
								"deliveryDate" : $scope.sellerBranch[sellerBranchId]['deliveryDate'],
								"orderItemStatus":"PLACED",
								"discount":"0.0",
								"deliveryType":$scope.sellerBranch[sellerBranchId]['deliveryType'],
								"taxValue":"0.0",
								"cutType":cartItems[item].cutType,
								"id":cartItems[item].orderItemId,
								"cartStatusFlag":cartItems[item].cartStatusFlag
							};
							if($scope.sellerBranch[sellerBranchId]['deliveryTime']=="ORDERLATER"){
							cartItemObject['properties']['timingsId'] = $scope.sellerBranch[sellerBranchId]['timings'];
							}
							if($scope.sellerBranch[sellerBranchId]['deliveryTime']=="ORDERNOW"){
							cartItemObject['properties']['deliveryTime'] = $scope.sellerBranch[sellerBranchId]['timeLimit'];
							}
							 	cartPOSTObject['entities'].push(cartItemObject);
							}

						
								//cartPOSTObject['entities'] = orderItemList;
						console.log(JSON.stringify(cartPOSTObject));
						var data = JSON.stringify(cartPOSTObject);
						url=window.location.origin+"/orders/create"
						//url = window.location.origin+"/transaction";
						var success = function(data){
							/*CartService.removeItemFromLocalStorage();
							alert("Order Successfully Inserted");*/
							CartService.removeItemFromLocalStorage();
							window.location.href="/payment/?o="+data['properties'].id;


						}
						var error = function(){
							alert("error");
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, data);

				
				}
					$scope.deliveryAddress = {};
					$scope.setAddressDetails = function(value, key){
						$scope.deliveryAddress[key] = value;

						}



});
HungryHomeTerminal.controller('SearchController',function($scope,$rootScope,$location){







});
/*==========================Main Slider Controller================================*/
HungryHomeTerminal.controller('MainSliderController', function($scope,
		$rootScope) {

	$scope.toggleMegaMenu = function() {
		$('.side-menu').toggleClass('toggle_sideMenu zoomInDown');
		$('.side-menu .mega-nav li img').toggleClass('rollIn');
		$('.side-img').toggleClass('hide');
		$('.mega_menu').addClass('hide');
	}
	$scope.getMenu = function(menuName) {
		$('.mega_menu').addClass('hide');
		$('.' + menuName).removeClass('hide');

		$('.mega_menu .list-group-item').addClass('fadeInUp')
	}


});
/*===========================Filter Controller===================================*/
HungryHomeTerminal
		.controller('FilterController',
				function($scope, $http,$location) {

					$scope.initSliderRange = function(minValue,maxValue){
					$('#slider-range').slider({
					range: true,
					min: parseFloat(minValue),
					max: parseFloat(maxValue),
					animate:'slow',
					values: [parseFloat(minValue), parseFloat(maxValue)],
					slide: function (event, ui) {
						
						$('#amount').val('₹' + parseFloat(ui.values[0]) + ' - ₹' + parseFloat(ui.values[1]));
					},
					change:function(event,ui){

							$scope.getItemByCheckedFilters();
					}

				});
				//$('#amount').val('$' + $('#slider-range').slider('values', 0) + ' - $' + $('#slider-range').slider('values', 1));
				}
				$scope.getValue  = function(name){
					alert(name);
				}
			
					$scope.getItemByCheckedFilters = function(){
						getItemsByAttributes($http);
						

					}

					$scope.getItembyFilters = function(tagTypeId,event) {
							var checkedList = $('#'+tagTypeId).find('input:checked').size();
						if(checkedList>0){
							$('#'+tagTypeId+' .clearLink').removeClass('hide');
						}else{
							$('#'+tagTypeId+' .clearLink').addClass('hide');
						}

					$scope.getItemByCheckedFilters();
							

					}

					$scope.clearLinks = function(event){
						var currentTarget =  $(event.currentTarget);
						currentTarget.parents('.sidebar-filter').find('.checked').removeClass('checked');
						currentTarget.parents('.sidebar-filter').find('input:checked').removeAttr('checked');
						currentTarget.addClass('hide');
					}

				});
/*================================My Account Controller==========================*/
HungryHomeTerminal.controller('MyAccountController',function($scope,HTTPService,ToastrService){
	
	$scope.user  ={},$scope.user['properties'] = {}
	$scope.EditUser  = function(event){
		
		$('.editable').removeClass('hide');
		$('.no_edit').addClass('hide');
		
	}
	$scope.cancelOrder = function(orderId,status,code){
		$scope.cancelOrder = {
			"orderId":orderId,
			"status":status,
			"code":code
		}
		$("#orderCancel").modal('show');
	}
	$scope.orderCancelConfirmation =function(){
		var orderObject = {
			"class":["orders"],
			"rel":["item"],
			"properties":{
				"$siren4j.class": "com.meat.representation.siren.OrdersRepresentation",
				"id":$scope.cancelOrder['orderId'],
				"status":"CANCELLED",
				"comments":$scope.comments

			}

		}
			var success = function(){
				$("#orderCancel").modal('hide');
				$('[href="#cancelled"]').trigger("click");
			}
			var error = function(){
				alert("Failure");
			}
			url = "/orders/"+$scope.cancelOrder['orderId']+"/edit";
			var data = JSON.stringify(orderObject);
			HTTPService.processServerRes(url, 'POST', success,
								error, data);


		}		
	
	$scope.cancelEdit = function(event){
		$('.editable').addClass('hide');
		$('.no_edit').removeClass('hide');
	}
	$scope.updateUser = function(user){
		event.preventDefault();
			$scope.user = user;
						$scope.user['properties']['$siren4j.class'] = "com.meat.representation.siren.UsersRepresentation";
						$scope.user['properties']['status'] = "Active";
						$scope.user['properties']['userType'] = "Customer";
						$scope.user['class'] = [ "user" ];
						$scope.user['rel'] = [ 'item' ];
						var data = JSON.stringify($scope.user);
						console.log(data);
						var id = sessionStorage.getItem('userId');
						var url ="/users/"+id+"/edit";
						var success = function() {
							window.location.reload();
							
						}
						var error = function() {
							alert('error')
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, data);

	}

	$scope.setIntialValues =function(key,value){
		$scope.user['properties'][key] = value;
	}
	$scope.selectedSellerItemId = "";
		$scope.showRatingWindow = function(sellerItemId){
$scope.selectedSellerItemId = sellerItemId;
			$("#rating").modal('show');
		}




		$scope.changePassword = function(user1,$event){
			 $event.preventDefault;
			 
					  var password = document.getElementById("chng_password");
  var confirm_password = document.getElementById("chgn_confirm_password");


  if(password.value != confirm_password.value) {
    confirm_password.setCustomValidity("Passwords Don't Match");
return false;
  } else {
    confirm_password.setCustomValidity('');
  }
		$scope.chgpwd = {};
		$scope.chgpwd['properties'] = user1;		
						$scope.chgpwd['properties']['$siren4j.class'] = "com.meat.representation.siren.UsersRepresentation",
						//$scope.chgpwd['properties']['id'] = sessionStorage.getItem('userId');
						/*$scope.chgpwd['properties']['password'] = "1234567";*/
						$scope.chgpwd['class'] = [ "user" ];
						$scope.chgpwd['rel'] = [ 'item' ];

						var data = JSON.stringify($scope.chgpwd);
						console.log(data);
						var url ="/users/changePassword";
						var success = function(data) {
							var status =data.entities[0].properties.authenticateStatus;
							var statusCode=status.split("::");
							 if(statusCode[0]=="InCorrect"){
       							 $scope.profileData=data;
       							 ToastrService.showToastr('error',statusCode[1],'Canceled')
								$scope.chgpwd = {};
      							}else{
      								
							ToastrService.showToastr('success','Password Changed Successfully','Done!');
							window.location.href="/myaccount/profile";	
     							 }

												
						}
						var error = function() {
								ToastrService.showToastr('error','Please try again','Error!');
							
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, data);
	}


	$scope.saveRating= function(rate){
		
		$scope.rateObj={};
		$scope.rateObj['class'] =["userSellerItemRating"];
		$scope.rateObj['rel'] =["item"];
		$scope.rateObj['properties']=rate;
		$scope.rateObj['properties']['rating'] = $(event.currentTarget).parents('.form-horizontal').find('#stars-red').attr('data-rating');
		$scope.rateObj['properties']['$siren4j.class'] = "com.meat.representation.siren.UserSellerItemRatingRepresentation";
		$scope.rateObj['properties']['sellerItemId'] = $scope.selectedSellerItemId;			

						var rating_data = JSON.stringify($scope.rateObj);
						console.log(rating_data);
						var url ="/userSellerItemRating/create";
						var success = function(rating_data) {
							ToastrService.showToastr('success','Thanks For ur Review','Done!');
							window.location.href="/myaccount/profile";	
     							 }
						var error = function() {
								ToastrService.showToastr('error','Please try again','Error!');
							
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, rating_data);

	}

});
/*===============================Cart Controller=================================*/
HungryHomeTerminal
		.controller(
				'CartController',
				function($scope, $rootScope, CartService,HTTPService) {
					$scope.itemTimings = {}
					$scope.items = {}
					$scope.discount ='';
					$scope.availableTimeSlotsObject = {};
						$scope.initAvailableTimings = function(oItemId,timingId,timings){
							$scope.itemTimings[oItemId+timingId] = 	timings; 	
						}
						$scope.setOrderItemTimings=function(orderItemId,timingId, timingName, availTimings){
					
							$scope.availableTimeSlots.push({"timingId":timingId,"timingName":timingName,"availableTimings":availTimings.split(',').filter(function(v) {return v !== ''})})
							$scope.availableTimeSlotsObject[timingId] = {"timingId":timingId,"timingName":timingName,"availableTimings":availTimings.split(',').filter(function(v) {return v !== ''})}
						}
						$scope.setCartItems = function(orderItemId,itemName, itemId,
							restaurantItemId, restaurantName, restaurantId,
							units, price, quantity, deliveryDate, deliveryTime,
							availableTime,timingName,timingDetailsId, itemTimingsArray) {
						deliveryTime = (deliveryTime) ? deliveryTime : "select";
						
						 var orderItem= {
							'orderItemId':orderItemId,
							'itemId' : itemId,
							'restaurantId' : restaurantId,
							'itemName' : itemName,
							'restaurantItemId' : restaurantItemId,
							'units' : parseInt(units),
							'quantity' : quantity,
							'restaurantName' : restaurantName,
							'price' : price,
							'totalItemPrice' : units * price,
							'deliveryDate' : deliveryDate,
							
							'deliveryTime' : deliveryTime,
							'timingName':timingName,
							'timingDetailsId':timingDetailsId,
							'availableTimeSlots' : $scope.availableTimeSlots

						}
						
						/*if (availableTime != null) {
							item['availableTimings'].unshift("select")
						}*/

						CartService.setCartItems(orderItem, 'fromServer');
						$scope.items[orderItem.orderItemId] = orderItem;
						$scope.orderTotalPrice = CartService.getTotalPrice();
					}
					/*$scope.setCartItems = function(){
						alert("ok");
					}*/
					$scope.cutTypes = {};
					$scope.setCartItemCutTypes = function(cartItemId,cutType){
						$scope.cutTypes[cartItemId] = cutType;
					}
					$scope.changeCutTypeWithPieceType = function(itemId){
						$('#'+itemId).find('.cart-save-btn.cut-piece-save').removeClass('hide');
					}
					$scope.changeTime = function(id){
						//alert(JSON.stringify($scope.slots));
					}

$scope.itemunits = {};
					$scope.setItemUnit = function(itemId,units){
$scope.itemunits[itemId] = parseFloat(units);
					}
					$scope.changeunit = function(itemId){
						$('.cart-save-btn').addClass('hide');
					$('#'+itemId).find('.cart-save-btn.unit-save').removeClass('hide');
					
						}
						$scope.modifyPreOrderCartItem = function(itemId){
							var url = "/preOrderCartItems/"+itemId+"/edit"
							var preOrderCartItemObject =  {"class": ["preOrderCartItems"],"rel": ["item" ]};
							preOrderCartItemObject['properties'] = {
									"$siren4j.class": "com.meat.representation.siren.PreOrderCartItemsRepresentation",
									"units":$scope.itemunits[itemId]+'',
									"id":itemId,
									"cutType":$scope.cutTypes[itemId]
							}
							var success = function(response){
						window.location.reload();
							}
							var error = function(){
								alert("error");
							}
							var data = JSON.stringify(preOrderCartItemObject);
							HTTPService.processServerRes(url, 'POST', success,
								error, data);


						}	
						$scope.deletePreOrderCartItems=function(itemId){
							var url = "/preOrderCartItems/"+itemId+"/delete";
								var success = function(response){
						window.location.reload();
							}
							var error = function(){
								alert("error");
							}
							HTTPService.processServerRes(url, 'GET', success,
								error, '');
						}
					$scope.checkOutOrder = function(items) {


						window.location.href="/checkout"+window.location.search;
				

					}
					$scope.setOrderDetails = function(orderId) {
						$scope.orderId = orderId;
					}
					$scope.initCartDatePicker = function(){
				
						$('.cartDatePicker').datepicker({
								autoclose:'true',
								
								
								
								format:'dd/mm/yyyy',
								todayHighlight:'true',
								 startDate: '-0d',
								defaultDate:new Date()

		});
					}

					

					if (Object.keys(CartService.cart['items']).length == 0) {
						CartService.cart['items'] = CartService
								.getItemsFromLocalStorage();
						CartService.cart['totalPrice'] = CartService
								.getTotalPriceFromLocalStorage();
					}
					$scope.cart = CartService.cart;
					$scope.editItem = function(orderItemId,units,deliveryDate,deliveryTime,timingDetailsId) {
						
						//alert($scope.availableTimeSlotsObject[timingDetailsId].timingName);
						CartService.editItemById(orderItemId,units, deliveryDate, deliveryTime,timingDetailsId);
						$scope.items = CartService.cart['items'];
						$scope.orderTotalPrice = CartService.getTotalPrice();

					}

					
					
					$scope.$on('$viewContentLoaded', function() {
						$('.datepicker').datepicker({
							autoclose : true,
							todayHighlight : true,
							minDate:0
						});
					});
					/*
					 * $scope.getTotalPrice = function(itemTotalPrice){
					 * $scope.cartTotalPrice=+ parseFloat(itemTotalPrice) }
					 */
					$scope.removeItem = function(orderItemId) {

					CartService.removeItemById(orderItemId)
					/*window.location.reload();*/
					}
					$scope.getTimings = function(id) {
						alert(id)
					};
					$scope.$on('$viewContentLoaded', function(event) {

						$('.datepicker').datepicker({
							autoclose : true,
							todayHighlight : true,
							minDate:0
						});

					});

				});
/*==========================================Item List Controller=================================*/
HungryHomeTerminal.controller('ItemListController',function($scope,$http,$compile,$rootScope,CartService,RecentItemsService,ToastrService){
$scope.pageNo = 1
$scope.pageSize =15


$scope.showModal = function(id){
	showQuickModal(id,$('.itemsListMainView'),$scope,$http,$compile,CartService,RecentItemsService);
} 
$scope.getNextPage = function(e){

	$scope.pageNo+= 1

	var url = window.location.origin+window.location.pathname+'/page/'+$scope.pageNo+'/pageSize/'+$scope.pageSize+attributesUrlBuilder().attrUrl;
	$http.get(url).success(	
								function(data, status, headers, config) {
									data = data.trim();
									if(data!=""){
										var scope = $scope;
								var compiledHTML = $compile(data)(scope);
									$('#items_list').append(compiledHTML);
									if(data.indexOf("empty-list")!=-1){
										$rootScope.loadMoreShow = false;
									}
								}
								else{
									ToastrService.showToastr('warning','That"s all we Have ','OOps!');
								}
									
								}).error(
								function(data, status, headers, config) {
									

								});
								e.stopPropagation();
}
$scope.sortItems = function(sort,type){
	var url = window.location.origin+window.location.pathname+'/page/'+$scope.pageNo+'/pageSize/'+$scope.pageSize+window.location.search+'&sort='+sort+'&type='+type;
console.log(url)
$http.get(url).success(
								function(data, status, headers, config) {
										var scope = $scope
								var compiledHTML = $compile(data)(scope)
									$('#items_list').html(compiledHTML);
									
								}).error(
								function(data, status, headers, config) {
									

								});



}
$scope.addToCart = function(itemId,restaurantItemId, restaurantId, restaurantName,itemName, price,
			quantity){

			var item = {
				'itemId' : itemId,
				'restaurantId' : restaurantId,
				'units' : 1,
				'quantity' : quantity,
				'restaurantItemId' : restaurantItemId,
				'itemName' : itemName,
				'restaurantName' : restaurantName,
				'price' : price,
				'totalItemPrice':parseFloat(1*price)

			}
			CartService.setCartItems(item,'toServer');

}

});
/*===================================Single Item Controller====================================*/
HungryHomeTerminal.controller('SingleItemController', function($scope,
		CartService,ToastrService,$http,$document,$compile,RecentItemsService,HTTPService,ToastrService) {
	
	$scope.getZoom = function(event){
		 $('#zoom_01').elevateZoom({
    zoomType: "inner",
cursor: "crosshair",
zoomWindowFadeIn: 500,
zoomWindowFadeOut: 750
   }); 
	}
	$scope.sellerItemUnits = {};
	$scope.getNumberIncr = function(event){
		var n=Number($(event.currentTarget).parent().siblings('input').attr("step"));
		//$(event.currentTarget).parent().siblings('input').val(Number($(event.currentTarget).parent().siblings('input').val()) + n);
		$scope.itemUnits=$scope.itemUnits + n;
}
	$scope.getNumberDecr = function(event){
			var n=Number($(event.currentTarget).parent().siblings('input').attr("step"));
		if($(event.currentTarget).parent().siblings('input').val() > n){
		//$(event.currentTarget).parent().siblings('input').val(Number($(event.currentTarget).parent().siblings('input').val()) - n)
			$scope.itemUnits = $scope.itemUnits - n;
			}
	}
	$scope.getNumberIncr1 = function(event,sellerItemId){
		var n=Number($(event.currentTarget).parent().siblings('input').attr("step"));
		//$(event.currentTarget).parent().siblings('input').val(Number($(event.currentTarget).parent().siblings('input').val()) + n);
		$scope.sellerItemUnits[sellerItemId]=$scope.sellerItemUnits[sellerItemId]+ n;
}
	$scope.getNumberDecr1 = function(event,sellerItemId){
			var n=Number($(event.currentTarget).parent().siblings('input').attr("step"));
		if($(event.currentTarget).parent().siblings('input').val() > n){
		//$(event.currentTarget).parent().siblings('input').val(Number($(event.currentTarget).parent().siblings('input').val()) - n)
			$scope.sellerItemUnits[sellerItemId] = $scope.sellerItemUnits[sellerItemId]- n;
			}
	}
	$scope.setSellerItemUnits = function(sellerItemId,units){
		$scope.sellerItemUnits[sellerItemId] = parseFloat(units);
		console.log($scope.sellerItemUnits);
	}
console.log($scope.sellerItemUnits);


	$scope.restaurants = {};
	$scope.item = {};
	
	var date = new Date();
	$scope.cartShow = true;
	$scope.selectedRestaurantItem = {};
	$scope.deliveryDate=date.getDate()+"/"+(function(i){return (i<=9)?'0'+i:i})(date.getMonth()+1)+"/"+date.getFullYear();
	$scope.deliveryTime="select";
	$scope.itemTimings={};
	$scope.timingId =''; 
	$scope.availableTimings={};
	$scope.setTimingDetails = function(timingId, availableTime,timingName){
		$scope.availableTimings[timingId]  = availableTime.split(',').filter(function(v) {return v !== ''})
		$scope.itemTimings[timingId] = timingName;
		/*console.log(itemTimings);*/
	}
	$scope.showModal = function(id){
		showQuickModal(id,$('.product-related'),$scope,$http,$compile,CartService);
	}
	$scope.setItemUnits = function(units){
$scope.itemUnits = parseFloat(units);
	}
	$scope.addtocart = function(sellerItemId,units,e,cutType,statusFlag,location) {
		e.preventDefault();
var select_value=$(event.currentTarget).parents('.p-info').find('select').val();
if(location == "SINGLE" && select_value == undefined){
$(event.currentTarget).parents('.p-info').find('select').addClass('select_piece');
		ToastrService.showToastr('error','Please fill the piece type details','Oops');
		return;
}

	
	
	/*if(select_value != null){*/
		$(event.currentTarget).parents('.p-info').find('select').removeClass('select_piece');
	var cartItemObject = {
																
									    "class": [
									        "preOrderCartItems"
									    ],
									    "rel": [
									        "item"
									    ]
						};
						cartItemObject['properties'] = {
							"$siren4j.class": "com.meat.representation.siren.PreOrderCartItemsRepresentation",
							"sellerItemId" : sellerItemId,
							
						
							"units" :units+'',
						
							"cutType":cutType,
							 "status": "CARTADDED",
							 
							/*"timingName":item.timingName,
							"timingDetailsId":item.timingDetailsId*/

						};
						if(statusFlag=="C"){
							cartItemObject['properties']['statusFlag'] = "C";
						}
						if(statusFlag=="QC"){
							cartItemObject['properties']['statusFlag'] = "QC";
						}
							var JSONData = JSON.stringify(cartItemObject);
						
						console.log(JSONData);
						var url = window.location.origin + "/preOrderCartItems/create"
						var success = function(response) {
							if(response.class!=null){

							ToastrService.showToastr('success','Item added to your bowl','Success')
								//	$scope.cartShow = false;
								$('.add-to-cart.active-cart').removeClass('.active-cart');
								$(e.currentTarget).addClass('inactive-cart');
								$(e.currentTarget).unbind();
						
							if(statusFlag=="QC"){
								window.location.href = "/quickcheckout";
							}
						}else{
							/*ToastrService.showToastr('error','Please Login and add the item to cart','Oops')*/
							window.location.href="/login";
						}
						
						}
						var error = function() {
							ToastrService.showToastr('error','Something Went wrong, Please try after dome time','Oops')
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, JSONData);

/*}else{
$(event.currentTarget).parents('.p-info').find('select').addClass('select_piece');
		ToastrService.showToastr('error','Please fill the piece type details','Oops')
					
}*/
/*}else{
	alert("its home page hit")
}*/




	
}

	$scope.xpressBowl=function(e){
		e.stopPropagation();
			if(sessionStorage.getItem('userId')){
				/*$('.xb').on('click',function(e){*/
							$(e.currentTarget).parents('.p-action').find('.t_division').addClass('show').addClass('fadeInUp');
						/*});*/

			}else{
				
		
						$('.loginmodalview').modal('show');

						ToastrService.showToastr('warning','Please Login','OOps!');
			}

	}
	$scope.initDatePicker = function(){
		$('.singleItemDatePicker').datepicker({
			autoclose:'true',
			
			minDate:0,
			format:'dd/mm/yyyy',
			todayHighlight:'true',
			orientation:'bottom',
			defaultDate:new Date()

		});
	}
	$scope.checkOutNow = function(timingId,deliveryDate,deliveryTime,units){
			var item = $scope.selectedRestaurantItem['item'];
			item['timingDetailsId'] = timingId;
			item['deliveryTime'] = 	deliveryTime;
			item['deliveryDate'] = deliveryDate;
			item['timingName'] = $scope.itemTimings[timingId];
			item['units'] = units;

		CartService.setQuickBuyItem(item);
	}

	$scope.setRestaurantItem = function(itemId,restaurantItemId, restaurantId, restaurantName,itemName, price,
			quantity) {
		
		
			$scope.selectedRestaurantItem['item'] = {
				'itemId' : itemId,
				'restaurantId' : restaurantId,
				'units' : $scope.itemUnits,
				'quantity' : quantity,
				'restaurantItemId' : restaurantItemId,
				'itemName' : itemName,
				'restaurantName' : restaurantName,
				'price' : price,
				'totalItemPrice' : $scope.itemUnits * price,
				
				
			}
			RecentItemsService.setRecentItems($scope.selectedRestaurantItem['item'],sessionStorage.getItem('userId'));

		
		 
	}

	$scope.setItemProperties = function(itemId, itemName) {
		$scope.item = {
			'itemId' : itemId,
			'itemName' : itemName
		}
		/* alert(JSON.stringify($scope.item)); */
	}
	$scope.relativeItems = {}
	$scope.setRelativeItems = function(itemId,restaurantItemId, restaurantId, restaurantName,itemName, price,
			quantity) {
		$scope.relativeItems[restaurantItemId] = {
				'itemId' : itemId,
				'restaurantId' : restaurantId,
				'units' : $scope.itemUnits,
				'quantity' : quantity,
				'restaurantItemId' : restaurantItemId,
				'itemName' : itemName,
				'restaurantName' : restaurantName,
				'price' : price,
				'totalItemPrice':parseFloat($scope.itemUnits*price)
				}




	}
	$scope.relativeAddToCart = function(itemId){
			CartService.setCartItems($scope.relativeItems[itemId],'toServer');
	}
	if(RecentItemsService.getRecentItems(sessionStorage.getItem('userId'))){
	$scope.recentItems = RecentItemsService.getRecentItems(sessionStorage.getItem('userId'))
	}
});
/*==============================================Sub Category Controller===================================*/
HungryHomeTerminal.controller('SubCategoryController', function($scope, $http,$location,$rootScope) {

	
$scope.getProductsBySubCategoryRemove = function(event){
	
$(event.currentTarget).parent('.sub-cat').find('img').removeClass('selected');
		
		getItemsByAttributes($http,$rootScope);
		event.stopPropagation();

}
	$scope.getProductsBySubCategory = function(event) {
$(event.currentTarget).parent('.sub-cat').toggleClass('sub_selected');
		$(event.currentTarget).parent('.sub-cat').find('img').toggleClass('selected');
		//$(event.currentTarget).parent('.sub-cat').find('a').toggleClass('selected');
		$(event.currentTarget).parent('.sub-cat').find('.pro-img-sub').toggleClass('address_selc1');
		$(event.currentTarget).parent('.sub-cat').find('.custom_icon_tick').toggleClass('show');
		getItemsByAttributes($http,$rootScope,'subCategory');
		$rootScope.loadMoreShow = true;
		event.stopPropagation();
	}
	$scope.getItemsByFilters = function(event,id){
		/*event.preventDefault();
		var filters = [];

		var scid = 'scid='+id
						$('.checker input[type="checkbox"]:checked').each(
								function() {
									var filter = $(this).attr("filter") + '='
											+ $(this).attr("name");
									console.log($(this));
									filters.push(filter);

								});

						var url = filters.join('&');
						var priceTag = '';
						
							var sp = parseInt($('.slider-input').val().split(',')[0]);
							var ep = parseInt($('.slider-input').val().split(',')[1]);
							priceTag = 'sp='+sp+'&ep='+ep;
							url = url+'&'+priceTag;
						var cid = window.location.search.split('id=')[1];
						url = (window.location.pathname.split('/').indexOf(
								'category') != -1) ? (window.location.origin
								+ '/price/filter/root/items?cid=' + cid + '&' + url+'&'+scid)
								: (window.location.origin
										+ '/filter/root/items?' + url +'&'+scid)

						$http.get(url).success(
								function(data, status, headers, config) {
									$('#itemList').html(data);
									$('.selectedSubCategory').removeClass('selectedSubCategory');
									$(event.currentTarget).parents('.owl-item ').addClass('selectedSubCategory');
								}).error(
								function(data, status, headers, config) {
									
								});*/


	}

});
/*==============================================HTTP SERVICE=========================================*/
HungryHomeTerminal.service('HTTPService', function($http) {
	this.processServerRes = function(url, type, success, error, data) {
		$http({
			url : url,
			method : type,
			data : data,
			headers : {
				'Content-Type' : "application/vnd.siren+json",
				'Accept' : "application/vnd.siren+json"
			}

		}).success(success).error(error);
	};
		this.processServerHTMLRes = function(url, type, success, error) {
		$http({
			url : url,
			method : type,
			dataType : "text/html",
			headers : {
				'Content-Type' : "text/html",
				'Accept' : "text/html"
			}

		}).success(success).error(error);
	};
});

HungryHomeTerminal.controller('FooterController',function($scope,$window,HTTPService,ToastrService){
	

	$scope.toggleBottomMenu = function(event){
		event.preventDefault();
		$(event.currentTarget).toggleClass('bounce');
		$("#stickyfooternav1").toggleClass("show").toggleClass("fadeInUp");
	}


	$scope.getSubcribeWithUs = function(newsdata){
		$('.span_err').remove();
       var x = document.forms["cardForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        $(event.currentTarget).parent().append("<span class='span_err'><i class='fa fa-exclamation-triangle l-s-5' aria-hidden='true'></i>Please enter valid email address</span>");
        return false;
    }
			$scope.newsdata1= newsdata;
						$scope.newsdata1['class'] = ["emailSubscription"];
						$scope.newsdata1['rel'] = ['item'];
						$scope.newsdata1['properties']['$siren4j.class'] = "com.meat.representation.siren.EmailSubscriptionRepresentation";
						
						
						var data = JSON.stringify($scope.newsdata1);
						console.log(data);
						var url = window.location.origin + "/emailSubscription/create"
						var success = function(data) {
						if(data['properties'].subscriptionStatus=="ALSUBSCRIBED"){
						
							ToastrService.showToastr('error','You have already subscribed with us!','Error!');
								
						}else{
							$('#successmodal').modal('show');
							ToastrService.showToastr('success','You have Successfully Subscribed with us!','Done!');
							
						}
							/*window.location.href="/";*/
						}
						var error = function() {
						ToastrService.showToastr('error','Please try agian to join with us!','Error!');
						
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, data);
	}




});
/*======================Login Controller================================*/
HungryHomeTerminal.controller('LoginController',function($scope,$http){

$scope.showForgotPassword = function() {
	$('#forgotPassword').modal('show');
}

    $scope.save = function(user) {
        $scope.loginDetails = angular.copy(user);
       
      				//var reurl=window.location.href;
      				$scope.loginDetails["reurl"]=window.location.href;
                     data=JSON.stringify($scope.loginDetails);
                     console.log(data);
                      
      $http({
        method: "POST",
        url: window.location.origin + '/web/securityLogin1',
        header:{ 
            'Accept': 'application/json',
               'Content-Type': 'application/json'
        },
        data:data
    }).success(function(data) {
      if(data.authenticateStatus=="true"){
        $scope.profileData=data;
       alert("success");
       
        window.location.reload();
      }else{
       alert("Eroor")
      }
      /* for (var i = 0; i < data.length; i++) {
         console.log(data[i].quantity);
   
       };*/
         }).error(function(error){

            $scope.error = error;
         });

}   

});

/*======================Registration Controller=========================*/
HungryHomeTerminal
		.controller('RegistrationController',function($scope, HTTPService,ToastrService) {

					$scope.userRegistration = function(userdata) {



						var password = document.getElementById("reg_password");
  			var confirm_password = document.getElementById("reg_confirm_password");
					if(password.value != confirm_password.value) {

						$('#wrg_pass').addClass('show').addClass('error');
    				confirm_password.setCustomValidity("Passwords Don't Match");
							return false;
  					} else {
  						$('#wrg_pass').removeClass('show').removeClass('error');
    						confirm_password.setCustomValidity('');
  					}
						/*event.preventDefault();*/
						/*var user = angular.copy($scope.user)*/
					/*	userdata.isDefaultPrevented();*/ 
					  

						/*$scope.number = $(event.currentTarget).parents('.register-row-non').find('.phnumber').val();*/
							$('.reg_span_err').remove();
       var x = document.forms["registerForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        $(event.currentTarget).parents('.reg_div').find('.reg_email_span').append("<span class='reg_span_err pull-right'><i class='fa fa-exclamation-triangle l-s-5' aria-hidden='true'></i>Please enter valid email address</span>");
        return false;
    }else{
    		$('.reg_span_err').remove();
    }
 

						$scope.userregis={};
						$scope.userregis['properties'] = userdata;
						$scope.userregis['properties']['$siren4j.class'] = "com.meat.representation.siren.UsersRepresentation";
						$scope.userregis['properties']['phoneNo']=$scope.userdata.phoneNo+'';	
						$scope.userregis['properties']['status'] = "INACTIVE";
						$scope.userregis['properties']['userType'] = "CUSTOMER";
						$scope.userregis['class'] = [ "user" ];
						$scope.userregis['rel'] = [ 'item' ];
						var data = JSON.stringify($scope.userregis);
						var url = window.location.origin + "/users/create"
						var success = function(data) {
							$("#loader").addClass('show');
							if(data['properties'].emailStatus=="DUPLICATEEM"){
							ToastrService.showToastr('error','Your Details already exists,Give Someother or click forgot password','Done!');	
							}
							else if(data['properties'].emailStatus=="DUPLICATEE"){
							ToastrService.showToastr('error','Your EmailId already exists,Give Someother or click forgot password','Done!');	
							}
							else if(data['properties'].emailStatus=="DUPLICATEM"){
							ToastrService.showToastr('error','Your Mobile.No already exists,Give Someother or click forgot password','Done!');	
							}
							else{
							ToastrService.showToastr('success','You have Successfully registered with us!','Done!');
			
									window.location.href="/";
									$("#loader").removeClass('show');			
							
							}
						}
						var error = function() {
						ToastrService.showToastr('error','Please try agian to join with us!','Error!');
						$("#loader").removeClass('show');
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, data);

					},
					$scope.initDatePicker = function(){
		$('.datepicker').datepicker({
			autoclose:'true',
			
			minDate:0,
			format:'dd/mm/yyyy',
			todayHighlight:'true',
			orientation:'bottom',
			defaultDate:new Date()

		});
	}

				});

/*======================================Toastr Service================================================*/
HungryHomeTerminal.service('ToastrService', function() {

	this.showToastr = function(msgType,msg,title){
				toastr.options = {
                                      "closeButton": true,
                                      "debug": false,
                                      "positionClass": "toast-top-right",
                                      "onclick": null,
                                      "showDuration": "1000",
                                      "hideDuration": "1000",
                                      "timeOut": "2000",
                                      "extendedTimeOut": "500",
                                      "showEasing": "swing",
                                      "hideEasing": "linear",
                                      "showMethod": "fadeIn",
                                      "hideMethod": "fadeOut",
                                      "progressBar":"true"
                                 }
                                    toastr[msgType](msg, title)
                               }
})



HungryHomeTerminal.directive('scrollToItem', function() {                                                      
    return {                                                                                 
        restrict: 'A',                                                                       
        scope: {                                                                             
            scrollTo: "@"                                                                    
        },                                                                                   
        link: function(scope, $elm,attr) {                                                   

            $elm.on('click', function() {                                                    
                $('html,body').animate({scrollTop: $(scope.scrollTo).offset().top }, 600,"easeOutBounce");
            });                                                                              
        }                                                                                    
    }})  



/*utilities*/

function showQuickModal(id, parentDiv,$scope,$http,$compile,CartService,RecentItemsService){



if(sessionStorage.getItem('userId')){
	
	var url = '/quickView/item/'+id;
	var req = {
				 method: 'GET',
				 url: url,
				 dataType:'text/html'
				}
				$http(req).success(
								function(data) {
										var scope = $scope
								var compiledHTML = $compile(data)(scope)
									$('.itemquickview').remove();
		parentDiv.append(compiledHTML);
		$('.itemquickview').modal('show');
		

								
								}).error(
								function(data, status, headers, config) {
									// called asynchronously if an error occurs
									// or server returns response with an error
									// status.
								});

}else{
	alert("Please Login");
}

/*$scope.initQuickDatePicker = function(){
	$('.singleItemDatePicker').datepicker({
    format: 'mm/dd/yyyy',
    startDate: '-3d',
    autoclose:'true'
});
}*/
$scope.deliveryDate = new Date();
$scope.quickViewItem = {};
 $scope.itemUnits = 1;
	$scope.setQuickRestaurantItem = function(itemId,restaurantItemId, restaurantId, restaurantName,itemName, price,
			quantity) {
		$scope.restaurantItemId = restaurantItemId;
		$scope.quickViewItem[restaurantItemId] = {
				'itemId' : itemId,
				'restaurantId' : restaurantId,
				'units' : $scope.itemUnits,
				'quantity' : quantity,
				'restaurantItemId' : restaurantItemId,
				'itemName' : itemName,
				'restaurantName' : restaurantName,
				'price' : price
				}




	}

	$scope.availableTimings = {};
	$scope.timingName  = {};
	$scope.setTimingDetails = function(timingId, availableTime,timingName){
		$scope.availableTimings[timingId]  = availableTime.split(',').filter(function(v) {return v !== ''})
		$scope.timingName[timingId]  = timingName;
	}
	$scope.checkOutNow = function(){


		var item = $scope.quickViewItem[$scope.restaurantItemId]
			item['timingDetailsId'] = $scope.timingId;
			item['deliveryTime'] = $scope.deliveryTime;
			item['deliveryDate'] = $scope.deliveryDate;
			item['timingName'] = $scope.timingName[$scope.timingId];
			item['units'] = $scope.itemUnits;

		CartService.setQuickBuyItem(item);
	}
}


function getItemsByAttributes($http,$rootScope){
	var builder = attributesUrlBuilder();
							

						$http.get(builder.url).success(
								function(data, status, headers, config) {
									$('#items_list').html(data);
									$rootScope.loadMoreShow = true;
									var stateObj = {"url":builder.addrUrl}
									
				window.history.pushState(stateObj, "", stateObj.url);
		/*		 history.pushState(
    { page: 1 }, 'page 1', '?page=1'
  );
  $location.url(addrUrl);
$location.replace();
window.history.pushState(null, 'any', $location.url());*/
								}).error(
								function(data, status, headers, config) {
									

								});



					
}


function attributesUrlBuilder(){

	var builder = {};

							var filters = [];
						$('.checker input[type="checkbox"]:checked').each(
								function() {
									var filter = $(this).attr("filter") + '='
											+ $(this).attr("name");
											if($(this).attr("filter")=='atval'){
													filter = filter+'&atid='+$(this).attr("content");
											}
									console.log($(this));
									filters.push(filter);

								});

						var url ='&'+filters.join('&');
						var priceTag = '';
							var p = $('#amount').val().replace(/₹/g,'');
							var sp = parseInt(p.split('-')[0]);
							var ep = parseInt(p.split('-')[1]);
							priceTag = 'sp='+sp+'&ep='+ep;

							
						

						var cid = $.QueryString['id'];
						var zid = $.QueryString['zid'];
						url = url+'&'+priceTag+'&zid='+zid;
						
						/* alert(url) */
						if($('.sub-category .sub_selected').length>0)
						{
							var scid = ''
							var scids = [];
								$('.sub-category .sub_selected').each(function(){
												scids.push('scid='+$(this).attr('name'));
										});	
											
											scid = scids.join('&');	

											url = url+'&'+scid;		
							}	
							var attrUrl = '?id='+cid+url
							var currUrl = window.location.pathname.split('/a')[0];
							var addrUrl = currUrl+'/a?id='+cid+url;
							url = (window.location.pathname.split('/').indexOf(
								'category') != -1) ? (window.location.origin
								+ '/filter/root/items?cid=' + cid +'&' + url)
								: (window.location.origin
										+ '/filter/root/items?' + url);



								builder['url'] = url;
								builder['addrUrl'] = addrUrl;
								builder['attrUrl'] = attrUrl;
								return builder;

}
