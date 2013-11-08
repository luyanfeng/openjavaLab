<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录  -- ${website }</title>
<link rel="stylesheet" href="${applicationScope.path }/comm/admin/css/reset.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${applicationScope.path }/comm/admin/css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="${applicationScope.path }/comm/admin/css/invalid.css" type="text/css" media="screen" />
<script type="text/javascript" src="${applicationScope.path }/comm/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${applicationScope.path }/comm/js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="${applicationScope.path }/comm/js/facebox.js"></script>
<script type="text/javascript" src="${applicationScope.path }/comm/js/jquery.wysiwyg.js"></script>
</head>
<body id="login">
<div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>欢迎主人回来</h1>
    <!-- Logo (221px width) -->
    <a href="#"><img id="logo" src="${applicationScope.path }/comm/admin/images/logo.png" alt="Simpla Admin logo" /></a> </div>
  <!-- End #logn-top -->
  <div id="login-content">
    <form action="${applicationScope.path }/admin/login.jap" method="post">
      <div class="notification information png_bg">
        <div></div>
        <div>注意：只有管理员才可以从这里登录，否则失败三次后系统会自动屏蔽您的IP！ </div>
      </div>
      <p>
        <label>E-Mail</label>
        <input class="text-input" type="text" name="email"/>
      </p>
      <p>
        <label>用户名</label>
        <input class="text-input" type="text" name="user"/>
      </p>
      <div class="clear"></div>
      <p>
        <label>密码</label>
        <input class="text-input" type="password"  name="passwd"/>
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
        记住我</p>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="登陆" />
      </p>
    </form>
  </div>
  <!-- End #login-content -->
</div>
<!-- End #login-wrapper -->
</body>
</html>
