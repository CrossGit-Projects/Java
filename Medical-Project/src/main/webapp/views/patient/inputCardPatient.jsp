<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Input card patient</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="/resources/css/util.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
    <!--===============================================================================================-->

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/resources/css/css2.css">


</head>
<body>

<%@include file="/resources/incl/menu.app" %>


<div class="container contact">
    <div class="row">
        <div class="col-md-3">

            <form:form method="post" action="addCardPatient" modelAttribute="cardPatient" >

                    <div class="contact-info">
                        <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                        <h2>Card Patient</h2>
                        <h4>Edit your card patient and begin with us !</h4>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="contact-form">

                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.city"/></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Enter city" name="city">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.postCode"/></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  placeholder="Enter post code" name="postCode">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.dateOfBirth"/></label>
                            <div class="col-sm-10">
                                <input type="date" class="form-control"  placeholder="Enter date of birth:" name="dateOfBirth">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.street"/></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" placeholder="Enter street:" name="street">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.localNumber"/></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  placeholder="Enter local number:" name="localNumber">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.gender"/></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  placeholder="Enter gender:" name="gender">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2" ><s:message code="card.age"/></label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  placeholder="Enter age:" name="age">
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Submit</button>
                            </div>
                        </div>
                    </div>
             </form:form>
        </div>
    </div>
</div>



<!--===============================================================================================-->
<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/bootstrap/js/popper.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/se   lect2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/daterangepicker/moment.min.js"></script>
<script src="/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/resources/js/main.js"></script>
<script src="/resources/js/inputCardPatient.js"></script>
</body>
</html>
