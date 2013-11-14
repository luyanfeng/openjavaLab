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
            <th style="text-align:center">文章数</th>
            <th style="text-align:center">操作</th>
          </tr>
        </thead>
        <tbody>
        <s:iterator status="vs" value="list" var="type">
          <tr>
            <td _name="<s:property value="#type.name "/>">
            	<a href="javascript:void(0)" id="${type.id}" onclick="modifyType('${type.id}')" ><s:property value="#type.name "/></a>
            	<div style="display:none">
            	<input type='text'  name='name' value='<s:property value="#type.name "/>' class='text-input'/>
            	<a href='javascript:void(0)' onclick="submitModify('${type.id}')" >确认</a>
            	<a href="javascript:void(0)" onclick="cannelModify('${type.id}')" >取消</a>
            	</div>
            	
            </td>
            <td style="text-align:center"><s:property value="#type.time "/>&nbsp;</td>
            <td style="text-align:center"><s:property value="#type.quantity "/>&nbsp;</td>
            <td style="text-align:center">
            <a href="javascript:void(0)" onclick="switchHidden('${type.id}')">${type.hidden ? '显示' :'隐藏'}</a> | 
            <a href="javascript:void(0)" onclick="deleteType('${type.id}')">删除</a>
            </td>
          </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
 </div>
