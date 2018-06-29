<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${initParam.appName}</title>
</head>
<body>
<form:form modelAttribute="user">
	<table>
		<caption>${msg}</caption>
		<tr>
			<td><form:label path="username">用户名称：</form:label></td>
			<td><form:input path="username"/><form:errors path="username"/></td>
		</tr>	
		<tr>
			<td><form:label path="password">用户口令：</form:label></td>
			<td><form:password path="password"/><form:errors path="password"/></td>
		</tr>	
		<tr>
			<td colspan="2">
				<input type="submit" value="登录系统"/>
				<input type="reset" value="重置数据"/>
			</td>
		</tr>		
	</table>
</form:form>
</body>
</html>