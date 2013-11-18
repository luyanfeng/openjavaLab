<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach items="${list }" var="item" varStatus="vs">
<div class="sidebar">
<div class="sidebar_item">
<c:if test="${vs.index eq 0 }"> <h2>最近更新</h2></c:if>
<span style="float:right;font-size:0.9em;color:#fff;letter-spacing: 0px;"><fmt:formatDate value="${item.time }" pattern="yyyy/MM/dd"/></span>
<a style="font-style: none;font-weight: normal;" href="${applicationScope.path}/home/article/detail.jap?id=${item.id}" target="_blank" >
 <c:choose>
 <c:when test="${fn:length(item.title) gt 10 }"> <c:out value="${fn:substring(item.title, 0,10)  }..."/></c:when>
 <c:otherwise> <c:out value="${item.title }"/></c:otherwise>
 </c:choose>
</a>
 </div></div>  
</c:forEach>