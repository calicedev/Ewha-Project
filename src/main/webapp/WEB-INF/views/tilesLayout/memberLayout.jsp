<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE HTML>
<html>
<head>
<tiles:insertAttribute name="include" />
</head>
<body>
		
		<tiles:insertAttribute name="body" ignore="true"/>
</body>
</html>