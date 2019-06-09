//JavaScript代码区域
layui.use('element', function(){
    var element = layui.element;

    var tab = {
        tabAdd:function(title,url,id){
            debugger;
            element.tabAdd('tabTest',{
                title: title,
                content: '<iframe id="'+"_"+id+'" tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="x-iframe" width="100%" height="750" class="on"></iframe>',
                id: id
            });
            element.render('tab', 'tabTest');
            var _id = "_"+id;
            var node = $("#"+_id).parent();
            var nodes = node.prevAll();
            if (nodes != null && nodes.length > 0) {
                for (var i = 0; i < nodes.length; i++) {
                    var css = nodes[i].getAttribute("class");
                    if (css.indexOf("layui-show") > -1){
                        nodes[i].removeAttribute("class");
                        nodes[i].setAttribute("class","layui-tab-item");
                    }
                }
            }
            
            node.addClass("layui-show");
            element.render('tab', 'tabTest');
        },
        tabDelete:function(othis){
            element.tabDelete('mainTab',id);
            othis.addClass('layui-btn-disabled');
        },
        tabChange:function(id){
            //切换到指定Tab项
            element.tabChange('mainTab', id); //切换到：用户管理
        }
    };


    element.on('nav(test)', function(data){
        debugger;
        var url = data.attr('_href');
        if (url == null || "undefined" == url) {
            return;
        }

        var title = data[0].innerText;
        if(title == null || "undefined" == title || "" == title){
            return;
        }

        var id = data.attr('id');

        tab.tabAdd(title,url,id);

    });



   /* $(".layui-nav-tree li").click(function(event){
        var url = $(this).children('a').attr('_href');
        var title = $(this).find('cite').html();
        var index  = $('.layui-nav-tree li').index($(this));
        //遍历打开的窗口，如果当前点击的选项已经打开，则跳转到对应窗口去，不再执行for外面的两条语句创建新窗口
        for (var i = 0; i <$('.x-iframe').length; i++) {
            if($('.x-iframe').eq(i).attr('tab-id')==index+1){
                tab.tabChange(index+1);
                event.stopPropagation();
                return;
            }
        };
        tab.tabAdd(title,url,index+1);
        tab.tabChange(index+1);
    });*/

});



//导航栏显示隐藏
var isShow = true;  //定义一个标志位
$('.kit-side-fold').click(function(){
    //选择出所有的span，并判断是不是hidden
    $('.layui-nav-item span').each(function(){
        if($(this).is(':hidden')){
            $(this).show();
        }else{
            $(this).hide();
        }
    });
    //判断isshow的状态
    if(isShow){
        $('.layui-side.layui-bg-black').width(60); //设置宽度
        $('.kit-side-fold i').css('margin-right', '70%');  //修改图标的位置
        //将footer和body的宽度修改
        $('.layui-body').css('left', 60+'px');
        $('.layui-footer').css('left', 60+'px');
        //将二级导航栏隐藏
        $('dd span').each(function(){
            $(this).hide();
        });
        //修改标志位
        isShow =false;
    }else{
        $('.layui-side.layui-bg-black').width(200);
        $('.kit-side-fold i').css('margin-right', '10%');
        $('.layui-body').css('left', 200+'px');
        $('.layui-footer').css('left', 200+'px');
        $('dd span').each(function(){
            $(this).show();
        });
        isShow =true;
    }
});