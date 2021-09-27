const app = getApp()

let colorList = app.globalData.colorList
Component({
  /**
   * 组件的外部class
   */
  externalClasses: ['v-class'],
  relations: {
    '../v-tab/index': {
      type: 'child',
      linked() {
        this.changeCurrent();
      },
      linkChanged() {
        this.changeCurrent();
      },
      unlinked() {
        this.changeCurrent();
      }
    }
  },
  /**
   * 组件的属性列表
   */
  properties: {
    type:{ // 激活颜色
      type: String,
      value: 'primary'
    },
    active: { //当前激活的key
      type:String,
      value:'',
      observer: 'changeCurrent'
    },
    fixed: { //是否定位
      type: String,
      value: false
    },
    sticky: { // 是否吸顶
      type: String,
      value: ''
    },
    background: { // 背景颜色
      type:String,
      value:"#ffffff"
    },
    color: { //非激活项目字体颜色
      type: String,
      value:'defalut'
    },
    size:{
      type:String,
      value:''
    },
    gutter: { // 间距
      type: String,
      value: '20'
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
    changeCurrent(val = this.data.active) {

      let items = this.getRelationNodes('../v-tab/index');
      const len = items.length;
      let width = ( 750 - (this.data.gutter * (len + 1)) ) / len


      if (len > 0) {
        items.forEach(item => {
          item.changeCurrent(item.data.key === val);

          if (item.data.key === val) {
            item.setActiveColor(this.data.type)
          }

          item.changeTabWidth(width)
        });

        
      }
      
    },
    emitEvent(key) {
      this.triggerEvent('change', { key });
    }
  }
})
