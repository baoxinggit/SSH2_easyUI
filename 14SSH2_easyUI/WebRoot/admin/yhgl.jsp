<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#admin_yhgl_datagrid').datagrid({
		    url:'user/getUser.action',
		    fit:true,
		    rownumbers:true,
		    pageNumber:1,
		    idField:name,
		    striped:true,
		    pagination:true,
		    pagePosition:'bottom',
		    pageSize:10,
		    pageList:[5,10,15,20,25,30],
		    columns:[[
				{checkbox:true},
				{field:'id',title:'编号',width:300},
				{field:'name',title:'name'},
				{field:'createTime',title:'createTime',align:'left'},
				{field:'modifyTime',title:'modifyTime',align:'left'},
				{field:'password',title:'password',align:'left'}
		    ]],
		   	toolbar:"#admin_yhgl_toolbar"
			})
		});
   		function add(){
   			$("#user_reg_regDialog").dialog("open");
   			$("#user_reg_regForm input").val('');
   		}
   		function del(){
   			var rows = $("#admin_yhgl_datagrid").datagrid('getSelections');
   			var ids = new Array();
   			if(rows.length>0){
   				for(var i = 0 ; i < rows.length;i++){
   					ids.push(rows[i].id);
   				}
	   			$.ajax({
	   				url:"user/del.action",
	   				data:{
	   					ids:ids.join(",")
	   				},
	   				dataType:"json",
	   				success:function(data){
	   					if(data.success){
	   						$("#admin_yhgl_datagrid").datagrid("load",{});
	   					}
	   					$.messager.show({
	   						title:"提示",
	   						msg:data.msg,
	   						timeout:3000
	   					});
	   				}
	   			});
   			}
   		}
   	 	function change(){
   			var row = $("#admin_yhgl_datagrid").datagrid("getSelected");
   			if(row != null){
	   			$("#admin_yhgl_changeForm input[name=id]").val(row.id);
	   			$("#admin_yhgl_changeForm input[name=name]").val(row.name);
	   			$("#admin_yhgl_changeForm input[name=password]").val('');
	   			$("#admin_yhgl_changeDialog").dialog('open');
   			}
   	 	}
   	 	function searchFun(){
   	 		var searchId = $("#admin_yhgl_searchId").val();
   	 		if(searchId != ""){
   	 			$("#admin_yhgl_datagrid").datagrid('load',{
   	 				searchId : searchId
   	 			});
   	 		}
   	 	}
</script>
<table id="admin_yhgl_datagrid">
	<div id="admin_yhgl_toolbar">
		<a href="#" class="easyui-linkbutton" style="float:left" data-options="iconCls:'icon-add',plain:true" onclick="add()">新增</a>
			<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left" data-options="iconCls:'icon-cancel',plain:true" onclick="del()">删除</a>
			<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left" data-options="iconCls:'icon-edit',plain:true" onclick="change()">修改</a> 
			<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" style="float:left" data-options="iconCls:'icon-search',plain:true" onclick="searchFun()">查询</a>
		<input type="text" id="admin_yhgl_searchId"/>
	</div>
</table>
<div id="admin_yhgl_changeDialog" class="easyui-dialog" title="修改"
	style="width:400px;height:200px;"
	data-options="iconCls:'icon-save',resizable:true,modal:true,closable:true,closed:true,
	buttons:[{
    	text:'修改',
    	iconCls:'icon-edit',
    	handler:function(){
    		$.ajax({
   				url:'user/change.action',
   				data:{
   					id:$('#admin_yhgl_changeForm input[name=id]').val(),
   					name:$('#admin_yhgl_changeForm input[name=name]').val(),
   					password:$('#admin_yhgl_changeForm input[name=password]').val()
   				},
   				dataType:'json',
   				success:function(data){
   					$('#admin_yhgl_changeDialog').dialog('close');
   					if(data.success){
   						$('#admin_yhgl_datagrid').datagrid('reload');
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
	<form id="admin_yhgl_changeForm" method="post">
		<table>
			<input type="hidden" name="id"/>
			<tr>
				<td>用户名:</td>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input name="password" class="easyui-validatebox"
					data-options="required:true" type="password" placeholder="请输入密码"></input></td>
			</tr>
		</table>
	</form>
</div>