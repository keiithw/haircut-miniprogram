const util = require('../../common/js/util.js')
const typeMap = ['text', 'number', 'idcard', 'textarea', 'digit', 'textarea']

Component({
  /**
   * 组件的属性列表
   */
  properties: {
    type: {
      type: String,
      value: 'text' //可选值 text number  textarea
    },
    autoHeight: {
      type: null,
      value: ''
    },
    fixed: {
      type: null,
      value: '' // 如果 textarea 是在一个 position:fixed 的区域，需要显示指定属性 fixed 为 true
    }
  },

  /**
   * 组件的初始数据
   */
  data: {

  },
  ready() {
    let type = this.data.type

    if(!typeMap.includes(type)) {
      util.error('input组件暂不支持该类型,path:"components/v-input"')
    }
  },
  /**
   * 组件的方法列表
   */
  methods: {

  }
})
