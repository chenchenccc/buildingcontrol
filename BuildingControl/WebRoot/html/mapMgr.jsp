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
	<link rel="stylesheet" type="text/css" href="../ol/ol.css" />
</head>
<body class="easyui-layout" >
<!-- <div data-options="region:'west',title:'楼宇树',split:false" border="true" style="width:180px;">
	 <ul id="buildingTree" class="ztree"></ul>
</div>-->
<div id="body" region="center" > 
 <div id="allmap" style="height:100%"></div>
</div>
 </body>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery-easyui-1.3.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path %>/js/JQuery-zTree-v3.5.15/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="../ol/ol.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=YBiVzVLfgjtaxfAGoZIXkPQK"></script>
<script type="text/javascript">
var map,zNodes;;
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
	zNodes;
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
  target: 'allmap',
  view: new ol.View({
    projection: 'EPSG:4326',
    center: [119.2906, 26.04],
    zoom: 18
  })
});
initFloor();


});



	// 初始化左侧菜单
function InitLeftMenu() {
	//$.fn.zTree.init($("#buildingTree"), setting, eval(zNodes));
	//var zTree = $.fn.zTree.getZTreeObj("buildingTree");
}
function initFloor(){
var source = new ol.source.Vector();
var VecLayer= new ol.layer.Vector({source:source});
$.ajax({
	url:getPath() + "/building_listBuilding.action",
	type:'post',
	success:function(data){
		eval("var buiding_data = "+data+";");
		$.each(buiding_data.rows,function(index,entity){
				if(index==0){
					map.getView().setCenter([Number(entity.centerLng),Number(entity.centerLat)]);
				}
				if(entity.buildingType==0){
					var pos = [Number(entity.centerLng),Number(entity.centerLat)];
				feature = new ol.Feature();
				feature.setGeometry( new ol.geom.Point(pos));
				var style = new ol.style.Style({
					image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
				    anchor: [0,32],
				    anchorXUnits: 'pixels',
				    anchorYUnits: 'pixels',
				    opacity: 1,
				    src: getPath()+'/images/floor.png'
				})),
			   text:new ol.style.Text({
					font: "14px 微软雅黑",
	       			text: entity.buildingName,
	       			fill: new ol.style.Fill({
		    			color: "#000000"
					}),
	        		stroke:  new ol.style.Stroke({
		   				 color: '#B1B1B1',
		   				 width: 1
					}),
	        		offsetX:16,
	        		offsetY : -32	
			  	 })
				});
				feature.setStyle(style);
				this.obj = feature;
				source.addFeature(feature);
				
				
				}
				
		})
		map.addLayer(VecLayer);
		
	}
})
	
}

</script>
</html>
	