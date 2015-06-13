<%@ page language="java" import="java.util.*,com.building.model.Building" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Building> list = (List<Building>)request.getSession().getAttribute("buildingList");
if(list==null){
	list = new ArrayList<Building>();
}
%>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript">
</script>
<style>
#police table,#police td,#police th{border:1px solid #ccc;border-collapse:collapse;}
</style>
<div id="build">
<c:if test="${operate eq 'view'}">

	<table cellpadding="5">
		<tr>
	      	<td><span class="x">*</span>楼层号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.buildingName" value="${building.buildingName }" ></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>楼层类型</td>
	      	<td><select class="easyui-combobox" style="width:250px" name="building.buildingType" value="${building.buildingType }" >
	      		<option value='0'>大楼</option>
	      		<option value='1'>楼层</option>
	      	</select></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>经度</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.centerLng" value="${building.centerLng }"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>纬度</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.centerLat" value="${building.centerLat }" ></input></td>
	  	</tr>
	</table>
</c:if>
<c:if test="${operate eq 'add'}">
<form id="saveform" method="post" action="">
		<table cellpadding="5">
		<tr>
	      	<td><span class="x">*</span>楼层号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.buildingName" value="${building.buildingName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>楼层类型</td>
	      	<td><select class="easyui-combobox" style="width:250px" name="building.buildingType" value="${building.buildingType }" data-options="required:true;message:'选择类型！'">
	      		<option value='0'>大楼</option>
	      		<option value='1'>楼层</option>
	      	</select></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属大楼</td>
	      	<td><select class="easyui-combobox" style="width:250px" name="building.superId" value="${building.superId }" data-options="required:true;message:'选择类型！'">
	      		<option value='0'>无</option>
	      		<%for(int i=0;i<list.size();i++){
	      			if(list.get(i).getBuildingType()==0){
	      		 %>
	      		 <option value='<%=list.get(i).getId() %>'><%=list.get(i).getBuildingName() %></option>
	      		 <%}} %>
	      	</select></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>经度</td>
	      	<td><input id="cLng" class="easyui-textbox" type="text" name="building.centerLng" value="${building.centerLng }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>经度</td>
	      	<td><input id="cLat" class="easyui-textbox" type="text" name="building.centerLat" value="${building.centerLat }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>
<c:if test="${operate eq 'edit'}">
<form id="saveform" method="post" action="">
<input type="hidden" name="building.id" value="${building.id}"/>
	<table cellpadding="5">
		<tr>
	      	<td><span class="x">*</span>楼层号</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.buildingName" value="${building.buildingName }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>楼层类型</td>
	      	<td><select class="easyui-combobox" style="width:250px" name="building.buildingType" value="${building.buildingType }" data-options="required:true;message:'选择类型！'">
	      		<option value='0'>大楼</option>
	      		<option value='1'>楼层</option>
	      	</select></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>所属大楼</td>
	      	<td><select class="easyui-combobox" style="width:250px" name="building.superId" value="${building.superId }" data-options="required:true;message:'选择类型！'">
	      		<option value='0'>无</option>
	      		<%for(int i=0;i<list.size();i++){
	      			if(list.get(i).getBuildingType()==0){
	      		 %>
	      		 <option value='<%=list.get(i).getId() %>'><%=list.get(i).getBuildingName() %></option>
	      		 <%}} %>
	      	</select></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>经度</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.centerLng" value="${building.centerLng }" data-options="required:true"></input></td>
	  	</tr>
	  	<tr>
	      	<td><span class="x">*</span>纬度</td>
	      	<td><input class="easyui-textbox" style="width:250px" type="text" name="building.centerLat" value="${building.centerLat }" data-options="required:true"></input></td>
	  	</tr>
	</table>
</form>
</c:if>



</div>