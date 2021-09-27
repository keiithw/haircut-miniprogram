// base/hari-stylist/index.js
var app=  getApp().globalData;

Component({
  /**
   * 组件的属性列表
   */
  properties: {
    list: {
      type: Array,
      value: ''
    },
    lastTime: {  //是否是上次剪发的发型师
      type: null,
      value: ''
    },
    sid:{
      type:Number,
      value:''
    },
    storeName:{
      type:String,
      value:''
    }
  },

  
 lifetimes:{
  attached: function() {
    // 在组件实例进入页面节点树时执行
    console.log('----------')
    console.log(this.properties.list)
    this.setData({
      id: this.properties.list[0].id
    })
  }
 },
  /**
   * 组件的初始数据
   */
  data: {
    showModal: false,
    id:0
  },

  
  /**
   * 组件的方法列表
   */
  methods: {
    handleModal(event) {
      console.log(event)
      var serveId = event.target.dataset.serveid
      var price = event.target.dataset.price
      var name = event.target.dataset.name
      var storeName = this.data.storeName
      // wx-wx.request({
      //   url: app.server + '/wxApp/listMembersInServe',
      //   data: {
      //     sid: app.sid,
      //     serveId: serveId
      //   },
      //   header: { 'content-type': 'application/json' },
      //   method: 'GET',
      //   dataType: 'json',
      //   responseType: 'text',
      //   success: function(result) {
      //     wx - wx.setStorage({
      //       key: 'stylists',
      //       data: r,
      //       success: function (res) { },
      //       fail: function (res) { },
      //       complete: function (res) { },
      //     })
      //   },
     
      // })
      var reqTask = wx.request({
        url: app.server+'/wxApp/listMembersInServe',
        data: {
          sid:app.sid,
          serveId:serveId
        },
        header: {'content-type':'application/json'},
        method: 'GET',
        dataType: 'json',
        responseType: 'text',
        success: (result)=>{
          var r = result.data.data
          wx.navigateTo({
            //带着list跳到设计师页
            url: '/pages/stylists/index?price='+price+'&sid='+app.sid+'&storeName='+storeName+'&serveId='+serveId+'&serveName='+name,
            success: (result)=>{
              wx-wx.setStorage({
                key: 'stylists',
                data: r,
                success: function(res) {},
                fail: function(res) {},
                complete: function(res) {},
              })
            },
            fail: ()=>{
              wx.showToast({
                title: '请求错误',
                icon: 'none',
                image: '',
                duration: 1500,
                mask: false,
                success: (result)=>{
                  
                },
                fail: ()=>{},
                complete: ()=>{}
              });
            },
            complete: ()=>{}
          });
        },
        fail: ()=>{},
        complete: ()=>{}
      });
    
      this.setData({
        
      })
    },
    zoom: function (e) {
      console.log(e)
      wx - wx.previewImage({
        current: '',
        urls: [e.currentTarget.dataset.url],
        success: function (res) { },
        fail: function (res) { },
        complete: function (res) { },
      })
    },
    closeModal() {
      this.setData({
        showModal: false
      })
    }
  }
})
