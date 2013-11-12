<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${applicationScope.path }/"/>
  <title>文章栏目 -- ${website}</title>
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
        <div class="content_item" style="width:100%;">
          <h2 style="text-align:center">${result.title }</h2>
            <div class="content_container" style="width:100%">       
            <h6 style="text-align:center">作者：${result.author } 时间：${result.time }</h6>
            <div style="color: #fff">${result.content }</div>
		 	</div>
	    </div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content--> 

	</div>
	
	<%@ include file="/WEB-INF/home/comm/foot.jspf" %>
  
</body>
</html>
