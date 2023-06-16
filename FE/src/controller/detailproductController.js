window.detailController = function ($scope, $http, $location, $rootScope) {
  var url = $location.absUrl().split("/");
  var id = url[url.length - 1];
  $http.get(banPhimAPI + "/detail/" + id).then(function (response) {
    $scope.spDetail = response.data;
    // if ($scope.spDetail.soLuong < 1) {
    //   $scope.soLuongMua = 0;
    // } else {
    //   $scope.soLuongMua = 1;
    // }
  });
  $scope.getImageUrl = function (image) {
    return 'data:image/png;base64,' + image;
  };
  $scope.soLuongMua = 1
  $scope.themVaoGio = function (event, data) {
    event.preventDefault();
    var khachhang = $rootScope.khachHang;
    $http.get(gioHangChiTietAPI + "/themvaogio/" + khachhang.id + "/" + data).then(function (response) {
      alert("Thêm vào giỏ thành công")
    }).catch(function (error) {
      // Xử lý lỗi
      alert("Thêm vào giỏ thành công")
    });
  }


  // $http.get(sanPhamAPI).then(function (response) {
  //   $scope.spTuongTu = response.data;
  // });
};
