const app = getApp()

let colorList = app.globalData.colorList
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    title:{
      type:String, // 模态框名称
      value: ''
    },
    mode: {
      type:String,
      value:'modal'
    },
    type:{
      type: String,
      value: 'button'
    },
    show: {
      type:Boolean,
      value: false
    },
    position: {
      type: String,
      value: 'center' //可选值 center bottom top
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    color: colorList
  },

  /**
   * 组件的方法列表
   */
  methods: {
    hideModal() {
      this.setData({
        show: false
      })
      console.log(2)
    },
    outHideModal() {
      this.setData({
        show: false
      })
      console.log(1)
    },
    confirm() {
      this.triggerEvent('confirm')
    },
  }
})
