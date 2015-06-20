<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Biblioteka - zbiory</title>
</head>

<body>

<h1>Biblioteka - zbiory</h1>

<p><a href="/books/create"><b>Dodaj książkę</b></a></p>

<table border="1px" cellpadding="0" cellspacing="0" >

<thead>
<tr>
<th width="10%">ISBN</th><th width="15%">Tytuł</th><th width="10%">Akcje</th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books}">
<tr>
	<td>${book.isbn}</td>
	<td>${book.title}</td>
	<td>
	<a href="/books/${book.isbn}">Szczegóły</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="/">Strona główna</a></p>

</body>
</html>