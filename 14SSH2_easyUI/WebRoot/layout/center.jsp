<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function addTab(node){
		if($("#layout_center_centerTab").tabs("exists",node.title)){
			$("#layout_center_centerTab").tabs("select",node.title);
		}else{
			$("#layout_center_centerTab").tabs("add",node);
		}
	}

</script>
<div id="layout_center_centerTab" class="easyui-tabs" data-options="fit:true">
</div>