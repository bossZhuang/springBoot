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
                    <strong>
                        ${uid}用户详细信息
                    </strong>
                </li>
            </ol>
        </div>
        <div class="col-lg-2">

        </div>
    </div>

    <div class="wrapper wrapper-content animated fadeInRight">
        <#--resource-->
        <div class="row">
            <div class="col-lg-12">
                <#--<input type="hidden" id="curPage" name="curPage" value="1"/>-->
                <div class="ibox ">
                    <div class="ibox-title">
                        <#--<form action="./getPlayerInfoList?curPage=0" method="get">-->
                            <#--<input name="queryId" style="width: 200px;float: left;margin-right: 5px;" type="text" class="form-control form-control-sm m-b-xs" id="filter"-->
                                   <#--placeholder="根据ID搜索">-->
                            <#--<a style="color: #fff;height: 31px;" class="btn btn-primary">-->
                                <#--查询-->
                            <#--</a>-->
                        <#--</form>-->
                        玩家资源信息
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>玩家ID</th>
                                <th>饲料数</th>
                                <th>水数量</th>
                                <th>火数量</th>
                                <th>解锁区域ID</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>1</th>
                                <th>${resource.uid}</th>
                                <th>${resource.feed}</th>
                                <th>${resource.water}</th>
                                <th>${resource.fire}</th>
                                <th>${resource.unlockareas}</th>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <#--build-->
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        玩家建筑信息
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>建筑ID</th>
                                <th>建筑位置</th>
                                <th>建筑状态</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list buildings as building>
                            <tr>
                                <th>${building_index+1}</th>
                                <th>${building.buildid}</th>
                                <th>${building.pos}</th>
                                <th>${building.status}</th>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <#--crop-->
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        玩家作物信息
                    </div>
                    <div class="ibox-content">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>作物ID</th>
                                <th>作物位置</th>
                                <th>作物状态</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list crops as crop>
                            <tr>
                               <th>${crop_index+1}</th>
                               <th>${crop.cropid}</th>
                               <th>${crop.pos}</th>
                               <th>${crop.status}</th>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <#--item-->
        <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            玩家物品信息
                        </div>
                        <div class="ibox-content">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>物品ID</th>
                                    <th>物品数量</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list items as item>
                                <tr>
                                    <th>${item_index+1}</th>
                                    <th>${item.itemid}</th>
                                    <th>${item.count}</th>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        <#--animal-->
        <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            玩家动物信息
                        </div>
                        <div class="ibox-content">
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>动物ID</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list animals as animal>
                                <tr>
                                    <th>${animal_index+1}</th>
                                    <th>${animal.animalid}</th>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
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

</script>
