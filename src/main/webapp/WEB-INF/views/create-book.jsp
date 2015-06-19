<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Biblioteka - dodaj książkę</title>
</head>

<body>
<h1>Dodaj książkę</h1>
<form:form method="POST" commandName="book" action="/books/create">
<table>
<tbody>
	<tr>
		<td>ISBN</td>
		<td><form:input path="isbn" /></td>
	</tr>
	<tr>
		<td>Tytuł:</td>
		<td><form:input path="title" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Dodaj" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="/">Strona główna</a></p>
</body>
</html>