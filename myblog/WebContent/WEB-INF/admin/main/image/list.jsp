<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form id="queryParameter" style="display:none" action="">
<input type="hidden" name="currentNum" value="${currentNum }" />
<input type="hidden" name="totalNum" value="${totalNum }" />
<input type="hidden" name="nav" value="${nav }" />
</form>
<div class="content-box-header">
  <h3>我的图册列表</h3>
  <a href="javascript:void(0)" class="button " onclick="alert('正在开发中。。。。');" style="padding:3px;float:right;margin:10px 5px;font-size: 1.2em;">上传新图册</a>
  <div class="clear"></div>
</div>
<div class="content-box-content">
  <div class="tab-content default-tab" id="tab1">
      <div id="listmessage" style="display:${display eq 1 ? '' :'none'} ;" class="notification attention png_bg"> <a href="#" class="close"><img src="${applicationScope.path }/comm/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
        <div><s:actionerror /><s:actionmessage/> </div>
      </div>
      <div style="text-align: center;">
      <s:iterator begin="0" end="5" var="d" status="vs">
      <table title="双击进入此图册" ondblclick="alert('正在开发...')" style="cursor:pointer; float:left;width:300px;height:200px;border:1px solid red;margin:10px;margin-right:18px;">
      	<tr><td rowspan="3" style="width:150px;" title="">图册封面xx</td><td>标签:xxx</td></tr>
      	<tr><td>上传者：xxx</td></tr>
      	<tr><td>简介：33xxx</td></tr>
      </table>
      </s:iterator>
      <hr style="clear: both;border-color: #fff"/>
      </div>
    </div>
 </div>
