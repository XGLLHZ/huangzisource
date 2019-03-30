<template>
  <div class="nav">
    <div class="navbar">
      <div class="leftbar">
        <router-link to="/" style="float:left"><img src="../../assets/logo.png" style="height:56px"/></router-link>
        <ul>
          <li><router-link to="/">首页</router-link></li>
          <li><router-link to="/alllive">全部</router-link></li>
          <li><router-link to="/kind">分类</router-link></li>
          <li><router-link to="/huangzivideo">皇子视频</router-link></li>
          <li><router-link to="/hostInfo">皇子操作</router-link></li>
        </ul>
      </div>
      <div class="rightbar">
        <div class="searchbar">
          <el-input placeholder="房间 主播 分类 视频" size="medium" clearable>
            <el-button slot="append" icon="el-icon-search" round></el-button>
          </el-input>
        </div>
        <div class="loginbar">
          <ul>
            <li>
              <el-popover placement="bottom-end" title="历史" width="200" trigger="hover"
                content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
                <span slot="reference">历史</span>
              </el-popover>
            </li>
            <li>
              <el-popover placement="bottom-end" title="关注" width="200" trigger="hover"
                content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
                <span slot="reference">关注</span>
              </el-popover>
            </li>
            <li>
              <el-popover placement="bottom-end" title="消息" width="200" trigger="hover"
                content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
                <span slot="reference">消息</span>
              </el-popover>
            </li>
            <li>
              <el-popover placement="bottom-end" title="登录" width="250" trigger="hover">
                <div><span>登录之后可以</span></div>
                <div class="login-one">
                  <span>发弹幕</span>
                  <span>看高清</span>
                  <span>关注主播</span>
                </div>
                <div class="login-one-button">
                  <router-link to="/login"><el-button size="mini" round>登录</el-button></router-link>
                  <el-button size="mini" round>注册-></el-button>
                </div>
                <span slot="reference">登录</span>
              </el-popover>
            </li>
          </ul>
        </div>
      </div>
    </div>

    

  </div>
</template>

<script>
  export default {
    name: 'homenav',
    data() {
      return {
        logindialogvisible: false
      }
    },
    methods: {
      login() {
        this.logindialogvisible = true;

      }
    }
  }
</script>

<style>
.nav {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 60px;
  position: fixed;
  background-color: white;
  border-bottom: 1px solid #E5E4E4;
}
.navbar {
  margin: 0 0 0 13%;
  padding: 0;
  width: 74%;
  height: 60px;
}
.leftbar ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
}
.leftbar li {
  float: left;
  margin: 0;
  padding: 0;
}
.leftbar li a {
  display: block;
  color: red;
  cursor: pointer;
  margin: 0;
  padding: 18px;
  font-size: 18px;
  text-decoration: none;
}
.leftbar li a:hover {
  color: white;
  background-color: red;
}
.el-icon-search {
  color: white;
}
.leftbar {
  margin: 0;
  padding: 0;
  width: 60%;
  height: 60px;
  float: left;
}
.rightbar {
  margin: 0;
  padding: 0;
  width: 40%;
  height: 60px;
  float: right;
}
.searchbar {
  margin: 0;
  padding: 0;
  width: 50%;
  height: 60px;
  float: left;
  line-height: 3.6;
}
.searchbar input {
  border-radius: 20px;
}
.el-input-group__append {
  border-top-right-radius: 20px;
  border-bottom-right-radius: 20px;
  background-color: red;
}
.loginbar {
  margin: 0;
  padding: 0;
  width: 50%;
  height: 60px;
  float: right;
}
.el-popover {
  color: #999999;
  border-top: 3px solid red;
}
.el-popover button {
  width: 46%;
  color: red;
  font-size: 15px;
  border: 2px solid red;
}
.el-popover button:hover {
  color: white;
  border: 1px solid white;
  background-color: red;
}
.login-one {
  height: 100px;
  background-color: antiquewhite
}
.rightbar ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
}
.rightbar li {
  float: left;
  margin: 0;
  padding: 0;
  line-height: 3.6;
}
.rightbar li span {
  display: block;
  margin: 0;
  padding: 0 5px 0 5px;
  color: #999999;
  cursor: pointer;
  text-decoration: none;
}
.rightbar li span:hover {
  color: red;
}
</style>

