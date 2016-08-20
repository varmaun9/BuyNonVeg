HungryHomeTerminal.service('RecentItemsService',function(ToastrService){
						var self = this;	
						self.recentItems = {};


						self.setRecentItems = function(item,userId){
								if(sessionStorage.getItem('userId')){
									if(self.getRecentItems(userId)){
										self.recentItems[userId] = self.getRecentItems(userId);
									}else{
										self.recentItems[userId] = {};
									}
									self.recentItems[userId][item.restaurantItemId]={};	
									self.recentItems[userId][item.restaurantItemId]=item;	
									localStorage.setItem('recentItems',JSON.stringify(self.recentItems));
								


								}
								else
								{
									ToastrService.showToastr('warning','Please Login','OOps!')
								}

						}
						self.getRecentItems  = function(userId)
						{	
							if(localStorage.getItem('recentItems')){
							self.recentItems[userId] =JSON.parse(localStorage.getItem('recentItems'))[userId];
							return self.recentItems[userId];
						}
						else{
							return null;
						}

						}


				});


// HungryHomeTerminal.service('loadingView',function(){
// 	this.startLoading = function(text){
// 		if(text=="show"){
// 	    	return $("body").append('<div class="loadingModal"><div class="spiner-example '+text+'"><div class="sk-spinner sk-spinner-wave"><div class="sk-rect1"></div><div class="sk-rect2"></div><div class="sk-rect3"></div><div class="sk-rect4"></div></div></div></div>');
// 		}else{
// 			// return $("body").prepend('<div class="spiner-example '+text+'"><div class="sk-spinner sk-spinner-wave"><div class="sk-rect1"></div><div class="sk-rect2"></div><div class="sk-rect3"></div><div class="sk-rect4"></div></div></div>');
// 			return $('.loadingModal').remove()
// 		}
// 	}
// })