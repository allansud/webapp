<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href='<c:url value="/recursos/style.css" />' />
        <title>Home</title>
    </head>
<body>
<div id="main_container">
  <div id="header">
    <div id="logo"><a href="#"><img src="<c:url value="/recursos/images/logo.gif" />" alt="" border="0" /></a>
    </div>
    <div id="menu">
      <ul>
        <li><a class="current" href="#">home</a></li>
        <li><a href="services.html">services</a></li>
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
      <h2>Informações para contato</h2>
      <div class="contact_info_box">
        <div class="contact_info_title">Dolore magna aliqua</div>
        <div class="contact_info"> <img src="<c:url value="recursos/images/phone_icon.gif"/>" alt="" class="box_img" /> 0700 679 122 489<br />
          0700 679 122 489 </div>
        <div class="contact_info"> <img src="<c:url value="recursos/images/contact_icon.gif"/>" alt="" class="box_img" /> info@company.com<br />
          contact@company.com </div>
        <div class="adress"> Alfred Street , New Caledonia 2005 , CP 14-7089 </div>
      </div>
      <h2>Cadastro</h2>
      <div id="contact_form">
      <sf:form modelAttribute="usuario" action="executarRegistro">
        <div class="form_row">
          <label>Name:<sf:errors path="nome" cssClass="erro"/></label>
          <sf:input type="text" path="nome" class="contact_input" />
        </div>
        <div class="form_row">
          <label>Email:<sf:errors path="email" cssClass="erro"/></label>
          <sf:input type="text" path="email" class="contact_input" />
        </div>
        <div class="form_row">
          <label>Nome do Usuário:<sf:errors path="login" cssClass="erro"/></label>
          <sf:input type="text" path="login" class="contact_input" />
        </div>
        <div class="form_row">
          <label>senha:<sf:errors path="senha" cssClass="erro"/></label>
          <sf:password path="senha" class="contact_input"/>
        </div>
        <div class="send"><input type="submit" value="Faça parte!" class="tiny button success"/></div>
        </sf:form>
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