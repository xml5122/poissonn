

layui.use(['form', 'layedit', 'laydate'], function(){

    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;


    //监听提交
    form.on('submit(demo1)', function(data){
        var data = data.field;
        var result = login(data);
        return false;

    });


    function login(data) {
        $.ajax({
            url:'/login',
            method:'POST',
            data:data,
            dataType:'text',
            async: false,
            success:function(res){
                debugger;
               // window.location.href=res;
                layer.alert(res, {
                    title: res
                });
                return false;
            },
            error:function (data) {
                debugger;
            }
        }) ;
    }

});

