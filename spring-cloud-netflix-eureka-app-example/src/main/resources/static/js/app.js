angular.module('user', ['ngRoute']).config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'user-page.html',
        controller: 'userCtr'
    })
}).controller('userCtr', function ($scope, $http) {
    $http.get('user/info/zhanshang').success(function (data) {
        $scope.user = data;
    });
});

