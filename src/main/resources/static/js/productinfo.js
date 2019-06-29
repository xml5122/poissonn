layui.use('form', function(){

    var form = layui.form;

    //权限下拉框动态赋值
    $.ajax({
        type: "GET",
        url: "/user/role",
        success: function(data){
            $.each(data.data, function (index, item) {
                $("[name='role']").append(new Option(item.value, item.code));// 下拉菜单里添加元素
            });
            layui.form.render("select");
        }
    });


    //点击编辑时 给表单赋值父页面的值
    if (parent.title == "编辑"){
        var parent_json = eval('('+parent.json+')');
        if (parent_json != null){
            form.val("userinfo", parent_json);
        }
    }


    //监听提交
    form.on('submit(formDemo)', function(data){
        layer.msg(JSON.stringify(data.field));
        return false;
    });
});

layui.use('upload', function() {
    var $ = layui.jquery
        , upload = layui.upload;

    //普通图片上传
    var uploadInst = upload.render({
        elem: '#test1'
        , url: '/upload/'
        , before: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#demo1').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功
        }
        , error: function () {
            //演示失败状态，并实现重传
            var demoText = $('#demoText');
            demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
            demoText.find('.demo-reload').on('click', function () {
                uploadInst.upload();
            });
        }
    });
});