<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.ckeditor.com/ckeditor5/37.0.1/classic/ckeditor.js"></script>
<script type="text/javascript"
	src="<c:url value='https://cdn.ckeditor.com/4.7.0/standard/ckeditor.js'/>"></script>
</head>
<body>
	<div class="content-wrapper">
		<!-- Content -->

		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">Forms /</span> Create Product
				<span style="color: red;">${message}</span>
			</h4>

			<div class="d-flex">
				<div style="width: 500px;">
					<form:form method="post" action="insert-product"
						modelAttribute="insertProductDTO" class="form-group" enctype="multipart/form-data">
						<div class="form-group">
							<label for="name">Name:</label>
							<form:input type="text" id="name" path="proName"
								class="form-control" />
						</div>

						<div class="form-group">
							<label for="name">image:</label>
							<form:input type="file" id="imageFile" path="fileUpload"
								class="form-control" />
						</div>

						<div class="form-group">
							<label for="name">Price:</label>
							<form:input type="text" path="price"
								class="form-control" />
						</div>

						<div class="form-group">
							<label for="name">sale price</label>
							<form:input type="text" path="sale_price"
								class="form-control" />
						</div>

						<div class="form-group">
							<label for="name">Category name</label>
							<form:select path="category_id">
								<form:option value="0"> --SELECT--</form:option>
								<c:forEach items="${categories }" var="c">
									<form:option value="${c.catId}">${c.name }</form:option>
								</c:forEach>	
							</form:select>
						</div>

						<div class="form-group" id="">
							<label for="name">Description</label>
							<form:textarea type="text" id="" path="description" cols="80" rows="10"
								class="form-control" />
						</div>

						<button type="submit" class="btn btn-primary">Add Product</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>