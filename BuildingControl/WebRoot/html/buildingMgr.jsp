<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>楼宇管理</title>
	<link rel="stylesheet" type="text/css" href="css/default.css">
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.3.5/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="../ol/ol.css" />
</head>
<body class="easyui-layout" >
<div id="body" region="center" > 
  <!-- 数据表格区域 -->
  <table id="tt" style="table-layout:fixed;"></table>
  <!-- Dialog -->
  <div id="dd"><div id="content" region="center" border="false" style="padding: 10px;  border: 1px solid #ccc;"></div>
 
  </div>
  
  <div id="mapDlg" class="easyui-dialog" title="地图选点" data-options="iconCls:'icon-save',closed:true" style="width:400px;height:260px;padding:10px">
        <div id="chooseMap"></div>
</div>

 </body>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="../ol/ol.js"></script>
<script type="text/javascript">
function getPath() {
	var pathName = window.document.location.pathname;
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return projectName;
}
var map;//地图
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
		url: getPath() + "/building_listBuilding.action",  
		columns:[[
			{field:'buildingName',title:'楼层号',width:60,halign:"center", align:"center"},
			{field:'buildingType',title:'楼层类型',width:60,halign:"center", align:"center",formatter:function(value,rowData,rowIndex){
				if(value == '0') return"大楼";
				else if(value == '1') return"楼层";
			}},
			{field:'createTime',title:'创建时间',width:60,halign:"center", align:"center"},
			{field:'centerLng',title:'经度坐标',width:60,halign:"center", align:"center"},
			{field:'centerLat',title:'纬度坐标',width:60,halign:"center", align:"center"},
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
								url: getPath() + '/building_saveAddBuilding.action',
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
			        },{
			            text:'地图选点',
			            iconCls:'icon-save',
			            handler:function(){
			                $("#mapDlg").dialog('open');
			                if(map==null){
			                	initMap();
			                }
							
			            }
			        }]
			    });
				$("#content").html(''); // 先将content的内容清空
				// 保存对象
				$.post(getPath()+"/building_addBuilding.action",
				    function(result){
						$("#content").append(result);
						$("#dd").dialog('open').dialog('setTitle', '添加');
			    		$('#form').form('clear');
				    });
				
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
							url: getPath() + '/building_saveEditBuilding.action',
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
			$.post(getPath()+"/building_editBuilding.action",
				{"building.id": row.id},
			    function(result){  
					$("#content").append(result);
					$("#dd").dialog('open').dialog('setTitle', '修改');
					$('#saveform').form('load', row);
			    });
			
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
							$.post(getPath() + '/building_delBuilding.action',
								{"building.id" :  row.id},
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
			text: '所有大楼',
			iconCls: 'icon-ok',
			handler: function(){
				$('#tt').datagrid({
					queryParams : {'building.superId':0}
				});
			}
		},{
			text: '所有楼层',
			iconCls: 'icon-ok',
			handler: function(){
				$('#tt').datagrid({
					queryParams : {'building.superId':1}
				});
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
	$.post(getPath()+"/building_viewBuilding.action",
		{"building.id" : row.id },
	    function(result){ 
			$("#content").append(result);
	    });
	$("#dd").dialog('open').dialog('setTitle', '查看');
}


function initMap(){
var projection = ol.proj.get("EPSG:4326");
var projectionExtent = projection.getExtent();
var size = ol.extent.getWidth(projectionExtent) / 256;
	var resolutions = new Array(20);
	var matrixIds = new Array(20);
	for (var z = 1; z <= 19; ++z) {
		  // generate resolutions and matrixIds arrays for this WMTS
		  resolutions[z] = size / Math.pow(2, z);
		  matrixIds[z] = z;
		}
	tileGrid = new ol.tilegrid.WMTS({
		origin : ol.extent.getTopLeft(projectionExtent),
		resolutions : resolutions,
		matrixIds : matrixIds
	});
	source =  new ol.source.WMTS({
		url : 'http://t0.tianditu.com/vec_c/wmts',
		layer : 'vec',

		// zoomOffset:2,
		matrixSet : "c",
		format : 'tiles',
		projection : projection,
		tileGrid : tileGrid,
		style: 'default',
	    wrapX: true
	});
	var raster = new ol.layer.Tile({
		opacity : 1,
		extent : projectionExtent,
		preload: Infinity,
		source : source
});
	var raster2 =  new ol.layer.Tile({
		opacity : 1,
		extent : projectionExtent,
		preload: Infinity,
		source : new ol.source.WMTS({
			url : 'http://t0.tianditu.com/cva_c/wmts',
			layer : 'cva',
			matrixSet : "c",
			format : 'tiles',
			projection : projection,
			tileGrid : new ol.tilegrid.WMTS({
				origin : ol.extent
						.getTopLeft(projectionExtent),
				resolutions : resolutions,
				matrixIds : matrixIds
			}),
			style: 'default',
		    wrapX: true
		})
});


map = new ol.Map({
  layers: [raster,raster2],
  target: 'chooseMap',
  view: new ol.View({
    projection: 'EPSG:4326',
    center: [119.2906, 26.04],
    zoom: 12
  })
});
map.on('click',function(evt){
	var coord = evt.coordinate;
	$('#cLng').val(coord[0]);
	$('#cLat').val(coord[1]);
	$("#mapDlg").dialog('close');
})

}


</script>
</html>
	