/**
 * 
 */






// Lấy nút "Thêm Sản Phẩm"
const openModalBtn = document.getElementById("openModalBtn");

// Lấy modal
const productModal = new bootstrap.Modal(
	document.getElementById("productModal")
);

// Sử dụng sự kiện click để mở modal khi nút được nhấn
openModalBtn.addEventListener("click", function() {
	productModal.show();
});

// Lấy nút "Đóng" trong modal
const closeModalBtn = document.querySelector(
	'#productModal button[data-dismiss="modal"]'
);

// Sử dụng sự kiện click để đóng modal khi nút "Đóng" được nhấn
closeModalBtn.addEventListener("click", function() {
	productModal.hide();
});

// Lấy nút "Thêm Vào Phiếu" trong modal
const addProductBtn = document.getElementById("addProductBtn");

// Kiểm tra sản phẩm đã tồn tại trong mảng hay chưa
function isProductInInvoices(productID, sizeID) {
	return invoices.some(function(invoice) {
		return invoice.productID === productID && invoice.sizeID === sizeID;
	});
}

function showDuplicateProductModal() {
	// Hiển thị modal thông báo ở đây
	// Đảm bảo bạn có modal thông báo hoặc thêm mã HTML cần thiết
	alert("Sản phẩm đã tồn tại trong phiếu nhập hàng.");
}

// Sử dụng sự kiện click để thêm sản phẩm vào phiếu khi nút "Thêm Vào Phiếu" được nhấn
addProductBtn.addEventListener("click", function() {

	const productID = document.getElementById("productName").value;

	const selectElement = document.getElementById("productName");
	const productName =
		selectElement.options[selectElement.selectedIndex].textContent;

	const sizeID = document.getElementById("productSize").value;

	const selectElement2 = document.getElementById("productSize");
	const productSize =
		selectElement2.options[selectElement2.selectedIndex].textContent;

	const giaNhap = document.getElementById("productGiaNhap").value;
	const productQuantity =
		document.getElementById("productQuantity").value;


	if (giaNhap.trim() === "" || productQuantity.trim() === "") {
		// Hiển thị thông báo lỗi nếu trống
		document.getElementById("giaNhapError").textContent = "Giá nhập không được để trống.";
		document.getElementById("quantityError").textContent = "Số lượng không được để trống.";
	} else {

		if (isProductInInvoices(productID, sizeID)) {
			// Sản phẩm đã tồn tại, hiển thị modal thông báo
			showDuplicateProductModal();
			return;
		}
		addInvoice(
			productName,
			productID,
			productSize,
			sizeID,
			giaNhap,
			productQuantity
		);

		// Sau khi thêm sản phẩm, đóng modal
		productModal.hide();
	}



});

// Mảng lưu trữ các phiếu nhập hàng
const invoices = [];

// Hàm để thêm một phiếu nhập hàng vào bảng và đóng dialog
function addInvoice(
	productName,
	productID,
	productSize,
	sizeID,
	giaNhap,
	productQuantity
) {
	const tableBody = document.querySelector("#invoiceTable tbody");
	const newRow = tableBody.insertRow();
	const cellNumber = newRow.insertCell(0);
	const cellProductName = newRow.insertCell(1);
	const cellSize = newRow.insertCell(2);
	const cellQuantity = newRow.insertCell(3);
	const cellGiaNhap = newRow.insertCell(4); // Thêm cột Giá nhập
	const cellDelete = newRow.insertCell(5); // Thêm cột Xóa

	cellNumber.innerHTML = invoices.length + 1;
	cellProductName.innerHTML = productName;
	cellSize.innerHTML = productSize;
	cellQuantity.innerHTML = productQuantity;
	cellGiaNhap.innerHTML = giaNhap;

	// Tạo nút Xóa và thiết lập sự kiện xóa sản phẩm
	const deleteButton = document.createElement("button");
	deleteButton.textContent = "Xóa";
	deleteButton.classList.add("btn", "btn-danger");
	deleteButton.addEventListener("click", function() {
		// Xử lý xóa sản phẩm ở đây
		removeRow(newRow);
		removeProduct(productID, sizeID);
	});

	cellDelete.appendChild(deleteButton);

	// Tạo đối tượng sản phẩm
	const product = {
		productID,
		productName,
		sizeID,
		productSize,
		giaNhap,
		productQuantity,
	};

	// Thêm sản phẩm vào mảng
	invoices.push(product);
}

// Hàm để xóa dòng khỏi bảng
function removeRow(row) {
	const tableBody = document.querySelector("#invoiceTable tbody");
	const rowIndex = row.rowIndex;

	// Xóa hàng khỏi bảng
	tableBody.deleteRow(rowIndex - 1);

	// Cập nhật lại số thứ tự trong bảng
	const rows = tableBody.getElementsByTagName("tr");
	for (let i = rowIndex - 1; i < rows.length; i++) {
		rows[i].cells[0].textContent = i + 1;
	}
}

// Hàm để xóa sản phẩm khỏi mảng invoices
function removeProduct(productID, sizeID) {
	invoices = invoices.filter(function(invoice) {
		return invoice.productID !== productID || invoice.sizeID !== sizeID;
	});
}

//Xử lí khi nhấp vào nút thêm phiếu nhập
const btnThemPN = document.getElementById("btnThemPN");

btnThemPN.addEventListener("click", function() {
	if (invoices.length === 0) {
		alert("Phiếu nhập hàng chưa có sản phẩm nào!!!");
	}
	else {
		if (confirm("Bạn có muốn thêm phiếu nhập không?")) {
			const ncc= document.getElementById("supplier").value;
			$.ajax({
				url: "/admin/them-pn?ncc="+ncc, // Thay thế bằng URL của controller của bạn
				method: "POST",
				data: JSON.stringify(invoices),
				contentType: "application/json",
				success: function(response) {
					// Xử lý phản hồi từ controller (nếu cần)
					console.log(response);
					alert("Thêm phiếu nhập hàng mới thành công");
					window.location.href = "/admin/nhap-hang";
				},
				error: function() {
					// Xử lý lỗi nếu có
					console.log('loi');
				},
			});
		}
	}
});

// Hàm để kiểm tra xem sản phẩm có trong mảng invoices không
function isProductInInvoices_1(productID) {
	return invoices.some(function(invoice) {
		return invoice.productID === productID;
	});
}

// Hàm để lấy giá nhập của sản phẩm từ mảng invoices (nếu có)
function getGiaNhapFromInvoices(productID) {
	const existingProduct = invoices.find(function(invoice) {
		return invoice.productID === productID;
	});
	return existingProduct ? existingProduct.giaNhap : null;
}

// Sử dụng sự kiện change để kiểm tra khi sản phẩm thay đổi
const selectElement = document.getElementById("productName");
selectElement.addEventListener("change", function() {
	const productID = this.value;

	const giaNhapInput = document.getElementById("productGiaNhap");

	if (isProductInInvoices_1(productID)) {
		// Nếu sản phẩm đã tồn tại, lấy giá nhập từ mảng invoices và gán vào ô giá nhập
		const giaNhap = getGiaNhapFromInvoices(productID);
		giaNhapInput.value = giaNhap;
		giaNhapInput.setAttribute("readonly", "readonly"); // Đánh dấu ô giá nhập là chỉ đọc
	} else {
		// Nếu sản phẩm không tồn tại, cho phép người dùng nhập giá nhập mới
		giaNhapInput.removeAttribute("readonly");
	}
});




