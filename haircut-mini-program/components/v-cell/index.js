// components/cell/index.js
const util = require('../../common/js/util.js')

console.log(util,'util')

Component({
  relations: {
    '../cell-group/index': {
      type: 'parent'
    }
  },
  /**
   * 组件的属性列表
   */
  properties: {
    label: {
      type: String,
      value: ''
    },
    value: {
      type: String,
      value: ''
    },
    icon:{
      type: String,
      value: ''
    },
    isLink: {
      type: null,
      value: ''
    },
    url:  {
      type: String,
      value: ''
    },
    linkType:{
      type:String,
      value: 'navigateTo' // 可选值为 navigateTo，redirectTo，switchTab，reLaunch
    },
    align: {
      type: String, 
      value: 'start' // // 可选值为 start center between
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    isLastCell: false
  },

  /**
   * 组件的方法列表
   */
  methods: {
    handleClick() {
      const { isLink, url, linkType } = this.data

      console.log(isLink, url, linkType, 'isLink,url,type')

      if(!isLink) return

      if(!url) {
        util.error('跳转的url不能为空！')
      }

      if (linkType == 'navigateTo'){
        wx.navigateTo({
          url: url,
        })
      } else if (linkType == 'redirectTo'){
        wx.redirectTo({
          url: url,
        })
      } else if (linkType == 'switchTab'){
        wx.switchTab({
          url: url,
        })
      } else {
        wx.reLaunch({
          url: url,
        })
      }
      
    },
    updateIsLastCell(isLastCell) {
      this.setData({ isLastCell });
    }
  }
})
