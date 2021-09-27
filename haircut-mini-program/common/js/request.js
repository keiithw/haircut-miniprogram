
const baseUrl = ''


http = {
  get({ url, data, success, fail }) {


    wx.request(data)
  },
  post({}) {

  },
  all({}) {

  }
}

module.exports = http
