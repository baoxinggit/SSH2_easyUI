<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_module_datagrid').datagrid({
			url : 'module/getModule.action',
			fit : true,
			rownumbers : true,
			pageNumber : 1,
			idField : name,
			sortName:'id',
			sortOrder:'asc',
			striped : true,
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 10,
			pageList : [ 5, 10, 15, 20, 25, 30 ],
			columns : [[ {
				checkbox : true
			}, {
				field : 'id',
				order:'asc',
				title : '编号',
				width : 300
			}, {
				field : 'name',
				title : 'name',
			}]],
			toolbar : "#admin_module_toolbar"
		})
	});
	function addModule() {
		$("#admin_module_regDialog").dialog('open');
	}
	function delModule() {
		var rows = $("#admin_module_datagrid").datagrid('getSelections');
		var ids = new Array();
		if (rows.length > 0) {
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			$.ajax({
				url : "module/deleteModule.action",
				data : {
					ids : ids.join(",")
				},
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$("#admin_module_datagrid").datagrid("reload");
					}
					$.messager.show({
						title : "提示",
						msg : data.msg,
						timeout : 3000
					});
				}
			});
		}
	}
	function changeModule() {
		var row = $("#admin_module_datagrid").datagrid("getSelected");
		if (row != null) {
			$("#admin_module_changeForm input[name=id]").val(row.id);
			$("#admin_module_changeForm input[name=name]").val(row.name);
			$("#admin_module_changeDialog").dialog('open');
		}
	}
	function searchFunModule() {
		var searchId = $("#admin_module_searchId").val();
		if (searchId != "") {
			$("#admin_module_datagrid").datagrid('load', {
				searchId : searchId
			});
		}
	}
</script>
<table id="admin_module_datagrid">
	<div id="admin_module_toolbar">
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-add',plain:true" onclick="addModule()">新增</a>
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-cancel',plain:true" onclick="delModule()">删除</a>
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-edit',plain:true" onclick="changeModule()">修改</a>
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-search',plain:true" onclick="searchFunModule()">查询</a>
		<input type="text" id="admin_module_searchId" />
	</div>
</table>
<div id="admin_module_changeDialog" class="easyui-dialog" title="修改"
	style="width:400px;height:200px;"
	data-options="iconCls:'icon-save',resizable:true,modal:true,closable:true,closed:true,
	buttons:[{
    	text:'修改',
    	iconCls:'icon-edit',
    	handler:function(){
    		$.ajax({
   				url:'module/changeModule.action',
   				data:{
   					id:$('#admin_module_changeForm input[name=id]').val(),
   					name:$('#admin_module_changeForm input[name=name]').val()
   				},
   				dataType:'json',
   				success:function(data){
   					$('#admin_module_changeDialog').dialog('close');
   					if(data.success){
   						$('#admin_module_datagrid').datagrid('reload');
   					}
   					$.messager.show({
   						title:'提示',
   						msg:data.msg,
   						timeout:2000
   					});
	   			}
		    });
		}
	}]">
	<form id="admin_module_changeForm" method="post">
		<table>
			<input type="hidden" name="id" />
			<tr>
				<td>用户名:</td>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
		</table>
	</form>
</div>
<div id="admin_module_regDialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
    data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,
    buttons:[{
    	text:'新增',
    	iconCls:'icon-edit',
    	handler:function(){
    		$.ajax({
   				url:'module/addModule.action',
   				data:{
   					name:$('#admin_module_addModuleForm input[name=name]').val()
   				},
   				dataType:'json',
   				success:function(data){
   					$('#admin_module_regDialog').dialog('close');
   					if(data.success){
   						$('#admin_module_datagrid').datagrid('reload');
   					}
   					$.messager.show({
   						title:'提示',
   						msg:data.msg,
   						timeout:2000
   					});
	   			}
		    });
		}
    }]">
    <form id="admin_module_addModuleForm" method="post">
		<table>
			<tr>
				<td>模块名：</td>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
		</table>
	</form>
</div>