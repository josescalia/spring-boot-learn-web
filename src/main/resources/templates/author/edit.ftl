<html>
<link rel="stylesheet" href="../css/style.css">
<head>
    <title>Simple Spring Boot Web Application</title>
</head>
<body>
    <form method="post">
        <table>
            <tr>
                <td><label for="id">Id</label></td>
                <td><input type="text" readonly id="id" name="id" value="${model.id}" ></td>
            </tr>

            <tr>
                <td><label for="authorName">Author Name</label></td>
                <td><input type="text" readonly id="authorName" name="authorName" value="${model.authorName}" ></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:right">
                    <input type="button" value="Save">
                    <button type="button" onclick="history.back()">Cancel</button>
                </td>
            </tr>
        </table>

    </form>
</body>
</html>