var app =  getApp().globalData;
const { $Message } = require('../dist/base/index');
// pages/order/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    showPayPwdInput: false,  //是否展示密码输入层
    pwdVal: '',  //输入的密码
    payFocus: true, //文本框焦点

    customerPhone:'',
    aid:'',
    serverName:'',
    storeName:'',
    day:'',

    curActive: 0,
    resArr:[],
    price:'',
    visible2:false,
    actions2: [
      {
        name: '微信支付',
        color: '#43a047'
      }
    ]
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    var reqTask = wx.request({
      url: app.server + '/wxApp/appointment/myAppointments',
      data: {
        myId: app.id
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        that.setData({
          resArr: result.data.data
        })

      },
      fail: () => { },
      complete: () => { }
    });
  },
 


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  waiting:function(){
    this.setData({
      curActive: 0
    })
  },
  serving: function () {
    this.setData({
      curActive:1
    })
   },
  finish: function () {
    this.setData({
      curActive: 2
    })
   },
  out: function () { 
    this.setData({
      curActive: 3
    })
  },
  edit: function(e){
    var item = e.target.dataset.item
    wx.navigateTo({
      url: '/pages/calendar/calendar?sid=' + item.sid + '&storeName=' + item.storeName + '&serveId=' + item.serverId + '&serveName=' + item.serverName + '&price=' + item.price + '&barberId=' + item.barberId + '&barberName=' + item.barberName + '&profile=' + item.barberAvatar + '&userPhone=' + item.barberPhone + '&day=' + item.day + '&aid=' + item.aid + '&note=' + item.note 
    })
  },
  cancel:function(e){
    var aid = e.target.dataset.aid
    var that = this
    wx.showModal({
      title: '取消预约',
      content: '确定要取消预约吗？',
      showCancel: true,
      cancelText: '取消',
      cancelColor: '#000000',
      confirmText: '确定',
      confirmColor: '#3CC51F',
      success: (result) => {
        if (result.confirm) {
          wx-wx.request({
            url: app.server+'/wxApp/appointment/cancel',
            data: {id:aid},
            header: {},
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {
              wx-wx.showToast({
                title: '取消成功',
                icon: '',
                image: '',
                duration: 1000,
                mask: true,
                success: function(res) {
                  var reqTask = wx.request({
                    url: app.server + '/wxApp/appointment/myAppointments',
                    data: {
                      myId: app.id
                    },
                    header: { 'content-type': 'application/json' },
                    method: 'GET',
                    dataType: 'json',
                    responseType: 'text',
                    success: (result) => {
                      that.setData({
                        resArr: result.data.data
                      })

                    },
                    fail: () => { },
                    complete: () => { }
                  });
                },
                fail: function(res) {},
                complete: function(res) {},
              })

            },
            fail: function(res) {},
            complete: function(res) {},
          })
        }
      },
      fail: () => { },
      complete: () => { }
    });
  },

  pay:function(e){
    var item = e.target.dataset.item
    var price = item.price
    var aid = item.aid
    var serverName = item.serverName
    var storeName = item.storeName
    var day = item.day
    var customerPhone = item.customerPhone
    console.log(e)
      this.setData({
        visible2: true,
        price: price,
        aid : item.aid,
        serverName:serverName,
        storeName:storeName,
        day:day,
        customerPhone:customerPhone
      });
  },
  handleCancel2() {
    this.setData({
      visible2: false
    });
  },
  handleClickItem2() {
    const action = [...this.data.actions2];
    action[0].loading = true;

    this.setData({
      actions2: action
    });
    this.showInputLayer();
    
  },

review:function(e){
  console.log(e)
  wx.navigateTo({
    url: '../review-create/index?item=' + JSON.stringify(e.target.dataset.item),
    success: function(res) {},
    fail: function(res) {},
    complete: function(res) {},
  })
},

seeReview:function(e){
  var id = e.target.dataset.item.rid
  wx.navigateTo({
    url: '../review-list/index?item='+JSON.stringify(e.target.dataset.item)+'&itemName=我&rid='+id,
  })
},

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this
    var reqTask = wx.request({
      url: app.server + '/wxApp/appointment/myAppointments',
      data: {
        myId: app.id
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        that.setData({
          resArr: result.data.data
        })

      },
      fail: () => { },
      complete: () => { }
    });
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
    var that = this
    var reqTask = wx.request({
      url: app.server + '/wxApp/appointment/myAppointments',
      data: {
        myId: app.id
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        that.setData({
          resArr: result.data.data
        })

      },
      fail: () => { },
      complete: () => { }
    });
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

  },
  redate:function(){
    wx.switchTab({
      url: '/pages/index/index',
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })
  },
  /**
  * 显示支付密码输入层
  */
  showInputLayer: function () {
    this.setData({ showPayPwdInput: true, payFocus: true });
  },
  /**
   * 隐藏支付密码输入层
   */
  hidePayLayer: function () {

    var val = this.data.pwdVal;

    this.setData({ showPayPwdInput: false, payFocus: false, pwdVal: '' }, function () {
      setTimeout(()=>{
        wx.showToast({
          title: '支付成功',
        })
      },1000)
     
    });

  },
  /**
   * 获取焦点
   */
  getFocus: function () {
    this.setData({ payFocus: true });
  },
  /**
   * 输入密码监听
   */
  inputPwd: function (e) {
    const action = [...this.data.actions2];
    this.setData({ pwdVal: e.detail.value });

    if (e.detail.value.length >= 6) {
    this.hidePayLayer();
    var that = this
    wx-wx.request({
      url: app.server+'/wxApp/appointment/pay',
      data: {
        aid: that.data.aid,
        storeName: that.data.storeName,
        serverName: that.data.serverName,
        customerPhone: that.data.customerPhone,
        day: that.data.day
      },
      header: {},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: function(res) {
        setTimeout(() => {
          action[0].loading = false;
          that.setData({
            visible2: false,
            actions2: action
          });
          $Message({
            content: '支付成功！正在跳转',
            type: 'success'
          });

        }, 1500);
        setTimeout(() => {
          wx.navigateTo({
            url: '../pay/index?price=' + that.data.price,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        }, 3000)
      },
      fail: function(res) {},
      complete: function(res) {},
    })

    }
  }
})
