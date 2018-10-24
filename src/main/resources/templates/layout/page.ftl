<!-- 模态框（Modal） -->
<#if (page.count > page.pageSize) >
<div class="row">
    <div class="col-lg-6">
        <div aria-relevant="all" aria-live="polite" role="alert" id="example_info"
             class="dataTables_info">
            显示 1 到 ${page.pageSize} ，符合条件共 ${page.count} 条数据 ，当前页数 ${page.curPage}
        </div>
    </div>
    <div class="col-lg-6">
        <div id="example_paginate" class="dataTables_paginate paging_simple_numbers">
            <ul class="pagination">

                <#if (page.curPage > 1) >
                    <li tabindex="0" aria-controls="example" page="${1}"
                        class="paginate_button submitPageForm"><a
                            href="./getPlayerInfoList?curPage=1">首页</a></li>
                </#if>

                <#if (page.curPage > 1) >
                    <li id="example_上一页" tabindex="0" page="${page.curPage -1}" aria-controls="example"
                        class="paginate_button submitPageForm"><a href="./getPlayerInfoList?curPage=${page.curPage-1}">上一页</a></li>
                </#if>
                <#if (page.curPage > 2) >
                    <li tabindex="0" aria-controls="example" page="${page.curPage -2}"
                        class="paginate_button submitPageForm"><a
                            href="#./getPlayerInfoList?curPage=${page.curPage-2}>${page.curPage -2}</a></li>
                </#if>

                <#if (page.curPage > 1) >
                    <li tabindex="0" aria-controls="example" page="${page.curPage -1}"
                        class="paginate_button submitPageForm"><a
                            href="./getPlayerInfoList?curPage=${page.curPage-1}">${page.curPage -1}</a></li>
                </#if>
                <li tabindex="0" aria-controls="example" page="${page.curPage -1}"
                    class="paginate_button submitPageForm active"><a
                        href="./getPlayerInfoList?curPage=${page.curPage}">${page.curPage}</a></li>
                <#if (page.maxPage - page.curPage > 0) >
                    <li tabindex="0" aria-controls="example" page="${page.curPage +1}"
                        class="paginate_button submitPageForm"><a
                            href="./getPlayerInfoList?curPage=${page.curPage+1}">${page.curPage +1}</a></li>
                </#if>
                <#if (page.maxPage - page.curPage > 1) >
                    <li tabindex="0" aria-controls="example" page="${page.curPage +2}"
                        class="paginate_button submitPageForm"><a
                            href="./getPlayerInfoList?curPage=${page.curPage+2}">${page.curPage +2}</a></li>
                </#if>

                <#if (page.maxPage - page.curPage > 0) >
                    <li tabindex="0" aria-controls="example" page="${page.curPage +1}"
                        class="paginate_button submitPageForm"><a
                            href="./getPlayerInfoList?curPage=${page.curPage +1}">下一页</a></li>
                </#if>

                <#if (page.maxPage - page.curPage > 0) >
                    <li tabindex="0" aria-controls="example" page="${page.maxPage}"
                        class="paginate_button submitPageForm"><a
                            href="./getPlayerInfoList?curPage=${page.maxPage}">末页</a></li>
                </#if>
             </ul>
        </div>
    </div>
</#if>

