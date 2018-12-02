<!DOCTYPE html>
<html>
<head>
	<title>登录</title>
    <#include "${request.contextPath}/common/global.ftl">
    <#include "${request.contextPath}/common/meta.ftl">
    <#include "${request.contextPath}/common/include-base-styles.ftl">
</head>

<body style="margin-top: 3em;">
	<center>
	<div style="width: 500px">
		<h2>第7章—Spring配套示例</h2>
		<form action="${request.contextPath}/user/logon" method="get">
			<table>
				<tr>
					<td width="80">用户名：</td>
					<td><input id="username" name="username" style="width: 100px" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input id="password" name="password" type="password" style="width: 100px" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						<button type="submit" class="btn btn-primary">登录系统</button>
					</td>
				</tr>
			</table>
		</form>

        <div class="row">
            <h5>登录失败时请用终端进入${request.contextPath}项目目录执行：<br/><code>mvn antrun:run -Pinit-db</code></h5>
            <hr />
            <h4 class="text-info">用户与角色列表（密码：000000）</h4>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>用户名</th>
                    <th>角色</th>
                    <th>部门</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>henry</td>
                    <td>系统管理员</td>
                    <th>IT部</th>
                </tr>
                <tr>
                    <td>2</td>
                    <td>bill</td>
                    <td>总经理</td>
                    <td>总经理室</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>jenny</td>
                    <td>人事经理</td>
                    <td>人事部</td>
                </tr>
                <tr class="success">
                    <td>4</td>
                    <td>kermit</td>
                    <td>部门经理</td>
                    <td>市场部</td>
                </tr>
                <tr class="success">
                    <td>5</td>
                    <td>eric</td>
                    <td>销售人员</td>
                    <td>市场部</td>
                </tr>
                <tr class="success">
                    <td>6</td>
                    <td>tom</td>
                    <td>销售人员</td>
                    <td>市场部</td>
                </tr>
                <tr class="info">
                    <td>7</td>
                    <td>andy</td>
                    <td>普通职员</td>
                    <td>业务部</td>
                </tr>
                <tr class="info">
                    <td>8</td>
                    <td>amy</td>
                    <td>普通职员</td>
                    <td>业务部</td>
                </tr>
                <tr class="danger">
                    <td>9</td>
                    <td>tony</td>
                    <td>财务人员</td>
                    <td>财务部</td>
                </tr>
                <tr class="danger">
                    <td>10</td>
                    <td>lily</td>
                    <td>出纳员</td>
                    <td>财务部</td>
                </tr>
                <tr>
                    <td>11</td>
                    <td>thomas</td>
                    <td>后勤人员</td>
                    <td>后勤部</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    </center>
</body>
</html>