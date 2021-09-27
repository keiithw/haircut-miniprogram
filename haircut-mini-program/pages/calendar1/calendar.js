
var HB = require('../../common/js/cutil.js');
var app =  getApp().globalData;
var timestamp = Date.parse(new Date());
var date = new Date(timestamp);
//获取年份  
var Y = date.getFullYear();
//获取月份  
var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
//获取当日日期 
var D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
var ED = date.getDate() < 3 ? '0' + date.getDate() + 7 : date.getDate() + 7;
var time= '12:01';
var day =''
var util = require('../../common/js/util.js')
var today = util.getToday();
var eday= HB.getDateStr(today,7)


Page({
  /**
   * 页面的初始数据
   */
  data: {
    sourceList: [{
      "ClinicLabelName": "医生A",
      "ClinicLabelId": "8a2256334b021c33014b06124fd60181",
      "Count": 5,
      "Date": "2020-2-29",
      "IsVisit": false,
      "NoonName": "上午",
      "Noon": 1,
      "Total": 50,
      "dayOfWeek": "3",
      "keyue": true
    },
    {
      "ClinicLabelName": "医生D",
      "ClinicLabelId": "8a2256334b021c33014b06124fd60181",
      "Count": 5,
      "Date": "2020-03-02",
      "IsVisit": false,
      "NoonName": "凌晨",
      "Noon": 4,
      "Total": 50,
      "dayOfWeek": "5",
      "keyue": true
    },
    {
      "ClinicLabelName": "医生B",
      "ClinicLabelId": "8a2256334b021c33014b06124fd60181",
      "Count": 5,
      "Date": "2020-03-02",
      "IsVisit": false,
      "NoonName": "下午",
      "Noon": 2,
      "Total": 50,
      "dayOfWeek": "0",
      "keyue": true
    },
    {
      "ClinicLabelName": "医生c",
      "ClinicLabelId": "8a2256334b021c33014b06124fd60181",
      "Count": 5,
      "Date": "2020-03-04",
      "IsVisit": false,
      "NoonName": "全天",
      "Noon": 4,
      "Total": 50,
      "dayOfWeek": "0",
      "keyue": true
    },
    {
      "ClinicLabelName": "医生D",
      "ClinicLabelId": "8a2256334b021c33014b06124fd60181",
      "Count": 5,
      "Date": "2020-03-05",
      "IsVisit": false,
      "NoonName": "夜间",
      "Noon": 3,
      "Total": 50,
      "dayOfWeek": "5",
      "keyue": true
    }
    ],
    dateArray: [],
    noonList: [{
      "noon":1,
      "noonName":"上午",
      Value: true,
      list:[]
    },
      {
        "noon": 2,
        "noonName": "下午",
        Value: true,
        list: []
      },
      {
        "noon": 3,
        "noonName": "夜间",
        Value: true,
        list: []
      },
      {
        "noon": 4,
        "noonName":"全天",
        Value: true,
        list: []
      },
    ],
    StartClinicDate: "" ,
    EndClinicDate: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var S = Y + '-' + M + '-' + D;
    var E = Y + '-' + M + '-' + ED
    this.setData({
      StartClinicDate: S,
      EndClinicDate: eday
    })
    console.log(options);
    var that = this
    // var data={
    //   start:this.data.StartClinicDate,
    //   end:this.data.EndClinicDate,
    //   barberId: options.barberId
    // }
    // var uri = app.server+'/wxApp/calendar/getByParams';
    // const getData = (uri, data) => {
    //   return new Promise((resolve, reject) => {
    //     wx.request({
    //       url: url,
    //       method: 'GET',
    //       header: {'content-type':'application/json'},
    //       data: data,
    //       success (res) {
    //         resolve(res.data)
    //       },
    //       fail (err) {
    //         reject(err)
    //       }
    //     })
    //   }).then(function(){
    //     console.log("then")
    //     that.setData({
          
    //     })
    //   })
    // }
    var req = wx-wx.request({
      url: app.server+'/wxApp/calendar/getByParams',
      data: {
        start:this.data.StartClinicDate,
        end:this.data.EndClinicDate,
        barberId: options.barberId
      },
      header: {'content-type':'application/json'},
      method: 'GET',
      dataType: 'json',
      responseType: 'text',
      success: (result)=>{
        that.setData({
           sourceList: result.data,
        })
        console.log("onLoad中：")
        console.log(that.data.sourceList)
      },
      fail: ()=>{
        wx-wx.showToast({
          title: '请求失败',
          icon: '',
          image: '',
          duration: 1000,
          mask: true,
          success: function(res) {},
          fail: function(res) {},
          complete: function(res) {},
        })
      },
      complete: ()=>{
        console.log("进入removal")
        that.removal();
        console.log(today)

        console.log(that.data.StartClinicDate);
        console.log(that.data.EndClinicDate)
      }
    })
   
   

  },
  removal: function () {
    var that = this;
    var objectArray = this.data.sourceList;
    console.log("removal内部")
    console.log("objectArray:")
    console.log(objectArray)
    var newObject = [];
    for (var i = 0; i < objectArray.length; i++) //从第二项开始遍历
    {
      newObject.push(objectArray[i].noonName);
    }

    var finalArray = [newObject[0]]; //结果数组
    for (var j = 1; j < newObject.length; j++) //从第二项开始遍历
    {
      //如果当前数组的第i项在当前数组中第一次出现的位置不是i，
      //那么表示第i项是重复的，忽略掉。否则存入结果数组
      if (newObject.indexOf(newObject[j]) == j) {
        finalArray.push(newObject[j]);
      }
    }
     var noonList = this.data.noonList;
    // for (var k = 0; k < finalArray.length; k++) //从第二项开始遍历
    // {
    //   noonList.push({
    //     noonName: finalArray[k],
    //     noon: that.getNoonNum(finalArray[k]),
    //     Value: false,
    //     list: []
    //   })
    // }
    console.log("noonList")
    console.log(noonList)
    that.setData({
      noonList: noonList.sort(that.compare("noon"))
    })
    console.log("getSevendays")
    that.getSevenDays();
  },
  getNoonNum: function (ele) {
    var num;
    switch (ele) {
      case '上午':
        num = 1;
        break;
      case '下午':
        num = 2;
        break;
      case '夜间':
        num = 3;
        break;
      case '凌晨':
        num = 4;
        break;
      case '全天':
        num = 5;
        break;
    }
    return num;
  },
  compare: function compare(property) {
    return function (a, b) {
      var value1 = a[property];
      var value2 = b[property];
      return value1 - value2;
    }
  },
  getSevenDays: function () {
    var daysArray = [];
    var dayDict = {};
    var weekStr = '';
    var weekNum = '';
    var date = new Date(); //当前日期
    var newDate = new Date();
    //开始日期与结束日期之间相差天数
    var dateNum = HB.Datedifference(this.data.StartClinicDate, this.data.EndClinicDate);
    //显示几周的表格
    var weekNum = Math.ceil((dateNum + 1) / 7);
    var dateArr = HB.GetAll(this.data.StartClinicDate, HB.DateCount(this.data.StartClinicDate, weekNum * 7 - 1));
    dateArr = (this.data.StartClinicDate + "," + dateArr + HB.DateCount(this.data.StartClinicDate, weekNum * 7 - 1)).split(","); //获取两个日期之间日期
    for (var i = 0; i < dateArr.length; i++) {
      weekNum = this.getWeekNum(this.getWeekByDay(dateArr[i]));
      dayDict = {
        "date": dateArr[i],
        "date_text": dateArr[i].substring(5, 10),
        "weekName": this.getWeekByDay(dateArr[i]),
        "weekNum": weekNum
      };
      daysArray.push(dayDict);
    }

    this.setData({
      dateArray: daysArray
    });
    console.log("dealData")
    this.dealData();
  },
  getWeekNum: function (ele) {
    var num;
    switch (ele) {
      case '周一':
        num = 0;
        break;
      case '周二':
        num = 1;
        break;
      case '周三':
        num = 2;
        break;
      case '周四':
        num = 3;
        break;
      case '周五':
        num = 4;
        break;
      case '周六':
        num = 5;
        break;
      case '周日':
        num = 6;
        break;
    }
    return num;
  },
  getWeekByDay: function (value) {
    var day = new Date(Date.parse(value.replace(/-/g, '/'))); //将日期值格式化  
    var today = new Array("周日", "周一", "周二", "周三", "周四", "周五", "周六"); //创建星期数组  
    return today[day.getDay()];
  },
  dealData: function () {
    var that = this;
    var tag = 0;
    var ar = [1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7];

    var objectArray = that.data.noonList;
    let loopNum = that.data.dateArray.length;
    for (var k = 0; k < objectArray.length; k++) {
      for (var m = 0; m < loopNum; m++) {
        objectArray[k].list.push({
          keyue: false,
          date: HB.DateCount(that.data.StartClinicDate, m)
        })
      }
    }
    console.log("dealData内部：")
    console.log("sorceList：")
    console.log(that.data.sourceList)
    console.log("objectArray：");
    console.log(objectArray);
    
    
    for (var i = 0; i < that.data.sourceList.length; i++) {
      var assignmentArray;
      
      for (var j = 0; j < objectArray.length; j++) {
        if (objectArray[j].noonName == that.data.sourceList[i].noonName) {
          assignmentArray = objectArray[j];
        }
      }
      console.log("assignmentArray:")
      console.log(assignmentArray)
      assignmentArray.Value = true;
      for (var n = 0; n < assignmentArray.list.length; n++) {
        if (assignmentArray.list[n].date == that.data.sourceList[i].start) {
          assignmentArray.list[n].noon = that.data.sourceList[i].noon,
            assignmentArray.list[n].clinicLabelId = that.data.sourceList[i].ClinicLabelId,
            assignmentArray.list[n].clinicLabelName = that.data.sourceList[i].ClinicLabelName,
            assignmentArray.list[n].count = that.data.sourceList[i].Count,
            assignmentArray.list[n].isVisit = that.data.sourceList[i].IsVisit,
            assignmentArray.list[n].noonName = that.data.sourceList[i].noonName,
            assignmentArray.list[n].total = that.data.sourceList[i].Total,
            assignmentArray.list[n].dayOfWeek = that.data.sourceList[i].dayOfWeek,
            assignmentArray.list[n].keyue = true
        }
      }

    }
    that.setData({
      noonList: objectArray
    })
  },
  clickDoctor: function (e) {
    let index = e.currentTarget.dataset.item;
    let indexChild = e.currentTarget.dataset.itemchild;
    let arrObiect = this.data.noonList;
    var objectList = arrObiect[index].list[indexChild];
    this.setData({
      day: objectList.date
    })
    
   console.log(this.data.day)
  },
  bindDateChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
  },
  bindTimeChange: function (e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      time: e.detail.value
    })
  }
})
