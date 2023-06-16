window.hoaDonController = function ($scope, $http, $location) {
    var url = $location.absUrl().split("/");
    var id = url[url.length - 1];
    if (!isNaN(id)) {
        console.log("hello");
        $http.get(gioHangChiTietAPI + "/hoadonchitiet/" + id).then(function (response) {
            $scope.dsHoaDonChiTiet = response.data;
        })
        $http.get(gioHangAPI + "/tinhtrang/" + id).then(function (response) {
            $scope.trangThai = response.data;
        })
    }
    $scope.getImageUrl = function (image) {
        return 'data:image/png;base64,' + image;
    };
    $scope.capNhatTrangThai = function (event, trangThai) {
        event.preventDefault();
        $http.get(gioHangAPI + "/capnhattrangthai/" + id + "/" + trangThai).then(function (response) { 
            $location.path("/hoadon")
        })
    }
    $http.get(gioHangAPI + "/giohangdangcho").then(function (response) {
        $scope.dsHoaDon = response.data;
    })
    $scope.hienThiHoaDon = function (event, trangThai) {
        event.preventDefault();
        if (trangThai == 0) {
            $http.get(gioHangAPI + "/giohangdangcho").then(function (response) {
                $scope.dsHoaDon = response.data;
            })
        } else if (trangThai == 1) {
            $http.get(gioHangAPI + "/giohangdangcho/1").then(function (response) {
                $scope.dsHoaDon = response.data;
            })
        } else {
            $http.get(gioHangAPI + "/giohangdangcho/2").then(function (response) {
                $scope.dsHoaDon = response.data;
            })
        }
    }

}