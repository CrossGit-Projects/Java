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
    <title>Card Doctor</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/resources/css/css1.css">

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
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <!--===============================================================================================-->
</head>
<body>
<%@include file="/resources/incl/menu.app" %>
<div class="container">
    <div class="row">
        <h2>Card Doctor</h2>


        <div class="col-md-7 ">

            <div class="panel panel-default">
                <div class="panel-heading">  <h4 >User Profile</h4></div>
                <div class="panel-body">

                    <div class="box box-info">

                        <div class="box-body">
                            <div class="col-sm-6">
                                <div  align="center">


                                    <div style="color:#999;" >click here to change profile image</div>
                                    <!--Upload Image Js And Css-->

                                </div>

                                <br>

                                <!-- /input-group -->
                            </div>
                            <div class="col-sm-6">
                                <h4 style="color:#00b1b1;">Medical clinic </h4></span>
                                <span><p>Doctor</p></span>
                            </div>
                            <div class="clearfix"></div>
                            <hr style="margin:5px 0 5px 0;">


                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.firstName"/></div><div class="col-sm-7 col-xs-6 "><c:out value="${user.firstName}"/></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.lastName"/></div><div class="col-sm-7"><c:out value="${user.lastName}"/></div>
                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.email"/>:</div><div class="col-sm-7"><c:out value="${user.email}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.telephone"/></div><div class="col-sm-7"><c:out value="${user.telephone}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.pesel"/></div><div class="col-sm-7"><c:out value="${user.pesel.PESEL}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.specialization"/></div><div class="col-sm-7"><c:out value="${card.specialization}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.city"/></div><div class="col-sm-7"><c:out value="${card.city}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.street"/></div><div class="col-sm-7"><c:out value="${card.street}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.localNumber"/></div><div class="col-sm-7"><c:out value="${card.localNumber}"/></div>

                            <div class="clearfix"></div>
                            <div class="bot-border"></div>

                            <div class="col-sm-5 col-xs-6 tital " ><s:message code="card.registrationDate"/></div><div class="col-sm-7"><c:out value="${card.registrationDate}"/></div>

                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->

                    </div>


                </div>
            </div>
        </div>
        <div class="panel-heading">  <h4 >Your visit</h4></div>

        <c:forEach var="u" items="${listVisit }">
            <div class="col-md-4" style="width: 1000px";>
                <div class="alert alert-info">
                    <div class="panel-body">
                        <div class="con_ina">
                            <b> <small><c:out value="${u.date}"/></small></b><br>
                            <c:out value="${u.hour }"/><br>
                            <c:out value="${u.describe }"/><br>
                            <c:out value="${u.costVisit }"/><br>
                            <c:out value="${u.cardDoctor.appUser.firstName }"/><br>
                            <c:out value="${u.cardDoctor.appUser.lastName }"/><br>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>





        <script>
            $(function() {
                $('#profile-image1').on('click', function() {
                    $('#profile-image-upload').click();
                });
            });
        </script>
    </div>
</div>

<a href="/doctor/inputCardDoctor">
    <div class="container-login100-form-btn" >
        <button class="login100-form-btn">
            Edit Profile Details
        </button>
    </div>
</a>


<!--===============================================================================================-->
<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/bootstrap/js/popper.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/daterangepicker/moment.min.js"></script>
<script src="/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/resources/js/main.js"></script>

</body>
</html>
