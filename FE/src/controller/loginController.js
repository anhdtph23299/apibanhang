window.loginController = function ($scope, $http, $location, $rootScope) {
  // $http.get(nguoiDungAPI).then(function (response) {
  //   $scope.nguoiDung = response.data;
  // });
  $scope.daGuiMail = false;
  $scope.user = {
    email: "",
    password: "",
  };
  $scope.qmk = {
    email: "",
    maXacThuc: "",
  };
  $scope.mk = {
    matKhauCu: "",
    matKhauMoi: "",
    matKhauXacNhan: "",
  };
  $scope.form = {
    hoTen: "",
    gioiTinh: true,
    ngaySinh: "",
    email: "",
    sdt: "",
    matKhau: "",
    diaChi: "",
    id: "",
    role: 0,
  };
  $scope.guiMail = function (event) {
    event.preventDefault();
    $http.get(emailAPI + "/quenmatkhau/" + $scope.qmk.email).then(function (response) {
      // if (response.data = "") {
      //   alert("Email này không đúng với bất cứ ai đăng ký tài khoản shop của tôi")
      // } else {
      $scope.qmk.maXacThuc = response.data;
      alert("Vui lòng kiểm tra email")
      // }
    })
  }
  $scope.checkMaXacThuc = function (event) {
    event.preventDefault();
    console.log($scope.qmk.maXacThuc);
    console.log($scope.maXacThuc);
    if ($scope.qmk.maXacThuc == $scope.maXacThuc) {
      alert("Bạn sẽ được chuyển sang trang đổi mật khẩu")
      // 
      $http.get(emailAPI + "/khachhang/" + $scope.qmk.email).then(function (response) {
        $scope.khachHang = response.data;
        $scope.daGuiMail = true;
      })
      // 
    } else {
      alert("Mã xác thực sai")
    }
  }
  $scope.doiMatKhau = function (event) {
    event.preventDefault();
    var kh = $scope.khachHang;
    console.log(kh);
    $scope.khachHang.matKhau = $scope.mk.matKhauMoi;
    if ($scope.daGuiMail) {
      if ($scope.mk.matKhauMoi == $scope.mk.matKhauXacNhan) {
        $http.post(emailAPI + "/doimatkhau", $scope.khachHang).then(function (response) {

        })
        alert("đổi mật khẩu thành công")
        $location.path("/")
      } else {
        alert("Không trùng mật khẩu xác nhận")
      }
    } else {
      alert("Sai xác nhận mật khẩu")
    }
  }
  $scope.dangKy = function () {
    var x = $scope.form;
    // if (
    //   x.email.length == 0 ||
    //   x.soDienThoai.length == 0 ||
    //   x.ngaySinh == "" ||
    //   x.ten.length == 0 ||
    //   x.password.length == 0 ||
    //   x.diaChi.length == 0
    // ) {
    //   alert("Bạn phải nhập đủ thông tin");
    //   return;
    // }
    // let regex_sdt = /^(0|\+84)[1-9][0-9]{8,9}$/;
    // var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    // if ($scope.form.email.match(mailformat)) {
    //   alert("Sai định dạng email");
    //   return;
    // }
    // if (!regex_sdt.test($scope.form.soDienThoai)) {
    //   alert("Sai định dạng email");
    //   return;
    // }
    $http.post(khachHangAPI + "/dangky", $scope.form).then(function (response) {
      if (response.data == "") {
        alert("Trùng email")
        return
      }
      alert("Đăng ký thành công");
    });
  };
  $scope.dangNhap = function () {
    $http.post(khachHangAPI + "/dangnhap", $scope.user).then(function (response) {
      if (response.data == "") {
        alert("sai tài khoản hoặc mật khẩu")
      } else {
        alert("đăng nhập thành công")
        $rootScope.khachHang = response.data;
        // $rootScope.setLaiGioHang()
        $location.path("/trangchu")
      }
    });
  };

  // $scope.doiMatKhau = function () {
  //   console.log($rootScope.index);
  //   if ($rootScope.taiKhoan.password !== $scope.mk.matKhauCu) {
  //     alert("Bạn nhập sai mật khẩu");
  //   } else {
  //     if ($scope.mk.matKhauMoi == $scope.mk.matKhauXacNhan) {
  //       $scope.nguoiDung[$rootScope.index].password = $scope.mk.matKhauMoi;
  //       $http
  //         .put(
  //           nguoiDungAPI + "/" + $scope.nguoiDung[$rootScope.index].id,
  //           $scope.nguoiDung[$rootScope.index]
  //         )
  //         .then(function (response) {
  //           $scope.nguoiDung[$scope.index] = response.data;
  //         });
  //     }
  //     alert("Bạn đổi mật khẩu thành công");
  //     $location.path("/");
  //   }
  // };

  // $scope.login = function () {
  //   $http.post(userAPI + "/login", $scope.user).then(function (response) {

  //   })
  //   alert("Sai tài khoản hoặc mật khẩu");
  // };

};
