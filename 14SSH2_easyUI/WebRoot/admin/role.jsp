<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_role_datagrid').datagrid({
			url : 'role/getRole.action',
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
				title : 'name'
			}, {
				field : 'des',
				title : '描述',
				align : 'left'
			}, {
				field : 'code',
				title : '权限代码',
				align : 'left'
			}]],
			toolbar : "#admin_role_toolbar"
		})
	});
	function addRole() {
		$("#admin_role_regDialog").dialog('open');
	}
	function delRole() {
		var rows = $("#admin_role_datagrid").datagrid('getSelections');
		var ids = new Array();
		if (rows.length > 0) {
			for (var i = 0; i < rows.length; i++) {
				ids.push(rows[i].id);
			}
			$.ajax({
				url : "role/deleteRole.action",
				data : {
					ids : ids.join(",")
				},
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$("#admin_role_datagrid").datagrid("reload");
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
	function changeRole() {
		var row = $("#admin_role_datagrid").datagrid("getSelected");
		if (row != null) {
			$("#admin_role_changeForm input[name=id]").val(row.id);
			$("#admin_role_changeForm input[name=name]").val(row.name);
			$("#admin_role_changeForm input[name=des]").val(row.des);
			$("#admin_role_changeDialog").dialog('open');
		}
	}
	function searchFunRole() {
		var searchId = $("#admin_role_searchId").val();
		if (searchId != "") {
			$("#admin_role_datagrid").datagrid('load', {
				searchId : searchId
			});
		}
	}
</script>
<table id="admin_role_datagrid">
	<div id="admin_role_toolbar">
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-add',plain:true" onclick="addRole()">新增</a>
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-cancel',plain:true" onclick="delRole()">删除</a>
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-edit',plain:true" onclick="changeRole()">修改</a>
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left"
			data-options="iconCls:'icon-search',plain:true" onclick="searchFunRole()">查询</a>
		<input type="text" id="admin_role_searchId" />
	</div>
</table>
<div id="admin_role_changeDialog" class="easyui-dialog" title="修改"
	style="width:400px;height:200px;"
	data-options="iconCls:'icon-save',resizable:true,modal:true,closable:true,closed:true,
	buttons:[{
    	text:'修改',
    	iconCls:'icon-edit',
    	handler:function(){
    		$.ajax({
   				url:'role/changeRole.action',
   				data:{
   					id:$('#admin_role_changeForm input[name=id]').val(),
   					name:$('#admin_role_changeForm input[name=name]').val(),
   					des:$('#admin_role_changeForm input[name=des]').val()
   				},
   				dataType:'json',
   				success:function(data){
   					$('#admin_role_changeDialog').dialog('close');
   					if(data.success){
   						$('#admin_role_datagrid').datagrid('reload');
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
	<form id="admin_role_changeForm" method="post">
		<table>
			<input type="hidden" name="id" />
			<tr>
				<td>用户名:</td>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
			<tr>
				<td>描述:</td>
				<td><input name="des" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
		</table>
	</form>
</div>
<div id="admin_role_regDialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
    data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,
    buttons:[{
    	text:'新增',
    	iconCls:'icon-edit',
    	handler:function(){
    		$.ajax({
   				url:'role/addRole.action',
   				data:{
   					name:$('#admin_role_addRoleForm input[name=name]').val(),
   					des:$('#admin_role_addRoleForm input[name=des]').val()
   				},
   				dataType:'json',
   				success:function(data){
   					$('#admin_role_regDialog').dialog('close');
   					if(data.success){
   						$('#admin_role_datagrid').datagrid('reload');
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
    <form id="admin_role_addRoleForm" method="post">
		<table>
			<tr>
				<td>角色名：</td>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
			<tr>
				<td>角色描述:</td>
				<td><input name="des" class="easyui-validatebox"
					data-options="required:true" type="text" placeholder="角色描述"></input></td>
			</tr>
		</table>
	</form>
</div>