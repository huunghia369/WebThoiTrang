<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Shop thời trang</title>
<style>
.product {
	display: none; /* Ẩn sản phẩm mặc định */
}
</style>
</head>
<body class="hold-transition sidebar-mini">
	<div class="container ">
		<div class="wrapper">
			<div class="content-wrapper">
				<section class="content">
					<div class="container-fluid">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<h1 style="text-align: center; color: red; font-size: 40px;">Lịch
										sử đơn hàng</h1>
									<div id="product-container">
										<c:forEach var="donhangInfo" items="${listDonhang}">
											<li class="product">
												<!-- Hiển thị thông tin đơn hàng -->
												<div>
													<hr>
													<span style="font-weight: bold;">Mã đơn hàng:</span>
													${donhangInfo.phieudat.mapd}<br> <span
														style="font-weight: bold;">Ngày đặt:</span>
													<fmt:formatDate value="${donhangInfo.phieudat.ngaydat}"
														pattern="dd-MM-yyyy" />
													<br>

													<!-- Hiển thị các thông tin khác của phiếu đặt -->
													<br>
													<table border="1">
														<thead>
															<tr>
																<th>Tên sản phẩm</th>
																<th>Hình ảnh</th>
																<th>Số lượng</th>
																<th>Tổng giá</th>
															</tr>
														</thead>
														<tbody>
															<c:set var="phieuDatTotalPrice" value="0" />
															<c:forEach var="donhang"
																items="${donhangInfo.listDonhangForPhieuDat}">
																<tr>
																	<td>${donhang.tenSP}</td>
																	<td>
																		<div id="firebase-image-${donhang.mamh}-${donhangInfo.phieudat.mapd}" ></div>
																		 <script>displayFirebaseImage("${donhang.mamh}", "${donhangInfo.phieudat.mapd}")</script>
																	</td>
																	<td>${donhang.soluong}</td>
																	<td><fmt:formatNumber value="${donhang.tonggia}"
																			pattern="#,##0 đ" /></td>
																	<!-- Cập nhật tổng giá của phiếu đặt -->
																	<c:set var="phieuDatTotalPrice"
																		value="${phieuDatTotalPrice + donhang.tonggia}" />
																</tr>
																
																
															</c:forEach>
															<!-- Hiển thị tổng giá của phiếu đặt -->
															<tr>
																<td colspan="3"><strong>Tổng cộng:</strong></td>
																<td><fmt:formatNumber value="${phieuDatTotalPrice}"
																		pattern="#,##0 đ" /></td>
															</tr>
														</tbody>
													</table>
													<button class="btn btn-primary float-right mr-2 text-white">Xem
														đánh giá</button>
													<button class="btn btn-danger float-right mr-2 text-white"
														onclick="buyAgain(${donhangInfo.phieudat.mapd})">Mua
														lại</button>
												</div>
											</li>
											<br>
										</c:forEach>
									</div>
									<br>
									<button id="load-more-button" class="btn btn-secondary ">Xem
										thêm</button>
									<button id="collapse-button" class="btn btn-secondary d-none">Rút
										gọn</button>
									<br>
									<button class="btn btn btn-success float-right"
										style="color: white">Quay lại trang chủ</button>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<script>
        document.addEventListener('DOMContentLoaded', function () {
            const productsPerPage = 2; // Thay đổi số lượng sản phẩm hiển thị mỗi lần
            let visibleProductCount = productsPerPage;
            const productContainer = document.getElementById('product-container');
            const products = document.querySelectorAll('#product-container .product');

            function hideExcessProducts() {
                products.forEach((product, index) => {
                    if (index < visibleProductCount) {
                        product.style.display = 'block';
                    } else {
                        product.style.display = 'none';
                    }
                });
            }

            const loadMoreButton = document.getElementById('load-more-button');
            const collapseButton = document.getElementById('collapse-button');

            loadMoreButton.addEventListener('click', function () {
                visibleProductCount += productsPerPage;
                hideExcessProducts();

                if (visibleProductCount >= products.length) {
                    loadMoreButton.style.display = 'none';
                    collapseButton.classList.remove('d-none');
                }
            });

            collapseButton.addEventListener('click', function () {
                visibleProductCount = productsPerPage;
                hideExcessProducts();

                collapseButton.classList.add('d-none');
                loadMoreButton.style.display = 'block';
            });

            if (visibleProductCount >= products.length) {
                loadMoreButton.style.display = 'none';
                collapseButton.classList.remove('d-none');
            }

            hideExcessProducts();
        });
    </script>

	<script>
	function buyAgain(mapd) {
		window.location.href="http://localhost:9090/user/history?mapd="+mapd;
	}
</script>
</body>
</html>
