const app = getApp()

let colorList = app.globalData.colorList

Component({
  externalClasses: ['v-class'],
  /**
   * 组件的属性列表
   */
  properties: {
    type: { //颜色类型
      type: String,
      value: 'error'
    },
    size:{
      type: String,
      value: '40' //默认宽高40
    },
    value: {
      type: Number,
      value: 0
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
