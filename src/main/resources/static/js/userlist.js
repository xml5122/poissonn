layui.use('table', function(){
    var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#LAY_table_user'
        ,url: '/demo/table/user/'
        ,cols: [[
            {checkbox: true, fixed: true}
            ,{field:'id', title: 'ID', width:80, sort: true, fixed: true}
            ,{field:'username', title: '用户名', width:80}
            ,{field:'sex', title: '昵称', width:80, sort: true}
            ,{field:'city', title: '平台', width:80}
            ,{field:'sign', title: '店铺'}
            ,{field:'experience', title: '备注', sort: true, width:80}
        ]]
        ,id: 'testReload'
        ,page: true
        ,height: 750
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

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});