<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
.errorMessage li{ background-image: none; }
</style>
<div class="content-box-header">
  <h3>关于</h3>
  <div class="clear"></div>
</div>
<div class="content-box-content">
  <div class="tab-content default-tab" id="tab1">
    <div id="savefailure" style="display:${display eq 1 ? '' :'none'}"  class="notification attention  png_bg"> 
    <a href="#" class="close"><img src="${applicationScope.path }/comm/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
      <div><s:actionerror/> </div>
    </div>
    <FORM id="FMdata" action="" >
    <input name="about.id" value="${result.id }" type="hidden"/>
		<table>
			<tr>
				<td style="width:80px;text-align: right">标题：</td>
				<td style="width:600px;"><input style="width:500px;" class="text-input " type="text" name="about.title" value="${result.title }"/><span style="color:red;margin-left:5px;font-size:1.2em;">*</span></td>
				<td><span style="display:none" class="user_subul input-notification error png_bg"><s:fielderror fieldName="title"/></span></td>
			</tr>
			<tr>
				<td valign="top" style="vertical-align: top;text-align: right">内容：</td>
				<td><textarea class="text-input textarea wysiwyg" style="width:500px;" id="content" name="about.content" cols="79" rows="15">${result.content }</textarea><span style="color:red;margin-left:5px;font-size:1.2em;vertical-align: top; ">*</span></td>
				<td><span style="display:none;" class="user_subul input-notification error png_bg"><s:fielderror fieldName="content"/></span></td>
			</tr>
			<c:if test="${!empty result.time }">
			<tr><td style="text-align: right">时间：</td><td colspan="2">${result.time }</td></tr>
			</c:if>
			<tr>
				<td colspan="3"><a class="button savebutton">保存</a></td>
			</tr>
		</table>
     </FORM>
   </div>
 </div>
 <script type="text/javascript">
<!--
$(".savebutton").click(function(){
	$.ajax({
		url:"${applicationScope.path }/admin/saveAbout.jap",
		data:$("#FMdata").serialize(),
		type:"post",
		success:function(o){
			if(o.s == 1){
				$("#savefailure div").html("已保存！");
				$("#savefailure").removeClass("attention error").addClass("success").show();
				$(".user_subul").hide();
			}else if(o.s == 0){
				$("#savefailure div").html("保存失败：请确认您的输入是正常的；不要耍我哦，我可是会生气的！");
				$("#savefailure").removeClass("attention success").addClass("error").show();
			}else{
				$(".content-box").html(o).find(".user_subul:not(:empty)").show();
				$("#savefailure div").html("保存失败：请确认您的输入是正常的；不要耍我哦，我可是会生气的！");
				$("#savefailure").removeClass("attention success").addClass("error").show();
			}
		}
	});
});
//-->
</script>
