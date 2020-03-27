var view1Controller = function($scope,View1Service,$state) {

	$scope.inp={};
	$scope.saveDetails = function() {
		debugger;
		View1Service.saveDetails($scope.inp).then(function(response) {
			$state.go('view2');
		},function(response) {
			
		});		
	}
	
	View1Service.getServer().
	then(
			function(response){
		//		debugger;
				$scope.view1Var = response;
				console.log(data)
			},function(response){
				var data = response;				
			}
	);
}
appName.controller("View1Controller", view1Controller);
//view1Controller.$inject['$scope','View1Service'];


