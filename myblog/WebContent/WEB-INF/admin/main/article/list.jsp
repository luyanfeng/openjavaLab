<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="content-box-header">
  <h3>我的新文章</h3>
  <div class="clear"></div>
</div>
<div class="content-box-content">
  <div class="tab-content default-tab" id="tab1">
      <!-- This is the target div. id must match the href of this div's tab -->
      <div class="notification attention png_bg"> <a href="#" class="close"><img src="${applicationScope.path }/comm/admin/images/icons/cross_grey_small.png" title="Close this notification" alt="close" /></a>
        <div>这是条提示信息！</div>
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
            <td>如何保护动物</td>
            <td>2013年11月35日 8:50 am</td>
            <td>456</td>
            <td>1501</td>
            <td><a href="javascript:void(0)">不可评论</a></td>
            <td>
              <a href="javascript:void(0)" title="Edit"><img src="${applicationScope.path }/comm/admin/images/icons/pencil.png" alt="Edit" /></a> 
              <a href="javascript:void(0)" title="Delete"><img src="${applicationScope.path }/comm/admin/images/icons/cross.png" alt="Delete" /></a> 
              <a href="javascript:void(0)" title="Edit Meta"><img src="${applicationScope.path }/comm/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> 
            </td>
          </tr>
          </s:iterator>
        </tbody>
      </table>
    </div>
 </div>
