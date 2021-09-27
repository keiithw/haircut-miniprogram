//index.js
//获取应用实例
const app = getApp()
const { $Toast } = require('../dist/base/index');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active: 0,
    markers:[],
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    banner: [
      {
        id: 0,
        type: 'image',
        url: '/common/images/banner01.png'
      },
      {
        id: 1,
        type: 'image',
        url: '/common/images/banner01.png'
      },
      {
        id: 2,
        type: 'image',
        url: '/common/images/banner01.png'
      }
    ],
    showModal: false,
     store: [
      {
        id:1,
        sysUserName:'百易广场工作室',
        price:'38',
        serverItem:'洗剪吹',
        distance: 192, 
        address:'龙华新区塘水围3区11栋4号铺',
        activity:'平台用户单，满30减3',
        activityType:1,
      },
    ]
  },
  handleChange({ detail }) {
    this.setData({
      active: detail.key
    })
  },
  handleSuccess() {
    $Toast({
      content: '授权成功',
      type: 'success'
    });
  },
  handleConfirm() {
    console.log('点击了确认')
    this.setData({
      showModal: false
    })
  },
  handleClick() {
    this.setData({
      showModal: true
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var latitudee = parseFloat(app.globalData.latitude) 
    var longitudee = parseFloat(app.globalData.longitude) 
    var that = this
    var reqTask = wx.request({
      url: app.globalData.server+'/wxApp/sysUser/listStore',
      data: {
        latitude: latitudee ,
        longitude:longitudee
      },
      header: {'content-type':'application/json'},
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result)=>{
        var resArr = result.data.data
  
        var markers = []
        var markerss = [
          {
            id: 0,
            latitude: 22.53332,
            longitude: 113.9644000000,
            iconPath: '/common/images/marker.png'
          },
          {
            id: 1,
            latitude: 22.53331,
            longitude: 115.8655000000,
            iconPath: '/common/images/marker.png'
          }

        ]
        for(var i=0;i<resArr.length;i++){
          var marker = {
            id: 0,
            longtitude: '',
            latitude: '',
            iconPath: 'https://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/map_marker_32.549356223176px_1185658_easyicon.net.png'
          }
          marker.id = i
          marker.longitude = parseFloat(resArr[i].longitude) 
          marker.latitude = parseFloat(resArr[i].latitude) 
          markers.push(marker)
        }
        that.setData({
          store : resArr,
          markers:markers
        })
        console.log(markers)
        console.log('商店列表')
        console.log(that.data.store)
      },
      fail: ()=>{},
      complete: ()=>{}
    });
  
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
    console.log(app.globalData)
    //初始化加载，先判断用户登录状态
    console.log("判断是否登录")

    wx.getSetting({
      success: function (res) {
        if (app.globalData.openId == '') {
          //未登录,跳转到登录页
          console.log("未登录 跳转中")
          wx.reLaunch({
            url: '../auth/index'
          })
        }
        else {
          console.log("已登录")
          wx.switchTab({
            url: 'index',
          })
        }
      }
    })

    
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
    var latitudee = parseFloat(app.globalData.latitude)
    var longitudee = parseFloat(app.globalData.longitude)
    var that = this
    var reqTask = wx.request({
      url: app.globalData.server + '/wxApp/sysUser/listStore',
      data: {
        latitude: latitudee,
        longitude: longitudee
      },
      header: { 'content-type': 'application/json' },
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result) => {
        var resArr = result.data.data

        var markers = []
        var markerss = [
          {
            id: 0,
            latitude: 22.53332,
            longitude: 113.9644000000,
            iconPath: '/common/images/marker.png'
          },
          {
            id: 1,
            latitude: 22.53331,
            longitude: 115.8655000000,
            iconPath: '/common/images/marker.png'
          }

        ]
        for (var i = 0; i < resArr.length; i++) {
          var marker = {
            id: 0,
            longtitude: '',
            latitude: '',
            iconPath: 'https://keithw-bucket.oss-cn-shenzhen.aliyuncs.com/images/map_marker_32.549356223176px_1185658_easyicon.net.png'
          }
          marker.id = i
          marker.longitude = parseFloat(resArr[i].longitude)
          marker.latitude = parseFloat(resArr[i].latitude)
          markers.push(marker)
        }
        that.setData({
          store: resArr,
          markers: markers
        })
        console.log(markers)
        console.log('商店列表')
        console.log(that.data.store)
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
    
  }
})