window.hoaDonController = function ($scope, $http, $location, $rootScope) {
    $rootScope.role = "admin";
    if ($rootScope.token == null) {
        //  alert("Bạn phải đăng nhập mới được vào giỏ hàng")
        $location.path($rootScope.role == "admin" ? "dangnhapadmin" : "/dangnhap")
    }

    var url = $location.absUrl().split("/");
    var id = url[url.length - 1];
    if (!isNaN(id)) {
        $http.get(gioHangChiTietAPI + "/hoadonchitiet/" + id, {
            headers: {
                'Authorization': 'Bearer ' + $rootScope.token
            }
        }).then(function (response) {
            $scope.dsHoaDonChiTiet = response.data;
        }).catch(function (error) {
            console.error('Error calling API: ', error);
        });

        $http.get(gioHangAPI + "/tinhtrang/" + id, {
            headers: {
                'Authorization': 'Bearer ' + $rootScope.token
            }
        }).then(function (response) {
            $scope.trangThai = response.data;
        }).catch(function (error) {
            console.error('Error calling API: ', error);
        });
    }

    $scope.getImageUrl = function (image) {
        return 'data:image/png;base64,' + image;
    };

    $scope.capNhatTrangThai = function (event, trangThai) {
        event.preventDefault();
        $http.get(gioHangAPI + "/capnhattrangthai/" + id + "/" + trangThai, {
            headers: {
                'Authorization': 'Bearer ' + $rootScope.token
            }
        }).then(function (response) {
            $location.path("/hoadon");
        }).catch(function (error) {
            console.error('Error calling API: ', error);
        });
    }

    $http.get(gioHangAPI + "/giohangdangcho", {
        headers: {
            'Authorization': 'Bearer ' + $rootScope.token
        }
    }).then(function (response) {
        $scope.dsHoaDon = response.data;
    }).catch(function (error) {
        console.error('Error calling API: ', error);
    });

    $scope.hienThiHoaDon = function (event, trangThai) {
        event.preventDefault();
        var apiEndpoint = gioHangAPI + "/giohangdangcho";

        if (trangThai == 1) {
            apiEndpoint += "/1";
        } else if (trangThai == 2) {
            apiEndpoint += "/2";
        }

        $http.get(apiEndpoint, {
            headers: {
                'Authorization': 'Bearer ' + $rootScope.token
            }
        }).then(function (response) {
            $scope.dsHoaDon = response.data;
        }).catch(function (error) {
            console.error('Error calling API: ', error);
        });
    }
}
