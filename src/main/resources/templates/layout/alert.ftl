<!--删除按钮的弹窗-->
<link rel="stylesheet" href="../css/BeAlert.css">
<script src="http://fbrankcdn.rivergame.net/assets/js/jquery-1.10.2.min.js"></script>
<script src="./js/BeAlert.js"></script>
<script src="./js/c.ajax.js"></script>
<script>
    /*<!--删除按钮的弹窗start-->*/
    $(".confirm").click(function () {
        var url = $(this).attr("url");
        var id = $(this).attr("delId");
        var info = $(this).attr('info');
        confirm("您确定操作这条记录吗?", info ? info : "操作不可撤销，请您谨慎操作!", function (isConfirm) {
            if (isConfirm) {
                $.post("../admin/" + url, {'id': id}, function (data) {
                    if (data.code == 200) {
                        confirm("系统信息", "更新成功", function () {
                            window.location.reload();
                        });
                    } else {
                        if (data.message) {
                            console.info(data.message)
                            alert("错误信息", data.message)
                        }

                    }
                }, 'json')
            }
        }, {confirmButtonText: '删除', cancelButtonText: '取消', width: 300});
    });
    <#if success??>
    confirm("信息更新成功", "");
    </#if>

    <#if error??>
    confirm("信息更新失败:${error}");
    </#if>
    /* <!--删除按钮的弹窗end-->*/
</script>
<!--Global JS-->
<script src="http://fbrankcdn.rivergame.net/assets/js/jquery-1.10.2.min.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/plugins/waypoints/waypoints.min.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/plugins/nanoScroller/jquery.nanoscroller.min.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/js/application.js"></script>
<!--Page Leve JS -->
<script src="http://fbrankcdn.rivergame.net/assets/plugins/dataTables/js/jquery.dataTables.js"></script>
<script src="http://fbrankcdn.rivergame.net/assets/plugins/dataTables/js/dataTables.bootstrap.js"></script>