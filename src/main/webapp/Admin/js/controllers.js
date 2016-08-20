/**
 *
 * Main controller.js file
 * Define controllers with data used in Inspinia theme
 *
 *
 * Functions (controllers) 
	- MainCtrl
	- ItemCreationCtrl
	- ItemListController
	- ItemEditController
	- CategoryItemsListController
	- SingleItemController
	- SellerBranchtItemsListController
	- SellerItemCreationController
	- CategoryCreationController
	- CategoryListController
	- SingleCategoryController
	- CategoryEditController
	- SubCategoryCreationController
	- SubCategoryListController
	- SingleSubCategoryController
	- SellersItemsListController
	- SingleSellerItemsController
	- TagCreationController
	- TagsListController
	- SingleTagController
	- TagTypeCreationController
	- TagTypeListController
	- CutTypeListController
	- CutTypeCreationController
	- SingleCutTypeController
	- SingleTagTypeController
	- SellersCreationController
	- RestaurantBranchCreationController
	- SellersListController
	- SellerBranchListController
	- SingleBranchController
	- SellerItemEditController
	- SellerBranchEmployeesListController
	- SellerBranchEmployeeCreationController
	- SingleSellerBranchEmployeeController
	- SellerBranchTimingController
	- SellerBranchTimingCreationController
	- SingleSellerBranchTimingsController
	- CompanyController
	- CompanyCreationController
	- CompanyBranchCreationController
	- SingleCompanyController
	- CompanyEmployeeController
	- CompanyEmployeeCreationController
	- SingleCompanyEmployeeController
	- CompanyAdminController
	- CompanyAdminCreationController
	- CompanyTimingsController
	- CompanyTimingCreationController
	- MeatListController
	- meatCreationController
	- meatEmployeeListController
	- meatEmployeeCreationController
	- meatAdminListController
	- meatAdminCreationController
	- TimingListController
	- CriteriaListController
	- CriteriaCreateController
	- ZonesListController
	- TimingCreateViewController
	- ZonesCreateViewController
 *  - OffersListController
 *  - OffersCreationController
 *  - 
 *
 *
 */

/**
 * MainCtrl - controller
 * Contains severals global data used in diferent view
 *
 */
function MainCtrl() {
	/**
	 * daterange - Used as initial model for data range picker in Advanced form view
	 */
	this.daterange = {startDate: null, endDate: null}

	/**
	 * slideInterval - Interval for bootstrap Carousel, in milliseconds:
	 */
	this.slideInterval = 5000;

	/**
	 * states - Data used in Advanced Form view for Chosen plugin
	 */
	this.states = [
		'Alabama',
		'Alaska',
		'Arizona',
		'Arkansas',
		'California',
		'Colorado',
		'Connecticut',
		'Delaware',
		'Florida',
		'Georgia',
		'Hawaii',
		'Idaho',
		'Illinois',
		'Indiana',
		'Iowa',
		'Kansas',
		'Kentucky',
		'Louisiana',
		'Maine',
		'Maryland',
		'Massachusetts',
		'Michigan',
		'Minnesota',
		'Mississippi',
		'Missouri',
		'Montana',
		'Nebraska',
		'Nevada',
		'New Hampshire',
		'New Jersey',
		'New Mexico',
		'New York',
		'North Carolina',
		'North Dakota',
		'Ohio',
		'Oklahoma',
		'Oregon',
		'Pennsylvania',
		'Rhode Island',
		'South Carolina',
		'South Dakota',
		'Tennessee',
		'Texas',
		'Utah',
		'Vermont',
		'Virginia',
		'Washington',
		'West Virginia',
		'Wisconsin',
		'Wyoming'
	];

	/**
	 * persons - Data used in Tables view for Data Tables plugin
	 */
	this.persons = [
		{
			id: '1',
			firstName: 'Monica',
			lastName: 'Smith'
		},
		{
			id: '2',
			firstName: 'Sandra',
			lastName: 'Jackson'
		},
		{
			id: '3',
			firstName: 'John',
			lastName: 'Underwood'
		},
		{
			id: '4',
			firstName: 'Chris',
			lastName: 'Johnatan'
		},
		{
			id: '5',
			firstName: 'Kim',
			lastName: 'Rosowski'
		}
	];

	/**
	 * check's - Few variables for checkbox input used in iCheck plugin. Only for demo purpose
	 */
	this.checkOne = true;
	this.checkTwo = true;
	this.checkThree = true;
	this.checkFour = true;

	/**
	 * knobs - Few variables for knob plugin used in Advanced Plugins view
	 */
	this.knobOne = 75;
	this.knobTwo = 25;
	this.knobThree = 50;

	/**
	 * Variables used for Ui Elements view
	 */
	this.bigTotalItems = 175;
	this.bigCurrentPage = 1;
	this.maxSize = 5;
	this.singleModel = 1;
	this.radioModel = 'Middle';
	this.checkModel = {
		left: false,
		middle: true,
		right: false
	};

	/**
	 * groups - used for Collapse panels in Tabs and Panels view
	 */
	this.groups = [
		{
			title: 'Dynamic Group Header - 1',
			content: 'Dynamic Group Body - 1'
		},
		{
			title: 'Dynamic Group Header - 2',
			content: 'Dynamic Group Body - 2'
		}
	];

	/**
	 * alerts - used for dynamic alerts in Notifications and Tooltips view
	 */
	this.alerts = [
		{ type: 'danger', msg: 'Oh snap! Change a few things up and try submitting again.' },
		{ type: 'success', msg: 'Well done! You successfully read this important alert message.' },
		{ type: 'info', msg: 'OK, You are done a great job man.' }
	];

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
	/**
	 * initial run for random stacked value
	 */
	this.randomStacked();

	/**
	 * summernoteText - used for Summernote plugin
	 */
	this.summernoteText = ['<h3>Hello Jonathan! </h3>',
	'<p>dummy text of the printing and typesetting industry. <strong>Lorem Ipsum has been the dustrys</strong> standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more',
		'recently with</p>'].join('');

	/**
	 * General variables for Peity Charts
	 * used in many view so this is in Main controller
	 */
	this.BarChart = {
		data: [5, 3, 9, 6, 5, 9, 7, 3, 5, 2, 4, 7, 3, 2, 7, 9, 6, 4, 5, 7, 3, 2, 1, 0, 9, 5, 6, 8, 3, 2, 1],
		options: {
			fill: ["#1ab394", "#d7d7d7"],
			width: 100
		}
	};

	this.BarChart2 = {
		data: [5, 3, 9, 6, 5, 9, 7, 3, 5, 2],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};

	this.BarChart3 = {
		data: [5, 3, 2, -1, -3, -2, 2, 3, 5, 2],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};

	this.LineChart = {
		data: [5, 9, 7, 3, 5, 2, 5, 3, 9, 6, 5, 9, 4, 7, 3, 2, 9, 8, 7, 4, 5, 1, 2, 9, 5, 4, 7],
		options: {
			fill: '#1ab394',
			stroke: '#169c81',
			width: 64
		}
	};

	this.LineChart2 = {
		data: [3, 2, 9, 8, 47, 4, 5, 1, 2, 9, 5, 4, 7],
		options: {
			fill: '#1ab394',
			stroke: '#169c81',
			width: 64
		}
	};

	this.LineChart3 = {
		data: [5, 3, 2, -1, -3, -2, 2, 3, 5, 2],
		options: {
			fill: '#1ab394',
			stroke: '#169c81',
			width: 64
		}
	};

	this.LineChart4 = {
		data: [5, 3, 9, 6, 5, 9, 7, 3, 5, 2],
		options: {
			fill: '#1ab394',
			stroke: '#169c81',
			width: 64
		}
	};

	this.PieChart = {
		data: [1, 5],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};

	this.PieChart2 = {
		data: [226, 360],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};
	this.PieChart3 = {
		data: [0.52, 1.561],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};
	this.PieChart4 = {
		data: [1, 4],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};
	this.PieChart5 = {
		data: [226, 134],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};
	this.PieChart6 = {
		data: [0.52, 1.041],
		options: {
			fill: ["#1ab394", "#d7d7d7"]
		}
	};
};



/**
 * rickshawChartCtrl - Controller for data for all Rickshaw chart
 * used in Rickshaw chart view
 */
function rickshawChartCtrl() {

	/**
	 * Data for simple chart
	 */
	var simpleChartSeries = [
		{
			color: '#1ab394',
			data: [
				{ x: 0, y: 40 },
				{ x: 1, y: 49 },
				{ x: 2, y: 38 },
				{ x: 3, y: 30 },
				{ x: 4, y: 32 }
			]
		}
	];
	/**
	 * Options for simple chart
	 */
	var simpleChartOptions = {
		renderer: 'area'
	};

	/**
	 * Data for Multi Area chart
	 */
	var multiAreaChartSeries = [
		{
			data: [
				{ x: 0, y: 40 },
				{ x: 1, y: 49 },
				{ x: 2, y: 38 },
				{ x: 3, y: 20 },
				{ x: 4, y: 16 }
			],
			color: '#1ab394',
			stroke: '#17997f'
		},
		{
			data: [
				{ x: 0, y: 22 },
				{ x: 1, y: 25 },
				{ x: 2, y: 38 },
				{ x: 3, y: 44 },
				{ x: 4, y: 46 }
			],
			color: '#eeeeee',
			stroke: '#d7d7d7'
		}
	];

	/**
	 * Options for Multi chart
	 */
	var multiAreaChartOptions = {
		renderer: 'area',
		stroke: true
	};

	/**
	 * Options for one line chart
	 */
	var oneLineChartOptions = {
		renderer: 'line'
	};

	/**
	 * Data for one line chart
	 */
	var oneLineChartSeries = [
		{
			data: [
				{ x: 0, y: 40 },
				{ x: 1, y: 49 },
				{ x: 2, y: 38 },
				{ x: 3, y: 30 },
				{ x: 4, y: 32 }
			],
			color: '#1ab394'
		}
	];

	/**
	 * Options for Multi line chart
	 */
	var multiLineChartOptions = {
		renderer: 'line'
	};

	/**
	 * Data for Multi line chart
	 */
	var multiLineChartSeries = [
		{
			data: [
				{ x: 0, y: 40 },
				{ x: 1, y: 49 },
				{ x: 2, y: 38 },
				{ x: 3, y: 30 },
				{ x: 4, y: 32 }
			],
			color: '#1ab394'
		},
		{
			data: [
				{ x: 0, y: 20 },
				{ x: 1, y: 24 },
				{ x: 2, y: 19 },
				{ x: 3, y: 15 },
				{ x: 4, y: 16 }
			],
			color: '#d7d7d7'
		}
	];

	/**
	 * Options for Bars chart
	 */
	var barsChartOptions = {
		renderer: 'bar'
	};

	/**
	 * Data for Bars chart
	 */
	var barsChartSeries = [
		{
			data: [
				{ x: 0, y: 40 },
				{ x: 1, y: 49 },
				{ x: 2, y: 38 },
				{ x: 3, y: 30 },
				{ x: 4, y: 32 }
			],
			color: '#1ab394'
		}
	];

	/**
	 * Options for Stacked chart
	 */
	var stackedChartOptions = {
		renderer: 'bar'
	};

	/**
	 * Data for Stacked chart
	 */
	var stackedChartSeries = [
		{
			data: [
				{ x: 0, y: 40 },
				{ x: 1, y: 49 },
				{ x: 2, y: 38 },
				{ x: 3, y: 30 },
				{ x: 4, y: 32 }
			],
			color: '#1ab394'
		},
		{
			data: [
				{ x: 0, y: 20 },
				{ x: 1, y: 24 },
				{ x: 2, y: 19 },
				{ x: 3, y: 15 },
				{ x: 4, y: 16 }
			],
			color: '#d7d7d7'
		}
	];

	/**
	 * Options for Scatterplot chart
	 */
	var scatterplotChartOptions = {
		renderer: 'scatterplot',
		stroke: true,
		padding: { top: 0.05, left: 0.05, right: 0.05 }
	}

	/**
	 * Data for Scatterplot chart
	 */
	var scatterplotChartSeries = [
		{
			data: [
				{ x: 0, y: 15 },
				{ x: 1, y: 18 },
				{ x: 2, y: 10 },
				{ x: 3, y: 12 },
				{ x: 4, y: 15 },
				{ x: 5, y: 24 },
				{ x: 6, y: 28 },
				{ x: 7, y: 31 },
				{ x: 8, y: 22 },
				{ x: 9, y: 18 },
				{ x: 10, y: 16 }
			],
			color: '#1ab394'
		}
	]

	/**
	 * Definition all variables
	 * Rickshaw chart
	 */
	this.simpleSeries = simpleChartSeries;
	this.simpleOptions = simpleChartOptions;
	this.multiAreaOptions = multiAreaChartOptions;
	this.multiAreaSeries = multiAreaChartSeries;
	this.oneLineOptions = oneLineChartOptions;
	this.oneLineSeries = oneLineChartSeries;
	this.multiLineOptions = multiLineChartOptions;
	this.multiLineSeries = multiLineChartSeries;
	this.barsOptions = barsChartOptions;
	this.barsSeries = barsChartSeries;
	this.stackedOptions = stackedChartOptions;
	this.stackedSeries = stackedChartSeries;
	this.scatterplotOptions = scatterplotChartOptions;
	this.scatterplotSeries = scatterplotChartSeries;

}

/**
 * modalDemoCtrl - Controller used to run modal view
 * used in Basic form view
 */
function modalDemoCtrl($scope, $modal) {

	$scope.open = function () {

		var modalInstance = $modal.open({
			templateUrl: 'views/modal_example.html',
			controller: ModalInstanceCtrl
		});
	};

	$scope.open1 = function () {
		var modalInstance = $modal.open({
			templateUrl: 'views/modal_example1.html',
			controller: ModalInstanceCtrl
		});
	};

	$scope.open2 = function () {
		var modalInstance = $modal.open({
			templateUrl: 'views/modal_example2.html',
			controller: ModalInstanceCtrl,
			windowClass: "animated fadeIn"
		});
	};

	$scope.open3 = function (size) {
		var modalInstance = $modal.open({
			templateUrl: 'views/modal_example3.html',
			size: size,
			controller: ModalInstanceCtrl
		});
	};

	$scope.open4 = function () {
		var modalInstance = $modal.open({
			templateUrl: 'views/modal_example2.html',
			controller: ModalInstanceCtrl,
			windowClass: "animated flipInY"
		});
	};
};
function ModalInstanceCtrl ($scope, $modalInstance) {
	$scope.ok = function () {
		$modalInstance.close();
	};
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};

	$scope.states = [
		'Alabama',
		'Alaska',
		'Arizona',
		'Arkansas',
		'California',
		'Colorado',
		'Connecticut',
		'Delaware',
		'Florida',
		'Georgia',
		'Hawaii',
		'Idaho',
		'Illinois',
		'Indiana',
		'Iowa',
		'Kansas',
		'Kentucky',
		'Louisiana',
		'Maine',
		'Maryland',
		'Massachusetts',
		'Michigan',
		'Minnesota',
		'Mississippi',
		'Missouri',
		'Montana',
		'Nebraska',
		'Nevada',
		'New Hampshire',
		'New Jersey',
		'New Mexico',
		'New York',
		'North Carolina',
		'North Dakota',
		'Ohio',
		'Oklahoma',
		'Oregon',
		'Pennsylvania',
		'Rhode Island',
		'South Carolina',
		'South Dakota',
		'Tennessee',
		'Texas',
		'Utah',
		'Vermont',
		'Virginia',
		'Washington',
		'West Virginia',
		'Wisconsin',
		'Wyoming'
	];
};

/**
 * ionSlider - Controller for data for Ion Slider plugin
 * used in Advanced plugin view
 */
function ionSlider() {
	this.ionSliderOptions1 = {
		min: 0,
		max: 5000,
		type: 'double',
		prefix: "$",
		maxPostfix: "+",
		prettify: false,
		hasGrid: true
	};
	this.ionSliderOptions2 = {
		min: 0,
		max: 10,
		type: 'single',
		step: 0.1,
		postfix: " carats",
		prettify: false,
		hasGrid: true
	};
	this.ionSliderOptions3 = {
		min: -50,
		max: 50,
		from: 0,
		postfix: "°",
		prettify: false,
		hasGrid: true
	};
	this.ionSliderOptions4 = {
		values: [
			"January", "February", "March",
			"April", "May", "June",
			"July", "August", "September",
			"October", "November", "December"
		],
		type: 'single',
		hasGrid: true
	};
	this.ionSliderOptions5 = {
		min: 10000,
		max: 100000,
		step: 100,
		postfix: " km",
		from: 55000,
		hideMinMax: true,
		hideFromTo: false
	};
}

/**
 * wizardCtrl - Controller for wizard functions
 * used in Wizard view
 */
function wizardCtrl($scope, $rootScope) {
	// All data will be store in this object
	$scope.formData = {};

	// After process wizard
	$scope.processForm = function() {
		alert('Wizard completed');
	};

}

/**
 * chartJsCtrl - Controller for data for ChartJs plugin
 * used in Chart.js view
 */
function chartJsCtrl() {

	/**
	 * Data for Polar chart
	 */
	this.polarData = [
		{
			value: 300,
			color:"#a3e1d4",
			highlight: "#1ab394",
			label: "App"
		},
		{
			value: 140,
			color: "#dedede",
			highlight: "#1ab394",
			label: "Software"
		},
		{
			value: 200,
			color: "#A4CEE8",
			highlight: "#1ab394",
			label: "Laptop"
		}
	];

	/**
	 * Options for Polar chart
	 */
	this.polarOptions = {
		scaleShowLabelBackdrop : true,
		scaleBackdropColor : "rgba(255,255,255,0.75)",
		scaleBeginAtZero : true,
		scaleBackdropPaddingY : 1,
		scaleBackdropPaddingX : 1,
		scaleShowLine : true,
		segmentShowStroke : true,
		segmentStrokeColor : "#fff",
		segmentStrokeWidth : 2,
		animationSteps : 100,
		animationEasing : "easeOutBounce",
		animateRotate : true,
		animateScale : false
	};

	/**
	 * Data for Doughnut chart
	 */
	this.doughnutData = [
		{
			value: 300,
			color:"#a3e1d4",
			highlight: "#1ab394",
			label: "App"
		},
		{
			value: 50,
			color: "#dedede",
			highlight: "#1ab394",
			label: "Software"
		},
		{
			value: 100,
			color: "#A4CEE8",
			highlight: "#1ab394",
			label: "Laptop"
		}
	];

	/**
	 * Options for Doughnut chart
	 */
	this.doughnutOptions = {
		segmentShowStroke : true,
		segmentStrokeColor : "#fff",
		segmentStrokeWidth : 2,
		percentageInnerCutout : 45, // This is 0 for Pie charts
		animationSteps : 100,
		animationEasing : "easeOutBounce",
		animateRotate : true,
		animateScale : false
	};

	/**
	 * Data for Line chart
	 */
	this.lineData = {
		labels: ["January", "February", "March", "April", "May", "June", "July"],
		datasets: [
			{
				label: "Example dataset",
				fillColor: "rgba(220,220,220,0.5)",
				strokeColor: "rgba(220,220,220,1)",
				pointColor: "rgba(220,220,220,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(220,220,220,1)",
				data: [65, 59, 80, 81, 56, 55, 40]
			},
			{
				label: "Example dataset",
				fillColor: "rgba(26,179,148,0.5)",
				strokeColor: "rgba(26,179,148,0.7)",
				pointColor: "rgba(26,179,148,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(26,179,148,1)",
				data: [28, 48, 40, 19, 86, 27, 90]
			}
		]
	};

	this.lineDataDashboard4 = {
		labels: ["January", "February", "March", "April", "May", "June", "July"],
		datasets: [
			{
				label: "Example dataset",
				fillColor: "rgba(220,220,220,0.5)",
				strokeColor: "rgba(220,220,220,1)",
				pointColor: "rgba(220,220,220,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(220,220,220,1)",
				data: [65, 59, 40, 51, 36, 25, 40]
			},
			{
				label: "Example dataset",
				fillColor: "rgba(26,179,148,0.5)",
				strokeColor: "rgba(26,179,148,0.7)",
				pointColor: "rgba(26,179,148,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(26,179,148,1)",
				data: [48, 48, 60, 39, 56, 37, 30]
			}
		]
	};

	/**
	 * Options for Line chart
	 */
	this.lineOptions = {
		scaleShowGridLines : true,
		scaleGridLineColor : "rgba(0,0,0,.05)",
		scaleGridLineWidth : 1,
		bezierCurve : true,
		bezierCurveTension : 0.4,
		pointDot : true,
		pointDotRadius : 4,
		pointDotStrokeWidth : 1,
		pointHitDetectionRadius : 20,
		datasetStroke : true,
		datasetStrokeWidth : 2,
		datasetFill : true
	};

	/**
	 * Options for Bar chart
	 */
	this.barOptions = {
		scaleBeginAtZero : true,
		scaleShowGridLines : true,
		scaleGridLineColor : "rgba(0,0,0,.05)",
		scaleGridLineWidth : 1,
		barShowStroke : true,
		barStrokeWidth : 2,
		barValueSpacing : 5,
		barDatasetSpacing : 1
};

	/**
	 * Data for Bar chart
	 */
	this.barData = {
		labels: ["January", "February", "March", "April", "May", "June", "July"],
		datasets: [
			{
				label: "My First dataset",
				fillColor: "rgba(220,220,220,0.5)",
				strokeColor: "rgba(220,220,220,0.8)",
				highlightFill: "rgba(220,220,220,0.75)",
				highlightStroke: "rgba(220,220,220,1)",
				data: [65, 59, 80, 81, 56, 55, 40]
			},
			{
				label: "My Second dataset",
				fillColor: "rgba(26,179,148,0.5)",
				strokeColor: "rgba(26,179,148,0.8)",
				highlightFill: "rgba(26,179,148,0.75)",
				highlightStroke: "rgba(26,179,148,1)",
				data: [28, 48, 40, 19, 86, 27, 90]
			}
		]
	};

	/**
	 * Data for Radar chart
	 */
	this.radarData = {
		labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
		datasets: [
			{
				label: "My First dataset",
				fillColor: "rgba(220,220,220,0.2)",
				strokeColor: "rgba(220,220,220,1)",
				pointColor: "rgba(220,220,220,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(220,220,220,1)",
				data: [65, 59, 90, 81, 56, 55, 40]
			},
			{
				label: "My Second dataset",
				fillColor: "rgba(26,179,148,0.2)",
				strokeColor: "rgba(26,179,148,1)",
				pointColor: "rgba(26,179,148,1)",
				pointStrokeColor: "#fff",
				pointHighlightFill: "#fff",
				pointHighlightStroke: "rgba(151,187,205,1)",
				data: [28, 48, 40, 19, 96, 27, 100]
			}
		]
	};

	/**
	 * Options for Radar chart
	 */
	this.radarOptions = {
		scaleShowLine : true,
		angleShowLineOut : true,
		scaleShowLabels : false,
		scaleBeginAtZero : true,
		angleLineColor : "rgba(0,0,0,.1)",
		angleLineWidth : 1,
		pointLabelFontFamily : "'Arial'",
		pointLabelFontStyle : "normal",
		pointLabelFontSize : 10,
		pointLabelFontColor : "#666",
		pointDot : true,
		pointDotRadius : 3,
		pointDotStrokeWidth : 1,
		pointHitDetectionRadius : 20,
		datasetStroke : true,
		datasetStrokeWidth : 2,
		datasetFill : true
	};


};


/**
 * nestableCtrl - Controller for nestable list
 */
function nestableCtrl($scope) {
	$scope.remove = function(scope) {
		scope.remove();
	};
	$scope.toggle = function(scope) {
		scope.toggle();
	};
	$scope.moveLastToTheBeginning = function () {
		var a = $scope.data.pop();
		$scope.data.splice(0,0, a);
	};
	$scope.newSubItem = function(scope) {
		var nodeData = scope.$modelValue;
		nodeData.nodes.push({
			id: nodeData.id * 10 + nodeData.nodes.length,
			title: nodeData.title + '.' + (nodeData.nodes.length + 1),
			nodes: []
		});
	};
	$scope.collapseAll = function() {
		$scope.$broadcast('collapseAll');
	};
	$scope.expandAll = function() {
		$scope.$broadcast('expandAll');
	};
	$scope.data = [{
		"id": 1,
		"title": "node1",
		"nodes": [
			{
				"id": 11,
				"title": "node1.1",
				"nodes": [
					{
						"id": 111,
						"title": "node1.1.1",
						"nodes": []
					}
				]
			},
			{
				"id": 12,
				"title": "node1.2",
				"nodes": []
			}
		]
	}, {
		"id": 2,
		"title": "node2",
		"nodes": [
			{
				"id": 21,
				"title": "node2.1",
				"nodes": []
			},
			{
				"id": 22,
				"title": "node2.2",
				"nodes": []
			}
		]
	}, {
		"id": 3,
		"title": "node3",
		"nodes": [
			{
				"id": 31,
				"title": "node3.1",
				"nodes": []
			}
		]
	}];
}

/**
 * codeEditorCtrl - Controller for code editor - Code Mirror
 */
function codeEditorCtrl($scope) {
	$scope.editorOptions = {
		lineNumbers: true,
		matchBrackets: true,
		styleActiveLine: true,
		theme:"ambiance"
	};

	$scope.editorOptions2 = {
		lineNumbers: true,
		matchBrackets: true,
		styleActiveLine: true
	};

}


/**
 * translateCtrl - Controller for translate
 */
function translateCtrl($translate, $scope) {
	$scope.changeLanguage = function (langKey) {
		$translate.use(langKey);
	};
}

function ItemCreationCtrl($scope,$http, $rootScope, processReqService,$location, $state, baseURL) {
	$('.confirm').removeClass('show');
	$('#rootwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#ItemForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#ItemForm").valid();
	  			
	  			if(index==3){
	  				$('.confirm').addClass('show');
	  			}
	  			if(index==1){ 
	  				if(!$valid) { 
	  					return false;
	  				}else{
	  					$('.next.pull-right').addClass('hide');
	  				}
	  				
	  			}
	  			if(!$valid) {
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  			if(index==0 || index==1 || index==2){
	  				$('.next.pull-right').removeClass('hide');
	  			}
	  		}
	  	});
	$http({
      method: "GET",
      url: baseURL.IP+'/category/categoryOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.catagoriesObj = data.entities;
    }).error(function(error){
      $scope.error = error;
    });

 		$scope.categoryData=function(categoryId){
   	$http({
      method: "GET",
      url: baseURL.IP+'/category/'+categoryId+'/subCategoryAndCatAttributes',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
    	$scope.subCategoryObj=[];
    	$scope.categoryAttributesObj=[];
      $.each(data['entities'],function(k,v){
      $.each(v['entities'],function(k1,v1){
      	if(v1['class']=='categoryAttributes'){
      		$scope.categoryAttributesObj.push(v1);
      		console.log($scope.categoryAttributesObj)
      	}
      	if(v1['class']=='subCategory'){
      		$scope.subCategoryObj.push(v1);
      	}
      })
      });
    }).error(function(error){
      $scope.error = error;
    });
    }
    $http({
        method: "GET",
        url: baseURL.IP+'/attributes/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.attributes = data;
       $scope.attributeEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.attributeEntities.push(value);
           // console.log(JSON.stringify($scope.tagtypeEntities));
       })
     }).error(function(error){
        $scope.error = error;
     });

    $scope.onAttributeTabClick=[];
      $scope.attributeCheck=function(data){
      	$scope.onAttributeTabClick.push(data);
      	console.log(JSON.stringify(data));
      }
      $scope.removeAttribute=function(checkedAttributeId){
      	$scope.onAttributeTabClick = $scope.onAttributeTabClick
               .filter(function (el) {
                        return el['properties'].id !== checkedAttributeId;
                       });
               console.log($scope.onAttributeTabClick);
      }
	$http({
      method: "GET",
      url:baseURL.IP+'/tagType/all',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
       $scope.tagtypes = data;
       $scope.itemtagtypeEntities=[];
       $.each(data['entities'],function(key,value){           
        $scope.itemtagtypeEntities.push(value);
       })
     }).error(function(error){
      $scope.error = error;
     });

     $scope.tagType=function(tagTypeId){
     	//alert(tagTypeId);
     	$http({
		      method: "GET",
		      url:baseURL.IP+'/tags/tagType/'+tagTypeId,
		      data: '',
		      headers: {
		           'Content-Type': "application/vnd.siren+json",
		           'Accept': "application/vnd.siren+json"
		        }

		    }).success(function(data) {
		       //$scope.tagtypes = data;
		       $scope.itemtagEntities=[];
		       $.each(data['entities'],function(key,value){           
		        $scope.itemtagEntities.push(value);
		       })
		     }).error(function(error){
		      $scope.error = error;
		     });
     }

     // $scope.subCategoryName=$('.select2-selection__rendered').attr('title');
      $scope.ItemTagsData=[];
      $scope.Itemtags=function($event){
        var ItemTagTypeData={};
        var ItemCheckedTag =$($event.currentTarget).toggleClass('checked');
        var ItemCheckedTagTypeName=$(ItemCheckedTag).attr('data');
        var ItemCheckedTagClass=$(ItemCheckedTag).attr('class');
        var ItemCheckedTagId=$(ItemCheckedTag).attr('id');
        var ItemCheckedTagName=$(ItemCheckedTag).attr('name');
        if(ItemCheckedTagClass=="checked"){
          ItemTagTypeData['id']=ItemCheckedTagId;
          ItemTagTypeData['tagName']=ItemCheckedTagName;
          ItemTagTypeData['tagtypeName']=ItemCheckedTagTypeName;
          if(ItemCheckedTagTypeName=="FoodType"){
          	if($scope.ItemTagsData.length==0){
        		$scope.ItemTagsData.push(ItemTagTypeData);
        		$('.next.pull-right').removeClass('hide');
        	}else{
          		alert("Please Select Only One FoodType");
          	}
          }
          else if(ItemCheckedTagTypeName != "FoodType"){
          	$scope.ItemTagsData.push(ItemTagTypeData);
          	$('.next.pull-right').removeClass('hide');
          }
          
          console.log(JSON.stringify($scope.ItemTagsData));
        }else{
          $scope.ItemTagsData=$scope.ItemTagsData.filter(function(el){
          return el.id !==ItemCheckedTagId;
          });
        }

      }
    $scope.save = function(itemDetails,categoryAttributesId) {
    	// var categoryAttributeData=[];
    	 var ItemTagEntity=[];

    	$.each($scope.onAttributeTabClick,function(k,v){
    		var attrObj={
 			"class": [
 				"itemAttributes"
 			],
 			"rel": [
 				"itemAttributesesRep"
 			],
 			"properties": {
 				"attributesId": v['properties'].attributesId,
 				"attributeValue":v['properties'].attributeValue,
 				"categoryAttributesId": v['properties'].id,
 				"status":"Active",
 				"$siren4j.class": "com.meat.representation.siren.ItemAttributesRepresentation"
 			}

 		}
 		ItemTagEntity.push(attrObj);
    	})
    	$scope.imageShow = true;
        $scope.bytes = {};
        $scope.uploadItemImage = function(el, index) {
          $scope.bytes = el.files[0];
        }
        $scope.saveItemImage=function(){
          var imageType=$scope.bytes.type;
          var imgType=imageType.substring(0,5);
          var formData = new FormData();
          formData.append('file', $scope.bytes);
          if(imgType == "image"){
            $.ajax({
            type: "POST",
            url: '/itemImageUpload',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
            	 $scope.ItemImageDetails=response;
                // console.log(JSON.stringify(response));
                $('.itemPreview').html($scope.ItemImageDetails)
                $scope.imageShow = false;
               
                $scope.$apply();
            },
            error:function(){
                alert("failure");
            }
          });
          }else{
            alert('Please Upload Image');
          }
          
        }
      
      $scope.itemData=angular.copy(itemDetails);
      $scope.itemData['status']="Active";
      $.each($scope.ItemTagsData,function(k,v){
        var itemTagObj={
          "class":[
            "itemTags"
          ],
          "rel":[
            "itemTagsesRep"
          ],
          "properties":{
            "$siren4j.class":"com.meat.representation.siren.ItemTagsRepresentation",
            "itemTagsStatus": "Active",
            "tagsId": v.id
          }
        };
        ItemTagEntity.push(itemTagObj);
      })

      $scope.itemData['$siren4j.class']="com.meat.representation.siren.ItemRepresentation",
      
            $scope.JsonData={
                "class":['item'],
                "rel":['item'],
                "properties":$scope.itemData,
                "entities":ItemTagEntity
            }
            data=$scope.JsonData;
            console.log(JSON.stringify($scope.JsonData));
            processReqService.processReq("/item/create","POST",$scope.JsonData,function(successData){
            	swal({   title: "SUCCESS!",   text: "ITEM CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   $location.path('#/ItemMaster/ItemsTemplate')
                   },function(){
                   	swal({   title: "ERROR!",   text: "ITEM NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     	});
			}
}
function ItemListController($scope, $http, $location, $state, dataTablesInitService, $rootScope, baseURL){
 
	$http({
		method: "GET",
		url: baseURL.IP+'/item/all',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$scope.itemsData=data.entities;                  
	}).error(function(error,statusText,xhr){
    	if(statusText==401){
    		location.reload();
    	}
      $scope.error = error;
    });
	//category Data 
	$http({
		method: "GET",
		url: baseURL.IP+'/category/categoryOnly',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$scope.onlyCategoryData=data.entities;                  
	}).error(function(error){
		$scope.error = error;
	});
	$scope.ItemChange=function(id,name){
		if(name=="ITEM"){
			$('.select2_demo_4').attr('disabled',"disabled");
			$('.select2_demo_5').attr('disabled',"disabled");
			var obj = $(".select2_demo_3").select2("data");
			$.each(obj,function(k,v){
				$scope.itemDetailsName=v.text;
			})
			$state.go('ItemMaster.ItemSingleTemplate',{ itemId: id, itemName: $scope.itemDetailsName  })
		}else if(name=="CATEGORY"){
			$('.select2_demo_3').attr('disabled',"disabled");
			$('.select2_demo_5').attr('disabled',"disabled");
			var obj = $(".select2_demo_4").select2("data");
			$.each(obj,function(k,v){
				$scope.categoryName=v.text;
			})
			$state.go('ItemMaster.CategoryItemsTemplate',{ categoryId: id,CName: $scope.categoryName })
		}else if(name=="BRANCH"){
			$('.select2_demo_4').attr('disabled',"disabled");
			$('.select2_demo_3').attr('disabled',"disabled");
			var obj = $(".select2_demo_5").select2("data");
			$.each(obj,function(k,v){
				$scope.restBranchName=v.text;
			})
			$state.go('ItemMaster.BranchItemsTemplate',{ branchId: id, RBname: $scope.restBranchName })
			
		}
	}
}
function SingleItemController($scope, $http, $stateParams, $state, $modal, $rootScope,baseURL){
	$scope.itemId=$stateParams.itemId;
	$scope.name=$stateParams.itemName;
	$http({
		method: "GET",
		url: baseURL.IP+'/item/itemWithSellerItem/'+$scope.itemId,
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

	}).success(function(data) {
		$scope.singleItemDetails= [];
		$scope.itemAttributesDetails=[];
		$scope.itemTagDetails=[];
		$scope.itemImageDetails=[];
		$scope.branchName=[];
		if(data.entities){
		$.each(data['entities'],function(key,value){
			if(value.class=="item"){
				$scope.itemDetails=value;
			}
			
		$.each(value['entities'],function(k,v){
			if(v.class=="sellerItem"){
			$scope.singleItemDetails.push(v);
			}
			if(v.class=="itemAttributes"){
			$scope.itemAttributesDetails.push(v);
			}
			if(v.class=="itemTag"){
			$scope.itemTagDetails.push(v);
			}
			if(v.class=="itemImage"){
			$scope.itemImageDetails.push(v);
			}
		})
		})
	}
		
	}).error(function(error){
	  $scope.error = error;
	});
	
	$scope.editItem = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/ItemEditTemplate.html',
			controller: ItemEditController
		});
		$rootScope.ItemEditData=data;
	}
	$scope.editItemSeo = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/ItemSeoEditTemplate.html',
			controller: ItemEditController
		});
		$rootScope.ItemEditData=data;
	}
	$scope.editItemAttribute = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/ItemAttributeEditTemplate.html',
			controller: ItemEditController
		});
		$rootScope.ItemEditData=data;
	}
	$scope.additemAttributes=function(id){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/ItemAttributesCreationTemplate.html',
				controller: ItemEditController
			});
			$rootScope.itemCategoryId=id;
		}
		$rootScope.itemId=$scope.itemId;
	$scope.editItemTag = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/ItemTagEditTemplate.html',
			controller: ItemEditController
		});
		$rootScope.ItemEditData=data;
	}
	$rootScope.currentItemId=$stateParams.itemId;
	$scope.additemTags=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/ItemTagCreationTemplate.html',
				controller: ItemEditController
			});
		}
		$rootScope.itemId=$scope.itemId;
		$scope.addSellerBranch=function(id,name){
		$state.go('ItemMaster.SellerItemCreationTemplate',{itemId:id,itemName:name})
	}
}
function ItemEditController($scope, $http, $modalInstance, $rootScope, baseURL, processReqService){

	    $http({
        method: "GET",
        url: baseURL.IP+'/attributes/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.attributes = data;
       $scope.attributeEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.attributeEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });
     if($rootScope.itemCategoryId){
     	$http({
	      method: "GET",
	      url: baseURL.IP+'/category/'+$rootScope.itemCategoryId+'/subCategoryAndCatAttributes',
	      data: '',
	      headers: {
	           'Content-Type': "application/vnd.siren+json",
	           'Accept': "application/vnd.siren+json"
	        }

	    }).success(function(data) {
	    	$scope.attributesDetails=[];
	      $.each(data['entities'],function(k,v){
	      $.each(v['entities'],function(k1,v1){
	      	if(v1['class']=='categoryAttributes'){
	      		$scope.attributesDetails.push(v1);
	      	}
	      })
	      });
	    }).error(function(error){
	      $scope.error = error;
	    });
     }
		
	$http({
      method: "GET",
      url: baseURL.IP+'/subCategory/subCategoryOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
    }).success(function(data) {
      $scope.subCatagories = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    $http({
      method: "GET",
      url: baseURL.IP+'/tagType/tagTypeOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.tagsTypes = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    $scope.tagtypeChange=function(tagTypeId){
    	$http({
      method: "GET",
      url: baseURL.IP+'/tagType/'+tagTypeId,
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
    }).success(function(data) {
      $scope.tags = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    }
	$scope.itemEdit = function (ItemEditData) {
	
	var jsonfile={
    "class": [
        "ItemRepreseantation"
    ],
    "rel": [
        "item"
    ],
    "properties": ItemEditData
    }
        console.log(JSON.stringify(jsonfile));
        processReqService.processReq(baseURL.IP+"/item/"+ItemEditData.id+"/edit","POST",jsonfile,function(){
        	location.reload();
        	$modalInstance.close();
        },function(){});
      	
	};
	$scope.ItemSeoEdit=function(ItemEditData){
		console.log(ItemEditData)
		var jsonfile={
    "class": [
        "ItemRepreseantation"
    ],
    "rel": [
        "item"
    ],
    "properties": ItemEditData
    }
        console.log(JSON.stringify(jsonfile));
        processReqService.processReq(baseURL.IP+"/item/"+ItemEditData.id+"/edit","POST",jsonfile,function(){
        	location.reload();
        },function(){});
      	$modalInstance.close();
	}
	$scope.ItemTagEdit=function(itemTagData){
		$scope.vtags=[];
		$.each(ItemTagData,function(k,v){
			$.each(v.tags,function(ktags,vtags){
				var itemTags={
		            "class": [
		                "itemTags"
		            ],
		            "rel": [
		                "itemTagsesRep"
		            ],
		            "properties": vtags
		        }
		        $scope.vtags.push(ItemTags);
			})
		})
		var jsonfile={
			    "class": [
			        "item"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.ItemRepresentation",
			        "id": $rootScope.itemId
			    },
		    	"entities":$scope.vtags
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/item/"+$rootScope.itemId+"/edit","POST",jsonfile,function(){
			location.reload();
		},function(){});
      	$modalInstance.close();
	}
	$scope.ItemTagCreate=function(itemTags){
		var jsonfile={
			    "class": [
			        "item"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.ItemRepresentation",
			        "id": $rootScope.itemId
			    },
		    	"entities":[
		        {
		            "class": [
		                "itemTag"
		            ],
		            "rel": [
		                "itemTagsesRep"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.ItemTagsRepresentation",
		                "tagsId": itemTags.tagsId,
		                "itemId": $rootScope.itemId,
		                "itemTagsStatus": itemTags.itemTagsStatus
		            }
		        }
        	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/item/"+$rootScope.itemId+"/edit","POST",jsonfile,function(){location.reload();},function(){});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
	$scope.itemattributeEdit=function(ItemAttributeEdit){
		$scope.vattributes=[];
		
		var jsonfile={
			    "class": [
			        "item"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.ItemRepresentation",
			        "id": $rootScope.itemId
			    },
		    	"entities":[
		    	{
		            "class": [
		                "itemAttributes"
		            ],
		            "rel": [
		                "itemAttributesesRep"
		            ],
		            	"properties":ItemAttributeEdit
		        }
		    	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/item/"+$rootScope.itemId+"/edit","POST",jsonfile,function(){location.reload();},function(){});
      	$modalInstance.close();
	}
		$scope.attributesId={};
	$scope.itemAttributeCreate=function(itemAttributes,attributesId){
		
		var jsonfile={
			    "class": [
			        "item"
			    ],
			    "properties": {
			        "$siren4j.class":"com.meat.representation.siren.ItemRepresentation",
			        "id": $rootScope.itemId
			    },
		    	"entities":[
		        {
		            "class": [
		                "itemAttributes"
		            ],
		            "rel": [
		                "itemAttributesesRep"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.ItemAttributesRepresentation",
		                "categoryAttributesId": itemAttributes.categoryAttributesId,
		                "attributesId":attributesId.attributes,
		                "attributeValue":itemAttributes.attributeValue,
		                "status": itemAttributes.status
		            }
		        }
        	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/item/"+$rootScope.itemId+"/edit","POST",jsonfile,function(){location.reload();},function(){});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
}
function ItemImageCreationController($scope, $rootScope, $http, $stateParams, processReqFactory, $state, $location, baseURL){
	$('.confirm').removeClass('show');
	$('#itemwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#itemImageForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#itemImageForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
		method: "GET",
		url: baseURL.IP+'/subCategory/all',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$scope.subCategoryData=data.entities;                  
	}).error(function(error,statusText,xhr){
    	if(statusText==401){
    		location.reload();
    	}
      $scope.error = error;
    });

	$scope.subCategorySelect=function(subCategoryImage){
		 $scope.SubCategoryImageData="";
		$scope.SubCategoryImageData = subCategoryImage;
		$("input[type='file']").val(null);
			 $('.subCategoryPreview').html("")
		// $scope.$apply();
	}
    $scope.imageShow = true;
        $scope.bytes = {};
        $scope.uploadSubCategoryImage = function(el, index) {
          $scope.bytes = el.files[0];
        }
        $scope.saveSubCategoryImage=function(){
          var imageType=$scope.bytes.type;
          var imgType=imageType.substring(0,5);
          var formData = new FormData();
          formData.append('file', $scope.bytes);
          formData.append('subCategoryId', $scope.SubCategoryImageData);
          if(imgType == "image"){
            $.ajax({
            type: "POST",
            url: '/subCategoryImageUpload',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
            	 $scope.SubCategoryImageDetails=response;
                console.log(JSON.stringify(response));
                $('.subCategoryPreview').html($scope.SubCategoryImageDetails)
                $scope.imageShow = false;
               
                $scope.$apply();
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
function SellerItemCreationController($scope, $rootScope, $http, $stateParams, processReqFactory, $state, $location, baseURL){
	$scope.ItemId=$stateParams.itemId;
	$scope.itemName=$stateParams.itemName;
	
	$('.confirm').removeClass('show');
	$('#SellerItemwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#SellerItemForm").valid();

                return false;
        },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#SellerItemForm").valid();
	  			
	  			if(index==2){
	  				$('.confirm').addClass('show');
	  			}
	  			if(index==1){
	  				$('.next.pull-right').addClass('show');
	  			}
	  			if(!$valid) {
	  			
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==0 || index==1){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
      method: "GET",
      url: baseURL.IP+'/seller/sellerOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.sellersObj = data.entities;
    }).error(function(error){
      $scope.error = error;
    });

 		$scope.sellerData=function(sellerId){
   	$http({
      method: "GET",
      url: baseURL.IP+'/sellerBranch/seller/'+sellerId+'/sellerBranchOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
    	$scope.sellerBranchObj=data.entities;
    }).error(function(error){
      $scope.error = error;
    });

    var obj=$('.select2_demo_1').select2('data');
    	$.each(obj,function(k,v){
    		$scope.sellerName=v.text;
    	})
    }
    
    $scope.sellerBranch=function(){
    	var obj=$('.select2_demo_2').select2('data');
    	$.each(obj,function(k,v){
    		$scope.branchName=v.text;
    	})
    }
    $http({
	    method: "GET",
	    url: baseURL.IP+'/cutType/all',
	    data: '',
	    headers: {
	           'Content-Type': "application/vnd.siren+json",
	           'Accept': "application/vnd.siren+json"
	        }

		}).success(function(data) {
	   	$scope.cutTypeEntities=[];
	   	$.each(data['entities'],function(key,value){         
	        $scope.cutTypeEntities.push(value);
	   	})
	 	}).error(function(error){
	    $scope.error = error;
	 	});
	
	$scope.sellerTimeDetails=[];
	$scope.Itemtimngs=function(name,id,starttime,endtime,$event){
	var checkedItemTime = $($event.currentTarget).toggleClass('checked');
	var checkedItemClass=$(checkedItemTime).attr('class');
	var checkedTimingId=$(checkedItemTime).attr('data');
	if(checkedItemClass=="col-xs-7 content no-top-border checked"){
	  $scope.sellerTimeDetails.push({
	  "startTime":starttime,
	  "endTime":endtime,
	  "timingName":name,
	  "timingDetailsId":id
	  });
	  $('.col-xs-7.content.no-top-border.checked').addClass('navy-bg');
	  $('.next.pull-right').removeClass('hide');
	}else{
	      $scope.sellerTimeDetails = $scope.sellerTimeDetails
	           .filter(function (el) {
	                    return el.timingDetailsId !== checkedTimingId;
	                   });
	           console.log($scope.sellerTimeDetails);
	           $('.next.pull-right').addClass('hide');
	           $('.col-xs-7.content.no-top-border').removeClass('navy-bg');
	           $('.col-xs-7.content.no-top-border.checked').addClass('navy-bg');
		}
	}
	$scope.SellerItemImagePathData=[];
    $scope.itemThumbImage1={imageType:"80X61(1)"};
    $scope.itemThumbImage2={imageType:"80X61(2)"};
    $scope.itemThumbImage3={imageType:"80X61(3)"};
    $scope.itemThumbImage4={imageType:"80X61(4)"};
    $scope.itemNormalImage5={imageType:"360X360(1)"};
    $scope.itemNormalImage6={imageType:"360X360(2)"};
    $scope.itemNormalImage7={imageType:"360X360(3)"};
    $scope.itemNormalImage8={imageType:"360X360(4)"};
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
          if(imgType == "image"){
            //$scope.categoryThumbImage={};
            $.ajax({   
            type: "POST",
            url: '/upload/uploadFile',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
                //alert(response);
                console.log(JSON.stringify(response));
                if(el.name=="itemImageThumb1"){
                  $scope.itemThumbImage1['itemImageThumb1']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemThumbImage1);
                  $('.itemImgPath1').html('<img src="'+$scope.itemThumbImage1['itemImageThumb1']+'" alt="imageLocationParallax" width="100%" height="100px" />');
                }else if(el.name=="itemImageThumb2"){
                  $scope.itemThumbImage2['itemImageThumb2']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemThumbImage2);
                  $('.itemImgPath2').html('<img src="'+$scope.itemThumbImage2['itemImageThumb2']+'" alt="imageLocationParallax" width="100%" height="100px" />');
                }else if(el.name=="itemImageThumb3"){
                  $scope.itemThumbImage3['itemImageThumb3']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemThumbImage3);
                  $('.itemImgPath3').html('<img src="'+$scope.itemThumbImage3['itemImageThumb3']+'" alt="imageLocationParallax" width="100%" height="100px" />');
                }else if(el.name=="itemImageThumb4"){
                  $scope.itemThumbImage4['itemImageThumb4']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemThumbImage4);
                  $('.itemImgPath4').html('<img src="'+$scope.itemThumbImage4['itemImageThumb4']+'" alt="imageLocationParallax" width="100%" height="100px" />');
                }else if(el.name=="itemImageNormal5"){
                  $scope.itemNormalImage5['itemImageNormal5']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemNormalImage5);
                  $('.itemImgPath5').html('<img src="'+$scope.itemNormalImage5['itemImageNormal5']+'" alt="imageLocationThumb"  width="100%" height="100px"/>');
                }else if(el.name=="itemImageNormal6"){
                  $scope.itemNormalImage6['itemImageNormal6']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemNormalImage6);
                  $('.itemImgPath6').html('<img src="'+$scope.itemNormalImage6['itemImageNormal6']+'" alt="imageLocationThumb"  width="100%" height="100px"/>');
                }else if(el.name=="itemImageNormal7"){
                  $scope.itemNormalImage7['itemImageNormal7']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemNormalImage7);
                  $('.itemImgPath7').html('<img src="'+$scope.itemNormalImage7['itemImageNormal7']+'" alt="imageLocationThumb"  width="100%" height="100px"/>');
                }else if(el.name=="itemImageNormal8"){
                  $scope.itemNormalImage8['itemImageNormal8']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemNormalImage8);
                  $('.itemImgPath8').html('<img src="'+$scope.itemNormalImage8['itemImageNormal8']+'" alt="imageLocationThumb"  width="100%" height="100px"/>');
                }else if(el.name=="itemMainImage"){
                  $scope.itemMainImage['itemMainImage']=response.replace(/\\/g,"/");
                  $scope.SellerItemImagePathData.push($scope.itemMainImage);
                  $('.itemMainImgPath').html('<img src="'+$scope.itemMainImage['itemMainImage']+'" alt="imageLocationThumb"  width="100%" height="100px"/>');
                }
              
                console.log(JSON.stringify($scope.SellerItemImagePathData));
            },
            error:function(){
                alert("failure");
            }
          });
          }else{
            alert('Please Upload Image');
          }
          
        }
			$scope.cutTypeChange=function(){
	    	$rootScope.cutType=[];
	    	var obj = $(".select2_demo_3").select2("data");
				$.each(obj,function(k,v){
				var cutTypeData={};
				cutTypeData['cutTypeName']=v.text;
				$rootScope.cutType.push(cutTypeData);
				})
				var cutTypeobj = "";
				for (var i in $rootScope.cutType){
					cutTypeobj = cutTypeobj+","+$rootScope.cutType[i].cutTypeName;
				}
				var cutTypeSimplifyData= cutTypeobj;
					$rootScope.cutType =cutTypeSimplifyData.replace(/^,/,'');
				console.log(JSON.stringify($rootScope.cutType));
	    	} 

       $scope.sellerSubmit=function(sellerDetails){
       	console.log(sellerDetails);

        $scope.sellerMaster=angular.copy(sellerDetails);
        $scope.sellerMaster['$siren4j.class']="com.meat.representation.siren.SellerItemRepresentation",
        $scope.sellerMaster['itemId']=$scope.ItemId;
        $scope.sellerMaster['cutTypes']=$rootScope.cutType;
        $scope.sellerMaster['sellerItemName']=$stateParams.itemName;
        $scope.sellerMaster['marketPrice']=$scope.sellerDetails['marketPrice']+'';
        $scope.sellerMaster['sellingPrice']=$scope.sellerDetails['sellingPrice']+'';
        $scope.sellerMaster['quantity']=$scope.sellerDetails['quantity']+'';
        $scope.jsonfile = 
             {
               "class":["sellerItem"],
               "rel": ["item"],
               "properties":$scope.sellerMaster
             }
         data=$scope.jsonfile;
         console.log(JSON.stringify($scope.jsonfile));

       processReqFactory.processReq("/sellerItem/create","POST",data,function(response){
       	if(response['properties'].itemExistsStatus=="DUPLICATE"){
       		swal({   title: "Exist!",   text: response['properties'].itemAvailableStatus,   type: "warning",   confirmButtonText: "Success" });
       	}else{
       		swal({   title: "SUCCESS!",   text: "success",   type: "success",   confirmButtonText: "Success" });
       		$location.path('#/ItemMaster/ItemsTemplate')
       	}
       },function(){
       	swal({   title: "ERROR!",   text: "ITEM NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
       });
      };   
}
function CategoryItemsListController($scope, $http ,dataTablesInitService ,$stateParams,baseURL){
	$scope.categoryName=$stateParams.CName;
	//category Data 
	$http({
		method: "GET",
		url: baseURL.IP+'/category/categoryOnly',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$scope.onlyCategoryData=data.entities;                  
	}).error(function(error){
		$scope.error = error;
	});
	$http({
				method: "GET",
				url: baseURL.IP+'/item/category/'+$stateParams.categoryId+'/itemOnly',
				data: '',
				headers: {
					   'Content-Type': "application/vnd.siren+json",
					   'Accept': "application/vnd.siren+json"
					},

			}).success(function(data) {
			 
				     var columns = [
            { "data": "properties.itemName" },
            { "data": "properties.categoryName" },
            { "data": "properties.subCategoryName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/ItemMaster/Item/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
				dataTablesInitService.initDataTables(data['entities'],columns,'#itemsTable');
				$scope.itemViewTable=true;
				$scope.restItemViewTable=false; 
				}).error(function(error){
				$scope.error = error;
			});
		$scope.categoryItemChange=function(categoryid){
			var obj = $(".select2_demo_4").select2("data");
				$.each(obj,function(k,v){
				$scope.categoryName=v.text;
			})
			$http({
				method: "GET",
				url: baseURL.IP+'/item/category/'+categoryid+'/itemOnly',
				data: '',
				headers: {
					   'Content-Type': "application/vnd.siren+json",
					   'Accept': "application/vnd.siren+json"
					},

			}).success(function(data) {
				
				     var columns = [
            { "data": "properties.itemName" },
            { "data": "properties.categoryName" },
            { "data": "properties.subCategoryName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/ItemMaster/Item/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
				dataTablesInitService.initDataTables(data['entities'],columns,'#itemsTable');
				$scope.itemViewTable=true;
				$scope.restItemViewTable=false; 
				$('div#itemsTable').removeAttr('id');                
			}).error(function(error){
				$scope.error = error;
			});
		}
}
function SellerBranchtItemsListController($scope, $http, $stateParams, dataTablesInitService, $rootScope,baseURL){
	$scope.sellerBranchName=$stateParams.SBname;
	//RestaurantBranch Data 
	$http({
		method: "GET",
		url: baseURL.IP+'/sellerBranch/all/sellerBranchOnly',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$rootScope.onlySellerBranchData=data.entities;                  
	}).error(function(error){
		$scope.error = error;
	});
	$http({
		method: "GET",
		url: baseURL.IP+'/item/sellerBranch/'+$stateParams.branchId,
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		
		     var columns = [
    { "data": "properties.itemName" },
    { "data": "properties.categoryName" },
    { "data": "properties.subCategoryName" },
    { "data": "properties.status" },
    { "data": "properties.id",
        "orderable": false,
        "searchable": false,   
        "render": function(data,type,row,meta) {
                    var a = '<a href="#/ItemMaster/Item/'+data+'">View</a>'
                    return a;
                  }
             }
        ];
				dataTablesInitService.initDataTables(data['entities'],columns,'#branchTable');
				                 
			}).error(function(error){
				$scope.error = error;
			});
			$scope.BranchItemChange=function(branchid){
				var obj = $(".select2_demo_5").select2("data");
				$.each(obj,function(k,v){
				$scope.sellerBranchName=v.text;
				})
				$http({
				method: "GET",
				url: baseURL.IP+'/item/sellerBranch/'+branchid,
				data: '',
				headers: {
					   'Content-Type': "application/vnd.siren+json",
					   'Accept': "application/vnd.siren+json"
					},

			}).success(function(data) {
				
				     var columns = [
            { "data": "properties.itemName" },
            { "data": "properties.categoryName" },
            { "data": "properties.subCategoryName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/ItemMaster/Item/'+data+'">View</a>'
                            return a;
                          }
             		}
        	];
			dataTablesInitService.initDataTables(data['entities'],columns,'#branchTable');
				                
			}).error(function(error){
				$scope.error = error;
			});
			}
}
function CategoryCreationController($scope, $http, $rootScope, processReqService, $location,baseURL){
	$('.confirm').removeClass('show');
	$('#categorywizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#categoryForm").valid();

                return false;
        	},
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#categoryForm").valid();
	  			
	  			if(index==3){
	  				$('.confirm').addClass('show');
	  			}
	  			if(index==1){ 
	  				if(!$valid) { 
	  					return false;
	  				}else{
	  					$('.next.pull-right').addClass('hide');
	  				}
	  				
	  			}
	  			if(!$valid) {
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  			if(index==0 || index==1 || index==2){
	  				$('.next.pull-right').removeClass('hide');
	  			}
	  		}
	  	});
	
$http({
        method: "GET",
        url: baseURL.IP+'/attributes/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.attributes = data;
       $scope.attributeEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.attributeEntities.push(value);
          
       })
     }).error(function(error){
        $scope.error = error;
     });
     $scope.onAttributeTabClick=[];
      $scope.attributeCheck=function($event){
        var AttributeTabData={};
        var checkedAttributes = $($event.currentTarget).toggleClass('checked');
        var checkedAttributeclass = $(checkedAttributes).attr('class');
        var checkedAttributeId = $(checkedAttributes).attr('id');
        var checkedAttributeName = $(checkedAttributes).attr('name');
        var CheckedAttributeName=$(checkedAttributes).attr('data');
        if(checkedAttributeclass=="checked"){
          AttributeTabData['id']=checkedAttributeId;
          AttributeTabData['attributeName']=checkedAttributeName;
          $scope.onAttributeTabClick.push(AttributeTabData);
          console.log(JSON.stringify($scope.onAttributeTabClick));
          $('.next.pull-right').removeClass('hide');
        }else{
          $scope.onAttributeTabClick = $scope.onAttributeTabClick
               .filter(function (el) {
                        return el.id !== checkedAttributeId;
                       });
               console.log($scope.onAttributeTabClick);
        }
      }

    $http({
        method: "GET",
        url: baseURL.IP+'/tagType/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.tagtypes = data;
       $scope.tagtypeEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.tagtypeEntities.push(value);
       });
     }).error(function(error){
        $scope.error = error;
     });
   $http({
        method: "GET",
        url: baseURL.IP+'/criteria/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.criteriaEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.criteriaEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });

    $scope.oncriteriaTabClick=[];
      $scope.criteriaCheck=function(data){
      	$scope.oncriteriaTabClick.push(data);
      	console.log(JSON.stringify(data));
      }
      $scope.removeCriteria=function(checkedCriteriaId){
      	$scope.oncriteriaTabClick = $scope.oncriteriaTabClick
               .filter(function (el) {
                        return el['properties'].id !== checkedCriteriaId;
                       });
               console.log($scope.oncriteriaTabClick);
      }
      $scope.onTagTabClick=[];
      $scope.checkbox=function($event){
        var TagTabData={};
        var checkedTags = $($event.currentTarget).toggleClass('checked');
        var checkedTagclass = $(checkedTags).attr('class');
        var checkedTagId = $(checkedTags).attr('id');
        var checkedTagName = $(checkedTags).attr('name');
        var checkedTagTypeName = $(checkedTags).attr('data');
        if(checkedTagclass=="checked"){
          TagTabData['id']=checkedTagId;
          TagTabData['tagName']=checkedTagName;
          TagTabData['tagTypeName']=checkedTagTypeName;
          if(checkedTagTypeName=="FoodType" && $scope.onTagTabClick.length==0){
        		$scope.onTagTabClick.push(TagTabData);
        		$('.next.pull-right').removeClass('hide');
          }
          else if(checkedTagTypeName != "FoodType"){
          	$scope.onTagTabClick.push(TagTabData);
          	$('.next.pull-right').removeClass('hide');
          }
          else{
          	alert("Please Select Only One FoodType");
          }
          console.log(JSON.stringify($scope.onTagTabClick));
        }else{
          $scope.onTagTabClick = $scope.onTagTabClick
               .filter(function (el) {
                        return el.id !== checkedTagId;
                       });
               console.log($scope.onTagTabClick);
        }
      }
      $rootScope.CategoryImagePathData=[];
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
          formData.append('folder', 'Category');
          if(imgType == "image"){
            //$scope.categoryThumbImage={};
            $.ajax({
            type: "POST",
            url: '/upload/uploadFile',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
                //alert(response);
            console.log(JSON.stringify(response));
            if(el.name=="imageLocationParallax"){
              $scope.categoryParallaxImage['imageLocationParallax']=response.replace(/\\/g,"/");
              $rootScope.CategoryImagePathData.push($scope.categoryParallaxImage);
              $('.imgPath').html('<img src="'+$scope.categoryParallaxImage['imageLocationParallax']+'" alt="imageLocationParallax" width="100%" height="70px" />');
            }
            else if(el.name=="imageLocationThumb"){
              $scope.categoryNormalImage['imageLocationThumb']=response.replace(/\\/g,"/");
              $rootScope.CategoryImagePathData.push($scope.categoryNormalImage);
              $('.imgPath1').html('<img src="'+$scope.categoryNormalImage['imageLocationThumb']+'" alt="imageLocationThumb" width="100%" height="70px"/>');
            }
              
            },
            error:function(){
                alert("failure");
            }
          });
          }else{
            alert('Please Upload Image');
          }
          
        }
			$scope.save = function(category) {
        var categoryEntities=[];
        $scope.master = angular.copy(category);
        $.each($scope.onTagTabClick,function(k,v){
          var tagObj=
          {
            "class": [
                "categoryTags"
            ],
            "rel": [
                "categoryTagsRep"
            ],
            "properties": {
                "$siren4j.class": "com.meat.representation.siren.CategoryTagsRepresentation",
                "categoryTagsStatus": "Active",
                "tagsId": v.id
            }
        };
        categoryEntities.push(tagObj);

        })
        $.each($scope.oncriteriaTabClick,function(k,v){
          var criteriaObj={
            "class": [
                "categoryCriteria"
            ],
            "rel": [
                "categoryCriteriaRep"
            ],
            "properties": {
                "criteriaId": v['properties'].id,
                "criteriaValue":v['properties'].criteriaValue,
                "status": "ACTIVE",
                "$siren4j.class": "com.meat.representation.siren.CategoryCriteriaRepresentation"
            }
        };
         categoryEntities.push(criteriaObj);
        })

          $.each($scope.onAttributeTabClick,function(k,v){
          var attributeObj={
            "class": [
                "categoryAttributes"
            ],
            "rel": [
                "categoryAttributesRep"
            ],
            "properties": {
                "$siren4j.class": "com.meat.representation.siren.CategoryAttributesRepresentation",
                "attributesId": v.id,
                "status": "ACTIVE"
            }
        };
         categoryEntities.push(attributeObj);
        })
        $.each($rootScope.CategoryImagePathData,function(kimg,vimg){
          if(vimg.imageLocationParallax){
            var imgLocation=vimg.imageLocationParallax;
          }else{
            var imgLocation=vimg.imageLocationThumb
          }
        var imgObj={
          "class":[
              "categoryImages"
          ],
          "rel":[
              "categoryImagesRep"
          ],
          "properties":{
            "$siren4j.class":"com.meat.representation.siren.CategoryImagesRepresentation",
            "imageName":vimg.imageName+'',
            "imageType":vimg.imageType+'',
            "imageLocation":imgLocation+''
          }
        };
        categoryEntities.push(imgObj);
      })
      
        $scope.master["$siren4j.class"]= "com.meat.representation.siren.CategoryRepresentation",
        $scope.jsonfile = 
                     {
                       "class":["category"],
                       "rel": ["item"],
                       "properties": $scope.master,
                       "entities":categoryEntities
                     }
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));

                   processReqService.processReq("/category/create","POST",data,function(){
                   	
                   swal({   title: "SUCCESS!",   text: "CATEGORY CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	$location.path('#/ItemMaster/CategoryTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "CATEGORY NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     	});
      };
}
function CategoryListController($scope, $http, dataTablesInitService,baseURL){
	$http({
		method: "GET",
		url: baseURL.IP+'/category/all',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

	}).success(function(data) {
		         var columns = [
		    { "data": "properties.categoryName" },
		    { "data": "properties.status" },
		    { "data": "properties.id",
		        "orderable": false,
		        "searchable": false,
		        "render": function(data,type,row,meta) {
		                    var a = '<a href="#/ItemMaster/Category/'+row.properties.categoryName+'/'+data+'">View</a>'
		                    return a;
		                  }
		     }
		];
		dataTablesInitService.initDataTables(data['entities'],columns,'#categoryTable');
		 }).error(function(error){
			$scope.error = error;
		 });
}
function SingleCategoryController($scope,$http,$stateParams, $modal, $rootScope, baseURL,processReqService){
	$scope.name=$stateParams.categoryName;
     $scope.categoryId=$stateParams.categoryId;

    $http({
        method: "GET",
        url: baseURL.IP+'/category/'+$scope.categoryId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
           $scope.singleCategoryDetails = data;
           $scope.categoryItemDetails=[];
           $scope.categoryTagDetails=[];
           $scope.categoryImageDetails=[];
           $scope.categoryAttributesDetails=[];
           $scope.categoryCriteriaDetails=[];
           $scope.categorysubDetails=[];
           $scope.categoryCutTypeDetails=[];
           $.each($scope.singleCategoryDetails['entities'],function(kcat,vcat){
              $scope.categoryDetails=vcat;
            if(vcat.class=="item"){
              $scope.categoryItemDetails.push(vcat);
            }
            if(vcat.class=="categoryAttributes"){
            	$scope.categoryAttributesDetails.push(vcat);
            }
            if(vcat.class=="categoryCriteria"){
            	$scope.categoryCriteriaDetails.push(vcat);
            }
            if(vcat.class=="categoryTag"){
              $scope.categoryTagDetails.push(vcat);
            }
            if(vcat.class=="categoryCutType"){
              $scope.categoryCutTypeDetails.push(vcat);
            }
            if(vcat.class=="categoryImage"){
              $scope.categoryImageDetails.push(vcat.properties);
            }
            if(vcat.class=='subCategory'){
            	$scope.categorysubDetails.push(vcat.properties)
            }
            
           });
				}).error(function(error){

            $scope.error = error;
         });

		$scope.editCategory = function (data) {
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryEditTemplate.html',
				controller: CategoryEditController
			});
			$rootScope.CategoryEditData=data;
		}
		$scope.editCategoryAttribute = function (data) {
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryAttributeEditTemplate.html',
				controller: CategoryEditController
			});
			$rootScope.CategoryAttributeEdit=data;
		}
		$scope.editCategorySeo=function(data){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategorySeoEditTemplate.html',
				controller: CategoryEditController
			});
			$rootScope.CategoryEditData=data;
		}
		$scope.editCategoryTag=function(data){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryTagsEditTemplate.html',
				controller: CategoryEditController
			});
			$rootScope.CategoryEditData=data;
		}
		$scope.addCategoryTags=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryTagsCreationTemplate.html',
				controller: CategoryEditController
			});
		}
		$rootScope.categoryId=$scope.categoryId;
		$scope.addCategoryAttributes=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryAttributesCreationTemplate.html',
				controller: CategoryEditController
			});
		}
		$scope.editCategoryCriteria = function (data) {
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryCriteriaEditTemplate.html',
				controller: CategoryEditController
			});
			$rootScope.CriteriaEditData=data;
		}
		$rootScope.categoryId=$scope.categoryId;
		$scope.addCategoryCutTypes=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryCutTypesCreationTemplate.html',
				controller: CategoryEditController
			});
		}
		$scope.editCategoryCutType = function(data) {
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryCutTypeEditTemplate.html',
				controller:CategoryEditController
			});
			$rootScope.CategoryCutTypeEdit= data;
		}
		$rootScope.categoryId=$scope.categoryId;
		$scope.addCategoryCriteria=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CategoryCriteriaCreationTemplate.html',
				controller: CategoryEditController
			});
		}

		$scope.categoryCutTypeDeleteDetails=function(cutTypeId){
			$scope.categoryCutTypeDetails=$scope.categoryCutTypeDetails.filter(function(el){
		  		return el['properties'].id !==cutTypeId['properties'].id;
		  	});
		  	console.log(cutTypeId)
		  	delete cutTypeId['links'];
		  	processReqService.processReq(baseURL.IP+"/categoryCutType/"+cutTypeId['properties'].id+"/delete","GET",cutTypeId,function(){

		  	},function(){

		  	});
		}
}
function CategoryEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
		
		$http({
		method: "GET",
		url: baseURL.IP+'/criteria/all',
		data: '',
		headers: {
				 'Content-Type': "application/vnd.siren+json",
				 'Accept': "application/vnd.siren+json"
			}

	}).success(function(data) {
			$scope.categoryCriteriaDetails = data.entities;
	 }).error(function(error){

		$scope.error = error;
	 });
		$http({
		method: "GET",
		url: baseURL.IP+'/attributes/all',
		data: '',
		headers: {
				 'Content-Type': "application/vnd.siren+json",
				 'Accept': "application/vnd.siren+json"
			}

	}).success(function(data) {
			$scope.attributesDetails = data.entities;
	 }).error(function(error){

		$scope.error = error;
	 });
	 $http({
		method: "GET",
		url: baseURL.IP+'/cutType/all',
		data: '',
		headers: {
				 'Content-Type': "application/vnd.siren+json",
				 'Accept': "application/vnd.siren+json"
			}

	}).success(function(data) {
			$scope.cutTypeDetails = data.entities;
	 }).error(function(error){

		$scope.error = error;
	 });
	 
	$http({
      method: "GET",
      url: baseURL.IP+'/tagType/tagTypeOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.tagsTypes = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    $scope.tagtypeChange=function(tagTypeId){
    	$http({
      method: "GET",
      url: baseURL.IP+'/tagType/'+tagTypeId,
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.tags = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
	}
	$scope.categoryEdit = function (CategoryEditData) {
		var jsonfile={
				    "class": [
				        "category"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":CategoryEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+CategoryEditData.id+"/edit","POST",jsonfile,function(){
		 	location.reload();},function(){});
		$modalInstance.close();
		
	};
	$scope.categorySeoEdit=function(CategoryEditData){
		var jsonfile={
				    "class": [
				        "category"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":CategoryEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+CategoryEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});
		$modalInstance.close();
		
	}
	$scope.CategoryTagEdit=function(CategoryEditData){
		$scope.vtags=[];
		
		var jsonfile={
			    "class": [
			        "category"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":CategoryEditData
		    	
		    	
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",jsonfile,function(){
			$modalInstance.close();
			location.reload();
		},function(){});
      	$modalInstance.close();
	}
	$scope.CategoryTagCreate=function(categoryTags){
		var jsonfile={
			    "class": [
			        "category"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":[
		        {
		            "class": [
		                "categoryTag"
		            ],
		            "rel": [
		                "categoryTagsRep"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.CategoryTagsRepresentation",
		                "tagsId": categoryTags.tagsId,
		                "categoryId": $rootScope.categoryId,
		                "categoryTagsStatus": categoryTags.categoryTagsStatus
		            }
		        }
        	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",jsonfile,function(){location.reload()},function(){});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
	$scope.categoryattrEdit=function(CategoryAttributeEdit){
		$scope.vattributes=[];
		
		var jsonfile={
			    "class": [
			        "category"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":[CategoryAttributeEdit]
		    	
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",jsonfile,function(){location.reload()},function(){});
      	$modalInstance.close();
		// console.log(JSON.stringify(categoryTagsData));
	}
	$scope.CategoryAttributeCreate=function(categoryAttributes){
		var jsonfile={
			    "class": [
			        "category"
			    ],
			    "properties": {
			        "$siren4j.class":"com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":[
		        {
		            "class": [
		                "categoryAttributes"
		            ],
		            "rel": [
		                "categoryAttributesRep"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.CategoryAttributesRepresentation",
		                "attributesId": categoryAttributes.attributesId,
		                "status": categoryAttributes.status
		            }
		        }
        	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",jsonfile,function(){location.reload()},function(){});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
	$scope.categoryCutTypeEdit = function (CategoryCutTypeEdit) {
		$scope.vcutType=[];
		
			delete CategoryCutTypeEdit['links'];
		console.log(JSON.stringify(CategoryCutTypeEdit));
		processReqService.processReq(baseURL.IP+"/categoryCutType/"+CategoryCutTypeEdit['properties'].id+"/edit","POST",CategoryCutTypeEdit,function(){
		 	location.reload();},function(){});
	};
	$scope.categoryCriteriaCreate=function(categoryCriteria){
		var jsonfile={
			    "class": [
			        "category"
			    ],
			    "properties": {
			        "$siren4j.class":"com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":[
		        {
		             "class": [
    						"categoryCriteria"
  							],
   					"rel":  [
    						"categoryCriteriaRep"
   							],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.CategoryCriteriaRepresentation",
		                "criteriaId":categoryCriteria.id,
		                 "categoryId": $rootScope.categoryId,
		                "criteriaValue":categoryCriteria.criteriaValue,
		                "status":categoryCriteria.status
		            }
		        }
        	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",jsonfile,function(){location.reload()},function(){});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
		$scope.CategoryCriteriaEdit=function(CriteriaEditData){
		$scope.v=[];
		var jsonfile={
			    "class": [
			        "category"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":[CriteriaEditData]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",jsonfile,function(){
			swal({   title: "SUCCESS!",   text: "CRITERIA EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
     	location.reload()
     },function(){
     	swal({ 	title: "ERROR!",   text: "CRITERIA NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
       	});
      	$modalInstance.close();
	}


		$scope.cutTypeChange=function(cutDatatype){
	 	$scope.cutTypeObj=[];
	 	var cutType = cutDatatype;
	 // 	var obj = $(".select2_demo_3").select2("data");
		$.each(cutType,function(k,v){

			var cutTypeJsonObj = {
        "class": [
					"categoryCutType"
					],
				"rel":  [
					"categoryCutTypeRep"
						],
          "properties": {
          	"cutTypeId":v,
          	"status": "ACTIVE",
          	"$siren4j.class": "com.meat.representation.siren.CategoryCutTypeRepresentation",
          	"categoryId":$rootScope.categoryId}
      }
		// cutTypeData['cutTypeName']=v.text;
		$scope.cutTypeObj.push(cutTypeJsonObj);
		})
		console.log(JSON.stringify($scope.cutTypeObj));
    	}
	$scope.categoryCutTypeCreate=function(cutType){
		var cutTypeObj=angular.copy(cutType)
		cutTypeObj['$siren4j.class']="com.meat.representation.siren.CategoryCutTypeRepresentation";
		var cutTypeObj={
			    "class": [
			        "category"
			    ],
			    "rel":[
			    	"item"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.CategoryRepresentation",
			        "id": $rootScope.categoryId
			    },
		    	"entities":$scope.cutTypeObj
		}
		console.log(JSON.stringify(cutTypeObj));
		processReqService.processReq(baseURL.IP+"/category/"+$rootScope.categoryId+"/edit","POST",cutTypeObj,function(){location.reload()},function(){});
      	$modalInstance.close();
	}
	
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	}
}
function SubCategoryCreationController($scope, $http, $location, processReqService, $stateParams, baseURL){
	if($stateParams.categoryId){
		$('.select2_demo_4').select2({ templateSelection :$stateParams.categoryId});
	}
	$('.confirm').removeClass('show');
	$('#subcategorywizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#subcategoryForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#subcategoryForm").valid();
	  			
	  			if(index==3){
	  				$('.confirm').addClass('show');
	  			}
	  			if(index==1){
	  				if(!$valid) {
	  					return false;
	  				}else{
	  				$('.next.pull-right').addClass('hide');
	  				}
	  			}
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
      method: "GET",
      url: baseURL.IP+'/category/all',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.catagories = data;
    }).error(function(error){
      $scope.error = error;
    });
    //Tags Assigning
    $http({
        method: "GET",
        url: baseURL.IP+'/tagType/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.tagtypes = data;
       $scope.tagtypeEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.tagtypeEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });
     // Attributes data
     $http({
        method: "GET",
        url: baseURL.IP+'/attributes/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.attributes = data;
       $scope.attributeEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.attributeEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });
     
     $scope.onTagTabClick=[];
      $scope.checkbox=function($event){
        var TagTabData={};
        var checkedTags = $($event.currentTarget).toggleClass('checked');
        var checkedTagclass = $(checkedTags).attr('class');
        var checkedTagId = $(checkedTags).attr('id');
        var checkedTagName = $(checkedTags).attr('name');
        var CheckedTagTypeName=$(checkedTags).attr('data');
        if(checkedTagclass=="checked"){
          TagTabData['id']=checkedTagId;
          TagTabData['tagName']=checkedTagName;
          TagTabData['tagtypeName']=CheckedTagTypeName;
          $scope.onTagTabClick.push(TagTabData);
          console.log(JSON.stringify($scope.onTagTabClick));
          $('.next.pull-right').removeClass('hide');
        }else{
          $scope.onTagTabClick = $scope.onTagTabClick
               .filter(function (el) {
                        return el.id !== checkedTagId;
                       });
               console.log($scope.onTagTabClick);
        }
      }
      $scope.imageShow = true;
        $scope.bytes = {};
        $scope.uploadSubCategoryImage = function(el, index) {
          $scope.bytes = el.files[0];
        }
        $scope.saveSubCategoryImage=function(){
          var imageType=$scope.bytes.type;
          var imgType=imageType.substring(0,5);
          var formData = new FormData();
          formData.append('file', $scope.bytes);
          if(imgType == "image"){
            $.ajax({
            type: "POST",
            url: '/subCategoryImageUpload',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
            	 $scope.SubCategoryImageDetails=response;
                console.log(JSON.stringify(response));
                $('.subCategoryPreview').html($scope.SubCategoryImageDetails)
                $scope.imageShow = false;
               
                $scope.$apply();
            },
            error:function(){
                alert("failure");
            }
          });
          }else{
            alert('Please Upload Image');
          }
          
        }

        $scope.save = function(category) {
        var categoryEntities=[];
        $scope.master = angular.copy(category);
        $.each($scope.onTagTabClick,function(k,v){
          var tagObj=
          {
            "class": [
                "subCategoryTag"
            ],
            "rel": [
                "subCategoryTagsRep"
            ],
            "properties": {
                "$siren4j.class": "com.meat.representation.siren.SubCategoryTagsRepresentation",
                "subCategoryTagsStatus": "Active",
                "tagsId": v.id
            }
        };
        categoryEntities.push(tagObj);

        })
        $.each($scope.SubCategoryImagePathData,function(kimg,vimg){
        var imgObj={
          "class":[
              "subCategoryImage"
          ],
          "rel":[
              "subCategoryImagesRep"
          ],
          "properties":{
            "$siren4j.class":"com.meat.representation.siren.SubCategoryImagesRepresentation",
            "imageName":vimg.imageName+'',
            "imageType":vimg.imageType+'',
            "imageLocation":vimg.imageLocationThumb
          }
        };
        categoryEntities.push(imgObj);
      })
        $scope.master["$siren4j.class"]="com.meat.representation.siren.SubCategoryRepresentation",
        $scope.jsonfile = 
                     {
                       "class":["subCategory"],
                       "rel": ["item"],
                       "properties": $scope.master,
                       "entities":categoryEntities
                     }
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));

                   processReqService.processReq(baseURL.IP+"/subCategory/create","POST",data,function(){
                   	// $location.path('/SubCategoryTemplate')},function(){});
                   swal({   title: "SUCCESS!",   text: "SUBCATEGORY CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	$location.path('#/ItemMaster/SubCategoryTemplate')
                   },function(){
                   	swal({   title: "ERROR!",   text: "SUBCATEGORY NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     	});
      };
}
function SubCategoryListController($scope, $http, dataTablesInitService, baseURL){
	$http({
		method: "GET",
		url: baseURL.IP+'/subCategory/subCategoryOnly',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}
	}).success(function(data) {
			
		         var columns = [
		    { "data": "properties.subCategoryName" },
		    { "data": "properties.categoryName" },
		    { "data": "properties.status" },
		    { "data": "properties.id",
		        "orderable": false,
		        "searchable": false,   
		        "render": function(data,type,row,meta) {
		                    var a = '<a href="#/ItemMaster/subCategory/'+row.properties.subCategoryName+'/'+data+'">View</a>'
		                    return a;
		                  }
		     }
		];
		dataTablesInitService.initDataTables(data['entities'],columns,'#subCategoryTable');
		 }).error(function(error){
			$scope.error = error;
		 });
}
function SingleSubCategoryController($scope,$http,$stateParams, baseURL, $modal, $rootScope){
			$scope.name=$stateParams.subCategoryName;
      		$rootScope.subCategoryId=$stateParams.subCategoryId;
    $http({
        method: "GET",
        url: baseURL.IP+'/subCategory/'+$rootScope.subCategoryId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    				}).success(function(data) {
           $scope.subCategoryDetails = data;
           $scope.itemDetails=[];
           $scope.subCategoryTagDetails=[];
           $scope.subCategoryImagesDetails=[];
           $.each($scope.subCategoryDetails['entities'],function(k,v){
              // $scope.subCategoryDetails=v;
            if(v.class=="item"){
              $scope.itemDetails.push(v);
            }
            if(v.class=="subCategoryTags"){
              $scope.subCategoryTagDetails.push(v);
            }
            if(v.class=="subCategoryImages"){
              $scope.subCategoryImagesDetails.push(v.properties);
            }
           })
			}).error(function(error){
			$scope.error = error;
     	});
		$scope.editSubCategory = function (data) {
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SubCategoryEditTemplate.html',
				controller: SubCategoryEditController
			});
			$rootScope.SubCategoryEditData=data;
		}
		$scope.editSubCategorySeo = function (data) {
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SubCategorySeoEditTemplate.html',
				controller: SubCategoryEditController
			});
			$rootScope.subCategoryEditData=data;
		}
		$scope.editsubCategoryTag=function(data){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/subCategoryTagsEditTemplate.html',
				controller: SubCategoryEditController
			});
			$rootScope.subCategoryEditData=data;
		}
		$scope.addsubCategoryTags=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/subCategoryTagsCreationTemplate.html',
				controller: SubCategoryEditController
			});
		}
		// $rootScope.subCategoryId=$scope.subCategoryId;
}

function SubCategoryEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
	
	if($rootScope.SubCategoryEditData){
	console.log(JSON.stringify($rootScope.SubCategoryEditData));	
	}
	$http({
      method: "GET",
      url: baseURL.IP+'/tagType/tagTypeOnly',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.tagsTypes = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    $scope.tagtypeChange=function(tagTypeId){
    	$http({
      method: "GET",
      url: baseURL.IP+'/tagType/'+tagTypeId,
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
    }).success(function(data) {
      $scope.tags = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
	}	
	$scope.ok = function (SubCategoryEditData) {
		var jsonfile={
				    "class": [
				        "subCategory"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":SubCategoryEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/subCategory/"+SubCategoryEditData.id+"/edit","POST",jsonfile,function(){
		 	
		 	$modalInstance.close();
		},function(){});
		
	};
	$scope.subCategorySeoEdit=function(SubCategoryEditData){
		var jsonfile={
				    "class": [
				        "subCategory"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":SubCategoryEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/subCategory/"+SubCategoryEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});
		$modalInstance.close();
	}
	$scope.subCategoryTagEdit=function(subCategoryEditData){
		$scope.vtags=[];
		$.each(subCategoryEditData,function(k,v){
			// $.each(v.tags,function(ktags,vtags){
				var subCategoryTags={
		            "class": [
		                "subCategoryTags"
		            ],
		            "rel": [
		                "subCategoryTagsRep"
		            ],
		            "properties": v.properties
		        }
		        $scope.vtags.push(subCategoryTags);
		    // })
		})
		var jsonfile={
			    "class": [
			        "subCategory"
			    ],
			    "properties": {
			        "$siren4j.class": "com.meat.representation.siren.SubCategoryRepresentation",
			        "id": $rootScope.subCategoryId
			    },
		    	"entities":$scope.vtags
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/subCategory/"+$rootScope.subCategoryId+"/edit","POST",jsonfile,function(){location.reload()},function(){});
      	$modalInstance.close();
	}
	$scope.subcategoryTagCreate=function(subCategoryTags){
		var jsonfile={
			    "class": [
			        "subCategory"
			    ],
			    "properties": {
			        "$siren4j.class":  "com.meat.representation.siren.SubCategoryRepresentation",
			        "id": $rootScope.subCategoryId
			    },
		    	"entities":[
		        {
		            "class": [
		                "subCategoryTags"
		            ],
		            "rel": [
		                "subCategoryTagsRep"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.SubCategoryTagsRepresentation",
		                "tagsId": subCategoryTags.tagsId,
		                "subCategoryTagsStatus": subCategoryTags.subcategoryTagsStatus
		            }
		        }
        	]
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/subCategory/"+$rootScope.subCategoryId+"/edit","POST",jsonfile,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "SUBCATEGORY EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
          $location.path('#/ItemMaster/SubCategoryEditTemplate')
          },function(){
          swal({ 	title: "ERROR!",   text: "SUBCATEGORY NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
        });
		
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
}

function SellersItemsListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/seller/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
        $scope.entities=[];
           $.each(data['entities'],function(k,v){
            $scope.entities.push(v);
           })
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleSellerItemsController($scope, $http, $stateParams, processReqService, baseURL, $rootScope,$modal){
	$scope.sellerId=$stateParams.sellerId;
	$http({
        method: "GET",
        url: baseURL.IP+'/sellerBranch/seller/'+$scope.sellerId+'/sellerBranchOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    	}).success(function(data) {
        $scope.branchEntities=[];
           $.each(data['entities'],function(k,v){
            $scope.branchEntities.push(v.properties);
           })
        }).error(function(error){
            $scope.error = error;
        });

        $scope.sellerBranchItems= function(sellerBranchId){
	        $http({
	        method: "GET",
	        url: baseURL.IP+'/sellerItem/sellerBranchItemOnly/'+sellerBranchId,
	        headers: {
	               'Content-Type': "application/vnd.siren+json",
	               'Accept': "application/vnd.siren+json"
	            }
	    	}).success(function(data) {
	    		$scope.sellerItemEntities={};
	       		$.each(data['entities'],function(k,v){
         			if(v.class=="sellerItem"){
         				if(!$scope.sellerItemEntities[v['properties'].sellerItemName]){
	                  $scope.sellerItemEntities[v['properties'].sellerItemName]={};   
	                  $scope.sellerItemEntities[v['properties'].sellerItemName]['itemsData']=[];  
	                  $scope.sellerItemEntities[v['properties'].sellerItemName]['ImagesData']=[];  
	                  $scope.sellerItemEntities[v['properties'].sellerItemName]['itemsData'].push(v.properties);   
	                  $scope.sellerItemEntities[v['properties'].sellerItemName]['ImagesData'].push(v.entities);  
	                }
         			}
         		})
	         }).error(function(error){

	            $scope.error = error;
	         });
         }
         $scope.sellerItemClick=function(name){
         	$rootScope.itemCutType=[];
          var sellerItemsData=$scope.sellerItemEntities[name];
          $.each(sellerItemsData,function(k,v){
            if(k=="itemsData"){
             $.each(v,function(kitem,vitem){
             	$scope.sellerItemDetails=vitem;
             	$rootScope.sellerItemId=vitem.id;
             	$rootScope.itemCutType = vitem['cutTypes'].split(",");
             })
             }
           });
        }
      $scope.addSellerItemCutTypes=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SellerItemCutTypeCreationTemplate.html',
				controller: SellerItemEditController
			});
		}
		$scope.editSellerItemCutType = function(data) {
			$rootScope.itemCutType=$rootScope.itemCutType.filter(function(i) {
				return i != data
			});
			var cutTypeItems = "";
			for (var i in $rootScope.itemCutType){
			cutTypeItems = cutTypeItems+","+$rootScope.itemCutType[i];
			}
			$scope.cutTypeItemsData =cutTypeItems.replace(/^,/,'');
			console.log(typeof $scope.cutTypeItemsData)
			var cutTypeSimplifyData1={
				    "class": [
				        "sellerItem"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":
				    {
			        "$siren4j.class": "com.meat.representation.siren.SellerItemRepresentation",
			        "id": $rootScope.sellerItemId,
			        "cutTypes":$scope.cutTypeItemsData
			    }
				}
				console.log(cutTypeSimplifyData1);
				processReqService.processReq(baseURL.IP+"/sellerItem/"+$rootScope.sellerItemId+"/edit","POST",cutTypeSimplifyData1,function(){},function(){});
			}
}
function SellerItemEditController($scope, $rootScope, $http, $modalInstance, processReqService, baseURL){

	$http({
		method: "GET",
		url: baseURL.IP+'/cutType/all',
		data: '',
		headers: {
				 'Content-Type': "application/vnd.siren+json",
				 'Accept': "application/vnd.siren+json"
			}
	}).success(function(data) {
			$scope.cutTypeDetails = data.entities;
			
	 }).error(function(error){

		$scope.error = error;
	 });

	 $scope.sellerItemCutTypeCreate=function(cutTypeData){
	 	
		for (var i in cutTypeData){
			$rootScope.itemCutType = $rootScope.itemCutType+","+cutTypeData[i];
		}
		console.log($rootScope.itemCutType)
		var cutTypeSimplifyData= $rootScope.itemCutType;
			$scope.cutType1 =cutTypeSimplifyData.replace(/^,/,'');
			var cutTypeSimplifyData={
				    "class": [
				        "sellerItem"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":
				    {
			        "$siren4j.class": "com.meat.representation.siren.SellerItemRepresentation",
			        "id": $rootScope.sellerItemId,
			        "cutTypes":$scope.cutType1
			    }
				}
		console.log(JSON.stringify(cutTypeSimplifyData));
		processReqService.processReq(baseURL.IP+"/sellerItem/"+$rootScope.sellerItemId+"/edit","POST",cutTypeSimplifyData,function(){
         	swal({   title: "SUCCESS!",   text: "CUTTYPE CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       	location.reload()
       },function(){
       	swal({   title: "ERROR!",   text: "CUTTYPE NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
         	});
	 }
	 $scope.cancel=function(){
		$modalInstance.close();
	}
}
function TagCreationController($scope, $http, baseURL, processReqService, $location, $state){
	console.log(baseURL.IP);
	$('.confirm').removeClass('show');
	$('#tagwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#tagForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#tagForm").valid();
 	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});	
	$http({
        method: "GET",
        url: baseURL.IP+'/tagType/tagTypeOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
           $scope.tagtypedetails = data;
         }).error(function(error){

            $scope.error = error;
         });
        $scope.save = function(tag) {
        $scope.master = angular.copy(tag);
        $scope.master["$siren4j.class"]= "com.meat.representation.siren.TagsRepresentation",
        $scope.jsonfile = 
                     {
                       "class":["tags"],
                       "rel": ["item"],
                       "properties":$scope.master
                     };
         data=$scope.jsonfile;
         console.log(JSON.stringify($scope.jsonfile));
        $('#page-top').append('<div class="spiner-example1"><div class="sk-spinner sk-spinner-rotating-plane"></div></div>')
         processReqService.processReq(baseURL.IP+"/tags/create","POST",data,function(){
         	$('div.spiner-example1').remove();
         	swal({   title: "SUCCESS!",   text: "TAG CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       	$state.go('Tags.TagsTemplate')
       },function(){
       	swal({   title: "ERROR!",   text: "TAG NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
         	});
      	};
}
function TagsListController($scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/tags/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    		}).success(function(data) {
           // $scope.tagdetails = data;
                 var columns = [
            { "data": "properties.tagName" },
            { "data": "properties.tagTypeName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Tags/Tag/'+row.properties.tagName+'/'+data+'">View</a>'
                            return a;
                          }
            }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#TagsTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleTagController($scope, $http,	$stateParams, baseURL, $modal, $rootScope){
	$scope.id=$stateParams.tagId;
     $scope.name=$stateParams.tagName;

    $http({
        method: "GET",
        url: baseURL.IP+'/tags/'+$scope.id,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
   
           $scope.singleTagDetails = data;
            // alert(data);
           // TableAdvanced.init();
         }).error(function(error){

            $scope.error = error;
         });
        $scope.editTag=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/TagEditTemplate.html',
				controller: TagEditController
			});
			$rootScope.TagEditData=data;
        }
        $scope.editTagSeo=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/TagSeoEditTemplate.html',
				controller: TagEditController
			});
			$rootScope.TagEditData=data;
        }
}
function TagEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
	$scope.ok=function(TagEditData){
		var jsonfile={
				    "class": [
				        "tag"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":TagEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/tags/"+TagEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});	
	}
	$scope.tagSeoEdit=function(TagEditData){
		var jsonfile={
				    "class": [
				        "tag"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":TagEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/tags/"+TagEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "Tag EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
           	$location.path('#/ItemMaster/TagEditTemplate')
           },function(){
           	swal({ 	title: "ERROR!",   text: "Tag NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
             	});
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function TagTypeCreationController($scope, $http, baseURL, processReqService, $state){

	$('.confirm').removeClass('show');
	$('#tagwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#tagForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#tagForm").valid();
	  			
	  			if(!$valid) {
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	   $scope.save = function(tagType) {
        $scope.master = angular.copy(tagType);
        $scope.master["$siren4j.class"]= "com.meat.representation.siren.TagTypeRepresentation";
        $scope.jsonfile = 
                     {
                       "class":["tagType"],
                       "rel": ["item"],
                       "properties":$scope.master
                     };
                     data=$scope.jsonfile;
        console.log(JSON.stringify($scope.jsonfile));
         processReqService.processReq(baseURL.IP+"/tagType/create","POST",data,function(){$state.go('Tags.TagTypeTemplate')},function(){
         	$('div.spiner-example1').remove();
         	swal({   title: "SUCCESS!",   text: "TAG CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       	$state.go('Tags.TagTypeTemplate')
       },function(){
       	swal({   title: "ERROR!",   text: "TAG NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
         	});
		}
}
function TagTypeListController( $scope, $http, dataTablesInitService,processReqFactory, baseURL){
	processReqFactory.processReq(baseURL.IP+"/tagType/all/tagTypesOnly","GET",'',function(data){
              var columns = [
            { "data": "properties.tagTypeName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Tags/TagType/'+row.properties.tagTypeName+'/'+data+'">View</a>'
                            return a;
                        }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#tagtypeTable');
	},function(){});
}
function SingleTagTypeController($scope, $http, $stateParams, baseURL, $modal, $rootScope){
	$scope.id=$stateParams.tagTypeId;
    $scope.name=$stateParams.tagTypeName;

    $http({
        method: "GET",
        url: baseURL.IP+'/tagType/'+$scope.id,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
   
           $scope.singleTagtypeDetails = data;
            // alert(data);
           // TableAdvanced.init();
         }).error(function(error){

            $scope.error = error;
         });
        $scope.editTagType=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/TagTypeEditTemplate.html',
				controller: TagTypeEditController
			});
			$rootScope.TagTypeEditData=data;
        }
}
function TagTypeEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
	$scope.ok=function(TagTypeEditData){
		var jsonfile={
				    "class": [
				        "tagType"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":TagTypeEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/tagType/"+TagTypeEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "TAGTYPE EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       	$location.path('#/ItemMaster/TagTypeEditTemplate')
       },function(){
       	swal({ 	title: "ERROR!",   text: "TAGTYPE NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
         	});
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function CutTypeCreationController( $scope, $http, processReqService, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#cuttypewizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#cutTypeForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#cutTypeForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
		
	     $scope.save = function(cutType) {
        $scope.cutTypes = angular.copy(cutType);
        $scope.cutTypes["$siren4j.class"]=  "com.meat.representation.siren.CutTypeRepresentation",
        
        $scope.jsonfile = 
           {
             "class":["cutType"],
             "rel": ["item"],
             "properties":$scope.cutTypes
           };
        data=$scope.jsonfile;
        console.log(JSON.stringify($scope.jsonfile));
        processReqService.processReq(baseURL.IP+"/cutType/create","POST",data,function(){
        	swal({   title: "Success!",   text: "CUTTYPE CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
        	$state.go('Tags.CutTypeTemplate')
        	},function(){
         	swal({   title: "ERROR!",   text: "CUTTYPE NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
         });
      };
}
function CutTypeListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/cutType/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      
           // $scope.tagdetails = data;
                 var columns = [
            { "data": "properties.cutTypeName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Tags/cutType/'+row.properties.cutTypeName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#CutTypeTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleCutTypeController( $scope, $http, $stateParams, baseURL, $rootScope, $modal){
	$scope.cutTypeName=$stateParams.cutTypeName;
	$scope.cutTypeId=$stateParams.cutTypeId;
	$http({
        method: "GET",
        url: baseURL.IP+'/cutType/'+$scope.cutTypeId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.cutTypeDetails=data;   
         }).error(function(error){
            $scope.error = error;
         });
   $scope.CutTypeEdit=function(cutType){
    	var modalInstance = $modal.open({
			templateUrl: '/Admin/views/CutTypeEditTemplate.html',
			controller: CutTypeEditController
			});
			$rootScope.cutTypeEditedData=cutType;
  	}
}
function CutTypeEditController($scope, $http, baseURL, $modalInstance, $rootScope, processReqService){
		$scope.cutTypeModelEdit=function(cutTypeEditData){
		delete cutTypeEditData.categoryId;
		delete cutTypeEditData.categoryName;
		delete cutTypeEditData.createdDate;
		var jsonfile={
				    "class": [
				        "cutType"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":cutTypeEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/cutType/"+cutTypeEditData.id+"/edit","POST",jsonfile,function(){
			swal({   title: "SUCCESS!",   text: "CUTTYPE EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
     	location.reload()
     },function(){
     	swal({ 	title: "ERROR!",   text: "CUTTYPE NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
       	});
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function SellersCreationController( $scope, $http, baseURL, processReqFactory, $state, $location){
	$('.confirm').removeClass('show');
	$scope.taxDetail=[];
	// $scope.imgsrc='';
	$('#sellerswizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#sellersForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#sellersForm").valid();
	  			if(index==4){
	  				if(!$valid) {

	  				return false;
	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			if(index==3){
	  				// console.log(JSON.stringify($scope.taxDetail));
	  				$('.confirm').addClass('show');
	  			}
	  			
	  			if(!$valid) {
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
		$http({
        method: "GET",
        url: baseURL.IP+'/zone/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.zoneEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.zoneEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });
			
			$scope.zonechange=function(){
        	$scope.zone=[];
        	var obj = $(".select2_demo_3").select2("data");
				$.each(obj,function(k,v){
				var zoneData={};
				zoneData['zoneName']=v.text;
				$scope.zone.push(zoneData);
				})
				console.log(JSON.stringify($scope.zone));
        	}

        $scope.save = function(seller,sellerBranch,address,zoneId) {
        $scope.sellerData=angular.copy(seller);
		$scope.sellerData['$siren4j.class']="com.meat.representation.siren.SellerRepresentation";
		var jsonData={
					"class": [
						"seller"
					],
					"rel": [
						"item"
					],
					"properties": $scope.sellerData
				}
		$scope.sellerBranchData=angular.copy(sellerBranch);
		$scope.sellerBranchData['$siren4j.class']="com.meat.representation.siren.SellerBranchRepresentation";
		$scope.addressData=angular.copy(address);
		$scope.addressData['status']='ACTIVE';
		$scope.addressData['$siren4j.class']="com.meat.representation.siren.SellerBranchAddressRepresentation";
		$scope.addressData['zipcode']=address['zipcode']+'';
		var addressobj={
					"class": [
						"sellerBranchAddress"
					],  
					"rel": [
						"sellerBranchAddressRep"
					],
					"properties": $scope.addressData
					};
		$.each(zoneId,function(k,v){
			var zoneobj={
					"class": ["sellerBranchZone"],
					"rel": ["sellerBranchZoneRep"],
					"properties": {
					"$siren4j.class": "com.meat.representation.siren.SellerBranchZoneRepresentation",
					"zoneId": v,
					"status": "Active"
				}
			}
		})
		var branchobj={
					"class": [
						"sellerBranch"
					],  
					"rel": [
						"sellerBranchRep"
					],
					"properties": $scope.sellerBranchData,
					"entities":[addressobj]
				}

		jsonData.entities = [];
		jsonData.entities.push(branchobj);
		console.log(JSON.stringify(jsonData));
		processReqFactory.processReq(baseURL.IP+'/seller/create','POST',jsonData,function(){
				swal({   title: "SUCCESS!",   text: "SELLER CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
					$state.go('Sellers.SellersTemplate')
					 },function(){
					swal({   title: "ERROR!",   text: "SELLER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
					});
	}
}
function SellersBranchCreationController( $scope, $http, baseURL, processReqFactory, $state, $location){
	$('.confirm').removeClass('show');
	$scope.taxDetail=[];
	$('#sellerswizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#sellersForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#sellersForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			if(index==5){
	  				// console.log(JSON.stringify($scope.taxDetail));
	  				$('.confirm').addClass('show');
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2 || index==3){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	  $http({
	    method: "GET",
	    url: baseURL.IP+'/zone/all',
	    data: '',
	    headers: {
	           'Content-Type': "application/vnd.siren+json",
	           'Accept': "application/vnd.siren+json"
	        }

		}).success(function(data) {
	   	$scope.zoneEntities=[];
	   	$.each(data['entities'],function(key,value){           
	        $scope.zoneEntities.push(value);
	   	})
	 	}).error(function(error){
	    $scope.error = error;
	 	});
			$scope.zoneChange=function(){
	    	$scope.zone=[];
	    	var obj = $(".select2_demo_3").select2("data");
				$.each(obj,function(k,v){
				var zoneData={};
				zoneData['zoneName']=v.text;
				$scope.zone.push(zoneData);
				})
				console.log(JSON.stringify($scope.zone));
	    	}       
      $http({
        method: "GET",
        url: baseURL.IP+'/seller/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
          $scope.sellerEntities=[];
          $.each(data['entities'],function(key,value){           
            $scope.sellerEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });
        $scope.sellerChange=function(){
        	var obj = $(".select2_demo_5").select2("data");
			$.each(obj,function(k,v){
			})
        }
        $http({
        method: "GET",
        url: baseURL.IP+'/tax/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      
         $scope.taxdetails = data.entities;
         }).error(function(error){

            $scope.error = error;
         });
        $http({
        method: "GET",
        url: baseURL.IP+'/amountType/amountTypeOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
         $scope.amountTypeDetails = data.entities;
         }).error(function(error){

            $scope.error = error;
         });
        $scope.sellerChange=function(){
        	var obj = $(".select2_demo_1").select2("data");
			$.each(obj,function(k,v){
				$scope.sellerName=v.text;
			})
        }
       	$scope.save = function(sellerId,sellerBranchDetails,sellerAddressDetails,sellerBranchZone) {
        var sellerZoneData=[];
        console.log(sellerBranchZone);  
        $scope.sellerBranchmaster=angular.copy(sellerBranchDetails);
        	var branchtime = sellerBranchDetails.minimumOrderTime.split(':')
			var minimumOrderTimeChange= 0;
			var m=1;
			while(branchtime.length > 0){
			minimumOrderTimeChange +=m* parseInt(branchtime.pop(),10);
			m*=60;
			}
        $scope.sellerBranchmaster["$siren4j.class"] = "com.meat.representation.siren.SellerBranchRepresentation";
        $scope.sellerBranchmaster["branchStatus"] = "Active";
        	sellerAddressDetails['zipcode']=sellerAddressDetails['zipcode']+'';
        	sellerAddressDetails['status']='ACTIVE';
        	sellerAddressDetails['$siren4j.class']="com.meat.representation.siren.SellerBranchAddressRepresentation";
        	sellerZoneData.push({
                    "class": [
                        "sellerBranchAddress"
                    ],
                    "rel": [
                        "sellerBranchAddressRep"
                    ],
                    "properties":sellerAddressDetails
                });
        	var jsonData={
					"class": [
						"sellerBranch"
					],
					"rel": [
						"item"
					],
					"properties": {
						"sellerId": sellerId,
						"branchName": sellerBranchDetails.branchName,
						"sellerEmailId": sellerBranchDetails.sellerEmailId,
						"sellerPhoneNo": sellerBranchDetails.sellerPhoneNo,
						"branchStatus": sellerBranchDetails.branchStatus,
						"minimumOrderTime": minimumOrderTimeChange+'',
						"deliveryCutoffDays": sellerBranchDetails.deliveryCutoffDays,
						"$siren4j.class": "com.meat.representation.siren.SellerBranchRepresentation"
					},
					"entities":sellerZoneData
				}
				 $.each($scope.taxDetail,function(ktax,vtax){
		        	var taxObj={
		            "class":[
		                "sellerBranchTax"
		            ],
		            "rel": [
		                "sellerBranchTaxRep"
		            ],
		            "properties":vtax
		          };
		          sellerZoneData.push(taxObj);
		        })

        	$.each(sellerBranchZone,function(kzone,vzone){
          	var zoneObj={
              "class": [
                  "sellerBranchZone"
              ],
              "rel": [
                  "sellerBranchZoneRep"
              ],
              "properties": {
                  "$siren4j.class": "com.meat.representation.siren.SellerBranchZoneRepresentation",
                  "zoneId": vzone,
                  "status": "Active"
              }
          };
          sellerZoneData.push(zoneObj) ;
        })
            data=jsonData;
                    console.log(JSON.stringify(jsonData));	
                processReqFactory.processReq(baseURL.IP+"/sellerBranch/create","POST",data,function(){
                
                swal({   title: "SUCCESS!",   text: "SELLER BRANCH CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                $state.go('Sellers.SellersTemplate');
                },function(){
                swal({   title: "ERROR!",   text: "SELLER BRANCH NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                });
      };
}
function SingleSellerBranchCreationController( $scope, $http, baseURL, processReqFactory, $state, $stateParams,$location){
	$('.confirm').removeClass('show');
	$scope.taxDetail=[];
	// $scope.imgsrc='';
	$('#sellersBranchwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#sellersBranchForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#sellersBranchForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			if(index==2){
	  				// console.log(JSON.stringify($scope.taxDetail));
	  				$('.confirm').addClass('show');
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});

	$scope.id=$stateParams.sellerId;


	$http({
        method: "GET",
        url: baseURL.IP+'/zone/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.zoneEntities=[];
       $.each(data['entities'],function(key,value){           
            $scope.zoneEntities.push(value);
       })
     }).error(function(error){
        $scope.error = error;
     });
			$scope.zoneChange=function(){
        	$scope.zone=[];
        	var obj = $(".select2_demo_3").select2("data");
				$.each(obj,function(k,v){
				var zoneData={};
				zoneData['zoneName']=v.text;
				$scope.zone.push(zoneData);
				})
				console.log(JSON.stringify($scope.zone));
        	}
 $scope.save = function(sellerBranchDetails,sellerAddressDetails,sellerBranchZone) {
        	var sellerBranchData=[];
        	sellerAddressDetails['zipcode']=sellerAddressDetails['zipcode']+'';
        	sellerAddressDetails['$siren4j.class']="com.meat.representation.siren.AddressRepresentation";
        	sellerBranchData.push({
                    "class": [
                        "address"
                    ],
                    "rel": [
                        "addressRep"
                    ],
                    "properties":sellerAddressDetails
                });
        	var jsonData={
					"class": [
						"sellerBranch"
					],
					"rel": [
						"item"
					],
					"properties": {
						"sellerId":$stateParams.sellerId,
						"branchName": sellerBranchDetails.branchName,
						"sellerEmailId": sellerBranchDetails.sellerEmailId,
						"sellerPhoneNo": sellerBranchDetails.sellerPhoneNo,
						"branchStatus": sellerBranchDetails.branchStatus,
						"minimumOrderTime": sellerBranchDetails.minimumOrderTime,
						"$siren4j.class": "com.meat.representation.siren.SellerBranchRepresentation"
					},
					"entities":sellerBranchData
				}
        
        $.each(sellerBranchZone,function(kzone,vzone){
          var zoneObj={
              "class": [
                  "sellerBranchZone"
              ],
              "rel": [
                  "sellerBranchZoneRep"
              ],
              "properties": {
                  "$siren4j.class": "com.meat.representation.siren.SellerBranchZoneRepresentation",
                  "zoneId": vzone,
                  "status": "Active"
              }
          };
          sellerBranchData.push(zoneObj);
        })
        $scope.jsonfile =
        {
            "class": [
                "sellerBranch"
            ],
            "rel": [
                "sellerBranchRep"
            ],
            "properties": $scope.sellerBranchmaster,
            "entities": sellerZoneData
        }
        data=jsonData;
        console.log(JSON.stringify(jsonData));
        processReqFactory.processReq(baseURL.IP+"/sellerBranch/create","POST",data,function(){
        swal({   title: "SUCCESS!",   text: "SELLER BRANCH CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
        $state.go('Sellers.SellersTemplate');
        },function(){
        swal({  title: "ERROR!",   text: "SELLER BRANCH NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
        });
      };
        
}

function SellersListController($scope, $http, baseURL, dataTablesInitService){
	$http({
        method: "GET",
        url: baseURL.IP+'/seller/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
 			  var entities=[];
           $.each(data['entities'],function(k,v){
              entities.push({'seller':v.properties});
           })
                  var columns = [
            { "data": "seller.sellerCode" },
            { "data": "seller.sellerName" },
            { "data": "seller.status" },
            { "data": "seller.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Sellers/seller/'+row.seller.sellerName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(entities,columns,'#sellerTable');
         }).error(function(error){
            $scope.error = error;	
         });
}
function SingleSellerController( $scope, $http, baseURL, $stateParams, processReqFactory, $state, $location, $modal, $rootScope){
	$scope.id=$stateParams.sellerId;
     $scope.name=$stateParams.sellerName;

    $http({
        method: "GET",
        url: baseURL.IP+'/seller/'+$stateParams.sellerId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.singleSellerDetails = data;
           $scope.sellerSellerDetails=[];
           $scope.sellerBranchDetails=[];
           $scope.sellerAddressDetails=[];
           $.each($scope.singleSellerDetails['entities'],function(ksel,vsel){
           	$scope.sellerDetails=vsel;
           	if(vsel.class=="seller"){
           	$scope.sellerSellerDetails.push(vsel);
           	}
           	if(vsel.class=="branch"){
           	$scope.sellerBranchDetails.push(vsel.properties)
           	}
           	if(vsel.class=="address"){
           	$scope.sellerAddressDetails.push(vsel.properties)
           	}
           })
         }).error(function(error){

            $scope.error = error;
         });
	    $scope.editSeller=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SellerEditTemplate.html',
				controller: SellersEditController
			});
			$rootScope.SellerEditData=data;
        }
        $scope.editSellerSeo=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SellerSeoEditTemplate.html',
				controller: SellersEditController
			});
			$rootScope.SellerEditData=data;
        }
        $scope.editbranch=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SellersBranchEditTemplate.html',
				controller: SellersEditController
			});
			$rootScope.SellerEditData=data;
        }
        
			// $rootScope.sellerId=$scope.sellerId;

	$scope.addBranch=function(id){
		$state.go('Sellers.SingleSellersBranchCreationTemplate',{sellerId:id})
	}
}
function SellersEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
	if($rootScope.SellerEditData.entities){
	$.each($rootScope.SellerEditData['entities'],function(k,v){
		if(v.class=='address'){
			$scope.branchAddress=v;
		}
	})
	}
	$http({
        method: "GET",
        url: baseURL.IP+'/item/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.itemDetails = data;
         }).error(function(error){
            $scope.error = error;
         });
         
	$http({
        method: "GET",
        url: baseURL.IP+'/zone/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.zonesDetails = data;
         }).error(function(error){
            $scope.error = error;
         });
	$scope.ok=function(SellerEditData){
		var jsonfile={
				    "class": [
				        "seller"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":SellerEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/seller/"+SellerEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});
		
	}
	$scope.sellerSeoEdit=function(data){
		var jsonfile={
				    "class": [
				        "seller"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":data
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/seller/"+data.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});
	
	}
	$scope.BranchEdit=function(SellerBranchEditData){
		var jsonfile={
			"class":[
				"sellerBranch"
			],
			"rel":[
				"item"
			],
				"properties":SellerBranchEditData
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/sellerBranch/"+SellerBranchEditData['properties'].id+"/edit","POST",data,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "Sellers EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	$location.path('#/ItemMaster/SellersTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "Sellers NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function SellerBranchListController($scope, $http, $location, $state, dataTablesInitService, $rootScope, baseURL){
 
	$http({
		method: "GET",
		url: baseURL.IP+'/sellerBranch/all',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$scope.sellerBranchData=data.entities;                  
	}).error(function(error,statusText,xhr){
    	if(statusText==401){
    		location.reload();
    	}
      $scope.error = error;
    });
	$scope.SellerBranchChange=function(id,name){
		if(name=="SELLERBRANCH"){
			var obj = $(".select2_demo_3").select2("data");
			$.each(obj,function(k,v){
				$scope.branchDetailsName=v.text;
			})
			$state.go('Sellers.SellerBranchSingleTemplate',{ sellerBranchId: id, branchName: $scope.branchDetailsName  })
		}
	}
}
function SingleBranchController($scope, $http, $stateParams, $state, $modal, $rootScope,baseURL,dataTablesInitService) {
	$scope.sellerBranchId=$stateParams.sellerBranchId;
	$scope.branchName=$stateParams.branchName;
	$http({
		method: "GET",
		url: baseURL.IP+'/sellerBranch/'+$scope.sellerBranchId +'/sellerBranchOnly',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			}

	}).success(function(data) {
           $scope.sellerBranchTimingsDetails=[];
           $scope.sellerBranchTaxDetails=[];
           $scope.sellerBranchChargesDetails=[];
           // $scope.sellerUsers=[];
           $.each(data['entities'],function(kbranch,vbranch){
           	if(vbranch.class=="sellerBranch"){
           	$scope.sellerBranchesDetails=vbranch.properties;
           	}
           	$.each(vbranch['entities'],function(kaddr,vaddr){
           		if(vaddr.class=="sellerBranchAddress"){
           			$scope.sellerBranchAddressDetails=vaddr.properties;
           		}
           		if(vaddr.class=="sellerBranchTimings"){
           			$scope.sellerBranchTimingsDetails.push(vaddr)
           		}
           		if(vaddr.class=="sellerBranchTax"){
           			$scope.sellerBranchTaxDetails.push(vaddr)
           		}
           		if(vaddr.class=="sellerBranchCharges"){
           			$scope.sellerBranchChargesDetails.push(vaddr)
           		}
           })
           })
         }).error(function(error){

            $scope.error = error;
         });
         $http({
		method: "GET",
		url: baseURL.IP+'/sellerUser/sellerBranch/'+$scope.sellerBranchId+'/allUsers',
		data: '',
		headers: {
			   'Content-Type': "application/vnd.siren+json",
			   'Accept': "application/vnd.siren+json"
			},

	}).success(function(data) {
		$scope.sellerBranchUsersDetails=data.entities;
      }).error(function(error){

            $scope.error = error;
         });
	
	$scope.editBranch = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/BranchEditTemplate.html',
			controller: SellerBranchEditController
		});
		$rootScope.BranchEditData=data;
	}
	$scope.editAddress = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/BranchAddressEditTemplate.html',
			controller: SellerBranchEditController
		});
		$rootScope.BranchAddressEditData=data;
	}
	$scope.editTimings = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/BranchTimingsEditTemplate.html',
			controller: SellerBranchEditController
		});
		$rootScope.BranchTimingsEditData=data;
	}
	$scope.editTax = function (data){
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/BranchTaxEditTemplate.html',
			controller:SellerBranchEditController
		});
		$rootScope.BranchTaxEditData=data;
	}
	$scope.editCharges = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/SellerBranchChargesEditTemplate.html',
			controller: SellerBranchEditController
		});
		$rootScope.BranchChargesEditData=data;
	}
	$rootScope.currentSellerBranchId=$stateParams.sellerBranchId;
	$scope.editSellerBranchUser = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/SellerBranchUserEditTemplate.html',
			controller: SellerBranchEditController
		});
		$rootScope.BranchEditData=data;
	}
	$rootScope.currentSellerBranchId=$stateParams.sellerBranchId;
	$scope.addTimings = function (data) {
		var modalInstance = $modal.open({
			templateUrl: '/Admin/views/BranchTimingsCreationTemplate.html',
			controller: SellerBranchEditController
		});
		$rootScope.BranchEditData=data;
	}
	$rootScope.currentSellerBranchId=$stateParams.sellerBranchId;
	$scope.addsellerUser=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/BranchUserCreateTemplate.html',
				controller: SellerBranchEditController
			});
		}
		$scope.addBranchCharges=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/BranchChargesCreationTemplate.html',
				controller: SellerBranchEditController
			});
		}
		$scope.addTaxes=function(){
			var modalInstance = $modal.open({
				templateUrl: '/Admin/views/BranchTaxCreateTemplate.html',
				controller: SellerBranchEditController
			});
		}
		$rootScope.sellerBranchId=$scope.sellerBranchId;
}
function SellerBranchEditController($scope, $http, $location, $modalInstance, $rootScope, baseURL, processReqService){
	    
	$http({
        method: "GET",
        url: baseURL.IP+'/seller/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.sellersDetails = data;
         }).error(function(error){
            $scope.error = error;
         });
         
        $http({
        method: "GET",
        url: baseURL.IP+'/timings/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.timingsesDetails = data;
         }).error(function(error){
            $scope.error = error;
         });

         $http({
        method: "GET",
        url: baseURL.IP+'/tax/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.taxesDetails = data;
         }).error(function(error){
            $scope.error = error;
         });

        $http({
    		method: "GET",
    		url: baseURL.IP+'/amountType/all',
    		data: '',
    		headers: {
           		'Content-Type': "application/vnd.siren+json",
           		'Accept': "application/vnd.siren+json"
        	}
		}).success(function(data) {
    	$scope.amountTypesDetails = data.entities;
  		}).error(function(error){
    	$scope.error = error;
  		});

		  processReqService.processReq(baseURL.IP+"/amountType/amountTypeOnly","GET",'',function(amountData){
        $scope.amountTypeData=amountData.entities;
        },function(){});
			$scope.branchEdit = function (BranchEditData) {
			var jsonfile={
				    "class": [
				        "sellerBranch"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties": BranchEditData
				    }
        console.log(JSON.stringify(jsonfile));
        processReqService.processReq(baseURL.IP+"/sellerBranch/"+$rootScope.sellerBranchId+"/edit","POST",jsonfile,function(){
				swal({   title: "SUCCESS!",   text: "BRANCH EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	$location.path('#/Sellers/SellerBranchSingleTemplate')
         },function(){
         	swal({ 	title: "ERROR!",   text: "BRANCH NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
      });
	};
	$scope.AddressEdit= function (BranchAddressEditData) {
		var jsonfile={
				    "class": [
				        "sellerBranchAddress"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties": BranchAddressEditData
				    }
    	console.log(JSON.stringify(jsonfile));
    	processReqService.processReq(baseURL.IP+"/sellerBranchAddress/"+BranchAddressEditData.id+"/edit","POST",jsonfile,function(){
	swal({   title: "SUCCESS!",   text: "ADDRESS EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	location.reload();
         	},function(){
         	swal({ 	title: "ERROR!",   text: "ADDRESS NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
        });
  		$modalInstance.close();
	}
	$scope.TimingsEdit= function (BranchTimingsEditData) {
		
        delete BranchTimingsEditData['links'];
        var data = angular.toJson(BranchTimingsEditData);
        console.log(data);
        processReqService.processReq(baseURL.IP+"/sellerBranchTimings/"+BranchTimingsEditData['properties'].id+"/edit","POST",BranchTimingsEditData,function(){
			swal({   title: "SUCCESS!",   text: "BRANCHTIMINGS EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                
                   	location.reload()
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "BRANCHTIMINGS NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
      	$modalInstance.close();
	}
	$scope.BranchTaxEdit= function (BranchTaxEditData) {
        	delete BranchTaxEditData['links'];
        	var data = angular.toJson(BranchTaxEditData);
        	console.log(data);
        	processReqService.processReq(baseURL.IP+"/sellerBranchTax/"+BranchTaxEditData['properties'].id+"/edit","POST",BranchTaxEditData,function(){
			swal({   title: "SUCCESS!",   text: "TAX EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	location.reload()
                   	},function(){
                   	swal({ 	title: "ERROR!",   text: "TAX NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
            });
      	$modalInstance.close();
	}
	$scope.SellerBranchUserEdit=function(BranchEditData){

        delete BranchEditData['links'];
        var data = angular.toJson(BranchEditData);
        console.log(data);
        processReqService.processReq(baseURL.IP+"/sellerUser/"+BranchEditData['properties'].sellerBranchId+"/edit","POST",BranchEditData,function(){
			swal({   title: "SUCCESS!",   text: "BRANCH USER EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	location.reload()
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "BRANCH USER NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
      	$modalInstance.close();
	}
	$scope.sellerUser={};
	$scope.BranchUsersCreate=function(sellerUser){
		var jsonfile={
		            "class": [
		                "sellerUser"
		            ],
		            "rel": [
		                "item"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.SellerUserRepresentation",
		                "sellerBranchId": $rootScope.sellerBranchId,
		                "userName": sellerUser.userName,
		                "userRoleType": sellerUser.userRoleType,
		                "userEmail": sellerUser.userEmail,		                
		                "userPhoneNo": sellerUser.userPhoneNo,
		                "gender": sellerUser.gender,
		                "sellerUserType": sellerUser.sellerUserType,
		                "userStatus": sellerUser.userStatus,
		                "password": sellerUser.password,
		                "confirmPassword": sellerUser.confirmPassword
		            }
		        }
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/sellerUser/create","POST",jsonfile,function(){
				swal({   title: "SUCCESS!",   text: "SELLERBRANCH USER SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	location.reload()
         },function(){
         	swal({ 	title: "ERROR!",   text: "SELLERBRANCH USER NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
           	});
      	$modalInstance.close();
	}
	$scope.BranchTimingsCreate=function(sellerBranchTimings){
		
		var jsonfile={
		            "class": [
		                "sellerBranchTimings"
		            ],
		            "rel": [
		                "item"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.SellerBranchTimingsRepresentation",
		                "sellerBranchId": $rootScope.sellerBranchId,
		                "timingsId": sellerBranchTimings.timingsId,
		                "status": sellerBranchTimings.status
		                
		            }
		        }
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/sellerBranchTimings/create","POST",jsonfile,function(){
			swal({   title: "SUCCESS!",   text: "BRANCH TIMINGS CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	location.reload()
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "BRANCH TIMINGS NOT CREATED ",   type: "warning",   confirmButtonText: "OK" });
                     	});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
	
	$scope.sellerBranchTax={};
	$scope.BranchTaxCreate=function(sellerBranchTax){
		var jsonfile={
			        "class": [
			            "sellerBranchTax"
			        ],
			        "rel": [
			            "item"
			        ],
        		"properties": {
		            "$siren4j.class": "com.meat.representation.siren.SellerBranchTaxRepresentation",
		            "sellerBranchId": $rootScope.sellerBranchId,
		            "taxId": sellerBranchTax.taxId,
		            "taxValue": sellerBranchTax.taxValue,
		            "amountTypeId":sellerBranchTax.amountTypeId,
		            "taxType": sellerBranchTax.taxType,
		            "sellerBranchTaxStatus": sellerBranchTax.sellerBranchTaxStatus
        		}
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/sellerBranchTax/create","POST",jsonfile,function(){
			swal({   title: "SUCCESS!",   text: "BRANCH TAX CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	location.reload()
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "BRANCH TAX NOT CREATED ",   type: "warning",   confirmButtonText: "OK" });
                     	});
      	$modalInstance.close();
	}
	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
	$scope.BranchChargesCreate=function(sellerBranchCharges){
		var obj = $(".selectStatus").find('option:selected').attr("data");
						$scope.chargesStatus=obj;
		var jsonfile={
		            "class": [
		                "sellerBranchCharges"
		            ],
		            "rel": [
		                "item"
		            ],
		            "properties": {
		                "$siren4j.class": "com.meat.representation.siren.SellerBranchChargesRepresentation",
		                "sellerBranchId": $rootScope.sellerBranchId,
		                "amountTypeId": sellerBranchCharges.amountTypeId,
		                "chargesType": sellerBranchCharges.chargesType,
						"chargesAmount": sellerBranchCharges.chargesAmount,
						"status":$scope.chargesStatus
		            }
		        }
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/sellerBranchCharges/create","POST",jsonfile,function(){location.reload()},function(){swal({   title: "SUCCESS!",   text: "Sellers EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	location.reload()
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "Sellers NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
      	$modalInstance.close();
	}

	$scope.SellerBranchChargesEdit=function(BranchChargesEditData){

        delete BranchChargesEditData['links'];
        var data = angular.toJson(BranchChargesEditData);
        console.log(data);
        processReqService.processReq(baseURL.IP+"/sellerBranchCharges/"+BranchChargesEditData['properties'].id+"/edit","POST",BranchChargesEditData,function(){
			swal({   title: "SUCCESS!",   text: "BRANCH CHARGES EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	location.reload()
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "BRANCH CHARGES NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
      	$modalInstance.close();
	}	
}
function SellerBranchEmployeeCreationController($scope, $http, baseURL, processReqFactory, $state){
	$('.confirm').removeClass('show');
	$('#sellerBranchEmployeewizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#sellerBranchEmployeeForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#sellerBranchEmployeeForm").valid();
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  			if(index==1){
	  				$('.confirm').addClass('show');
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==0){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
			$scope.restaurantChange = function(){
		    	var obj = $(".select2_demo_1").select2("data");
					$.each(obj,function(k,v){
						$scope.restaurantName=v.text;
					})
		    }
	   $http({
        method: "GET",
        url: baseURL.IP+'/sellerBranch/sellerBranchOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
          //$scope.restData=data;
      		$scope.sellerBranchDetails=data.entities;
         }).error(function(error){

            $scope.error = error;
         });
            $scope.save = function(sellerBranchData) {

  			if(sellerBranchData['password']!=sellerBranchData['confirmPassword']){
  				alert("Your password and confirmation password do not match.");
  				return false;
  			}
        $scope.sellerBranchEmpDetails = angular.copy(sellerBranchData);
       	
    	$scope.sellerBranchEmpDetails["$siren4j.class"] = "com.meat.representation.siren.SellerUserRepresentation",
   
        $scope.jsonfile = {
		             "class":["sellerUser"],
		             "rel": ["item"],
		             "properties":$scope.sellerBranchEmpDetails
		           };
		           data=$scope.jsonfile;
		           console.log(JSON.stringify($scope.jsonfile));
		           processReqFactory.processReq(baseURL.IP+"/sellerUser/create","POST",data,function(){
		           	
		            swal({   title: "SUCCESS!",   text: "SELLERBRANCH EMPLOYEE CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
		         	$state.go('Sellers.SellerBranchEmployeesListTemplate');
		         },function(){
		         	swal({   title: "ERROR!",   text: "SELLERBRANCH EMPLOYEE NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
		      });
      };
}
function SellerBranchEmployeesListController($scope, $http, baseURL, dataTablesInitService){
	$http({
        method: "GET",
        url: baseURL.IP+'/sellerUser/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
                  var columns = [
            { "data": "properties.userName" },
            { "data": "properties.sellerUserType" },
            { "data": "properties.userEmail" },
            { "data": "properties.userPhoneNo" },
            { "data": "properties.gender" },
            { "data": "properties.userStatus" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Sellers/SellerBranchEmployee/'+row.properties.userName+'/'+data+'">View</a>'
                            return a;
                          }
             }

        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#sellerBranchEmpTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleSellerBranchEmployeeController( $scope, $http, $stateParams, baseURL, $modal, $rootScope){
	$scope.userId=$stateParams.userId;
     $scope.userName=$stateParams.userName;
	$http({
        method: "GET",
        url: baseURL.IP+'/sellerUser/'+$scope.userId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
   
           $scope.singleSellerBranchEmployeeDetails = data;
         }).error(function(error){

            $scope.error = error;
         });
     $scope.employeeEdit=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SellerBranchEmployeeEditTemplate.html',
				controller: SellerBranchEmployeeEditController
			});
			$rootScope.SellerBranchEmployeeEditData=data;
        }
}
function SellerBranchEmployeeEditController($scope, $http, baseURL, $rootScope,  processReqService,$modalInstance){
	$scope.branchEmployeeEdit=function(SellerBranchEmployeeEditData){
		var jsonData={
				    "class": [
				        "sellerUser"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":SellerBranchEmployeeEditData
				}
		console.log(JSON.stringify(jsonData));
		processReqService.processReq(baseURL.IP+"/sellerUser/"+SellerBranchEmployeeEditData.id+"/edit","POST",jsonData,function(){
			swal({   title: "SUCCESS!",   text: "SELLERBRANCHEMPLOYEE EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.reload();
           },
	function(){
      swal({ 	title: "ERROR!",   text: "SELLERBRANCHEMPLOYEE NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
    });
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function SellerBranchTimingController($scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/seller/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
 			  var entities=[];
           $.each(data['entities'],function(k,v){
              entities.push({'seller':v.properties});
           })
                  var columns = [
            { "data": "seller.sellerCode" },
            { "data": "seller.sellerName" },
            { "data": "seller.sellerType" },
            { "data": "seller.status" },
            { "data": "seller.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Sellers/SellerBranchTiming/'+row.seller.sellerName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(entities,columns,'#sellerBranchTimingsTable');
         }).error(function(error){
            $scope.error = error;	
         });
}
function SellerBranchTimingCreationController( $scope, $http, baseURL, processReqFactory , $location){
	$('.confirm').removeClass('show');
	$('#timingwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#timingForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#timingForm").valid();
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});	
	$http({
        method: "GET",
        url: baseURL.IP+'/sellerBranch/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.sellerBranchDataDetails=data.entities;
         }).error(function(error){

            $scope.error = error;
         });
$http({
        method: "GET",
        url: baseURL.IP+'/timings/all/timingsOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           $scope.sellerBranchTimingDetails=data.entities;
         
         }).error(function(error){

            $scope.error = error;
         });
      $scope.save=function(sellerBranch,sellerBranchTimings){
          $scope.sellerId=angular.copy(sellerBranch);
          $scope.timingsData=[];
          $scope.sellerId["$siren4j.class"] = "com.meat.representation.siren.SellerBranchRepresentation",
          $.each(sellerBranchTimings,function(ktime,vtime){
        var timeObj={
              "class": [
                  "sellerBranchTimings"
              ],
              "rel": [
                  "sellerBranchTimingsRep"
              ],
              "properties": {
                  "$siren4j.class": "com.meat.representation.siren.SellerBranchTimingsRepresentation",
                  "timingsId": vtime,
                  "status": "Active"
              }
          };
          $scope.timingsData.push(timeObj) ;
        })
          $scope.jsonfile = {
                            "class": [
                                "sellerBranch"
                            ],
                            "rel": [
                                "item"
                            ],
                            "properties": $scope.sellerId,
                            "entities": $scope.timingsData
                        };

            data=$scope.jsonfile;
            console.log(JSON.stringify($scope.jsonfile));
            processReqFactory.processReq(baseURL.IP+"/sellerBranch/"+$scope.sellerId.id+"/edit","POST",data,function(){
             	swal({   title: "Success!",   text: "BRANCH TIMING SUCCESS",   type: "success",   confirmButtonText: "Success" });
             	$location.path('#/Sellers/SellerBranchTimings')
            },function(){
             	swal({   title: "ERROR!",   text: "BRANCH TIMING NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
            });
      };
}
function SingleSellerBranchTimingsController( $scope, $http, baseURL, $location, $stateParams, $state, $modal, $rootScope){
	$scope.sellerName=$stateParams.sellerName;
	$scope.sellerId=$stateParams.sellerId;
        $http({
        method: "GET",
        url: baseURL.IP+'/sellerBranch/seller/'+$scope.sellerId+"/sellerBranchOnly",
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
          $scope.branchEntities=data;

         }).error(function(error){

            $scope.error = error;
         });

         $scope.branchChange=function(sellerBranchId){
        	
        $http({
        method: "GET",
        url: baseURL.IP+'/sellerBranchTimings/sellerBranch/'+sellerBranchId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
          $scope.branchTimingDetails=data;

         }).error(function(error){

            $scope.error = error;
         });
		
		}

		$scope.sellerBranchTimingEdit=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/SellerBranchTimingEditTemplate.html',
				controller: SellerBranchTimingEditController
			});
			$rootScope.SellerBranchTimingEditData=data;
        }
}
function SellerBranchTimingEditController($scope, $http, baseURL, $rootScope, processReqService,$modalInstance){
	$scope.update=function(SellerBranchTimingEditData){
		var jsonfile={
				    "class": [
				        "sellerBranchTimings"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":SellerBranchTimingEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/sellerBranchTimings/"+SellerBranchTimingEditData.id+"/edit","POST",jsonfile,function(){
			location.reload()
		},function(){
			swal({   title: "SUCCESS!",   text: "SELLERBRANCHTIMING EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/SellerBranchTimingEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "SELLERBRANCHTIMING NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
		
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function PackageCreationController($scope, $http, baseURL, $state, processReqService){
	$('.confirm').removeClass('show');
	$('#packagewizard').bootstrapWizard({
		'tabClass': 'nav nav-pills',
		'onTabClick': function(tab, navigation, index) {
			$("#packageForm").valid();
            return false;
    },
		'onNext': function(tab, navigation, index) {
	  	var $valid = $("#packageForm").valid();
	  	if(index==2){
	  		if(!$valid) {
	  			return false;
	  		}else{
	  			$('.confirm').addClass('show');
	  		}
	  	}
	  	if(!$valid) {
	  		return false;
			}
	  },
	  'onPrevious':function(tab, navigation, index){
	  	if(index==1 || index==0){
	  		$('.confirm').removeClass('show');
	  	}
	  }
	});
	$http({
    method: "GET",
    url: baseURL.IP+'/company/Company/all',
    data: '',
    headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        } 
  }).success(function(data) {
    $scope.companydetails=[];
    $.each(data['entities'],function(k,v){
      $.each(v['entities'],function(k1,v1){
        $scope.companydetails.push(v1);
      })
    })
  }).error(function(error){
		$scope.error = error;
  });
  $http({
    method: "GET",
    url: baseURL.IP+'/amountType/all',
    data: '',
    headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
	}).success(function(data) {
    $scope.amountTypeDetails = data.entities;
  }).error(function(error){
    $scope.error = error;
  });
  $scope.AddDays = function(SelectedDate) {
    var totalDays=parseInt($scope.package.packageNoOfDays);
    var filterDays=SelectedDate.split('/');
    var Days=parseInt(filterDays[0]);
    var Months=parseInt(filterDays[1]);
    var Years=parseInt(filterDays[2]);
    var d = new Date(Years,Months -1,Days);
    var time=new Date(d.setDate(d.getDate()+totalDays));
    var newDay=time.getDate();
    var newMonth=time.getMonth();
    var newYear=time.getFullYear();
    var NewDate=time.toJSON().split("-");
    var toDateDay=NewDate[2].substring(0, 2);
    var toDateMonth=NewDate[1];
    var toDateYear=NewDate[0];
    $scope.endDate=toDateDay+"/"+toDateMonth+"/"+toDateYear;
    $scope.package.packageEndDate=$scope.endDate;
  }
	$scope.save=function(packageData){
    $scope.packageMaster=angular.copy(packageData);
    $scope.packageMaster["$siren4j.class"] = "com.meat.representation.siren.PackagesRepresentation";
    $scope.packageMaster["placedByStatus"] = "Packages";
    $scope.jsonfile = 
                   {
                     "class":["package"],
                     "rel": ["item"],
                     "properties":$scope.packageMaster
                   };
    data=$scope.jsonfile;
    console.log(JSON.stringify($scope.jsonfile));
    processReqService.processReq(baseURL.IP+"/packages/create","POST",data,function(){$location.path("/PackageTemplate")},function(){});
  };
}
function PackageListController($scope, $http, baseURL, $state, dataTablesInitService){
		$http({
        method: "GET",
        url: baseURL.IP+'/packages/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
        var entities=[];
           $.each(data['entities'],function(k,v){
              entities.push({'Package':v.properties});
           })
           // console.log(entities );
                  var columns = [
            { "data": "Package.packageCode" },
            { "data": "Package.branchName" },
            { "data": "Package.packageName" },
            { "data": "Package.packageStartDate" },
            { "data": "Package.packageEndDate" },
            { "data": "Package.packageNoOfDays" },
            { "data": "Package.amountTypeValue" },
            { "data": "Package.status" },
            { "data": "Package.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/Package/'+row.Package.packageName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(entities,columns,'#PackageTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SinglePackageController($scope, $http, baseURL, $state, $stateParams){
	$scope.packageId=$stateParams.packageId;
	$scope.packageName=$stateParams.packageName;
	$http({
    method: "GET",
    url: baseURL.IP+'/packages/'+$scope.packageId,
    data: '',
    headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
  }).success(function(data) {
    $scope.PackageDetails=data;
  }).error(function(error){
    $scope.error = error;
  });
  $http({
    method: "GET",
    url: baseURL.IP+'/company/all',
    data: '',
    headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
  }).success(function(data) {
		$scope.allCompanies=[];
    $.each(data['entities'],function(kcom,vcom){
      var packageEdit={};
      $.each(vcom['entities'],function(kbranch,vbranch){
        packageEdit['branchId']=vbranch['properties'].id;
      })
      packageEdit['companyName']=vcom['properties'].companyName;
      $scope.allCompanies.push(packageEdit);
    });
  }).error(function(error){
    $scope.error = error;
  });    
	$http({
    method: "GET",
    url: baseURL.IP+'/amountType/all',
    data: '',
    headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }
  }).success(function(data) {
    $scope.amountTypeData=data;
  }).error(function(error){
    $scope.error = error;
  });
}
function OffersListController($scope, $http, baseURL, $state, dataTablesInitService){
$http({
        method: "GET",
        url: baseURL.IP+'/offer/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
 			  var entities=[];
           $.each(data['entities'],function(k,v){
              entities.push({'Offers':v.properties});
      
           })
           // console.log(entities );
                  var columns = [
            { "data": "properties.offerCode" },
            { "data": "properties.offerName" },
            { "data": "properties.offerFromDate" },
            { "data": "properties.offerToDate" },
            { "data": "properties.offerNoOfDays" },
            { "data": "properties.offerFromTime" },
            { "data": "properties.offerToTime" },
            { "data": "properties.amountTypeValue" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Offers/Offers/'+row.properties.offerName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#OffersTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function OffersCreationController($scope, $http, baseURL, $state, processReqFactory, $location){
	$scope.Offer={};
	$('.confirm').removeClass('show');
	$('#offerswizard').bootstrapWizard({
	  'tabClass': 'nav nav-pills',
	  'onTabClick': function(tab, navigation, index) {
		  $("#offersForm").valid();
	    return false;
    },
    'onFinish': function(tab, navigation, index){
     	$("#offersForm").valid();
    },
	  'onNext': function(tab, navigation, index) {
			var $valid = $("#offersForm").valid();
			// if(index==1){
				$scope.nextCount=index;
			// }
			if(index==4){
				if(!$valid) {
					return false;
				}else{
					$('.confirm').addClass('show');
				}
			}
			if(!$valid) {
				return false;
			}
		},
	  'onPrevious':function(tab, navigation, index){
	  	if(index==1 || index==0 || index==2 || index==3){
	  		$('.confirm').removeClass('show');
	  	}
	  }
	});
			$scope.offerData=function(offerRep,index){
				if(index==1){
					$scope.offerMaster=angular.copy(offerRep);
					$scope.offerMaster["$siren4j.class"]="com.meat.representation.siren.OfferRepresentation";
					$scope.offerMaster['offerNoOfDays']=offerRep['offerNoOfDays']+'';
					if(offerRep['quantity']){
						$scope.offerMaster['quantity']=offerRep['quantity']+'';
					}
					var offerFile={
			            "class": [
			                "offer"
			            ],
			            "rel": [
			                "item"
			            ],
			            "properties": $scope.offerMaster
        			}
        			console.log(JSON.stringify(offerFile));
							processReqFactory.processReq(baseURL.IP+"/offer/create","POST",offerFile,function(successdata){
			        	// console.log(JSON.stringify(successdata));
			        	$scope.OfferSuccessData=successdata;
			        // swal({   title: "Success!",   text: "OFFER CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
			         	},function(){
				     	// swal({   title: "ERROR!",   text: "OFFER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
				     	});
				}
			}

	processReqFactory.processReq(baseURL.IP+"/amountType/all","GET",'',function(data){
	  	 $scope.amountTypeDetails = data.entities;
	},function(error){});

	$scope.amountType=function(){
		var obj = $(".select2_demo_2").select2("data");
				$.each(obj,function(k,v){
					$scope.amountType=v.text;
				})
	}
	$scope.offerStatusChange=function(offerStatus){
    $scope.Selected=offerStatus;

    // category Data
	processReqFactory.processReq(baseURL.IP+"/category/categoryOnly","GET",'',function(data){
	 	// $scope.Offerscategory = data.entities;
	 	$scope.Offerscategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.Offerscategory.push(vcb);
	        });
	},function(error){});

	processReqFactory.processReq(baseURL.IP+"/item/itemOnly","GET",'',function(data){
	 	$scope.OffersItems=[];
	    $.each(data['entities'],function(kitem,vitem){
	      $scope.OffersItems.push(vitem);
	  	});
	},function(error){});

    processReqFactory.processReq(baseURL.IP+"/seller/sellerOnly","GET",'',function(data){
	 	$scope.Offersrestaurant=[];
    	$.each(data['entities'],function(kres,vres){
    		$scope.Offersrestaurant.push(vres);
    	});
	},function(error){});
    
    // seller branch data
    processReqFactory.processReq(baseURL.IP+"/sellerBranch/sellerBranchOnly","GET",'',function(data){
	 	$scope.OffersSellerBranch=[];
    	$.each(data['entities'],function(kres,vres){
    		$scope.OffersSellerBranch.push(vres);
    	});
	},function(error){});

	// seller Items only
    processReqFactory.processReq(baseURL.IP+"/sellerItem/sellerItemOnly","GET",'',function(data){
	 	$scope.OffersSellerItem=[];
    	$.each(data['entities'],function(kres,vres){
    		$scope.OffersSellerItem.push(vres);
    	});
	},function(error){});

	// subcategory data
    processReqFactory.processReq(baseURL.IP+"/subCategory/subCategoryOnly","GET",'',function(data){
	 	$scope.OfferssubCategory=[];
    	$.each(data['entities'],function(kres,vres){
    		$scope.OfferssubCategory.push(vres);
    	});
	},function(error){});
  }
  // showing the excluding data
  $scope.offerChange=function(includeData,Name){
  	$scope.excluSELLERITEM=false;
  	$scope.excluSUBCATEGORY=false;
  	$scope.excluCATEGORY=false;
  	$scope.excluSELLERBRANCH=false;
  	$scope.excluSELLER=false;
  	if(includeData=='ALL'){
  		$scope['exclu'+Name]=true;
  	}else if(includeData!='ALL'){
  		// $scope['exclu'+Name]=false;
  		if(Name=="SELLER"){
	    processReqFactory.processReq(baseURL.IP+'/sellerBranch/seller/'+includeData+'/sellerBranchOnly',"GET",'',function(data){
		 	$scope.OffersrestBranch=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.OffersrestBranch.push(vcb);
	        });
		},function(error){});
	       processReqFactory.processReq(baseURL.IP+'/category/seller/'+includeData+'/categoryOnly',"GET",'',function(data){
		 	$scope.Offerscategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.Offerscategory.push(vcb);
	        });
		  },function(error){});

	      processReqFactory.processReq(baseURL.IP+'/subCategory/seller/'+includeData+'/subCategoryOnly',"GET",'',function(data){
		 	$scope.OfferssubCategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.OfferssubCategory.push(vcb);
	        });
		  },function(error){});
    	}else if(Name=="SELLERBRANCH"){
	      processReqFactory.processReq(baseURL.IP+'/category/sellerBranch/'+includeData+'/categoryOnly',"GET",'',function(data){
		 	$scope.Offerscategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.Offerscategory.push(vcb);
	        });
	      },function(error){});
	      // End of selecting seller to display seller branch category only

	    processReqFactory.processReq(baseURL.IP+'/subCategory/sellerBranch/'+includeData+'/subCategoryOnly',"GET",'',function(data){
		 	$scope.OfferssubCategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.OfferssubCategory.push(vcb);
	        });
		},function(error){});
		// End of selecting seller to display seller branch category only

	    processReqFactory.processReq(baseURL.IP+'/sellerItem/sellerBranchItemOnly/'+includeData,"GET",'',function(data){
		 	$scope.OffersSellerItem=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.OffersSellerItem.push(vcb);
	        });
		},function(error){});
    	}else if(Name=="CATEGORY"){
        //on selecting category to display subcategories
         processReqFactory.processReq(baseURL.IP+'/subCategory/category/'+includeData+'/subCategoryOnly',"GET",'',function(data){
		 	$scope.OfferssubCategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.OfferssubCategory.push(vcb);
	        });
		},function(error){});
      }else if(Name=="SubCategory"){
      	
      	processReqFactory.processReq(baseURL.IP+'/subCategory/category/'+includeData+'/subCategoryOnly',"GET",'',function(data){
		 	$scope.OfferssubCategory=[];
	        $.each(data['entities'],function(kcb,vcb){
	          $scope.OfferssubCategory.push(vcb);
	        });
		},function(error){});

      }
    }
  }
    $scope.Offer={offerFromDate:''};
    $scope.dateChange=function(){
    	// $scope.Pack={startDate:''}
    	$scope.Offer['offerFromDate']=$scope.Offer['offerFromDate'].toLocaleDateString();
    	console.log($scope.Offer.offerFromDate);
    	var totalDays=parseInt($scope.Offer['offerNoOfDays'])
    	var filterDays=$scope.Offer['offerFromDate'].split('/');
      var Days=parseInt(filterDays[0]);
      var Months=parseInt(filterDays[1]);
      var Years=parseInt(filterDays[2]);
      var d = new Date(Years,Months -1,Days);
      var time=new Date(d.setDate(d.getDate()+totalDays));
      var newDay=time.getDate();
      var newMonth=time.getMonth();
      var newYear=time.getFullYear();
      var NewDate=time.toJSON().split("-");
      var toDateDay=NewDate[2].substring(0, 2);
      var toDateMonth=NewDate[1];
      var toDateYear=NewDate[0];
    	var endDate=toDateDay+"/"+toDateMonth+"/"+toDateYear;
    	$scope.Offer['offerToDate']=endDate;
    }

    $scope.save=function(offerData,excludingData,includeDataSELLERITEM,includeDataCATEGORY,includeDataSUBCATEGORY,includeDataSELLER,includeDataSELLERBRANCH){
    	var offerData=[];
    	var offerFinalData=[];
    	var offerExcludeData=[];
    	$scope.jsonfile={
            "class": [
                "offer"
            ],
            "rel": [
                "item"
            ],
            "properties": {
            	"$siren4j.class": "com.meat.representation.siren.OfferRepresentation",
            	"id":$scope.OfferSuccessData['properties'].id
            },
            "entities":offerFinalData
        }
        if($scope.OfferSuccessData['properties'].placedByStatus=="SELLERITEM" || $scope.OfferSuccessData['properties'].placedByStatus=="CATEGORY" || $scope.OfferSuccessData['properties'].placedByStatus=="SUBCATEGORY" || $scope.OfferSuccessData['properties'].placedByStatus=="SELLER" || $scope.OfferSuccessData['properties'].placedByStatus=="SELLERBRANCH" ){
        	var includeAllData={};
        	var OfferBy=$scope.OfferSuccessData['properties'].placedByStatus;
        	if($scope.OfferSuccessData['properties'].placedByStatus=="SELLERBRANCH"){
	          //include seller branch data
	           includeAllData["includeData"+OfferBy]=includeDataSELLERBRANCH;
	        }else if($scope.OfferSuccessData['properties'].placedByStatus=="SELLER"){
	          //include seller data
	           includeAllData["includeData"+OfferBy]=includeDataSELLER;
	        }else if($scope.OfferSuccessData['properties'].placedByStatus=="SUBCATEGORY"){
	          //include subcategory data
	           includeAllData["includeData"+OfferBy]=includeDataSUBCATEGORY;
	        }else if($scope.OfferSuccessData['properties'].placedByStatus=="CATEGORY"){
	          //include subcategory data
	           includeAllData["includeData"+OfferBy]=includeDataCATEGORY;
	        }else if($scope.OfferSuccessData['properties'].placedByStatus=="SELLERITEM"){
	        	includeAllData["includeData"+OfferBy]=includeDataSELLERITEM;
	        }
	        var OfferByStatus=OfferBy.replace(OfferBy,OfferBy.toLowerCase());
	        if(OfferByStatus=="subcategory"){
	        	OfferByStatus="subCategory";
	        }else if(OfferByStatus=="sellerbranch"){
	        	OfferByStatus="sellerBranch";
	        }else if(OfferByStatus=="selleritem"){
	        	OfferByStatus="sellerItem";
	        }
			if(includeAllData["includeData"+OfferBy]!="ALL"){

				$.each(includeAllData["includeData"+OfferBy],function(k,v){
	    			var Data={
						"class": ["offerConfig"],
						"rel": ["offerConfigRep"],
						"properties": {
							"placedByStatus": ""+OfferByStatus+"",
							"$siren4j.class": "com.meat.representation.siren.OfferConfigRepresentation",
							"offerId":$scope.OfferSuccessData['properties'].id,
							"status":"ACTIVE"
						}
					}
					Data['properties'][OfferByStatus+"Id"]=v;
					offerFinalData.push(Data)
    			})
			}else if(includeAllData["includeData"+OfferBy]=="ALL"){
				var Data={
						"class": ["offerConfig"],
						"rel": ["offerConfigRep"],
						"properties": {
							// 'sellerId':v,
							"placedByStatus": $scope.OfferSuccessData['properties'].placedByStatus,
							"offerAttributeName":$scope.OfferSuccessData['properties'].placedByStatus,
							"$siren4j.class": "com.meat.representation.siren.OfferConfigRepresentation",
							"offerId":$scope.OfferSuccessData['properties'].id,
							"status":"ACTIVE",
							"offerAttributeValue": "ALL"
						}
					}
					offerFinalData.push(Data)
			}
		}
		if(excludingData){
			$.each(excludingData,function(k,v){
				var offerExclude={
					"class": ["offerExcludeConfig"],
					"rel": ["offerExcludeConfigRep"],
					"properties": {
						"$siren4j.class": "com.meat.representation.siren.OfferExcludeConfigRepresentation",
						// ""+OfferByStatus+"Id": v,
						"placedByStatus": ""+OfferByStatus+"",
						"offerId":$scope.OfferSuccessData['properties'].id,
						"status": "ACTIVE"
					}
				}
				offerExclude['properties'][OfferByStatus+"Id"]=v;
			offerFinalData.push(offerExclude);
			})
		}
       data=$scope.jsonfile;
        console.log(JSON.stringify($scope.jsonfile));
        processReqFactory.processReq(baseURL.IP+"/offer/"+$scope.OfferSuccessData['properties'].id+"/edit","POST",data,function(){
        	// $location.path("/dashboards/OffersTemplate")},function(){});
        swal({   title: "Success!",   text: "OFFER CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	$location.path("/Offers/OffersTemplate");

         	$state.go('Offers.OffersTemplate');
	     	},function(){
	     	swal({   title: "ERROR!",   text: "OFFER NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
	     	});
    }
}
function SingleOfferController($scope, $http, processReqService, $stateParams, baseURL, $modal, $rootScope){
	$scope.offerId=$stateParams.offerId;
     $scope.offerName=$stateParams.offerName;
	$http({
        method: "GET",
        url: baseURL.IP+'/offer/'+$scope.offerId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
   
           $scope.singleOfferDetails = data;
         }).error(function(error){

            $scope.error = error;
         });
     $scope.editOffer=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/RestaurantBranchEmployeeEditTemplate.html',
				controller: RestaurantEmployeeEditController
			});
			$rootScope.RestaurantEmployeeEditData=data;
        }
}
function ComboPackCreationController($scope, $http, baseURL, $state, processReqFactory){
	$('.confirm').removeClass('show');
	$('#comboPackwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#comboPackForm").valid();

                return false;
        },
        'onFinish': function(tab, navigation, index){
        	$("#comboPackForm").valid();
        },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#comboPackForm").valid();
	  			if(index==2){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$('#comboPackRestwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#comboPackRestForm").valid();

                return false;
        },
        'onFinish': function(tab, navigation, index){
        	$("#comboPackForm").valid();
        },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#comboPackRestForm").valid();
	  			if(index==2){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	// Amount Type
	$http({
	    method: "GET",
	    url: baseURL.IP+'/amountType/all',
	    data: '',
	    headers: {
	           'Content-Type': "application/vnd.siren+json",
	           'Accept': "application/vnd.siren+json"
	        }
  }).success(function(data) {
    $scope.amountTypeDetails = data.entities;
  }).error(function(error){
    $scope.error = error;
  });
	$scope.restaurantView=false;
	$scope.categoryView=true;
	$scope.combopackView=function(data){
		if(data=="restaurantView"){
			$scope.restaurantView=true;
			$scope.categoryView=false;
		}else{
			$scope.categoryView=true;
			$scope.restaurantView=false;
		}
	}
	$http({
      method: "GET",
      url: baseURL.IP+'/category/all',
      data: '',
      headers: {
           'Content-Type': "application/vnd.siren+json",
           'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      $scope.catagoriesEntities = data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    $http({
        method: "GET",
        url: baseURL.IP+'/timingDetails/getTimingDetailsOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
      
      $scope.timingDetails=data.entities;
    }).error(function(error){
      $scope.error = error;
    });
    $http({
        method: "GET",
        url: baseURL.IP+'/restaurant/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
      $scope.restaurantEntities=[];
      $.each(data['entities'],function(k,v){
        if(v.entities){
          $.each(v['entities'],function(k1,v1){
          	$scope.restaurantEntities.push({'supplier':v.properties,'branch':v1.properties});
					})
      	}
      })
    }).error(function(error){
			$scope.error = error;
    });
  	$scope.changeRestaurant=function(branchId){
      $http({
        method: "GET",
        url: baseURL.IP+'/subCategory/restaurantBranch/'+branchId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    	}).success(function(data) {
        $scope.subCategoryEntities=[];
        $.each(data['entities'],function(k,v){
          $scope.subCategoryEntities.push(v);
        })
      }).error(function(error){
				$scope.error = error;
      });
      var obj = $(".select2_demo_1").select2("data");
			$.each(obj,function(k,v){
				$scope.restaurantBranchName=v.text;
			})
    }
    $scope.changesubCategory=function(subCategory){
    	$http({
        method: "GET",
        url: baseURL.IP+'/restaurantItem/subCategory/'+subCategory+'/restaurantItemOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    	}).success(function(data) {
        $scope.subCategoryItemsEntities=[];
        $.each(data['entities'],function(k,v){
          $scope.subCategoryItemsEntities.push(v);
        })
      }).error(function(error){
				$scope.error = error;
      });
      var obj = $(".select2_demo_3").select2("data");
			$.each(obj,function(k,v){
				$scope.subCategoryName=v.text;
			})
		var obj = $(".select2_demo_2").select2("data");
			$.each(obj,function(k,v){
				$scope.timingName=v.text;
			})
    }
    $scope.itemChange=function(itemsData,data){
    	console.log(itemsData)
    	$scope.itemcost=[];
    	var obj = $(".select2_demo_4").select2("data");
    	$scope.itemName=[];
			$.each(obj,function(k,v){
				$scope.itemName.push(v.text);
				$.each(v.element.attributes,function(kp,vp){
					if(vp.nodeName=='data-price'){
						$scope.itemcost.push(vp.value);
					}
					
				})
			})
			var total=0;
			for(var i in $scope.itemcost) { 
			 total += parseInt($scope.itemcost[i]); 
			}
			$scope.comboPack['actualCost']=total+'';
    }
  $scope.saveComboPack=function(comboPackData,timings,itemsData){
      var comboObjData=[];
      $scope.timingsMaster={};
      $scope.ComboPackMaster=angular.copy(comboPackData);
      $scope.timingsMaster=angular.copy(timings);
      $scope.timingsMaster['$siren4j.class']="com.meat.representation.siren.PackTimingsRepresentation",
      $scope.timingsMaster['packTimingsStatus']="Active",
      $scope.ComboPackMaster['$siren4j.class']="com.meat.representation.siren.PackRepresentation",
      $scope.ComboPackMaster['packCost']=$scope.comboPack['packCost']+'';
      // $scope.ComboPackMaster['packNoOfDays']=$scope.comboPack['packNoOfDays']+'';
      $.each(itemsData,function(kitem,vitem){
        var comboItemsData={
            "class": [
                "packRestaurantItem"
            ],
            "rel": [
                "packRestaurantItemRep"
            ],
            "properties": {
                "$siren4j.class": "com.meat.representation.siren.PackRestaurantItemRepresentation",
                "restaurantItemId": vitem,
                "packRestaurantItemStatus": "Active"
            }
          }
          comboObjData.push(comboItemsData);
      })
      comboObjData.push({
            "class": [
                "packTiming"
            ],
            "rel": [
                "packTimingsRep"
            ],
            "properties": $scope.timingsMaster
          })
         $scope.jsonfile = 
                     {
                       "class":["pack"],
                       "rel": ["item"],
                       "properties":$scope.ComboPackMaster,
                       "entities":comboObjData
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqFactory.processReq(baseURL.IP+"/pack/create","POST",data,function(){
                     	// $location.path("/ComboPackTemplate")},function(){});
                     	swal({   title: "Success!",   text: "COMBOPACK CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	$state.go('dashboards.ComboPackTemplate')
                     },function(){
                     	swal({   title: "ERROR!",   text: "COMBOPACK NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
    };
}
function ComboPackListController($scope, $http, baseURL, $state, dataTablesInitService){
		$http({
        method: "GET",
        url: baseURL.IP+'/pack/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
        var entities=[];
           $.each(data['entities'],function(k,v){
            entities.push({'ComboPack':v.properties});
           });
           // console.log(JSON.stringify(entities));
                  var columns = [
            { "data": "ComboPack.packCode" },
            { "data": "ComboPack.packName" },
            { "data": "ComboPack.actualCost" },
            { "data": "ComboPack.packCost" },
            { "data": "ComboPack.status" },
            { "data": "ComboPack.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/ComboPack/'+row.ComboPack.packName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(entities,columns,'#comboPackTable');
         }).error(function(error){

            $scope.error = error;
         });

}
function SingleComboPackController($scope, $http, baseURL, $state, $stateParams){
	$scope.PackName=$stateParams.packName;
$scope.PackId=$stateParams.packId;
 $http({
        method: "GET",
        url: baseURL.IP+'/pack/'+$scope.PackId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
        $scope.packData=data;
        $scope.restaurantPackItem=[];
        $.each($scope.packData['entities'],function(key,val){
          if(val.class=="packRestaurantItem"){
            $scope.restaurantPackItem.push(val);
          }
        })
         }).error(function(error){

            $scope.error = error;
         });
}
function CouponCreationController($scope, $http, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#couponwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#couponForm").valid();

                return false;
        },
        'onFinish': function(tab, navigation, index){
        	$("#couponForm").valid();
        },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#couponForm").valid();
	  			if(index==2){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           $scope.companydetails=[];
           $.each(data['entities'],function(k,v){
            $.each(v['entities'],function(k1,v1){
              $scope.companydetails.push(v1);
            })
    
           })
         
         }).error(function(error){

            $scope.error = error;
         });
      $http({
        method: "GET",
        url: baseURL.IP+'/amountType/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      
         $scope.amountTypeDetails = data.entities;
         }).error(function(error){

            $scope.error = error;
         });

}
function CouponListController($scope, $http, baseURL, $state){

}
function CompanyCreationController( $scope, $http, processReqFactory, baseURL, $location, $state){
	$('.confirm').removeClass('show');
	$('#companywizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#companyForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#companyForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$scope.companyImagePathData=[];
        $scope.companyImage={};
        $scope.companyImage['imageName']="companyLogo";
        $scope.companyImage['imageType']="logo";
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
          formData.append('folder', 'Company');
          if(imgType == "image"){
            //$scope.categoryThumbImage={};
            $.ajax({   
            type: "POST",
            url: '/upload/uploadFile',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
                //alert(response);
                console.log(JSON.stringify(response));
                if(el.name=="companylogoImage"){
                  $scope.companyImage['companylogoImage']=response.replace(/\\/g,"/");
                  $scope.companyImagePathData.push($scope.companyImage);
                  $('.companylogoImgPath').html('<img src="'+$scope.companyImage['companylogoImage']+'" alt="imageLocationLogo" width="100%" height="50px" />');
                }
               
            },
            error:function(){
                alert("failure");
            }
          });
          }else{
            alert('Please Upload Image');
          }
          
        }

	 $http({
        method: "GET",
        url: baseURL.IP+'/zone/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.zonesCompanyDetails = data;
         }).error(function(error){

            $scope.error = error;
         });
     $scope.save = function(company,companyBranch,companyAddress) {
     	var companyZoneData=[];
        $scope.companymaster = angular.copy(company);
        console.log($scope.companymaster);
        $scope.companymaster["$siren4j.class"] = "com.meat.representation.siren.CompanyRepresentation";
        $scope.companymaster["companyType"] = "Company";
        $scope.companyBranchmaster=angular.copy(companyBranch);
        $scope.companyBranchmaster["$siren4j.class"] = "com.meat.representation.siren.CompanyBranchRepresentation";
        $scope.companyBranchmaster["branchStatus"] = "Active";
        console.log($scope.companyBranchmaster);
        $scope.companyAddressmaster=angular.copy(companyAddress);
        $scope.companyAddressmaster["$siren4j.class"] = "com.meat.representation.siren.AddressRepresentation";
        $scope.companyAddressmaster["zipcode"] = $scope.companyAddress['zipcode']+'';
        console.log($scope.companyAddressmaster);
        
        companyZoneData.push(
        {
                    "class": [
                        "address"
                    ],
                    "rel": [
                        "addressRep"
                    ],
                    "properties":$scope.companyAddressmaster
        })
        $scope.jsonfile = 
                     {
                       "class":["company"],
                       "rel": ["item"],
                       "properties":$scope.companymaster,
                       "entities": [
        {
            "class": [
                "companyBranch"
            ],
            "rel": [
                "companyBranchRep"
            ],
            "properties": $scope.companyBranchmaster,
            "entities": companyZoneData
        }
    ]
         };
         data=$scope.jsonfile;
         console.log(JSON.stringify($scope.jsonfile));
         processReqFactory.processReq(baseURL.IP+"/company/create","POST",data,function(){
         	
         	swal({   title: "Success!",   text: "COMPANY CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	$state.go('dashboards.CompanyTemplate')
         },function(){
         	swal({   title: "ERROR!",   text: "COMPANY NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
         });
      };
}
function CompanyBranchCreationController( $scope, $http, processReqFactory, baseURL, $location, $state){
	$('.confirm').removeClass('show');
	$('#companyBranchwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#companyBranchForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#companyBranchForm").valid();
	  			if(index==2){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 ){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});

	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
          $scope.allCompanies=[];
      $.each(data['entities'],function(kcom,vcom){
              companyCreate={};
              companyCreate['id']=vcom['properties'].id;
              companyCreate['companyName']=vcom['properties'].companyName;
              $scope.allCompanies.push(companyCreate);
      });
       console.log(JSON.stringify($scope.allCompanies));
       
    }).error(function(error){
      $scope.error = error;
    });    

    $http({
        method: "GET",
        url: baseURL.IP+'/zone/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.zonesCompanyAllDetails = data;
         }).error(function(error){

            $scope.error = error;
         });
     $scope.changeCompany=function(){
     	var obj = $(".select2_demo_1").select2("data");
			$.each(obj,function(k,v){
				$scope.companyBranchName=v.text;
			})
     }
     $scope.save = function(company,companyBranch,companyAddress) {
        $scope.companyBranchmaster=angular.copy(companyBranch);
        $scope.companyBranchmaster["$siren4j.class"] = "com.meat.representation.siren.CompanyBranchRepresentation";
        $scope.companyBranchmaster["branchStatus"] = "Active";
        console.log($scope.companyBranchmaster);
        $scope.companyAddressmaster=angular.copy(companyAddress);
        $scope.companyAddressmaster["$siren4j.class"] = "com.meat.representation.siren.AddressRepresentation";
        $scope.companyAddressmaster["zipcode"] = $scope.companyAddress['zipcode']+'';
        console.log($scope.companyAddressmaster);
        $scope.jsonfile = 
                     
        {
            "class": [
                "companyBranch"
            ],
            "rel": [
                "item"
            ],
            "properties": $scope.companyBranchmaster,
            "entities": [
                {
                    "class": [
                        "address"
                    ],
                    "rel": [
                        "addressRep"
                    ],
                    "properties":$scope.companyAddressmaster
                }
            ]
        
             };
             data=$scope.jsonfile;
             console.log(JSON.stringify($scope.jsonfile));
             processReqFactory.processReq(baseURL.IP+"/companyBranch/create","POST",data,function(){
             
             	swal({   title: "Success!",   text: "COMPANY BRANCH CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
             	$state.go('dashboards.CompanyTemplate')
             },function(){
             	swal({   title: "ERROR!",   text: "COMPANY BRANCH NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
             });

      };
}
function CompanyController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
           var entities=[];
           $.each(data['entities'],function(k,v){
           	entities.push({'company':v.properties});
           	if(v.entities){
           	$.each(v['entities'],function(k1,v1){
           		
           	})
			}
           })
                  var columns = [
            { "data": "company.companyName" },
            { "data": "company.companyPhoneNo" },
            { "data": "company.status" },
            { "data": "company.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/Company/'+row.company.companyName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(entities,columns,'#companyTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleCompanyController( $scope, $http, $stateParams, baseURL, processReqFactory){
	 $scope.companyName=$stateParams.companyName;
      $scope.companyId=$stateParams.companyId;

    $http({
        method: "GET",
        url: baseURL.IP+'/company/'+$scope.companyId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
   			$scope.userDetails=[];
   			$scope.branchDetails=[];
           	$scope.singleCompanyDetails = data;
           	$.each(data['entities'],function(k,v){
           		$('.newImage').addClass('show');
	            if(v.class=="companyBranch"){
	              $scope.branchDetails.push(v['properties']);
	            }else if(v.class=='companyImage'){
	            	$scope.ImageDetails=v['properties'];
	            }else{
	            	$('.newImage').addClass('hide');
	            }
	            if(v.entities){
	            $.each(v['entities'],function(k1,v1){
	              if(v1.class=="address"){
	                $scope.addressDetails=v1['properties'];
	              }
	              if(v1.class=="user"){
	                $scope.userDetails.push(v1);
	              }
	            })
	        	}
           })
         }).error(function(error){

            $scope.error = error;
         });
     $scope.companyImagePathData=[];
        $scope.companyImage={};
        $scope.companyImage['imageName']="companyLogo";
        $scope.companyImage['imageType']="logo";
        $scope.companyImage['$siren4j.class']="com.meat.representation.siren.CompanyImagesRepresentation"
        $scope.companyImage['companyId']=$scope.companyId;
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
          formData.append('folder', 'Company');
          if(imgType == "image"){
            //$scope.categoryThumbImage={};
            $.ajax({   
            type: "POST",
            url: '/upload/uploadFile',
            beforeSend: function(req) {
              req.setRequestHeader("Accept", "application/json");
            },
            data:formData,
            processData: false,
            contentType: false,
            success: function(response) {
                //alert(response);
                console.log(JSON.stringify(response));
                if(el.name=="imageLocation"){
                  $scope.companyImage['imageLocation']=response.replace(/\\/g,"/");
                  $scope.companyImagePathData.push($scope.companyImage);
                  $('.companylogoImgPath').html('<img src="'+$scope.companyImage['imageLocation']+'" alt="imageLocationLogo" width="100%" height="50px" />');
                }
               
            },
            error:function(){
                alert("failure");
            }
          });
          }else{
            alert('Please Upload Image');
          }
          
        }
        $scope.addImage=function(){
        	$scope.companyImageData={};
        	console.log(JSON.stringify($scope.companyImagePathData));
        	$.each($scope.companyImagePathData,function(k,v){
        		$scope.companyImageData=v;
        	})
        	
        	var jsonfile = {
	                       	"class": [
				                "companyImage"
				            ],
				            "rel": [
				                "companyImageRep"
				            ],
				            "properties":$scope.companyImageData
	                       }
                       
            console.log(JSON.stringify(jsonfile));
            processReqFactory.processReq(baseURL.IP+"/companyImages/create","POST",jsonfile,function(){
                     	
                     	swal({   title: "Success!",   text: "COMPANY IMAGE CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	location.reload();
                     },function(){
                     	swal({   title: "ERROR!",   text: "COMPANY IMAGE NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
        }
}
function CompanyEmployeeCreationController( $scope, $http, processReqFactory, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#companyEmployeewizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#companyEmployeeForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#companyEmployeeForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}

	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
           $scope.companydetails=[];
           // var entities=[];
           $.each(data['entities'],function(k,v){
            
            $.each(v['entities'],function(k1,v1){
              
              $scope.companydetails.push(v1);
            })
    
           })
         
         }).error(function(error){

            $scope.error = error;
         });
        	$scope.customer={dob:''};
        
         $scope.save = function(customer) {
         	if($scope.restaurant['password']!=$scope.restaurant['confirmPassword']){
	  				alert("Your password and confirmation password do not match.");
	  				return false;
	  			}
         	
         	$scope.customer.dob=$scope.customer['dob'].toLocaleDateString();
		    
					$scope.usermaster=angular.copy(customer);
				 	$scope.usermaster["$siren4j.class"] = "com.meat.representation.siren.UserRepresentation";
				 	$scope.usermaster["userType"] = "Customer";


        	$scope.jsonfile = 
                     {
                       "class":["user"],
                       "rel": ["item"],
                       "properties":$scope.usermaster
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));

                if($scope.restaurant['password']!=$scope.restaurant['confirmPassword']){
	  				alert("Your password and confirm password do not match.");
	  			}else{
                     processReqFactory.processReq(baseURL.IP+"/user/create","POST",data,function(){
                     	
                      	swal({   title: "Success!",   text: "COMPANY EMPLOYEE CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	$state.go('dashboards.CompanyEmployeeTemplate')
                     },function(){
                     	swal({   title: "ERROR!",   text: "COMPANY EMPLOYEE NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
                }
      };
}

function CompanyEmployeeController( $scope, $http, dataTablesInitService, baseURL){
	 $http({
        method: "GET",
        url: baseURL.IP+'/user/Customer/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
                  var columns = [
            { "data": "properties.userCode" },
            { "data": "properties.userName" },
            { "data": "properties.companyName" },
            { "data": "properties.branchName" },
            { "data": "properties.phoneNo" },
            { "data": "properties.emailId" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/CompanyEmployee/'+row.properties.userName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#companyEmployeeTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleCompanyEmployeeController( $scope, $http, $stateParams, baseURL, $modal, $rootScope){
	 $scope.userId=$stateParams.userId;
     $scope.userName=$stateParams.userName;
    $http({
        method: "GET",
        url: baseURL.IP+'/user/'+$scope.userId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.companyuserdetails=data;   
         }).error(function(error){
            $scope.error = error;
         });

         $scope.update=function(data){
        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CompanyEmployeeEditTemplate.html',
				controller: CompanyEmployeeEditController
			});
			$rootScope.CompanyEmployeeEditData=data;
        } 
}
function CompanyEmployeeEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
  	$scope.update = function(customer) {
  			$scope.CompanyEmployeeEditData.dob=$scope.CompanyEmployeeEditData['dob'].toLocaleDateString();
  		var jsonfile={
  			"class":["user"],
  			"properties":customer
  		}
       console.log(JSON.stringify(jsonfile));
       processReqService.processReq(baseURL.IP+"/user/"+customer.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
       	swal({   title: "SUCCESS!",   text: "CompanyEmployee EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/CompanyEmployeeEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "CompanyEmployee NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
    }
    $scope.cancel=function(){
    	$modalInstance.close();
    }
}
function CompanyAdminCreationController($scope, $http, processReqFactory, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#companyAdminwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#companyAdminForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#companyAdminForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
           $scope.companydetails=[];
           // var entities=[];
           $.each(data['entities'],function(k,v){
            
            $.each(v['entities'],function(k1,v1){
              
              // entities.push({'company':v.properties,'branch':v1.properties});
              $scope.companydetails.push(v1);
              console.log(JSON.stringify($scope.companydetails));
            })
    
           }) 
       }).error(function(error){

            $scope.error = error;
         });
      
      $scope.save = function(admin) {
      	 
        $scope.companyAdminMaster = angular.copy(admin);
        console.log($scope.companyAdminMaster);
        $scope.companyAdminMaster["$siren4j.class"] = "com.meat.representation.siren.UserRepresentation",
        $scope.companyAdminMaster["userType"] = "CompanyAdmin",
        $scope.jsonfile = 
                     {
                       "class":["user"],
                       "rel": ["item"],
                       "properties":$scope.companyAdminMaster
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqFactory.processReq(baseURL.IP+"/user/create","POST",data,function(){
                      	swal({   title: "Success!",   text: "COMPANY ADMIN CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	$state.go('dashboards.CompanyAdminTemplate')
                     },function(){
                     	swal({   title: "ERROR!",   text: "COMPANY ADMIN NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
      };
}
function CompanyAdminController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/user/CompanyAdmin/All', 
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            },
    }).success(function(data) {
                  var columns = [
            { "data": "properties.userCode" },
            { "data": "properties.userName" },
            { "data": "properties.companyName" },
            { "data": "properties.branchName" },
            { "data": "properties.phoneNo" },
            { "data": "properties.emailId" },
            { "data": "properties.status" },
            { "data": "properties.companyBranchId",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/CompanyAdmin/'+row.properties.userName+'/'+row.properties.id+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#CompanyAdminTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleCompanyAdminController( $scope, $http, processReqService, $stateParams, baseURL, $modal, $rootScope){
	$scope.userId=$stateParams.userId;
     $scope.userName=$stateParams.userName;
    $http({
        method: "GET",
        url: baseURL.IP+'/user/'+$scope.userId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.companyAdmindetails=data;   
         }).error(function(error){
            $scope.error = error;
         });

          $scope.update=function(data){
	        	var modalInstance = $modal.open({
						templateUrl: '/Admin/views/CompanyAdminEditTemplate.html',
						controller: CompanyAdminEditController
						});
						$rootScope.CompanyAdminEditData=data;
        	}
}
function CompanyAdminEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
  	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
           $scope.companydetails=[];
           // var entities=[];
           $.each(data['entities'],function(k,v){
            
            $.each(v['entities'],function(k1,v1){
              $scope.companydetails.push(v1);
            })
    
           }) 
       }).error(function(error){

            $scope.error = error;
         });
  	$scope.update = function(customer) {
  		var jsonfile={
  			"class":["user"],
  			"properties":customer
  		}
       console.log(JSON.stringify(jsonfile));
       processReqService.processReq(baseURL.IP+"/user/"+customer.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
       	swal({   title: "SUCCESS!",   text: "COMPANYADMINEDIT EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/CompanyAdminEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "COMPANYADMINEDIT NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
    }
    $scope.cancel=function(){
    	$modalInstance.close();
    }
}
function CompanyTimingCreationController($scope, $http, processReqFactory, baseURL,$location){
	$('.confirm').removeClass('show');
	$('#companyTimingwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#companyTimingForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#companyTimingForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
           $scope.companyDataDetails=[];
           $.each(data['entities'],function(k,v){            
            $.each(v['entities'],function(k1,v1){
              
              $scope.companyDataDetails.push(v1);
            })
    
           })
         
         }).error(function(error){

            $scope.error = error;
         });
    $http({
        method: "GET",
        url: baseURL.IP+'/timingDetails/getTimingDetailsOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           $scope.companyTimingDetails=data.entities;
         
         }).error(function(error){

            $scope.error = error;
         });
         $scope.save=function(companyBranch,timing){
          $scope.RestaurantMaster=angular.copy(companyBranch);
          $scope.TimingMaster=angular.copy(timing);
          $scope.RestaurantMaster["$siren4j.class"] = "com.meat.representation.siren.CompanyBranchRepresentation",
          $scope.TimingMaster["$siren4j.class"] = "com.meat.representation.siren.TimingsRepresentation",
          $scope.jsonfile = 
                                             {
                            "class": [
                                "companyBranch"
                            ],
                            "rel": [
                                "item"
                            ],
                            "properties": $scope.RestaurantMaster,
                            "entities": [
                                {
                                    "class": [
                                        "timing"
                                    ],
                                    "rel": [
                                        "timingsRep"
                                    ],
                                    "properties": $scope.TimingMaster,
                                
                            }
                            ]
                        };
             data=$scope.jsonfile;
             console.log(JSON.stringify($scope.jsonfile));
             processReqFactory.processReq(baseURL.IP+"/companyBranch/create","POST",data,function(){$location.path('/dashboards/CompanyTimings')},function(){});
      };
}
function CompanyTimingsController($scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/companyBranchTimings/companyBranchTimingsOnly', 
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            },
    }).success(function(data) {
      var companyTimingsData=[];
      if(data.entities){
        $.each(data['entities'],function(k1,v1){
                    companyTimingsData.push({'timings':v1.properties});
                 
        })
        }
           var columns = [
            { "data": "timings.companyName" },
            { "data": "timings.branchName" },
            { "data": "timings.timingName" },
            { "data": "timings.startTime" },
            { "data": "timings.endTime" },
            { "data": "timings.timingsId",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/CompanyTimings/'+row.timings.id+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(companyTimingsData,columns,'#companyTimingsTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleCompanyTimingsController( $scope, $http, processReqService, $stateParams, baseURL, $modal, $rootScope){
	$scope.branchTimingsId=$stateParams.branchTimingsId;
     $scope.TimingsId=$stateParams.TimingsId;
    $http({
        method: "GET",
        url: baseURL.IP+'/companyBranchTimings/'+$scope.branchTimingsId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.companyBranchTimingsdetails=data;   
         }).error(function(error){
            $scope.error = error;
         });

          $scope.BranchTimingsEdit=function(data){
	        	var modalInstance = $modal.open({
						templateUrl: '/Admin/views/CompanyTimingsEditTemplate.html',
						controller: BranchTimingsEditController
						});
						$rootScope.BranchTimingsEditData=data;
        	}
}
function BranchTimingsEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
  	$http({
        method: "GET",
        url: baseURL.IP+'/company/Company/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
      $scope.companydetails=[];
      $.each(data['entities'],function(k,v){
        $.each(v['entities'],function(k1,v1){
          $scope.companydetails.push(v1);
        })
    	}) 
    }).error(function(error){
			 	$scope.error = error;
    });
      $http({
        method: "GET",
        url: baseURL.IP+'/timingDetails/getTimingDetailsOnly',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            } 

    }).success(function(data) {
           $scope.companyTimingDetails=data.entities;
         
         }).error(function(error){

            $scope.error = error;
         });
  	$scope.update = function(BranchTimingsEditData) {
  		var jsonfile={
  			"class":["companyBranchTimings"],
  			"properties":BranchTimingsEditData
  		}
      console.log(JSON.stringify(jsonfile));
      processReqService.processReq(baseURL.IP+"/companyBranchTimings/"+BranchTimingsEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
      	swal({   title: "SUCCESS!",   text: "BRANCHTIMINGS EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/BranchTimingsEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "BRANCHTIMINGS NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});
    }
    $scope.cancel=function(){
    	$modalInstance.close();
    }
}
function meatCreationController( $scope, $http, baseURL, processReqFactory, $location){
	$('.confirm').removeClass('show');
	$('#meatwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#meatForm").valid();

                return false;
        	},
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#meatForm").valid();
	  			
	  			if(index==3){
	  				if(!$valid) {
	  				return false;
	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			if(!$valid) {
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==2 || index==0){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	$http({
        method: "GET",
        url: baseURL.IP+'/zone/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

      }).success(function(data) {
           $scope.zonesDetails = data;
         }).error(function(error){

            $scope.error = error;
         });
 					$scope.zonechange=function(){
 						var obj = $(".select2_demo_3").select2("data");
						$.each(obj,function(k,v){
							$scope.ZoneName=v.text;
						})
 					}
         $scope.save = function(company,companyBranch,companyAddress) {
        $scope.companymaster = angular.copy(company);
     
    $scope.companymaster["$siren4j.class"] = "com.meat.representation.siren.CompanyRepresentation";
   $scope.companymaster["companyType"] = "meat";
   
        $scope.companyBranchmaster=angular.copy(companyBranch);
         $scope.companyBranchmaster["$siren4j.class"] = "com.meat.representation.siren.CompanyBranchRepresentation";
         $scope.companyBranchmaster["branchStatus"] = "Active";
      
		$scope.companyAddressmaster=angular.copy(companyAddress);
		$scope.companyAddressmaster['zipcode']=$scope.meatAddress['zipcode']+'';
 		$scope.companyAddressmaster["$siren4j.class"] = "com.meat.representation.siren.AddressRepresentation";

        $scope.jsonfile = 
                     {
                       "class":["company"],
                       "rel": ["item"],
                       "properties":$scope.companymaster,
                       "entities": [
        {
            "class": [
                "companyBranch"
            ],
            "rel": [
                "companyBranchRep"
            ],
            "properties": $scope.companyBranchmaster,
            "entities": [
                {
                    "class": [
                        "address"
                    ],
                    "rel": [
                        "addressRep"
                    ],
                    "properties":$scope.companyAddressmaster
                }
            ]
        }
    ]
         };
         data=$scope.jsonfile;
         console.log(JSON.stringify($scope.jsonfile));
         processReqFactory.processReq(baseURL.IP+"/company/create","POST",data,function(){
         	
         swal({   title: "SUCCESS!",   text: "meat CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       	$location.path('#/Meat/meatTemplate')
       	//$state.go('dashboards.ItemsTemplate');
       },function(){
       	swal({   title: "ERROR!",   text: "meat NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
       });
      };
}
function MeatListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/company/meat/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           // $scope.restaurantsdetails = data;
           var entities=[];
           if(data.entities){
           $.each(data['entities'],function(k,v){
            if(v.entities){
            $.each(v['entities'],function(k1,v1){
              entities.push({'company':v.properties,'branch':v1.properties});

            })
      }
           })
       }
                  var columns = [
            { "data": "company.companyCode" },
            { "data": "company.companyName" },
            { "data": "company.companyPhoneNo" },
            { "data": "branch.branchName" },
            { "data": "branch.phoneNo" },
            { "data": "company.status" },
            { "data": "company.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Meat/Meat/'+row.company.companyName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(entities,columns,'#meatTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SinglemeatController( $scope, $http, baseURL, processReqService, $stateParams, $modal, $rootScope){
	$scope.meatName=$stateParams.meatName;
	$scope.meatId=$stateParams.meatId;
	$http({
        method: "GET",
        url: baseURL.IP+'/company/'+$scope.meatId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      $scope.singlemeatDetails=data;
      $scope.singlemeatBranchDetails=[];
      $scope.singlemeatAddressDetails=[];
      $.each(data['entities'],function(k,v){
      	$scope.singlemeatBranchDetails.push(v);
        $.each(v['entities'],function(k1,v1){
          $scope.singlemeatAddressDetails.push(v1);
        })
    	})
    	console.log(JSON.stringify($scope.singlemeatBranchDetails));
    }).error(function(error){
			$scope.error = error;
    });
}
function meatEmployeeCreationController( $scope, $http, processReqFactory, baseURL){
	 	$('.confirm').removeClass('show');
	$('#meatEmployeewizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#meatEmployeeForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#meatEmployeeForm").valid();
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});	
	 $http({
        method: "GET",
        url: baseURL.IP+'/company/AppOwner/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           /*$scope.superAdminDetails;*/
           $.each(data['entities'],function(k,v){
            
            $.each(v['entities'],function(k1,v1){
              
             $scope.superAdminDetails=v1['properties'].id;
             
            })
    
           })
         
         }).error(function(error){

            $scope.error = error;
         });

         $scope.save = function(meatEmployee) {

		$scope.usermaster=angular.copy(meatEmployee);
 		$scope.usermaster["$siren4j.class"] = "com.meat.representation.siren.UserRepresentation";
 		$scope.usermaster["userType"] = "meatEmployee";
 		$scope.usermaster["companyBranchId"] = $scope.superAdminDetails;
        $scope.jsonfile = 
                     {
                       "class":["user"],
                       "rel": ["item"],
                       "properties":$scope.usermaster
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqFactory.processReq(baseURL.IP+"/user/create","POST",data,function(){},function(){});
      };
}
function meatEmployeeListController( $scope, $http, dataTablesInitService, baseURL){
 $http({
        method: "GET",
        url: baseURL.IP+'/user/meatEmployee/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
                  var columns = [
            { "data": "properties.userCode" },
            { "data": "properties.userName" },
            { "data": "properties.companyName" },
            { "data": "properties.branchName" },
            { "data": "properties.phoneNo" },
            { "data": "properties.emailId" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Meat/MeatEmployee/'+row.properties.userName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#meatEmployeeTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SinglemeatEmployeeController($scope, $http, baseURL, processReqFactory, $location, $stateParams){
	$scope.employeeName=$stateParams.employeeName;
     $scope.employeeId=$stateParams.employeeId;
    $http({
        method: "GET",
        url: baseURL.IP+'/user/'+$scope.employeeId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.employeeDetails=data;   
         }).error(function(error){
            $scope.error = error;
         });

          $scope.editCriteria=function(data){
	        	var modalInstance = $modal.open({
						templateUrl: '/Admin/views/CriteriaEditTemplate.html',
						controller: CriteriaEditController
						});
						$rootScope.CriteriaEditData=data;
        	}
}
function meatAdminCreationController($scope, $http, baseURL, processReqFactory, $location){
	$('.confirm').removeClass('show');
	$('#meatAdminwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#meatAdminForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#meatAdminForm").valid();
	  			
	  			if(!$valid) {
	  				return false;
	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});	
	$http({
        method: "GET",
        url: baseURL.IP+'/company/meat/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $.each(data['entities'],function(k,v){
            
            $.each(v['entities'],function(k1,v1){
              
             $scope.superAdminDetails=v1['properties'].id;
             
            })
    
           })
         
         }).error(function(error){

            $scope.error = error;
         });
			$scope.meatAdmin={dob:''};
         $scope.save = function(meatAdmin) {
				$scope.meatAdmin.dob=$scope.meatAdmin['dob'].toLocaleDateString();
				$scope.usermaster=angular.copy(meatAdmin);
				$scope.usermaster["$siren4j.class"] = "com.meat.representation.siren.UsersRepresentation";
				$scope.usermaster["userType"] = "ADMINUSER";
				$scope.usermaster["companyBranchId"] = $scope.superAdminDetails;

        $scope.jsonfile = 
                     {
                       "class":["users"],
                       "rel": ["item"],
                       "properties":$scope.usermaster
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqFactory.processReq(baseURL.IP+"/users/create","POST",data,function(){

                      swal({   title: "SUCCESS!",   text: "MEAT ADMIN CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                   	$location.path('#/Meat/MeatAdminTemplate')
                   	//$state.go('dashboards.ItemsTemplate');
                   },function(){
                   	swal({   title: "ERROR!",   text: "MEAT ADMIN NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                   });
      };

}
function meatAdminListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/users/ADMINUSER/All',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
                  var columns = [
            { "data": "properties.userCode" },
            { "data": "properties.userName" },
            { "data": "properties.dob"},
            { "data": "properties.phoneNo" },
            { "data": "properties.emailId" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Meat/SingleMeatAdmin/'+row.properties.userName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#meatAdminTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function TimingCreateViewController($scope, $http, baseURL,processReqService,$state){
	$('.confirm').removeClass('show');
	$('#timingwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#timingForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#timingForm").valid();
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});		
	$scope.save = function(Timing) {
        $scope.Timing = angular.copy(Timing);
         $scope.Timing["$siren4j.class"]= "com.meat.representation.siren.TimingsRepresentation";
         $scope.Timing["status"]= "Active";
         $scope.jsonfile = 
                     {
                       "class": [
							"timings"
							],
						"rel": [
							"item"
							],
              "properties":$scope.Timing,
                };
	
                 data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));

                   processReqService.processReq(baseURL.IP+"/timings/create","POST",data,function(){
                   	swal({   title: "Success!",   text: "Timing Created",   type: "success",   confirmButtonText: "Success" });
                   	$state.go('Timings.TimingTemplate')
                   },function(){
                   	swal({   title: "ERROR!",   text: "Timing Not Created",   type: "warning",   confirmButtonText: "Success" })
                   });
                    
      };
}
function SingleTimingsController( $scope, $http, $stateParams, baseURL, $rootScope, $modal){
	$scope.TimingsName=$stateParams.TimingsName;
	$scope.TimingsId=$stateParams.TimingsId;
	$http({
        method: "GET",
        url: baseURL.IP+'/timings/'+$scope.TimingsId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.timing=data;   
         }).error(function(error){
            $scope.error = error;
         });
   $scope.TimingsEdit=function(timing){
    	var modalInstance = $modal.open({
			templateUrl: '/Admin/views/TimingsEditTemplate.html',
			controller: TimingsEditController
			});
			$rootScope.TimingsEditData=timing;
  	}
}
function TimingsEditController($scope, $http, $modalInstance, $rootScope, processReqService, baseURL){
	$scope.update=function(TimingsEditData){
		var jsonfile={
                       "class": [
							"timings"
							],
						"rel": [
							"item"
							],
              				"properties":TimingsEditData,
                	};
                	console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/timings/"+TimingsEditData.id+"/edit","POST",jsonfile,function(){
			location.reload()
		},function(){
		swal({   title: "SUCCESS!",   text: "TIMINGS EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/TimingsEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "TIMINGS NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
         	});	
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function TimingListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/timings/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }
    }).success(function(data) {
                  var columns = [
            { "data": "properties.timingName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Timings/Timings/'+row.properties.timingName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#TimingTable');
        }).error(function(error){
            $scope.error = error;
        });
}
function SinglemeatController( $scope, $http, baseURL, processReqService, $stateParams, $modal, $rootScope){
	$scope.meatName=$stateParams.meatName;
	$scope.meatId=$stateParams.meatId;
	$http({
        method: "GET",
        url: baseURL.IP+'/company/'+$scope.meatId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      $scope.singlemeatDetails=data;
      $scope.singlemeatBranchDetails=[];
      $scope.singlemeatAddressDetails=[];
      $.each(data['entities'],function(k,v){
      	$scope.singlemeatBranchDetails.push(v);
        $.each(v['entities'],function(k1,v1){
          $scope.singlemeatAddressDetails.push(v1);
        })
    	})
    	console.log(JSON.stringify($scope.singlemeatBranchDetails));
    }).error(function(error){
			$scope.error = error;
    });
}
function CriteriaCreateController($scope, $http,$state, processReqService, baseURL){
	$('.confirm').removeClass('show');
	$('#criteriawizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#criteriaForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#criteriaForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
$scope.save=function(Criteria){
    $scope.CriteriaMaster=angular.copy(Criteria);
    $scope.CriteriaMaster['$siren4j.class']="com.meat.representation.siren.CriteriaRepresentation";
    var jsondata = 
             {
               "class":
               ["criteria"],
               "rel": 
               ["item"],
               "properties":$scope.CriteriaMaster
             };
            data=jsondata;
            console.log(JSON.stringify(jsondata));
            processReqService.processReq(baseURL.IP+"/criteria/create","POST",data,function(){
          		swal({  title: "Success!",   text: "CRITERIA CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
             	$state.go('dashboards.CriteriaTemplate')
            },function(){
             	swal({   title: "ERROR!",   text: "CRITERIA NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
            });
  }
}
function CriteriaListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/criteria/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      
           // $scope.tagdetails = data;
                 var columns = [
            { "data": "properties.criteriaName" },
            { "data": "properties.orderOfPlace" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Settings/Criteria/'+row.properties.criteriaName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#criteriaTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleCriteriaController( $scope, $http, processReqService, $stateParams, baseURL, $modal, $rootScope){
	$scope.criteriaName=$stateParams.criteriaName;
    $scope.criteriaId=$stateParams.criteriaId;
    $http({
        method: "GET",
        url: baseURL.IP+'/criteria/'+$scope.criteriaId,
        data: '',
        headers: {
              'Content-Type': "application/vnd.siren+json",
              'Accept': "application/vnd.siren+json"
          	}

    }).success(function(data) {
           $scope.criteriadetails=data;   
         }).error(function(error){
            $scope.error = error;
         });

          $scope.editCriteria=function(data){
	        	var modalInstance = $modal.open({
				templateUrl: '/Admin/views/CriteriaEditTemplate.html',
				controller: CriteriaEditController
				});
				$rootScope.CriteriaEditData=data;
        	}
}
function CriteriaEditController($scope, $http, baseURL, $modalInstance, $rootScope, processReqService){
	$scope.ok=function(CriteriaEditData){
		var jsonfile={
			"class": ["criteria"],
    	"properties":CriteriaEditData
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/criteria/"+CriteriaEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "CRITERIA EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/CriteriaEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "CRITERIA NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});	

	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function ZonesListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/zoneCity/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      
           // $scope.tagdetails = data;
                 var columns = [
            { "data": "properties.cityName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Settings/zoneCity/'+row.properties.cityName+'/'+data+'">View</a>'
                            return a;
                          }
             }

        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#ZoneTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleZoneController($scope, $http, processReqService, $stateParams, baseURL, $modal, $rootScope){
		$scope.zoneName=$stateParams.zoneName;
    $scope.zoneCityId=$stateParams.zoneCityId;
    $http({
        method: "GET",
        url: baseURL.IP+'/zoneCity/zoneCity/'+$scope.zoneCityId+"/zoneOnly",
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.zoneCityDetails=data;
         }).error(function(error){
            $scope.error = error;
         });

          $scope.editZoneCity=function(data){
	        	var modalInstance = $modal.open({
						templateUrl: '/Admin/views/ZoneCityEditTemplate.html',
						controller: ZoneEditController
						});
						$rootScope.ZoneEditData=data;
        	}
        	
		$rootScope.zoneCityId=$scope.zoneCityId;
		  $scope.editZone=function(data){
	        	var modalInstance = $modal.open({
						templateUrl: '/Admin/views/ZoneEditTemplate.html',
						controller: ZoneEditController
						});
						$rootScope.ZoneEditData=data;
        	}
        	$scope.addZones=function(id){
					var modalInstance = $modal.open({
					templateUrl: '/Admin/views/ZoneAddTemplate.html',
				controller: ZoneEditController
			});
			$rootScope.zoneId=id;
		}
		// $rootScope.zoneId=$scope.zoneId;
}
function ZoneEditController( $scope, $http, $modalInstance, $rootScope, processReqService, baseURL, $state){
	$http({
        method: "GET",
        url: baseURL.IP+'/zoneCity/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.zoneCityDetails=data.entities;
     }).error(function(error){
        $scope.error = error;
     });
     $http({
        method: "GET",
        url: baseURL.IP+'/zone/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.zonesDetails=data.entities;
     }).error(function(error){
        $scope.error = error;
     });
	$scope.ZoneCityEdit=function(ZoneCityEditData){
		var jsonfile={
			"class": ["zoneCity"],
    	"properties":ZoneCityEditData
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/zoneCity/"+ZoneCityEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});
	}

	$scope.ZoneEdit=function(ZoneEditData){
		var jsonfile={
			"class": ["zone"],
    	"properties":ZoneEditData
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/zone/"+ZoneEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){});
	}

	$scope.ZoneCreate=function(zoneCity){
		$scope.zones = angular.copy(zoneCity);
		$scope.zones['zoneCityId'] = $rootScope.zoneCityId;
        $scope.zones["$siren4j.class"]=  "com.meat.representation.siren.ZoneRepresentation",
        
        $scope.jsonfile = 
             {
               "class":["zone"],
               "rel": ["item"],
               "properties":$scope.zones
             };
             data=$scope.jsonfile;
             console.log(JSON.stringify($scope.jsonfile));
             processReqService.processReq(baseURL.IP+"/zone/create","POST",data,function(){
              	swal({   title: "Success!",   text: "ZONES CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
             	$state.go('Settings.ZonesTemplate')
             },function(){
             	swal({   title: "ERROR!",   text: "ZONES NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
             });
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function ZonesCreateViewController( $scope, $http, processReqService, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#zonewizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#zoneForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#zoneForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	 		$http({
        method: "GET",
        url: baseURL.IP+'/zoneCity/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.zoneCityEntities=data.entities;
     }).error(function(error){
        $scope.error = error;
     });
		
	     $scope.save = function(Zones) {
        $scope.zones = angular.copy(Zones);
        $scope.zones["$siren4j.class"]=  "com.meat.representation.siren.ZoneRepresentation",
        
        $scope.jsonfile = 
        {
           "class":["zone"],
           "rel": ["item"],
           "properties":$scope.zones
        };
        data=$scope.jsonfile;
        console.log(JSON.stringify($scope.jsonfile));
        processReqService.processReq(baseURL.IP+"/zone/create","POST",data,function(){
          	swal({   title: "Success!",   text: "ZONES CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	$state.go('Settings.ZonesTemplate')
        },function(){
         	swal({   title: "ERROR!",   text: "ZONES NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
        });
      };
}
function ZoneAreaCreateViewController( $scope, $http, processReqService, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#zoneareawizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#zoneAreaForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#zoneAreaForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
     $http({
        method: "GET",
        url: baseURL.IP+'/zone/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
       $scope.zoneEntities=data.entities;
     }).error(function(error){
        $scope.error = error;
     });
		
	     $scope.save = function(zoneArea) {
        $scope.zoneArea = angular.copy(zoneArea);
        $scope.zoneArea["$siren4j.class"]=  "com.meat.representation.siren.ZoneAreaRepresentation",
        
        $scope.jsonfile = 
                     {
                       "class":[
                       		"zoneArea"
                       ],
                       "rel": [
                       		"zoneAreaRep"
                       ],
                       "properties":$scope.zoneArea
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqService.processReq(baseURL.IP+"/zoneArea/create","POST",data,function(){
                      	swal({   title: "Success!",   text: "ZONE AREA CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	$state.go('Settings.ZonesTemplate')
                     },function(){
                     	swal({   title: "ERROR!",   text: "ZONE AREA NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
      };
}
function ZoneCityCreationViewController( $scope, $http, processReqService, baseURL, $state){
	$('.confirm').removeClass('show');
	$('#zonewizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#zoneForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#zoneForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
	     $scope.save = function(ZoneCity) {
        $scope.ZoneCity = angular.copy(ZoneCity);
        $scope.ZoneCity["$siren4j.class"]=  "com.meat.representation.siren.ZoneCityRepresentation",
        
        $scope.jsonfile = 
                     {
                       "class":["zoneCity"],
                       "rel": ["item"],
                       "properties":$scope.ZoneCity
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqService.processReq(baseURL.IP+"/zoneCity/create","POST",data,function(){
                      	swal({   title: "Success!",   text: "ZONECITY CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	$state.go('Settings.ZonesTemplate')
                     },function(){
                     	swal({   title: "ERROR!",   text: "ZONECITY NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
      };
}
function TaxesListController( $scope, $http, baseURL, dataTablesInitService){
	$http({
        method: "GET",
        url: baseURL.IP+'/tax/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
      
           // $scope.tagdetails = data;
                 var columns = [
            { "data": "properties.taxName" },
            { "data": "properties.taxType" },
            { "data": "properties.taxStatus" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,   
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/dashboards/Tax/'+row.properties.taxName+'/'+data+'">View</a>'
                            return a;
                          }
             }

        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#taxTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function TaxesCreationController( $scope, $http, baseURL, processReqService,$state){
	$('.confirm').removeClass('show');
	$('#taxwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#taxForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#taxForm").valid();
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});	
	 $scope.save = function(Tax) {
        $scope.tax = angular.copy(Tax);
        $scope.tax["$siren4j.class"]= "com.meat.representation.siren.TaxRepresentation",
        
        $scope.jsonfile = 
                     {
                       "class":["tax"],
                       "rel": ["item"],
                       "properties":$scope.tax
                     };
                     data=$scope.jsonfile;
                     console.log(JSON.stringify($scope.jsonfile));
                     processReqService.processReq(baseURL.IP+"/tax/create","POST",data,function(){
                      	swal({   title: "Success!",   text: "TAX CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
                     	$state.go('dashboards.TaxesListTemplate')
                     },function(){
                     	swal({   title: "ERROR!",   text: "TAX NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
                     });
      };
}
function SingleTaxController( $scope, $http, processReqService, $stateParams, baseURL, $modal, $rootScope){
	$scope.taxName=$stateParams.taxName;
     $scope.taxId=$stateParams.taxId;
    $http({
        method: "GET",
        url: baseURL.IP+'/tax/'+$scope.taxId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.taxadetails=data;   
         }).error(function(error){
            $scope.error = error;
         });

          $scope.editTax=function(data){
	        	var modalInstance = $modal.open({
						templateUrl: '/Admin/views/TaxEditTemplate.html',
						controller: TaxEditController
						});
						$rootScope.TaxEditData=data;
        	}
}
function TaxEditController($scope, $http, baseURL, $modalInstance, $rootScope, processReqService){
	$scope.ok=function(TaxEditData){
		var jsonfile={
			"class": ["tax"],
    	"properties":TaxEditData
		}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/tax/"+TaxEditData.id+"/edit","POST",jsonfile,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "TAX EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/TaxEditTemplate')
                   },function(){
                   	swal({ 	title: "ERROR!",   text: "TAX NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
                     	});	
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function LoginController ($scope, $http, baseURL) {
}
function AttributesListController( $scope, $http, dataTablesInitService, baseURL){
	$http({
        method: "GET",
        url: baseURL.IP+'/attributes/all',
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
        }

    }).success(function(data) {
      
           // $scope.tagdetails = data;
                 var columns = [
            { "data": "properties.attributeName" },
            { "data": "properties.status" },
            { "data": "properties.id",
                "orderable": false,
                "searchable": false,
                "render": function(data,type,row,meta) {
                            var a = '<a href="#/Tags/Attributes/'+row.properties.attributeName+'/'+data+'">View</a>'
                            return a;
                          }
             }
        ];
        dataTablesInitService.initDataTables(data['entities'],columns,'#AttributesTable');
         }).error(function(error){

            $scope.error = error;
         });
}
function SingleAttributesController( $scope, $http, $stateParams, baseURL, $rootScope, $modal){
	$scope.AttributesName=$stateParams.AttributesName;
	$scope.AttributesId=$stateParams.AttributesId;
	$http({
        method: "GET",
        url: baseURL.IP+'/attributes/'+$scope.AttributesId,
        data: '',
        headers: {
               'Content-Type': "application/vnd.siren+json",
               'Accept': "application/vnd.siren+json"
            }

    }).success(function(data) {
           $scope.Attributesdetails=data;   
         }).error(function(error){
            $scope.error = error;
         });
   $scope.AttributesEdit=function(Attributes){
    	var modalInstance = $modal.open({
			templateUrl: '/Admin/views/AttributesEditTemplate.html',
			controller: AttributesEditController
			});
			$rootScope.AttributesEditData=Attributes;
  	}
}
function AttributesEditController($scope, $http, baseURL, $modalInstance, $rootScope, processReqService){
		$scope.AttributesEdit=function(AttributesEditData){
		var jsonfile={
				    "class": [
				        "attributes"
				    ],
				    "rel": [
				        "item"
				    ],
				    "properties":AttributesEditData
				}
		console.log(JSON.stringify(jsonfile));
		processReqService.processReq(baseURL.IP+"/tags/"+AttributesEditData.Id+"/edit","POST",jsonfile,function(){location.reload()},function(){
			swal({   title: "SUCCESS!",   text: "ATTRIBUTES EDITED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
       location.path('#/ItemMaster/AttributesEditTemplate')
       },function(){
       	swal({ 	title: "ERROR!",   text: "ATTRIBUTES NOT EDITED",   type: "warning",   confirmButtonText: "OK" });
        });
	}
	$scope.cancel=function(){
		$modalInstance.close();
	}
}
function AttributesCreateController($scope, $http,$state, processReqService, baseURL){
	$('.confirm').removeClass('show');
	$('#Attributeswizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onTabClick': function(tab, navigation, index) {
	  			$("#AttributesForm").valid();

                return false;
            },
	  		'onNext': function(tab, navigation, index) {
	  			var $valid = $("#AttributesForm").valid();
	  			if(index==3){
	  				if(!$valid) {
	  				return false;

	  			}else{

	  				$('.confirm').addClass('show');
	  			}
	  			}
	  			
	  			if(!$valid) {
	  				return false;

	  			}
	  		},
	  		'onPrevious':function(tab, navigation, index){
	  			if(index==1 || index==0 || index==2){
	  				$('.confirm').removeClass('show');
	  			}
	  		}
	  	});
$scope.save=function(Attributes){
    $scope.AttributesMaster=angular.copy(Attributes);
    $scope.AttributesMaster['$siren4j.class']="com.meat.representation.siren.AttributesRepresentation";
    var jsondata = 
        {
        	"class":
           	["attributes"],
           	"rel": 
           	["item"],
           	"properties":$scope.AttributesMaster
        };
        data=jsondata;
        console.log(JSON.stringify(jsondata));
        processReqService.processReq(baseURL.IP+"/attributes/create","POST",data,function(){
      		swal({   title: "Success!",   text: "Attributes CREATED SUCCESSFULLY",   type: "success",   confirmButtonText: "Success" });
         	$state.go('Tags.AttributesTemplate')
        },function(){
         	swal({   title: "ERROR!",   text: "ATTRIBUTES NOT CREATED",   type: "warning",   confirmButtonText: "OK" });
        });
  }
}
angular
	.module('AdminTerminal')
	.controller('MainCtrl', MainCtrl)
	.controller('ItemCreationCtrl',ItemCreationCtrl)
	.controller('ItemImageCreationController',ItemImageCreationController)
	.controller('ItemListController',ItemListController)
	.controller('SingleItemController',SingleItemController)
	.controller('ItemEditController',ItemEditController)
	.controller('CategoryItemsListController',CategoryItemsListController)
	.controller('SellerBranchtItemsListController',SellerBranchtItemsListController)
	.controller('SellerItemCreationController',SellerItemCreationController)
	.controller('CategoryCreationController',CategoryCreationController)
	.controller('CategoryListController',CategoryListController)
	.controller('SingleCategoryController',SingleCategoryController)
	.controller('CategoryEditController',CategoryEditController)
	.controller('SubCategoryCreationController',SubCategoryCreationController)
	.controller('SubCategoryListController',SubCategoryListController)
	.controller('SingleSubCategoryController',SingleSubCategoryController)
	.controller('SellersItemsListController',SellersItemsListController)
	.controller('SingleSellerItemsController',SingleSellerItemsController)
	.controller('SellerItemEditController',SellerItemEditController)
	.controller('SellerBranchListController',SellerBranchListController)
	.controller('SingleBranchController',SingleBranchController)
	.controller('TagCreationController',TagCreationController)
	.controller('TagsListController',TagsListController)
	.controller('SingleTagController',SingleTagController)
	.controller('TagTypeCreationController',TagTypeCreationController)
	.controller('TagTypeListController',TagTypeListController)
	.controller('SingleTagTypeController',SingleTagTypeController)
	.controller('CutTypeCreationController',CutTypeCreationController)
	.controller('CutTypeListController',CutTypeListController)
	.controller('SingleCutTypeController',SingleCutTypeController)
	.controller('SellersCreationController',SellersCreationController)
	.controller('SellersBranchCreationController',SellersBranchCreationController)
	.controller('SingleSellerBranchCreationController',SingleSellerBranchCreationController)
	.controller('SellersListController',SellersListController)
	.controller('SingleSellerController',SingleSellerController)
	.controller('SellerBranchEmployeesListController',SellerBranchEmployeesListController)
	.controller('SellerBranchEmployeeCreationController',SellerBranchEmployeeCreationController)
	.controller('SingleSellerBranchEmployeeController',SingleSellerBranchEmployeeController)
	.controller('SellerBranchTimingController',SellerBranchTimingController)
	.controller('SellerBranchTimingCreationController',SellerBranchTimingCreationController)
	.controller('SingleSellerBranchTimingsController',SingleSellerBranchTimingsController)
	// Offers controllers
	.controller('PackageCreationController',PackageCreationController)
	.controller('PackageListController',PackageListController)
	.controller('SinglePackageController',SinglePackageController)
	.controller('OffersCreationController',OffersCreationController)
	.controller('OffersListController',OffersListController)
	.controller('SingleOfferController',SingleOfferController)
	.controller('ComboPackCreationController',ComboPackCreationController)
	.controller('ComboPackListController',ComboPackListController)
	.controller('SingleComboPackController',SingleComboPackController)
	.controller('CouponCreationController',CouponCreationController)
	.controller('CouponListController',CouponListController)
	.controller('CompanyController',CompanyController)
	.controller('CompanyCreationController',CompanyCreationController)
	.controller('CompanyBranchCreationController',CompanyBranchCreationController)
	.controller('SingleCompanyController',SingleCompanyController)
	.controller('CompanyEmployeeController',CompanyEmployeeController)
	.controller('CompanyEmployeeCreationController',CompanyEmployeeCreationController)
	.controller('SingleCompanyEmployeeController',SingleCompanyEmployeeController)
	.controller('CompanyAdminController',CompanyAdminController)
	.controller('CompanyAdminCreationController',CompanyAdminCreationController)
	.controller('SingleCompanyAdminController',SingleCompanyAdminController)
	.controller('CompanyTimingsController',CompanyTimingsController)
	.controller('CompanyTimingCreationController',CompanyTimingCreationController)
	.controller('SingleCompanyTimingsController',SingleCompanyTimingsController)
	.controller('MeatListController',MeatListController)
	.controller('meatCreationController',meatCreationController)
	.controller('SinglemeatController',SinglemeatController)
	.controller('meatEmployeeListController',meatEmployeeListController)
	.controller('meatEmployeeCreationController',meatEmployeeCreationController)
	.controller('SinglemeatEmployeeController',SinglemeatEmployeeController)
	.controller('meatAdminListController',meatAdminListController)
	.controller('meatAdminCreationController',meatAdminCreationController)
	.controller('TimingListController',TimingListController)
	.controller('TimingCreateViewController',TimingCreateViewController)
	.controller('TimingsEditController',TimingsEditController)
	.controller('SingleTimingsController',SingleTimingsController)
	.controller('CriteriaListController',CriteriaListController)
	.controller('CriteriaCreateController',CriteriaCreateController)
	.controller('SingleCriteriaController',SingleCriteriaController)
	.controller('ZonesListController',ZonesListController)
	.controller('ZonesCreateViewController',ZonesCreateViewController)
	.controller('ZoneCityCreationViewController',ZoneCityCreationViewController)
	.controller('SingleZoneController',SingleZoneController)
	.controller('TaxesListController',TaxesListController)
	.controller('TaxesCreationController',TaxesCreationController)
	.controller('AttributesCreateController',AttributesCreateController)
	.controller('AttributesListController',AttributesListController)
	.controller('SingleAttributesController',SingleAttributesController)
	.controller('SingleTaxController',SingleTaxController)
	.controller('LoginController',LoginController);
