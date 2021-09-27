// pages/review-list/index.js
var app = getApp().globalData
Page({

  /**
   * 页面的初始数据
   */
  data: {
    itemName: "美丽人生",
    rateList: [
      {
      customerName: 'Cat',
      star: 5,
      title: '不错',
      barberName: 'Robi',
      createdTime: '2019-04-03',
      serveName: "极致推油",
      customerAvatar: '/common/images/avatar.jpg',
      content: '服务周到，简洁方便，发型师贴心, 沟通到位, 环境干净'
    },
      {
        customerName: 'dog',
        star: 5,
        title: '爽死了',
        barberName: 'CUCU',
        createdTime: '2019-04-03',
        serveName: "雅致染烫",
        customerAvatar: '/common/images/avatar.jpg',
        content: '服务周到，简洁方便，发型师贴心, 沟通到位, 环境干净，66666'
      },
      {
        customerName: 'fish',
        star: 2,
        title: '糟糕透顶',
        barberName: '蔡徐坤',
        createdTime: '2019-04-03',
        serveName: "洗剪吹",
        customerAvatar: '/common/images/avatar.jpg',
        content: '呕了'
      }
    ]

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    var that = this;
    var sid = options.sid;
    var data;
    var url;
    if(options.rid!=null){
      url = app.server + '/wxApp/review/getById'
      wx - wx.request({
        url: url,
        data: { rid: options.rid },
        header: {},
        method: 'GET',
        dataType: 'json',
        responseType: 'text',
        success: function (res) {
          that.setData({
            itemName: options.itemName,
            rateList: res.data.data
          })
          console.log(that.data.rateList)
        },
        fail: function (res) { },
        complete: function (res) { },
      })
    }else{
      if (options.type === '1') {
        url = app.server + '/wxApp/review/barberReview'
      }
      else {
        url = app.server + '/wxApp/review/storeReview'
      }
      console.log(url)
      wx - wx.request({
        url: url,
        data: { sid: sid },
        header: {},
        method: 'GET',
        dataType: 'json',
        responseType: 'text',
        success: function (res) {
          that.setData({
            itemName: options.itemName,
            rateList: res.data.data
          })
          console.log(that.data.rateList)
        },
        fail: function (res) { },
        complete: function (res) { },
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