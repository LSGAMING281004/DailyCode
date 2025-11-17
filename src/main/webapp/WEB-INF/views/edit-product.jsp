<html>
<head><title>Edit Product</title></head>
<body>

<h2>Edit Product</h2>

<form action="/product/save" method="post">
    <input type="hidden" name="id" value="${product.id}">
    Name: <input type="text" name="name" value="${product.name}"><br><br>
    Price: <input type="number" name="price" value="${product.price}"><br><br>
    Image URL: <input type="text" name="image" value="${product.image}"><br><br>
    Description: <textarea name="description">${product.description}</textarea><br><br>
    <button type="submit">Update</button>
</form>

</body>
</html>
