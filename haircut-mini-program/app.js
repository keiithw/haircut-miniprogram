//app.js
App({
  globalData: {
    colorList: { //default, primary, ghost, info, success, warning, error
      default: '#333', //主要字体
      success: '#6c6982', //
      primary: '#8f74fa', // 主题色:按钮 tabs背景 弹窗确认按钮
      error: '#ff3d3d', // 价格颜色
      warning: '#c2b4fc', // 标签色
      info:'#c9c9c9',  // 灰色按钮
      explain: '#999999', // 灰色字体
      ghost:'#4d4d4d', // 评论处按钮
      white:'white',
      button:'linear-gradient(45deg, #9171fa, #8286fc)',
      tabBg: 'linear-gradient(45deg, #9b5ff3, #8285fc)'
    },
      nickName:'',
      gender:'',
      city:'',
      province:'',
      avatarUrl:'',
      openId:'',
      unionId:'',
      finishInfo:'',
      phone:'',
      height:'',
      weight:'',
      session_key:'',
      id:'',
      introduce:'',
      tmplIds : ['J96MUisUST_8drYqCO8n8CxAsaaRYHEeYU8gPP5QNmQ'],
      server:'http://192.168.0.109:8102'
  },
  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function () {
    
  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {

   
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    
  }
})
