<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<!-- Thêm tệp CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@10/dist/sweetalert2.min.css">

<!-- Thêm tệp JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

<link rel="stylesheet"
	href='<c:url value="/templates/user/css/chiTietSP.css"/>'>

<script src="<c:url value='/templates/user/js/chiTietSP.js'/>"
	type="text/javascript"></script>


</head>
<body>
	<div class="container-fluid ">

		<div class="header">
			<label>Thông tin chi tiết sản phẩm</label>
		</div>

		<div class="row khung">
			<div class="col-5">

				<div id="myCarousel" class="carousel slide "
					data-ride="carousel">
					<!-- Slides (hình ảnh) -->
					<div class="carousel-inner">
						<c:forEach var="linkAnh" items="${mh.getHinhanhmhs()}"
							varStatus="status">
							<div
								class="carousel-item khung_anh ${status.first ? 'active' : ''}">
								<img src="${linkAnh.getDuongdan()}" alt="Hình Ảnh ${status.index + 1}"
									class="d-block w-100">
							</div>
						</c:forEach>
					</div>



					<!-- Nút chuyển đổi trước và sau -->
					<a class="carousel-control-prev" href="#myCarousel"
						data-slide="prev"> <span class="carousel-control-prev-icon"></span>
					</a> <a class="carousel-control-next" href="#myCarousel"
						data-slide="next"> <span class="carousel-control-next-icon"></span>
					</a>
				</div>

				<div class="container mt-5"></div>

			</div>
			<div class="col">
				<div class="card mx-auto khung_inf">
					<div class="card-body ml-20">
						<input type="hidden" id="productId" value="${mh.getMamh()}">
						<ul class="list-group list-group-flush">

							<li class="list-group-item"><strong class="mr-2">Tên
									sản phẩm :</strong> <span>${mh.getTenmh()}</span></li>
							<li class="list-group-item"><strong class="mr-2">Thương
									hiệu:</strong> <span>${mh.getNhanhieu().getTennh()}</span></li>
							<li class="list-group-item"><strong class="mr-2">Chất
									liệu:</strong> <span>${mh.getChatlieu().getTenvai()}</span></li>
							<li class="list-group-item"><strong class="mr-2">Giá:</strong>
								<span data-gia="${gia }" id="giaBan"></span></li>
							<li class="list-group-item"><strong class="mr-2">Kích
									thước:</strong> <select id="sizeSelect" class="form-select">
									<c:forEach var="CTSize" items="${mh.getCtsizes()}">
										<option value="${CTSize.getSize().getMasize()}">${CTSize.getSize().getTensize()}</option>
									</c:forEach>
							</select></li>
							<li class="list-group-item"><strong class="mr-2">Mô
									tả:</strong> <span>${mh.getMota()}</span></li>

							<li class="list-group-item d-flex"><strong class="mr-2">Điểm đánh
									giá:</strong>
								<div id="rating-container">
									<div id="rating-stars"></div>
									<input type="hidden" id="danhGia" value="${danhGia}">
									<div id="rating-score"></div>
								</div></li>
						</ul>

						<div class="text-center mt-4">
							<!-- Nút "Thêm vào giỏ hàng" với hiệu ứng thu nhỏ hình ảnh -->
							<button id="btnThemGH" name="btnThemGH"
								class="btn btn-success btn-add-to-cart lg">
								<i class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng
							</button>
							<!-- Nút "Mua ngay" -->
							<button class="btn btn-primary btn-buy-now lg" id="muaNgay">
								<i class="fas fa-shopping-bag"></i> Mua ngay
							</button>
						</div>
					</div>

				</div>


			</div>
		</div>
		<div class="row khung">
		<div class="header">
			<label>________ Sản phẩm liên quan ________</label>
		</div>
		
		<h1>Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh-Đây là phần cho thông minh</h1>
		</div>
	</div>
	<script type="text/javascript">
		
	</script>
</body>
</html>




