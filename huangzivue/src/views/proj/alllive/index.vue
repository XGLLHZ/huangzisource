<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="maint">
          <div class="main-top">
            <div class="main-topt">
              <span style="font-size:28px;color:#555555">全部直播</span>
              <span><el-button size="mini" round><span>全部</span></el-button></span>
              <span><el-button size="mini" round><span>网游竞技</span></el-button></span>
              <span><el-button size="mini" round><span>单机热游</span></el-button></span>
              <span><el-button size="mini" round><span>手游休闲</span></el-button></span>
              <span><el-button size="mini" round><span>娱乐天地</span></el-button></span>
            </div>
          </div>
          <div class="main-midle">
            <ul class="midle-ul"><!---->
                <li v-for="(item,index) in this.hostinfo">
                    <router-link :to="{path: '/hostlive',query: {hostid:item.id}}">
                        <div class="live-li">
                            <div class="live-li-logo">
                                <img class="live-li-logo-img" :src="item.liveLogoUrl">
                            </div>
                            <div class="live-li-info">
                                <div class="info-info"><span class="info-title">{{item.hostTitle}}</span></div>
                                <div class="info-info">
                                    <span class="info-name">{{item.hostNickname}}</span>
                                    <span class="info-fans">{{item.hostFansCount}}人</span>
                                </div>
                            </div>
                        </div>
                    </router-link>
                </li>
            </ul>
          </div>
        </div>
        <!--<homefooter></homefooter>-->
      </div>
    </div>
  </div>
</template>

<script>
import homenav from '@/components/homenav'
import homeaside from '@/components/homeaside'
import homefooter from '@/components/homefooter'
import { getAllLiveInfo } from '@/api/proj/yewu/index.js'
export default {
  name: 'alllive',
  components: {
    homenav,
    homeaside,
    homefooter
  },
  data() {
    return {
      queryData: {
        hostRoom: '',
        hostType: '',
        hostFlag: '',
        hostName: '',
        hostNickname: '',
        hostGender: ''
      },
      hostinfo: [],
      imageUrl: ''
    }
  },

  created() {
    this.getList()
  },

  methods: {

    //获取数据列表
    getList() {
      this.loading = true
      getAllLiveInfo(this.queryData).then(response => {
        this.loading = false
        this.hostinfo = response.data.list
      }).catch(() => {
        this.loading = false
      })
    }

  }
}
</script>

<style>
.huangzi {
  margin: 0;
  padding: 0;
  width: 100%;
}
.huanzgi-main {
  margin: 0;
  padding: 0;
  width: 100%;
}
.main {
  margin: 61px 0 0 0;
  padding: 0;
  width: 84%;
  float: right;
  background-color: #F4F5F8;
}
.maint {
  margin: 0 3%;
  padding: 0;
  width: 94%;
}
.main-top {
  margin: 0;
  padding: 0 0 0 30px;
  line-height: 3;
}
.main-midle {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
}
.main-topt {
  margin: 0;
  padding: 0;
  width: 45%;
}
.main-top span {
  vertical-align: middle;
}
.main-top span button {
  vertical-align: middle;
}
.main-midle {
  margin: 0;
  padding: 0;
  width: 100%;
}
.midle-ul {
  list-style-type: none;
}
.live-li {
    margin: 0 20px 20px 0;
    padding: 0;
    width: 23%;
    height: 240px;
    float: left;
    border-radius: 10px;
    background-color: white;
}
.live-li-logo {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 75%;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
.live-li-logo-img {
    width: 100%; 
    height: 100%;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
.live-li-info {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 25%;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}
.info-info {
    margin: 0;
    padding: 0;
    width: 100%;
    height: 50%;
}
.info-title {
    margin: 2% 0 0 2%;
    float: left;
    color: black;
}
.info-name {
    margin: 0 0 0 2%;
    float: left;
    font-size: 13.5px;
    color: gray;
}
.info-fans {
    margin: 0 2% 0 0;
    float: right;
    font-size: 13.5px;
    color: gray;
}
.midle-ul img:hover {
  border-color: red;
}
.kind-img {
  margin: 0 15px 15px 0;
  float: left;
  width: 130px;
  border-radius: 5px;
  border: 2px solid white;
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>



