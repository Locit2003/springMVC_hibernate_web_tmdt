<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="home" /></title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/template/web/css/styles.css" />">
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/template/web/css/cart-item.css" />">
<link rel='stylesheet prefetch'
	href='https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>

<style type="text/css">


.size {
	margin: 0 10px;
	padding: 0 16px;
}

div.stars {
	width: 270px;
	display: inline-block;
}

input.star {
	display: none;
}

label.star {
	float: right;
	padding: 10px;
	font-size: 36px;
	color: #444;
	transition: all .2s;
}

input.star:checked ~ label.star:before {
	content: '\f005';
	color: #FD4;
	transition: all .25s;
}

input.star-5:checked ~ label.star:before {
	color: #FE7;
	text-shadow: 0 0 20px #952;
}

input.star-1:checked ~ label.star:before {
	color: #F62;
}

label.star:hover {
	transform: rotate(-15deg) scale(1.3);
}

label.star:before {
	content: '\f006';
	font-family: FontAwesome;
}

label.star:before {
	content: '\f006';
	font-family: FontAwesome;
}

.product-ratings {
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, .05);
	border-radius: 0.125rem;
	overflow: hidden;
	background: #fff;
	margin-top: 0.9375rem;
	padding: 0 40px;
	overflow: visible;
}

.product-ratings__header {
	display: flex;
	flex-flow: row nowrap;
	align-items: center;
	margin-bottom: 1em;
}

.product-ratings__header_score {
	font-size: 1.125rem;
	color: rgba(0, 0, 0, .87);
	margin-right: 0.2em;
	text-transform: capitalize;
}

.product-rating-overview {
	background-color: #fffbf8;
	min-height: 5rem;
	border: 1px solid #f9ede5;
	margin-bottom: 1rem;
	display: flex;
	align-items: center;
	border-radius: 2px;
	box-sizing: border-box;
	padding: 1.875rem;
}

.product-rating-overview__briefing {
	text-align: center;
	margin-right: 1.875rem;
}

.theme--ofs .product-rating-overview__score-wrapper {
	color: #d0011b;
}

.product-rating-overview__stars {
	font-size: 1.25rem;
	margin-top: 0.625rem;
}

.product-description {
	width: 70%;
	border: 1px solid #ccc; /*Thiết lập đường viền cho hộp*/
	padding: 10px; /*Thiết lập khoảng cách giữa nội dung và đường viền*/
	background-color: #f8f8f8; /*Thiết lập màu nền cho hộp*/
	font-size: 16px; /*Thiết lập kích thước chữ cho nội dung*/
	line-height: 1.4; /*Thiết lập độ cao dòng cho nội dung*/
	margin: 30px auto;
}

.buttons_added {
	opacity: 1;
	display: inline-block;
	display: -ms-inline-flexbox;
	display: inline-flex;
	white-space: nowrap;
	vertical-align: top;
	margin-bottom: 30px
}

.is-form {
	overflow: hidden;
	position: relative;
	background-color: #f9f9f9;
	height: 2.2rem;
	width: 1.9rem;
	padding: 0;
	text-shadow: 1px 1px 1px #fff;
	border: 1px solid #ddd;
}

.is-form:focus, .input-text:focus {
	outline: none;
}

.is-form.minus {
	border-radius: 4px 0 0 4px;
}

.is-form.plus {
	border-radius: 0 4px 4px 0;
}

.input-qty {
	background-color: #fff;
	height: 2.2rem;
	text-align: center;
	font-size: 1rem;
	display: inline-block;
	vertical-align: top;
	margin: 0;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-left: 0;
	border-right: 0;
	padding: 0;
}

.input-qty::-webkit-outer-spin-button, .input-qty::-webkit-inner-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}
label.radio {
	cursor: pointer;
}

label.radio input {
	position: absolute;
	top: 0;
	left: 0;
	visibility: hidden;
	pointer-events: none;
}

label.radio span {
	padding: 1px 12px;
	border: 2px solid #ada9a9;
	display: inline-block;
	color: #8f37aa;
	border-radius: 3px;
	text-transform: uppercase;
	font-size: 11px;
	font-weight: 300;
}

label.radio input:checked+span {
	border-color: #fff;
	background-color: blue;
	color: #fff;
}


</style>
</head>
<body>

	<!--header-->
	<%@ include file="/common/web/header.jsp"%>
	<!--header-->

	<!-- main -->
	<dec:body />
	<!-- main -->

	<!--footer-->
	<%@ include file="/common/web/footer.jsp"%>
	<!--footer-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value="template/js/scripts.js" />"></script>
	<script type="text/javascript">
	$('input.input-qty').each(function() {
		  var $this = $(this),
		    qty = $this.parent().find('.is-form'),
		    min = Number($this.attr('min')),
		    max = Number($this.attr('max'))
		  if (min == 0) {
		    var d = 0
		  } else d = min
		  $(qty).on('click', function() {
		    if ($(this).hasClass('minus')) {
		      if (d > min) d += -1
		    } else if ($(this).hasClass('plus')) {
		      var x = Number($this.val()) + 1
		      if (x <= max) d += 1
		    }
		    $this.attr('value', d).val(d)
		  })
		})
	</script>
</body>
</html>