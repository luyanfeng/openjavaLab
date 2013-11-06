<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${applicationScope.path }/"/>
  <title>博客首页 -- ${website}</title>
  <meta name="keywords" content="luyanfeng芦艳峰的博客" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="${applicationScope.path }/comm/css/style.css" />
  <script type="text/javascript" src="${applicationScope.path }/comm/js/jquery-1.10.2.js"></script>
  <script type="text/javascript" src="${applicationScope.path }/comm/js/image_slide.js"></script>
</head>

<body>
  <div id="main">
	<%@ include file="/WEB-INF/home/comm/nav.jspf" %>	
    
	<div id="site_content">		
		<%@ include file="/WEB-INF/home/comm/left.jspf" %>
	
	  <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="680" height="250" src="${applicationScope.path }/comm/images/home_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
          <li><img width="680" height="250" src="${applicationScope.path }/comm/images/home_2.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        </ul>
      </div>	  	 
	 
	  <div id="content">
        <div class="content_item">
		  <h1>Welcome To Your Website</h1> 
	      <p>This standards compliant, simple, fixed width website template is released as an &lsquo;open source&rsquo; design (under the Creative Commons Attribution 3.0 Licence), which means that you are free to download and use it for anything you want (including modifying and amending it). If you wish to remove the &lsquo;ARaynorDesign&rsquo; link in the footer of the template, all I ask is for a donation of &pound;20.00 GBP.</p>	  
		  
		  <div class="content_image">
		    <img src="${applicationScope.path }/comm/images/content_image1.jpg" alt="image1"/>
	      </div>
		  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.</p>
		  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim.</p>
		  <br style="clear:both"/>
		  
		  <div class="content_container">
		    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.</p>
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->
		  </div><!--close content_container-->
          <div class="content_container">
		    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.</p>          
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->		  
		  </div><!--close content_container-->			  
		</div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content--> 
    
	</div>
	
	<%@ include file="/WEB-INF/home/comm/foot.jspf" %>  
</body>
</html>
