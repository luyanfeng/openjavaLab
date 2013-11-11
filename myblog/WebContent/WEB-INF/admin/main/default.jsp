<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content-box-header">
    <h3>内容</h3>
    <ul class="content-box-tabs">
      <li><a href="#tab1" class="default-tab">数据表</a></li>
      <li><a href="#tab2">表单项</a></li>
    </ul>
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
            <th>
              <input class="check-all" type="checkbox" />
            </th>
            <th>Column 1</th>
            <th>Column 2</th>
            <th>Column 3</th>
            <th>Column 4</th>
            <th>Column 5</th>
          </tr>
        </thead>
        <tfoot>
          <tr>
            <td colspan="6">
              <div class="bulk-actions align-left">
                <select name="dropdown">
                  <option value="option1">Choose an action...</option>
                  <option value="option2">Edit</option>
                  <option value="option3">Delete</option>
                </select>
                <a class="button" href="#">选定</a> </div>
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
          <tr>
            <td>
              <input type="checkbox" />
            </td>
            <td>Lorem ipsum dolor</td>
            <td><a href="#" title="title">Sit amet</a></td>
            <td>Consectetur adipiscing</td>
            <td>Donec tortor diam</td>
            <td>
              <!-- Icons -->
              <a href="#" title="Edit"><img src="${applicationScope.path }/comm/admin/images/icons/pencil.png" alt="Edit" /></a> <a href="#" title="Delete"><img src="${applicationScope.path }/comm/admin/images/icons/cross.png" alt="Delete" /></a> 
              <a href="#" title="Edit Meta"><img src="${applicationScope.path }/comm/admin/images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a> </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="tab-content" id="tab2">
      <form action="#" method="post">
        <fieldset>
        <!-- Set class to "column-left" or "column-right" on fieldsets to divide the form into columns -->
        <p>
          <label>Small form input</label>
          <input class="text-input small-input" type="text" id="small-input" name="small-input" />
          <span class="input-notification success png_bg">Successful message</span>
          <!-- Classes for input-notification: success, error, information, attention -->
          <br />
          <small>A small description of the field</small> </p>
        <p>
          <label>Medium form input</label>
          <input class="text-input medium-input datepicker" type="text" id="medium-input" name="medium-input" />
          <span class="input-notification error png_bg">Error message</span> </p>
        <p>
          <label>Large form input</label>
          <input class="text-input large-input" type="text" id="large-input" name="large-input" />
        </p>
        <p>
          <label>Checkboxes</label>
          <input type="checkbox" name="checkbox1" />
          This is a checkbox
          <input type="checkbox" name="checkbox2" />
          And this is another checkbox </p>
        <p>
          <label>Radio buttons</label>
          <input type="radio" name="radio1" />
          This is a radio button<br />
          <input type="radio" name="radio2" />
          This is another radio button </p>
        <p>
          <label>This is a drop down list</label>
          <select name="dropdown" class="small-input">
            <option value="option1">Option 1</option>
            <option value="option2">Option 2</option>
            <option value="option3">Option 3</option>
            <option value="option4">Option 4</option>
          </select>
        </p>
        <p>
          <label>Textarea with WYSIWYG</label>
          <textarea class="text-input textarea wysiwyg" id="textarea" name="textfield" cols="79" rows="15"></textarea>
        </p>
        <p>
          <input class="button" type="submit" value="Submit" />
        </p>
        </fieldset>
        <div class="clear"></div>
        <!-- End .clear -->
      </form>
    </div>
    <!-- End #tab2 -->
</div>
