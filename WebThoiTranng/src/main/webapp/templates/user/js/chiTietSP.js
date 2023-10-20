/**
 * 
 */



$(document)
	.ready(
		function() {
			// Lắng nghe sự kiện thay đổi kích thước
			$("#sizeSelect")
				.change(
					function() {
						// Khi thay đổi size, đặt lại nút "Thêm vào giỏ hàng"
						$("#btnThemGH")
							.html(
								'<i class="fas fa-shopping-cart"></i> Thêm vào giỏ hàng');
						$("#btnThemGH").attr(
							"disabled", false); // Bật lại nút button
					});

			$("#btnThemGH")
				.click(
					function(event) {
						event.preventDefault(); // Ngăn chặn hành động mặc định của form (tải lại trang)

						// Lấy giá trị id và size từ các phần tử HTML
						var id = $("#productId").val();
						var size = $("#sizeSelect")
							.val();

						// Thực hiện yêu cầu AJAX để thêm sản phẩm vào giỏ hàng
						$
							.ajax({
								url: "/user/chi-tiet-sp/them?id="
									+ id
									+ "&size="
									+ size, // Đường dẫn đến endpoint xử lý
								type: "POST", // Hoặc "GET" nếu bạn muốn sử dụng GET request
								success: function(response) {
									// Xử lý kết quả trả về nếu cần
									console
										.log("Sản phẩm đã được thêm vào giỏ hàng  "
											+ id
											+ "_"
											+ size);
									// Đặt trạng thái đã thêm sản phẩm và thay đổi nội dung của button
									$("#btnThemGH")
										.html(
											'<i class="fas fa-check"></i> Đã thêm vào giỏ hàng');
									$("#btnThemGH")
										.attr(
											"disabled",
											true); // Vô hiệu hóa button
								},
								error: function() {
									// Xử lý lỗi nếu cần	
									console
										.error("Lỗi khi thêm vào giỏ hàng");
								}
							});
					});
		});
