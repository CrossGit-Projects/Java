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
    <title>Login V8</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="/resources/images/icons/favicon.ico"/>
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

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/resources/cssindex/bootstrap.css">
    <link rel="stylesheet" href="/resources/vendors/linericon/style.css">
    <link rel="stylesheet" href="/resources/cssindex/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/vendors/owl-carousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/resources/vendors/lightbox/simpleLightbox.css">
    <link rel="stylesheet" href="/resources/vendors/nice-select/css/nice-select.css">
    <link rel="stylesheet" href="/resources/vendors/animate-css/animate.css">
    <link rel="stylesheet" href="/resources/vendors/popup/magnific-popup.css">
    <!-- main css -->
    <link rel="stylesheet" href="/resources/cssindex/style.css">
    <link rel="stylesheet" href="/resources/cssindex/responsive.css">
</head>
<body>
<%@include file="/resources/incl/menu.app" %>


<!--================Home Banner Area =================-->
<section class="home_banner_area">
    <div class="banner_inner d-flex align-items-center">
        <div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0" data-background=""></div>
        <div class="container">
            <div class="banner_content text-center">
                <h3>Medical Clinic<br />for a better world</h3>
                <a class="main_btn" href="/register">Zarejestruj się!</a>
                <a class="main_btn" href="/login">Zaloguj się!</a>
            </div>
        </div>
    </div>
</section>
<!--================End Home Banner Area =================-->




<!--================ start footer Area  =================-->
<footer class="footer-area p_120">
    <div class="container">
        <div class="row">
            <div class="col-lg-2  col-md-6 col-sm-6">
                <div class="single-footer-widget tp_widgets">
                    <h6 class="footer_title">Administration</h6>
                </div>
            </div>
            <div class="col-lg-2  col-md-6 col-sm-6">
                <div class="single-footer-widget tp_widgets">
                    <h6 class="footer_title">Doctor</h6>
                </div>
            </div>
            <div class="col-lg-2  col-md-6 col-sm-6">
                <div class="single-footer-widget tp_widgets">
                    <h6 class="footer_title">Patient</h6>
                </div>
            </div>

        </div>
        <div class="row footer-bottom d-flex justify-content-between align-items-center">
            <p class="col-lg-8 col-md-8 footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This website is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Carol.Kawecki</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            <div class="col-lg-4 col-md-4 footer-social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-dribbble"></i></a>
                <a href="#"><i class="fa fa-behance"></i></a>
            </div>
        </div>
    </div>
</footer>
<!--================ End footer Area  =================-->


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
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/popper.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/stellar.js"></script>
<script src="/resources/vendors/lightbox/simpleLightbox.min.js"></script>
<script src="/resources/vendors/nice-select/js/jquery.nice-select.min.js"></script>
<script src="/resources/vendors/isotope/imagesloaded.pkgd.min.js"></script>
<script src="/resources/vendors/isotope/isotope.pkgd.min.js"></script>
<script src="/resources/vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="/resources/vendors/popup/jquery.magnific-popup.min.js"></script>
<script src="/resources/js/jquery.ajaxchimp.min.js"></script>
<script src="/resources/vendors/counter-up/jquery.waypoints.min.js"></script>
<script src="/resources/vendors/counter-up/jquery.counterup.js"></script>
<script src="/resources/js/mail-script.js"></script>
<script src="/resources/js/theme.js"></script>
</body>
</html>
