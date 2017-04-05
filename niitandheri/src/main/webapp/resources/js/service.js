'use strict';
 
app.factory('Service', ['$http', '$q' ,function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/niitandheri/data/';
 
    var factory = {
        fetchAllBlogs: fetchAllBlogs,
        fetchBlog:fetchBlog,
        createBlog: createBlog,
        updateBlog:updateBlog,
        deleteBlog:deleteBlog,
        fetchUserBlogs:fetchUserBlogs
    };
 
    return factory;
 
    function fetchAllBlogs() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching blogs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }   
 
}]);