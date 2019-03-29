<template>
  <div class="footer-div">
    <div class="footer-bar">
      <ul>
      <li><router-link to="/">关于我们</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">联系客服</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">招聘信息</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">友情链接</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">我要直播</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">意见反馈</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">版权保护投诉指引</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">皇子官方QQ号</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">12318全国文化市场举报网站</router-link><span class="splitbar">|</span></li>
      <li><router-link to="/">网上有害信息举报专区</router-link></li>
    </ul>
    </div>
    <div class="footer-bar">
      <ul>
        <li>皇子直播网络科技有限公司  版权所有  ©www.xgllhz.com  津ICP备18006982号<span class="splitbar">|</span></li>
        <li><router-link to="/">津公网安备  000000000000000号</router-link><span class="splitbar">|</span></li>
        <li><router-link to="/">工商网监</router-link></li>
      </ul>
    </div>
    <div class="footer-bar">
      <ul>
        <li>公司地址：中国 天津 经济技术开发区第十三大街29号14栋5楼   客户服务热线：001-15103304/002-15103304</li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'homefooter'
  }
</script>

<style>
.footer-div {
  margin: 0;
  padding: 30px 0;
  width: 100%;
  background-color: #3F3F3F;
}
.footer-bar {
  margin: 0;
  padding: 5px 0;
  width: 100%;
}
.footer-bar ul {
  margin: 0;
  padding: 0;
  list-style-type: none;
  overflow: hidden;
}
.footer-bar ul li {
  margin: 0;
  padding: 0;
  font-size: 13px;
  color: #B5B5B5;
  display: inline-block;
}
.footer-bar a {
  margin: 0;
  padding: 0;
  color: #B5B5B5;
  cursor: pointer;
  font-size: 13px;
  text-decoration: none;
  vertical-align: middle;
}
.footer-bar a:hover {
  color: #FFFFFF;
}
.splitbar {
  padding: 0 3px;
  vertical-align: middle;
  color: #B5B5B5;
}
</style>
