var addIndex;
var roomId;
var barberName;
var calendar;
var $ = layui.jquery;
var layer = layui.layer;
// var form = layui.form;
var laydate = layui.laydate;

var info1;

roomId = $('#0').attr("roomId");
var sid = $("#sid").val();
$("#0").css("backgroundColor", "#003399");
barberName = $('#0').text();


document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    calendar = new FullCalendar.Calendar(calendarEl, {
        plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
        defaultView: 'dayGridMonth',
        // defaultDate: '2019-05-07',
        selectable: true, // dataClick生效
        locale: 'zh-cn', // 设置中文
        eventLimit: 4, // 显示更多
        displayEventEnd: true, // 显示结束时间
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        events: {
            url: '/calendar/getByParams?sid='+$('#sid').val()+"&barberId="+roomId,
            type: 'GET',
            error: function() {
                alert('there was an error while fetching events!');
            }
        }
        //     [
        //     {
        //         title: 'Event1',
        //         start: '2020-02-01'
        //     },
        //     {
        //         title: 'Event2',
        //         start: '2020-03-05'
        //     }
        //     // etc...
        // ],

        ,eventClick: function(info) {
            console.log('eventClick ' + info);
            openEditLayer(info);
        }
        ,dateClick: function(info) {
            console.log('dateClick ' + info.dateStr);
            openLayer(info);
        }
        ,eventRender: function(info) {
            var tooltip = new Tooltip(info.el, {
                title: popContent(info.event.title, info.event.extendedProps.appointPerson, info.event.start, info.event.end, info.event.extendedProps.tel),
                placement: 'top',
                trigger: 'hover',
                container: 'body',
                html: true
            });
        }
    });

    calendar.render();
});

function popContent(title, appointPerson, stime, etime, tel) {
    var sDate =new Date(stime);
    var s = sDate.getHours() + '点' + sDate.getMinutes() + '分';
    var eDate =new Date(etime);
    var e = eDate.getHours() + '点' + eDate.getMinutes() + '分';
    var str = '<div style="font-weight: bold;">' + title + '</div>';
    str += '<div style="height: 1px;background-color: black;"></div>'
    str += '<div style="text-align: left;">预订人：' + appointPerson + '</div>';
    str += '<div style="text-align: left;">预订时间：' + s + ' -  ' + e + '</div>';
    str += '<div style="text-align: left;">预订电话：' + tel + '</div>'
    return str;
}





$(document).ready(function () {

});

function initDateCtrl() {
    //日期时间选择器
    laydate.render({
        elem: '#stime' //指定元素
        ,type: 'time'
        ,format: 'HH:mm'
        ,done: function(value, date){
            var etime = $("#etime").val();
            var ehour = parseInt(etime.split(":")[0]);
            var eminute = parseInt(etime.split(":")[1]);
            var hour = date.hours;
            var minute = date.minutes;
            if(ehour < hour) {
                $("#finishtime").val(value);
            } else {
                if(eminute < minute) {
                    $("#etime").val(value);
                }
            }
        }
    });

    //日期时间选择器
    laydate.render({
        elem: '#etime' //指定元素
        ,type: 'time'
        ,format: 'HH:mm'
        ,done: function(value, date){
            var stime = $("#stime").val();
            var shour = parseInt(stime.split(":")[0]);
            var sminute = parseInt(stime.split(":")[1]);
            var hour = date.hours;
            var minute = date.minutes;
            if(shour > hour) {
                $("#stime").val(value);
            } else {
                if(sminute > minute) {
                    $("#stime").val(value);
                }
            }
        }
    });
}



function openEditLayer(info){

    //通过$(document).ready(function(){})   简写 $(function(){})


    addIndex=layer.open({
        title : '<i class="fa fa-plus"></i>&nbsp;编辑日程',
        type : 1,
        fix : false,
        skin : 'layui-layer-rim',
        // 加上边框
        area : [ '470px', '450px' ],
        // 宽高
        content : $('#calendarForm').html(),
        success: function (layero, index) {
            initDateCtrl();
            $("#delEdit").show();

            var data = {};
            data.id = info.event.id;
            var sDate =new Date(info.event.start);
            data.stime = sDate.getHours() + ':' + sDate.getMinutes() ;
            var eDate =new Date(info.event.end);
            data.etime = eDate.getHours() + ':' + eDate.getMinutes() ;
            data.appointTheme = info.event.title;
            data.appointPerson = info.event.extendedProps.appointPerson;
            data.tel = info.event.extendedProps.tel;
            form.val('calendarForm', data);
            form.render();

            // 表单提交事件

        }
    });
    // layui.use('form', function(){
    //     var form = layui.form;
    //     form.render();
    // });
}


function openLayer(info){

    addIndex=layer.open({
        title : '<i class="fa fa-plus"></i>&nbsp;新增日程',
        type : 1,
        fix : false,
        skin : 'layui-layer-rim',
        // 加上边框
        area : [ '470px', '450px' ],
        // 宽高
        content : $('#calendarForm').html(),
        success: function (layero, index) {
            initDateCtrl();
            $("#barberId").val(roomId);
            $("#barberName").val(barberName);
            $("#delEdit").hide();
            // 表单提交事件
            info1 = info;
        }
    });

    layui.use('form', function(){
        var form = layui.form;
        form.render();
    });
}

$(function () {
    layui.use('form', function(){
        let form = layui.form;
        //监听提交
        form.on('submit(formSubmit)', function (d) {
            if (d.field.noon==1) {
                d.field.start = info1.dateStr+" "+"09:40:00";
                d.field.end = info1.dateStr+" "+"12:00:00";
            } else if (d.field.noon==2) {
                d.field.start = info1.dateStr+" "+"14:30:00";
                d.field.end = info1.dateStr+" "+"18:00:00";
            }else if (d.field.noon==3) {
                d.field.start = info1.dateStr+" "+"19:00:00";
                d.field.end = info1.dateStr+" "+"21:50:00";
            }else if (d.field.noon==4) {
                d.field.start = info1.dateStr+" "+"09:40:00";
                d.field.end = info1.dateStr+" "+"21:50:00";
            }
            $.ajax({
                type: 'POST',
                url: '/calendar/create',//发送请求
                contentType: "application/json; charset=utf-8",
                async: true,
                data: JSON.stringify(d.field),
                dataType: "json",
                success: function (res) {
                    layer.closeAll("loading");
                    if(res.code == 200){
                        //layer.msg("添加成功！", {icon: 1});
                        calendar.refetchEvents();
                        layer.closeAll('page');
                    }else{
                        layer.msg(res.msg, {icon: 2});
                    }
                }
            });
            console.log("提交");

            return false;
        });
    });
});

function changeRoom(id){
    $(".external-event").each(function(i){
        if(this.id==id){
            $(this).css("backgroundColor", "#003399");
            roomId = $(this).attr("roomId");
            barberName = $(this).text();
            console.log(barberName);
            console.log("....");
            console.log(roomId)
        }else{
            $(this).css("backgroundColor", "#3366CC");
        }
    });
    calendar.removeAllEventSources();
    var events= {
        url: '/calendar/getByParams?sid='+$('#sid').val()+"&barberId="+roomId,
            type: 'GET',
            error: function() {
            alert('there was an error while fetching events!');
        }
    };
    calendar.addEventSource(events);
}

function del(){
    var id=$("#id").val();
    layer.confirm('确定要删除吗？', {
        offset: '65px',
        title: '提示'
    }, function (i) {
        layer.close(i);
        layer.load(2);
        $.post("/erpcalendartask/deleteByID", {id: id}, function (res){
            layer.closeAll('loading');
            if(res.code == 200){
                // layer.msg("删除成功");
                calendar.refetchEvents();
                layer.closeAll('page');
            }else{
                layer.msg(res.message);
            }
        });
    });
}

// 所有ew-event
$('body').on('click', '*[ew-event]', function () {
    var event = $(this).attr('ew-event');
    if (event == 'closeDialog') {
        var id = $(this).parents('.layui-layer').attr('id').substring(11);
        layer.close(id);
    }
});