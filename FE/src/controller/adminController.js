window.AdminController = function ($scope, $rootScope, $http, $location) {

    $rootScope.role = "admin";
    $scope.user = {
        email: "",
        password: ""
    }
    $scope.loginadmin = function (event) {
        event.preventDefault();
        $http.post("http://localhost:8080/authenticate", $scope.user).then(function (response) {
            $rootScope.token = response.data.jwtToken;
            console.log(response.data);
            $rootScope.role = "admin";
            $location.path("/trangchuadmin")
        })
    }


}