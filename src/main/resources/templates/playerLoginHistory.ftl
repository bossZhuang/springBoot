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

    <link href="/static/assets/inspinia_v2.8/css/plugins/datapicker/datepicker3.css" rel="stylesheet">

    <style>
        .listTrClass{
            cursor: pointer;
        }
        .listTrClass:hover{
            background-color: #F5F5F6;
        }
        .commonTrHeadStyle{
            text-align: center;
        }
        .dateText{
            background-color: white;
            border-color: white;
            color: black;
            cursor: none;
        }
        .dateText:hover{
            background-color: white;
            border-color: white;
            color: black;
            cursor: none;
        }
    </style>
</head>
<body>
<div id="wrapper">
    <#include "layout/header.ftl">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>玩家登陆历史</h2>
            <ol class="breadcrumb">
                <li class="breadcrumb-item active">
                    <strong></strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">

        </div>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <input type="hidden" id="curPage" name="curPage" value="1"/>
                <div class="ibox ">
                    <div class="ibox-title">
                        <form action="./getPlayerLoginHistory" method="get">
                            <div class="input-group date" style="float: left;width: auto;">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="startTime" name="startTime" type="text" class="" value="" autocomplete="off">
                                <span class="btn btn-primary dateText" style="">
                                    开始时间
                                </span>
                            </div>
                            <div class="input-group date" style="float: left;width: auto;">
                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span><input id="endTime" name="endTime" type="text" class="" value="" autocomplete="off">
                                <span class="btn btn-primary dateText" style="margin-right: 10px;">
                                    结束时间
                                </span>
                            </div>
                            <input name="queryId" style="width: 200px;float: left;margin-right: 5px;" type="text" class="form-control form-control-sm m-b-xs" id="filter"
                                   placeholder="用户ID">
                            <button type="submit" style="color: #fff;height: 31px;" class="btn btn-primary">
                                查询
                            </button>
                        </form>
                    </div>
                    <div class="ibox-content">
                        <#if page??>
                        <table class="table table-bordered commonTrHeadStyle">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>玩家ID</th>
                                <th>玩家登陆时间</th>
                                <th>玩家登出时间</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list page.list as history>
                                <tr class="listTrClass">
                                    <th>${history_index+1}</th>
                                    <th>${history.uid}</th>
                                    <th>${history.time?number_to_datetime}</th>
                                    <th>${history.disconnect?number_to_datetime}</th>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                            <#--<#include "layout/page.ftl"/>-->
                        </#if>
                    </div>
                </div>
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

<#--date time picker-->
<script src="/static/assets/inspinia_v2.8/js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- Custom and plugin javascript -->
<script src="/static/assets/inspinia_v2.8/js/inspinia.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/pace/pace.min.js"></script>


<script src="http://fbrankcdn.rivergame.net/assets/js/modernizr-2.6.2.min.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/js/html5shiv.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/js/respond.min.js"></script>

</body>
</html>
<script>
    $(document).ready(function () {

        var mem = $('.input-group.date').datepicker({
            todayBtn: "linked",
            keyboardNavigation: false,
            forceParse: false,
            calendarWeeks: true,
            autoclose: true,
            format: 'yyyy-mm-dd',
        });
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        var now = year + '-' + month + '-' + day;
        // $('#startTime').val(now);
        // $('#endTime').val(now);
    })
</script>
