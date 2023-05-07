<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>login</title>
</head>
<body>
  <h1>Spring MVC Security - Login with Google</h1>
  <h2>${message}</h2>
  
  <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/spring-mvc-project/login-google&response_type=code
    &client_id=195851300604-32sho9b3g2se5j27vi13mur8sclho8du.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>  
  <form name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
    <table>
      <tr>
        <td>User:</td>
        <td><input type='text' name='username'></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type='password' name='password' /></td>
      </tr>
      <tr>
        <td colspan='2'><input name="submit" type="submit" value="login" /></td>
      </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</body>
</html>