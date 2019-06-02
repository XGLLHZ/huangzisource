<template>
    <div class="person-main">
        <div class="info-left">
            <img class="info-left-logo" src="../../../assets/indexpng/hostLogo.png">
        </div>
        <div class="info-right">
            <div class="info-right-content">
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo">姓名：{{userObj.userZSName}}</span>
                </div>
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo">昵称：{{userObj.nickName}}</span>
                </div>
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo">出生年月：{{userObj.age}}</span>
                </div>
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo">身份证号：{{userObj.idNum}}</span>
                </div>
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo">电话：{{userObj.phone}}</span>
                </div>
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo">地址：{{userObj.loc}}</span>
                </div>
                <div class="info-right-content-host">
                    <span class="info-right-content-hostinfo"><router-link to="/updatepassword">修改密码>></router-link></span>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { getInfo } from '@/api/proj/base/navbar.js'
export default {
    name: 'person',
    data() {
        return {
            userObj: {
                id: '',
                userZSName: '',
                nickName: '',
                age: '',
                idNum: '',
                phone: '',
                loc: ''
            }
        }
    },

    created() {
        this.getById()
    },

    methods: {
        getById() {
            var name = this.$store.state.user.userName
            var type = this.$store.state.user.userType
            getInfo(name,type).then(response => {
                this.userObj = response.data
            }).catch(() => {});
        }
    }
}
</script>

<style>

.person-main {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 100%;
}
.info-left {
    margin: 0;
    padding: 0;
    height: 100%;
    float: left;
}
.info-left-logo {
    margin: 10px;
    padding: 0;
    border-radius: 5px;
}
.info-right {
    margin: 0;
    padding: 0;
    height: 100%;
}
.info-right-content {
    margin: 0;
    padding: 30px 0 0 10px;
}
.info-right-content-host {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 30px;
}
.info-right-content-hostinfo {
    margin: 0;
    padding: 0;
    float: left;
}
</style>

