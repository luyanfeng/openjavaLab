<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach items="${list }" var="item" varStatus="vs">
<div class="sidebar" style="width:100%;color:#fff">
<c:if test="${vs.index eq 0 }"> <h2>分类导航</h2></c:if>
<ul class="sidebar_item" style="list-style-type: none;margin:0px ;	">
	<li style="border-bottom:1px dotted #999;margin-right:10px;padding-bottom:3px;">
 	<a href="${applicationScope.path }/home/article.jap?nav=article&tyid=${item.id}" style="font-style: none;font-weight: normal;"> <c:out value="${item.name }"/></a>
 	<span style="float:right;">(<c:out value="${item.articles.size() }" />)</span>
	</li>
</ul>
</div>  
</c:forEach>