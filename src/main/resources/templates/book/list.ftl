<html>
<link rel="stylesheet" href="../css/style.css">
<head>
    <title>Simple Spring Boot Web Application</title>
</head>
<body>
<a href="#" class="tblAddNew">Add New</a>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
    </tr>
    </thead>
    <tbody>
    <#list bookList as book>
    <tr>
        <td style="text-align: center"><a href="edit?id=${book.id}">${book.id}</a></td>
        <td>${book.bookTitle}</td>
        <td>${book.author.authorName}</td>
        <td>${book.publisher.publisherName}</td>
    </tr>
    </#list>
    </tbody>
</table>


<p><a href="/">Back to Index</a> </p>
</body>
</html>