// pages/calendar/calendar.js
var app = getApp().globalData
var util = require('../../common/js/util.js')
var today = util.getToday();
var date = new Date(); //0 表示1月
date.setDate(28)
date.setMonth(date.getMonth() + 1);
// 日期设置为0号, 0表示1号的前一天
let lastDay = date.setDate(0);
var d = new Date(lastDay)
var Y = d.getFullYear();
//获取月份  
var M = (d.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
//获取当日日期 
var D = d.getDate() < 10 ? '0' + date.getDate() : date.getDate();
var lastStr = Y + '-'+M+'-'+D
var choosedDate=''
const { $Message } = require('../dist/base/index');

Page({
  /**
    * 页面的初始数据
    */
  data: {
    day: '点击上面的绿点 (可预约日期)',
    tempDay:'',
    time: '点击下面可预约的时间段',
    start: '',
    end: '',
    top:'',
    bottom:'',
    dateMap:'',
    noonList:[{
      noonName:"本时段ta不上班..请君择日~",
      start:"去小绿点看看吧^^",
      end:""
    }],
    dotDays: [],
    dotColor: "#00bfa5",
    noonName:'下午',
    appointNumber:'',
    max:'',
    sid:'',
    storeName: '',
    serveId: '',
    serveName: '',
    price: '',
    barberId: '',
    barberName: '',
    barberAvatar: '',
    barberPhone: '',
    customerId:'',
    customerName:'',
    customerPhone: '',
    customerAvatar: '',
    note:'',
    tip:'',
    full:0,
    aid:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var sid = options.sid
    var storeName = options.storeName
    var serveId = options.serveId
    var serveName = options.serveName
    var price = options.price
    var barberId = options.barberId
    var barberName = options.barberName
    var barberAvatar = options.profile
    var barberPhone = options.userPhone
    var customerId= app.id
    var customerPhone = app.phone
    var customerAvatar = app.avatarUrl
    var customerName = app.nickName
    var day= options.day
    var aid = options.aid
    var note = options.note
    var that = this

    //获取请求参数
    that.setData({
      aid:aid,
      start: today,
      end: lastStr,
      sid:sid,
      day:day,
      storeName: storeName,
      serveId: serveId,
      serveName: serveName,
      price: price,
      barberId: barberId,
      barberName: barberName,
      barberAvatar: barberAvatar,
      barberPhone: barberPhone,
      customerPhone: customerPhone,
      customerAvatar: customerAvatar,
      customerId: customerId,
      customerName: customerName,
      note:note
    })
    var dots = []

    //请求  渲染dots
    var req = wx - wx.request({
      url: app.server + '/wxApp/calendar/getByParams',
      data: {
        start: this.data.start,
        end: this.data.end,
        barberId: options.barberId
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        var mObj = {};


        //遍历mObj
        // for (var pro in mObj) {
        //   if (mObj.hasOwnProperty(pro)) {
        //     console.log('key is ' + pro + ' and value is' + mObj[pro]);
        //   }
        // }
        console.log("请求结果")
        console.log(result.data)

        for (var i = 0; i < result.data.length; i++) {

          var s = result.data[i].start
          //yyyy-MM-dd
          s = s.replace(/ \d+(:\d+){2}/, '')
          var di = result.data[i]
          di.start = di.start.split(" ")[1].substring(0, 5)
          di.end = di.end.split(" ")[1].substring(0, 5)
          if (mObj.hasOwnProperty(s)) {
            var tempArr = mObj[s]
            tempArr.push(di)
            mObj[s] = tempArr
          } else {
            var arr = []
            arr.push(di)
            mObj[s] = arr
          }
          dots.push(s)
        }
        that.setData({
          dotDays: dots,
          dateMap: mObj
        })
        // console.log(that.data.dotDays)
        console.log(mObj)

      },
      fail: () => {
        wx - wx.showToast({
          title: '请求失败',
          icon: '',
          image: '',
          duration: 1000,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
      },
      complete: () => { }
    })
    console.log(sid,storeName,serveId,serveName,price,barberId,barberName,barberAvatar)
    

  },

clearTime:function(){
  this.setData({
    time:''
  })
},
  bindDateChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      day: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    console.log('picker发送选择改变，携带值为', e)
    var date = this.data.choosedDate
    var max = e.target.dataset.max
    var that =this
    console.log(max)
    if (this.data.dateMap.hasOwnProperty(date)) {
      this.setData({
        day: this.data.tempDay + " " + e.detail.value+":00",
        time: e.detail.value,
        max: max
      })
      var reqTask = wx-wx.request({
        url: app.server+'/wxApp/appointment/checkBusy',
        data: {
          "day":this.data.day,
          "barberId":this.data.barberId,
          "max":max
        },
        header: {},
        method: 'POST',
        dataType: 'json',
        responseType: 'text',
        success: function(res) {
          console.log(res.data)
          that.setData({
            tip:res.data.data.advice,
            full:res.data.data.full
          })
        },
        fail: function(res) { console.log(res)},
        complete: function(res) {},
      })
    }else{
      wx-wx.showToast({
        title: '此时段无法预约，换成有小绿点的工作日吧',
        icon: '',
        image: '',
        duration: 2000,
        mask: true,
        success: function(res) {},
        fail: function(res) {},
        complete: function(res) {},
      })
    }
    
  },
  onDayClick: function (e) {
    console.log(e)
    var date = e.detail.id
    var m = this.data.dateMap
    if (this.data.dateMap.hasOwnProperty(date)) {
      console.log(m[date])
      if(m[date].length!=0){
        this.setData({
          noonList: m[date]
        })
      }
    }else{
      this.setData({
        noonList: [{
          noonName: "本时段ta不上班..请君择日~",
          start: "去小绿点看看吧^^",
          end: ""
        }]
      })
      console.log("没有数据啊！")
    }
    this.setData({
      day: date,
      tempDay: date,
      time:'',
      tip:'',
      choosedDate: date
    })
  },
  bindOnMonthChange: function (e) {
    console.log(e)
  },


  formSubmit: function (e) {
    var that = this;
    var full = this.data.full
    var sid = this.data.sid
    var storeName = this.data.storeName
    var serveId = this.data.serveId
    var serveName = this.data.serveName
    var price = this.data.price
    var barberId = this.data.barberId
    var barberName = this.data.barberName
    var barberAvatar = this.data.profile
    var barberPhone = this.data.userPhone
    var customerPhone = this.data.phone
    var customerAvatar = this.data.customerAvatar
    var day = this.data.day
   
    var data = JSON.stringify(e.detail.value)
    console.log(data)
    if(full === 1){
      wx-wx.showToast({
        title: '时段预约已满',
        icon: '',
        image: '',
        duration: 2000,
        mask: true,
        success: function(res) {},
        fail: function(res) {},
        complete: function(res) {},
      })
    }else{
      wx.showModal({ //提交修改提示框
        title: '预约',
        content: '确定预约？多次失信会被拉入黑名单',//修改提示框标题
        success: function (res) {
          if (res.confirm) {
            //提示框确定以后
            wx - wx.request({
              url: app.server + '/wxApp/appointment/save',
              data: data,
              header: {},
              method: 'POST',
              dataType: 'json',
              responseType: 'text',
              success: function (res) {
                console.log(res)
                $Message({
                  content: '成功预约！正在跳转！',
                  type: 'success'
                });
                wx-wx.showToast({
                  title: '预约成功 !',
                  icon: '',
                  image: '',
                  duration: 1500,
                  mask: true,
                  success: function(res) {},
                  fail: function(res) {},
                  complete: function(res) {},
                })
                setTimeout(()=>{
                  wx - wx.switchTab({
                    url: '/pages/order/index',
                    success: function (res) { },
                    fail: function (res) { },
                    complete: function (res) { },
                  })
                },1500)
                
              },
              fail: function (res) { },
              complete: function (res) { },
            })
          } else if (res.cancel) {
            //console.log('用户点击取消')
          }
        }
      })

    }

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
 
})