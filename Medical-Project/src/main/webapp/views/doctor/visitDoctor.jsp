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
    <title>Visits Doctor</title>
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

            <form:form method="post" action="saveVisitDoctor" modelAttribute="visit" >

            <div class="contact-info">
                <img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
                <h2>Save your visit</h2>
                <h4>Edit your visit patient and begin with us !</h4>
            </div>
        </div>
        <div class="col-md-9">
            <div class="contact-form">

                <div class="form-group">
                    <label class="control-label col-sm-2" ><s:message code="card.date"/></label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" placeholder="Enter date visit" name="date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" ><s:message code="card.hour"/></label>
                    <div class="col-sm-10">
                        <input type="time" class="form-control"  placeholder="Enter hour" name="hour">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" ><s:message code="card.describe"/></label>
                    <div class="col-sm-10">
                        <textarea rows="4" cols="50" name="describe" class="form-control"  placeholder="Enter describe">
                        </textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2" ><s:message code="card.costVisit"/></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Enter cost visit" name="costVisit">
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
