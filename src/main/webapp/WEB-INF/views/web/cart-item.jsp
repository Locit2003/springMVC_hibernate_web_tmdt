<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main class="page-cart">
		<section class="shopping-cart dark">
			<div class="container">
				<div class="block-heading row">
					<div class="col-md-6">
						<h2>Shopping Cart</h2>
						<form id="form-1" class="form-group" style="width: 350px"
							action="add-info-customer" method="post">
							<div class="form-group">
								<label id="label-1">nhập địa chỉ giao hàng:</label> <input
									type="text" name="address" class="form-control">
							</div>
							<div class="form-group">
								<label id="label-1">nhập số điên thoại:</label> <input
									type="text" name="phoneNumber" class="form-control">
							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-info">Thêm</button>
							</div>
						</form>
						<p></p>
					</div>

					<div class="col-md-6">
						<h2>Thông tin giao hàng</h2>
						<span class="text-danger">${error}</span>
						<form id="form-1" class="form-group row" style="width: 350px">
							<div class="col-md-9">
								<div class="form-group">
									<label id="label-1">địa chỉ giao hàng:</label> <input
										type="text" name="address" class="form-control"
										value="${address }" readonly="readonly">
								</div>
								<div class="form-group">
									<label id="label-1">số điên thoại người nhận:</label> <input
										type="text" name="phoneNumber" class="form-control"
										value="${phone }" readonly="readonly">
								</div>
							</div>

							<div class="col-md-3"
								style="display: flex; justify-content: center; align-items: center;">
								<button type="submit" class="btn btn-danger">thay đổi</button>
							</div>
						</form>
						<p></p>
					</div>
				</div>
				<div class="content">
					<div class="row">
						<div class="col-md-12 col-lg-8">
							<div class="items">

								<c:forEach items="${cart_items }" var="item">
									<div class="product"
										style="border-bottom: 3px solid gray; padding: 8px 5px">
										<c:if test="${item.bill.id == null }">

											<div class="row">
												<div class="col-md-3" style="border-right: 3px solid gray;">
													<img class="img-fluid mx-auto d-block image"
														src="<c:url value="/template/image/${item.productDetails.image.imgName }"/>"
														alt="..." />
												</div>
												<div class="col-md-6">
													<div class="info">
														<div class="row">
															<div class="col-md-5 product-name">
																<div class="product-name">
																	<a href="#">${item.productDetails.product.name }</a>
																	<div class="product-info">
																		<div>
																			Color: <span class="value">${item.colorName }</span>
																		</div>
																		<div>
																			Size: <span class="value">${item.sizeName }</span>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-md-4 quantity">
																<label for="quantity">Quantity:</label> <input
																	id="quantity" type="number" value="${item.quantity }"
																	class="form-control quantity-input">
															</div>
															<div class="col-md-3 price">
																<label for="quantity">Giá:</label>
																<c:if test="${item.new_price > 0}">
																	<span> <fmt:formatNumber
																			value="${item.new_price }" type="currency" />
																	</span>
																</c:if>
																<c:if test="${item.new_price <= 0}">
																	<span> <fmt:formatNumber
																			value="${item.productDetails.product.price }"
																			type="currency" />
																	</span>
																</c:if>
															</div>

														</div>
													</div>
												</div>
												<div class="col-md-2 price">
													<label for="quantity">Tổng tiền:</label>
													<c:if test="${item.new_price > 0 }">
														<span> <fmt:formatNumber
																value="${item.new_price * item.quantity }"
																type="currency" />
														</span>
													</c:if>
													<c:if test="${item.new_price <= 0 }">
														<span> <fmt:formatNumber
																value="${item.productDetails.product.price * item.quantity }"
																type="currency" />
														</span>
													</c:if>
												</div>
												<div class="col-md-1 price pt-2">
													<a href="delete/${item.id }" class="btn btn-danger">xóa</a>
												</div>
											</div>
										</c:if>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-md-12 col-lg-4">
							<div class="summary">
								<form action="thanh-toan" method="post">
									<h3>Chi tiết giỏ hàng</h3>
									<span class="text-danger">${notPrice }</span>
									<div class="summary-item">
										<span class="text" style="font-size: 13px; color: orange;">Phương
											thức thanh toán: <b style="color: red; font-size: 11px">Thanh
												toán khi nhận hàng</b>
										</span>
									</div>
									<div class="summary-item">
										<span class="text">Tổng tiền hàng: </span><span class="price">
											<fmt:formatNumber value="${total}" type="currency" /> <input
											type="hidden" name="total" value="${total}">
										</span>
									</div>
									<div class="summary-item">
										<span class="text">Discount: </span><span class="price">0đ</span>
									</div>
									<div class="summary-item">
										<span class="text">Shipping: </span><span class="price">Miễn
											phí</span>
									</div>
									<div class="summary-item">
										<span class="text">Tổng tiền: </span> <span class="price">
											<fmt:formatNumber value="${total}" type="currency" />
										</span>
									</div>
									<button type="submit"
										class="btn-checkout btn btn-primary btn-lg btn-block">Thanh
										Toán</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
</body>
</html>