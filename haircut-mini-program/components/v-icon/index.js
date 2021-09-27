const app = getApp()

let colorList = app.globalData.colorList

Component({
  externalClasses: ['v-class'],
  /**
   * 组件的属性列表
   */
  properties: {
    type: {
      type: String,
      value: 'info'
    },
    icon: { // 指定icon
      type: String,
      value: '' 
    },
    size:{
      type:String,
      value: '32'
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

  }
})
