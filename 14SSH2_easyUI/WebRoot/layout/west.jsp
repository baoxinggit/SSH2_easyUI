<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="aa" class="easyui-accordion" data-options="fit:true">
    <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
    	<ul id="layot_west_tree" class="easyui-tree" data-options="
    		url:'menu/getTree.action',
    		selected:true,
    		animate:true,
    		onClick:function(node){
    			if(!node.state){
	    			addTab({
	    				title:node.text,
	    				href:node.attributes.url,
	    				closable:true
	    			});
    			}
    		}
    	">
		</ul>
    </div>
    <div title="Title2" data-options="iconCls:'icon-reload'" style="padding:10px;">
    </div>
</div>