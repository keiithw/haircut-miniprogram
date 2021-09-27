// components/v-gridgroup/index.js
Component({
  externalClasses: ['v-class'],
  relations: {
    '../v-grid-item/index': {
      type: 'child',
      linked() {
        this.setGridItemWidth();
      },
      linkChanged() {
        this.setGridItemWidth();
      },
      unlinked() {
        this.setGridItemWidth();
      }
    }
  },
  /**
   * 组件的属性列表
   */
  properties: {
    row:{
      type: String,
      value:''
    },
    col: { // 指定多少列
      type: String,
      value: '3'
    },
    colGutter: {
      type: Number,
      value: 0
    },
    rowGutter: {
      type: Number,
      value: 0
    },
    border: {
      type: Boolean,
      value:true
    }
  },
  /**
   * 组件的初始数据
   */
  data: {
    gridTemplateColumns: '', //用来设置每列宽
    gridTemplateRow: '' //用来设置每行宽
  },

  /**
   * 组件的方法列表
   */
  methods: {
    setGridItemWidth() {
      const nodes = this.getRelationNodes('../v-grid-item/index');

      let len = nodes.length

      nodes.forEach(item => {
        item.changeBorder(this.data.border)
      })

    }
  }
})
