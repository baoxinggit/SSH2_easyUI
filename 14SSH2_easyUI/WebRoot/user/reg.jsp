<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#user_reg_regDialog").dialog('close');
		$("#user_reg_regForm").form({
			url: "user/reg.action",
			success: function(data){
				data = jQuery.parseJSON(data);
				if(data.success){
					$('#user_reg_regDialog').dialog('close');
		   			$('#admin_yhgl_datagrid').datagrid("reload");
				}
				$.messager.show({
					title:'提示',
					msg:data.msg,
					timeout:5000
				});
			}
		});
		$('#user_reg_regForm').bind("keyup",function(event){
			if("13" == event.keyCode){
				$('#user_reg_regForm').submit();
			}
		});
	});
	
</script>
<div id="user_reg_regDialog" class="easyui-dialog" title="注册"
	style="width:400px;height:200px;"
	data-options="iconCls:'icon-save',resizable:true,modal:true,closable:true,
		    buttons:[{
		    	text:'注册',
		    	iconCls:'icon-edit',
		    	handler:function(){
		    		$('#user_reg_regForm').submit();
		    	}
		    }]">
	<form id="user_reg_regForm" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input name="name" class="easyui-validatebox"
					data-options="required:true" type="text"></input></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input name="password" id="pwd" class="easyui-validatebox"
					data-options="required:true" type="password"></input></td>
			</tr>
			<tr>
				<td>再次输入密码:</td>
				<td><input class="easyui-validatebox"
					data-options="required:true,validType:'eqPwd[\'#pwd\']'"
					type="password"></input></td>
			</tr>
		</table>
	</form>
</div>