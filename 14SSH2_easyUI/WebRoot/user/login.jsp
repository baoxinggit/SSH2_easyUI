<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$("#user_login_loginDialog").dialog({
			title : "登录",
			iconCls : 'icon-save',
			modal : true,
			resizable : true,
			buttons : [{
				text : "注册",
				iconCls : "icon-edit",
				handler : function() {
					$("#user_reg_regDialog").dialog('open');
					$("#user_login_loginDialog").dialog('close');
				}
			}, {
				text : "登录",
				iconCls : 'icon-ok',
				handler : function() {
					$("#user_login_loginForm").form('submit', {
						url : "user/login.action",
						success : function(data) {
							data = jQuery.parseJSON(data);
							if(data.success){
								$("#user_login_loginDialog").dialog('close');
							}
							$.messager.show({
								title:"提示",
								timeout:2000,
								msg:data.msg
							});
						}
					});
				}
			}]
		});
		$("#user_login_loginForm").form({
			url:"user/login.action",
			success:function(data){
				data = jQuery.parseJSON(data);
				if(data.success){
					$("#user_login_loginDialog").dialog('close');
				}
				$.messager.show({
					title:'提示',
					msg:data.msg,
					timeout:3000
				});
			}
		});
		$("#user_login_loginForm").bind("keyup",function(event){
			if( "13" == event.keyCode){
				$("#user_login_loginForm").submit();
			}
		});
	});
</script>
<div id="user_login_loginDialog">
	<form id="user_login_loginForm" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" autofocus="true" id="userName"
					name="name" class="easyui-validatebox"
					data-options="required:true,missingMessage:'用户名必填'" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="password" name="password"
					class="easyui-validatebox"
					data-options="required:true,missingMessage:'密码必填'" /></td>
			</tr>
		</table>
	</form>
</div>