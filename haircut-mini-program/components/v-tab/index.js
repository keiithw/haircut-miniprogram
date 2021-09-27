const app = getApp()

let colorList = app.globalData.colorList

Component({
  /**
   * 组件的class
   */
  relations: {
    '../v-tabs/index': {
      type: 'parent'
    }
  },
  externalClasses: ['v-class'],
  /**
   * 组件的属性列表
   */
  properties: {
    title:{
      type:String,
      value:''
    },
    key: {
      type: String,
      value:''
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    active: false,
    currentColor: '',
    tabWidth:'',
    color: colorList,
    type: '',
    width: ''
  },
  methods: {
    changeCurrent(active) {
      console.log(active,'active')
      this.setData({ active });
    },
    changeCount(len) {
      let width = 100 / len + '%'
      console.log(width,'width')
      this.setData({ 
        tabWidth: width 
      })
    },
    setActiveColor(activeColorType) {
      this.setData({
        type: activeColorType
      })
    },
    // changeScroll(scroll) {
    //   this.setData({ scroll });
    // },
    changeTabWidth(width) {
      this.setData({
        width:width
      })
    },
    handleClickItem() {
      const parent = this.getRelationNodes('../v-tabs/index')[0];
      parent.emitEvent(this.data.key);
    }
  }
})
