<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form id="queryParameter" style="display:none" action="">
<input type="hidden" name="currentNum" value="${currentNum }" />
<input type="hidden" name="totalNum" value="${totalNum }" />
<input type="hidden" name="nav" value="${nav }" />
</form>
<div class="content-box-header">
  <h3>标签管理</h3>
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
            <th>标签</th>
            <th style="text-align:center">时间</th>
            <th style="text-align:center">文章数</th>
            <th style="text-align:center">操作</th>
          </tr>
        </thead>
        <tbody>
        <s:iterator status="vs" value="list" var="tag">
          <tr>
            <td _name="<s:property value="#tag.name "/>">
            	<a href="javascript:void(0)" id="${tag.id}" onclick="modifytag('${tag.id}')" ><s:property value="#tag.name "/></a>
            	<div style="display:none">
            	<input type='text'  name='name' value='<s:property value="#tag.name "/>' class='text-input'/>
            	<a href='javascript:void(0)' onclick="submitModify('${tag.id}')" >确认</a>
            	<a href="javascript:void(0)" onclick="cannelModify('${tag.id}')" >取消</a>
            	</div>
            	
            </td>
            <td style="text-align:center"><s:property value="#tag.time "/>&nbsp;</td>
            <td style="text-align:center"><s:property value="#tag.quantity "/>&nbsp;</td>
            <td style="text-align:center">
            <a href="javascript:void(0)" onclick="switchHidden('${tag.id}')">${tag.hidden ? '显示' :'隐藏'}</a> | 
            <a href="javascript:void(0)" onclick="deletetag('${tag.id}')">删除</a>
            </td>
          </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
 </div>
<script type="text/javascript">
//加载数据
function initTags(){
	$.ajax({
		type:"post",
		data: $("#queryParameter").size() == 1 ? $("#queryParameter").serialize() : "",
		url:"${applicationScope.path }/admin/article/tags.jap",
		beforeSend:function(){
			$(".content-box").html("<h1>系统正在给力的为您加载组件....</h1>");
		},
		error:function(){
			alert("网络不给力，加载不了了....");
		},
		success:function(o){
			$(".content-box").html(o);
		}
	});
}
/**
 * 删除
 */
function deletetag(id){
	if(id){
		$.ajax({
			type:"post",
			data:{"id":id},
			url:"${applicationScope.path }/admin/tag/delete.jap",
			success:function(o){
				if(o.s == 1){
					initTags();
				}else{
					$("#listmessage div").html("网络不给力，请稍后再试");
					$("#listmessage").show();
				}
			}
		});
	}else{
		alert("网络不给力，请刷新后重试了....");
	}
}
//显隐开关
function switchHidden(id){
	if(id){
		$.ajax({
			type:"post",
			data:{"id":id},
			url:"${applicationScope.path }/admin/tag/switchHidden.jap",
			success:function(o){
				if(o.s == 1){
					initTags();
				}else{
					$("#listmessage div").html("网络不给力，请稍后再试");
					$("#listmessage").show();
				}
			}
		});
	}
}
// 修改类型事件
function modifytag(id){
	if(id){
		$("#"+id).hide();
		$("#"+id).siblings("div").find("input").val( $("#"+id).parents("td").attr("_name"));
		$("#"+id).siblings("div").show();
	}else{
		alert("怎么回事");
	}
}
/**
 * 取消类型修改
 */
function cannelModify(id){
	if(id ){
		var va = $("#"+id).parents("td").attr("_name");
		$("#"+id).text(va  ? va : "");
		$("#"+id).show();
		$("#"+id).siblings("div").find("input").val( $("#"+id).parents("td").attr("_name") );
		$("#"+id).siblings("div").hide();
	}
}
/**
 * 提交类型保存
 */
function submitModify(id){
	if(id && $("#"+id).siblings("div").find("input").val() ){
		var inputval = $("#"+id).siblings("div").find("input").val();
		$.ajax({
			url:"${applicationScope.path}/admin/tag/save.jap",
			type:"post",
			data:{"name": inputval ? inputval : "" ,"id":id},
			success:function(o){
				initTags();
			}
		});
	}else{
		alert("请正确输入！");
	}
}
</script>