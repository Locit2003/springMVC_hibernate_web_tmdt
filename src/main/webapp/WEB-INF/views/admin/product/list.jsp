<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	.imgPro{
		width: :60px;
		height: 60px;
	}
</style>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content -->

		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="row">
				<div class="col-md-4">
					<h4 class="fw-bold py-3 mb-4">
						<span class="text-muted fw-light">Tables /</span> Contest
					</h4>
				</div>
				<div class="col-md-6">
				</div>
				<div class="col-md-2">
					<a href="<%=request.getContextPath()%>/admin/product-add">
						<button class="btn btn-primary" data-bs-toggle="tooltip"
							data-bs-offset="0,4" data-bs-placement="right"
							data-bs-html="true" title="Add one candidates ">Add</button>
					</a>
				</div>

			</div>


			<div class="card">
				<div class="table-responsive text-nowrap">
					<table class="table ">
						<thead>
							<tr>
								<th>id</th>
								<th>Name</th>
								<th>Image</th>
								<th>price</th>
								<th>sale</th>
								<th>category Name</th>
								<th></th>
							</tr>
						</thead>
						<tbody class="table-border-bottom-0">
							<c:forEach items="${prods }" var="pro">
								<tr>
									<td><i class="fab fa-angular fa-lg text-danger me-3"></i>
										<strong>${pro.id }</strong></td>
									<td>${pro.product.name }</td>
									<td><img class="imgPro" width="70px" height="70px" src="<c:url value="/template/image/${pro.image.imgName}"/>"></td>
									<td>${pro.product.price }</td>
									<td>${pro.product.sale_price }</td>
									<td>${pro.product.category.name }</td>
									<td>
										<div class="dropdown">
											<button type="button"
												class="btn p-0 dropdown-toggle hide-arrow"
												data-bs-toggle="dropdown">
												<i class="bx bx-dots-vertical-rounded"></i>
											</button>
											<div class="dropdown-menu">
												<a class="dropdown-item" href="list-contest-candidates/"><i
													class="menu-icon tf-icons bx bx-detail"></i> Show list
													candidates</a> <a class="dropdown-item"
													href="vote-history-contest/"><i class="bx bx-show"></i>
													Show history vote</a> <a class="dropdown-item" href="edit/${pro.id }"><i
													class="bx bx-edit-alt me-1"></i> Edit Contest</a> <a
													class="dropdown-item"
													onclick="return confirm('You definitely want to delete this entry ?')"
													href="product/delete/${pro.id }"><i class="bx bx-trash me-1"></i> Delete</a>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
	<nav aria-label="Page navigation">
		<ul class="pagination" id="pagination"></ul>
	</nav>
	<script type="text/javascript">
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : 35,
				visiblePages : 10,
				onPageClick : function(event, page) {
					console.info(page + ' (from options)');
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>
</body>
</html>