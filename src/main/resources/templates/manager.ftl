<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>FvGm</title>

    <link href="/static/assets/inspinia_v2.8/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/assets/inspinia_v2.8/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="/static/assets/inspinia_v2.8/css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="/static/assets/inspinia_v2.8/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="/static/assets/inspinia_v2.8/css/animate.css" rel="stylesheet">
    <link href="/static/assets/inspinia_v2.8/css/style.css" rel="stylesheet">

</head>

<body>
<div id="wrapper">
    <#include "layout/header.ftl">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>管理员管理</h2>
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <a href="index.html">首页</a>
                </li>
                <li class="breadcrumb-item active">
                    <strong>管理员管理</strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">

        </div>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <a style="color: #fff;" class="btn btn-primary" data-toggle="modal" data-target="#regModal">
                            <i class="fa fa-plus"></i>
                            新增
                        </a>
                        <div class="ibox-tools">

                        </div>
                    </div>
                    <div class="ibox-content">

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>用户名</th>
                                <#--<th>账户状态</th>-->
                                <th>创建时间</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list authUserList as item>
                                <tr>
                                    <td>${item_index+1}</td>
                                    <td>${item.name}</td>
                                    <#--<td>启用</td>-->
                                    <td>${item.createTime?number_to_datetime}</td>
                                    <td>${item.updateTime?number_to_datetime}</td>
                                    <td>
                                        <#--<a href="./updateManager?id=${item.id}" style="color: #fff;" class="btn btn-primary btn-xs">-->
                                        <a onclick="updateInfo('${item.id}')" style="color: #fff;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#updateModel">
                                            <i class="fa fa-pencil-square-o"></i>
                                            修改
                                        </a>
                                        <a href="./deleteManager?id=${item.id}" style="color: #fff;" class="btn btn-primary btn-xs">
                                            <i class="fa fa-trash-o"></i>
                                            删除
                                        </a>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <#include "layout/footer.ftl">
</div>

    <div class="modal fade" id="regModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="exampleModalLabel">新增管理员信息</h4>
                </div>
                <div class="modal-body">
                    <form id="addManager" action="./addManager" method="post">
                        <div class="form-group">
                            <label for="recipient-name" class="control-label">用户名:</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="control-label">密码:</label>
                            <input type="password" class="form-control" id="pwd" name="pwd">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addManager()">确认</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="updateModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="exampleModalLabel">修改管理员信息</h4>
                </div>
                <div class="modal-body">
                    <form id="updateManager" action="./doUpdateManager" method="post">
                        <input type="hidden" id="id" name="id" value="">
                        <div class="form-group">
                            <label for="recipient-name" class="control-label">用户名:</label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="control-label">密码:</label>
                            <input type="password" class="form-control" name="pwd">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="submitUpdate()">确认</button>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Mainly scripts -->
<script src="/static/assets/inspinia_v2.8/js/jquery-3.1.1.min.js"></script>
<script src="/static/assets/inspinia_v2.8/js/popper.min.js"></script>
<script src="/static/assets/inspinia_v2.8/js/bootstrap.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Flot -->
<script src="/static/assets/inspinia_v2.8/js/plugins/flot/jquery.flot.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/flot/jquery.flot.spline.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/flot/jquery.flot.resize.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/flot/jquery.flot.pie.js"></script>

<!-- Peity -->
<script src="/static/assets/inspinia_v2.8/js/plugins/peity/jquery.peity.min.js"></script>
<script src="/static/assets/inspinia_v2.8/js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="/static/assets/inspinia_v2.8/js/inspinia.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="/static/assets/inspinia_v2.8/js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- GITTER -->
<script src="/static/assets/inspinia_v2.8/js/plugins/gritter/jquery.gritter.min.js"></script>

<!-- Sparkline -->
<script src="/static/assets/inspinia_v2.8/js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="/static/assets/inspinia_v2.8/js/demo/sparkline-demo.js"></script>

<!-- Toastr -->
<script src="/static/assets/inspinia_v2.8/js/plugins/toastr/toastr.min.js"></script>
</body>
</html>
<script>
    function addManager() {
        $('#addManager').submit();
    }
    function updateInfo(id) {
        $('#id').val(id);
    }
    function submitUpdate() {
        $('#updateManager').submit();
    }
</script>
