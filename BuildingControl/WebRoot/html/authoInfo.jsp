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
			<td><label>URL：</label></td>
			<td><label>${autho.url}</label></td>
		</tr>
		<tr>
			<td><label>上级权限：</label></td>
			<td><label>${autho.superName}</label></td>
		</tr>
		<tr>
			<td><label>描述:</label></td>
			<td><label>${autho.description}</label></td>
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
	      	<td><span class="x">*</span>URL</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.url" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>上级权限</td>
	      	<td>
	      		<select name="autho.superId" class="easyui-combogrid" style="width:250px" data-options="
			            panelWidth: 500,
			            idField: 'id',
			            textField: 'authoName',
			            url: getPath()+'/autho_listAutho.action',
			            method: 'post',
			            columns: [[
			                {field:'authoName',title:'权限名称',width:80,align:'center'},
			                {field:'url',title:'URL',width:120,align:'center'},
			                {field:'superName',title:'上级权限',width:120,align:'center'},
			            ]],
			            fitColumns: true
			        ">
			    </select>
	      	</td>
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
	      	<td><span class="x">*</span>URL</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.authoName" value="${autho.url }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>上级权限</td>
	      	<td>
	      		<select name="autho.superId" class="easyui-combogrid" value="${autho.superId }" style="width:250px" data-options="
			            panelWidth: 500,
			            idField: 'id',
			            textField: 'authoName',
			            url: getPath()+'/autho_listAutho.action',
			            method: 'post',
			            columns: [[
			                {field:'authoName',title:'权限名称',width:80,align:'center'},
			                {field:'url',title:'URL',width:120,align:'center'},
			                {field:'superName',title:'上级权限',width:120,align:'center'},
			            ]],
			            fitColumns: true
			        ">
			    </select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="autho.description" value="${autho.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>