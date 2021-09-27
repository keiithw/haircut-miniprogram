// components/v-avatar/index.js
Component({
  externalClasses: ['v-class'],
  /**
   * 组件的属性列表
   */
  properties: {
    type: {
      type: String,
      value: 'circle' //可选‘circle square’
    },
    src: {
      type: String,
      value: ''
    },
    size: {
      type: String,
      value: '150'
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

  }
})
