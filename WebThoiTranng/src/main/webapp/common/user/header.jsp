<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>


<%-- <nav style="padding: 1em 1.5em; font-size: 16px;"
	class="navbar navbar-expand-lg navbar-dark bg-dark">

	<a class="navbar-brand" href='<c:url value="/user/home"/>'><h1>Shop Linh Kiện Xe</h1></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href='<c:url value="/user/home"/>'><i class="fas fa-glasses"></i>
					Trang chủ</a></li>

		</ul>
		<form class="form-inline ml-auto">
			<input value="${paging.search}" name="search"
				style="width: 350px; height: 32px" class="form-control mr-sm-2"
				type="search" placeholder="Nhập từ khóa tìm kiếm..."
				aria-label="Search">
			<button style="height: 32px"
				class="btn btn-outline-light my-2 my-sm-0" type="submit">Tìm
				Kiếm</button>
		</form>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/user/cart"/>"><i
					class="fas fa-shopping-cart"></i> Giỏ Hàng</a></li>
			<%
			Boolean loginValue = (Boolean) session.getAttribute("login");
			boolean isLoggedin = loginValue != null && loginValue.booleanValue();

			if (!isLoggedin) {
			%>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/login"/>"><i class="fas fa-user"></i> Login</a>
			</li>
			<%
			} else {
			%>
			 <li class="nav-item">
        <a class="nav-link" href="/WebBanKinh/user/profile"><i class="fas fa-user"></i><em> ${sessionScope.user.name}</em></a>
    </li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user"></i><em>
						${sessionScope.user.name}</em>
			</a>
				<div class="dropdown-menu" style="font-size: 18px;"
					aria-labelledby="userDropdown">
					<!-- Các mục trong danh sách -->
					<a class="dropdown-item bg-light"
						href="<c:url value="/user/profile"/>">Thông tin cá nhân</a> <a
						class="dropdown-item bg-light"
						href="<c:url value="/user/history"/>">Xem lịch sử đơn đặt hàng</a>
					<a class="dropdown-item bg-light"
						href="<c:url value="/user/change_password"/>">Đổi mật khẩu</a> <a
						class="dropdown-item bg-light" href="#" data-toggle="modal"
						data-target="#confirmModal1">Đăng xuấtt</a>

					<!-- ...Thêm mục khác nếu cần -->
				</div></li>


			<%
			}
			%>



		</ul>

	</div>
</nav>

<div class="modal fade" id="confirmModal1" tabindex="-1" role="dialog"
	aria-labelledby="confirmModalLabel1" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="confirmModalLabel1">Xác nhận đăng
					xuất</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Bạn có chắc chắn muốn đăng xuất hay không?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
				<a href="<c:url value='/user/logout'/>" class="btn btn-primary">Xác
					nhận</a>
			</div>
		</div>
	</div>
</div> --%>

<!-- Header -->
<header class="bg-dark text-white fixed-top ">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div id="shop-name" class="display-4"> <i class="fas fa-dragon"></i> Urban Vogue</div>
                
                <p><span class="lead ml-4"><em>Thời trang - phong cách</em></span></p>

                
            </div>
            <div class="col-md-5">
           
                <form class="form-inline mt-4" >
                    <input class="form-control mr-2" style="width: 60%;" type="search" placeholder="Tìm kiếm">
                    <button class="btn btn-outline-light" type="submit">Tìm kiếm</button>
                </form>
            </div>
			<div class="col-md-3">
				<a href="#" class="btn btn-outline-secondary mt-4 "><i
					class="fas fa-user"></i> Đăng Nhập </a></a> <a href="#"
					class="btn btn-outline-secondary ml-4 mt-4 "><i
					class="fas fa-shopping-cart"></i> Giỏ hàng </a></a>

			</div>

		</div>
    </div>
</header>
