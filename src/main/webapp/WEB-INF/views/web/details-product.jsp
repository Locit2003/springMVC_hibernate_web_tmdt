<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="py-5">
		<form:form action="add-to-cart" method="post"
			modelAttribute="productDetailsDTO">
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<form:input type="hidden" path="proId" value="${proDetails.id}"
						readonly="true" />
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="<c:url value="/template/image/${proDetails.image.imgName}"/>"
							alt="..." />
					</div>
					<div class="col-md-6">
						<h2 style="margin-top: -100px; padding-bottom: 80px">${proDetails.product.name }</h2>
						<div class="small mb-1">SKU: BST-498</div>
						<h1 class="display-5 fw-bolder"></h1>
						<div class="fs-5 mb-5">
						<c:if test="${proDetails.product.sale_price <= 0}">
							<span>Giá: </span>	
							<span>
								<fmt:formatNumber value="${proDetails.product.price }" type="currency"/>
							</span>
						</c:if>
						
						<c:if test="${proDetails.product.sale_price > 0}">
							<span class="text-decoration-line-through">
							<span>Giá: </span>	
								<fmt:formatNumber value="${proDetails.product.price }" type="currency"/>
							</span>
							
							<span>Giá-KM: </span>	
							<span>
								<fmt:formatNumber value="${proDetails.product.sale_price }" type="currency"/>
							</span>
						</c:if>
						</div>
						<div class="buttons_added">
							<span style="padding-right: 20px">Số lượng: </span> <input
								class="minus is-form" type="button" value="-">
							<form:input aria-label="quantity" class="input-qty" max="99"
								min="1" path="quantity" type="number" value="1" />
							<input class="plus is-form" type="button" value="+">
						</div>
						<br>
						<div class="d-flex">
							<button class="btn btn-outline-dark flex-shrink-0" type="submit"
								name="action" value="add-to-cart">
								<i class="bi-cart-fill me-1"></i> Add to cart
							</button>
							 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button style="margin-left: 10px;"
								class="btn btn-outline-danger flex-shrink-0" type="submit"
								name="action" value="add-now">
								<i class="bi-cart-fill me-1"></i> Mua ngay
							</button>
							<br>
						</div>
						<div class="d-flex" style="margin-top: 50px">
						<c:forEach items="${proDetails.products_sizes }" var="ps">
							<label class="radio"> <form:radiobutton path="size"
									value="${ps.size.sizeId }" /> <span>${ps.size.sizeName }</span>
							</label>
						</c:forEach>
						</div>
						<div class="d-flex" style="margin-top: 50px">
						<c:forEach items="${proDetails.products_color }" var="pc">
							<label class="radio"> <form:radiobutton path="color"
									value="${pc.color.colorId }" /> <span>${pc.color.colorName }</span>
							</label>
						</c:forEach>
						</div>
						<div class="stars" style="margin-top: 30px"></div>
					</div>
				</div>
			</div>
		</form:form>
	</section>
	<div class="product-description">
		<h4>MÔ TẢ SẢN PHẨM</h4>
		<p>${proDetails.product.description }</p>
	</div>
	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 class="fw-bolder mb-4">Related products</h2>
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Fancy Product</h5>
								<!-- Product price-->
								$40.00 - $80.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">View
									options</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Special Item</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through">$20.00</span>
								$18.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<div class="badge bg-dark text-white position-absolute"
							style="top: 0.5rem; right: 0.5rem">Sale</div>
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Sale Item</h5>
								<!-- Product price-->
								<span class="text-muted text-decoration-line-through">$50.00</span>
								$25.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">Popular Item</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
									<div class="bi-star-fill"></div>
								</div>
								<!-- Product price-->
								$40.00
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div>
			<div style="display: contents;">
				<div class="product-ratings" data-nosnippet="true">
					<div class="product-ratings__header">
						<div class="product-ratings__header_score">ĐÁNH GIÁ SẢN PHẨM</div>
						<form action="">
							<input class="star star-5" id="star-5" type="radio" name="star" />
							<label class="star star-5" for="star-5"></label> <input
								class="star star-4" id="star-4" type="radio" name="star" /> <label
								class="star star-4" for="star-4"></label> <input
								class="star star-3" id="star-3" type="radio" name="star" /> <label
								class="star star-3" for="star-3"></label> <input
								class="star star-2" id="star-2" type="radio" name="star" /> <label
								class="star star-2" for="star-2"></label> <input
								class="star star-1" id="star-1" type="radio" name="star" /> <label
								class="star star-1" for="star-1"></label>
						</form>
					</div>
					<div class="product-rating-overview">
						<div class="product-rating-overview__briefing">
							<div class="product-rating-overview__score-wrapper">
								<span class="product-rating-overview__rating-score">4.7</span><span
									class="product-rating-overview__rating-score-out-of">
									trên 5 </span>
							</div>
						</div>
						<div class="product-rating-overview__filters">
							<div
								class="product-rating-overview__filter product-rating-overview__filter--active product-rating-overview__filter--all">tất
								cả</div>
							<div class="product-rating-overview__filter">5 Sao (19)</div>
							<div class="product-rating-overview__filter">4 Sao (1)</div>
							<div class="product-rating-overview__filter">3 Sao (1)</div>
							<div class="product-rating-overview__filter">2 Sao (0)</div>
							<div class="product-rating-overview__filter">1 Sao (1)</div>
							<div
								class="product-rating-overview__filter product-rating-overview__filter--with-comment">Có
								Bình luận (6)</div>
							<div
								class="product-rating-overview__filter product-rating-overview__filter--with-photo">Có
								hình ảnh / video (3)</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>
</body>
</html>