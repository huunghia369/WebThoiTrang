<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

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
				<div id="myCarousel" class="carousel slide khung_anh "
					data-ride="carousel">
					<!-- Slides (hình ảnh) -->
					<div class="carousel-inner">
						<div class="carousel-item khung_anh">
							<img
								src="https://vapa.vn/wp-content/uploads/2022/12/anh-thien-nhien-dep-3d-007.jpg"
								alt="Hình Ảnh 1" class="d-block w-100 ">
						</div>
						<div class="carousel-item active khung_anh">
							<img
								src="https://vapa.vn/wp-content/uploads/2022/12/anh-thien-nhien-dep-3d-007.jpg"
								alt="Hình Ảnh 2" class="d-block w-100 ">

						</div>
						<div class="carousel-item khung_anh">
							<img
								src="https://vapa.vn/wp-content/uploads/2022/12/anh-dep-thien-nhien-3d-007.jpg"
								alt="Hình Ảnh 3" class="d-block w-100 ">

						</div>
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
				<div class="card mx-auto khung_inf"
					style="background-color: #f8f8f8; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);">
					
					<div class="card-body">
						<input type="hidden" id ="productId" value="${mh.getMamh()}">
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
										<option value="${CTSize.getSize().getTensize()}">${CTSize.getSize().getTensize()}</option>
									</c:forEach>
							</select></li>
							<li class="list-group-item"><strong class="mr-2">Mô
									tả:</strong> <span>${mh.getMota()}</span></li>
							<li class="list-group-item"><strong class="mr-2">Đánh
									giá sản phẩm:</strong>
								<div class="rating">
									<span class="star">★</span> <span class="star">★</span> <span
										class="star">★</span> <span class="star">★</span> <span
										class="star">☆</span> <span>4/5</span>
								</div></li>
						</ul>

						<div class="text-center mt-4">
							<!-- Nút "Thêm vào giỏ hàng" với hiệu ứng thu nhỏ hình ảnh -->
							<button id="btnThemGH" name="btnThemGH"
								class="btn btn-success btn-add-to-cart lg">
								<i class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng
							</button>
							<!-- Nút "Mua ngay" -->
							<button class="btn btn-primary btn-buy-now lg">
								<i class="fas fa-shopping-bag"></i> Mua ngay
							</button>
						</div>
					</div>

				</div>


			</div>
		</div>

	</div>
	<script type="text/javascript">
		// Lấy phần tử span có id là "giaBan"
		const giaBanElement = document.getElementById('giaBan');

		//Lấy giá trị của biến gia từ môi trường view
		const gia = giaBanElement.getAttribute('data-gia');
		// Tạo đối tượng Intl.NumberFormat và định dạng giá
		const formatter = new Intl.NumberFormat('vi-VN', {
			style : 'currency',
			currency : 'VND',
		});

		// Định dạng giá và đặt nội dung cho phần tử span
		giaBanElement.textContent = formatter.format(gia);
	</script>
</body>
</html>




