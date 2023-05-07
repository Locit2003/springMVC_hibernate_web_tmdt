<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="<c:url value="/trang-chu" />">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="auth/login-admin">Login</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">All Products</a></li>
						<li><hr class="dropdown-divider" /></li>
						<li><a class="dropdown-item" href="#!">Popular Items</a></li>
						<li><a class="dropdown-item" href="#!">New Arrivals</a></li>
					</ul></li>
			</ul>
			<form class="d-flex">
				<a class="btn btn-outline-dark"
					href="<c:url value="/user/cart-items" />"> <i
					class="bi-cart-fill me-1"></i> Cart <span
					class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				</a>
			</form>
			<c:if test="${acc.fullName!=null }">
			<ul class="navbar-nav flex-row align-items-center ps-5">
				<li class="nav-item navbar-dropdown dropdown-user dropdown"><a
					class="nav-link dropdown-toggle hide-arrow show"
					href="javascript:void(0);" data-bs-toggle="dropdown"
					aria-expanded="true">
						<div class="avatar avatar-online">
							<img width="50px" height="50px"
								src="<c:url value="/template/admin/assets/img/avatars/1.png" />"
								alt="" class="w-px-40 h-auto rounded-circle">
						</div>
				</a>
					<ul class="dropdown-menu dropdown-menu-end show"
						data-bs-popper="none">
						<li><a class="dropdown-item" href="#">
								<div class="d-flex">
									<div class="flex-shrink-0 me-3">
										<div class="avatar avatar-online">
											<img width="46px" height="47px" style="margin-right:6px" src="<c:url value="/template/admin/assets/img/avatars/1.png" />" alt=""
												class="w-px-40 h-auto rounded-circle">
										</div>
									</div>
									<div class="flex-grow-1">
										<span class="fw-semibold d-block">${acc.fullName }</span> <small
											class="text-muted">User</small>
									</div>
								</div>
						</a></li>
						<li>
							<div class="dropdown-divider"></div>
						</li>
						<li><a class="dropdown-item" href="#"> <i
								class="bx bx-user me-2"></i> <span class="align-middle">My
									Profile</span>
						</a></li>
						<li><a class="dropdown-item" href="#"> <i
								class="bx bx-cog me-2"></i> <span class="align-middle">Settings</span>
						</a></li>
						<li><a class="dropdown-item" href="#"> <span
								class="d-flex align-items-center align-middle"> <i
									class="flex-shrink-0 bx bx-credit-card me-2"></i> <span
									class="flex-grow-1 align-middle">Billing</span> <span
									class="flex-shrink-0 badge badge-center rounded-pill bg-danger w-px-20 h-px-20">4</span>
							</span>
						</a></li>
						<li>
							<div class="dropdown-divider"></div>
						</li>
						<li>

							<form class="dropdown-item" action="<c:url value="/j_spring_security_logout" />"
								method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> 
									<input type="submit" value="logout"/>
							</form>
							
						
						</li>
					</ul></li>
			</ul>
			</c:if>
		</div>
	</div>
</nav>
<!-- Header-->
<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">Shop in style</h1>
			<p class="lead fw-normal text-white-50 mb-0">With this shop
				hompeage template</p>
		</div>
	</div>
</header>
<nav id="mainNavbar" class="navbar navbar-dark bg-dark navbar-expand-md">

	<div class="collapse navbar-collapse" id="navLinks">
		<ul class="navbar-nav m-auto">

			<c:forEach items="${cats}" var="cats">
				<li class="nav-item"><a href="<%=request.getContextPath()%>/danh-muc/${cats.catId}" class="nav-link">${cats.name}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</nav>


