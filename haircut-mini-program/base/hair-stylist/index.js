// base/hari-stylist/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    list: {
      type:Array,
      value: ''
    },
    lastTime: {  //是否是上次剪发的发型师
      type: null,
      value: ''
    },
    price:{
      type: Number,
      value: 0
    },
    sid: {
      type: Number,
      value: 0
    },
    storeName: {
      type: String,
      value: ''
    },
    serveId: {
      type: Number,
      value: 0
    },
    serveName: {
      type: String,
      value: ''
    },
  },

  /**
   * 组件的初始数据
   */
  data: {
    showModal:false,
    profile:'',
    barberName:'',
    phone:''
  },

  /**
   * 组件的方法列表
   */
  methods: {
    openCalendar(event){
      console.log(event)
      var barberId = event.target.dataset.barberid
      var profile = event.target.dataset.profile
      var userPhone = event.target.dataset.userphone
      var barberName = event.target.dataset.barbername
      var sid = this.data.sid
      var storeName = this.data.storeName
      var serveId = this.data.serveId
      var serveName = this.data.serveName
      var price = this.data.price
      console.log(barberId)
     
      wx.navigateTo({
        url: '../../pages/calendar/calendar?barberId=' + barberId + '&barberName=' + barberName + '&price=' + price + '&serveId=' + serveId + '&serveName=' + serveName + '&sid=' + sid + '&storeName=' + storeName + '&profile=' + profile + '&userPhone=' + userPhone,
        success: (result)=>{
          wx.showToast({
            title: '跳转成功',
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
        fail: (res)=>{
          console.log(res);
          wx.showToast({
            title: '跳转出错',
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
      })
    },

    goDetail:function(e){
      console.log(e.target.dataset)
      var dataset = e.target.dataset.item
      wx-wx.navigateTo({
        url: '/pages/stylist-detail/index?profilePhoto=' + dataset.profilePhoto + '&phone=' + dataset.userPhone + '&name=' + dataset.sysUserName + '&id=' + dataset.id + '&storeName=' + this.data.storeName + '&introduce=' + dataset.introduce,
        success: function(res) {},
        fail: function(res) {},
        complete: function(res) {},
      })
    },
    
    handleModal() {
      this.setData({
        showModal: true
      })
    },
    closeModal() {
      this.setData({
        showModal: false
      })
    }
  }
})
