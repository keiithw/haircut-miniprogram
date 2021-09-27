// pages/store-detail/index.js
const util = require('../../common/js/util.js');
var app =  getApp().globalData;

Page({

  /**
   * 页面的初始数据
   */
  data: {
    rateList:[{
      customerName:'Cat',
      star:5,
      title:'不错',
      barberName:'Robi',
      createdTime: '2019-04-03',
      serveName:"极致推油",
      customerAvatar: '/common/images/avatar.jpg',
      content: '该店还没有评价噢'
    }],
    serveList: [
      {
        id:0,
        description:'',
        name:'单剪',
        resting:0, //0工作中 1休息中
        workTime:'前面还有2人',
        price:15,
        cutting:2,
        originalPrice:98,
        picture:'/common/images/avatar.jpg'
      }
    ],
    id:'',
    sid:'',
    address:'',
    storeName:'',
    picture:'',
    latitude:'',
    longtitude:'',
    introduce:'',
    curActive: 0,
    toView:'',
    isOpen: false,
    star:0,
    showModal: false
  },
  handleOpen() {
    console.log(123)
    let state = this.data.isOpen
    this.setData({
      isOpen: !state
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  //参数传递
  onLoad: function (options) {
    console.log(options)
    this.setData({
      id:options.id,
      sid:options.sid,
      picture:options.picture,
      storeName:options.storeName,
      address:options.address,
      introduce:options.introduce,
      longtitude:options.longitude,
      latitude:options.latitude
    })
    app.sid = this.data.sid
    console.log(this.data.picture)
    
    var that = this
    var reqTask = wx.request({
      url: app.server+'/wxApp/listServer',
      data: {
        sid: this.data.sid
      },
      header: {'content-type':'application/json'},
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result)=>{
        that.setData({
          serveList : result.data.list
        })
      },
      fail: ()=>{},
      complete: ()=>{}
    });
    var id  = this.data.id
    //是否收藏
    wx-wx.request({
      url: app.server+"/wxApp/isStar",
      data: {
        customerId: app.id,
        targetId:id
      },
      header: {},
      method: 'POST',
      dataType: 'json',
      responseType: 'text',
      success: function(res) {
        if(res.data.code==200){
          that.setData({
            star:1
          })
        }
      },
      fail: function(res) {},
      complete: function(res) {},
    })
    wx-wx.request({
      url: app.server + "/wxApp/review/simpleReview",
      data: {sid: this.data.sid},
      header: {},
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: function(res) {
        if(res.data.data!='没有数据'){
          that.setData({
            rateList: res.data.data
          })
        }
  
      },
      fail: function(res) {},
      complete: function(res) {},
    })
  },

  jumpTo: function (e) {
    // 获取标签元素上自定义的 data-opt 属性的值
    let target = e.currentTarget.dataset.opt;
    console.log(target)
    this.setData({
      toView: target
    })
  },
//点击收藏
 star: function(event){
   console.log("收藏")
   console.log(event.currentTarget)
   var targetId = event.currentTarget.dataset.id
   var that = this
   wx-wx.request({
     url: app.server+'/wxApp/star',
     data: {
       customerId: app.id,
       targetId: targetId,
       isShop:1
     },
     header: {},
     method: 'POST',
     dataType: 'json',
     responseType: 'text',
     success: function (res) {
       if(res.data.code==200){
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
       }else{
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
     fail: function(res) {
       wx-wx.showToast({
         title: '收藏失败',
         icon: '',
         image: '',
         duration: 0,
         mask: true,
         success: function(res) {},
         fail: function(res) {},
         complete: function(res) {},
       })
     },
     complete: function(res) {},
   })
   
 },
//取消收藏
  unstar: function (event) {
    console.log("取消收藏")
    console.log(event.currentTarget)
    var targetId = event.currentTarget.dataset.id
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

 moreReview: function(){
   var sid = this.data.sid;
   var storeName = this.data.storeName
   wx.navigateTo({
     url: '../review-list/index?sid='+sid+'&itemName='+storeName,
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
    console.log(options)
    this.setData({
      sid: options.sid,
      picture: options.picture,
      storeName: options.storeName,
      address: options.address,
      introduce: options.introduce,
      longtitude: options.longtitude,
      latitude: options.latitude
    })
    app.sid = this.data.sid
    console.log(this.data.picture)

    var that = this
    var reqTask = wx.request({
      url: app.server + '/wxApp/listServer',
      data: {
        sid: this.data.sid
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        that.setData({
          serveList: result.data.list
        })
      },
      fail: () => { },
      complete: () => { }
    });
    var sid = this.data.sid
    //是否收藏
    wx - wx.request({
      url: app.server + "/wxApp/isStar",
      data: {
        customerId: app.id,
        targetId: sid
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
  openMap:function(){
    console.log('openmap')
    console.log(this.data.longtitude)
    wx-wx.navigateTo({
      url: '../store-map/index?longitude='+this.data.longtitude+'&latitude='+this.data.latitude,
      success: function(res) {},
      fail: function(res) {
        console.log('失败')
        console.log(res)
      },
      complete: function(res) {},
    })
  }
})