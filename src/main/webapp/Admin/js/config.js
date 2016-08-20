/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
 // .state('start.profile', {
 //        url: '/profile',
 //        views: {
 //          'menuContent': {
 //            templateUrl: function(){
 //              if(localStorage.getItem("sellerBranchId")){
 //                return baseURL+'/seller/accountpage/'+localStorage.getItem("userId")
 //              }
 //            } 
 //          }
 //        }
 //      })
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider, KeepaliveProvider) {	
		// Configure Idle settings
		IdleProvider.idle(5); // in seconds
		IdleProvider.timeout(120); // in seconds
		$urlRouterProvider.otherwise("/dashboards/DashboardTemplate");
		$ocLazyLoadProvider.config({
				// Set to true if you want to see what and when is dynamically loaded
				debug: false
		});
		$stateProvider
				.state('dashboards', {
						abstract: true,
						url: "/dashboards",
						templateUrl: "views/common/content.html",
				})
				.state('dashboards.DashboardTemplate', {
						url: "/DashboardTemplate",
						templateUrl: "views/DashboardTemplate.html",
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'angles',
														files: ['js/plugins/chartJs/angles.js', 'js/plugins/chartJs/Chart.min.js']
												},
												{
														name: 'angular-peity',
														files: ['js/plugins/peity/jquery.peity.min.js', 'js/plugins/peity/angular-peity.js']
												}
										]);
								}
						}
				})
				.state('dashboards.QueriesTemplate',{
						url:"/QueriesTemplate",
						templateUrl:"views/QueriesTemplate.html",
						data:{ pageTitle: ' Queries View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
					})
				.state('dashboards.SingleQueriesTemplate',{
				url:"/Queries/:QueriesId",
				templateUrl: "views/SingleQueriesTemplate.html",
				data: { pageTitle: 'Queries View' },
				resolve: {
						loadPlugin: function ($ocLazyLoad) {
								return $ocLazyLoad.load([
										{
												serie: true,
												name: 'angular-flot',
												files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
										},
										{
												name: 'ui.checkbox',
												files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
											 
										},
										{
												name: 'datePicker',
												files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
										},
										{
												files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
										},
										{
												files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
										},
										{
												name: 'oitozero.ngSweetAlert',
												files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
										},
										{
												files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
										},
								]);
						}
				}
		})
				.state('ItemMaster', {
						abstract: true,
						url: "/ItemMaster",
						templateUrl: "views/common/content.html",
				})
				.state('ItemMaster.ItemImageCreationTemplate', {
						url: "/ItemImageCreationTemplate",
						templateUrl: "views/ItemImageCreationTemplate.html",
						data: { pageTitle: 'Items List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}

										]);
								}
						}
				})
				.state('ItemMaster.ItemsTemplate', {
						url: "/ItemsTemplate",
						templateUrl: "views/ItemsTemplate.html",
						data: { pageTitle: 'Items List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												// {
												// 		serie: true,
												// 		files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												// },
												// {
												// 		serie: true,
												// 		files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												// },
												// {
												// 		name: 'datatables',
												// 		files: ['js/plugins/dataTables/angular-datatables.min.js']
												// },
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.ItemSingleTemplate', {
						url: "/Item/:itemId/:itemName",
						templateUrl: "views/SingleItemTemplate.html",
						data: { pageTitle: 'SingleItemList' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												// },
												// {
												// 	serie: true,
												// 	files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												// },
												// {
												// 	serie: true,
												// 	files: ['js/plugins/dataTables/dataTables.bootstrap.js']
												// },
												// {
												// 		name: 'datatables',
												// 		files: ['js/plugins/dataTables/angular-datatables.min.js']
												// },
												// {
												// files: ['js/plugins/footable/footable.all.min.js', 'css/plugins/footable/footable.core.css']
												// },
												// {
												// 		name: 'ui.footable',
												// 		files: ['js/plugins/footable/angular-footable.js']
												},

										]);
								}
						}
				})
				.state('ItemMaster.CategoryItemsTemplate', {
						url: "/CategoryItems/:categoryId/:CName",
						templateUrl: "views/CategoryItemsTemplate.html",
						data: { pageTitle: 'Category Items List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.BranchItemsTemplate', {
						url: "/BranchItems/:branchId/:RBname",
						templateUrl: "views/BranchItemsTemplate.html",
						data: { pageTitle: 'Branch Items List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.ItemCreateView', {
						url: "/ItemCreateView",
						templateUrl: "views/ItemCreationView.html",
						controller: ItemCreationCtrl,
						data: { pageTitle: 'Item Creation List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.CategoryCreateView', {
						url: "/CategoryCreateView",
						templateUrl: "views/CategoryCreationTemplate.html",
						controller: CategoryCreationController,
						data: { pageTitle: 'Category Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.CategoryTemplate', {
						url: "/CategoryTemplate",
						templateUrl: "views/CategoryTemplate.html",
						data: { pageTitle: 'Category List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.CategorySingleTemplate', {
						url: "/Category/:categoryName/:categoryId",
						templateUrl: "views/SingleCategoryTemplate.html",
						data: { pageTitle: 'Single Category View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})

				.state('ItemMaster.SubCategoryCreateView', {
						url: "/SubCategoryCreateView",
						templateUrl: "views/SubCategoryCreationView.html",
						controller: SubCategoryCreationController,
						data: { pageTitle: 'SubCategory Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				// .state('ItemMaster.SubCategoryCategoryView',{
				// 		url: "/SubCategoryCategoryView/:categoryId",
				// 		templateUrl: "views/SubCategoryCreationView.html",
				// 		controller: SubCategoryCreationController,
				// 		data: { pageTitle: 'SubCategory Creation' },
				// 		resolve: {
				// 				loadPlugin: function ($ocLazyLoad) {
				// 						return $ocLazyLoad.load([
				// 								{
				// 									 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
				// 								}
				// 						]);
				// 				}
				// 		}
				// })
				.state('ItemMaster.SubCategoryTemplate', {
						url: "/SubCategoryTemplate",
						templateUrl: "views/SubCategoryTemplate.html",
						data: { pageTitle: 'SubCategory List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.SubCategorySingleTemplate', {
						url: "/subCategory/:subCategoryName/:subCategoryId",
						templateUrl: "views/SingleSubCategoryTemplate.html",
						data: { pageTitle: 'Single SubCategory View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Tags', {
						abstract: true,
						url: "/Tags",
						templateUrl: "views/common/content.html",
				})
				
				.state('Tags.TagsCreateView',{
						url: "/TagCreateView",
						templateUrl: "views/TagCreationView.html",
						controller: TagCreationController,
						data: { pageTitle: 'Tag Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Tags.TagsTemplate',{
						url:"/TagsTemplate",
						templateUrl:"views/TagsTemplate.html",
						data:{ pageTitle: 'Tags Template View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Tags.SingleTagTemplate',{
						url:"/Tag/:tagName/:tagId",
						templateUrl:"views/SingleTagTemplate.html",
						data:{ pageTitle: 'Single Tag Template' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Tags.TagTypeCreateView',{
						url: "/TagTypeCreateView",
						templateUrl: "views/TagTypeCreationView.html",
						controller: TagTypeCreationController,
						data: { pageTitle: 'TagType Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Tags.TagTypeTemplate',{
						url:"/TagTypeTemplate",
						templateUrl:"views/TagTypeTemplate.html",
						data:{ pageTitle: 'TagType Template View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Tags.SingleTagTypeTemplate',{
						url:"/TagType/:tagTypeName/:tagTypeId",
						templateUrl:"views/SingleTagTypeTemplate.html",
						data:{ pageTitle: 'Single TagType Template' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Tags.AttributesCreateView',{
						url: "/AttributesCreateView",
						templateUrl: "views/AttributesCreationView.html",
						controller: AttributesCreateController,
						data: { pageTitle: 'AttributesCreationView' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Tags.AttributesTemplate',{
				url:"/AttributesTemplate",
				templateUrl:"views/AttributesTemplate.html",
				data:{ pageTitle: ' Attributes View' },
				resolve:{
						loadPlugin: function($ocLazyLoad) {
								return $ocLazyLoad.load([
										{
												serie: true,
												files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
										},
										{
												serie: true,
												files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
										},
										{
												name: 'datatables',
												files: ['js/plugins/dataTables/angular-datatables.min.js']
										},
										{
												files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
										}
								]);
						}
				}
			})
					.state('Tags.SingleAttributesTemplate',{
						url:"/Attributes/:AttributesName/:AttributesId",
						templateUrl: "views/SingleAttributesTemplate.html",
						data: { pageTitle: 'Attributes View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Tags.CutTypeTemplate', {
						url: "/CutTypeTemplate",
						templateUrl: "views/CutTypeTemplate.html",
						data: { pageTitle: 'CutType List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Tags.CutTypeCreateView', {
						url: "/CutTypeCreateView",
						templateUrl: "views/CutTypeCreationTemplate.html",
						controller: "CutTypeCreationController",
						data: { pageTitle: 'CutType Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
									return $ocLazyLoad.load([
								{
									files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
								},
								{
									files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
								},
								{
									name: 'oitozero.ngSweetAlert',
									files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
								},
								{
									files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
								}
							]);
						}
						}
				})
				.state('Tags.SingleCutTypeTemplate',{
						url:"/cutType/:cutTypeName/:cutTypeId",
						templateUrl: "views/SingleCutTypeTemplate.html",
						data: { pageTitle: 'Cut Type View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Sellers', {
						abstract: true,
						url: "/Sellers",
						templateUrl: "views/common/content.html",
				})
				.state('Sellers.SellersCreateView',{
						url: "/SellersCreateView",
						templateUrl: "views/SellersCreateView.html",
						controller: SellersCreationController,
						data: { pageTitle: 'Restaurant Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SellersBranchCreateView',{
						url: "/SellersBranchCreateView",
						templateUrl: "views/SellersBranchCreateView.html",
						controller: SellersBranchCreationController,
						data: { pageTitle: 'SellerBranch Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SingleSellersBranchCreationTemplate',{
						url: "/SingleSellersBranchCreationTemplate/:sellerId",
						templateUrl: "views/SingleSellerBranchCreationTemplate.html",
						controller: SingleSellerBranchCreationController,
						data: { pageTitle: 'SingleSeller Branch Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				// .state('supplier', {
				// 		abstract: true,
				// 		url: "/supplier",
				// 		templateUrl: "views/common/content.html",
				// })
				.state('Sellers.SellersTemplate',{
						url:"/SellersTemplate",
						templateUrl:"views/SellersTemplate.html",
						data:{ pageTitle: 'Sellers Template View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SellerBranchesTemplate',{
						url:"/SellerBranchesTemplate",
						templateUrl:"views/SellerBranchesTemplate.html",
						data:{ pageTitle: 'Sellers Template View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SellerBranchSingleTemplate', {
						url: "/SellerBranchSingleTemplate/:sellerBranchId/:branchName",
						templateUrl: "views/SellerBranchSingleTemplate.html",
						data: { pageTitle: 'SingleBranchList' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js']
												},
												// {
												// 		serie: true,
												// 		files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												// },
												// {
												// 		serie: true,
												// 		files: ["js/plugins/footable/footable.all.min.js"]
												// },
												// {
												// 		name: 'datatables',
												// 		files: ['js/plugins/dataTables/angular-datatables.min.js']
												// },
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},

										]);
								}
						}
				})
				.state('Sellers.SingleSellerTemplate', {
						url: "/seller/:sellerName/:sellerId",
						templateUrl: "views/SingleSellerTemplate.html",
						data: { pageTitle: 'Single Seller View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('ItemMaster.SellersItemsTemplate', {
						url: "/SellersItemsTemplate",
						templateUrl: "views/SellersItemsTemplate.html",
						data: { pageTitle: 'SellersItems List' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														name: 'angular-peity',
														files: ['js/plugins/peity/jquery.peity.min.js', 'js/plugins/peity/angular-peity.js']
												},
												{
														files: ['css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files: ['js/plugins/footable/footable.all.min.js', 'css/plugins/footable/footable.core.css']
												},
												{
														name: 'ui.footable',
														files: ['js/plugins/footable/angular-footable.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SellerBranchItems', {
						url: "/SellerBranchItems/:branchId/:restName/:restId",
						templateUrl: "views/SellerBranchItemsTemplate.html",
						controller: SellerBranchtItemsListController,
						data: { pageTitle: 'Seller Branch Items View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SingleSellerBranchTemplate',{
						url: "/SellerBranch/:branchId",
						templateUrl: "views/SingleSellerBranchTemplate.html",
						data: { pageTitle: 'Single Seller Branch View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Sellers.SellerBranchUserCreationTemplate',{
						url: "/SellerBranchUserCreationTemplate/:sellerBranchId",
						templateUrl: "views/SellerBranchUserCreationTemplate.html",
						controller: SingleSellerBranchCreationController,
						data: { pageTitle: 'SingleSeller Branch Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('ItemMaster.SellerItemCreationTemplate',{
						url:"/SellerItemCreationView/:itemId/:itemName",
						templateUrl: "views/SellerItemCreationTemplate.html",
						controller: SellerItemCreationController,
						data: { pageTitle: 'SellerItem Creation'},
						resolve:{
								loadPlugin:function($ocLazyLoad){
										return $ocLazyLoad.load([
												{
														files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('ItemMaster.SingleSellerItemTemplate', {
						url: "/SingleSellerItems/:sellerId",
						templateUrl: "views/SingleSellerItemTemplate.html",
						data: { pageTitle: 'Single Seller Items View' },
						resolve: {
							loadPlugin: function ($ocLazyLoad) {
									return $ocLazyLoad.load([
									{
											files: ["js/jquery/jquery.validate.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
									},
									{
											files: ['css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css']
									},
									// {
									// 		serie: true,
									// 		files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
									// },
									{
											serie: true,
											files: ["js/plugins/footable/footable.all.min.js"]
									},
									// {
									// 		name: 'datatables',
									// 		files: ['js/plugins/dataTables/angular-datatables.min.js']
									// },
									{
											name: 'ui.select',
											files: ['js/plugins/ui-select/select.min.js', 'css/plugins/ui-select/select.min.css']
									},
									{
											files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
									},
									{
											name: 'oitozero.ngSweetAlert',
											files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
									},
									{
											files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
									},
								]);
							}
						}
				})
				.state('Sellers.SellerBranchEmployeeCreationView',{
						url: "/SellerBranchEmployeeCreationView",
						templateUrl: "views/SellerBranchEmployeeCreationView.html",
						controller: SellerBranchEmployeeCreationController,
						data: { pageTitle: 'SellerBranch Employee Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SellerBranchEmployeesListTemplate',{
						url:"/SellerBranchEmployeesListTemplate",
						templateUrl:"views/SellerBranchEmployeesListTemplate.html",
						data:{ pageTitle: 'SellerBranch Employees List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SingleSellerBranchEmployeeTemplate', {
						url: "/SellerBranchEmployee/:userName/:userId",
						templateUrl: "views/SingleSellerBranchEmployeeTemplate.html",
						data: { pageTitle: 'Single SellerBranch Employee View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Sellers.SellerBranchTimings',{
						url:"/SellerBranchTimings",
						templateUrl:"views/SellerBranchTimingsTemplate.html",
						data:{ pageTitle: 'SellerBranch Timing View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SellerBranchTimingCreationView',{
						url: "/SellerBranchTimingCreationView",
						templateUrl: "views/SellerBranchTimingCreationView.html",
						controller: SellerBranchTimingCreationController,
						data: { pageTitle: 'SellerBranch Timing Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Sellers.SingleSellerBranchTimingTemplate', {
						url: "/SellerBranchTiming/:sellerName/:sellerId",
						templateUrl: "views/SingleSellerBranchTimingTemplate.html",
						data: { pageTitle: 'Single SellerBranch Timing View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Offers', {
						abstract: true,
						url: "/Offers",
						templateUrl: "views/common/content.html",
				})
				.state('Offers.OffersZone',{
						url:"/OffersZone",
						templateUrl:"views/OffersZoneTemplate.html",
						data:{ pageTitle: 'Offers Zone View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.PackageTemplate',{
						url:"/PackageTemplate",
						templateUrl:"views/PackageTemplate.html",
						data:{ pageTitle: 'Package List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.PackageCreateView',{
						url: "/PackageCreateView",
						templateUrl: "views/PackageCreationView.html",
						controller: PackageCreationController,
						data: { pageTitle: 'Package Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.PackageSingleTemplate', {
						url: "/Package/:packageName/:packageId",
						templateUrl: "views/SinglePackageTemplate.html",
						data: { pageTitle: 'Single Package View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
										]);
								}
						}
				})
				.state('Offers.PlansTemplate',{
						url:"/PlansTemplate",
						templateUrl:"views/PlansTemplate.html",
						data:{ pageTitle: 'Plans List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.OffersTemplate',{
						url:"/OffersTemplate",
						templateUrl:"views/OffersTemplate.html",
						data:{ pageTitle: 'Offers List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.OffersCreateView',{
						url: "/OffersCreateView",
						templateUrl: "views/OffersCreationView.html",
						controller: OffersCreationController,
						data: { pageTitle: 'Offers Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/select2weetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.OfferSingleTemplate',{
						url:'/Offers/:offerName/:offerId',
						templateUrl: "views/SingleOfferTemplate.html",
						data: { pageTitle: 'Offer View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
										]);
								}
						}
				})
				.state('Offers.ComboPackTemplate',{
						url:"/ComboPackTemplate",
						templateUrl:"views/ComboPackTemplate.html",
						data:{ pageTitle: 'ComboPack List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
		.state('Offers.ComboPackCreateView',{
						url: "/ComboPackCreateView",
						templateUrl: "views/ComboPackCreationView.html",
						controller: ComboPackCreationController,
						data: { pageTitle: 'ComboPack Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.ComboPackSingleTemplate', {
						url: "/ComboPack/:packName/:packId",
						templateUrl: "views/SingleComboPackTemplate.html",
						data: { pageTitle: 'Single ComboPack View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.CouponTemplate',{
						url:"/CouponTemplate",
						templateUrl:"views/CouponTemplate.html",
						data:{ pageTitle: 'Coupon List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.CouponCreateView',{
						url: "/CouponCreateView",
						templateUrl: "views/CouponCreationView.html",
						controller: CouponCreationController,
						data: { pageTitle: 'Coupon Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				//Companies
				.state('Offers.CompanyTemplate',{
						url:"/CompanyTemplate",
						templateUrl:"views/CompanyTemplate.html",
						data:{ pageTitle: 'Company List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.companyCreateView',{
						url: "/CompanyCreateView",
						templateUrl: "views/CompanyCreationView.html",
						controller: CompanyCreationController,
						data: { pageTitle: 'Company Creation View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.companyBranchCreateView',{
						url: "/CompanyBranchCreateView",
						templateUrl: "views/CompanyBranchCreationView.html",
						controller: CompanyBranchCreationController,
						data: { pageTitle: 'Company Branch Creation View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.CompanySingleTemplate', {
						url: "/Company/:companyName/:companyId",
						templateUrl: "views/SingleCompanyTemplate.html",
						data: { pageTitle: 'Single Company View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.CompanyEmployeeTemplate',{
						url:"/CompanyEmployeeTemplate",
						templateUrl:"views/CompanyEmployeeTemplate.html",
						data:{ pageTitle: 'Company Employee View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.companyEmployeeCreateView',{
						url: "/CompanyEmployeeCreateView",
						templateUrl: "views/CompanyEmployeeCreationView.html",
						controller: CompanyEmployeeCreationController,
						data: { pageTitle: 'Company Employee Creation View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.CompanySingleEmployee',{
						url:"/CompanyEmployee/:userName/:userId",
						templateUrl: "views/SingleCompanyEmployeeTemplate.html",
						data: { pageTitle: 'Company Employee View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('dashboards.CompanyAdminTemplate',{
						url:"/CompanyAdminTemplate",
						templateUrl:"views/CompanyAdminTemplate.html",
						data:{ pageTitle: 'Company Admin View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('dashboards.companyAdminCreateView',{
						url: "/CompanyAdminCreateView",
						templateUrl: "views/CompanyAdminCreationView.html",
						controller: CompanyAdminCreationController,
						data: { pageTitle: 'Company Admin Creation View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files: ['css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('dashboards.CompanySingleAdminTemplate',{
						url:"/CompanyAdmin/:userName/:userId/:branchId",
						templateUrl: "views/SingleCompanyAdminTemplate.html",
						data: { pageTitle: 'Company Admin View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('dashboards.CompanyTimings',{
						url:"/CompanyTimings",
						templateUrl:"views/CompanyTimingsTemplate.html",
						data:{ pageTitle: 'Company Timings View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('dashboards.companyTimingCreateView',{
						url: "/CompanyTimingCreateView",
						templateUrl: "views/CompanyTimingCreationView.html",
						controller: CompanyTimingCreationController,
						data: { pageTitle: 'Company Timing Creation View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files: ['css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('dashboards.CompanySingleTimingsTemplate',{
						url:"/CompanyTimings/:branchTimingsId/:TimingsId",
						templateUrl: "views/SingleCompanyTimingsTemplate.html",
						data: { pageTitle: 'Company Timing View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Meat', {
						abstract: true,
						url: "/Meat",
						templateUrl: "views/common/content.html",
				})
				.state('Meat.MeatTemplate',{
						url:"/MeatTemplate",
						templateUrl:"views/MeatTemplate.html",
						data:{ pageTitle: 'Meat View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Meat.MeatCreateView',{
						url:"/MeatCreationTemplate",
						templateUrl:"views/MeatCreationTemplate.html",
						controller: meatCreationController,
						data:{ pageTitle: 'Meat Creation View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Meat.MeatSingleTemplate',{
						url:"/Meat/:meatName/:meatId",
						templateUrl: "views/SingleMeatTemplate.html",
						data: { pageTitle: 'Meat View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Meat.MeatAdminTemplate',{
						url:"/MeatAdminTemplate",
						templateUrl:"views/MeatAdminTemplate.html",
						data:{ pageTitle: 'Meat Admin View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Meat.MeatAdminCreateView',{
						url:"/MeatAdminCreationTemplate",
						templateUrl:"views/MeatAdminCreationTemplate.html",
						controller: meatAdminCreationController,
						data:{ pageTitle: 'Meat Admin Creation View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
												{
														files: ['css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
										]);
								}
						}
				})
				.state('Meat.MeatEmployeeTemplate',{
						url:"/MeatEmployeeTemplate",
						templateUrl:"views/MeatEmployeeTemplate.html",
						data:{ pageTitle: 'Meat Employees View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Meat.MeatEmployeeCreateView',{
						url:"/MeatEmployeeCreationTemplate",
						templateUrl:"views/MeatEmployeeCreationTemplate.html",
						controller: meatEmployeeCreationController,
						data:{ pageTitle: 'Meat Employee Creation View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												},
												{
														files: ['css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												}
										]);
								}
						}
				})
				.state('Meat.MeatEmployeeSingleTemplate',{
						url:"/MeatEmployee/:employeeName/:employeeId",
						templateUrl: "views/SingleMeatEmployeeTemplate.html",
						data: { pageTitle: 'Meat Employee View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Timings', {
						abstract: true,
						url: "/Timings",
						templateUrl: "views/common/content.html",
				})
				.state('Timings.TimingTemplate',{
						url:"/TimingTemplate",
						templateUrl:"views/TimingsTemplate.html",
						data:{ pageTitle: ' Timings View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Timings.TimingCreateView',{
						url: "/TimingCreateView",
						templateUrl: "views/TimingCreationView.html",
						controller: TimingCreateViewController,
						data: { pageTitle: 'Timing Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Timings.TimingsSingleTemplate',{
						url:"/Timings/:TimingsName/:TimingsId",
						templateUrl: "views/SingleTimingsTemplate.html",
						data: { pageTitle: 'Timings View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','js/plugins/datapicker/angular-datepicker.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Orders', {
						abstract: true,
						url: "/Orders",
						templateUrl: "views/common/content.html",
				})
				.state('Orders.OrdersTemplate',{
						url:"/orders",
						templateUrl:"views/OrdersListTemplate.html",
						data:{ pageTitle: ' Orders View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['../common/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['../common/plugins/dataTables/dataTables.bootstrap.js','../common/plugins/dataTables/dataTables.colReorder.js','../common/plugins/dataTables/all.min.js','../common/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['../common/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["../common/plugins/select2/select2.min.css","../common/plugins/select2/select2.full.min.js"]
												},
												{
														files: ['../common/plugins/footable/footable.all.min.js', 'css/plugins/footable/footable.core.css']
												},
												{
														name: 'ui.footable',
														files: ['../common/plugins/footable/angular-footable.js']
												},
												{
														serie: true,
														files: ['../common/plugins/moment/moment.min.js', '../common/plugins/daterangepicker/daterangepicker.js', 'css/plugins/daterangepicker/daterangepicker-bs3.css']
												},
												{
														name: 'daterangepicker',
														files: ['../common/plugins/daterangepicker/angular-daterangepicker.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','../common/plugins/datapicker/angular-datepicker.js']
												}
										]);
								}
						}
				})
				.state('Orders.InvoiceTemplate',{
						url:"/Invoice",
						templateUrl:"views/InvoiceListTemplate.html",
						data:{ pageTitle: ' Invoice View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['../common/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['../common/plugins/dataTables/dataTables.bootstrap.js','../common/plugins/dataTables/dataTables.colReorder.js','../common/plugins/dataTables/all.min.js','../common/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['../common/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["../common/plugins/select2/select2.min.css","../common/plugins/select2/select2.full.min.js"]
												},
												{
														files: ['../common/plugins/footable/footable.all.min.js', 'css/plugins/footable/footable.core.css']
												},
												{
														name: 'ui.footable',
														files: ['../common/plugins/footable/angular-footable.js']
												},
												{
														serie: true,
														files: ['../common/plugins/moment/moment.min.js', '../common/plugins/daterangepicker/daterangepicker.js', 'css/plugins/daterangepicker/daterangepicker-bs3.css']
												},
												{
														name: 'daterangepicker',
														files: ['../common/plugins/daterangepicker/angular-daterangepicker.js']
												},
												{
														name: 'datePicker',
														files: ['css/plugins/datapicker/angular-datapicker.css','../common/plugins/datapicker/angular-datepicker.js']
												}
										]);
								}
						}
				})
				.state('Settings', {
						abstract: true,
						url: "/Settings",
						templateUrl: "views/common/content.html",
				})
				.state('Settings.CriteriaTemplate',{
						url:"/CriteriaTemplate",
						templateUrl:"views/CriteriaTemplate.html",
						data:{ pageTitle: ' Criteria View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Settings.CriteriaCreateView',{
						url: "/CriteriaCreateView",
						templateUrl: "views/CriteriaCreationView.html",
						controller: CriteriaCreateController,
						data: { pageTitle: 'CriteriaCreationView' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Settings.CriteriaSingleTemplate',{
						url:'/Criteria/:criteriaName/:criteriaId',
						templateUrl: "views/SingleCriteriaTemplate.html",
						data: { pageTitle: 'Criteria View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Settings.ZonesTemplate',{
						url:"/ZonesTemplate",
						templateUrl:"views/ZonesTemplate.html",
						data:{ pageTitle: ' Zones View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Settings.ZoneCreateView',{
						url: "/ZoneCreateView",
						templateUrl: "views/ZoneCreationView.html",
						controller: ZonesCreateViewController,
						data: { pageTitle: 'Zones Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
					})
				.state('Settings.ZoneAreaCreateView',{
						url: "/ZoneAreaCreateView",
						templateUrl: "views/ZoneAreaCreationView.html",
						controller: ZoneAreaCreateViewController,
						data: { pageTitle: 'ZoneArea Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
					})
					.state('Settings.ZoneCityCreationView',{
						url: "/ZoneCityCreationView",
						templateUrl: "views/ZoneCityCreationView.html",
						controller: ZoneCityCreationViewController,
						data: { pageTitle: 'ZoneCity Creation' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Settings.ZoneSingleTemplate',{
						url:'/zoneCity/:cityName/:zoneCityId',
						templateUrl: "views/SingleZoneTemplate.html",
						data: { pageTitle: 'Zone View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})

				.state('Offers.TaxesCreateView',{
						url:"/TaxesCreateView",
						templateUrl:"views/TaxesCreationView.html",
						controller: TaxesCreationController,
						data:{ pageTitle: ' Taxes Creation View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
													 files: ['css/plugins/steps/jquery.steps.css','js/plugins/bootstrap-wizard/jquery.bootstrap.wizard.js','js/plugins/bootstrap-wizard/form-wizard.js',"js/jquery/jquery.validate.js","js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js",'css/plugins/iCheck/custom.css','js/plugins/iCheck/icheck.min.js']
												},
												{
														files: ['css/plugins/clockpicker/clockpicker.css', 'js/plugins/clockpicker/clockpicker.js']
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				.state('Offers.TaxesListTemplate',{
						url:"/TaxesTemplate",
						templateUrl:"views/TaxesListTemplate.html",
						data:{ pageTitle: 'Taxes List View' },
						resolve:{
								loadPlugin: function($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														files: ['js/plugins/dataTables/jquery.dataTables.js','css/plugins/dataTables/dataTables.bootstrap.css']
												},
												{
														serie: true,
														files: ['js/plugins/dataTables/dataTables.bootstrap.js','js/plugins/dataTables/dataTables.colReorder.js','js/plugins/dataTables/all.min.js','js/plugins/dataTables/dataTables.scroller.js']
												},
												{
														name: 'datatables',
														files: ['js/plugins/dataTables/angular-datatables.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				
				.state('Offers.TaxSingleTemplate',{
						url:'/Tax/:taxName/:taxId',
						templateUrl: "views/SingleTaxTemplate.html",
						data: { pageTitle: 'Tax View' },
						resolve: {
								loadPlugin: function ($ocLazyLoad) {
										return $ocLazyLoad.load([
												{
														serie: true,
														name: 'angular-flot',
														files: [ 'js/plugins/flot/jquery.flot.js', 'js/plugins/flot/jquery.flot.time.js', 'js/plugins/flot/jquery.flot.tooltip.min.js', 'js/plugins/flot/jquery.flot.spline.js', 'js/plugins/flot/jquery.flot.resize.js', 'js/plugins/flot/jquery.flot.pie.js', 'js/plugins/flot/curvedLines.js', 'js/plugins/flot/angular-flot.js', ]
												},
												{
														name: 'ui.checkbox',
														files: ['js/bootstrap/angular-bootstrap-checkbox.js','js/plugins/blueimp/jquery.blueimp-gallery.min.js','css/plugins/blueimp/css/blueimp-gallery.min.css']
													 
												},
												{
														files: ['js/plugins/sweetalert/sweetalert.min.js', 'css/plugins/sweetalert/sweetalert.css']
												},
												{
														name: 'oitozero.ngSweetAlert',
														files: ['js/plugins/sweetalert/angular-sweetalert.min.js']
												},
												{
														files:["js/plugins/select2/select2.min.css","js/plugins/select2/select2.full.min.js"]
												}
										]);
								}
						}
				})
				// $stateProvider
				// .state('login', {
				// 		url: "/login",
				// 		templateUrl: "views/login.html",
				// 		data: { pageTitle: 'Login', specialClass: 'gray-bg' }
				// })
				// .state('login_two_columns', {
				// 		url: "/login_two_columns",
				// 		templateUrl: "views/login_two_columns.html",
				// 		data: { pageTitle: 'Login two columns', specialClass: 'gray-bg' }
				// })
				// .state('register', {
				// 		url: "/register",
				// 		templateUrl: "views/register.html",
				// 		data: { pageTitle: 'Register', specialClass: 'gray-bg' }
				// })
				// .state('lockscreen', {
				// 		url: "/lockscreen",
				// 		templateUrl: "views/lockscreen.html",
				// 		data: { pageTitle: 'Lockscreen', specialClass: 'gray-bg' }
				// })
				// .state('forgot_password', {
				// 		url: "/forgot_password",
				// 		templateUrl: "views/forgot_password.html",
				// 		data: { pageTitle: 'Forgot password', specialClass: 'gray-bg' }
				// });

}
angular
		.module('AdminTerminal')
		.config(config)
		.run(function($rootScope, $state) {
				$rootScope.$state = $state;
		});

