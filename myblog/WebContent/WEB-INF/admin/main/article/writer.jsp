<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="content-box-header">
  <h3>我的新文章</h3>
  <div class="clear"></div>
</div>
<div class="content-box-content">
  <div class="tab-content default-tab" id="tab1">
    <div id="savefailure" style="display:none"  class="notification attention  png_bg"> 
    <a href="#" class="close"><img src="${applicationScope.path }/comm/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
      <div>这是条提示信息！</div>
    </div>
    <FORM id="FMdata" action="" >
		<table>
			<tr>
				<td>标题：</td>
				<td><input class="text-input small-input" type="text" name="title" value="${title }"/></td>
			</tr>
			<tr>
				<td valign="top" style="vertical-align: top;">内容：</td>
				<td><textarea class="text-input textarea wysiwyg" id="content" name="content" cols="79" rows="15"></textarea></td>
			</tr>
			<tr>
				<td colspan="3"><a class="button savebutton">保存文章</a></td>
			</tr>
		</table>
     </FORM>
   </div>
 </div>
 <script type="text/javascript">
<!--
$(".savebutton").click(function(){
	$.ajax({
		url:"${applicationScope.path }/admin/article/save.jap",
		data:$("#FMdata").serialize(),
		type:"post",
		success:function(o){
			if(o.s){
				alert("保存成功");
			}else{
				$("#savefailure div").html("保存失败：请确认您的输入是正常的；不要耍我哦，我可是会生气的！")
// 				.addClass("error")
				;
				$("#savefailure").show();
			}
		}
	});
});
//-->
</script>
