const app = getApp()

let colorList = app.globalData.colorList

Component({
  externalClasses: ['v-class'],
  /**
   * 组件的属性列表
   */
  properties: {
    type:{
      type:String, // default primary info 
      value:'primary'
    },
    size: {
      type:String,
      vlaue: '' // 可选值为 small normal large 
    },
    shape: {
      type: String,
      value: 'circle' // 可选值为 circle 和 square
    },
    disabled1:{
      type:Number,
      value: 0
    },
    url: {
      type: String,
      value: ''
    },
    linkType: {
      type: String,
      value: 'navigateTo' //可选值为 navigateTo，redirectTo，switchTab，reLaunch
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    color: colorList
  },
  ready() {
 
  },
  /**
   * 组件的方法列表
   */
  methods: {
    handleClick() {
      this.triggerEvent('click')
    }
  }
})
