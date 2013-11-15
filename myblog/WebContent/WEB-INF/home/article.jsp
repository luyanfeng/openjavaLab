<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
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
        <div class="content_item ">
          <h2 >最近的文章</h2>
          <c:forEach items="${requestScope.results }" var="article" varStatus="vs">
            <div class="content_container ">       
			  <h3>" <c:out value="${article.title }" /> "</h3>
			  <div style="color:#999;text-indent:2em ; font-size :100% ;border-bottom : 1px dotted #666; padding-bottom: 25px;" >
			  <c:choose>
			   <c:when test="${fn:length(article.content) lt 100 }">article.content</c:when>
			  <c:otherwise>${fn:substring(article.content, 0 , 100) }...</c:otherwise>
			  </c:choose>
			  <div><a href="${applicationScope.path}/home/article/detail.jap?id=${article.id}" target="_blank" style="clear:both;font-weight:normal; float: right;clear: both;color:#ECEFF4;font-size: 0.9em;">&gt;&gt;&gt;阅读</a></div>
			  </div>
            </div>
          </c:forEach>
	    </div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content--> 

	</div>
	
	<%@ include file="/WEB-INF/home/comm/foot.jspf" %>
  
</body>
</html>
