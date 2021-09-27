
/* 
 *
 时间格式转化
 * 
 */
const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

/* 
 *
 错误提示
 * 
 */


const error = function (msg) {
  console.error(msg)
}

/* 
 *
 判断数据类型
 * 
 */

const typeMap = {
  '[object Array]': 'Array',
  '[object Object]': 'Object',
  '[object String]': 'String'
}

const getType =  function(data) {
  if (!data) return error('getType函数参数为空！')

  let type = Object.prototype.toString.apply(data)

  return typeMap[type]
}


/* 
 *
 价格转化
 * 
 */
function createDecimal(number) {
  let  decimal = ''

  for(let i=1;i<=number;i++) {
    decimal += '0'
  }
  return decimal
}


const formatPrice = function(price,number) {
  if (number <= 0) return error('formatPrice函数接收的number参数必须大于0！')

  let reg = /[\.]/
  let newPrice = ''
  let decimal = ''
  let integer = ''

  if (reg.test(price)) {
    integer = price.split('.')[0]
    let decimal = price.split('.')[1]
    
    let len = decimal.length

    if(len < number) {
      decimal = decimal + createDecimal(number - len)

      newPrice = newPrice + '.' + decimal
    }
  }else {
    integer = price
    decimal = decimal + createDecimal(number)

    newPrice = integer + '.' + decimal
  }

  return {
    newPrice: newPrice,
    int: integer,
    dec: decimal
  }
}

//获取当前日期
function getToday() {
  var now = new Date();
  var year = now.getFullYear();
  var month = now.getMonth() + 1;
  var day = now.getDate();
  if (month < 10) {
    month = "0" + month;
  };
  if (day < 10) {
    day = "0" + day;
  };
  // 如果需要时分秒
  // var h = now.getHours();
  // var m = now.getMinutes();
  // var s = now.getSeconds();
  var formatDate = year + "-" + month + "-" + day;
  return formatDate;
}
//把函数添加到对象属性里



//获取几天后日期
function dateCount(arg, date) {
  var date1 = arg;
  var date2 = new Date(date1);
  date2.setDate(date2.getDate() + parseInt(date));
  var times = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
  var Year = 0;
  var Month = 0;
  var Day = 0;
  var CurrentDate = "";
  Year = date2.getFullYear();
  Month = date2.getMonth() + 1;
  Day = date2.getDate();
  CurrentDate += Year + "-";
  if (Month >= 10) {
    CurrentDate += Month + "-";
  } else {
    CurrentDate += "0" + Month + "-";
  }
  if (Day >= 10) {
    CurrentDate += Day;
  } else {
    CurrentDate += "0" + Day;
  }
  return CurrentDate;
}

Date.prototype.format = function () {
  var s = '';
  s += this.getFullYear() + '-'; // 获取年份。
  if ((this.getMonth() + 1) >= 10) { // 获取月份。
    s += (this.getMonth() + 1) + "-";
  } else {
    s += "0" + (this.getMonth() + 1) + "-";
  }
  if (this.getDate() >= 10) { // 获取日。
    s += this.getDate();
  } else {
    s += "0" + this.getDate();
  }
  return (s); // 返回日期。
};
//两个日期之间的所有日期
function getAll(begin, end) {
  var ab = begin.split("-");
  var ae = end.split("-");
  var db = new Date();
  db.setUTCFullYear(ab[0], ab[1] - 1, ab[2]);
  var de = new Date();
  de.setUTCFullYear(ae[0], ae[1] - 1, ae[2]);
  var unixDb = db.getTime();
  var unixDe = de.getTime();
  var str = "";
  for (var k = unixDb + 24 * 60 * 60 * 1000; k < unixDe;) {
    str += (new Date(parseInt(k))).format() + ",";
    k = k + 24 * 60 * 60 * 1000;
  }
  return str;
}
//两个时间相差天数
function datedifference(sDate1, sDate2) { //sDate1和sDate2是2006-12-18格式  
  var aDate, oDate1, oDate2, iDays;
  aDate = sDate1.split("-");
  oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]); //转换为9-25-2017格式 
  aDate = sDate2.split("-");
  oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
  iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24);
  return iDays;
}
module.exports = {
  DateCount: dateCount,
  GetAll: getAll,
  Datedifference: datedifference,
  getToday: getToday, 
  formatTime: formatTime,
  error: error,
  getType: getType,
  formatPrice: formatPrice
}

