var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/banphim", {
      templateUrl: "./pages/banphim.html",
      controller: banPhimController,
    }).when("/sanpham", {
      templateUrl: "./pages/sanpham.html",
      controller: banPhimController,
    }).when("/dangnhap", {
      templateUrl: "./pages/login.html",
      controller: loginController,
    }).when("/dangky", {
      templateUrl: "./pages/dangky.html",
      controller: loginController,
    }).when("/quenmatkhau", {
      templateUrl: "./pages/quenmatkhau.html",
      controller: loginController,
    }).when("/doimatkhau", {
      templateUrl: "./pages/doimatkhau.html",
      controller: loginController,
    }).when("/trangchu", {
      templateUrl: "./pages/trangchu.html",
      controller: homeController,
    }).when("/", {
      templateUrl: "./pages/login.html",
      controller: loginController,
    }).when("/card/:id", {
      templateUrl: "./pages/detailintelji.html",
      controller: detailController,
    }).when("/giohang", {
      templateUrl: "./pages/giohang.html",
      controller: ChartController,
    }).when("/giohang/checkout", {
      templateUrl: "./pages/checkout.html",
      controller: ChartController,
    }).when("/thongke", {
      templateUrl: "./pages/thongke.html",
      controller: ChartController,
    }).when("/damua", {
      templateUrl: "./pages/damua.html",
      controller: ChartController,
    }).when("/hoadon", {
      templateUrl: "./pages/hoadon.html",
      controller: hoaDonController,
    }).when("/hoadon/:id", {
      templateUrl: "./pages/hoadonct.html",
      controller: hoaDonController,
    })
    .otherwise({
      redirectTo: "/",
    });
});
app.controller("gioHangController", function ($scope, $rootScope, $http) {
  $scope.soLuongGiohang = $rootScope.soLuongGiohang
  // console.log($rootScope.khachHang);
  // console.log($rootScope.khachHang != undefined);

  // if ($rootScope.khachHang != null) {
  //   console.log($rootScope.khachHang);
  //   $http.get(gioHangAPI + "/" + $rootScope.khachHang.id).then(function (response) {
  //     $scope.soLuongGiohang = response.data;
  //   })
  // } else {
  //   $scope.soLuongGiohang = 0;
  // }
})
app.run(function ($rootScope, $http) {
  $rootScope.khachHang = null;
  // $rootScope.setLaiGioHang = function () {
  //   $http.get(gioHangAPI + "/soluonggiohang/" + $rootScope.khachHang.id).then(function (response) {
  //     $rootScope.soLuongGiohang = response.data;
  //   })
  // }
})