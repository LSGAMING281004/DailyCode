<html>
<head><title>Add Product</title></head>
<body>

<h2>Add Product</h2>

<form action="/product/save" method="post">
    Name: <input type="text" name="name"><br><br>
    Price: <input type="number" name="price"><br><br>
    Image URL: <input type="text" name="image"><br><br>
    Description: <textarea name="description"></textarea><br><br>
    <button type="submit">Save</button>
</form>

</body>
</html>
