'use strict';
 
app.controller('Controller', ['$scope', 'Service', ,function($scope, Service) {
 
	
	
    self.blogs=[];
  
    fetchAllBlogs();
    
    
    function fetchAllBlogs(){
        Service.fetchAllBlogs()
            .then(
            function(d) {
                self.blogs = d;
            },
            function(errResponse){
                console.error('Error while fetching blogs');
            }
        );
    }
    
    
}]);