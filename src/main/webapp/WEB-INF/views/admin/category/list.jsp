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
	<div class="content-wrapper">
		<!-- Content -->

		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="row">
				<div class="col-md-4">
					<h4 class="fw-bold py-3 mb-4">
						<span class="text-muted fw-light">Tables /</span> Danh Mục
					</h4>
				</div>
				<div class="col-md-6">
				</div>
				<div class="col-md-2">
					<a href="<%=request.getContextPath()%>/admin/admin-category-add">
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
								<th>Status</th>
							</tr>
						</thead>
						<tbody class="table-border-bottom-0">
							<c:forEach items="${cats }" var="cat">
								<tr>
									<td><i class="fab fa-angular fa-lg text-danger me-3"></i>
										<strong>${cat.catId }</strong></td>
									<td>${cat.name }</td> 
									<td>${cat.status == true ? "còn hàng" : "hết hàng" }</td>
									<td>
										<div class="dropdown">
											<button type="button"
												class="btn p-0 dropdown-toggle hide-arrow"
												data-bs-toggle="dropdown">
												<i class="bx bx-dots-vertical-rounded"></i>
											</button>
											<div class="dropdown-menu">
												<a class="dropdown-item" href="danh-muc/${cat.catId }"><i
													class="menu-icon tf-icons bx bx-detail"></i> Show list
													products</a> <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/category-edit/${cat.catId}"><i
													class="bx bx-edit-alt me-1"></i> Edit category</a> 
													<a class="dropdown-item" href="<%=request.getContextPath()%>/admin/category-delete/${cat.catId}"><i class="bx bx-trash me-1"></i> Delete
													category</a>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<nav aria-label="Page navigation">
				<ul class="pagination" id="pagination"></ul>
			</nav>
		</div>
	</div>
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