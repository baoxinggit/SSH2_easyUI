<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function(){
		$('#grant_roleCode_datagrid').datagrid({
		    url:'roleCode/getRoleCode.action',
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
				{field:'id',title:'编号',width:200},
				{field:'name',title:'角色名',width:200},
				{field:'des',title:'角色描述',width:200},
				{field:'module',title:'角色权限控制',width:200,
					 formatter: function(value,rowData,index){
						return "<a onclick='changeModule("+ rowData.id + ")'>更改权限</a>";
					}
				}
		    ]],
		    toolbar:'#grant_roleCode_datagrid_toolbar',
		});
	});
	function searchroleCode(){
		var searchId = $("#grant_roleCode_searchId").val();
 		if(searchId != ""){
 			$("#grant_roleCode_datagrid").datagrid('load',{
 				searchId : searchId
 			});
 		}
 		$("#grant_roleCode_searchId").val('');
	}
	function changeModule(roleId){
		$.ajax({
			type:"post",
			url:"roleModule/getRoleModule.action",		
			data:{"roleId":roleId},
			success:function(data){
				data = eval("(" + data + ")");
				var tbody = document.getElementById("dataFull");
				tbody.innerHTML = "";
				 for(var i = 0; i < data.total; i++){
					 var tr = document.createElement("tr");
					 var td = document.createElement("td");
					 var text = document.createTextNode(data.rows[i].name);
					 td.appendChild(text);
					 tr.appendChild(td);
					 var td2 = document.createElement("td");
					 var text2 = "";
					 if(data.rows[i].code - 8 >= 0){
						  text2 = text2 + "<input type='checkbox' checked value='8' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>増";
						  data.rows[i].code = data.rows[i].code - 8;
					 }else{
						 text2 = text2 + "<input type='checkbox' value='8' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>増 ";
					 }
					 if(data.rows[i].code - 4 >= 0){
						  text2 = text2 + "<input type='checkbox' checked value='4' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>删";
						  data.rows[i].code = data.rows[i].code - 4;
					 }else{
						 text2 = text2 + "<input type='checkbox' value='4' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>删" ;
					 }
					 if(data.rows[i].code - 2 >= 0){
						  text2 = text2 + "<input type='checkbox' checked value='2' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>改";
						  data.rows[i].code = data.rows[i].code - 2;
					 }else{
						 text2 = text2 + "<input type='checkbox' value='2' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>改 ";
					 }
					 if(data.rows[i].code - 1 >= 0){
						  text2 = text2 + "<input type='checkbox' checked value='1' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>查 ";
						  data.rows[i].code = data.rows[i].code - 1;
					 }else{
						 text2 = text2 + "<input type='checkbox' value='1' onclick='changeCode(this,"+roleId+","+data.rows[i].id+")'/>查 ";
					 }
					 console.log(text2);
					 td2.innerHTML = text2;
					 tr.appendChild(td2)
					 tbody.appendChild(tr);
				} 
			}
		});
		
		$("#defineDialog").show(800);
		$("#closeButton").bind("click",function(){
			$("#defineDialog").hide(500);
		});
	}
	function changeCode(obj,roleId,moduleId){
		if(obj.checked){
			$.ajax({
				type:"post",
				url:"roleModule/addRoleModule.action",
				data:{
					code:obj.value,
					roleId:roleId,
					moduleId:moduleId
				},
				dataType:"json",
				success:function(data){
					$.messager.show({
						title:'提示',
						msg:data.msg,
						timeout:3000,
						showType:'slide'
					})
				}
			});
		}else{
			$.ajax({
				type:"post",
				url:"roleModule/delRoleModule.action",
				data:{
					code:obj.value
				},
				dataType:"json",
				success:function(data){
					$.messager.show({
						title:'提示',
						msg:data.msg,
						timeout:3000,
						showType:'slide'
					})
				}
			});
		}
	}
</script>
<div id="grant_roleCode_datagrid">
</div>
<div id="grant_roleCode_datagrid_toolbar">
	<div class="datagrid-btn-separator"></div>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchroleCode()"></a>
	<input type="text" id="grant_roleCode_searchId"/>
</div>
