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
<div id="device">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>设备名称：</label></td>
			<td><label>${device.deviceName}</label></td>
		</tr>
		<tr>
			<td><label>设备类型:</label></td>
			<td><label>${device.deviceType}</label></td>
		</tr>
		<tr>
			<td><label>设备状态:</label></td><!--
			if(value == '0') return"<img src='images/off.png'/>";
				else if(value == '1') return"<img src='images/on.png'/>";
			--><td><label>${device.state}</label></td>
		</tr>
		<tr>
			<td><label>所属楼层:</label></td>
			<td><label>${device.buildingName}</label></td>
		</tr>
		<tr>
			<td><label>设备号:</label></td>
			<td><label>${device.deviceNo}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/device_saveAddDevice.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>设备名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="device.deviceName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>设备号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="device.deviceNo" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属楼层</td>
	      	<td>
	      	<select name="device.buildingId" class="easyui-combogrid" style="width:250px" data-options="
			            panelWidth: 500,
			            idField: 'id',
			            textField: 'buildingName',
			            url: getPath()+'/building_listBuilding.action',
			            method: 'post',
			            columns: [[
			                {field:'buildingName',title:'楼层号',width:80,align:'center'},
			                {field:'buildingType',title:'楼层类型',width:120,align:'center',formatter:function(value,rowData,rowIndex){
								if(value == '0') return'大楼';
								else if(value == '1') return'楼层';
							}},
			            ]],
			            fitColumns: true
			        ">
			    </select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>设备类型</td>
	      	<td>
	      		<select name="building.deviceType" class="easyui-combobox"><option value="1">电灯</option><option value="2">电风扇</option><option value="3">空调</option><option value="5">洗衣机</option><option value="4">电视机</option><option value="6">热水器</option><option value="7">插座</option></select>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>状态</td>
	      	<td>
	      		<select name="building.state" class="easyui-combobox"><option value="1">开</option><option value="0">关</option></select>
	      	</td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/device_saveEditDevice.action">
<input type="hidden" name="device.id" value="${device.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>权限名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="device.deviceName" value="${device.deviceName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>URL</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="device.url" value="${device.url }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>上级权限</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="device.superId" value="${device.superId }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="device.description" value="${device.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>