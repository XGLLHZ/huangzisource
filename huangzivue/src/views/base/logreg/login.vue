<template>
  <div class="login">
    <homenav></homenav>
    <div class="main-main">
        <div class="login-main">
            <div class="login-main-content">
                <div class="content content-one"><span>登录皇子</span></div>
                <el-form
                :rules="rules"
                :model="loginModel"
                ref="loginRef"
                v-loading="loading">
                    <el-form-item prop="userName">
                        <el-input placeholder="请输入账号：手机号" v-model="loginModel.userName" clearable></el-input>
                    </el-form-item>
                    <el-form-item prop="userPassword">
                        <el-input placeholder="请输入登录密码" v-model="loginModel.userPassword" type="password" clearable></el-input>
                    </el-form-item>
                    <el-button @click="loginSubmit()" class="content-three">登 录</el-button>
                </el-form>
                <div class="content">
                    <div class="content-five">
                        <span><router-link to="/">忘记密码？</router-link></span>
                        <span><router-link to="/register">免费注册</router-link></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="login-main2">
            <span style="font-size:30px;margin:30px 0 20px 0">来皇子直播&nbsp;&nbsp;&nbsp;&nbsp;你就是国服第一！</span>
            <span>英雄联盟 绝地求生</span>
            <span>魔兽争霸 守望先锋</span>
            <span>炉石传说 DOTA2</span>
            <span>刀塔自走棋 王者荣耀</span>
        </div>
    </div>
    <homefooter></homefooter>
  </div>
</template>

<script>
import homenav from '@/components/homes/homenav'
import homefooter from '@/components/homes/homefooter'
import { loginApi } from '@/api/proj/base/navbar.js'
export default {
  name: 'login',
  components: {
    homenav,
    homefooter
  },
  data() {
    return {
        loading: false,
        loginModel: {
            userName: '',
            userPassword: ''
        },
        rules: {
            userName: [
                { required: true, message: '请输入账号！', trigger: 'blur' }
                // { min: 11,max: 11, message: '账号应为11位手机号！', trigger: 'blur' }
            ],
            userPassword: [
                { required: true, message: '请输入登录密码！', trigger: 'blur' }
                // { min: 8,max: 16, pattern:/[0-9A-Za-z]{8,16}/, message: '密码长度在8-16之间，且为字母数字组合！', trigger: 'blur' }
            ]
        }
    }
  },
 
  methods: {
      //登录
      loginSubmit() {
          this.loading = false
          var path = this.$route.query.redirect
          this.$refs.loginRef.validate((valid) => {
              if (valid) {
                  loginApi(this.loginModel).then(response => {
                    this.loading = false
                    var userinfo = response.data
                    if (response && response.status == 200 && userinfo.userName != null) {
                        this.$store.commit('login', userinfo)
                        console.log("用户信息以放入localStorage")
                        this.$router.push(this.$route.query.redirect || '/')
                        console.log("返回登录前的页面")
                    } else {
                        alert("用户名或密码错误！")
                    }
                }).catch(() => {
                    this.loading = false
                })
              } else {}
          })
      }
  }

}
</script>

<style>
.login {
    margin: 0;
    padding: 0;
    width: 100%
}
.main-main {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 620px;
    background-color: #1C2023;
}
.login-main {
    margin: 150px  250px 0 0;
    padding: 0;
    width: 25%;
    height: 60%;
    float: right;
    background-color: white;
}
.login-main-content {
    margin: 6%;
    padding: 0;
    width: 88%;
    height: 88%;
}
.content {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 18%;
}
.content-one span {
    float: left;
    font-size: 20px;
}
.content-three {
    margin: 10px 0 0 0;
    width: 100%;
    color: white;
    background-color: #00C1DE;
}
.content-three:hover {
    color: white;
    background-color: #0DBC79;
}
.content-five {
    float: right;
    font-size: 13px;
}
.content-five a {
    color: #999999;
    text-decoration: none;
}
.content-five a:hover {
    color: #0DBC79;
}
.login-main2 {
    margin: 150px  0 0 200px;
    padding: 0;
    width: 40%;
    height: 60%;
    float: left;
}
.login-main2 span {
    display: block;
    margin: 10px;
    padding: 0;
    color: white;
}
</style>
