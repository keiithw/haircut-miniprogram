const app = getApp().globalData
// pages/stylist-detail/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    stylist:{
      name:"Robi",
      level:'资深设计师',
      headImg: '/common/images/avatar.jpg',
      workPlace:'百易广场工作室',
      distance: '156m',
      workYear: 5,
      originPrice:98,
      price: 38
    },
    id:0,
    curActive: 0,
    star: 0,
    phone:'',
    name:'',
    introduce:'',
    profilePhoto:'',
    address:'',
    rateData: {
      rate:4.96,
      num:280
    },
    rateList: [{
      name: 'Cat',
      phone: '139****0154',
      star: 5,
      content: '不错',
      stylist: 'Robi',
      creatTime: '2019-04-03',
      headImg: '/common/images/avatar.jpg',
      label: '服务周到，简洁方便，发型师贴心, 沟通到位, 环境干净'
    }],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    var that = this
    this.setData({
      id:options.id,
      phone:options.phone,
      name:options.name,
      introduce: options.introduce,
      profilePhoto: options.profilePhoto,
      storeName: options.storeName
    })
    //是否收藏
    var reqTask=wx - wx.request({
      url: app.server + "/wxApp/isStar",
      data: {
        customerId: app.id,
        targetId: options.id
      },
      header: {},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        if (res.data.code == 200) {
          that.setData({
            star: 1
          })
        }
      },
      fail: function (res) { },
      complete: function (res) { },
    })
  },

  //点击收藏
  star: function (event) {
    console.log("收藏")
    console.log(event.currentTarget)
    var targetId = this.data.id
    var that = this
    wx - wx.request({
      url: app.server + '/wxApp/star',
      data: {
        customerId: app.id,
        targetId: targetId,
        isShop: 0
      },
      header: {},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        if (res.data.code == 200) {
          that.setData({
            star: 1
          })
          wx - wx.showToast({
            title: '收藏成功',
            icon: '',
            image: '',
            duration: 1500,
            mask: true,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        } else {
          wx - wx.showToast({
            title: '收藏失败',
            icon: '',
            image: '',
            duration: 0,
            mask: true,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        }

      },
      fail: function (res) {
        wx - wx.showToast({
          title: '收藏失败',
          icon: '',
          image: '',
          duration: 0,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
      },
      complete: function (res) { },
    })

  },
  //取消收藏
  unstar: function (event) {
    console.log("取消收藏")
    console.log(event.currentTarget)
    var targetId = this.data.id
    var that = this
    wx - wx.request({
      url: app.server + '/wxApp/unstar',
      data: {
        customerId: app.id,
        targetId: targetId
      },
      header: {},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: function (res) {
        if (res.data.code == 200) {
          that.setData({
            star: 0
          })
          wx - wx.showToast({
            title: '取消成功',
            icon: '',
            image: '',
            duration: 1500,
            mask: true,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        } else {
          wx - wx.showToast({
            title: '收藏失败',
            icon: '',
            image: '',
            duration: 0,
            mask: true,
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        }

      },
      fail: function (res) {
        wx - wx.showToast({
          title: '收藏失败',
          icon: '',
          image: '',
          duration: 0,
          mask: true,
          success: function (res) { },
          fail: function (res) { },
          complete: function (res) { },
        })
      },
      complete: function (res) { },
    })
  },

introduce:function(){
  this.setData({
    curActive:0
  })
},

  review: function () {
    var that =this
    wx-wx.request({
      url: app.server +'/wxApp/review/simpleBarberReview',
      data: {bid:this.data.id},
      header: {},
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: function(res) {
        that.setData({
          curActive:1,
          rateList:res.data.data
        })
      },
      fail: function(res) {},
      complete: function(res) {},
    })
    this.setData({
      curActive: 1
    })
    
  },

moreReview:function(){
  wx-wx.navigateTo({
    url: '../review-list/index?sid=' + this.data.id + '&itemName=' + this.data.name + '&type=' + '1',
    success: function(res) {},
    fail: function(res) {},
    complete: function(res) {},
  })
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