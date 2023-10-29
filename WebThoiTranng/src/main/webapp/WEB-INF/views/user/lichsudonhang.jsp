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
															<div
																id="firebase-image-${donhang.mamh}-${donhangInfo.phieudat.mapd}-${donhang.size}-"></div>
															<script>displayFirebaseImage("${donhang.mamh}", "${donhangInfo.phieudat.mapd}","${donhang.size}","")</script>
															<p class="nameSP">${donhang.tenSP}</p>
															<hr>
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
																			<h4 class="modal-title" style="text-align: center;">Thông
																				Tin Đơn hàng</h4>
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
																								<strong>SĐT:</strong>
																								${donhangInfo.phieudat.sdt}
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
																									items="${donhangInfo.listDonhangForPhieuDat}"
																									varStatus="loop">
																									<div class="SP" id="product-${donhang.mamh}">
																										<div
																											id="firebase-image-${donhang.mamh}-${donhangInfo.phieudat.mapd}-${donhang.size}-${loop.index + 1}"></div>
																										<script>displayFirebaseImage("${donhang.mamh}", "${donhangInfo.phieudat.mapd}","${donhang.size}","${loop.index + 1}")</script>
																										<p class="nameSP">${donhang.tenSP}</p>
																										<hr>
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
																										<div class="rating">
																											<span
																												class="star ${donhang.danhgia >= 1 ? 'star-rated' : ''}"
																												data-mamh="${donhang.mamh}" data-danhgia="1">&#9733;</span>
																											<span
																												class="star ${donhang.danhgia >= 2 ? 'star-rated' : ''}"
																												data-mamh="${donhang.mamh}" data-danhgia="2">&#9733;</span>
																											<span
																												class="star ${donhang.danhgia >= 3 ? 'star-rated' : ''}"
																												data-mamh="${donhang.mamh}" data-danhgia="3">&#9733;</span>
																											<span
																												class="star ${donhang.danhgia >= 4 ? 'star-rated' : ''}"
																												data-mamh="${donhang.mamh}" data-danhgia="4">&#9733;</span>
																											<span
																												class="star ${donhang.danhgia >= 5 ? 'star-rated' : ''}"
																												data-mamh="${donhang.mamh}" data-danhgia="5">&#9733;</span>
																											<!-- Thêm chữ hiển thị -->
																											<span class="rating-text"> <%-- Dựa vào số sao đánh giá, hiển thị chữ tương ứng --%>
																												<c:choose>
																													<c:when test="${donhang.danhgia == 5}">
            Rất tốt
        </c:when>
																													<c:when test="${donhang.danhgia == 4}">
            Tốt
        </c:when>
																													<c:when test="${donhang.danhgia == 3}">
            Bình thường
        </c:when>
																													<c:when test="${donhang.danhgia == 2}">
            Tệ
        </c:when>
																													<c:when test="${donhang.danhgia == 1}">
            Rất tệ
        </c:when>
																													<c:otherwise>
            Chưa đánh giá
        </c:otherwise>
																												</c:choose>
																											</span>
																										</div>

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
												<button class="btn btn-primary" data-toggle="collapse"
													data-target="#products-${donhangInfo.phieudat.mapd}">
													<c:if test="${danhgiaStatus}">Xem đánh giá</c:if>
													<c:if test="${not danhgiaStatus}">Đánh giá</c:if>
												</button>

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
	<script>
document.addEventListener('DOMContentLoaded', function () {
    // Sử dụng JavaScript để xử lý sự kiện mouseenter
    $('.rating .star').mouseenter(function() {
        const rating = $(this).data('danhgia');
        const mamh = $(this).data('mamh');

        // Đặt màu cho các sao từ 1 đến rating thành màu vàng
        $(".star[data-mamh='" + mamh + "']").css("color", "gray");
        for (let i = 1; i <= rating; i++) {
            $(".star[data-mamh='" + mamh + "'][data-danhgia='" + i + "']").css("color", "yellow");
        }
    });
    
    // Đoạn mã JavaScript để xử lý sự kiện khi người dùng tương tác với ngôi sao
    $(document).on("click", ".star", function (event) {
        const rating = $(this).data("danhgia");
        const mamh = $(this).data("mamh");

        // Đặt màu cho các ngôi sao dựa trên số sao đánh giá
        $(".star[data-mamh='" + mamh + "']").css("color", "gray"); // Đặt tất cả ngôi sao thành màu xám

        for (let i = 1; i <= rating; i++) {
            $(".star[data-mamh='" + mamh + "'][data-danhgia='" + i + "']").css("color", "yellow"); // Đặt ngôi sao thành màu vàng
        }

        // Cập nhật số sao đánh giá hiển thị
        $(".rating[data-mamh='" + mamh + "'] .rating-value").text(rating);

        // Gửi yêu cầu POST đánh giá sản phẩm và cập nhật trong cơ sở dữ liệu
        $.ajax({
            type: "POST",
            url: "/user/rate",
            data: {
                mamh: mamh,
                danhgia: rating
            },
            success: function (data) {
                alert("Đã đánh giá thành công");
            },
            error: function (data) {
                alert(data);
            }
        });
    });

    // Đoạn mã JavaScript để xử lý sự kiện khi di chuột ra khỏi phần tử
    $(document).on("mouseleave", ".rating", function () {
        // Lấy số sao đánh giá từ dữ liệu
        const rating = $(this).data("danhgia");
        const mamh = $(this).data("mamh");

        // Đặt lại màu cho các sao dựa trên số sao đánh giá
        $(".star[data-mamh='" + mamh + "']").each(function () {
            const starRating = $(this).data("danhgia");
            if (starRating <= rating) {
                $(this).addClass("star-rated");
            } else {
                $(this).removeClass("star-rated");
            }
        });
    });

});
</script>
</body>
</html>
