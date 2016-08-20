/**
 * INSPINIA - Responsive Admin Theme
 *
 * Inspinia theme use AngularUI Router to manage routing and views
 * Each view are defined as state.
 * Initial there are written state for all view in theme.
 *
 */
function config($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, IdleProvider, KeepaliveProvider) {
    var plugin_start="/Restaurants/Dashboard/";
    // Configure Idle settings
    IdleProvider.idle(5); // in seconds
    IdleProvider.timeout(120); // in seconds

    $urlRouterProvider.otherwise("/dashboards/orders");

    $ocLazyLoadProvider.config({
        // Set to true if you want to see what and when is dynamically loaded
        debug: false
    });

    $stateProvider

        .state('dashboards', {
            abstract: true,
            url: "/dashboards",
            templateUrl: plugin_start+"views/common/content_top_navigation.html",
        })
        .state('dashboards.orders', {
            url: "/orders",
            templateUrl: plugin_start+"views/Orders.html",
            data: { pageTitle: 'ORDERS' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                    {
                        files:[plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js',plugin_start+'js/plugins/masonry/masonry.pkgd.min.js']
                    },
                    {
                            name: 'wu.masonry',
                            files: [plugin_start+'js/plugins/masonry/angular-masonry.min.js']
                    },
                        {
                            name: 'datePicker',
                            files: [plugin_start+'css/plugins/datapicker/angular-datapicker.css',plugin_start+'js/plugins/datapicker/angular-datepicker.js']
                        },
                        {
                            name: 'daterangepicker',
                            files: [plugin_start+'js/plugins/daterangepicker/angular-daterangepicker.js']
                        },{
                            files: [plugin_start+'css/plugins/ionRangeSlider/ion.rangeSlider.css',plugin_start+'css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css',plugin_start+'js/plugins/ionRangeSlider/ion.rangeSlider.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            name: 'localytics.directives',
                            files: [plugin_start+'css/plugins/chosen/chosen.css',plugin_start+'js/plugins/chosen/chosen.jquery.js',plugin_start+'js/plugins/chosen/chosen.js']
                        },
                        {
                            name: 'nouislider',
                            files: [plugin_start+'css/plugins/nouslider/jquery.nouislider.css',plugin_start+'js/plugins/nouslider/jquery.nouislider.min.js',plugin_start+'js/plugins/nouslider/angular-nouislider.js']
                        },
                        {
                            files:[plugin_start+"js/plugins/select2/select2.min.css",plugin_start+"js/plugins/select2/select2.full.min.js"]
                        }
                    ]);
                }
            }
        })
        .state('dashboards.sample', {
            url: "/sample",
            templateUrl: plugin_start+"views/sample.html",
            data: { pageTitle: 'ORDERS' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                    {
                        files:[plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js',plugin_start+'js/plugins/masonry/masonry.pkgd.min.js']
                    },
                    {
                            name: 'wu.masonry',
                            files: [plugin_start+'js/plugins/masonry/angular-masonry.min.js']
                    }
                    ]);
                }
            }
        })
        .state('dashboards.confirmedOrders', {
            url: "/confirmedOrders",
            templateUrl: plugin_start+"views/confirmedOrders.html",
            data: { pageTitle: 'Orders View' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                    {
                        files:[plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                    }
                    ]);
                }
            }
        })
        .state('dashboards.deliveredOrders', {
            url: "/deliveredOrders",
            templateUrl: plugin_start+"views/deliveredOrders.html",
            data: { pageTitle: 'Delivered Orders View' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        },
                        {
                            files: [plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/dataTables/jquery.dataTables.js',plugin_start+'css/plugins/dataTables/dataTables.bootstrap.css']
                        },
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/dataTables/dataTables.bootstrap.js']
                        },
                        {
                            name: 'datatables',
                            files: [plugin_start+'js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            files: [plugin_start+'js/plugins/footable/footable.all.min.js', plugin_start+'css/plugins/footable/footable.core.css']
                        },
                        {
                            name: 'ui.footable',
                            files: [plugin_start+'js/plugins/footable/angular-footable.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards.cancelledOrders', {
            url: "/cancelledOrders",
            templateUrl: plugin_start+"views/cancelledOrders.html",
            data: { pageTitle: 'Orders View' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                    {
                        files:[plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                    }
                    ]);
                }
            }
        })
        .state('dashboards.file_upload', {/*can remove this*/
            url: "/fileUpload",
            templateUrl: plugin_start+"views/upload.html",
            data: { pageTitle: 'fileUpload' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                    {
                        files:[plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                    }
                    ]);
                }
            }
        })/*can remove this*/
        .state('dashboards.items', {
            url: "/items",
            templateUrl: plugin_start+"views/itemsList.html",
            data: { pageTitle: 'ITEMS' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/dataTables/jquery.dataTables.js',plugin_start+'css/plugins/dataTables/dataTables.bootstrap.css']
                        },
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/dataTables/dataTables.bootstrap.js']
                        },
                        {
                            name: 'datatables',
                            files: [plugin_start+'js/plugins/dataTables/angular-datatables.min.js']
                        },
                        {
                            files: [plugin_start+'js/plugins/footable/footable.all.min.js', plugin_start+'css/plugins/footable/footable.core.css']
                        },
                        {
                            name: 'ui.footable',
                            files: [plugin_start+'js/plugins/footable/angular-footable.js']
                        },{
                            name: 'ui.knob',
                            files: [plugin_start+'js/plugins/jsKnob/jquery.knob.js',plugin_start+'js/plugins/jsKnob/angular-knob.js']
                        },
                        {
                            files: [plugin_start+'css/plugins/ionRangeSlider/ion.rangeSlider.css',plugin_start+'css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css',plugin_start+'js/plugins/ionRangeSlider/ion.rangeSlider.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            name: 'localytics.directives',
                            files: [plugin_start+'css/plugins/chosen/chosen.css',plugin_start+'js/plugins/chosen/chosen.jquery.js',plugin_start+'js/plugins/chosen/chosen.js']
                        },
                        {
                            name: 'nouislider',
                            files: [plugin_start+'css/plugins/nouslider/jquery.nouislider.css',plugin_start+'js/plugins/nouslider/jquery.nouislider.min.js',plugin_start+'js/plugins/nouslider/angular-nouislider.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards.dashboard_1', {
            url: "/dashboard_1",
            templateUrl: plugin_start+"views/dashboard_1.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {

                            serie: true,
                            name: 'angular-flot',
                            files: [ plugin_start+'js/plugins/flot/jquery.flot.js', plugin_start+'js/plugins/flot/jquery.flot.time.js', plugin_start+'js/plugins/flot/jquery.flot.tooltip.min.js', plugin_start+'js/plugins/flot/jquery.flot.spline.js', plugin_start+'js/plugins/flot/jquery.flot.resize.js', plugin_start+'js/plugins/flot/jquery.flot.pie.js', plugin_start+'js/plugins/flot/curvedLines.js', plugin_start+'js/plugins/flot/angular-flot.js' ]
                        },
                        {
                            name: 'angles',
                            files: [plugin_start+'js/plugins/chartJs/angles.js', plugin_start+'js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards.dashboard_2', {
            url: "/dashboard_2",
            templateUrl: plugin_start+"views/dashboard_2.html",
            data: { pageTitle: 'Dashboard 2' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [plugin_start+ 'js/plugins/flot/jquery.flot.js', plugin_start+'js/plugins/flot/jquery.flot.time.js', plugin_start+'js/plugins/flot/jquery.flot.tooltip.min.js', plugin_start+'js/plugins/flot/jquery.flot.spline.js', plugin_start+'js/plugins/flot/jquery.flot.resize.js', plugin_start+'js/plugins/flot/jquery.flot.pie.js', plugin_start+'js/plugins/flot/curvedLines.js', plugin_start+'js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            files: [plugin_start+'js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js', plugin_start+'js/plugins/jvectormap/jquery-jvectormap-2.0.2.css']
                        },
                        {
                            files: [plugin_start+'js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
                        },
                        {
                            name: 'ui.checkbox',
                            files: [plugin_start+'js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards.dashboard_3', {
            url: "/dashboard_3",
            templateUrl: plugin_start+"views/dashboard_3.html",
            data: { pageTitle: 'Dashboard 3' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angles',
                            files: [plugin_start+'js/plugins/chartJs/angles.js', plugin_start+'js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        },
                        {
                            name: 'ui.checkbox',
                            files: [plugin_start+'js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        .state('dashboards_top', {
            abstract: true,
            url: "/dashboards_top",
            templateUrl: plugin_start+"views/common/content_top_navigation.html",
        })
        .state('dashboards_top.dashboard_4', {
            url: "/dashboard_4",
            templateUrl: plugin_start+"views/dashboard_4.html",
            data: { pageTitle: 'Dashboard 4' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angles',
                            files: [plugin_start+'js/plugins/chartJs/angles.js', plugin_start+'js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        },
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ plugin_start+'js/plugins/flot/jquery.flot.js', plugin_start+'js/plugins/flot/jquery.flot.time.js', plugin_start+'js/plugins/flot/jquery.flot.tooltip.min.js', plugin_start+'js/plugins/flot/jquery.flot.spline.js', plugin_start+'js/plugins/flot/jquery.flot.resize.js', plugin_start+'js/plugins/flot/jquery.flot.pie.js', plugin_start+'js/plugins/flot/curvedLines.js', plugin_start+'js/plugins/flot/angular-flot.js', ]
                        }
                    ]);
                }
            }
        })
        .state('dashboards.dashboard_4_1', {
            url: "/dashboard_4_1",
            templateUrl: plugin_start+"views/dashboard_4_1.html",
            data: { pageTitle: 'Dashboard 4' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angles',
                            files: [plugin_start+'js/plugins/chartJs/angles.js', plugin_start+'js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        },
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ plugin_start+'js/plugins/flot/jquery.flot.js', plugin_start+'js/plugins/flot/jquery.flot.time.js', plugin_start+'js/plugins/flot/jquery.flot.tooltip.min.js', plugin_start+'js/plugins/flot/jquery.flot.spline.js', plugin_start+'js/plugins/flot/jquery.flot.resize.js', plugin_start+'js/plugins/flot/jquery.flot.pie.js', plugin_start+'js/plugins/flot/curvedLines.js', plugin_start+'js/plugins/flot/angular-flot.js', ]
                        }
                    ]);
                }
            }
        })
        .state('layouts', {
            url: "/layouts",
            templateUrl: plugin_start+"views/layouts.html",
            data: { pageTitle: 'Layouts' },
        })
        .state('charts', {
            abstract: true,
            url: "/charts",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('charts.flot_chart', {
            url: "/flot_chart",
            templateUrl: plugin_start+"views/graph_flot.html",
            data: { pageTitle: 'Flot chart' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ plugin_start+'js/plugins/flot/jquery.flot.js', plugin_start+'js/plugins/flot/jquery.flot.time.js', plugin_start+'js/plugins/flot/jquery.flot.tooltip.min.js', plugin_start+'js/plugins/flot/jquery.flot.spline.js', plugin_start+'js/plugins/flot/jquery.flot.resize.js', plugin_start+'js/plugins/flot/jquery.flot.pie.js', plugin_start+'js/plugins/flot/curvedLines.js', plugin_start+'js/plugins/flot/angular-flot.js', ]
                        }
                    ]);
                }
            }
        })
        .state('charts.rickshaw_chart', {
            url: "/rickshaw_chart",
            templateUrl: plugin_start+"views/graph_rickshaw.html",
            data: { pageTitle: 'Rickshaw chart' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            reconfig: true,
                            serie: true,
                            files: [plugin_start+'js/plugins/rickshaw/vendor/d3.v3.js',plugin_start+'js/plugins/rickshaw/rickshaw.min.js']
                        },
                        {
                            reconfig: true,
                            name: 'angular-rickshaw',
                            files: [plugin_start+'js/plugins/rickshaw/angular-rickshaw.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.peity_chart', {
            url: "/peity_chart",
            templateUrl: plugin_start+"views/graph_peity.html",
            data: { pageTitle: 'Peity graphs' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.sparkline_chart', {
            url: "/sparkline_chart",
            templateUrl: plugin_start+"views/graph_sparkline.html",
            data: { pageTitle: 'Sparkline chart' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/sparkline/jquery.sparkline.min.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.chartjs_chart', {
            url: "/chartjs_chart",
            templateUrl: plugin_start+"views/chartjs.html",
            data: { pageTitle: 'Chart.js' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/chartJs/Chart.min.js']
                        },
                        {
                            name: 'angles',
                            files: [plugin_start+'js/plugins/chartJs/angles.js']
                        }
                    ]);
                }
            }
        })
        .state('charts.chartist_chart', {
            url: "/chartist_chart",
            templateUrl: plugin_start+"views/chartist.html",
            data: { pageTitle: 'Chartist' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-chartist',
                            files: [plugin_start+'js/plugins/chartist/chartist.min.js', plugin_start+'css/plugins/chartist/chartist.min.css', plugin_start+'js/plugins/chartist/angular-chartist.min.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox', {
            abstract: true,
            url: "/mailbox",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('mailbox.inbox', {
            url: "/inbox",
            templateUrl: plugin_start+"views/mailbox.html",
            data: { pageTitle: 'Mail Inbox' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox.email_view', {
            url: "/email_view",
            templateUrl: plugin_start+"views/mail_detail.html",
            data: { pageTitle: 'Mail detail' }
        })
        .state('mailbox.email_compose', {
            url: "/email_compose",
            templateUrl: plugin_start+"views/mail_compose.html",
            data: { pageTitle: 'Mail compose' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'css/plugins/summernote/summernote.css',plugin_start+'css/plugins/summernote/summernote-bs3.css',plugin_start+'js/plugins/summernote/summernote.min.js']
                        },
                        {
                            name: 'summernote',
                            files: [plugin_start+'css/plugins/summernote/summernote.css',plugin_start+'css/plugins/summernote/summernote-bs3.css',plugin_start+'js/plugins/summernote/summernote.min.js',plugin_start+'js/plugins/summernote/angular-summernote.min.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox.email_template', {
            url: "/email_template",
            templateUrl: plugin_start+"views/email_template.html",
            data: { pageTitle: 'Mail compose' }
        })
        .state('widgets', {
            url: "/widgets",
            templateUrl: plugin_start+"views/widgets.html",
            data: { pageTitle: 'Widhets' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            name: 'angular-flot',
                            files: [ plugin_start+'js/plugins/flot/jquery.flot.js', plugin_start+'js/plugins/flot/jquery.flot.time.js', plugin_start+'js/plugins/flot/jquery.flot.tooltip.min.js', plugin_start+'js/plugins/flot/jquery.flot.spline.js', plugin_start+'js/plugins/flot/jquery.flot.resize.js', plugin_start+'js/plugins/flot/jquery.flot.pie.js', plugin_start+'js/plugins/flot/curvedLines.js', plugin_start+'js/plugins/flot/angular-flot.js', ]
                        },
                        {
                            files: [plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                        },
                        {
                            files: [plugin_start+'js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js', plugin_start+'js/plugins/jvectormap/jquery-jvectormap-2.0.2.css']
                        },
                        {
                            files: [plugin_start+'js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js']
                        },
                        {
                            name: 'ui.checkbox',
                            files: [plugin_start+'js/bootstrap/angular-bootstrap-checkbox.js']
                        }
                    ]);
                }
            }
        })
        .state('metrics', {
            url: "/metrics",
            templateUrl: plugin_start+"views/metrics.html",
            data: { pageTitle: 'Metrics' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/sparkline/jquery.sparkline.min.js']
                        }
                    ]);
                }
            }
        })
        .state('mailbox.singleOrder', {
            url: "/singleOrder/:name/:id",
            templateUrl: plugin_start+"views/singleorder.html",
            data: { pageTitle: 'Single Order' },
            controller: function($scope, $stateParams) {
                $scope.name = $stateParams.name;
                $scope.id = $stateParams.id;
            }
        })
        .state('forms', {
            abstract: true,
            url: "/forms",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('forms.basic_form', {
            url: "/basic_form",
            templateUrl: plugin_start+"views/form_basic.html",
            data: { pageTitle: 'Basic form' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('forms.advanced_plugins', {
            url: "/advanced_plugins",
            templateUrl: plugin_start+"views/form_advanced.html",
            data: { pageTitle: 'Advanced form' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.knob',
                            files: [plugin_start+'js/plugins/jsKnob/jquery.knob.js',plugin_start+'js/plugins/jsKnob/angular-knob.js']
                        },
                        {
                            files: [plugin_start+'css/plugins/ionRangeSlider/ion.rangeSlider.css',plugin_start+'css/plugins/ionRangeSlider/ion.rangeSlider.skinFlat.css',plugin_start+'js/plugins/ionRangeSlider/ion.rangeSlider.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            name: 'localytics.directives',
                            files: [plugin_start+'css/plugins/chosen/chosen.css',plugin_start+'js/plugins/chosen/chosen.jquery.js',plugin_start+'js/plugins/chosen/chosen.js']
                        },
                        {
                            name: 'nouislider',
                            files: [plugin_start+'css/plugins/nouslider/jquery.nouislider.css',plugin_start+'js/plugins/nouslider/jquery.nouislider.min.js',plugin_start+'js/plugins/nouslider/angular-nouislider.js']
                        },
                        {
                            name: 'datePicker',
                            files: [plugin_start+'css/plugins/datapicker/angular-datapicker.css',plugin_start+'js/plugins/datapicker/angular-datepicker.js']
                        },
                        {
                            files: [plugin_start+'js/plugins/jasny/jasny-bootstrap.min.js']
                        },
                        {
                            files: [plugin_start+'css/plugins/clockpicker/clockpicker.css', plugin_start+'js/plugins/clockpicker/clockpicker.js']
                        },
                        {
                            name: 'ui.switchery',
                            files: [plugin_start+'css/plugins/switchery/switchery.css',plugin_start+'js/plugins/switchery/switchery.js',plugin_start+'js/plugins/switchery/ng-switchery.js']
                        },
                        {
                            name: 'colorpicker.module',
                            files: [plugin_start+'css/plugins/colorpicker/colorpicker.css',plugin_start+'js/plugins/colorpicker/bootstrap-colorpicker-module.js']
                        },
                        {
                            name: 'ngImgCrop',
                            files: [plugin_start+'js/plugins/ngImgCrop/ng-img-crop.js',plugin_start+'css/plugins/ngImgCrop/ng-img-crop.css']
                        },
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/moment/moment.min.js', plugin_start+'js/plugins/daterangepicker/daterangepicker.js', plugin_start+'css/plugins/daterangepicker/daterangepicker-bs3.css']
                        },
                        {
                            name: 'daterangepicker',
                            files: [plugin_start+'js/plugins/daterangepicker/angular-daterangepicker.js']
                        },
                        {
                            files: [plugin_start+'css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css']
                        }

                    ]);
                }
            }
        })
        .state('forms.file_upload', {
            url: "/file_upload",
            templateUrl: plugin_start+"views/form_file_upload.html",
            data: { pageTitle: 'File upload' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'css/plugins/dropzone/basic.css',plugin_start+'css/plugins/dropzone/dropzone.css',plugin_start+'js/plugins/dropzone/dropzone.js']
                        }
                    ]);
                }
            }
        })
        .state('forms.text_editor', {
            url: "/text_editor",
            templateUrl: plugin_start+"views/form_editors.html",
            data: { pageTitle: 'Text editor' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'summernote',
                            files: [plugin_start+'css/plugins/summernote/summernote.css',plugin_start+'css/plugins/summernote/summernote-bs3.css',plugin_start+'js/plugins/summernote/summernote.min.js',plugin_start+'js/plugins/summernote/angular-summernote.min.js']
                        }
                    ]);
                }
            }
        })
        .state('app', {
            abstract: true,
            url: "/app",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('app.contacts', {
            url: "/contacts",
            templateUrl: plugin_start+"views/contacts.html",
            data: { pageTitle: 'Contacts' }
        })
        .state('app.profile', {
            url: "/profile",
            templateUrl: plugin_start+"views/profile.html",
            data: { pageTitle: 'Profile' }
        })
        .state('app.projects', {
            url: "/projects",
            templateUrl: plugin_start+"views/projects.html",
            data: { pageTitle: 'Projects' }
        })
        .state('app.project_detail', {
            url: "/project_detail",
            templateUrl: plugin_start+"views/project_detail.html",
            data: { pageTitle: 'Project detail' }
        })
        .state('app.file_manager', {
            url: "/file_manager",
            templateUrl: plugin_start+"views/file_manager.html",
            data: { pageTitle: 'File manager' }
        })
        .state('app.calendar', {
            url: "/calendar",
            templateUrl: plugin_start+"views/calendar.html",
            data: { pageTitle: 'Calendar' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            insertBefore: '#loadBefore',
                            files: [plugin_start+'css/plugins/fullcalendar/fullcalendar.css',plugin_start+'js/plugins/fullcalendar/fullcalendar.min.js',plugin_start+'js/plugins/fullcalendar/gcal.js']
                        },
                        {
                            name: 'ui.calendar',
                            files: [plugin_start+'js/plugins/fullcalendar/calendar.js']
                        }
                    ]);
                }
            }
        })
        .state('app.faq', {
            url: "/faq",
            templateUrl: plugin_start+"views/faq.html",
            data: { pageTitle: 'FAQ' }
        })
        .state('app.timeline', {
            url: "/timeline",
            templateUrl: plugin_start+"views/timeline.html",
            data: { pageTitle: 'Timeline' }
        })
        .state('app.pin_board', {
            url: "/pin_board",
            templateUrl: plugin_start+"views/pin_board.html",
            data: { pageTitle: 'Pin board' }
        })
        .state('app.invoice', {
            url: "/invoice",
            templateUrl: plugin_start+"views/invoice.html",
            data: { pageTitle: 'Invoice' }
        })
        .state('app.blog', {
            url: "/blog",
            templateUrl: plugin_start+"views/blog.html",
            data: { pageTitle: 'Blog' }
        })
        .state('app.article', {
            url: "/article",
            templateUrl: plugin_start+"views/article.html",
            data: { pageTitle: 'Article' }
        })
        .state('app.issue_tracker', {
            url: "/issue_tracker",
            templateUrl: plugin_start+"views/issue_tracker.html",
            data: { pageTitle: 'Issue Tracker' }
        })
        .state('app.clients', {
            url: "/clients",
            templateUrl: plugin_start+"views/clients.html",
            data: { pageTitle: 'Clients' }
        })
        .state('app.teams_board', {
            url: "/teams_board",
            templateUrl: plugin_start+"views/teams_board.html",
            data: { pageTitle: 'Teams board' }
        })
        .state('app.social_feed', {
            url: "/social_feed",
            templateUrl: plugin_start+"views/social_feed.html",
            data: { pageTitle: 'Social feed' }
        })
        .state('pages', {
            abstract: true,
            url: "/pages",
            templateUrl: plugin_start+"views/common/content.html"
        })
        .state('pages.search_results', {
            url: "/search_results",
            templateUrl: plugin_start+"views/search_results.html",
            data: { pageTitle: 'Search results' }
        })
        .state('pages.empy_page', {
            url: "/empy_page",
            templateUrl: plugin_start+"views/empty_page.html",
            data: { pageTitle: 'Empty page' }
        })
        .state('login', {
            url: "/login",
            templateUrl: plugin_start+"views/login.html",
            data: { pageTitle: 'Login', specialClass: 'gray-bg' }
        })
        .state('login_two_columns', {
            url: "/login_two_columns",
            templateUrl: plugin_start+"views/login_two_columns.html",
            data: { pageTitle: 'Login two columns', specialClass: 'gray-bg' }
        })
        .state('register', {
            url: "/register",
            templateUrl: plugin_start+"views/register.html",
            data: { pageTitle: 'Register', specialClass: 'gray-bg' }
        })
        .state('lockscreen', {
            url: "/lockscreen",
            templateUrl: plugin_start+"views/lockscreen.html",
            data: { pageTitle: 'Lockscreen', specialClass: 'gray-bg' }
        })
        .state('forgot_password', {
            url: "/forgot_password",
            templateUrl: plugin_start+"views/forgot_password.html",
            data: { pageTitle: 'Forgot password', specialClass: 'gray-bg' }
        })
        .state('errorOne', {
            url: "/errorOne",
            templateUrl: plugin_start+"views/errorOne.html",
            data: { pageTitle: '404', specialClass: 'gray-bg' }
        })
        .state('errorTwo', {
            url: "/errorTwo",
            templateUrl: plugin_start+"views/errorTwo.html",
            data: { pageTitle: '500', specialClass: 'gray-bg' }
        })
        .state('ui', {
            abstract: true,
            url: "/ui",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('ui.typography', {
            url: "/typography",
            templateUrl: plugin_start+"views/typography.html",
            data: { pageTitle: 'Typography' }
        })
        .state('ui.icons', {
            url: "/icons",
            templateUrl: plugin_start+"views/icons.html",
            data: { pageTitle: 'Icons' }
        })
        .state('ui.buttons', {
            url: "/buttons",
            templateUrl: plugin_start+"views/buttons.html",
            data: { pageTitle: 'Buttons' }
        })
        .state('ui.tabs_panels', {
            url: "/tabs_panels",
            templateUrl: plugin_start+"views/tabs_panels.html",
            data: { pageTitle: 'Panels' }
        })
        .state('ui.tabs', {
            url: "/tabs",
            templateUrl: plugin_start+"views/tabs.html",
            data: { pageTitle: 'Tabs' },
            resolve:{
                loadPlugin:function($ocLazyLoad){
                    return $ocLazyLoad.load([
                    {
                        files:[plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                    }
                    ]);
                }
            }
        })
        .state('ui.notifications_tooltips', {
            url: "/notifications_tooltips",
            templateUrl: plugin_start+"views/notifications.html",
            data: { pageTitle: 'Notifications and tooltips' }
        })
        .state('ui.badges_labels', {
            url: "/badges_labels",
            templateUrl: plugin_start+"views/badges_labels.html",
            data: { pageTitle: 'Badges and labels and progress' }
        })
        .state('ui.video', {
            url: "/video",
            templateUrl: plugin_start+"views/video.html",
            data: { pageTitle: 'Responsible Video' }
        })
        .state('ui.draggable', {
            url: "/draggable",
            templateUrl: plugin_start+"views/draggable.html",
            data: { pageTitle: 'Draggable panels' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.sortable',
                            files: [plugin_start+'js/plugins/ui-sortable/sortable.js']
                        }
                    ]);
                }
            }
        })
        .state('grid_options', {
            url: "/grid_options",
            templateUrl: plugin_start+"views/grid_options.html",
            data: { pageTitle: 'Grid options' }
        })
        .state('miscellaneous', {
            abstract: true,
            url: "/miscellaneous",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('miscellaneous.google_maps', {
            url: "/google_maps",
            templateUrl: plugin_start+"views/google_maps.html",
            data: { pageTitle: 'Google maps' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.event',
                            files: [plugin_start+'js/plugins/uievents/event.js']
                        },
                        {
                            name: 'ui.map',
                            files: [plugin_start+'js/plugins/uimaps/ui-map.js']
                        },
                    ]);
                }
            }
        })
        .state('miscellaneous.code_editor', {
            url: "/code_editor",
            templateUrl: plugin_start+"views/code_editor.html",
            data: { pageTitle: 'Code Editor' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: [plugin_start+'css/plugins/codemirror/codemirror.css',plugin_start+'css/plugins/codemirror/ambiance.css',plugin_start+'js/plugins/codemirror/codemirror.js',plugin_start+'js/plugins/codemirror/mode/javascript/javascript.js']
                        },
                        {
                            name: 'ui.codemirror',
                            files: [plugin_start+'js/plugins/ui-codemirror/ui-codemirror.min.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.modal_window', {
            url: "/modal_window",
            templateUrl: plugin_start+"views/modal_window.html",
            data: { pageTitle: 'Modal window' }
        })
        .state('miscellaneous.chat_view', {
            url: "/chat_view",
            templateUrl: plugin_start+"views/chat_view.html",
            data: { pageTitle: 'Chat view' }
        })
        .state('miscellaneous.nestable_list', {
            url: "/nestable_list",
            templateUrl: plugin_start+"views/nestable_list.html",
            data: { pageTitle: 'Nestable List' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.tree',
                            files: ['css/plugins/uiTree/angular-ui-tree.min.css',plugin_start+'js/plugins/uiTree/angular-ui-tree.min.js']
                        },
                    ]);
                }
            }
        })
        .state('miscellaneous.notify', {
            url: "/notify",
            templateUrl: plugin_start+"views/notify.html",
            data: { pageTitle: 'Notifications for angularJS' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'cgNotify',
                            files: [plugin_start+'css/plugins/angular-notify/angular-notify.min.css',plugin_start+'js/plugins/angular-notify/angular-notify.min.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.timeline_2', {
            url: "/timeline_2",
            templateUrl: plugin_start+"views/timeline_2.html",
            data: { pageTitle: 'Timeline version 2' }
        })
        .state('miscellaneous.forum_view', {
            url: "/forum_view",
            templateUrl: plugin_start+"views/forum_view.html",
            data: { pageTitle: 'Forum - general view' }
        })
        .state('miscellaneous.forum_post_view', {
            url: "/forum_post_view",
            templateUrl: plugin_start+"views/forum_post_view.html",
            data: { pageTitle: 'Forum - post view' }
        })
        .state('miscellaneous.diff', {
            url: "/diff",
            templateUrl: plugin_start+"views/diff.html",
            data: { pageTitle: 'Text Diff' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/diff_match_patch/javascript/diff_match_patch.js']
                        },
                        {
                            name: 'diff-match-patch',
                            files: [plugin_start+'js/plugins/angular-diff-match-patch/angular-diff-match-patch.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.sweet_alert', {
            url: "/sweet_alert",
            templateUrl: plugin_start+"views/sweet_alert.html",
            data: { pageTitle: 'Sweet alert' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/sweetalert/sweetalert.min.js', plugin_start+'css/plugins/sweetalert/sweetalert.css']
                        },
                        {
                            name: 'oitozero.ngSweetAlert',
                            files: [plugin_start+'js/plugins/sweetalert/angular-sweetalert.min.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.idle_timer', {
            url: "/idle_timer",
            templateUrl: plugin_start+"views/idle_timer.html",
            data: { pageTitle: 'Idle timer' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'cgNotify',
                            files: [plugin_start+'css/plugins/angular-notify/angular-notify.min.css',plugin_start+'js/plugins/angular-notify/angular-notify.min.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.live_favicon', {
            url: "/live_favicon",
            templateUrl: plugin_start+"views/live_favicon.html",
            data: { pageTitle: 'Live favicon' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/tinycon/tinycon.min.js']
                        }
                    ]);
                }
            }
        })
        .state('miscellaneous.spinners', {
            url: "/spinners",
            templateUrl: plugin_start+"views/spinners.html",
            data: { pageTitle: 'Spinners' }
        })
        .state('miscellaneous.validation', {
            url: "/validation",
            templateUrl: plugin_start+"views/validation.html",
            data: { pageTitle: 'Validation' }
        })
        .state('miscellaneous.agile_board', {
            url: "/agile_board",
            templateUrl: plugin_start+"views/agile_board.html",
            data: { pageTitle: 'Agile board' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ui.sortable',
                            files: [plugin_start+'js/plugins/ui-sortable/sortable.js']
                        }
                    ]);
                }
            }
        })
        .state('tables', {
            abstract: true,
            url: "/tables",
            templateUrl: plugin_start+"views/common/content.html",
        })
        .state('tables.static_table', {
            url: "/static_table",
            templateUrl: plugin_start+"views/table_basic.html",
            data: { pageTitle: 'Static table' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'angular-peity',
                            files: [plugin_start+'js/plugins/peity/jquery.peity.min.js', plugin_start+'js/plugins/peity/angular-peity.js']
                        },
                        {
                            files: [plugin_start+'css/plugins/iCheck/custom.css',plugin_start+'js/plugins/iCheck/icheck.min.js']
                        }
                    ]);
                }
            }
        })
        .state('tables.data_tables', {
            url: "/data_tables",
            templateUrl: plugin_start+"views/table_data_tables.html",
            data: { pageTitle: 'Data Tables' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/dataTables/jquery.dataTables.js',plugin_start+'css/plugins/dataTables/dataTables.bootstrap.css']
                        },
                        {
                            serie: true,
                            files: [plugin_start+'js/plugins/dataTables/dataTables.bootstrap.js']
                        },
                        {
                            name: 'datatables',
                            files: [plugin_start+'js/plugins/dataTables/angular-datatables.min.js']
                        }
                    ]);
                }
            }
        })
        .state('tables.foo_table', {
            url: "/foo_table",
            templateUrl: plugin_start+"views/foo_table.html",
            data: { pageTitle: 'Foo Table' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/footable/footable.all.min.js', plugin_start+'css/plugins/footable/footable.core.css']
                        },
                        {
                            name: 'ui.footable',
                            files: [plugin_start+'js/plugins/footable/angular-footable.js']
                        }
                    ]);
                }
            }
        })
        .state('tables.nggrid', {
            url: "/nggrid",
            templateUrl: plugin_start+"views/nggrid.html",
            data: { pageTitle: 'ng Grid' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            name: 'ngGrid',
                            files: [plugin_start+'js/plugins/nggrid/ng-grid-2.0.3.min.js']
                        },
                        {
                            insertBefore: '#loadBefore',
                            files: [plugin_start+'js/plugins/nggrid/ng-grid.css']
                        }
                    ]);
                }
            }
        })
        .state('commerce', {
            abstract: true,
            url: "/commerce",
            templateUrl: plugin_start+"views/common/content.html",
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/footable/footable.all.min.js', plugin_start+'css/plugins/footable/footable.core.css']
                        },
                        {
                            name: 'ui.footable',
                            files: [plugin_start+'js/plugins/footable/angular-footable.js']
                        }
                    ]);
                }
            }
        })
        .state('commerce.products_grid', {
            url: "/products_grid",
            templateUrl: plugin_start+"views/ecommerce_products_grid.html",
            data: { pageTitle: 'E-commerce grid' }
        })
        .state('commerce.product_list', {
            url: "/product_list",
            templateUrl: plugin_start+"views/ecommerce_product_list.html",
            data: { pageTitle: 'E-commerce product list' }
        })
        .state('commerce.orders', {
            url: "/orders",
            templateUrl: plugin_start+"views/ecommerce_orders.html",
            data: { pageTitle: 'E-commerce orders' }
        })
        .state('commerce.product', {
            url: "/product",
            templateUrl: plugin_start+"views/ecommerce_product.html",
            data: { pageTitle: 'Product edit' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'css/plugins/summernote/summernote.css','css/plugins/summernote/summernote-bs3.css',plugin_start+'js/plugins/summernote/summernote.min.js']
                        },
                        {
                            name: 'summernote',
                            files: [plugin_start+'css/plugins/summernote/summernote.css','css/plugins/summernote/summernote-bs3.css',plugin_start+'js/plugins/summernote/summernote.min.js','js/plugins/summernote/angular-summernote.min.js']
                        }
                    ]);
                }
            }

        })
        .state('gallery', {
            abstract: true,
            url: "/gallery",
            templateUrl: plugin_start+"views/common/content.html"
        })
        .state('gallery.basic_gallery', {
            url: "/basic_gallery",
            templateUrl: plugin_start+"views/basic_gallery.html",
            data: { pageTitle: 'Lightbox Gallery' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            files: [plugin_start+'js/plugins/blueimp/jquery.blueimp-gallery.min.js',plugin_start+'css/plugins/blueimp/css/blueimp-gallery.min.css']
                        }
                    ]);
                }
            }
        })
        .state('gallery.bootstrap_carousel', {
            url: "/bootstrap_carousel",
            templateUrl: plugin_start+"views/carousel.html",
            data: { pageTitle: 'Bootstrap carousel' }
        })
        .state('css_animations', {
            url: "/css_animations",
            templateUrl: plugin_start+"views/css_animation.html",
            data: { pageTitle: 'CSS Animations' },
            resolve: {
                loadPlugin: function ($ocLazyLoad) {
                    return $ocLazyLoad.load([
                        {
                            reconfig: true,
                            serie: true,
                            files: [plugin_start+'js/plugins/rickshaw/vendor/d3.v3.js',plugin_start+'js/plugins/rickshaw/rickshaw.min.js']
                        },
                        {
                            reconfig: true,
                            name: 'angular-rickshaw',
                            files: [plugin_start+'js/plugins/rickshaw/angular-rickshaw.js']
                        }
                    ]);
                }
            }

        })
        .state('landing', {
            url: "/landing",
            templateUrl: plugin_start+"views/landing.html",
            data: { pageTitle: 'Landing page', specialClass: 'landing-page' }
        })
        // .state('outlook', {
        //     url: "/outlook",
        //     templateUrl: plugin_start+"views/outlook.html",
        //     data: { pageTitle: 'Outlook view', specialClass: 'fixed-sidebar' }
        // })
        .state('off_canvas', {
            url: "/off_canvas",
            templateUrl: plugin_start+"views/off_canvas.html",
            data: { pageTitle: 'Off canvas menu', specialClass: 'canvas-menu' }
        });

}
angular
    .module('HUNGRY')
    .config(config)
    .run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });
