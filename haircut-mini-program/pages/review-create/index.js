// pages/review-create/index.js
var app = getApp().globalData
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fileList: [
      // Uploader 根据文件后缀来判断是否为图片文件
      // 如果图片 URL 中不包含类型信息，可以添加 isImage 标记来声明
      
    ],
    stars: 5,
    uid:0,
    customerName:'',
    customerAvatar:'',
    bid:0,
    barberName:'',
    sid:0,
    storeName:'',
    serveName:'',
    photo:''
  },

  afterRead(event) {
    const { file } = event.detail;
    var that = this
    // 当设置 mutiple 为 true 时, file 为数组格式，否则为对象格式
    wx.uploadFile({
      url: app.server+'/wxApp/uploadPhoto', // 仅为示例，非真实的接口地址
      filePath: file.path,
      name: 'file',
    
      success(res) {
        // 上传完成需要更新 fileList
       var obj =  JSON.parse(res.data)
        var fileList = []
        fileList.push({ ...file, url: res.data.path });
        that.setData({ 
          fileList:fileList,
          photo:obj.path
           });
      
      }
    });
  },
  delete:function(){
    this.setData({
      fileList:[],
      photo:''
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(JSON.parse(options.item))
    var item = JSON.parse(options.item)
    this.setData({
      uid: item.customerId,
      bid: item.barberId,
      barberName: item.barberName,
      sid: item.sid,
      aid:item.aid,
      serveName:item.serverName,
      customerName:item.customerName,
      customerAvatar:item.customerAvatar
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  formSubmit:function(e){
    console.log(e)
    var data = e.detail.value
    wx-wx.request({
      url: app.server+'/wxApp/review/create',
      data: data,
      header: {},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: function(res) {
        console.log(res)
        wx.showToast({
          title: '评价成功,跳转中',
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
            url: '/pages/index/index',
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        },1000)
      
      },
      fail: function(res) {},
      complete: function(res) {},
    })
  },
  onChange1(e) {
    const index = e.detail.index;
    this.setData({
      'stars': index
    })
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