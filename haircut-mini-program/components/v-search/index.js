// components/search/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    city:{
      type: String,
      value: ''
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    showCascade: false
  },
  /**
   * 组件的方法列表
   */
  methods: {
    handleClick() {
      this.setData({
        showCascade: !this.data.showCascade
      })
    }
  }
})
