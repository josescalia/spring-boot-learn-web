<html>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<head>
    <title>Simple Spring Boot Web Application</title>
</head>
<body>
<div class="container">
<a href="#modalForm" class="btn btn-info btn-sm" data-toggle="modal" data-placement="top" >Add New</a>
<table class="table table-bordered table-striped table-condensed">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <#list authorList as author>
        <tr>
            <td style="text-align:center;"><a href="edit?id=${author.id}">${author.id}</a></td>
            <td>${author.authorName}</td>
            <td>${author.authorAddress}</td>
        </tr>
    </#list>
    </tbody>
</table>
<p><a href="/">Back to Index</a> </p>
</div>
<#--author form, hidden by default-->
<div class="modal fade" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true"
     style="overflow-y:auto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header" style="background-color:rgba(173, 216, 230, 0.17)">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"
                        style="margin:3px">&times;</button>
                <h4 class="text-center">Add New Author</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                <#include "_form.ftl">
                </form>
            </div>
            <div class="modal-footer">
                <a href="#" id="btnSave" class="btn btn-info btn-sm"><span
                        class="glyphicon glyphicon-floppy-disk"></span> Save</a>
                <a href="#" id="btnCancel" data-dismiss="modal" class="btn btn-danger btn-sm"><span
                        class="glyphicon glyphicon-step-backward"></span> Cancel</a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#btnSave").click(function(){
            $.post("/service/json/author/save", $("#modalForm").find("form").serialize(), function(jsonString){
                if(jsonString == "Save Succeed"){
                    alert(jsonString);
                    window.location.reload();
                }else{
                    alert(jsonString);
                }
            })
        })
    })
</script>
</body>
</html>