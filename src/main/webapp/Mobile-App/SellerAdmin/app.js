// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
angular.module('NonVeg', ['ionic', 'starter.controllers','ngCordova'])

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);

      // Don't remove this line unless you know what you are doing. It stops the viewport
      // from snapping when text inputs are focused. Ionic handles this internally for
      // a much nicer keyboard experience.
      cordova.plugins.Keyboard.disableScroll(true);
    }

    if(window.StatusBar) {
      // StatusBar.styleDefault();
      StatusBar.backgroundColorByHexString("#EF4B4B");
    }
    // $ionicPlatform.ready(function() {
    // var push = new Ionic.Push({
    //   "debug": true
    // });

    // push.register(function(token) {
    //   console.log("Device token:",token.token);
    //   push.saveToken(token);  // persist the token in the Ionic Platform
    // });
  // });
  });
})
.config(function($stateProvider, $urlRouterProvider,$ionicConfigProvider) {
  $ionicConfigProvider.navBar.alignTitle('center');
    var baseURL="http://192.168.0.72:8082";
    $stateProvider
      .state('app', {
        url: '/app',
        templateUrl: baseURL+'/seller/welcomepage'
      })
      .state('login', {
        url: '/login',
        templateUrl: baseURL+'/seller/loginpage'
      })
      .state('start', {
        url: '/start',
        abstract: true,
        templateUrl: baseURL+'/seller/mainmenupage'
      })
      .state('start.home', {
        url: '/home',
        views: {
          'menuContent': {
            templateUrl: baseURL+'/seller/sellerBranch/'+localStorage.getItem("sellerBranchId")+'/sellerDashboard'
          }
        }
      })
      .state('start.orders', {
        url: '/orders',
        views: {
          'menuContent': {
            abstract: true,
            templateUrl: function(){
              // $ionicHistory.clearHistory();
              // $ionicHistory.clearCache();
              var date=new Date();
              var getDay=date.getDate();
              var getMonth=date.getMonth()+1;
              var getFullYear=date.getFullYear();
              var fullDate=getFullYear+"-"+getMonth+"-"+getDay;
              return baseURL+'/seller/sellerorders/branch/'+localStorage.getItem("sellerBranchId")+'/date/'+fullDate+'/status/PLACED'
            }
          }
        }
      })
      .state('start.orders.PLACED', {
        url: '/PLACED?:fullDate',
        cache: false,
        views: {
          'placedContent': {
            templateUrl: function($stateParams){
              // $ionicHistory.clearHistory();
              // $ionicHistory.clearCache();
              var fullDate = '';
              if(!$stateParams.fullDate){
                var date=new Date();
                var getDay=date.getDate();
                var getMonth=date.getMonth()+1;
                var getFullYear=date.getFullYear();
                fullDate=getFullYear+"-"+getMonth+"-"+getDay;
              }else{
                fullDate = $stateParams.fullDate;
              }
              // $scope.$broadcast('scroll.refreshComplete');

              return baseURL+'/seller/sellerorders/branch/'+localStorage.getItem("sellerBranchId")+'/date/'+fullDate+'/placedstatus/PLACED'
              // location.reload();
            }
          }
        }
      })
      .state('start.orders.CONFIRMED', {
        url: '/CONFIRMED?:fullDate',
        views: {
          'confirmContent': {
            templateUrl: function($stateParams){
              var fullDate;
              if(!$stateParams.fullDate){
                var date=new Date();
                var getDay=date.getDate();
                var getMonth=date.getMonth()+1;
                var getFullYear=date.getFullYear();
                fullDate=getFullYear+"-"+getMonth+"-"+getDay;
              }else{
                fullDate = $stateParams.fullDate;
              }
              // location.reload();
              return baseURL+'/seller/sellerorders/branch/'+localStorage.getItem("sellerBranchId")+'/date/'+fullDate+'/confirmedstatus/CONFIRMED'
            }
          }
        }
      })
      .state('start.orders.SHIPPED', {
        url: '/SHIPPED?:fullDate',
        views: {
          'shippedContent': {
            templateUrl: function($stateParams){
              var fullDate;
              if(!$stateParams.fullDate){
                var date=new Date();
                var getDay=date.getDate();
                var getMonth=date.getMonth()+1;
                var getFullYear=date.getFullYear();
                fullDate=getFullYear+"-"+getMonth+"-"+getDay;
              }else{
                fullDate = $stateParams.fullDate;
              }
              // location.reload();
              return baseURL+'/seller/sellerorders/branch/'+localStorage.getItem("sellerBranchId")+'/date/'+fullDate+'/shippedstatus/SHIPPED'
            }
          }
        }
      })
      .state('start.orders.DELIVERED', {
        url: '/DELIVERED?:fullDate',
        views: {
          'deliveredContent': {
            templateUrl: function($stateParams){
              var fullDate;
              if(!$stateParams.fullDate){
                var date=new Date();
                var getDay=date.getDate();
                var getMonth=date.getMonth()+1;
                var getFullYear=date.getFullYear();
                fullDate=getFullYear+"-"+getMonth+"-"+getDay;
              }else{
                fullDate = $stateParams.fullDate;
              }
              return baseURL+'/seller/sellerorders/branch/'+localStorage.getItem("sellerBranchId")+'/date/'+fullDate+'/deliveredstatus/DELIVERED'
            }
          }
        }
      })
      .state('start.payments', {
        url: '/payments',
        views: {
          'menuContent': {
            templateUrl: baseURL+'/seller/sellerpayments/'+localStorage.getItem("sellerBranchId")
            // templateUrl: 'templates/PaymentsView.html'
          }
        }
      })
      .state('start.returns', {
        url: '/returns',
        views: {
          'menuContent': {
            templateUrl: 'templates/ReturnsView.html'
          }
        }
      })
      .state('start.allItems', {
        url: '/allItems',
        views: {
          'menuContent': {
            templateUrl: baseURL+'/seller/selleritemslistpage/'+localStorage.getItem("sellerBranchId")
          }
        }
      })
      .state('start.profile', {
        url: '/profile',
        views: {
          'menuContent': {
            templateUrl: function(){
              if(localStorage.getItem("sellerBranchId")){
                return baseURL+'/seller/accountpage/'+localStorage.getItem("userId")
              }
            } 
          }
        }
      })
      .state('start.support', {
        url: '/support',
        views: {
          'menuContent': {
            templateUrl: 'templates/SupportView.html'
          }
        }
      })
      .state('start.settings', {
        url: '/settings',
        views: {
          'menuContent': {
            templateUrl: 'templates/SettingsView.html'
          }
        }
      })
      .state('start.queries', {
        url: '/queries',
        views: {
          'menuContent': {
            templateUrl: 'templates/QueriesView.html'
          }
        }
      })
    $urlRouterProvider.otherwise('/login');
});