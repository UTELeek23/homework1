<%--
  Created by IntelliJ IDEA.
  User: khoak
  Date: 9/17/2024
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!--===============================================================================================-->
  <link rel="icon" type="image/png" href="../images/icons/favicon.ico"/>
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/bootstrap/css/bootstrap.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/animate/animate.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/css-hamburgers/hamburgers.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/vendor/select2/select2.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/util.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
  <!--===============================================================================================-->
</head>
<body>
<c:if test="${alert != null}">
  <h3 class="alert alert-danger">${alert}</h3>
</c:if>
<c:if test="${notice != null}">
  <h3 class="alert-success">${notice}</h3>
</c:if>
<div class="limiter">
  <div class="container-login100">
    <div class="wrap-login100">
      <div class="login100-pic js-tilt" data-tilt>
        <img src="${pageContext.request.contextPath}/static/images/img-01.png" alt="IMG">
      </div>

      <form class="login100-form validate-form" action="forget" method="post">
					<span class="login100-form-title">
						forget password
					</span>
        <div class="wrap-input100 validate-input" data-validate = "Valid username is required">
          <input class="input100" type="text" name="username" placeholder="Username">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
        </div>
        <div class="wrap-input100 validate-input" data-validate = "Question is required">
          <label>Choose a question:</label>
          <select name="quest" id="quest">
            <c:forEach var="question" items="${questions}">
              <option value="${question.ID}">${question.content}</option>
            </c:forEach>
          </select>
        </div>
        <div class="wrap-input100 validate-input" data-validate = "Valid Answer is required">
          <input class="input100" type="text" name="answer" placeholder="Answer">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
        </div>
        <div class="container-login100-form-btn">
          <button class="login100-form-btn">
            Submit
          </button>
        </div>
        <div class="text-center p-t-136">
          <a class="txt2" href="/homework1_war_exploded/Login">
            Already have account ?
            <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
          </a>
        </div>
      </form>
    </div>
  </div>
</div>




<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/static/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/vendor/tilt/tilt.jquery.min.js"></script>
<script >
  $('.js-tilt').tilt({
    scale: 1.1
  })
</script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/js/main.js"></script>

</body>
</html>
