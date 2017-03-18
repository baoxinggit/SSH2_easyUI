<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<style type="text/css">
	#defineDialog{
		   position: fixed;
		   border-radius: 10%;
		   margin-left: 25%;
		   margin-top: 3%;
		   width: 50%;
		   height: 80%;
		   background-color: highlight;
		   display: none;
		   overflow: auto;
		   z-index: 999;
	}
	#closeButton{
		    background-image: url(${ctx}/jslib/jquery-easyui-1.3.1/themes/icons/no.png);
		    width: 50px;
		    height: 50px;
		    display: block;
		    position: absolute;
		    background-repeat: no-repeat;
		    right: 6px;
		    top: 2px;
		    border-radius: 50%;
		    background-position: 10px;
	}
</style>
<div id="defineDialog">
	<div id="closeButton">
	</div>
	<table style="width: 100%;top: 50px;position: absolute;left: 10%;border: 2px;">
		<tr>
			<td>模块名</td>
			<td>模块权限</td>
		</tr>
		<tbody id="dataFull" >
		</tbody>
	</table>
</div>