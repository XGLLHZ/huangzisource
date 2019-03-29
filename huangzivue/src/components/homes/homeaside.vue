<template>
  <div class="aside-div">
    <div class="aside-top">
      <router-link to="/">赛事直播</router-link>
      <router-link to="/">我的关注</router-link>
    </div>
    <div class="aside-midle">
      <div class="aside-midle-all">
        <div class="all-tiltle">
          <router-link class="all-title-name" to="/"><span>|</span>网游竞技</router-link>
          <router-link class="all-title-all" to="/">全部></router-link>
        </div>
        <div class="all-content">
          <ul>
            <li><router-link class="all-content-name" to="/">英雄联盟</router-link></li>
            <li><router-link class="all-content-name" to="/">绝地求生</router-link></li>
            <li><router-link class="all-content-name" to="/">魔兽世界</router-link></li>
          </ul>
          <ul>
            <li><router-link class="all-content-name" to="/">DOTA2</router-link></li>
            <li><router-link class="all-content-name" to="/">守望先锋</router-link></li>
            <li><router-link class="all-content-name" to="/">刀塔自走棋</router-link></li>
          </ul>
        </div>
        <div class="all-tiltle">
          <router-link class="all-title-name" to="/"><span>|</span>单机热游</router-link>
          <router-link class="all-title-all" to="/">全部></router-link>
        </div>
        <div class="all-content">
          <ul>
            <li><router-link class="all-content-name" to="/">战地风云</router-link></li>
            <li><router-link class="all-content-name" to="/">怪物猎人</router-link></li>
            <li><router-link class="all-content-name" to="/">NBA 2K</router-link></li>
          </ul>
          <ul>
            <li><router-link class="all-content-name" to="/">格斗游戏</router-link></li>
            <li><router-link class="all-content-name" to="/">圣歌</router-link></li>
            <li><router-link class="all-content-name" to="/">FIFA</router-link></li>
          </ul>
        </div>
        <div class="all-tiltle">
          <router-link class="all-title-name" to="/"><span>|</span>手游休闲</router-link>
          <router-link class="all-title-all" to="/">全部></router-link>
        </div>
        <div class="all-content">
          <ul>
            <li><router-link class="all-content-name" to="/">王者荣耀</router-link></li>
            <li><router-link class="all-content-name" to="/">刺激战场</router-link></li>
            <li><router-link class="all-content-name" to="/">炉石传说</router-link></li>
          </ul>
          <ul>
            <li><router-link class="all-content-name" to="/">QQ飞车</router-link></li>
            <li><router-link class="all-content-name" to="/">三国杀</router-link></li>
            <li><router-link class="all-content-name" to="/">阴阳师</router-link></li>
          </ul>
        </div>
        <div class="all-tiltle">
          <router-link class="all-title-name" to="/"><span>|</span>娱乐天地</router-link>
          <router-link class="all-title-all" to="/">全部></router-link>
        </div>
        <div class="all-content">
          <ul>
            <li><router-link class="all-content-name" to="/">二次元</router-link></li>
            <li><router-link class="all-content-name" to="/">星娱</router-link></li>
            <li><router-link class="all-content-name" to="/">音乐</router-link></li>
          </ul>
          <ul>
            <li><router-link class="all-content-name" to="/">户外</router-link></li>
            <li><router-link class="all-content-name" to="/">美食</router-link></li>
            <li><router-link class="all-content-name" to="/">一起看</router-link></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="aside-bootom">
      <el-button size="medium" round>皇子客户端</el-button>
      <router-link to="/"><el-button size="medium" round>成为主播</el-button></router-link>
      <router-link to="" style="display:block">12318举报</router-link>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'homeaside'
  }
</script>

<style>
.aside-div {
  margin: 61px 0 0 0;
  padding: 0;
  width: 16%;
  height: 100%;
  background-color: #2D2E36;
  position: fixed;
}
.aside-top {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 12%;
  border-bottom: 1px solid #434343;
}
.aside-top a {
  display: block;
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: #A7A7A7;
  line-height: 2.7;
}
.aside-top a:hover {
  color: red;
  background-color: #26272E;
}
.aside-midle {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 66%;
  border-bottom: 1px solid #434343;
}
.aside-midle a:hover {
  color: red;
}
.aside-midle-all {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 25%;
}
.aside-midle-all span {
  padding-right: 5px; 
  color: red;
  font-weight: bold;
}
.aside-midle-all a {
  margin: 0;
  padding: 0;
  text-decoration: none;
  color: #A7A7A7;
}
.all-tiltle {
  margin: 0;
  padding: 10px 20px 0 20px;
  width: calc(100%-20px);
  height: 28%;
}
.all-title-name {
  display: block;
  margin: 0;
  float: left;
}
.all-title-all {
  display: block;
  float: right;
  font-size: 12px;
  line-height: 2;
}
.all-content {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 60%;
  border-bottom: 1px solid #26272E;
}
.all-content ul {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 50%;
  list-style-type: none;
}
.all-content li {
  margin: 0;
  padding: 7px 0 0 20px;
  float: left;
}
.all-content li a {
  text-decoration: none;
  font-size: 13px;
}
.aside-bottom {
  margin: 0;
  padding: 0;
  width: 100%;
}
.aside-bootom button {
  margin: 10px 0 10px 0;
  color: white;
  background-color: #FF5252;
  border: 0px;
}
.aside-bootom button:hover {
  color: white;
  background-color: red;
}
.aside-bootom a {
  color: #676C6C;
  font-size: 13px;
  text-decoration: none;
}
.aside-bootom a:hover {
  color: red;
}
</style>
