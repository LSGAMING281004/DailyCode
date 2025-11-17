<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Products</title>
<style>
body{
background-color: #82C8E5;
}
div{
background-color: white;
border-radius: 15px;
}
</style>
</head>
<body>

<h2>Product List</h2>
<a href="product/add">Add Product</a>

<br><br>

<c:forEach var="p" items="${products}">
    <div style="border:1px solid; padding:10px; margin:10px;">
        <h3>${p.name}</h3>
        <p>Price: ${p.price}</p>
        <p>${p.description}</p>
        <img src="${p.image}" width="150">

        <br><br>
        <a href="product/edit/${p.id}">Edit</a> |
        <a href="product/delete/${p.id}">Delete</a>
    </div>
</c:forEach>

</body>
</html>
