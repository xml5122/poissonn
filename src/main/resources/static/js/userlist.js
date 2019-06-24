layui.use('table', function(){
    debugger;
    var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#LAY_table_user'
        ,url: '/user/query'
        ,method:'post'
        ,contentType:'application/json'
        ,where:{username:'xianyu',name:"xianyu"}
        ,parseData: function(res){
            return {
                "data": res.data //解析数据列表
            };
        },
        done: function(res, curr, count){
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            console.log(res);

            //得到当前页码
            console.log(curr);

            //得到数据总量
            console.log(count);
        }
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
        ,height: 'full-20'
    });



    var $ = layui.$, active = {
        reload: function(){
            debugger;
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
        var data;

        $.ajax({
            type: "POST",
            url: "/user/query",
            data: {username:'xianyu', name:'xianyu'},
            dataType: "json",
            success: function(data){
                console.log(data.code);
                data = data.data;
            }
        });


        table.render({
            elem: '#LAY_table_user'
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
            ,data:data
        });
    });
});