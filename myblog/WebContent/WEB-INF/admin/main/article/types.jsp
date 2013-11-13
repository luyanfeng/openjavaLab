<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form id="queryParameter" style="display:none" action="">
<input type="hidden" name="currentNum" value="${currentNum }" />
<input type="hidden" name="totalNum" value="${totalNum }" />
<input type="hidden" name="nav" value="${nav }" />
</form>
<div class="content-box-header">
  <h3>类型管理</h3>
  <div class="clear"></div>
</div>
<div class="content-box-content">
  <div class="tab-content default-tab" id="tab1">
      <div id="listmessage" style="display:${display eq 1 ? '' :'none'} ;" class="notification attention png_bg"> <a href="#" class="close"><img src="${applicationScope.path }/comm/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
        <div><s:actionerror /><s:actionmessage/> </div>
      </div>
      <table>
        <thead>
          <tr>
            <th>类型</th>
            <th style="text-align:center">时间</th>
            <th style="text-align:center">文章</th>
            <th style="text-align:center">操作</th>
          </tr>
        </thead>
        <tbody>
        <s:iterator status="vs" value="list" var="type">
          <tr>
            <td></td>
            <td>${empty article.updateTime ? article.time : article.updateTime}</td>
            <td>${article.readtimes }&nbsp;</td>
            <td>${article.reviewtimes }&nbsp;</td>
            <td><a href="javascript:void(0)" onclick="switchopen('${article.id}')">${article.open ? '可以评论' :'禁止评论'}</a></td>
            <td>
            </td>
          </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
 </div>
