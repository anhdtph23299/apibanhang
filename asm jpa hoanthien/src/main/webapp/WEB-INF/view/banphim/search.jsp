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
    <section>
        <!--  -->
        <%--        <img src="/images/banphim.jpg">--%>
        <h1 class="text-center text-danger mb-3">Thông tin sản phẩm</h1>

        <form:form action="/banphim/add" method="post" enctype="multipart/form-data"
                   onsubmit="return confirm('Bạn có muốn thêm không')"
                   modelAttribute="banPhim">
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
                    <form:input type="number" path="donGia" cssClass="form-control" aria-describedby="basic-addon1"/>
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
                        <input class="form-control"
                               type="file" accept="image/*"
                               id="formFile" name="anh">
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
                    Thêm
                </button>
            </div>
        </form:form>
    </section>

    <section>
        <form action="/banphim/find">
            <div class="row mb-4 mt-5">
                <div class="col-2"></div>
                <div class="col-2"><h5>Tìm kiếm</h5></div>
                <div class="col-4">
                    <input name="tenCanTim" class="form-control" value="${param.tenCanTim}"
                           aria-describedby="basic-addon1">
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-success">Search</button>
                </div>
            </div>
        </form>
        <%--        --%>
        <form action="/banphim/findthuoctinh">
            <div class="row mb-4 mt-5">
                <div class="col-1"><h5>Tìm kiếm</h5></div>
                <div class="col-2">
                    <input type="text" class="form-control" name="tenBanPhim"
                           placeholder="Nhập tên" value="${param.tenCanTim}">
                </div>
                <div class="col-3">
                    <input name="min" placeholder="Nhập khoảng giá min" class="form-control" value="${param.min}"
                           aria-describedby="basic-addon1">
                </div>
                <div class="col-3">
                    <input name="max" placeholder="Nhập khoảng giá max" class="form-control" value="${param.max}"
                           aria-describedby="basic-addon1">
                </div>
                <div class="col-3">
                    <select class="form-select" aria-label="Default select example" name="denNen">
                        <option value="" selected>Chọn đèn nền</option>
                        <option value="Có" ${param.denNen=="Có"?"selected":""}>Có</option>
                        <option value="Không" ${param.denNen=="Không"?"selected":""}>Không</option>
                    </select>
                </div>
                <div class="col-3 mt-3">
                    <select class="form-select" aria-label="Default select example" name="hang">
                        <option value="" selected>Chọn hãng</option>
                        <c:forEach items="${dsHang}" var="x">
                            <option value="${x.tenHang}" ${param.hang==x.tenHang?"selected":""}>${x.tenHang}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-3 mt-3">
                    <select class="form-select" name="kieuKetNoi" aria-label="Default select example">
                        <option value="" selected>Chọn kiểu kết nối</option>
                        <c:forEach items="${dsKieuKetNoi}" var="x">
                            <option value="${x.tenKieu}" ${param.kieuKetNoi==x.tenKieu?"selected":""}>${x.tenKieu}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-3 mt-3">
                    <select class="form-select" aria-label="Default select example" name="loaiBanPhim">
                        <option value="" selected>Chọn loại bàn phím</option>
                        <c:forEach items="${dsLoaiBanPhim}" var="x">
                            <option value="${x.tenLoai}" ${param.loaiBanPhim==x.tenLoai?"selected":""}>${x.tenLoai}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-2">
                    <button type="submit" class="btn btn-success mt-3">Search</button>
                </div>
            </div>
            <c:url var="pageUrl" value="/banphim/findthuoctinh">
                <c:param name="tenBanPhim" value="${param.tenBanPhim}"/>
                <c:param name="min" value="${param.min}"/>
                <c:param name="max" value="${param.max}"/>
                <c:param name="denNen" value="${param.denNen}"/>
                <c:param name="hang" value="${param.hang}"/>
                <c:param name="kieuKetNoi" value="${param.kieuKetNoi}"/>
                <c:param name="loaiBanPhim" value="${param.loaiBanPhim}"/>
            </c:url>
            <%--            <a href="${pageUrl}">Hello</a>--%>

        </form>
    </section>
    <!--  -->
    <c:if test="${dsBanPhim.isEmpty()}">
        <h5 class="alert alert-danger text-center">Empty list you are search</h5>
    </c:if>
    <c:if test="${not dsBanPhim.isEmpty()}">
        <section>
            <div class="container">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Tên sản phẩm</th>
                        <th scope="col">Ảnh</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Giá tiền</th>
                        <th scope="col">Đèn nền</th>
                        <th scope="col">Hãng</th>
                        <th scope="col">Kiểu bàn phím</th>
                        <th scope="col">Loại</th>
                        <th scope="col-2">Funtion</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${dsBanPhim.content}" var="x">
                        <tr>
                            <th scope="row">${x.tenBanPhim}</th>
                            <th scope="row"><img src="${x.images}" height="50px" width="50px"></th>
                            <td>${x.soLuong}</td>
                            <td>${x.donGia1}</td>
                            <td>${x.denNen==false?"Không":"Có"}</td>
                            <td>${x.hang.tenHang}</td>
                            <td>${x.kieuKetNoi.tenKieu}</td>
                            <td>${x.loaiBanPhim.tenLoai}</td>
                            <td>
                                <a href="/banphim/detail/${x.maBanPhim}"
                                   class="btn btn-outline-primary me-2">Detail</a>
                                <a href="/banphim/view-update/${x.maBanPhim}"
                                   class="btn btn-outline-primary me-2">Update</a>
                                <a href="/banphim/delete/${x.maBanPhim}"
                                   class="btn btn-outline-primary me-2 mt-2"
                                   onclick="return confirm('Bạn có muốn xoá không?');"
                                >Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <!--  -->
        </section>
    </c:if>
    <section class="d-flex justify-content-center mt-5">
        <nav aria-label="Page navigation example">
            <a href="/banphim">Quay lại không search</a>
            <ul class="pagination">
                <c:if test="${dsBanPhim.number+1>1}">
                    <li class="page-item">
                        <a class="page-link" href="${pageUrl}&page=${dsBanPhim.number}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${tongSoTrang}" varStatus="y">
                    <c:if test="${dsBanPhim.number==y.index}">
                        <li class="page-item active">
                            <a class="page-link" href="${pageUrl}&page=${y.index+1}">${y.index+1}</a>
                        </li>
                    </c:if>
                    <c:if test="${dsBanPhim.number!=y.index}">
                        <li class="page-item">
                            <a class="page-link" href="${pageUrl}&page=${y.index+1}">${y.index+1}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${dsBanPhim.getNumber() + 1 lt dsBanPhim.getTotalPages()}">
                    <a class="page-link" aria-label="Next" href="${pageUrl}&page=${dsBanPhim.getNumber() + 2}">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </c:if>
            </ul>
        </nav>
    </section>
</div>
</body>
</html>
