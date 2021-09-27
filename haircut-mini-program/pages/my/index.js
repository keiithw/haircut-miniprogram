// pages/my/index.js
const app = getApp();
Page({
  
  /**
   * 页面的初始数据
   */
  data: {
  
    // user: {
      headImg:'',
      name:"Mr.wu",
      phone:"13902644883",
    // },
    prop:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 必须是在用户已经授权的情况下调用
    this.setData({
      headImg: app.globalData.avatarUrl,
      phone: app.globalData.phone
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  
  onReady: function () {

   
``
    // wx.request({
    //   url: 'http://192.168.0.103:8080/index/user',
    //   data: {

    //   },
    //   method: 'GET',
    //   header: {
    //     'content-type': 'application/json'
    //   },
    //   success: function (res) {
    //     console.log(res.data.name);
    //     var r=res.data;
    //     that.setData({
    //       name:r.name,
    //       phone:r.phone,
    //       headImg: profilePicUrl
    //     });
    //     console.log(profilePicUrl)
    
    //   },
    //   fail: function (res) {
    //     console.log(res.errMsg);
    //     console.log(profilePicUrl)
    //     that.setData({
    //       headImg: profilePicUrl
    //     });
    //   }
    // })

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    if (app.globalData.finishInfo == 0 || app.globalData.finishInfo==null)
      wx.redirectTo({
        url: '../my-edit/index',
        success: (result) => {

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
    this.setData({
      headImg: app.globalData.avatarUrl,
      phone: app.globalData.phone
    })
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