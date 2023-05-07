<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach items="${pros}" var="pro">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top" width="200" height="300"
								src="<c:url value="/template/image/${pro.productDetails.get(0).image.imgName}"/>"
								alt="${pro.productDetails.get(0).image.imgName}" />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${pro.name }</h5>
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
									<c:if test="${pro.sale_price > 0 }">
									<span class="text-muted text-decoration-line-through">
									<span>Giá: </span>	
										<fmt:formatNumber value="${pro.price}" type="currency"/>
									</span>
									<br>
									<span>Giá-KM: </span>	
										<fmt:formatNumber value="${pro.sale_price}" type="currency"/>
									</c:if>
									<c:if test="${pro.sale_price <= 0 }">
										<span>Giá: </span>	
										<fmt:formatNumber value="${pro.price}" type="currency"/>
									</c:if>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto"
										href="<%=request.getContextPath()%>/chi-tiet-san-pham/${pro.proId}">View
										options</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

</body>
</html>