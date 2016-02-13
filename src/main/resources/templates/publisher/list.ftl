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
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <#list publisherList as publisher>
        <tr>
            <td style="text-align: center"><a href="edit?id=${publisher.id}">${publisher.id}</a></td>
            <td>${publisher.publisherName}</td>
        </tr>
    </#list>
    </tbody>
</table>


<p><a href="/">Back to Index</a> </p>
</body>
</html>