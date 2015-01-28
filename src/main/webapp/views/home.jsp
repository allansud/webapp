<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href='<c:url value="/recursos/style.css" />' />
        <script type="text/javascript" src="<c:url value="/recursos/js/jquery-2.1.1.min.js" />"> </script>
         <script type="text/javascript" src="<c:url value="/recursos/js/jquery-ui.js"/>"> </script>
        <title>Home</title>
        <script type="text/javascript">
        $(function() {
            $( "#formlogin" ).dialog({
              autoOpen: false,
              show: {
                effect: "slideDown",
                duration: 500
              },
              hide: {
                effect: "explode",
                duration: 500
              }
            });
          
            $( "#login" ).click(function() {
              $( "#dialog" ).dialog( "open" );
            });
          });	
        </script>
    </head>
<body>
<div id="main_container">
  <div id="header">
    <div id="logo"><a href="#"><img src="<c:url value="/recursos/images/logo.gif" />" alt="" border="0" /></a>
    <sec:authorize access="isAnonymous()">
    	<form id="formlogin" style="margin-top: 1.0em;" action="<c:url value="/j_spring_security_check"/>" method="post">
			<div>
				<input type="text" name="j_username" placeholder="Usuário" class="three columns right"/>
				<input type="password" name="j_password" placeholder="Senha" class="three columns right"/>
				<input type="submit" value="Entrar" class="tiny button success" class="three columns right"/>&nbsp;
				<a href="<c:url value='registro'/>" class="tiny button success">Registre-se</a>
			</div>
		</form>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		Bem vindo(a) <sec:authentication property="principal"/> - <a href="<c:url value="/j_spring_security_logout"/>">Sair</a>
	</sec:authorize>
    </div>
    <div id="menu">
      <ul>
        <li><a class="current" href="#">home</a></li>
        <li><a id="login" href="services.html">login</a></li>
        <li><a href="#">clients</a></li>
        <li><a href="#">testimonials</a></li>
        <li><a href="contact.html">contact us</a></li>
      </ul>
    </div>
  </div>
  <div class="green_box">
    <div class="clock"> <img src="<c:url value="/recursos/images/clock.png" />" alt="" /> </div>
    <div class="text_content">
      <h1>What is your biological clock?</h1>
      <p class="green"> "Lorem ipsum dolor sit amet int occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." </p>
      <div class="read_more"><a href="#">read more</a></div>
    </div>
    <div id="right_nav">
      <ul>
        <li><a href="#">Lorem ipsum dolor sit amet cons</a></li>
        <li><a href="services.html">Lorem ipsum dolor sit amet cons</a></li>
        <li><a class="current" href="#">Lorem ipsum dolor sit amet cons</a></li>
        <li><a href="#">Lorem ipsum dolor sit amet cons</a></li>
        <li><a href="contact.html">Lorem ipsum dolor sit amet cons</a></li>
      </ul>
    </div>
  </div>
  <!--end of green box-->
  <div id="main_content">
    <div id="left_content">
      <h2>Welcome to greefies</h2>
      <p> "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
      <div id="left_nav">
        <ul>
          <li><a href="#">Lorem ipsum dolor sit amet</a></li>
          <li><a href="services.html">Lorem ipsum dolor sit amet</a></li>
          <li><a href="#">Lorem ipsum dolor sit amet</a></li>
          <li><a href="#">Lorem ipsum dolor sit amet</a></li>
        </ul>
      </div>
      <p class="clear"> <img src="<c:url value="/recursos/images/pic1.jpg" />" alt="" class="left_img" /> "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
      <div class="read_more_link"><a href="#">read more</a></div>
    </div>
    <!--end of left content-->
    <div id="right_content">
      <h2>Our Products</h2>
      <div class="products_box"> <img src="<c:url value="/recursos/images/box_icon.gif"/>" alt="" class="box_img" />
        <h3>Dolore magna aliqua</h3>
        <p> "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
        <div class="read_more_link"><a href="#">read more</a></div>
      </div>
      <div class="products_box"> <img src="<c:url value="/recursos/images/box_icon.gif"/>" alt="" class="box_img" />
        <h3>Dolore magna aliqua</h3>
        <p> "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. </p>
        <div class="read_more_link"><a href="#">read more</a></div>
      </div>
      <div class="search_box">
        <div class="search_title">Dolore magna aliqua</div>
        <input type="text" class="search_input" />
        <input type="image" src="images/search.gif" class="submit" />
        <div class="subsearch"> "Lorem ipsum dolor sit amet. </div>
      </div>
      <div class="contact_information">
        <h4>Free Customers Support</h4>
        <p> <img src="<c:url value="/recursos/images/phone_icon.gif"/>" alt="" class="box_img" /> 0700 679 122 489<br />
          0700 679 122 489 </p>
        <br />
        <br />
        <p> <img src="<c:url value="/recursos/images/contact_icon.gif"/>" alt="" class="box_img" /> info@company.com<br />
          contact@company.com </p>
      </div>
    </div>
    <!--end of right content-->
    <div style=" clear:both;"></div>
  </div>
  <!--end of main content-->
  <div id="footer">
    <div class="copyright"> <a href="#"><img src="<c:url value="/recursos/images/footer_logo.gif"/>" border="0" alt="" /></a> </div>
    <div class="footer_links"> <a href="#">About us</a> <a href="privacy.html">Privacy policy</a> <a href="contact.html">Contact us</a> </div>
  </div>
</div>
<!--end of main container-->
</body>
</html>
