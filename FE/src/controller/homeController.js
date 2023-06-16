window.homeController = function ($scope, $http) {
  $scope.soLuongMua = 1;
  $http.get(banPhimAPI+"/getall").then(function (response) {
    $scope.listBanPhim = response.data;
  })

  $scope.getImageUrl = function (image) {
    return 'data:image/png;base64,' + image;
  };
  // $scope.detailBanPhim = function (event, id) {
  //   event.preventDefault();
  //   $http.get(banPhimAPI + "/detail/" + id).then(function (response) {
  //     $scope.spDetail = response.data;
  //   })
  // }
};
