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
			<td><label>权限名称：</label></td>
			<td><label>${autho.authoName}</label></td>
		</tr>
		<tr>
			<td><label>上级权限:</label></td>
			<td><label>${autho.superId}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/autho_saveAddAutho.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>权限名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.authoName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.description" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/autho_saveEditAutho.action">
<input type="hidden" name="autho.id" value="${autho.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>权限名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.authoName" value="${autho.authoName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.description" value="${autho.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>