window.ChartController = function ($scope, $rootScope, $http, $location) {


    if ($rootScope.khachHang == null && $rootScope.token == null) {
        //  alert("Bạn phải đăng nhập mới được vào giỏ hàng")
        $location.path($rootScope.role == "admin" ? "dangnhapadmin" : "/dangnhap")
    }

    if ($rootScope.khachHang != null) {
        $http.get(gioHangChiTietAPI + "/" + $rootScope.khachHang.id).then(function (response) {
            $scope.dsGioHang = response.data;
        })
        $http.get(gioHangChiTietAPI + "/tongtien/" + $rootScope.khachHang.id)
            .then(function (response) {
                $scope.tongTien = response.data;
            })
            .catch(function (error) {
                console.error("Error occurred:", error);
                $scope.tongTien = 0;
            });
    } else {
        $rootScope.role = "admin"
    }

    var url = $location.absUrl().split("/");
    $scope.daMuaTatCa = function (event) {
        event.preventDefault();
        $http.get(gioHangChiTietAPI + "/damua/" + $rootScope.khachHang.id).then(function (response) {
            $scope.dsDaMua = response.data;
        })
    }
    $scope.daMua = function (event, trangThai) {
        $http.get(gioHangChiTietAPI + "/damua/" + $rootScope.khachHang.id + "/" + trangThai).then(function (response) {
            $scope.dsDaMua = response.data;
        })
    }
    $scope.getImageUrl = function (image) {
        return 'data:image/png;base64,' + image;
    };

    function getDaysInMonth() {
        var currentDate = new Date(); // Lấy ngày hiện tại
        var year = currentDate.getFullYear(); // Lấy năm hiện tại
        var month = currentDate.getMonth(); // Lấy tháng hiện tại (từ 0 đến 11)

        var daysInMonth = new Date(year, month + 1, 0).getDate(); // Lấy số ngày trong tháng

        var daysArray = [];
        for (var i = 1; i <= daysInMonth; i++) {
            daysArray.push(i);
        }

        return daysArray;
    }

    $scope.thongKeTon = function () {
        $http.get(gioHangChiTietAPI + "/topsanphamton").then(function (response) {
            console.log(response);
            $scope.dsSanPhamTon = response.data;
        })
    }
    $scope.locThongKeTon = function (event, data) {
        event.preventDefault();
        var url = "";
        if (data == 0) {
            url = "ngay=" + $scope.ngayCanTim;
        } else if (data == 1) {
            url = "tuan=" + data;
        } else {
            url = "thang=" + data;
        }
        $scope.thongKeTonTheoThoiGian(url);
    }
    $scope.thongKeTonTheoThoiGian = function (url) {
        $http.get(gioHangChiTietAPI + "/topspton?" + url).then(function (response) {
            $scope.dsSanPhamTon = response.data;
        })
    };

    $scope.thongKeTatCa = function () {
        // Hủy biểu đồ hiện tại nếu đã tồn tại
        if ($scope.myChart) {
            $scope.myChart.destroy();
        }

        $http.get(gioHangChiTietAPI + "/topsanphambanchay").then(function (response) {
            $scope.chartData = response.data;
            console.log($scope.chartData);
            var ctx = document.getElementById("myChart").getContext("2d");
            var uniqueColors = []; // Mảng chứa các màu sắc duy nhất

            var datasets = $scope.chartData.map(function (item) {
                var color = getRandomColor(); // Hàm để lấy một màu sắc ngẫu nhiên
                uniqueColors.push(color); // Thêm màu sắc vào mảng uniqueColors

                return {
                    label: item.tenBanPhim,
                    data: [item.soLuong],
                    backgroundColor: color,
                    borderColor: "rgba(75, 192, 192, 1)",
                    borderWidth: 1,
                };
            });

            $scope.myChart = new Chart(ctx, {
                type: "bar",
                data: {
                    labels: ["Thống kê bàn phím bán chạy"],
                    datasets: datasets,
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                        },
                    },
                },
            });

            function getRandomColor() {
                var letters = "0123456789ABCDEF";
                var color = "#";
                for (var i = 0; i < 6; i++) {
                    color += letters[Math.floor(Math.random() * 16)];
                }
                return color;
            }
        });
    };


    $scope.ngay = getDaysInMonth();

    var cantim = url[url.length - 1];
    if (cantim == "checkout") {
        $http.get(gioHangAPI + "/" + $rootScope.khachHang.id).then(function (response) {
            $scope.gioHang = response.data;
            console.log($scope.gioHang);
        })
    } else if (cantim == "thongke") {
        $scope.thongKeTatCa();
        $scope.thongKeTon();

    }



    $scope.datHang = function (event, idGioHang) {
        event.preventDefault();

        $scope.gioHang.id = idGioHang;
        console.log($scope.gioHang.id);
        $http.post(gioHangAPI + "/dathang", $scope.gioHang).then(function (response) {
            alert("Đặt hàng thành công")
        })
    }
    $scope.thayDoiSoLuong = function (event, soLuong, idBanPhim, idGioHang, index) {
        event.preventDefault();
        $http.get(gioHangChiTietAPI + "/updategiohang" + "/" + idGioHang + "/" + idBanPhim + "/" + soLuong).then(function (response) {
            if (response.data.soLuong == 0) {
                $scope.dsGioHang.splice(index, 1);
            } else {
                $scope.dsGioHang[index] = response.data
            }
        })
        // $scope.tongTien();

    }




    $scope.loc = function (event, data) {
        event.preventDefault();
        var url = "";
        if (data == 0) {
            url = "ngay=" + $scope.ngayCanTim;
        } else if (data == 1) {
            url = "tuan=" + data;
        } else {
            url = "thang=" + data;
        }
        $scope.thongKeTheoThoiGian(url);
    }
    // 
    $scope.thongKeTheoThoiGian = function (url) {
        // Hủy biểu đồ hiện tại nếu đã tồn tại
        if ($scope.myChart) {
            $scope.myChart.destroy();
        }
        $http.get(gioHangChiTietAPI + "/topspbanchay?" + url).then(function (response) {
            $scope.chartData = response.data
            console.log($scope.chartData);
            var ctx = document.getElementById("myChart").getContext("2d");
            var uniqueColors = []; // Mảng chứa các màu sắc duy nhất

            var datasets = $scope.chartData.map(function (item) {
                var color = getRandomColor(); // Hàm để lấy một màu sắc ngẫu nhiên
                uniqueColors.push(color); // Thêm màu sắc vào mảng uniqueColors

                return {
                    label: item.tenBanPhim,
                    data: [item.soLuong],
                    backgroundColor: color,
                    borderColor: "rgba(75, 192, 192, 1)",
                    borderWidth: 1,
                };
            });

            $scope.myChart = new Chart(ctx, {
                type: "bar",
                data: {
                    labels: ["Data"],
                    datasets: datasets,
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                        },
                    },
                },
            });

            function getRandomColor() {
                var letters = "0123456789ABCDEF";
                var color = "#";
                for (var i = 0; i < 6; i++) {
                    color += letters[Math.floor(Math.random() * 16)];
                }
                return color;
            }


        })
    }

}