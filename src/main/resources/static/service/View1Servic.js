appName.service("View1Service", function($http,$q){

	this.getServer = function(){		

		var defer = $q.defer();
		//return {			
			/*return $http.get('https://api.github.com/users/haroldrv')*/
		return $http.get('http://localhost:8080/getList')		
			.then(function(response) {
			//	debugger;
				defer.resolve(response.data);
				return defer.promise;
			}, function(response) {
		//		debugger;
				defer.reject(response);
				return defer.promise;
			});
		//}
	};
	
	this.saveDetails = function(data) {		
		var url='http://localhost:8080/savedata';
		var json = [{
			detail1:data.detail1,
			detail2:data.detail2,
			detail3:data.detail3,
			detail4:data.detail4
			},{
				detail1:data.detail1,
				detail2:data.detail2,
				detail3:data.detail3,
				detail4:data.detail4
			}
		];
		
		var defer = $q.defer();
		
		return $http.post(url, JSON.stringify(json)).then(function(response){
			defer.resolve(response.data);
			return defer.promise;
		},function(response){
			defer.reject(response);
			return defer.promise;
		});		
	};
})