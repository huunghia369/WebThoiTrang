<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Ký</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value='/templates/login/register.css'/>" />

<style>
.page {
	background-image:
		url("https://plus.unsplash.com/premium_photo-1683309565422-77818a287060?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
	background-size: cover;
	background-repeat: no-repeat;
}

.dropdown:hover .dropdown-menu {
	display: block;
	margin-top: 0;
}

.icon {
	color: #fff;
}
.login-header {
    text-align: center; /* Căn giữa ngang */
    line-height: 100px; /* Căn giữa theo chiều dọc - điều chỉnh giá trị này để căn giữa theo ý muốn */
}

</style>

</head>

<body class="page">


	<div class="wrap">
		<div class="login" style="margin-top: 20%;">
			<!--<i class="fa-solid fa-xmark iconclose1"></i>-->
			<h2 class="login-header">Cập nhật thông tin</h2>
			<form:form class="login-form" method="POST"
				action="insert" modelAttribute="KhachHang">


				<div class="input-container">
					<i class="fa-solid fa-user icon"></i>
					<form:input type="text" pattern=".*" class="input-content"
						placeholder="Họ và Tên" path="hotenkh" />
					<p
						style="color: #ff3366; font-size: 12px; margin-top: 5px; margin-bottom: 0px;">
						<form:errors path="hotenkh" cssClass="errors" />
					</p>
				</div>

				<div class="input-container">
					<i class="fa-solid fa-globe icon"></i>
					<form:select path="gioitinh" id="cars" class="select input-content"
						placeholder="Giới tính">
						<option value="true">Nam</option>
						<option value="false">Nữ</option>
					</form:select>
				</div>

				<div class="input-container">
					<i class="fa-solid fa-phone icon"></i>
					<form:input type="text" class="input-content"
						placeholder="Số điện thoại" path="sdt" />
					<p
						style="color: #ff3366; font-size: 12px; margin-top: 5px; margin-bottom: 0px;">
						<form:errors path="sdt" cssClass="errors" />
					</p>
				</div>





				<div class="input-container">
					<i class="fa-solid fa-globe icon"></i>
					<form:select path="diachi" id="cars" class="select">
						<option class="opacity-value" value>Area</option>
						<option value="An Giang">An Giang</option>
						<option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu</option>
						<option value="Bắc Giang">Bắc Giang</option>
						<option value="Bắc Kạn">Bắc Kạn</option>
						<option value="Bạc Liêu">Bạc Liêu</option>
						<option value="Bắc Ninh">Bắc Ninh</option>
						<option value="Bến Tre">Bến Tre</option>
						<option value="Bình Định">Bình Định</option>
						<option value="Bình Dương">Bình Dương</option>
						<option value="Bình Phước">Bình Phước</option>
						<option value="Bình Thuận">Bình Thuận</option>
						<option value="Cà Mau">Cà Mau</option>
						<option value="Cần Thơ">Cần Thơ</option>
						<option value="Cao Bằng">Cao Bằng</option>
						<option value="Đà Nẵng">Đà Nẵng</option>
						<option value="Đắk Lắk">Đắk Lắk</option>
						<option value="Đắk Nông">Đắk Nông</option>
						<option value="Điện Biên">Điện Biên</option>
						<option value="Đồng Nai">Đồng Nai</option>
						<option value="Đồng Tháp">Đồng Tháp</option>
						<option value="Gia Lai">Gia Lai</option>
						<option value="Hà Giang">Hà Giang</option>
						<option value="Hà Nam">Hà Nam</option>
						<option value="Hà Nội">Hà Nội</option>
						<option value="Hà Tĩnh">Hà Tĩnh</option>
						<option value="Hải Dương">Hải Dương</option>
						<option value="Hải Phòng">Hải Phòng</option>
						<option value="Hậu Giang">Hậu Giang</option>
						<option value="Hòa Bình">Hòa Bình</option>
						<option value="Hưng Yên">Hưng Yên</option>
						<option value="Khánh Hòa">Khánh Hòa</option>
						<option value="Kiên Giang">Kiên Giang</option>
						<option value="Kon Tum">Kon Tum</option>
						<option value="Lai Châu">Lai Châu</option>
						<option value="Lâm Đồng">Lâm Đồng</option>
						<option value="Lạng Sơn">Lạng Sơn</option>
						<option value="Lào Cai">Lào Cai</option>
						<option value="Long An">Long An</option>
						<option value="Nam Định">Nam Định</option>
						<option value="Nghệ An">Nghệ An</option>
						<option value="Ninh Bình">Ninh Bình</option>
						<option value="Ninh Thuận">Ninh Thuận</option>
						<option value="Phú Thọ">Phú Thọ</option>
						<option value="Phú Yên">Phú Yên</option>
						<option value="Quảng Bình">Quảng Bình</option>
						<option value="Quảng Nam">Quảng Nam</option>
						<option value="Quảng Ngãi">Quảng Ngãi</option>
						<option value="Quảng Ninh">Quảng Ninh</option>
						<option value="Quảng Trị">Quảng Trị</option>
						<option value="Sóc Trăng">Sóc Trăng</option>
						<option value="Sơn La">Sơn La</option>
						<option value="Tây Ninh">Tây Ninh</option>
						<option value="Thái Bình">Thái Bình</option>
						<option value="Thái Nguyên">Thái Nguyên</option>
						<option value="Thanh Hóa">Thanh Hóa</option>
						<option value="Thừa Thiên Huế">Thừa Thiên Huế</option>
						<option value="Tiền Giang">Tiền Giang</option>
						<option value="Trà Vinh">Trà Vinh</option>
						<option value="Tuyên Quang">Tuyên Quang</option>
						<option value="Vĩnh Long">Vĩnh Long</option>
						<option value="Vĩnh Phúc">Vĩnh Phúc</option>
						<option value="Yên Bái">Yên Bái</option>
						<option value="Phú Quốc">Phú Quốc</option>
						<option value="Các huyện đảo">Các huyện đảo</option>
					</form:select>
				</div>

				<div>


					<label class="form-label" for="">Ngày sinh</label> <select
						name="day" id="day" class="select-date" required>
						<option value>Ngày</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select> <select name="month" id="month" class="select-date" required>
						<option value>Tháng</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select> <select name="year" id="year" class="select-date" required>
						<option value>Năm</option>

						<option value="2008">2008</option>
						<option value="2007">2007</option>
						<option value="2006">2006</option>
						<option value="2005">2005</option>
						<option value="2004">2004</option>
						<option value="2003">2003</option>
						<option value="2002">2002</option>
						<option value="2001">2001</option>
						<option value="2000">2000</option>
						<option value="1991">1999</option>
						<option value="1991">1998</option>
						<option value="1991">1997</option>
						<option value="1991">1996</option>
						<option value="1991">1995</option>
						<option value="1991">1994</option>
						<option value="1991">1993</option>
						<option value="1991">1992</option>
						<option value="1991">1991</option>
						<option value="1990">1990</option>
						<option value="1989">1989</option>

					</select>
				</div>
				<div class="submit-row">
					<button type="submit" class="btn-submit">Xác Nhận</button>
					<!--<div class="term-policy-container"> By signing up, you agree to our&nbsp; <a href="#" class="link">
							Terms of Use </a> &nbsp;and&nbsp; <a href="#" class="link">
							Privacy Policy </a>
					</div>-->
				</div>
			</form:form>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>