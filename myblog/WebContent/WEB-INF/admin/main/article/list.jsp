<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="content-box-header">
  <h3>我的新文章</h3>
  <div class="clear"></div>
</div>
<div class="content-box-content">
  <div class="tab-content default-tab" id="tab1">
      <!-- This is the target div. id must match the href of this div's tab -->
      <div style="display:${display eq 1 ? '' :'none'} ;" class="notification attention png_bg"> <a href="#" class="close"><img src="${applicationScope.path }/comm/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
        <div><s:actionerror /><s:actionmessage/> </div>
      </div>
      <table>
        <thead>
          <tr>
            <th><input class="check-all" type="checkbox" /></th>
            <th>标题</th>
            <th>时间（更新时间）</th>
            <th>阅读</th>
            <th>评论</th>
            <th>权限</th>
            <th>操作</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <td colspan="6">
              <!-- <div class="bulk-actions align-left">
                <select name="dropdown">
                  <option value="option1">Choose an action...</option>
                  <option value="option2">Edit</option>
                  <option value="option3">Delete</option>
                </select>
                <a class="button" href="#">选定</a> 
               </div> -->
              <div class="pagination"> 
               <a href="#" title="First Page">&laquo; 首页</a>
               <a href="#" title="Previous Page">&laquo; 前一页</a>
               <a href="#" class="number" title="1">1</a> <a href="#" class="number" title="2">2</a> 
               <a href="#" class="number current" title="3">3</a> <a href="#" class="number" title="4">4</a> 
               <a href="#" title="Next Page">下一页 &raquo;</a><a href="#" title="Last Page">最后一页 &raquo;</a> 
              </div>
              <!-- End .pagination -->
              <div class="clear"></div>
            </td>
          </tr>
        </tfoot>
        <tbody>
        <s:iterator status="vs" value="list" var="article">
          <tr>
            <td><input type="checkbox" /></td>
            <td><a href="${applicationScope.path}/home/article/detail.jap?id=${article.id}" target="_blank" ><s:property value="#article.title"/></a></td>
            <td>${empty article.updateTime ? article.time : article.updateTime}</td>
            <td>456</td>
            <td>1501</td>
            <td><a href="javascript:void(0)">不可评论</a></td>
            <td>
              <a href="javascript:void(0)" onclick="writer_('${article.id}')" title="Edit"><img src="${applicationScope.path }/comm/admin/images/icons/pencil.png" alt="Edit" /></a> 
              <a href="javascript:void(0)" onclick="delete_('${article.id}','${article.title }')" title="Delete"><img src="${applicationScope.path }/comm/admin/images/icons/cross.png" alt="Delete" /></a> 
              <a href="javascript:void(0)" title="Edit Meta"><img src="${applicationScope.path }/comm/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> 
            </td>
          </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
 </div>
