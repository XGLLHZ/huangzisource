<template>
  <div class="login">
    <homenav></homenav>
    <div class="main-main">
        <div class="login-main">
            <div class="login-main-content">
                <div class="content content-one"><span>注册皇子</span></div>
                <el-form
                :rules="rules"
                :model="registerModel"
                ref="registerRef"
                v-loading="loading">
                    <el-form-item prop="userName">
                        <el-input placeholder="请输入账号：手机号" v-model="registerModel.userName" clearable></el-input>
                    </el-form-item>
                    <el-form-item prop="userPassword">
                        <el-input placeholder="请输入密码" v-model="registerModel.userPassword" type="password" clearable></el-input>
                    </el-form-item>
                    <el-form-item prop="userPasswordtwo">
                        <el-input placeholder="请在此输入密码" v-model="registerModel.userPasswordtwo" type="password" autocomplete="off" clearable></el-input>
                    </el-form-item>
                    <el-button @click="registerSubmit()" class="content-three">注 册</el-button>
                </el-form>
                <div class="content">
                    <div class="content-five">
                        <span><router-link to="/login">已有账号直接登录</router-link></span>
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
import { registerApi } from '@/api/proj/base/navbar.js'
export default {
  name: 'register',
  components: {
    homenav,
    homefooter
  },
  data() {
    var checkPass2 = (rule,value,callback) => {
        if (value == '') {
            callback(new Error('请再次输入密码！'))
        } else if (value !== this.registerModel.userPassword) {
            callback(new Error('两次输入密码不一致！'))
        } else {
            callback()
        }
    }
    return {
        loading: false,
        registerModel: {
            userName: '',
            userPassword: '',
            userPasswordtwo: '',
            userType: '4'
        },
        rules: {
            userName: [
                { required: true, message: '请输入账号！', trigger: 'blur' }
                // { min: 11,max: 11, message: '账号应为11位手机号！', trigger: 'blur' }
            ],
            userPassword: [
                { required: true, message: '请输入密码！', trigger: 'blur' }
                // { min: 8,max: 16, pattern:/[0-9A-Za-z]{8,16}/, message: '密码长度在8-16之间，且为字母数字组合！', trigger: 'blur' }
            ],
            userPasswordtwo: [
                { validator: checkPass2, trigger: 'blur' }
                // { min: 8,max: 16, pattern:/[0-9A-Za-z]{8,16}/, message: '密码长度在8-16之间，且为字母数字组合！', trigger: 'blur' }
            ]
        }
    };
  },

  methods: {
      //注册
      registerSubmit() {
          this.loading = false
          this.$refs.registerRef.validate((valid) => {
              if (valid) {
                  registerApi(this.registerModel).then(response => {
                    this.loading = false
                    if (response && response.status == 200) {
                        var userinfo = response.data
                        if (userinfo.userName != null) {
                            alert("注册成功！")
                        } else {
                            alert("用户名已被注册！")
                        }
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


