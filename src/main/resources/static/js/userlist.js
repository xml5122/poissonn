layui.use('table', function(){
    var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#LAY_table_user'
        ,url: '/user/query'
        ,cols: [[
            {checkbox: true, fixed: true}
            ,{field:'id', title: 'ID', width:80, sort: true, fixed: true}
            ,{field:'username', title: '用户名', width:200}
            ,{field:'name', title: '昵称', width:200}
            ,{field:'phone', title: '手机号码', width:200}
            ,{field:'email', title: '邮箱', width:200}
            ,{field:'role', title: '角色', width:200}
            ,{field:'remark', title: '备注',width:200}
        ]]
        ,id: 'testReload'
        ,page: true
        ,height: 600
    });

    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload');
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    key: {
                        id: demoReload.val()
                    }
                }
            }, 'data');
        }
    };

    //搜索方法
    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});