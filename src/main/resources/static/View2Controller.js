var view2Controller = function($scope, View2Service) {

	$scope.view2Var={};
	$scope.getData = function() {
		View2Service.getData().then(function(response){
			$scope.view2Var=response;
		},function(response){
			console.log(response);
		});
	}
	$scope.getData();
}
appName.controller("View2Controller", view2Controller);
//view2Controller.$inject['$scope'];
