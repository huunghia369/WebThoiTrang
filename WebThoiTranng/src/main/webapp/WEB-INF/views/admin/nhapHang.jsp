<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Cửa Hàng Thời Trang</title>

<link rel="stylesheet"
	href='<c:url value="/templates/admin/css/nhapHang.css"/>'>

</head>

<body>
	<div class="container">
		<h1 style="text-align: center;">Phiếu Nhập Hàng</h1>
		<div style="font-size: 30px;">
			<label for="supplier">Nhà Cung Cấp: </label> <select
				class="form-select" id="supplier" name="supplier">
				<c:forEach var="ncc" items="${dsNCC}">
					<option value="${ncc.getMancc()}">${ncc.getTenncc()}</option>
				</c:forEach>
			</select>
		</div>
		<section class="card">
			<table id="invoiceTable"
				class="table table-striped table-bordered table-hover">
				<thead style="background-color: lightgray;">
					<tr>
						<th>Số Thứ Tự</th>
						<th>Tên Sản Phẩm</th>
						<th>Size</th>
						<th>Số Lượng</th>
						<th>Giá Nhập</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<!-- Dữ liệu sẽ được thêm vào đây sau khi tạo phiếu -->
				</tbody>
			</table>
		</section>
		<div class="fixed-buttons">
			<!-- Nút để mở dialog -->
			<button type="button" id="openModalBtn" class="btn btn-primary">
				Thêm Sản Phẩm</button>

			<!-- Nút để mở dialog -->
			<button type="button" id="btnThemPN" class="btn btn-success">
				Thêm phiếu nhập</button>
		</div>
		<!-- Dialog sử dụng Bootstrap Modal -->
		<div class="modal fade" id="productModal" tabindex="-1" role="dialog"
			aria-labelledby="productDialogLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header bg-success text-white">
						<h5 class="modal-title" id="productDialogLabel">Thêm Sản Phẩm</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="productName">Tên Sản Phẩm:</label>
							<div class="d-flex">
								<select id="productName" name="productName"
									class="form-control selectpicker" data-live-search="true"
									required>
									<c:forEach var="sp" items="${dsMatHang}">
										<option value="${sp.getMamh()}">${sp.getTenmh()}</option>
									</c:forEach>
								</select> <span class="ml-2">
									<button type="button" class="btn btn-primary" id="themSP"><i class="fa fa-plus-square"></i></button>
								</span>
							</div>
						</div>

						<div class="form-group">
							<label for="productSize">Size:</label> 
							<div class="d-flex">
							<select id="productSize"
								name="productSize" class="form-control" required>
								<c:forEach var="size" items="${dsSize}">
									<option value="${size.getMasize()}">${size.getTensize()}</option>
								</c:forEach>
							</select>
							<button type="button" class="btn btn-primary" id="themSize"><i class="fa fa-plus-square"></i></button>
						</div>
						</div>
						<div class="form-group">
							<label for="productGiaNhap">Giá Nhập:</label> <input
								type="number" class="form-control" id="productGiaNhap"
								name="productGiaNhap" required min="1" />
							<div id="giaNhapError" class="text-danger"></div>
						</div>
						<div class="form-group">
							<label for="productQuantity">Số Lượng:</label> <input
								type="number" class="form-control" id="productQuantity"
								name="productQuantity" required min="1" />
							<div id="quantityError" class="text-danger"></div>
						</div>

					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-success" id="addProductBtn">
							Thêm Vào Phiếu</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Đóng</button>
					</div>
				</div>
			</div>
		</div>

<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="addProductModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title" id="addProductModalLabel">Thêm Sản Phẩm Mới</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Nội dung modal nhập sản phẩm mới -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="saveProductBtn">Lưu</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="addSizeModal" tabindex="-1" role="dialog" aria-labelledby="addSizeModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title" id="addSizeModalLabel">Thêm Size Mới</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Nội dung modal nhập size mới -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="saveSizeBtn">Lưu</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
      </div>
    </div>
  </div>
</div>



<script type="text/javascript">
  // Xử lý khi nhấp vào nút 'themSP'
  $("#themSP").click(function() {
    $("#addProductModal").modal("show");
  });

  // Xử lý khi nhấp vào nút 'themSize'
  $("#themSize").click(function() {
    $("#addSizeModal").modal("show");
  });

  // Xử lý khi nhấp vào nút 'Lưu' trong modal nhập sản phẩm mới
  $("#saveProductBtn").click(function() {
    // Thực hiện xử lý lưu dữ liệu sản phẩm mới
    // Đóng modal
    $("#addProductModal").modal("hide");
  });

  // Xử lý khi nhấp vào nút 'Lưu' trong modal nhập size mới
  $("#saveSizeBtn").click(function() {
    // Thực hiện xử lý lưu dữ liệu size mới
    // Đóng modal
    $("#addSizeModal").modal("hide");
  });
</script>

	</div>
	<!-- Thêm Bootstrap 4 JavaScript và jQuery từ CDN (cần có jQuery) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		type="text/javascript"></script>

	<script src="<c:url value='/templates/admin/js/nhapHang.js'/>"
		type="text/javascript"></script>



</body>
</html>
