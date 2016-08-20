HungryHomeTerminal
		.service(
				'CartService',
				function($rootScope, HTTPService,ToastrService) {

					var self = this;
					self.cart = {};
					self.cart['items'] = {};
					self.cart['totalPrice'] = 0.0;
					self.cart['discount'] =parseFloat(0.0);
					self.cartItemIds = [];	
					self.quickbuyItem = {};
					self.quickbuyItem['totalPrice'] = 0.0;
					self.quickbuyItem['item'] = {};
					self.setQuickBuyItem = function(item){
						self.quickbuyItem['item'] = item;
					self.quickbuyItem['totalPrice'] = item.price;
					self.QuickOrderCreate(item);
					self.setQuickBuyItemtoLocalStorage(self.quickbuyItem);



					}
					self.pushItemToServer = function(item) {
						/*alert(self.getTotalPrice());*/
						/*var amount = parseFloat(self.getTotalPrice())+parseFloat(item.price);*/
						
						
						var cartItemObject = {
																
									    "class": [
									        "preOrderCartItems"
									    ],
									    "rel": [
									        "item"
									    ]
						};
						cartItemObject['properties'] = {
							"$siren4j.class": "com.hungry.representation.siren.PreOrderCartItemsRepresentation",
							"restaurantItemId" : item.restaurantItemId,
							"userId" : sessionStorage.getItem('userId'),
							"quantity" : item.quantity,
							"units" : item.units,
							"price" : item.price,
							"cartPrice":parseFloat(item.units*item.price)+'',
							 "preOrderCartItemsStatus": "CartAdded",
							 "statusFlag":"C"
							/*"timingName":item.timingName,
							"timingDetailsId":item.timingDetailsId*/

						};

						
						var JSONData = JSON.stringify(cartItemObject);
						console.log(JSONData);
						var url = window.location.origin + "/preOrderCartItems/create"
						var success = function(response) {
							console.log('success')

							ToastrService.showToastr('success','Item added to your bowl','Success')
							/*							var cart = $('.cartLid');
						   var imgtofly = $('.product-main-image .img-responsive')
							if (imgtofly) {
								var imgclone = imgtofly.clone()
									.offset({ top:imgtofly.offset().top, left:imgtofly.offset().left })
									.css({'opacity':'0.7', 'position':'absolute', 'height':'150px', 'width':'150px', 'z-index':'100000'})
									.appendTo($('body'))
									.animate({
										'top':cart.offset().top + 45,
										'left':cart.offset().left + 40,
										'width':55,
										'height':55



						        
									}, 1250, 'easeInOutBack');
									cart.css({ "width": "100px","height": "100px","top": "-46px","left": "-62px", "transform": "rotate(30deg)",});
								imgclone.animate({'width':0, 'height':0}, function(){
								 $(this).detach();
								
								cart.css({ "width": "100px","height": "100px","top": "-21px","left": "-85px", "transform": "rotate(0deg)"});



								 });


							}*/
						
						var orderItemId = response['properties'].id;
						if(orderItemId){
							self.cart['items'] = (self.cart['items']) ? self.cart['items']:{};
								self.cart['items'][orderItemId] = item;
									
							self.setItemsToLocalStorage(self.cart['items']);
							self.getTotalPrice();
						}
						}
						var error = function() {
							ToastrService.showToastr('error','Something Went wrong, Please try after dome time','Oops')
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, JSONData);

					}
					self.setCartItems = function(item, itemSource) {
						var rIId = item.restaurantItemId;
						if (window.sessionStorage.getItem('userId')) {
						/*	alert(self.getItemsFromLocalStorage());*/
							var cartItemsArray = [];

							if (self.getItemsFromLocalStorage() && itemSource=='toServer') {
								self.cart['items'] = self
										.getItemsFromLocalStorage();
										cartItemsArray = Object.keys(self.getItemsFromLocalStorage());
										
							}
							

						/*	if (cartItemsArray.indexOf(rIId)==-1) {*/


								

							
								if (itemSource == "toServer") {

									if(!self.checkForItemExist(item))
									{
									self.pushItemToServer(item);
								}else{
									ToastrService.showToastr('info','Already added to cart,To Update your item go to cart','Oops')
								}
								
								} else {

									self.cart['items'] = (self.cart['items']) ? self.cart['items']:{};
								self.cart['items'][item.orderItemId] = item;
									self.getTotalPrice();
									self
											.setItemsToLocalStorage(self.cart['items']);

								}
								if(itemSource == "toServer")
								{
/*
														var cart = $('.cartLid');
						   var imgtofly = $('.product-main-image .img-responsive')
							if (imgtofly) {
								var imgclone = imgtofly.clone()
									.offset({ top:imgtofly.offset().top, left:imgtofly.offset().left })
									.css({'opacity':'0.7', 'position':'absolute', 'height':'150px', 'width':'150px', 'z-index':'100000'})
									.appendTo($('body'))
									.animate({
										'top':cart.offset().top + 45,
										'left':cart.offset().left + 40,
										'width':55,
										'height':55



						        
									}, 1250, 'easeInOutBack');
									cart.css({ "width": "100px","height": "100px","top": "-46px","left": "-62px", "transform": "rotate(30deg)",});
								imgclone.animate({'width':0, 'height':0}, function(){
								 $(this).detach();
								cart.animate({"width":0,'height':0});
								cart.css({ "width": "100px","height": "100px","top": "-21px","left": "-85px", "transform": "rotate(0deg)"});



								 });
							}*/
						}
							/*} else {
								ToastrService.showToastr('info','Already added to cart,To Update your item go to cart','Oops')
							}*/
						} else {
							ToastrService.showToastr('warning','Please Login to Continue','Sorry')
							window.location.href = "/login"
						}
					}
					self.getTotalPrice = function() {
						self.cart['totalPrice'] = 0.0;
						for (item in self.cart['items']) {

							self.cart['totalPrice'] += parseFloat(self.cart.items[item].totalItemPrice);
						}
						self
								.setTotalPriceToLocalStorage(self.cart['totalPrice'])
								return self.cart['totalPrice'];

					}
					self.QuickOrderCreate = function(item){
						var cartItemsObject = item;
						var cartPOSTObject = {};
						var discount=0.0;
						/*cartPOSTObject = {
							"class" : [ "OrderRepresentation" ],
							"rel" : [ "item" ]
						}
						cartPOSTObject['properties'] = {
							"$siren4j.class" : "com.hungry.representation.siren.OrderRepresentation",
							
							"status" : "quickCartAdded",
							"amount" : item.price+'',
							"discount" : discount+'',
							/*"id" : $scope.orderId
						};
						cartPOSTObject['entities'] = [];*/
						
						/*for (item in cartItemsObject) {*/
							var cartItemObject = {
								"class": [
									        "preOrderCartItems"
									    ],
									    "rel": [
									        "item"
									    ]
							};
							cartItemObject['properties'] = {
								"$siren4j.class": "com.hungry.representation.siren.PreOrderCartItemsRepresentation",
								"restaurantItemId" : item.restaurantItemId,
								"userId" : sessionStorage.getItem('userId'),
								"quantity" : item.quantity,
								"units" : parseInt(item.units),
								"price" : item.price,
								"deliveryTime" : item.deliveryTime,
								"deliveryDate" : item.deliveryDate,
								"timingDetailsId":item.timingDetailsId,
								"timingName":item.timingName,
								"preOrderCartItemsStatus":"quickCartAdded",
								"statusFlag":"QC",
								"cartPrice":parseFloat(item.units*item.price)+''
							};
							/*cartPOSTObject['entities'].push(cartItemObject);*/

						
						console.log(JSON.stringify(cartItemObject));
						var data = JSON.stringify(cartItemObject);
						url=window.location.origin+"/preOrderCartItems/create"
						var success = function(){
						
							

							window.location.href="/quickCheckout";

						}
						var error = function(){
							alert("error");
						}
						HTTPService.processServerRes(url, 'POST', success,
								error, data);
					}
					self.editItemById = function(orderItemId,units, deliveryDate, deliveryTime,timingDetailsId,timingName) {
						if (self.getItemsFromLocalStorage()) {
							self.cart['items'] = self
									.getItemsFromLocalStorage();
						}
						var cartItemObject = {
								"class" : [ "orderItem" ],
								"rel" : [ "orderItemRep" ]
							};
							cartItemObject['properties'] = {
								"$siren4j.class" : "com.hungry.representation.siren.OrderItemRepresentation",
								"id":self.cart.items[orderItemId].orderItemId,
								"restaurantItemId" : self.cart.items[orderItemId].restaurantItemId,
								"quantity" : self.cart.items[orderItemId].quantity,
								"units" : parseInt(units),
								"price" : self.cart.items[orderItemId].price,
								"deliveryTime" :deliveryTime,
								"deliveryDate" :deliveryDate,
								"timingDetailsId":timingDetailsId,

							};
							var JSONData = JSON.stringify(cartItemObject);

							var url = "/orderItem/"+self.cart.items[orderItemId].orderItemId+"/edit";
							var success = function(response){
											
							}
							var error = function(error){
								alert(error);
							}
							HTTPService.processServerRes(url, 'POST', success,
								error, JSONData);
							self.cart.items[orderItemId]['deliveryTime'] = deliveryTime;
											self.cart.items[orderItemId]['deliveryDate'] = deliveryDate;
											self.cart.items[orderItemId]['units'] = units;
											self.cart.items[orderItemId]['timingDetailsId'] = timingDetailsId;
											self.cart.items[orderItemId]['timingName'] = timingName;
											self.cart.items[orderItemId]['totalItemPrice'] = self.cart.items[orderItemId]['units']
													* self.cart.items[orderItemId]['price'];
											self.setItemsToLocalStorage(self.cart['items']);
											self.getTotalPrice();
							return true;
						
						
					}

					self.removeItemById = function(id){
						if (self.getItemsFromLocalStorage()) {
							self.cart['items'] = self
									.getItemsFromLocalStorage();
						}
						var orderItemId = self.cart.items[id]['orderItemId'];
						var url="/orderItem/"+orderItemId+"/delete";
						var success = function(response){
							delete self.cart.items[id];
							self.setItemsToLocalStorage(self.cart['items']);
							self.getTotalPrice();
							window.location.reload();
						}
						var error = function(){
							alert("error")

						}
						HTTPService.processServerRes(url, 'GET', success,
								error,'');
					}
					self.setQuickBuyItemtoLocalStorage = function(quickBuyItem){
						localStorage.removeItem('HungryQuickBuyItem');
						localStorage.setItem('HungryQuickBuyItem', JSON
								.stringify(quickBuyItem));
					}
					self.getQuickBuyItemtoLocalStorage = function(quickBuyItem){
						var hungryquickItem = localStorage.getItem('HungryQuickBuyItem');
						return (hungryquickItem)?JSON.parse(hungryquickItem):null;
					}
					self.getItemsFromLocalStorage = function() {


						var hungryCartItems = localStorage.getItem('HungryCartItems');
						return (hungryCartItems)?JSON.parse(hungryCartItems):null;
					}
					self.setItemsToLocalStorage = function(cartItems) {
						localStorage.removeItem('HungryCartItems');
						localStorage.setItem('HungryCartItems', JSON
								.stringify(cartItems));
					}
					self.setTotalPriceToLocalStorage = function(cartTotalPrice) {
						localStorage.removeItem('HungryCartTotalPrice');
						localStorage.setItem('HungryCartTotalPrice',
								cartTotalPrice);
					}
					self.getTotalPriceFromLocalStorage = function() {
						return localStorage.getItem('HungryCartTotalPrice');
					}
					self.removeItemFromLocalStorage = function() {
						localStorage.removeItem('HungryCartItems');
						localStorage.removeItem('HungryCartTotalPrice');
					}
					self.removeQuickItemFromLocalStorage = function() {


						localStorage.removeItem('HungryQuickBuyItem');
					}
					self.checkForItemExist = function(item){
						var items = self.getItemsFromLocalStorage();
						var existStatus = false;
						if(items!=null){
							for(var key in items){
								if(items[key].restaurantItemId==item.restaurantItemId){
									existStatus = true
								}
							}
						}
						return existStatus;
					}

				})


