<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">Forms /</span> Update Category
			</h4>

			<div class="d-flex">
				<div style="width: 500px;">
					<form:form method="post" action="category-update" class="form-group" modelAttribute="catUpdate">
						<div class="form-group">
							<label for="name">Name:</label>
							<form:input type="hidden" path="catId" name="id" value="${category.catId }"/>
							<form:input type="text" name="name" value="${category.name}" path="name" class="form-control" />
						</div>

						<div class="form-group">
							<label for="status">Status:</label><br>
							<div class="form-check-inline">
								<label class="form-check-label"> <form:radiobutton
										id="active" path="status"
										class="form-check-input" required="true" value="1"/>Hiển thị
								</label>
							</div>
							<div class="form-check-inline">
								<label class="form-check-label"> <form:radiobutton
										id="inactive" path="status"
										class="form-check-input" required="true" value="0" />Tạm ẩn
								</label>
							</div>
						</div>

						<button type="submit" class="btn btn-primary">Update
							Category</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>