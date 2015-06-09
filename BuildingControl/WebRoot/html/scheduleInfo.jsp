<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<style>
#scheduleDate {
	width: 381px;
}
#scheduleDate input {
	width: 30px;
}
#police table,#police td,#police th{border:1px solid #ccc;border-collapse:collapse;}
</style>
<div id="schedule">
<c:if test="${operate eq 'view'}">
<form id="saveform" method="post">
	<table cellpadding="5">
		<tr>
			<td><label>日程时间：</label></td>
			<td><label>${schedule.scheduleDate}</label></td>
		</tr>
		<tr>
			<td><label>楼层号:</label></td>
			<td><label>${schedule.buildingName}</label></td>
		</tr>
		<tr>
			<td><label>设备名:</label></td>
			<td><label>${schedule.deviceName}</label></td>
		</tr>
		<tr>
			<td><label>设置状态:</label></td>
			<td><label>${schedule.changeState}</label></td>
		</tr>
		<tr>
			<td><label>状态:</label></td>
			<td><label>${schedule.isDone}</label></td>
		</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="<%=path %>/schedule_saveAddSchedule.action">
		<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>日程时间</td>
	      	<td>
	      		<div id="scheduleDate">
	      		<input name="scheduleDate" type="checkbox">每天
	      		<input name="scheduleDate" type="checkbox">工作日
	      		<input name="scheduleDate" type="checkbox">周末
	      		<input name="scheduleDate" type="checkbox">一次
	      		<input name="scheduleDate" type="checkbox">星期一
	      		<input name="scheduleDate" type="checkbox">星期二
	      		<input name="scheduleDate" type="checkbox">星期三
	      		<input name="scheduleDate" type="checkbox">星期四
	      		<input name="scheduleDate" type="checkbox">星期五
	      		<input name="scheduleDate" type="checkbox">星期六
	      		<input name="scheduleDate" type="checkbox">星期日
	      		</div>
	      	<input class="easyui-textbox" style="width:250px" type="text" name="schedule.buildingName" data-options="required:true"></input>
	      	</td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>楼层号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.buildingName" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>设备号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.changeState" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>设备状态</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.description" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="<%=path %>/schedule_saveEditSchedule.action">
<input type="hidden" name="schedule.id" value="${schedule.id }"/>
	<table cellpadding="5">
	 	<tr>
	      	<td><span class="x">*</span>权限名称</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.authoName" value="${schedule.authoName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>URL</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.url" value="${schedule.url }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>上级权限</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.superId" value="${schedule.superId }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>描述</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="schedule.description" value="${schedule.description }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
</div>