layui.use('table', function(){
    var table = layui.table;

    //方法级渲染
    var option = ({
        elem: '#user'
        ,url: '/user/query'
        ,method:'post'
        ,where:{}
        ,contentType:'application/json'
        ,parseData: function(res){
            return {
                "code":res.code,
                "msg":res.msg,
                "count":res.count,
                "data": res.data
            };
        }
        ,cols: [[
            {field:'id', title: 'ID', width:'6%', sort: true, fixed: true,align:'center'}
            ,{field:'productName', title: '商品名称', width: '10%',align:'center'}
            ,{field:'productType', title: '商品类型', width: '10%',align:'center'}
            ,{field:'productPrice', title: '价格', width:'10%',align:'center'}
            ,{field:'productRecommendPrice', title: '建议出售价', width:'10%',align:'center'}
            ,{field:'productDesc', title: '商品描述', width:'10%',align:'center'}
            ,{field:'createBy', title: '创建人', width:'10%',align:'center'}
            ,{field:'createTime', title: '创建时间', width:'10%',templet:"<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd')}}</div>",align:'center'}
            ,{field:'remark', title: '备注',width:'12%',align:'center'}
            ,,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:'12%',align:'center'}
        ]]
        ,id: 'testReload'
        ,page: true
        ,height: 'full-50'
    });

    table.render(option);


    //搜索方法
    $('#search').on('click', function(){
        option.where.username = $('#username').val();
        option.where.name = $('#name').val();
        table.render(option);
    });

    //新增用户按钮
    $('#add').on('click', function(){
        title = '新增';
        layer.open({
           type:1,
            title:'新增用户',
            area: ['700px', '600px'],
            scrollbar:false,
            content:'<iframe id="userinfo" tab-id="userinfo" frameborder="0" src="../userinfo.html"  class="x-iframe" scrolling="no" width="600" height="500"  class="on" style="padding-top:30px;"></iframe>'
        });
    });

    //编辑和删除
    table.on('tool(user)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                debugger;
                $.ajax({
                    type: "GET",
                    url: "/user/delete",
                    data: {id:data.id},
                    dataType: "json",
                    success: function(data){
                        layer.msg(data.msg, {
                            time: 5000, //5s后自动关闭
                            btn: ['哦']
                        });
                    }
                });
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            json = JSON.stringify(data);
            title = '编辑';
            layer.open({
                type:1,
                title:'编辑',
                area: ['700px', '600px'],
                scrollbar:false,
                content: '<iframe id="userinfo" tab-id="userinfo" frameborder="0" src="../userinfo.html"  class="x-iframe" scrolling="no" width="600" height="500"  class="on" style="padding-top:30px;"></iframe>',
            });
        }
    });







});



layui.use('tree', function(){
    debugger;
    var tree = layui.tree
        ,layer = layui.layer
        ,util = layui.util;



    var data1 = [{
        title: '江西'
        ,id: 1
        ,children: [{
            title: '南昌'
            ,id: 1000
            ,children: [{
                title: '青山湖区'
                ,id: 10001
            },{
                title: '高新区'
                ,id: 10002
            }]
        },{
            title: '九江'
            ,id: 1001
        },{
            title: '赣州'
            ,id: 1002
        }]
    },{
        title: '广西'
        ,id: 2
        ,children: [{
            title: '南宁'
            ,id: 2000
        },{
            title: '桂林'
            ,id: 2001
        }]
    },{
        title: '陕西'
        ,id: 3
        ,children: [{
            title: '西安'
            ,id: 3000
        },{
            title: '延安'
            ,id: 3001
        }]
    }];


    //常规用法
    tree.render({
        elem: '#test1' //默认是点击节点可进行收缩
        ,data: data1
    });

});