const util = require('../../common/js/util.js')
Component({
  externalClasses: ['v-class'],

  relations: {
    '../v-grid/index': {
      type: 'parent'
    },
    '../v-grid-icon/index': {
      type: 'child'
    }
  },
  properties: {
    badge: {
      type: Number,
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
  data: {
    itemBorder: true
  },
  methods: {
    changeBorder(bol) {
      this.setData({
        itemBorder: bol
      })
    },
    handleClick() {
      const { url, linkType } = this.data


      if (!url) {
        util.error('跳转的url不能为空！')
      }

      if (linkType == 'navigateTo') {
        wx.navigateTo({
          url: url,
        })
      } else if (linkType == 'redirectTo') {
        wx.redirectTo({
          url: url,
        })
      } else if (linkType == 'switchTab') {
        wx.switchTab({
          url: url,
        })
      } else {
        wx.reLaunch({
          url: url,
        })
      }

    }
  }
});
