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
            <h2>游戏用户信息</h2>
            <ol class="breadcrumb">
                <li class="breadcrumb-item active">
                    <strong>用户基本信息</strong>
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
                        <form action="./getPlayerInfoList?curPage=0" method="get">
                            <input name="queryId" style="width: 200px;float: left;margin-right: 5px;" type="text" class="form-control form-control-sm m-b-xs" id="filter"
                                   placeholder="根据ID搜索">
                            <input name="queryName" style="width: 140px;float: left;margin-right: 5px;" type="text" class="form-control form-control-sm m-b-xs" id="filter"
                                   placeholder="根据昵称查询">
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
                                <th class="commonTrHeadStyle" style="width: 143px;">玩家ID</th>
                                <th class="commonTrHeadStyle" style="width: 45px;">昵称</th>
                                <th class="commonTrHeadStyle" style="width: 150px;">注册时间</th>
                                <th class="commonTrHeadStyle" style="width: 157px;">上次登陆时间</th>
                                <th class="commonTrHeadStyle" style="width: 157px;">上次登出时间</th>
                                <th class="commonTrHeadStyle" style="width: 105px;">登录ip</th>
                                <th class="commonTrHeadStyle" style="width: 72px;">总经验值</th>
                                <th class="commonTrHeadStyle" style="width: 45px;">等级</th>
                                <th class="commonTrHeadStyle" style="width: 60px;">金币数</th>
                                <th class="commonTrHeadStyle" style="width: 60px;">农币数</th>
                                <th class="commonTrHeadStyle">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list page.list as player>
                                <tr class="listTrClass">
                                    <th onclick="clickPlayer('${player.uid}')">${player_index+1}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.uid}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.name}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.regtime?number_to_datetime}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.lastlogintime?number_to_datetime}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.lastlogouttime?number_to_datetime}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.ip}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.exp}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.level}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.gold}</th>
                                    <th onclick="clickPlayer('${player.uid}')">${player.money}</th>
                                    <th>
                                        <a onclick="addGold('${player.uid}')" style="color: #fff;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addGoldModel">
                                            加金币
                                        </a>
                                        <a onclick="addMoney('${player.uid}')" style="color: #fff;" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#addMoneyModel">
                                            加农币
                                        </a>
                                        <a onclick="reset('${player.uid}')" style="color: #fff;" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#sureReset">
                                            删除
                                        </a>
                                    </th>
                                </tr>
                                </#list>
                            </tbody>
                        </table>
                            <#include "layout/page.ftl"/>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<div class="modal fade" id="addGoldModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">增加金币</h4>
            </div>
            <div class="modal-body">
                <form id="addGold" action="./addGold" method="post">
                    <input type="hidden" id="uidGold" name="uid" value="">
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">增加金币数:</label>
                        <input type="text" class="form-control" id="gold" name="gold">
                    </div>
                    <div class="modal-footer" style="border-top: none;">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">确认</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addMoneyModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">增加农币</h4>
            </div>
            <div class="modal-body">
                <form action="./addMoney" method="post">
                    <input type="hidden" id="uidMoney" name="uid" value="">
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">增加农币数:</label>
                        <input type="text" class="form-control" id="money" name="money">
                    </div>
                    <div class="modal-footer" style="border-top: none;">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">确认</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 信息删除确认 -->
<div class="modal fade" id="sureReset">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
            </div>
            <div class="modal-body">
                <p>您确认要删除吗？</p>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="uidReset"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a onclick="sureReset()" style="color: white;" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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

    function reset(id) {
        $('#uidReset').val(id);
    }
    function sureReset() {
        var uid = $('#uidReset').val();
        console.log(uid);
        window.location.href = "./reset?uid="+uid;
    }
</script>
