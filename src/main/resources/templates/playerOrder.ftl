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
    </style>
</head>
<body>
<div id="wrapper">
    <#include "layout/header.ftl">
    <div class="row wrapper border-bottom white-bg page-heading">
        <div class="col-lg-10">
            <h2>玩家订单</h2>
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
                <div class="ibox ">
                    <div class="ibox-title">
                        <form action="./getPlayerOrder" method="get">
                            <input name="queryId" style="width: 200px;float: left;margin-right: 5px;" type="text" class="form-control form-control-sm m-b-xs" id="filter"
                                   placeholder="根据玩家ID搜索">
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
                                    <th>订单ID</th>
                                    <th>玩家ID</th>
                                    <th>订单配置表ID</th>
                                    <th>充值农币数</th>
                                    <th>花费</th>
                                </tr>
                            </thead>
                            <tbody>
                                <#list page.list as order>
                                <tr class="listTrClass">
                                    <th>${order_index+1}</th>
                                    <th>${order.orderid?c}</th>
                                    <th>${order.playerid}</th>
                                    <th>${order.packageid}</th>
                                    <th>${order.amount}</th>
                                    <th>${order.gross}</th>
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


<!-- Custom and plugin javascript -->
<script src="/static/assets/inspinia_v2.8/js/inspinia.js"></script>
<script src="/static/assets/inspinia_v2.8/js/plugins/pace/pace.min.js"></script>


<script src="http://fbrankcdn.rivergame.net/assets/js/modernizr-2.6.2.min.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/js/html5shiv.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/js/respond.min.js"></script>
</body>
</html>
<script>
    function addGold(id) {
        $('#uidGold').val(id);
    }
    function addMoney(id) {
        $('#uidMoney').val(id);
    }
    function clickPlayer(uid) {
        console.log(uid);
        window.location.href = "./getPlayerDetailInfoById?uid="+uid;
    }
</script>
