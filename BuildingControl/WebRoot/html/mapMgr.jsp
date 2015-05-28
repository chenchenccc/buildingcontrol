<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>地图</title>
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
 <div id="allmap" style="height:100%"></div>
</div>
 </body>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/JQuery-zTree-v3.5.15/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=YBiVzVLfgjtaxfAGoZIXkPQK"></script>
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
				/*$('#tt').datagrid({
					queryParams : {'device.buildingId':node.id}
				});*/
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
			//InitLeftMenu();
			var json = eval('('+msg+')');
			if(json.success == true) {
				zNodes = json.msg;
				InitLeftMenu();
			} else {
				zNodes = [];
				$('#buildingTree').append(json.msg);
			
			}
		}
	});
	
	
	// 初始化左侧菜单
	function InitLeftMenu() {
		$.fn.zTree.init($("#buildingTree"), setting, eval(zNodes));
		var zTree = $.fn.zTree.getZTreeObj("buildingTree");
	}
	
	// 百度地图API功能
	var map = new BMap.Map("allmap");    // 创建Map实例
	map.centerAndZoom(new BMap.Point(119.404, 26.115), 12);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.setCurrentCity("福州");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
});
</script>
</html>
	