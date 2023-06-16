<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Sửa sản phẩm</title>
</head>
<body>
<div class="container">
    <section>
        <!--  -->
        <h1 class="text-center text-danger mb-3">Thông tin sản phẩm</h1>

        <form:form action="/banphim/update/${banPhim.maBanPhim}" enctype="multipart/form-data"
                   method="post" onsubmit="return confirm('Bạn có chắc chắn muốn sửa không?');" modelAttribute="banPhim">
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Tên bàn phím</p></div>
                <div class="col-4">
                    <form:input path="tenBanPhim" cssClass="form-control" aria-describedby="basic-addon1"/>
                </div>
            </div>
            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Giá tiền</p></div>
                <div class="col-4">
                    <form:input type="number" path="donGia" cssClass="form-control" value="${banPhim.donGia1}" aria-describedby="basic-addon1"/>
                </div>
            </div>
            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Số lượng</p></div>
                <div class="col-4">
                    <form:input type="number" min="0" path="soLuong" cssClass="form-control"
                                aria-describedby="basic-addon1"/>
                </div>
            </div>
            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Đèn nền</p></div>
                <div class="col-4">
                    <form:radiobutton path="denNen" value="true" label="Có" checked="true"/>
                    <form:radiobutton path="denNen" value="false" label="Không"/>
                </div>
            </div>
            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Hãng</p></div>
                <div class="col-4">
                    <form:select path="hang" aria-label="Default select example"
                                 cssClass="form-select">
                        <form:options items="${dsHang}" itemLabel="tenHang" itemValue="maHang"/>
                    </form:select>
                </div>
            </div>
            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Kiểu kết nối</p></div>
                <div class="col-4">
                    <form:select path="kieuKetNoi" aria-label="Default select example"
                                 cssClass="form-select">
                        <form:options items="${dsKieuKetNoi}" itemLabel="tenKieu" itemValue="maKieu"/>
                    </form:select>
                </div>
            </div>

            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Loại Bàn phím</p></div>
                <div class="col-4">
                    <form:select path="loaiBanPhim" aria-label="Default select example"
                                 cssClass="form-select">
                        <form:options items="${dsLoaiBanPhim}" itemLabel="tenLoai" itemValue="maLoai"/>
                    </form:select>
                </div>
            </div>

            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Ảnh</p></div>
                <div class="col-4">
                    <div class="mb-3">
                        <label for="formFile" class="form-label"
                        >Nên lựa chọn các ảnh đẹp , bắt mắt</label
                        >
                        <input
                                class="form-control"
                                type="file"
                                id="formFile"
                                name="anh"
                        />
                    </div>
                </div>
            </div>
            <!-- -->
            <div class="row mb-4">
                <div class="col-2"></div>
                <div class="col-2"><p>Mô tả</p></div>
                <div class="col-7">
                    <div class="form-floating">
                        <form:textarea path="mota" cssClass="form-control" placeholder="Leave a comment here"
                                       id="floatingTextarea" cssStyle="height: 100px"/>
                        <label for="floatingTextarea"
                        >Mô tả ý nghĩa để có nhiều khách hàng hơn</label
                        >
                    </div>
                </div>
            </div>
            <div class="mt-3 text-center mb-3">
                <button
                        type="submit"
                        class="btn btn-outline-info me-5"
                        style="width: 100px"
                >
                    Update
                </button>
            </div>
        </form:form>
    </section>
    <c:url var="pageUrl" value="/search">
        <c:param name="page" value="22" />
        <%-- Thêm các tham số tìm kiếm vào URL --%>
        <c:param name="keyword" value="abc" />
        <c:param name="category" value="xyz" />
    </c:url>
    <a href="${pageUrl}">Hello</a>

</div>
</body>
</html>
