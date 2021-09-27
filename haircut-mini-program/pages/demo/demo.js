Page({
  data: {
    index: 0,
    multiIndex: [0, 0, 0],
    date: '2016-09-01',
    time: '12:01',
    customItem: '全部',
    dots: ["2020-03-01", "2020-03-10", "2020-03-12", "2020-03-13", "2020-03-13"]
  },
 
  bindDateChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      date: e.detail.value
    })
  },
  bindTimeChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      time: e.detail.value
    })
  },
 
})