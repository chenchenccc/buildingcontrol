<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<style>
#police table,#police td,#police th{border:1px solid #ccc;border-collapse:collapse;}
</style>
<div id="autho">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>用户名称：</label></td>
			<td><label>${user.username}</label></td>
		</tr>
		<tr>
			<td><label>密码:</label></td>
			<td><label>${user.password}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/user_saveAddUser.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>用户名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="user.username" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>密码</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="password" name="user.password" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>