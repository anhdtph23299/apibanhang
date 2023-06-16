window.banPhimController = function ($scope, $http) {
    $scope.listBanPhim = {}
    $http.get(banPhimAPI).then(function (response) {
        $scope.listBanPhim = response.data;
    })
    $http.get(loaiBanPhimAPI).then(function (response) {
        $scope.listLoai = response.data;
    })
    $http.get(kieuKetNoiAPI).then(function (response) {
        $scope.listKieu = response.data;
    })
    $http.get(hangAPI).then(function (response) {
        $scope.listHang = response.data;
    })

    $scope.loadLaiBanPhim = function () {
        $http.get(banPhimAPI + "?page=" + $scope.soTrang).then(function (response) {
            $scope.listBanPhim = response.data;
        })
    }
    $http.get(banPhimAPI + "/getall").then(function (response) {
        $scope.getAll = response.data;
     })


    $scope.timKiem = true;
    $scope.soTrang = 1;
    $scope.index = -1;
    $scope.banPhim = {
        id: null,
        tenBanPhim: "",
        soLuong: null,
        donGia: null,
        denNen: true,
        mota: "",
        images: null,
        hang: {
            id: null,
            tenHang: "",
        },
        kieuKetNoi: {
            id: null,
            tenKieu: "",
        },
        loaiBanPhim: {
            id: null,
            tenLoai: "",
        },
    };

    $scope.find = {
        tenCanTim: "",
        min: "",
        max: "",
        denNen: "",
        hang: "",
        kieuKetNoi: "",
        loaiBanPhim: "",
    }
    $scope.updateBanPhim = function (event) {
        event.preventDefault();
        var id = $scope.listBanPhim.content[$scope.index].id;
        var data = new FormData();
        data.append('file', $scope.selectedFile);
        data.append('requestData', new Blob([JSON.stringify($scope.banPhim)], {
            type: "application/json"
        }));

        var config = {
            transformRequest: angular.identity,
            transformResponse: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        }
        var url = banPhimAPI + "/update/" + id;
        var promise1 = $http.put(url, data, config);
        promise1.then(function (response) {
            $scope.loadLaiBanPhim();
        },
            function errorCallback(response) {
                alert(response.data.errorMessage);
            });
    }

    // 
    $scope.detailBanPhim = function (event, index) {
        event.preventDefault();
        $scope.index = index
        var id = $scope.listBanPhim.content[index].id;
        $http.get(banPhimAPI + "/detail/" + id).then(
            function (response) {
                $scope.banPhim = response.data;
            }
        )
    }
    $scope.deleteBanPhim = function (event, index) {
        event.preventDefault();
        var id = $scope.listBanPhim.content[index].id;
        $http.delete(banPhimAPI + "/delete/" + id).then(
            function (response) {
                $scope.loadLaiBanPhim();
            }
        )
    }

    $scope.phanTrang = function (event, soTrang) {
        event.preventDefault();
        soTrang++;
        if ($scope.timKiem == false) {
            $http.post(banPhimAPI + "/findthuoctinh?page=" + soTrang, $scope.find).then(function (response) {
                $scope.listBanPhim = response.data;
            })
        } else {
            $http.get(banPhimAPI + "?page=" + soTrang).then(function (response) {
                $scope.listBanPhim = response.data;
            })
        }

        $scope.soTrang = soTrang;
    }

    $scope.range = function () {
        var result = []
        for (let index = 0; index < $scope.listBanPhim.totalPages; index++) {
            result.push(index);
        }
        return result;
    }
    $scope.setSelectedFile = function (element) {
        $scope.selectedFile = element.files[0];
    };
    $scope.addBanPhim = function (event) {
        event.preventDefault();
        var data = new FormData();
        data.append('file', $scope.selectedFile);
        data.append('requestData', new Blob([JSON.stringify($scope.banPhim)], {
            type: "application/json"
        }));

        var config = {
            transformRequest: angular.identity,
            transformResponse: angular.identity,
            headers: {
                'Content-Type': undefined
            }
        }
        var url = "http://localhost:8080/banphim/add";
        console.log($scope.banPhim);
        var promise1 = $http.post(url, data, config);
        promise1.then(function (response) {
            $scope.loadLaiBanPhim()
        },
            function errorCallback(response) {
                alert(response.data.errorMessage);
            });

    }
    $scope.getImageUrl = function (image) {
        return 'data:image/png;base64,' + image;
    };
    $scope.findThuocTinh = function (event, index) {
        event.preventDefault();
        $http.post(banPhimAPI + "/findthuoctinh?page=" + index, $scope.find).then(function (response) {
            $scope.listBanPhim = response.data;
        })

        $scope.soTrang = 0;
        $scope.timKiem = false;
    }
    $scope.xoaTimKiem = function (event) {
        $scope.timKiem = true;
        $scope.soTrang = 0;
        $scope.phanTrang(event, $scope.soTrang);
    }

}
