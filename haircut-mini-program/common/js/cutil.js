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
};
//几天后日期
function getDateStr(today, addDayCount) {
  var dd;
  if (today) {
    dd = new Date(today);
  } else {
    dd = new Date();
  }
  dd.setDate(dd.getDate() + addDayCount);//获取AddDayCount天后的日期 
  var y = dd.getFullYear();
  var m = dd.getMonth() + 1;//获取当前月份的日期 
  var d = dd.getDate();
  if (m < 10) {
    m = '0' + m;
  };
  if (d < 10) {
    d = '0' + d;
  };
  return y + "-" + m + "-" + d;
};

module.exports = {
  DateCount: dateCount,
  GetAll: getAll,
  Datedifference: datedifference,
  getDateStr:getDateStr
}
