// pages/my-edit/index.js
var appInst =  getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
      nickName : '',
      sex: '',
      id: '',
      openId: '',
      phone: '',
      height:'',
      weight:'',
      introduce:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      nickName: appInst.globalData.nickName,
      sex: appInst.globalData.gender,
      id: appInst.globalData.id,
      openId: appInst.globalData.openId,
      phone: appInst.globalData.phone,
      introduce: appInst.globalData.introduce,
      height: appInst.globalData.height,
      weight: appInst.globalData.weight
    })
  },

  formSubmit: function(e){

    var that = this.data
    console.log(e.detail.value)

    var value = e.detail.value

    //加入本地缓存
   
   
 
   
    var reqTask = wx.request({
      url: appInst.globalData.server+'/wxApp/customer/setInfo',
      data: {
        id:value.id ,
        openId:value.openId,
        name:value.nickName,
        phone:value.phone,
        height:value.height,
        weight:value.weight,
        introduce:value.introduce,
        sex:value.sex
        },
      header: {'content-type':'application/json'},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: (result)=>{
        if(result.data.code == 200){
          console.log("保存成功")
          console.log(result)
          appInst.globalData.finishInfo = result.data.data.finishInfo
          appInst.globalData.phone = result.data.data.phone
          appInst.globalData.height = result.data.data.height
          appInst.globalData.weight = result.data.data.weight
          appInst.globalData.introduce = result.data.data.introduce
          wx-wx.showToast({
            title: '保存成功',
            icon: '',
            image: '',
            duration: 1000,
            mask: true,
            success: function(res) {},
            fail: function(res) {},
            complete: function(res) {},
          })
          setTimeout(()=>{
            wx - wx.switchTab({
              url: '../my/index',
              success: function (res) { },
              fail: function (res) { },
              complete: function (res) { },
            })
          },1000)
          
        }else{
          
        }
      },
      fail: (e)=>{
        console.log(e)
      },
      complete: ()=>{}
    });
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    console.log(this.data.nickName)
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