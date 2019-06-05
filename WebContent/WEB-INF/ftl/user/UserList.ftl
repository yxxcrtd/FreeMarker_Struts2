<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>在Struts2中使用FreeMarker模板</title>
	</head>

	<body>
	
  		<h2>用户列表（总用户数：<#if userList??>${userList?size}</#if>） - <a href="UserList.html" target="_blank">静态页面</a></h2>
  				
  		<table cellSpacing="1" style="width: 100%; border: 1px solid #E6DBC0; border-collapse: collapse;">
  			<thead>
	  			<tr>
					<th width="10%" style="border: 1px solid #E6DBC0;">ID</th>
					<th width="20%" style="border: 1px solid #E6DBC0;">用户名</th>
					<th width="30%" style="border: 1px solid #E6DBC0;">出生日期</th>
					<th width="20%" style="border: 1px solid #E6DBC0;">用户状态</th>
					<th width="20%" style="border: 1px solid #E6DBC0;">操作</th>
  				</tr>
  			</thead>
  			<tbody>
  				<#if userList??>
					<#list userList as u>
						<tr>
							<td style="border: 1px solid #E6DBC0; text-align: center;">${u.id!}</td><#--?string.currency-->
							<td style="border: 1px solid #E6DBC0; text-align: center;">${u.username!}</td>
							<td style="border: 1px solid #E6DBC0; text-align: center;">${u.birthday!?string("yyyy-MM-dd HH:mm:ss")}</td>
							<td style="border: 1px solid #E6DBC0; text-align: center;"><#if (u.status)>正常<#else>异常</#if></td>
							<td style="border: 1px solid #E6DBC0; text-align: center;"><a href="javascript:;">修改</a>&nbsp;&nbsp;<a href="javascript:;">删除</a></td>
						</tr>
					</#list>
				</#if>
  			</tbody>
  		</table>
  		
	</body>
</html>
