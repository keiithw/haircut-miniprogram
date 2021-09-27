// base/rate/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    list: {
      type:Array,
      value: ''
    }
  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {
    zoom: function (e) {
      console.log(e)
      wx - wx.previewImage({
        current: '',
        urls: [e.currentTarget.dataset.url],
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      })
    }
  }
})
