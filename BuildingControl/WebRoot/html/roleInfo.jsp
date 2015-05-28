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
<div id="role">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>角色名称：</label></td>
			<td><label>${role.roleName}</label></td>
		</tr>
		<tr>
			<td><label>上级角色:</label></td>
			<td><label>${role.superId}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/role_saveAddRole.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>角色名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="role.roleName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="role.description" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/role_saveEditRole.action">
<input type="hidden" name="role.id" value="${role.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>角色名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="role.roleName" value="${role.roleName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="role.description" value="${role.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>