<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="block m-t-xs font-bold">
                            <#if Session['account']??>
                                ${Session['account'].name}
                            <#else >
                                用户未登陆
                            </#if>
                        </span>
                        <#if Session['account']??>
                             <span class="text-muted text-xs block">管理员 <b class="caret"></b></span>
                        </#if>
                    </a>
                    <#--<ul class="dropdown-menu animated fadeInRight m-t-xs">-->
                        <#--<li><a class="dropdown-item" href="profile.html">Profile</a></li>-->
                        <#--<li><a class="dropdown-item" href="contacts.html">Contacts</a></li>-->
                        <#--<li><a class="dropdown-item" href="mailbox.html">Mailbox</a></li>-->
                        <#--<li class="dropdown-divider"></li>-->
                        <#--<li><a class="dropdown-item" href="login.html">Logout</a></li>-->
                    <#--</ul>-->
                </div>
                <div class="logo-element">
                    IN+
                </div>
            </li>
            <#--<#if account??>-->
                <li>
                    <a style="color: #a7b1c2;">
                        <i class="fa fa-th-large"></i>
                        <span class="nav-label">账户管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li class="active"><a href="./manager">管理员管理</a></li>
                    </ul>
                </li>
                <li>
                    <a style="color: #a7b1c2;">
                        <i class="fa fa-diamond"></i>
                        <span class="nav-label">玩家管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="./getPlayerInfoList">玩家基础信息</a>
                        </li>
                        <li>
                            <a href="./getPlayerLoginHistory">玩家登陆历史</a>
                        </li>
                        <li>
                            <a href="./getPlayerOrder">玩家支付订单</a>
                        </li>
                    </ul>
                </li>
            <#--</#if>-->
        </ul>

    </div>
</nav>
<div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                <form role="search" class="navbar-form-custom" action="search_results.html">
                    <div class="form-group">
                        <#--<input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">-->
                    </div>
                </form>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <li style="padding: 20px">
                    <span class="m-r-sm text-muted welcome-message">Welcome to INSPINIA+ Admin Theme.</span>
                </li>
                <li>
                    <a href="./logout">
                        <i class="fa fa-sign-out"></i> Log out
                    </a>
                </li>
            </ul>

        </nav>
    </div>
