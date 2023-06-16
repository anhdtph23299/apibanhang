<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%--    <link href="../css/plugin/bootstrap/bootstrap.css" rel="stylesheet"/>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"
    ></script>
    <!-- <link rel="stylesheet" href="../css/custom/cs.css" /> -->
    <title>Thông tin sản phẩm</title>
</head>
<body>
<div class="container">
    <form action="">
        <div class="row mt-5">
            <div class="col-md-5">
                <div class="main-img dt">
                    <img class="img-fluid" src="${banPhim.images}" alt="ProductS"/>
                </div>
            </div>
            <div class="col-md-7">
                <div class="main-description px-2">
                    <h3>Loại bàn phím : ${banPhim.loaiBanPhim.tenLoai}</h3>
                    <div class="product-title text-bold my-3">
                        <h1>${banPhim.tenBanPhim}</h1>
                    </div>
                    <div class="row mb-4">
                        <div class="col-3"><p>Hãng :</p></div>
                        <div class="col-6">
                            <h5>${banPhim.hang.tenHang}</h5>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-3"><p>Kiểu kết nối :</p></div>
                        <div class="col-6">
                            <h5>${banPhim.kieuKetNoi.tenKieu}</h5>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-3"><p>Số lượng hiện tại :</p></div>
                        <div class="col-6">
                            <h5>${banPhim.soLuong}</h5>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-3"><p>Giá tiền :</p></div>
                        <div class="col-6">
                            <strong>${banPhim.donGia}</strong>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-3">
                            <span id="basic-addon1">Số lượng</span>
                        </div>

                        <div class="col-5">
                            <input
                                    type="number"
                                    class="form-control"
                                    aria-describedby="basic-addon1"
                                    name="soLuong"
                                    value="1"
                                    min="1"
                                    max="${banPhim.soLuong}"
                            />
                        </div>
                    </div>
                    <div class="row mb-5">
                        <div class="col-2"></div>
                        <div class="col-3">
                            <button type="submit" class="btn btn-dark">Mua ngay</button>
                        </div>
                        <div class="col-5">
                            <a href="#" class="btn btn-dark">
                                Thêm vào giỏ hàng
                            </a>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <p>Mô tả :</p>
                        <p>${banPhim.mota}</p>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
