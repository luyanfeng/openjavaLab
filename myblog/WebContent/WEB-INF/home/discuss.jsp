<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>博客热点讨论 -- ${website}</title>
  <meta name="keywords" content="luyanfeng芦艳峰的博客" />
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/comm/css/style.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath }/comm/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/comm/js/image_slide.js"></script>
</head>

<body>
  <div id="main">
	<%@ include file="/WEB-INF/home/comm/nav.jspf" %>	
	
	<div id="site_content">	
		<%@ include file="/WEB-INF/home/comm/left.jspf" %>
	
	  <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="680" height="250" src="${pageContext.request.contextPath }/comm/images/home_1.jpg" alt="&quot;Enter your caption here&quot;" /></li>
          <li><img width="680" height="250" src="${pageContext.request.contextPath }/comm/images/home_2.jpg" alt="&quot;Enter your caption here&quot;" /></li>
        </ul>
      </div>	 	   
	   
      <div id="content">
        <div class="content_item">
		  <div class="form_settings">
            <h2>Contact Us</h2>
            <p>A contact form requires some method of emailing the contents of the form to an email address. The most common way to do this is to use some kind of server script (PHP for example). I would be happy to send you the PHP code for the contact form for your chosen template, I charge £20.00GBP for this. Simply <a href="http://www.araynordesign.co.uk/contact.php">contact me</a> for more details.</p>
			<p>&nbsp;</p>
			<p><span>Name</span><input class="contact" type="text" name="your_name" value="" /></p>
			<p><span>Email Address</span><input class="contact" type="text" name="your_email" value="" /></p>
			<p><span>Message</span><textarea class="contact textarea" rows="8" cols="50" name="your_message"></textarea></p>
            <p style="padding: 10px 0 10px 0;">Please enter the answer to this simple maths question (to prevent spam)</p>
			<p><span>Maths Question: 9 + 3 = ?</span><input type="text" name="user_answer" class="contact" /><input type="hidden" name="answer" value="4d76fe9775" /></p>
            <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="Send" /></p>
          </div><!--close form_settings-->
		</div><!--close content_item-->
      </div><!--close content-->  
    </div><!--close site_content-->  

	</div>
	<%@ include file="/WEB-INF/home/comm/foot.jspf" %>  
</body>
</html>
