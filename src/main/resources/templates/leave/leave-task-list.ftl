<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <#include "${request.contextPath}/common/global.ftl">
    <#include "${request.contextPath}/common/meta.ftl">
    <#include "${request.contextPath}/common/include-base-styles.ftl">
    <title>请假流程待办任务列表--chapter7</title>

    <script src="${request.contextPath}/js/common/jquery.js" type="text/javascript"></script>
</head>
<body>
	<#if message?? &&  message!= "">
	    <div id="message" class="alert alert-success">${message}</div>
		<!-- 自动隐藏提示信息 -->
		<script type="text/javascript">
            setTimeout(function () {
                $('#message').hide('slow');
            }, 5000);
        </script>
    </#if>
<table width="100%" class="table table-bordered table-hover table-condensed" style="margin-top: 5em;">
    <thead>
    <tr>
        <th>申请人</th>
        <th>类型</th>
        <th>请假时间</th>
        <th>请假原因</th>
        <th>任务ID</th>
        <th>任务名称</th>
        <th>流程实例ID</th>
        <th>流程定义ID</th>
        <th>任务创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
        <#list records as leave>
        <tr>
            <td>${leave.userId}</td>
            <td>${leave.leaveType}</td>
            <td>${leave.startTime}至<br/>${leave.endTime}</td>
            <td>${leave.reason}</td>
            <td>${leave.task.id }</td>
            <td>${leave.task.name }</td>
            <td>${leave.task.processInstanceId }</td>
            <td>${leave.task.processDefinitionId }</td>
            <td>${leave.task.createTime }</td>
            <td>
                <#if leave.task.assignee == "">
                     <a class="btn" href="claim/${leave.task.id}"><i class="icon-eye-open"></i>签收</a>
                </#if>
                <#if leave.task.assignee != "">
                    <a class="btn" href="view/${leave.task.id}"><i class="icon-user"></i>办理</a>
                </#if>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
</body>
</html>