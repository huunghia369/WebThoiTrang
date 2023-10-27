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
</head>
<body class="hold-transition sidebar-mini">
	<div class="container">
		<div class="wrapper">
			<div class="content-wrapper">
				<section class="content">
					<div class="container-fluid">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<br>
									<h1 style="text-align: center; color: red; font-size: 40px;">Lịch
										sử đơn hàng</h1>
									<div id="order-container">
										<c:forEach var="donhangInfo" items="${listDonhang}">
											<div class="order" id="order-${donhangInfo.phieudat.mapd}"
												data-toggle="modal"
												data-target="#modal-${donhangInfo.phieudat.mapd}">
												<!-- Hiển thị thông tin đơn hàng -->
												<div>
													<p>
														<strong>Mã đơn hàng:</strong> ${donhangInfo.phieudat.mapd}
													</p>
													<p>
														<strong>Ngày đặt:</strong>
														<fmt:formatDate value="${donhangInfo.phieudat.ngaydat}"
															pattern="dd-MM-yyyy" />
													</p>
												</div>
												<%-- Thêm biến để tính tổng giá --%>
												<c:set var="phieuDatTotalPrice" value="0" />
												<div class="listSP">
													<c:forEach var="donhang"
														items="${donhangInfo.listDonhangForPhieuDat}">
														<div class="SP" id="product-${donhang.mamh}">
															<p class="infoSP">
																<strong>Tên sản phẩm:</strong> ${donhang.tenSP}
															</p>
															<p class="infoSP">
																<strong>Hình ảnh:</strong><div id="firebase-image-${donhang.mamh}-${donhangInfo.phieudat.mapd}-${donhang.size}-" ></div>
																		 <script>displayFirebaseImage("${donhang.mamh}", "${donhangInfo.phieudat.mapd}","${donhang.size}","")</script>
															</p>
															<p class="infoSP">
																<strong>Size:</strong> ${donhang.size}
															</p>
															<p class="infoSP">
																<strong>Số lượng:</strong> ${donhang.soluong}
															</p>
															<c:set var="khuyenmai" value="${donhang.mucgiamgia}" />
															<p class="priceSP">
																<strong class="priceLabel">Giá bán:</strong>
																<c:if test="${khuyenmai > 0}">
																	<span
																		style="text-decoration: line-through; color: red;">
																		<fmt:formatNumber value="${donhang.tonggia}"
																			pattern="#,##0 đ" />
																	</span>
																</c:if>
																<fmt:formatNumber
																	value="${donhang.tonggia - (donhang.tonggia * khuyenmai / 100)}"
																	pattern="#,##0 đ" />
															</p>
															<%-- Tính tổng giá của sản phẩm và cộng vào tổng giá của phiếu đặt --%>
															<c:set var="phieuDatTotalPrice"
																value="${phieuDatTotalPrice + (donhang.tonggia - (donhang.tonggia * khuyenmai / 100))}" />

															<div class="modal fade"
																id="modal-${donhangInfo.phieudat.mapd}">
																<div class="modal-dialog modal-lg">
																	<div class="modal-content ">
																		<div class="  modal-header "
																			style="background: #2c83e0; color: white;">
																			<h4 class="modal-title ">Thông Tin Đơn hàng</h4>
																			<button type="button" class="close"
																				data-dismiss="modal" aria-label="Close">
																				<span aria-hidden="true">&times;</span>
																			</button>
																		</div>
																		<div class="modal-body">
																			<div class="container">
																				<div class="row">
																					<div class="col col-sm-6" style="margin-top: 35px;">
																						<!-- Hiển thị thông tin đơn hàng -->
																						<div class="order-info">
																							<p>
																								<strong>Người nhận:</strong>
																								${donhangInfo.phieudat.hotennguoinhan}
																							</p>
																							<p>
																								<strong>Địa chỉ nhận hàng:</strong>
																								${donhangInfo.phieudat.diachi}
																							</p>
																							<p>
																								<strong>Ngày đặt:</strong>
																								<fmt:formatDate
																									value="${donhangInfo.phieudat.ngaydat}"
																									pattern="dd-MM-yyyy" />
																							</p>
																						</div>
																					</div>
																					<div class="col col-sm-6">
																						<form class="invoice-form" style="display: none;">
																							<p>
																								<strong>Mã đơn hàng:</strong>
																								${donhangInfo.phieudat.mapd}
																							</p>
																							<%-- Thêm biến để tính tổng giá --%>
																							<c:set var="phieuDatTotalPrice" value="0" />
																							<div class="listSP">
																								<c:forEach var="donhang"
																									items="${donhangInfo.listDonhangForPhieuDat}" varStatus="loop">
																									<div class="SP" id="product-${donhang.mamh}">
																										<p class="infoSP">
																											<strong>Tên sản phẩm:</strong>
																											${donhang.tenSP}
																										</p>
																										<p class="infoSP">
																											<strong>Hình ảnh:</strong><div id="firebase-image-${donhang.mamh}-${donhangInfo.phieudat.mapd}-${donhang.size}-${loop.index + 1}" ></div>
																		 <script>displayFirebaseImage("${donhang.mamh}", "${donhangInfo.phieudat.mapd}","${donhang.size}","${loop.index + 1}")</script>
																										</p>
																										<p class="infoSP">
																											<strong>Size:</strong> ${donhang.size}
																										</p>
																										<p class="infoSP">
																											<strong>Số lượng:</strong> ${donhang.soluong}
																										</p>
																										<c:set var="khuyenmai"
																											value="${donhang.mucgiamgia}" />
																										<p class="priceSP">
																											<strong class="priceLabel">Giá bán:</strong>
																											<c:if test="${khuyenmai > 0}">
																												<span
																													style="text-decoration: line-through; color: red;">
																													<fmt:formatNumber
																														value="${donhang.tonggia}"
																														pattern="#,##0 đ" />
																												</span>
																											</c:if>
																											<fmt:formatNumber
																												value="${donhang.tonggia - (donhang.tonggia * khuyenmai / 100)}"
																												pattern="#,##0 đ" />
																										</p>
																										<%-- Tính tổng giá của sản phẩm và cộng vào tổng giá của phiếu đặt --%>
																										<c:set var="phieuDatTotalPrice"
																											value="${phieuDatTotalPrice + (donhang.tonggia - (donhang.tonggia * khuyenmai / 100))}" />
																									</div>
																								</c:forEach>
																							</div>
																							<!-- Hiển thị tổng giá của phiếu đặt -->
																							<div class="donhang-summary">
																								<p>
																									<br> <strong style="font-weight: bold;">Tổng
																										cộng:</strong>
																									<fmt:formatNumber value="${phieuDatTotalPrice}"
																										pattern="#,##0 đ" />
																								</p>
																							</div>
																						</form>
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</c:forEach>
												</div>
												<!-- Hiển thị tổng giá của phiếu đặt -->
												<div class="donhang-summary">
													<p>
														<br> <strong style="font-weight: bold;">Tổng
															cộng:</strong>
														<fmt:formatNumber value="${phieuDatTotalPrice}"
															pattern="#,##0 đ" />
													</p>
												</div>
												<c:choose>
													<c:when test="${danhgiaStatus}">
														<button class="btn btn-primary" data-toggle="collapse"
															data-target="#products-${donhangInfo.phieudat.mapd}">Xem
															đánh giá</button>
													</c:when>
													<c:otherwise>
														<button class="btn btn-primary" data-toggle="collapse"
															data-target="#products-${donhangInfo.phieudat.mapd}">Đánh
															giá</button>
													</c:otherwise>
												</c:choose>

												<button class="btn btn-danger"
													onclick="buyAgain(${donhangInfo.phieudat.mapd})">Mua
													lại</button>
											</div>
										</c:forEach>
									</div>
									<br>
									<button id="load-more-button" class="btn btn-secondary">Xem
										thêm</button>
									<button id="collapse-button" class="btn btn-secondary d-none">Rút
										gọn</button>
									<br> <a href="http://localhost:8080"
										class="btn btn-success float-right" style="color: white">Quay
										lại trang chủ</a>
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
        const productsPerPage = 2;
        let visibleProductCount = productsPerPage;
        const productContainer = document.getElementById('order-container');
        const orders = document.querySelectorAll('#order-container .order');

        function hideExcessOrders() {
            orders.forEach((order, index) => {
                if (index < visibleProductCount) {
                    order.style.display = 'block';
                } else {
                    order.style.display = 'none';
                }
            });
        }

        const loadMoreButton = document.getElementById('load-more-button');
        const collapseButton = document.getElementById('collapse-button');

        loadMoreButton.addEventListener('click', function () {
            visibleProductCount += productsPerPage;
            hideExcessOrders();
            if (visibleProductCount >= orders.length) {
                loadMoreButton.style.display = 'none';
                collapseButton.classList.remove('d-none');
            }
        });
        collapseButton.addEventListener('click', function () {
            visibleProductCount = productsPerPage;
            hideExcessOrders();
            collapseButton.classList.add('d-none');
            loadMoreButton.style.display = 'block';
        });
        if (visibleProductCount >= orders.length) {
            loadMoreButton.style.display = 'none';
            collapseButton.classList.remove('d-none');
        }
        hideExcessOrders();
    });
</script>
	<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Lấy danh sách tất cả các thẻ div sản phẩm
        const productDivs = document.querySelectorAll('.SP');

        // Gán sự kiện nhấn vào từng thẻ div sản phẩm
        productDivs.forEach(function (productDiv) {
            productDiv.addEventListener('click', function () {
                // Thực hiện hành động khi thẻ div sản phẩm được nhấn
                // Ví dụ: Hiển thị thông tin chi tiết sản phẩm, chuyển đến trang sản phẩm, v.v.
            });
        });
    });
</script>
	<script>
    document.addEventListener('DOMContentLoaded', function () {
        // Lấy danh sách tất cả các thẻ div "order"
        const orderDivs = document.querySelectorAll('.order');

        orderDivs.forEach(function (orderDiv) {
            const invoiceForm = orderDiv.querySelector('.invoice-form');
            
            // Thêm sự kiện click vào div "order"
            orderDiv.addEventListener('click', function () {
                // Toggle hiển thị/ẩn form hóa đơn
                if (invoiceForm.style.display === 'none' || invoiceForm.style.display === '') {
                    invoiceForm.style.display = 'block';
                } else {
                    invoiceForm.style.display = 'none';
                }
            });

            // Lấy nút "Đánh giá" hoặc "Xem đánh giá" trong thẻ "order"
            const reviewButton = orderDiv.querySelector('.btn-primary');

            // Thêm sự kiện click vào nút "Đánh giá" / "Xem đánh giá"
            reviewButton.addEventListener('click', function () {
                // Xác định trạng thái đánh giá dựa trên nội dung của nút
                const danhgiaStatus = reviewButton.textContent === 'Xem đánh giá';

                if (danhgiaStatus) {
                    // Đã đánh giá, thực hiện hành động khi xem đánh giá
                    // Ví dụ: Hiển thị đánh giá sản phẩm
                } else {
                    // Chưa đánh giá, thực hiện hành động khi đánh giá sản phẩm
                    // Ví dụ: Mở một cửa sổ hoặc trang để đánh giá sản phẩm
                }
            });
        });
    });
</script>
	<script>
    function buyAgain(mapd) {
        window.location.href = "http://localhost:8080/user/history?mapd=" + mapd;
    }
</script>
</body>
</html>
