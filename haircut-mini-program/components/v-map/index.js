var QQMapWX = require('../../common/libs/qqmap-wx-jssdk.js')
const app = getApp().globalData;
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    full: {
      type: true, // true的话全屏显示
      value: ''
    },
    markers: {
      type: Array, // true的话全屏显示
      value: [
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
  }
  },
  /**
   * 组件的初始数据
   */
  data: {
    mapHeigth: '680rpx',
    longitude:'',
    latitude: '',
    markers: '',
  },
  ready() {
    
    if (this.properties.full) {
      this.setData({
        mapHeigth: '100%'
      })
    }


    let that = this;

    wx.getLocation({
      type: 'gcj02',

      success(res) {
        var latitude = res.latitude
        var longitude = res.longitude
        app.longitude = longitude
        app.latitude = latitude
        var speed = res.speed
        var accuracy = res.accuracy
        that.setData({
          longitude: res.longitude,
          latitude: res.latitude,
          speed: speed,
          accuracy: accuracy,
          markers: that.data.markers
        })
        console.log(that.data.markers)
      }
    })
  },
  moved() {

  },
  detached() {

  },
  /**
   * 组件的方法列表
   */
  methods: {
    handleMarker(e) {
      console.log(e)
    }
  }
})
