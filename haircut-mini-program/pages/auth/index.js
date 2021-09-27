// pages/auth/index.js
const { $Toast } = require('../dist/base/index');
const appInst = getApp();
Page({
 
  handleSuccess() {
    $Toast({
      content: '授权成功',
      type: 'success'
    });
  },

  /**
   * 页面的初始数据
   */
  data: {
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   
  },

  authClick: function(){
    var app= getApp()
    var that = this
    var temlIds = app.globalData.tmplIds
    wx.login({
      success(res) {
        var code = res.code;
        console.log("登陆成功" + res.code)

        if (code) {
          //获取用户信息
          console.log("获取用户信息")
          wx.getUserInfo({
            success: function (res) {
              console.log(res.userInfo)

              //请求服务器解密
              wx.request({
                method: 'POST',
                url: appInst.globalData.server + "/wxApp/login",
                header: {
                  'content-type': 'application/x-www-form-urlencoded'
                },
                data: {
                  code: code,
                  encryptedData: res.encryptedData,
                  iv: res.iv
                },
                fail: function (res) {
                  console.log("后端请求解密失败:" + res)
                  console.log(this.code + ',' + this.encryptedData + ',' + this.iv)
                },
                //获取解密成功
                success: (loginRes) => {
                  var loginData = loginRes.data.data
                  console.log("后端请求成功" + loginRes.data)
                  app.globalData.nickName = loginData.nickName
                  app.globalData.city = loginData.city
                  app.globalData.province = loginData.province
                  app.globalData.avatarUrl = loginData.avatarUrl
                  app.globalData.openId = loginData.openid
                  app.globalData.phone = loginData.phone
                  app.globalData.session_key = loginData.session_key
                  app.globalData.id = loginData.id
                  app.globalData.height = loginData.height
                  app.globalData.weight = loginData.weight
                  app.globalData.introduce = loginData.introduce
                  app.globalData.gender = loginData.gender
                  app.globalData.finishInfo = loginData.finishInfo

                  if (loginData.finish_info = 0) {
                    wx.redirectTo({
                      url: '../my-edit/index'
                    })
                    return;
                  } else {
                    wx.switchTab({
                      url: '../index/index',
                      success: function () {
                        that.handleSuccess()
                      }
                    })
                  }


                }
              })
            }
          })

        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
    })
  
    // 登录
  
   
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