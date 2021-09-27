// pages/stylists/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list:'',
    price:'',
    serveId:'',
    sid: '',
    serveName:'',
    storeName:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    var price = options.price
    var sid = options.sid
    var storeName= options.storeName
    var serveName = options.serveName
    var serveId = options.serveId
    wx - wx.getStorage({
      key: 'stylists',
      success: function (res) { 
        console.log(res)
        that.setData({
          list: res.data,
          price:price,
          sid:sid,
          serveId:serveId,
          serveName:serveName,
          storeName:storeName
      })
      },
      fail: function (res) { },
      complete: function (res) { },
    })
    wx.clearStorage('stylists');
  
    
  
    console.log(this.data.list)
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