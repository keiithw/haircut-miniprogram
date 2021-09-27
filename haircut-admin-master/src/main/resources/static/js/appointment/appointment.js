/**
 * 用户管理
 */
var pageCurr;
var form;
$(function() {
    layui.use('table', function(){
        var table = layui.table;
        form = layui.form;

        tableIns=table.render({
            elem: '#appointList',
            url:'/appointment/listAppointment',
            method: 'post', //默认：get请求
            cellMinWidth: 80,
            page: true,
            request: {
                pageName: 'pageNum', //页码的参数名称，默认：pageNum
                limitName: 'pageSize' //每页数据量的参数名，默认：pageSize
            },
            response:{
                statusName: 'code', //数据状态的字段名称，默认：code
                statusCode: 200, //成功的状态码，默认：0
                countName: 'totals', //数据总数的字段名称，默认：count
                dataName: 'data' //数据列表的字段名称，默认：data
            },
            cols: [[
                {type:'numbers',initSort:'roleName'}
                ,{field:'aid', title:'预约号',align:'center'}
                ,{field:'customerName', title:'顾客名称',align:'center'}
                ,{field:'serverName', title:'预约服务' ,}
                ,{field:'barberName', title: '服务者',align:'center'}
                ,{field:'customerPhone', title:'顾客手机',align:'center'}
                ,{field:'day', title: '预约时间',align:'center'}
                ,{field:'price', title: '价格(元)',align:'center'}
                ,{field:'status', title: '状态',align:'center'}
                ,{field:'note', title: '备注',align:'center',hide:true}
                ,{title:'操作',align:'center', toolbar:'#optBar'}
            ]],
            done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                //console.log(res);
                //得到当前页码
                console.log(res.data);
                console.log(curr);

                $("[data-field='10']").children().each(function(){
                    console.log()
                });
                $("[data-field='status']").children().each(function(){

                    if($(this).text()=='-1'){
                        $(this).text("预约成功")
                        $(this).parents('tr').children("[data-field='10']").children().html(" <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">查看备注</a>\n" +
                            "\n" +
                            "            <a class=\"layui-btn layui-btn-xs\" lay-event=\"enterStore\" >入店</a>\n" +
                            "\n" +
                            "            <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">取消</a>")
                    }else if($(this).text()=='1'){
                        $(this).text("已到店")
                        $(this).parents('tr').children("[data-field='10']").children().html(" <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">查看备注</a>\n" +
                            "\n" + "            <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"pay\">线下支付</a>")
                    }else if($(this).text()=='2'){
                        $(this).text("已完成")
                        $(this).parents('tr').children("[data-field='10']").children().html(" <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">查看备注</a>\n")
                    }else if($(this).text()=='3'){
                        $(this).text("预约取消")
                        $(this).parents('tr').children("[data-field='10']").children().html(" <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\">查看备注</a>\n")
                    }

                });
                $("[data-field='sex']").children().each(function(){
                    if($(this).text()=='1'){
                        $(this).text("男")
                    }else if($(this).text()=='2'){
                        $(this).text("女")
                    }else if($(this).text()=='0'){
                        $(this).text("未知")
                    }
                });
                //得到数据总量
                //console.log(count);
                pageCurr=curr;
            }
        });


        var stuffs = JSON.parse($('#stuffs').val());
        console.log("渲染select");
        $('#barberId').append(new Option("所有",-555));
        for (var i=0;i<stuffs.length;i++){
            var option = new Option(stuffs[i].sysUserName,stuffs[i].id);
            $('#barberId').append(option);//往下拉菜单里添加元素

        }



        var status = JSON.parse($('#status').val());
        $('#statuss').append(new Option("所有",-555));
        for (var key in status) {
            var option = new Option(key,status[key]);
            console.log(key+"-"+status[key]);
            $('#statuss').append(option);//往下拉菜单里添加元素
        }

        form.render('select'); //这个很重要


        //监听工具条
        table.on('tool(userTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                //删除
                delUser(data,data.aid,data.customerName);
            } else if(obj.event === 'edit'){
                //编辑
                openUser(data,"编辑");
            }else if(obj.event === 'enterStore'){
                //恢复
                enterStore(data.aid,data);
            }else if(obj.event === 'pay'){
                //恢复
                pay(data.aid,data);
            }
        });

        //监听提交
        form.on('submit(userSubmit)', function(data){
            // TODO 校验
            formSubmit(data);
            return false;
        });
    });

    //搜索框
    layui.use(['form','laydate'], function(){
        var form = layui.form ,layer = layui.layer
            ,laydate = layui.laydate;
        //日期
        laydate.render({
            elem: '#startTime'
        });
        laydate.render({
            elem: '#endTime'
        });
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
    });
});





//提交表单
function formSubmit(obj){
    $.ajax({
        type: "POST",
        data: $("#userForm").serialize(),
        url: "/user/setUser",
        success: function (data) {
            if (data.code == 1) {
                layer.alert(data.msg,function(){
                    layer.closeAll();
                    load(obj);
                });
            } else {
                layer.alert(data.msg);
            }
        },
        error: function () {
            layer.alert("操作请求错误，请您稍后再试",function(){
                layer.closeAll();
                //加载load方法
                load(obj);//自定义
            });
        }
    });
}




//开通用户
function addUser(){
    openUser(null,"开通用户");
}
function openUser(data,title){
    console.log(data);
    if (data.note!=null)
        layer.alert(data.note);
    else
        layer.alert("暂无更多信息")
}

function delUser(obj,id,name) {
    var currentUser=$("#currentUser").html();
    console.log(obj);
    var phone = obj.customerPhone;
    var aid = obj.aid;
    if(null!=id){
        if(currentUser==id){
            layer.alert("对不起，您不能执行删除自己的操作！");
        }else{
            layer.confirm('您确定要取消'+name+'的预约吗？请提前联系该用户.', {
                btn: ['确认','返回'] //按钮
            }, function(){
                $.post("/appointment/cancel",{"aid":aid,"phone":phone},function(data){
                    if (data.code == 200) {
                        layer.alert("该预约已取消！",function(){
                            layer.closeAll();
                            load(obj);
                        });
                    } else {
                        layer.alert("系统错误！");
                    }
                });
            }, function(){
                layer.closeAll();
            });
        }
    }
}



//恢复
function enterStore(aid,obj) {
    if(null!=aid){
        layer.confirm('确认用户已经到店吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/appointment/enterStore",{"aid":aid},function(data){
                if (data.code == 200) {
                    layer.alert("用户入店成功!！",function(){
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}

function pay(aid,obj) {
    if(null!=aid){
        layer.confirm('确认用户已经支付吗？', {
            btn: ['确认','返回'] //按钮
        }, function(){
            $.post("/appointment/hasBeenPaid",{"aid":aid},function(data){
                if (data.code == 200) {
                    layer.alert(aid+"号订单已完成",function(){
                        layer.closeAll();
                        load(obj);
                    });
                } else {
                    layer.alert(data.msg);
                }
            });
        }, function(){
            layer.closeAll();
        });
    }
}


function load(obj){
    //重新加载table
    tableIns.reload({
        where:{
            aid:$('#aid').val(),
            customerPhone:$('#customerPhone').val(),
            barberId:$('#barberId').val(),
            status:$('#statuss').val(),
            startTime:$('#startTime').val(),
            endTime:$('#endTime').val(),
        },
        page: {
            curr: pageCurr //从当前页码开始
        }
    });
}

function cleanUser(){
    $("#username").val("");
    $("#mobile").val("");
    $("#password").val("");
    $('#roleId').html("");
}
