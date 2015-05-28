<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>设备管理</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/JQuery-zTree-v3.5.15/css/zTreeStyle/zTreeStyle.css">
</head>
<body class="easyui-layout" >
<div data-options="region:'west',title:'楼宇树',split:false" border="true" style="width:180px;">
	<ul id="buildingTree" class="ztree"></ul>
</div>
<div id="body" region="center" > 
  <!-- 数据表格区域 -->
  <table id="tt" style="table-layout:fixed;"></table>
  <!-- Dialog -->
  <div id="dd"><div id="content" region="center" border="false" style="padding: 10px;  border: 1px solid #ccc;"></div>
 
  </div>
 </body>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/JQuery-zTree-v3.5.15/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
function getPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return projectName;
}
var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		selectedMulti: false
	},
	callback: {
		onClick:function(e, id, node){
			var zTree = $.fn.zTree.getZTreeObj("buildingTree");
			if(node.isParent) {
				zTree.expandNode();
			} else {
				//addTabs(node.name, getPath() + node.file);
				$('#tt').datagrid({
					queryParams : {'device.buildingId':node.id}
				});
			}
		}
	}
};
$(function(){
	var zNodes;
	// 获取楼宇树
	$.ajax({
	  type: 'POST',
	  url: getPath() + "/building_buildingTree.action",
	  success: function (msg){  
			console.log(msg);    
			//zNodes = msg;
			//InitcenterMenu();
			var json = eval('('+msg+')');
			if(json.success == true) {
				zNodes = json.msg;
				InitcenterMenu();
			} else {
				zNodes = [];
				$('#buildingTree').append(json.msg);
			
			}
		}
	});
	
	
	// 初始化左侧菜单
	function InitcenterMenu() {
		$.fn.zTree.init($("#buildingTree"), setting, eval(zNodes));
		var zTree = $.fn.zTree.getZTreeObj("buildingTree");
	}
	$("#tt").datagrid({
		height:$("#body").height()-$('#search_area').height()-5,
		width:$("#body").width(),
//		idField:'id',
		singleSelect:true, 
		nowrap:true,
		striped: true,
		fitColumns:true,
		rownumbers:true,
		loadMsg : /*showProcess(true, '温馨提示', '正在加载数据, 请稍后...')*/'正在加载数据',
		url: getPath() + "/device_listDevice.action",  
		columns:[[
			{field:'deviceName',title:'设备名称',width:60,halign:"center", align:"center"},
			{field:'deviceType',title:'设备类型',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"电灯";
				else if(value == '2') return"电风扇";
				else if(value == '3') return"空调";
				else if(value == '4') return"电视机";
				else if(value == '5') return"洗衣机";
				else if(value == '5') return"热水器";
				else if(value == '5') return"插座";
				else return "";
			}},
			{field:'state',title:'状态',width:60,halign:"center",  align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '0') return"<img src='images/off.png'/>";
				else if(value == '1') return"<img src='images/on.png'/>";
				else return "";
			}},
			{field:'buildingName',title:'所属楼层',width:60,halign:"center", align:"center"},
			{field:'deviceNo',title:'设备号',width:60,halign:"center", align:"center"},
			{field:'createTime',title:'创建时间',width:60,halign:"center", align:"center"}
		]],
		showPageList:[10,20,30,40,50],
		pageNumber: 1, // 初始页数
		pageSize: 10,  // 初始
		pagination: true,
		toolbar: [{
			text: '添加',
			iconCls: 'icon-add',
			handler: function(){
				$('#dd').dialog({
			        buttons: [{
			            text:'保存',
			            iconCls:'icon-ok',
			            handler:function(){
			        		 // 保存添加对象
			        		var formData=$("#saveform").serialize();
			        		$.ajax({
								type: "POST",
								url: getPath() + '/device_saveAddDevice.action',
								processData: true,
								data: formData,
								success: function(data){
			        				var result = eval("("+data+")");
									if (result && result.success) {
										$('#tt').datagrid('reload');
										$.messager.show({title : '信息',msg : result.msg});
									} else {
										$.messager.show({title : '错误',msg : result.msg});
									}
			        			
								}
			        		});
			                $("#dd").dialog('close');
			            }
			        },{
			            text:'取消',
			            iconCls:'icon-cancel',
			            handler:function(){
			                $("#dd").dialog('close');
			            }
			        }]
			    });
				$("#content").html(''); // 先将content的内容清空
				// 保存对象
				$.post(getPath()+"/device_addDevice.action",
				    function(result){
						$("#content").append(result);
				    });
				$("#dd").dialog('open').dialog('setTitle', '添加');
			    $('#form').form('clear');
			}
		},{
			text: '修改',
			iconCls: 'icon-edit',
			handler: function(){
				$('#dd').dialog({
		        buttons: [{
		            text:'保存',
		            iconCls:'icon-ok',
		            handler:function(){
		        		var formData=$("#saveform").serialize();
						// 保存编辑对象		        		
		        		$.ajax({
							type: "POST",
							url: getPath() + '/device_saveEditDevice.action',
							processData:true,
							data:formData,
							success: function(data){
								var result = eval("("+data+")");
								if (result && result.success) {
									$('#tt').datagrid('reload');
									$.messager.show({title : '信息',msg : result.msg});
								} else {
									$.messager.show({title : '错误',msg : result.msg});
								}
		        				$('#tt').datagrid('reload');
							}
		        		});
		                $("#dd").dialog('close');
						$('#tt').datagrid('reload');
		            }
		        },{
		            text:'取消',
		            iconCls:'icon-cancel',
		            handler:function(){
		                $("#dd").dialog('close');
		            }
		        }]
		    });
			var row = $('#tt').datagrid('getSelected');
			if(row == null) {
				showMsg('警告','请选择一条记录','alert');
				return;
			}
			$("#content").html(''); // 先将content的内容清空
			// 获取编辑对象
			$.post(getPath()+"/device_editDevice.action",
				{"device.id": row.id},
			    function(result){  
					$("#content").append(result);
			    });
			$("#dd").dialog('open').dialog('setTitle', '修改');
			$('#form').form('load', row);
		}
		},{
			text: '删除',
			iconCls: 'icon-remove',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if (row) {$.messager.confirm('警告','确定删除？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/device_delDevice.action',
								{"device.id" :  row.id},
								function(json) {
									var result = eval(json);
									if (result && result.success) {
										$('#tt').datagrid('reload'); 
									} else {
										$.messager.show({title : 'Error',msg : result.msg});
									}
								},'json');
						}
					});
				} else {
					showMsg('警告','请选择一条记录','alert');
				}
			}
			},'-',{
			text: '更改状态',
			iconCls: 'icon-reload',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				var state = row.state;
				var device = row.deviceName;
				var building = row.buildingName;
				if (row) {$.messager.confirm('警告','确定将'+device+'状态更改为'+(state==1?"<font color='red'>关</font>":"<font color='red'>开</font>")+'？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/device_changeState.action',
								{"device.id" :  row.id},
								function(json) {
									var result = eval(json);
									if (result && result.success) {
										$('#tt').datagrid('reload'); 
										$.messager.show({title : 'Info',msg : '更改状态成功, 已将'+building+'>'+device+'的状态更改为'+(state==1?"<font color='red'>关</font>":"<font color='red'>开</font>")});
									} else {
										$.messager.show({title : 'Error',msg : result.msg});
									}
								},'json');
						}
					});
				} else {
					showMsg('警告','请选择一条记录','alert');
				}
			}
		}],
		onDblClickRow:function(rowIndex, rowData){
			viewDetail(rowData.id);
		}
	});
	$('#dd').dialog({
	    width: 500,
	    height: 300,
	    closed: true,
	    cache: false,
	    modal: true,
        iconCls: 'icon-save'
    });

});
function fuzzyquery() {
	$('#tt').datagrid({
		queryParams : form2Obj("fuzzy")
	});
}
/**
 * 查看详细信息
 */
function viewDetail(data){
	////
	$('#dd').dialog({
        buttons: [{
            text:'确定',
            iconCls:'icon-ok',
            handler:function(){
                $("#dd").dialog('close');
            }
        }]
    });
	////
	var row = $('#tt').datagrid('getSelected');
	$("#content").html(''); // 先将content的内容清空
	// 查看对象
	$.post(getPath()+"/device_viewDevice.action",
		{"device.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}

</script>
</html>
	