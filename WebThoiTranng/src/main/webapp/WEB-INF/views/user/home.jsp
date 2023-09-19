<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cửa hàng thời trang</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
    
   <style>
    .custom-padding {
        padding-left: 30px;
        padding-right: 30px;
        width: 200px; /* Đặt chiều dài tùy chỉnh tại đây */
  
    }
</style>
</head>
<body >



<!-- Slide -->
	<div class="container" style="margin-top: 5%;">
		<div class="row">
			<div class="col-md-6">

				<div class="row">
					<div class="col-md-12">
					
						<div id="productSlide" class="carousel slide " data-ride="carousel">
					<div class="carousel-inner ">
						<div class="carousel-item  active " >
							<img
								src="https://images.unsplash.com/photo-1523779105320-d1cd346ff52b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1773&q=80"
								class="d-block mx-auto" alt="Sản phẩm 1"
								style="max-width: 100%; height: auto;">

						</div>
						<div class="carousel-item " >
							<img
								src="https://images.unsplash.com/photo-1523381210434-271e8be1f52b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1770&q=80"
								class="d-block w-100 mx-auto" alt="Sản phẩm 2"
								style="max-width: 100%; height: auto;">
						</div>
						<div class="carousel-item" >
							<img
								src="https://images.unsplash.com/photo-1620799140408-edc6dcb6d633?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1972&q=80"
								class="d-block w-100 mx-auto" alt="Sản phẩm 3"
								style="max-width: 100%; height: auto;">
						</div>
						<div class="carousel-item" >
							<img
								src="https://plus.unsplash.com/premium_photo-1663100940306-d9d419fe7cfa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1764&q=80"
								class="d-block w-100 mx-auto" alt="Sản phẩm 4"
								style="max-width: 100%; height: auto;">
						</div>
					</div>
					<a class="carousel-control-prev" href="#productSlide" role="button"
						data-slide="prev"> <span class="carousel-control-prev-icon"
						aria-hidden="true"></span> <span class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#productSlide"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
						
					</div>
					
				</div>
				
				<div class="row ml-2">
				<h2 style="color: #9ca0a2">Danh mục sản phẩm</h2>
				</div>

				<div class="row ml-2">

					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					<div class="col-md-2 mt-2">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 2">
							<div class="card-body">
								<h5 class="card-title">Túi xách</h5>
							</div>
						</div>
					</div>
					
					
				</div>




			</div>
			<div class="col-md-6">

				<div class="container">
					<div class="row">
						<div class="col-md-12">
						   <img
								src="https://cmsv2.yame.vn/uploads/5f601839-70b0-49fb-b0b2-da495ccee387/3_Lookbook_Nostyle_(1x1.5)_04..jpg?quality=80&w=0&h=0"
								class="d-block mx-auto" alt="Sản phẩm 1"
								style="max-width: 100%; height: auto;">
					</div>
						</div>
						
				</div>

			</div>
		</div>
	</div>
	<!-- Phần gợi ý sản phẩm -->
<section class="container my-5">
    <h2 style="color: #9ca0a2">Gợi ý hôm nay  </h2>
    <div class="row">
        <div class="col-md-2">
            <div class="card "  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1585488763177-bde7d15fd3cf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 1"  >
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 1</h5>
                    <p class="card-text">$100</p>
                    
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 2">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 2</h5>
                    <p class="card-text">$120</p>
                    
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1553062407-98eeb64c6a62?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 3">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 3</h5>
                    <p class="card-text">$90</p>
                    
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 4">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 4</h5>
                    <p class="card-text">$80</p>
                    
                </div>
            </div>
        </div>
         <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1622445275463-afa2ab738c34?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 4">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 5</h5>
                    <p class="card-text">$80</p>
                    
                </div>
            </div>
        </div>
         <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1619208382871-96f4d45bc840?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 4">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 6</h5>
                    <p class="card-text">$80</p>
                    
                </div>
            </div>
        </div>
    </div>
       <div class="row mt-2">
        <div class="col-md-6 mx-auto text-center">
            <a href="#" class="btn btn-outline-secondary custom-padding" style="width: 60%;"><strong>--Xem thêm--</strong></a>
        </div>
    </div>
</section>

<!-- Bán chạy -->
<section class="container my-5">
    <h2 style="color: #9ca0a2">Sản phẩm bán chạy</h2>
    <div class="row">
        <div class="col-md-2">
            <div class="card "  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1585488763177-bde7d15fd3cf?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 1"  >
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 1</h5>
                    <p class="card-text">$100</p>
                    
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1624687943971-e86af76d57de?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 2">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 2</h5>
                    <p class="card-text">$120</p>
                    
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1553062407-98eeb64c6a62?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 3">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 3</h5>
                    <p class="card-text">$90</p>
                    
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 4">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 4</h5>
                    <p class="card-text">$80</p>
                    
                </div>
            </div>
        </div>
         <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1622445275463-afa2ab738c34?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 4">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 5</h5>
                    <p class="card-text">$80</p>
                    
                </div>
            </div>
        </div>
         <div class="col-md-2">
            <div class="card"  style="max-width: 100%;">
                <img src="https://images.unsplash.com/photo-1619208382871-96f4d45bc840?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80" 
                class="card-img-top" alt="Sản phẩm 4">
                <div class="card-body">
                    <h5 class="card-title">Sản phẩm 6</h5>
                    <p class="card-text">$80</p>
                    
                </div>
            </div>
        </div>
    </div>
       <div class="row mt-2">
        <div class="col-md-6 mx-auto text-center">
            <a href="#" class="btn btn-outline-secondary custom-padding" style="width: 60%;"><strong>--Xem thêm--</strong></a>
        </div>
    </div>
</section>

<!-- Bán đang được ưu đãi -->
<section class="container my-5">
    <h2 style="color: #9ca0a2">Sản phẩm giảm mạnh</h2>
    <div class="row">
        <div class="col-md-6">
            <div class="container">
					<div class="row">
						<img
								src="https://cmsv2.yame.vn/uploads/12378f1a-4211-4ea8-be56-81caf817e885/thumb-1053x1260.jpg?quality=80&w=700&h=0"
								class="d-block mx-auto" alt="Sản phẩm 1"
								style="max-width: 100%; height: auto;">
					</div>
				</div>
				
				
        </div>
			<div class="col-md-6" >

				<div class="row">
					<div class="col-md-12 text-center">
						<!-- Sử dụng class "text-center" để căn giữa theo chiều ngang -->
						<div class="display-1 font-weight-bold text-white">Ưu Đãi
							lớn</div>
						<!-- Sử dụng class "font-weight-bold" để làm nổi bật và "text-primary" để đổi màu văn bản -->
					</div>
				</div>

				<div class="row  mt-auto">

					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 4</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 4</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 4</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 4</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 4</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1613482184972-f9c1022d0928?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 4</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1622445275463-afa2ab738c34?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 5</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
					<div class="col-md-3 mt-4">
						<div class="card" style="max-width: 100%;">
							<img
								src="https://images.unsplash.com/photo-1619208382871-96f4d45bc840?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1887&q=80"
								class="card-img-top" alt="Sản phẩm 4">
							<div class="card-body">
								<h5 class="card-title">Sản phẩm 6</h5>
								<p class="card-text">$80</p>

							</div>
						</div>
					</div>
				</div>
				
				<div class="row mt-2">
        <div class="col-md-6 mx-auto text-center">
            <a href="#" class="btn btn-outline-secondary custom-padding" style="width: 60%;"><strong>--Xem thêm--</strong></a>
        </div>
			</div>
		</div>
       
         
       
    </div>
    
    
</section>

	<!-- trang trí web -->
	<section class="container my-5">

		<div class="row">

			<div class="col-md-7 ">

				<div class="row ">
					<div class="col-md-12 text-center">
						<!-- Sử dụng class "text-center" để căn giữa theo chiều ngang -->
						<div class="display-1 font-weight-bold text-white" style="margin-top: 35%">SPEED
							COLLECTION</div>
						<div class="text-white  text-left">
							<h2>Những kiểu dáng ấn tượng, những phối màu phá cách tạo
								nên một phong cách thời trang đậm chất TAY ĐUA hiện đại~</h2>
						</div>
						<!-- Sử dụng class "font-weight-bold" để làm nổi bật và "text-primary" để đổi màu văn bản -->
					</div>
				</div>

				<div class="row "></div>


				<div class="row mt-2">
					<div class="col-md-6 mx-auto text-center">
						<a href="#" class="btn btn-outline-secondary custom-padding"
							style="width: 60%;"><strong>-- MUA NGAY BÂY GIỜ --</strong></a>
					</div>
				</div>


			</div>

			<div class="col-md-5">
				<div class="container">
					<div class="row">
						<img
							src="https://cmsv2.yame.vn/uploads/4ed6687c-7a11-4781-bdc2-d40e0d87980b/speed-1053x1260-3.jpg?quality=80&w=0&h=0"
							class="d-block mx-auto" alt="Sản phẩm 1"
							style="max-width: 100%; height: auto;">
					</div>
				</div>


			</div>

		</div>


	</section>



	<!-- trang trí web 2 -->
	<section class="container my-5">

		<div class="row">
		
		<div class="col-md-6">
				<div class="container">
					<div class="row">
						<img
							src="https://cmsv2.yame.vn/uploads/41b364dc-84f8-4aac-8ffb-a2ce0f407dfc/THUMB1.jpg?quality=80&w=0&h=0"
							class="d-block mx-auto" alt="Sản phẩm 1"
							style="max-width: 100%; height: auto;">
					</div>
				</div>


			</div>

			<div class="col-md-6 " >

				<div class="row ">
					<div class="col-md-12 text-center" style="margin-top: 45%">
						<!-- Sử dụng class "text-center" để căn giữa theo chiều ngang -->
						<div class="display-1 font-weight-bold text-white">THE DAY'S EYE</div>
						<div class="text-white  text-left">
							<h2>Bắt nguồn từ "Saxon day's eye" có nghĩa là “con mắt ban ngày”. Có lẽ vì hoa nở cùng với ánh sáng ban mai rồi 
							khép lại những cánh trắng khi chiều xuống: chính là Daisy</h2>
						</div>
						<!-- Sử dụng class "font-weight-bold" để làm nổi bật và "text-primary" để đổi màu văn bản -->
					</div>
				</div>

				<div class="row "></div>


				<div class="row mt-2">
					<div class="col-md-6 mx-auto text-center">
						<a href="#" class="btn btn-outline-secondary custom-padding"
							style="width: 60%;"><strong>-- MUA NGAY BÂY GIỜ --</strong></a>
					</div>
				</div>


			</div>

			

		</div>


	</section>



	<!-- trang trí web 3 -->
	<section class="container my-5">

		<div class="row">

			<div class="col-md-5 ">

				<div class="row ">
					<div class="col-md-12 text-center">
						<!-- Sử dụng class "text-center" để căn giữa theo chiều ngang -->
						<div class="display-1 font-weight-bold text-white" style="margin-top: 45%">
							JAPANESE HORROR STORIES</div>
						<div class="text-white  text-left">
							<h2>Đã lến lúc nghe về "Những câu chuyện kinh dị Nhật Bản" về bộ ba Quỷ Thần đầy lôi 
							cuốn trong truyền thuyết. Hồ ly Kisune, Tengu hay Oni sẽ thao túng tâm lý bạn?~</h2>
						</div>
						<!-- Sử dụng class "font-weight-bold" để làm nổi bật và "text-primary" để đổi màu văn bản -->
					</div>
				</div>

				<div class="row "></div>


				<div class="row mt-2">
					<div class="col-md-6 mx-auto text-center">
						<a href="#" class="btn btn-outline-secondary custom-padding"
							style="width: 70%;"><strong>-- MUA NGAY BÂY GIỜ --</strong></a>
					</div>
				</div>


			</div>

			<div class="col-md-7">
				<div class="container">
					<div class="row">
						<img
							src="https://cmsv2.yame.vn/uploads/d4c8d1a0-dcdc-408b-b853-48411d5f291a/thumb_jbs.jpg?quality=80&w=0&h=0"
							class="d-block mx-auto" alt="Sản phẩm 1"
							style="max-width: 100%; height: auto;">
					</div>
				</div>


			</div>

		</div>


	</section>




	


	


	<!-- Bootstrap JS và jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
	