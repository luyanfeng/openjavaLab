<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>博客后台管理系统 -- ${website }</title>
<link rel="stylesheet" href="${applicationScope.path }/comm/admin/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${applicationScope.path }/comm/admin/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${applicationScope.path }/comm/admin/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="${applicationScope.path }/comm/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${applicationScope.path }/comm/js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="${applicationScope.path }/comm/js/facebox.js"></script>
</head>
<body>

<div id="body-wrapper">
  <div id="sidebar">
    <%@ include file="/WEB-INF/admin/nav.jspf" %>
  </div>
  <!-- End #sidebar -->
  <%@ include file="/WEB-INF/admin/main.jspf" %>
</div>
</body>
<!-- Download From www.exet.tk-->
</html>
