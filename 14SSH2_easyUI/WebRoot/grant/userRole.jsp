<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#grant_userRole_datagrid').datagrid({
		    url:'userRole/getUserRole.action',
		    fitColumns:true,
		    fit:true,
			rownumbers : true,
			pageNumber : 1,
			idField : name,
			sortName:'id',
			sortOrder:'asc',
			striped : true,
			pagination : true,
			pagePosition : 'bottom',
			pageSize : 10,
			border:false,
			checkOnSelect:false,
			pageList : [ 5, 10, 15, 20, 25, 30 ],
		    columns:[[
		        {checkbox:true},
				{field:'id',title:'编号',width:150},
				{field:'name',title:'用户名',width:70},
				{field:'rows',title:'角色', width:300,fixed:true,resizable:true,rowspan:2,
					 formatter: function(value,rowData,index){
						var td = [];
						for(var r  in rowData.role){
							if(rowData.role[r].code == 1){
								td.push("<input type='checkbox' onclick='addOrDelRole(this)' checked value='" + rowData.role[r].id + "," +rowData.id  + "'/>" + rowData.role[r].name);
							}else{
								td.push("<input type='checkbox' onclick='addOrDelRole(this)' value='" + rowData.role[r].id + "," +rowData.id + "'/>" + rowData.role[r].name);
							}
						}
						return td.join("");
					}
				}
		    ]],
		    toolbar:'#grant_userRole_datagrid_toolbar',
		});
	});
	function searchUserRole(){
		var searchId = $("#grant_userRole_searchId").val();
 		if(searchId != ""){
 			$("#grant_userRole_datagrid").datagrid('load',{
 				searchId : searchId
 			});
 		}
 		$("#grant_userRole_searchId").val('');
	}
	function addOrDelRole(obj){
		 if(obj.checked){
			$.post("userRole/addUserRole.action",{"userRoleId":obj.value},
					function(data){
						$.messager.show({
							title:'提示',
							msg:data.msg,
							timeout:3000,
							showType:'slide'
						})
					},"json");
		}else{
			$.post("userRole/delUserRole.action",{"userRoleId":obj.value},
					function(data){
						$.messager.show({
							title:'提示',
							msg:data.msg,
							timeout:3000,
							showType:'slide'
						});
					},"json");
		} 
	} 
</script>
<div id="grant_userRole_datagrid">
</div>
	<div id="grant_userRole_datagrid_toolbar">
		<div class="datagrid-btn-separator"></div>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchUserRole()"></a>
		<input type="text" id="grant_userRole_searchId"/>
	</div>