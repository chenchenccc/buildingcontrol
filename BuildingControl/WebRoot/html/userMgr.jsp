<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户管理</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
</head>
<body class="easyui-layout" >
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
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
function getPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return projectName;
}

$(function(){
	
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
		url: getPath() + "/user_listUser.action",  
		columns:[[
			{field:'username',title:'用户名',width:60,halign:"center", align:"center"},
			{field:'lastLogin',title:'最后登陆时间',width:60,halign:"center", align:"center"},
			{field:'isOnline',title:'状态 ',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '1') return"在线";
				else if(value == '2') return"离线";
				else if(value == '3') return"<font color='gray'>禁用</font>";
			}}
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
								url: getPath() + '/user_saveAddUser.action',
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
				$.post(getPath()+"/user_addUser.action",
				    function(result){
						$("#content").append(result);
				    });
				$("#dd").dialog('open').dialog('setTitle', '添加');
			    $('#form').form('clear');
			}
		},{
			text: '禁用',
			iconCls: 'icon-remove',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if (row) {$.messager.confirm('警告','确定禁用？',
					function(r) {
						if (r) {
							// 删除对象
							$.post(getPath() + '/user_disableUser.action',
								{"user.id" :  row.id},
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
			text: '角色',
			iconCls: 'icon-ok',
			handler: function(){
				row = $('#tt').datagrid('getSelected');
				if (row) {
					//查看角色
					viewRole();
				} else {
					showMsg('警告','请选择一条记录','alert');
				}
			}
		},'-',{
			text: '帮助',
			iconCls: 'icon-help',
			handler: function(){showMsg('帮助','这里是帮助内容','alert');}
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
	$.post(getPath()+"/user_viewUser.action",
		{"user.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}
/**
 * 查看角色
 */
function viewRole(){
	var row = $('#tt').datagrid('getSelected');
	$("#content").html(''); // 先将content的内容清空
	$("#content").append('<font color="red">'+row.username+'</font>拥有如下角色：<br/>')
	// 查看角色
	$.post(getPath() + '/user_roleList.action',
		{"user.id" :  row.id},
		function(json) {
			var result = eval(json);
			console.log(result);
			if (result && result.success) {
				// $('#tt').datagrid('reload'); 
				var data = result.msg;
				for(var i in data) {
					$("#content").append("<a onclick='delRole("+data[i].id+")'>"+data[i].roleName+", ");
				}
				
				$("#content").append("<hr />添加角色");
				
				$.post(getPath() + '/user_addRoleList.action',
					{"user.id" :  row.id},
					function(json) {
						var result = eval(json);
						console.log(result);
						if (result && result.success) {
							// $('#tt').datagrid('reload'); 
							var data = result.msg;
							for(var i in data) {
								$("#content").append('<input type="checkbox" name="role" value="'+data[i].id+'">'+data[i].roleName);
							}
						} else {
							$.messager.show({title : 'Error',msg : result.msg});
						}
					},'json');
			} else {
				$.messager.show({title : 'Error',msg : result.msg});
			}
		},'json');
	
	
	////
	$('#dd').dialog({
        buttons: [{
            text:'确定',
            iconCls:'icon-ok',
            handler:function(){
            	saveRole();
                $("#dd").dialog('close');
            }
        }]
    });
	////
	$("#dd").dialog('open').dialog('setTitle', '查看角色');
}
function saveRole() {
	var row = $('#tt').datagrid('getSelected');
	var result = new Array();
    $("[name = role]:checkbox").each(function () {
        if ($(this).is(":checked")) {
            result.push($(this).attr("value"));
        }
    });
    //alert(result.join(","));
    // 删除对象
	$.post(getPath()+"/userHasRole_saveAddUserHasRole.action",
		{"userHasRole.userId" : row.id, "roleIds": result.join(",") },
	    function(result){ 
			//$("#content").append(result);
			var json = eval("("+result+")");
			console.log(json);
			if (json && json.success) {
				//	$('#tt').datagrid('reload'); ;
				viewRole();
				$("#dd").dialog('close');
				$.messager.show({title : 'Info',msg : "添加角色成功！"});
			} else {
				$.messager.show({title : 'Error',msg : json.msg});
			}
	    });
}
function delRole(id) {
	var row = $('#tt').datagrid('getSelected');
	$.messager.confirm('警告','确定取消该角色？',
	function(r) {
		if (r) {
			// 删除对象
			$.post(getPath()+"/userHasRole_delUserHasRole.action",
				{"userHasRole.userId" : row.id, "userHasRole.roleId": id },
			    function(result){ 
					//$("#content").append(result);
					
					var json = eval("("+result+")");
					console.log(json);
					if (json && json.success) {
						//	$('#tt').datagrid('reload'); ;
						viewRole();
						$.messager.show({title : 'Info',msg : "取消权限成功！"});
					} else {
						$.messager.show({title : 'Error',msg : json.msg});
					}
			    });
		}
	});
	
}
</script>
</html>
	