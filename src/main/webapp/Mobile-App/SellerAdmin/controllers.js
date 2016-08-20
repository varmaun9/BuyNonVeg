function LoadingController($scope, $ionicLoading,$timeout,$state){
  $timeout(function() {
    $state.go('login');
    $ionicLoading.hide();
  }, 4300);
}
function loginController($scope, $ionicLoading, $timeout, $state, $http, baseURL, alertMsg, $ionicModal){
  $scope.userLogin=function(user){
    $ionicLoading.show({template: '<p class=""><ion-spinner icon="lines"/></p>',hideOnStageChange: true});
    var data = "username="+user.username+"&channel=SELLERMOBILE&password="+user.password;
    // $.ajax({
    // data: data,
    // timeout: 1000,
    // type: 'POST',
    // url: 'http://192.168.0.129:8082/login'
    // }).done(function(data, textStatus, jqXHR) {
    //   // var preLoginInfo = JSON.parse($.cookie('dashboard.pre.login.request'));
    //   if(jqXHR.status==302){
    //     $state.go('start.home');
    //   }else if(jqXHR.status==200){
    //     $state.go('start.home');
    //     alert('You did a great job');
    //   }
    // }).fail(function(jqXHR, textStatus, errorThrown) {
    //   alert('Booh! Wrong credentials, try again!');
    // });

    localStorage.setItem("userId", '');
        localStorage.setItem("userName", '');
        localStorage.setItem("sellerBranchId", '');
        localStorage.setItem("sellerName", '');
      $http({
        method: 'POST',
        url: baseURL.IP+"/login",
        data:data,
        headers : {'Content-Type': 'application/x-www-form-urlencoded'},
      }).then(function successCallback(response) {
        // alert('hi');
        var userCred = response.data;
        var userData = userCred.split(':::');
        localStorage.setItem("userId", userData[0]);
        localStorage.setItem("userName", userData[1]);
        localStorage.setItem("sellerBranchId", userData[2]);
        localStorage.setItem("sellerName", userData[3]);
        $state.go('start.home');
        $ionicLoading.hide();
          // this callback will be called asynchronously
          // when the response is available
        }, function failureCallback(response) {
            $ionicLoading.hide();
            alertMsg.alertPopup('error');
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        });
   }

  $scope.forgotPassword=function(){
    $ionicModal.fromTemplateUrl("templates/ForgotPassword.html", function($ionicModal){
      $scope.modal = $ionicModal;
    },{
      scope: $scope,
      animation: 'slide-in-up'
    }).then(function(modal) {
      $scope.modal = modal;
      $scope.modal.show();
    });
    
  };
    $scope.closeModal = function() {
      $scope.modal.hide();
    };
    //Cleanup the modal when we're done with it!
    $scope.$on('$destroy', function() {
      $scope.modal.remove();
    });
    // Execute action on hide modal
    $scope.$on('modal.hidden', function() {
      // Execute action
    });
    // Execute action on remove modal
    $scope.$on('modal.removed', function() {
      // Execute action
    });
    $scope.forgotOtp=false;
  $scope.changePassword=function(res){
    console.log(res)
  }
}
// function orderListController($scope,$rootScope,$state,$ionicPopup,$http,$compile,$ionicActionSheet,processReqFactory,webSocketService,$ionicModal,$ionicHistory,baseURL,$location,$cordovaPush,$cordovaLocalNotification,$cordovaVibration) {
function orderListController($scope,$rootScope,$state,$ionicPopup,$http,$compile,$ionicActionSheet,processReqFactory,$ionicModal,$ionicHistory,baseURL,$location,webSocketService,$cordovaLocalNotification) {
  $scope.userName = localStorage.getItem("userName")
  $scope.sellerName = localStorage.getItem("sellerName")
  // $scope.profileView = function() {
  //     $ionicModal.fromTemplateUrl(baseURL.IP+'/seller/accountpage', function($ionicModal){
  //       $scope.modal = $ionicModal;
  //     },{
  //       scope: $scope,
  //       animation: 'slide-in-up'
  //     }).then(function(modal) {
  //       $scope.modal = modal;
  //       $scope.modal.show();
  //     });
  // }
  var stompClient = null;
  if(webSocketService.stompClient==null){
    stompClient=webSocketService.webSocketConnect();
  }else{
    stompClient=webSocketService.stompClient;
  }

  stompClient.connect({}, function(frame) {
    stompClient.subscribe('/orders/subOrders/'+baseURL.sellerBranchId, function(notificationResponse){
          //alert(notificationResponse.body)
      console.log(JSON.parse(notificationResponse.body));
      // $scope.
      // var audio = new Audio('./Restaurants/Dashboard/2.mp3');
      // audio.play();
      var subOrder = {};
      subOrder = JSON.parse(notificationResponse.body);
      
      var notificationOrderItems = subOrder.orderItemModels;
      $cordovaLocalNotification.schedule(
        {
          message: ""+subOrder.subOrderCode+"",
          icon: "file://res/meat_logo.png"
        })
      $cordovaVibration.vibrate(100);
      for(var orderItem in notificationOrderItems){
        $scope.setOrderData(subOrder.id,subOrder.subOrderCode,subOrder.subOrderStatus,subOrder.subOrderTotalPrice,subOrder.startTime,subOrder.endTime,subOrder.timingName,subOrder.subOrderDeliveryTime,subOrder.subOrderDeliveryDate,notificationOrderItems[orderItem],'0')
        $scope.setOrderItemsData(subOrder.id,subOrder.subOrderCode,notificationOrderItems[orderItem].sellerItemName,notificationOrderItems[orderItem].id,notificationOrderItems[orderItem].units,notificationOrderItems[orderItem].measurementUnit)
      }
    });
  });
  
  // var sellerData=[];
  $scope.setOrderData = function(subOrderId,subOrderCode,subOrderStatus,subOrderTotalPrice,startTime,endTime,timingName,DeliveryTime,subOrderDeliveryDate,index){
      // console.log(subOrderCode);
      // $scope.countData = {'placedCount': '0','confirmedCount': '0'};
      $ionicHistory.clearHistory();
      $ionicHistory.clearCache();
      
      // if(index == '1'){
      //   var i = 1;
      //   for(var k in i){
        // $rootScope.orderData=[];
        // $rootScope.orderData[index] = {};
        
        if(index==0){
          $rootScope.orderData=[];
          var subOrderDataDetails={};
          subOrderDataDetails['id'] = subOrderId;
          subOrderDataDetails['subOrderCode'] = subOrderCode;
          subOrderDataDetails['subOrderStatus'] = subOrderStatus;
          subOrderDataDetails['subOrderTotalPrice'] = subOrderTotalPrice;
          subOrderDataDetails['startTime'] = startTime;
          subOrderDataDetails['endTime'] = endTime;
          subOrderDataDetails['timingName'] = timingName;
          subOrderDataDetails['subOrderDeliveryTime'] = DeliveryTime
          subOrderDataDetails['subOrderDeliveryDate'] = subOrderDeliveryDate;
          subOrderDataDetails['orderItems'] = [];
          // subOrderDataDetails['orderItems'].push(orderItems);
          $rootScope.orderData.unshift(subOrderDataDetails);
        }else{
          var subOrderDataDetails={};
          subOrderDataDetails['id'] = subOrderId;
          subOrderDataDetails['subOrderCode'] = subOrderCode;
          subOrderDataDetails['subOrderStatus'] = subOrderStatus;
          subOrderDataDetails['subOrderTotalPrice'] = subOrderTotalPrice;
          subOrderDataDetails['startTime'] = startTime;
          subOrderDataDetails['endTime'] = endTime;
          subOrderDataDetails['timingName'] = timingName;
          subOrderDataDetails['subOrderDeliveryTime'] = DeliveryTime
          subOrderDataDetails['subOrderDeliveryDate'] = subOrderDeliveryDate;
          subOrderDataDetails['orderItems'] = [];
          // subOrderDataDetails['orderItems'].push(orderItems);
          $rootScope.orderData.unshift(subOrderDataDetails);
        }
        // if(!$rootScope.orderData[index][subOrderCode]){
           
        //   subOrderDataDetails['id'] = subOrderId;
        //   subOrderDataDetails['subOrderCode'] = subOrderCode;
        //   subOrderDataDetails['subOrderStatus'] = subOrderStatus;
        //   subOrderDataDetails['subOrderTotalPrice'] = subOrderTotalPrice;
        //   subOrderDataDetails['startTime'] = startTime;
        //   subOrderDataDetails['endTime'] = endTime;
        //   subOrderDataDetails['timingName'] = timingName;
        //   subOrderDataDetails['subOrderDeliveryTime'] = DeliveryTime
        //   subOrderDataDetails['subOrderDeliveryDate'] = subOrderDeliveryDate;
        //   subOrderDataDetails['orderItems'] = [];
        //   // subOrderDataDetails['orderItems'].push(orderItems);
        //   $rootScope.orderData.unshift(subOrderDataDetails);
        // }
      //   }
      // }    // console.log(JSON.stringify($rootScope.orderData));
      $scope.countData = {'placedCount': '0','confirmedCount': '0'};
      if($rootScope.orderData[$rootScope.orderData.length - 1].subOrderStatus=="CONFIRMED"){
        $scope.countData.confirmedCount = $rootScope.orderData.length;
      }else if($rootScope.orderData[$rootScope.orderData.length - 1].subOrderStatus=="PLACED"){
        $scope.countData.placedCount = $rootScope.orderData.length;
      }
      
  }
  $scope.setOrderItemsData=function(subOrderId,subOrderCode,itemName,itemId,units,measurementUnit){
    $.each($rootScope.orderData,function(k,v){
      if(v['subOrderCode']==subOrderCode){
        v['orderItems'].push({'subOrderId':subOrderId,'subOrderCode':subOrderCode,'itemName':itemName,'itemId':itemId,'units':units,'measurementUnit':measurementUnit})
      }
    })
  }

  var d = new Date();
  var getDay=d.getDate();
  var getMonth=d.getMonth()+1;
  var getFullYear=d.getFullYear();
  $scope.clickedDate=getFullYear+"-"+getMonth+"-"+getDay;
  var weekdays=new Array();
  weekdays[0]="Sun";
  weekdays[1]="Mon";
  weekdays[2]="Tue";
  weekdays[3]="Wed";
  weekdays[4]="Thu";
  weekdays[5]="Fri";
  weekdays[6]="Sat";
  var yesterday = new Date(d);
  $rootScope.array=new Array();
  var week = d.getDay() -1;
  if(week == -1){
    week = 6;
  }
  // var weekday = yesterday.getDate() -1;
  for (var i= -1;i<4;i++){
    var weekday = weekdays[week];
    var date= new Date(yesterday.getFullYear() ,yesterday.getMonth(), yesterday.getDate() + i);
    var currentDate= date.getDate();
    var currentMonth= date.getMonth();
    if(currentDate<10){
      currentDate = '0'+date.getDate();
    }
    var obj={
      "day": weekday,
      "date": currentDate,
      "month": currentMonth,
      "year": date.getFullYear(),
      "fullYear": date.getFullYear()+'-'+currentMonth+'-'+currentDate,
      "status": (function(){if(yesterday.getDate()==currentDate){return true}else{return false}})()
    }
    $rootScope.array.push(obj);
    week++;  
    if(weekday=="Sat"){
      week=0;
    }   
  }
  $scope.dateChange=function(newDate){
    $ionicHistory.clearCache();
    $ionicHistory.clearHistory();
    for (var i= 0;i<$rootScope.array.length;i++){
      $rootScope.array[i]['status']=false;
    }
    var hash = $location.path();
    var value = hash.split('/');
    newDate['status']=true;
    var month = newDate.month + 1;
    $scope.clickedDate = newDate.year+'-'+month+'-'+newDate.date;
    if(hash){
      $state.go('start.orders.'+value[3]+'',{fullDate: $scope.clickedDate})
    }
    $scope.modal.hide();
    $rootScope.orderData=[];
  }

  $scope.toggleCalendar = function() {
    $ionicModal.fromTemplateUrl('templates/calender.html', function($ionicModal){
      $scope.modal = $ionicModal;
    },{
      scope: $scope,
      animation: 'popIn',
      duration: 0.5
    }).then(function(modal) {
      $scope.modal = modal;
      $scope.modal.show();
       $scope.calender=$scope.array;
    });
  };
  $scope.singleOrder = function(subOrderId) {
    $ionicModal.fromTemplateUrl(baseURL.IP+'/seller/subOrder/'+subOrderId+'', function($ionicModal){
      $scope.modal = $ionicModal;
    },{
      scope: $scope,
      animation: 'slide-in-up'
    }).then(function(modal) {
      $scope.modal = modal;
      $scope.modal.show();
    });
    
  };
  $scope.closeModal = function() {
    $scope.modal.hide();
  };
  //Cleanup the modal when we're done with it!
  $scope.$on('$destroy', function() {
    $scope.modal.remove();
  });
  // Execute action on hide modal
  $scope.$on('modal.hidden', function() {
    // Execute action
  });
  // Execute action on remove modal
  $scope.$on('modal.removed', function() {
    // Execute action
  });
   // Query View pages
  $scope.TopQueriesFAQ = function(){
    $ionicModal.fromTemplateUrl('templates/QueriesListView.html', function($ionicModal){
        $scope.modal = $ionicModal;
    },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
    });
  }
  $scope.CategoryQueries=function(){
    $ionicModal.fromTemplateUrl('templates/CategoryQueriesList.html', function($ionicModal){
        $scope.modalCategory = $ionicModal;
    },{
        scope: $scope,
        animation: 'slide-in-right'
      }).then(function(modal) {
        $scope.modalCategory = modal;
        $scope.modalCategory.show();
    });
  }
  $scope.closeModalCategory = function(){
    $scope.modalCategory.remove();
  }
  // Return View pages
  $scope.ReturnFilter=function(){
    $ionicModal.fromTemplateUrl('templates/ReturnFilter.html', function($ionicModal){
        $scope.modal = $ionicModal;
    },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
    });
  }
  $scope.OtherRequest=function(){
    $ionicModal.fromTemplateUrl('templates/OtherRequest.html', function($ionicModal){
        $scope.modal = $ionicModal;
    },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
    });
  }

  $scope.toggleGroup = function(index) {
    if ($scope.isGroupShown(index)) {
      $scope.shownGroup = null;
    } else {
      $scope.shownGroup = index;
    }
  };
  $scope.isGroupShown = function(index) {
    return $scope.shownGroup == index;
  };
  $scope.declineOrder=function(id,Status){
    var jsonFile={
        "class":['subOrder'],
        "properties":{
          "$siren4j.class": "com.meat.representation.siren.SubOrderRepresentation",
          "id":id,
          "subOrderStatus":Status
        }
    }
    processReqFactory.processReq(baseURL.IP+'/subOrder/'+id+'/edit',"POST",jsonFile,function(){
      location.reload();
      $scope.$broadcast('scroll.refreshComplete');
      $scope.modal.hide();
    },function(){});            
  }

  $scope.confirmOrder=function(id,Status){
    var jsonFile={
        "class":['subOrder'],
        "properties":{
          "$siren4j.class": "com.meat.representation.siren.SubOrderRepresentation",
          "id":id,
          "subOrderStatus":Status
        }
    }
    processReqFactory.processReq(baseURL.IP+'/subOrder/'+id+'/edit',"POST",jsonFile,function(){
      location.reload();
      $scope.$broadcast('scroll.refreshComplete');
      $scope.modal.hide();
    },function(){});            
  }
  $scope.users={};
  $scope.shippedOrder=function(id,subOrderId,Status){
    var jsonFile={
        "class":['subOrder'],
        "properties":{
          "$siren4j.class": "com.meat.representation.siren.SubOrderRepresentation",
          "id":subOrderId,
          "subOrderStatus":Status,
          "deliveryContactId":$scope.users.id
        }
    }
    console.log(JSON.stringify(jsonFile));
    processReqFactory.processReq(baseURL.IP+'/subOrder/'+subOrderId+'/edit',"POST",jsonFile,function(){
      $scope.modal.hide();
      $scope.$broadcast('scroll.refreshComplete');
      location.reload();
    },function(){});
  }
          
  $scope.deliveredOrder=function(id,Status){
    // console.log($scope.users);
    var jsonFile={
        "class":['subOrder'],
        "properties":{
          "$siren4j.class": "com.meat.representation.siren.SubOrderRepresentation",
          "id":id,
          "subOrderStatus":Status
        }
    }
    processReqFactory.processReq(baseURL.IP+'/subOrder/'+id+'/edit',"POST",jsonFile,function(){
      location.reload();
      $scope.$broadcast('scroll.refreshComplete');
    },function(){});
  }

  $scope.selectingUser=function(subOrderId){
    $scope.subOrderId=subOrderId;
    // processReqFactory.processReq(baseURL.IP+"/sellerItem/sellerItemOnly/40288018526fb58f01526fd986d0001b","GET",'',function(data){
    //   $scope.SellerItemsData=data.entities;
    // },function(){});

    $ionicModal.fromTemplateUrl('templates/DeliveryUserList.html', function($ionicModal){
  // $ionicModal.fromTemplateUrl('my-modal.html', function($ionicModal){
    $scope.modal = $ionicModal;
    },{
      scope: $scope,
      animation: 'slide-in-up'
    }).then(function(modal) {
      $scope.modal = modal;
      $scope.modal.show();

      processReqFactory.processReq(baseURL.IP+"/sellerUser/sellerBranch/"+baseURL.sellerBranchId+"/users/DELIVERY_USER","GET",'',function(data){
         $scope.employeeListData=data.entities;
       },function(){
    });
    });
  }
}
function AccountController($scope, $rootScope, $ionicActionSheet, $ionicHistory, $ionicModal, processReqFactory, baseURL, $cordovaCamera, $cordovaSms, $ionicPopover){
    $scope.branchName = localStorage.getItem("sellerName")
    $scope.userName = localStorage.getItem("userName")
    
    $scope.choosePhoto = function () {

      // $cordovaSms
      // .send(9985046464, 'Hi', options)
      // .then(function() {
      //   alert('Success')
      // }, function(error) {
      //   // An error occurred
      //   alert('error')
      // });


      var options = {
        quality: 75,
        destinationType: Camera.DestinationType.DATA_URL,
        sourceType: Camera.PictureSourceType.PHOTOLIBRARY,
        allowEdit: true,
        encodingType: Camera.EncodingType.JPEG,
        targetWidth: 300,
        targetHeight: 300,
        popoverOptions: CameraPopoverOptions,
        saveToPhotoAlbum: false
    };

    $cordovaCamera.getPicture(options).then(function (imageData) {
        $scope.imgURI = "data:image/jpeg;base64," + imageData;
    }, function (err) {
        // An error occured. Show a message to the user
    });
}
    $scope.toggle = function(index) {
      if ($scope.isShown(index)) {
        $scope.shownGroup = null;
      } else {
        $scope.shownGroup = index;
      }
    };
    $scope.isShown = function(index) {
      return $scope.shownGroup == index;
    };

    // $scope.editModal=function(){
      $ionicPopover.fromTemplateUrl('templates/EditPopOver.html', {
        scope: $scope,
      }).then(function(popover) {
        $scope.popover = popover;
        // $scope.popover.show();
      });
    // }
    $scope.editModal = function($event,sellerUserId) {
      $rootScope.sellerUserId = sellerUserId;
      $scope.popover.show($event);
    };
    $scope.closePopover = function() {
      $scope.popover.hide();
    };
    
    $scope.accountModal = function() {
     // $ionicModal.fromTemplateUrl(baseURL.IP+'/seller/subOrder/'+subOrderId+'', function($ionicModal){
      $ionicModal.fromTemplateUrl('templates/SingleAccount.html', function($ionicModal){
        $scope.modal = $ionicModal;
      },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
      });
    }
    $scope.passwordModal = function() {
     // $ionicModal.fromTemplateUrl(baseURL.IP+'/seller/subOrder/'+subOrderId+'', function($ionicModal){
      $ionicModal.fromTemplateUrl('templates/ChangePassword.html', function($ionicModal){
        $scope.modal = $ionicModal;
      },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
      });
    }
    // $scope.employeeModal = function() {
    //  // $ionicModal.fromTemplateUrl(baseURL.IP+'/seller/subOrder/'+subOrderId+'', function($ionicModal){
    //   $ionicModal.fromTemplateUrl('templates/EmployeeCreation.html', function($ionicModal){
    //     $scope.modal = $ionicModal;
    //   },{
    //     scope: $scope,
    //     animation: 'slide-in-up'
    //   }).then(function(modal) {
    //     $scope.modal = modal;
    //     $scope.modal.show();
    //   });
    // }
    $scope.addressModal=function(){
      $ionicModal.fromTemplateUrl('templates/AddressEdit.html', function($ionicModal){
        $scope.modal = $ionicModal;
      },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
      });
    }
    $scope.employeesListModal=function(){
      $ionicModal.fromTemplateUrl('templates/EmployeeList.html', function($ionicModal){
        $scope.modal = $ionicModal;
      },{
        scope: $scope,
        animation: 'slide-in-up'
      }).then(function(modal) {
        $scope.modal = modal;
        $scope.modal.show();
      });
    }
    $scope.closeModal = function() {
      $scope.modal.hide();
    };
    //Cleanup the modal when we're done with it!
    $scope.$on('$destroy', function() {
      $scope.modal.remove();
    });
    // Execute action on hide modal
    $scope.$on('modal.hidden', function() {
      // Execute action
    });
    // Execute action on remove modal
    $scope.$on('modal.removed', function() {
      // Execute action
    });
    $scope.myGoBack = function() {
      $ionicHistory.goBack();
    };
    // /sellerUser/sellerBranch/{sellerBranch}/users/{userRole}
    processReqFactory.processReq(baseURL.IP+"/sellerUser/sellerBranch/"+baseURL.sellerBranchId+"/users/DELIVERY_USER","GET",'',function(data){
         $scope.employeeList=data.entities;
       },function(){
    });
    processReqFactory.processReq(baseURL.IP+"/users/"+baseURL.userId,"GET",'',function(data){
         $scope.userData=data;
       },function(){
    });
    processReqFactory.processReq(baseURL.IP+"/sellerBranchAddress/sellerBranch/"+baseURL.sellerBranchId,"GET",'',function(data){
         $scope.branchAddressData=data.entities[0];
       },function(){
    });
  }
function SingleAccountController($scope, $rootScope, baseURL, processReqFactory, $ionicLoading){
  $scope.adminUser = function(restaurant) {
    $ionicLoading.show({template: '<p class=""><ion-spinner icon="lines"/></p>',hideOnStageChange: true});
   $scope.restaurantEmpDetails = {};
       
    $scope.restaurantEmpDetails["$siren4j.class"] = "com.meat.representation.siren.SellerUserRepresentation",
    $scope.restaurantEmpDetails["userName"]=restaurant.userName,
    $scope.restaurantEmpDetails["userEmail"]=restaurant.emailId,
    $scope.restaurantEmpDetails["userPhoneNo"]=restaurant.phoneNo,
    $scope.restaurantEmpDetails["id"]=$rootScope.sellerUserId,
   // $scope.restaurantEmpDetails["sellerBranchId"]=baseURL.sellerBranchId,
   // $scope.restaurantEmpDetails["userStatus"]="ACTIVE",
   // $scope.restaurantEmpDetails["userRoleType"]="DELIVERY_USER",
   // $scope.restaurantEmpDetails["sellerUserType"]="SELLER_USER",
   // $scope.restaurantEmpDetails["userType"]="SELLERUSER",
   
  
    $scope.jsonfile = {
       "class":["sellerUser"],
       "rel": ["item"],
       "properties":$scope.restaurantEmpDetails
    };
      data=$scope.jsonfile;
      console.log(JSON.stringify($scope.jsonfile));
    processReqFactory.processReq(baseURL.IP+"/sellerUser/"+$rootScope.sellerUserId+"/edit","POST",data,function(){
      
      $scope.$broadcast('scroll.refreshComplete');
      $ionicLoading.hide();
      $scope.modal.hide();
      location.reload();
      $scope.popover.hide();
    },function(){
    // swal({   title: "ERROR!",   text: " USER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
      });
  };

  $scope.addressChange = function(addressData){
    $scope.jsonfile = {
       "class":["sellerBranchAddress"],
       "rel": ["item"],
       "properties":addressData
    };
      data=$scope.jsonfile;
      console.log(JSON.stringify($scope.jsonfile));
    processReqFactory.processReq(baseURL.IP+"/sellerBranchAddress/"+addressData.id+"/edit","POST",data,function(){
      
      $scope.$broadcast('scroll.refreshComplete');
      $ionicLoading.hide();
      $scope.modal.hide();
      location.reload();
      $scope.popover.hide();
    },function(){
    // swal({   title: "ERROR!",   text: " USER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
      });
  }

  $scope.passwordProceed=function(passwordData){
    $ionicLoading.show({template: '<p class=""><ion-spinner icon="lines"/></p>',hideOnStageChange: true});
   $scope.empPasswordDetails = {};
       
    $scope.empPasswordDetails["$siren4j.class"] = "com.meat.representation.siren.SellerUserRepresentation",
    $scope.empPasswordDetails["password"]=passwordData.password,
    $scope.empPasswordDetails["newPassword"]=passwordData.newPassword,
    $scope.empPasswordDetails["confirmPassword"]=passwordData.confirmPassword,
    $scope.empPasswordDetails["id"]=$rootScope.sellerUserId,
   // $scope.restaurantEmpDetails["sellerBranchId"]=baseURL.sellerBranchId,
   // $scope.restaurantEmpDetails["userStatus"]="ACTIVE",
   // $scope.restaurantEmpDetails["userRoleType"]="DELIVERY_USER",
   // $scope.restaurantEmpDetails["sellerUserType"]="SELLER_USER",
   // $scope.restaurantEmpDetails["userType"]="SELLERUSER",
   
  
    $scope.jsonfile = {
       "class":["sellerUser"],
       "rel": ["item"],
       "properties":$scope.empPasswordDetails
    };
      data=$scope.jsonfile;
      console.log(JSON.stringify($scope.jsonfile));
    processReqFactory.processReq(baseURL.IP+"/sellerUser/changePassword","POST",data,function(response){
      
      $scope.$broadcast('scroll.refreshComplete');
      $ionicLoading.hide();
      $scope.modal.hide();
      location.reload();
      $scope.popover.hide();
    },function(){
    // swal({   title: "ERROR!",   text: " USER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
      });
  }
}
function EmployeeCreationController($scope, $rootScope, baseURL, processReqFactory, $ionicLoading){
  $scope.employeeUser = function(restaurant) {
    
   $scope.restaurantEmpDetails = angular.copy(restaurant);
       
    $scope.restaurantEmpDetails["$siren4j.class"] = "com.meat.representation.siren.SellerUserRepresentation",
   // $scope.restaurantEmpDetails["sellerUserType"]="deliveryUser",
   $scope.restaurantEmpDetails["sellerBranchId"]=baseURL.sellerBranchId,
   $scope.restaurantEmpDetails["userStatus"]="ACTIVE",
   $scope.restaurantEmpDetails["userRoleType"]="DELIVERY_USER",
   $scope.restaurantEmpDetails["sellerUserType"]="SELLER_USER",
   // $scope.restaurantEmpDetails["userType"]="SELLERUSER",
   
  
    $scope.jsonfile = {
       "class":["sellerUser"],
       "rel": ["item"],
       "properties":$scope.restaurantEmpDetails
    };
      data=$scope.jsonfile;
      // console.log(JSON.stringify($scope.jsonfile));
      $ionicLoading.show({template: '<p class=""><ion-spinner icon="lines"/></p>'});
    processReqFactory.processReq(baseURL.IP+"/sellerUser/create","POST",data,function(){
      
      $scope.$broadcast('scroll.refreshComplete');
      $ionicLoading.hide();
      $scope.modal.hide();
      location.reload();
    },function(){
    // swal({   title: "ERROR!",   text: " USER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
      });
  };
}
function SellerItemListController($scope, $rootScope,baseURL,processReqFactory, $ionicPopup){
  $scope.sellerItemEdit=function(itemId,status){
    $scope.data1 ={
      "class": [
          "sellerItem"
      ],
      "rel": [
          "item"
      ],
      "properties":
      {
          "$siren4j.class": "com.meat.representation.siren.SellerItemRepresentation",
          "id": itemId
      }
    }
    // $scope.data1['id'] = itemId;
    // $scope.data1['id'] = itemId;
    // console.log(itemId)
    var myPopup = $ionicPopup.show({
      // template: '<ion-item><ion-select  ng-model="data1.status"><ion-option value="ACTIVE" checked="true">ACTIVE</ion-option><ion-option value="INACTIVE">INACTIVE</ion-option></ion-select></ion-item>',
      template: '<select class="form-control" ng-model="data1.properties.itemAvailableStatus"><option value="default">Select Status</option><option value="ACTIVE">ACTIVE</option><option value="INACTIVE">INACTIVE</option></select>',
      title: 'ITEM VIEW',
      scope: $scope,
      buttons: [
        { text: 'Cancel' },
        {
          text: '<b>Save</b>',
          type: 'button-positive',
          onTap: function(e) {
            // console.log(JSON.stringify($scope.data1));
            // return $scope.data1.status 

            processReqFactory.processReq(baseURL.IP+"/sellerItem/"+itemId+"/edit","POST",$scope.data1,function(data){
              location.reload();
            },function(){});
          }
        }
      ]
    });

    myPopup.then(function(res) {
      // console.log('Tapped!', res);
    });
  }
  // $scope.statusChange=function(status){
  //   console.log(status)
  // }
  // processReqFactory.processReq(baseURL.IP+"/sellerItem/sellerItemOnly/"+baseURL.sellerBranchId,"GET",'',function(data){
  //   $scope.SellerItemsData=data.entities;
  // },function(){});
}
angular
  .module('starter.controllers', ['ionic'])
  .controller('LoadingController',LoadingController)
  .controller('loginController',loginController)
  .controller('orderListController',orderListController)
  .controller('AccountController',AccountController)
  .controller('SingleAccountController',SingleAccountController)
  .controller('EmployeeCreationController',EmployeeCreationController)
  .controller('SellerItemListController',SellerItemListController)