<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ES-管理</title>
<style>
	.div-request-show{
		width:90%;
		min-height:30px;
		height:30px;
		margin:auto;
		padding:10px 20px;
		border:1px dotted grey;
		border-radius:5px;
		font-family:'微软雅黑';
		font-size:16px;
		color:#D34034;
		display:none;
	}
	.div-param-show{
		width:90%;
		min-height:160px;
		height:160px;
		margin:auto;
		padding:10px 20px;
		border:1px dotted grey;
		border-radius:5px;
		font-family:'微软雅黑';
		font-size:16px;
		color:#D34034;
		display:none;
	}
	.div-result-show{
		width:90%;
		min-height:450px;
		height:600px;
		margin:auto;
		padding:10px 20px;
		display:none;
		border:1px dotted grey;
		border-radius:5px;
		font-family:'微软雅黑';
		font-size:16px;
		overflow:auto;
	}
	.table-show{
		border:0px;
		width:100%;
		margin:auto;
		display:none;
	}
	.table-show caption{
		height:40px;
		line-height:50px;
		text-align:left;
		text-indent:20px;
		font-size:18px;
		font-family:'微软雅黑';
	}
	textarea{
		width:100%;
		height:100%;
		border:0px;
	}
	
</style>
<script>
	var path="/_ES";
	
	
	
</script>
<script src="/_ES/statics/jquery-1.11.3.js" type="text/javascript"></script>
<script src="/_ES/index/xnda/mapping-xnda.js" type="text/javascript"></script>
<script src="/_ES/index/xnda/mapping-qwjs.js" type="text/javascript"></script>
<script src="/_ES/statics/index.js" type="text/javascript"></script>
</head>
<body>
<div style="width:100%;">
	<button onclick="showPage('jqjk')">集群监控</button>
	<button onclick="showPage('jdjk')">节点监控</button>
	<button onclick="showPage('syjk')">索引监控</button>
	<button onclick="showPage('jscs')">检索测试</button>
	<!-- <button onclick="showPage('lxcj')">类型(mapping)创建</button> -->
</div>
<table class="table-show" id="table-request">
	<caption><b class="b-title">请求地址：</b></caption>
	<tr>
		<td>
			<div id="div-request-jqjk" class="div-request-show">
				<a></a>
				<button onclick="showResultData('jqjk')">执行</button>
			</div>
				<div id="div-request-jdjk" class="div-request-show">
				<a></a>
				<button onclick="showResultData('jdjk')">执行</button>
			</div>
			<div id="div-request-syjk" class="div-request-show">
				<a></a>
				<button onclick="showResultData('syjk')">执行</button>
			</div>
			<div id="div-request-jscs" class="div-request-show">
				<a></a>
				<button onclick="showResultData('jscs')">执行</button>
			</div>
			<div id="div-request-lxcj" class="div-request-show">
				<a></a>
				<button onclick="showResultData('lxcj')">执行</button>
			</div>
			
		</td>
	</tr>
</table>
<table class="table-show" id="table-param">
	<caption><b class="b-title">请求参数：</b></caption>
	<tr>
		<td>
			<div id="div-param-jscs" class="div-param-show">
				<textarea>
				{
					'query' : {
						'match_all' : {}
					}
				}
				</textarea>
			</div>
			<div id="div-param-lxcj" class="div-param-show">
				<select id="es_index_mapping">
					<option value="qwjs">全文检索</option>
					<option value="xnda">虚拟档案</option>
				</select>
			</div>
		</td>
	</tr>
</table>
<table  class="table-show" id="table-result">
	<caption><b class="b-title">响应结果：</b></caption>
	<tr>
		<td>
			<div id="div-result-jqjk" class="div-result-show"></div>
			<div id="div-result-jdjk" class="div-result-show"></div>
			<div id="div-result-syjk" class="div-result-show"></div>
			<div id="div-result-jscs" class="div-result-show"></div>
			<div id="div-result-lxcj" class="div-result-show"></div>
		</td>
	</tr>
</table>

</body>


</html>