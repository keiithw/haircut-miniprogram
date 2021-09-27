const util = require('../../common/js/util.js');

const app = getApp()

let colorList = app.globalData.colorList

Component({
  externalClasses: ['v-class'],
  /**
   * 组件的属性列表
   */
  properties: {
    mode: {
      type: String,
      value: 'RMB', // UMB
    },
    price: {
      type:String,
      value: ''
    },
    format: {
      type: String,
      value: '1', // 保留几位小数 0 1  2
    },
    type:{
      type: String,
      value: 'error'
    },
    fontSize: {
      type:String,
      value:'32'
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    showDecimal: false,
    int:'',
    dec: '',

    color: colorList
  },
  ready() {
    if (this.data.format > 0) {
      this.setData({
        showDecimal:true
      })

      let int = util.formatPrice(this.data.price, this.data.format).int

      let dec = util.formatPrice(this.data.price, this.data.format).dec

      this.setData({
        int: int,
        dec: dec
      })
    }
  },
  /**
   * 组件的方法列表
   */
  methods: {

  }
})
