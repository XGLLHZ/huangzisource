<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="main-live">
          <div class="main-live-info">
            <div class="live-info">
              <div class="live-host">
                <div class="host-logo">
                  <img src="../../../assets/indexpng/hostLogo.png" style="height:100%">
                </div>
                <div class="host-title">
                  <div class="title-name" style="float:left;line-height:35px">
                    <span style="font-size:20px;font-weight: bold">{{this.liveinfo.hostTitle}}</span>  
                  </div>
                  <div class="title-total" style="float:right;line-height:30px">
                    <el-button size="small" round style="width:130px"><span>关注 | {{liveinfo.hostFansCount}}</span></el-button>
                  </div> 
                </div>
                <div class="host-title-other">
                  <div class="host-title-midle">
                    <span>Lv.30</span>
                    <span>{{liveinfo.hostNickname}}</span>
                    <span>私信主播</span>
                    <span>皇子星火</span>
                    <span>{{liveinfo.hostFansCount}}人</span>
                  </div>
                </div>
                <div class="host-title-other">
                  <div class="host-title-span">
                    <el-button size="mini" style="width:150px" round><span>无形之刃 最为致命</span></el-button>
                  </div>
                </div>
              </div>
              <div class="live-live">
                <div class="video-box">
                  <div>
                    <videoPlayer v-show="videoplayshow" class="vjs-custom-skin videoPlayer" :options="playerOptions"></videoPlayer>
                    <img v-show="hostnoneshow" style="width:100%" src="../../../assets/indexpng/host-none.jpg">
                  </div>
                </div>
              </div>
            </div>
            <div class="live-barrage">
              <div class="barrage-title"><span>贡献榜</span></div>
              <div class="barrage-bar" >
                <div class="barrage-list" v-for="(item, key) in barragelist">
                  <el-row>
                    <el-col>
                      <span class="barrage-list-user">{{liveinfo.hostNickname}}：</span><span class="barrage-list-content">{{item}}</span>
                    </el-col>
                  </el-row>
                </div>
              </div>
              <div class="send-bar">
                <el-input ref="input" placeholder="给主播来个弹幕吧！" size="medium" v-model="barragetext">
                  <el-button slot="append" style="color: white" @click="sendBarrage()" @keydown.enter="sendBarrage()">发送</el-button>
                </el-input>
              </div>
            </div>
          </div>
        </div>
        <!--<div class="main-discuss">
          <div class="main-discuss-info">
            <div class="discuss-info">
              <div class="discuss-guessing"></div>
              <div class="discuss-post"></div>
            </div>
            <div class="discuss-host-neighbor"></div>
          </div>
        </div>-->
        <!--<homefooter></homefooter>-->
      </div>
    </div>
  </div>
</template>

<script>
import homenav from '@/components/homenav'
import homeaside from '@/components/homeaside'
import homefooter from '@/components/homefooter'
import { getByIdHostInfo } from '@/api/proj/yewu/index.js'
import 'video.js/dist/video-js.css'
import {videoPlayer} from 'vue-video-player'
import 'videojs-flash'
export default {
  name: 'hostlive',
  components: {
    homenav,
    homeaside,
    homefooter,
    videoPlayer
  },
  data() {
    return {
      liveinfo: {
        id: '',
        hostRoom: '',
        hostNickname: '',
        hostTitle: '',
        hostFlag: '',
        hostFansCount: '',
        hostType: '',
        hostLiuname: '',
        liuUrl: ''
      },
      videoplayshow: true,
      hostnoneshow:false,
      srcUrl: '',
      loading: false,
      barragelist: [],
      barragetext: '',
      playerOptions: {
			sources: [{
				type: 'rtmp/mp4',
        src: '',
        withCredentials: false
      }],
      poster : '', 
			height: '487',
			techOrder: ['flash'],
			autoplay: true,
      controls: true,
      language: 'zh-CN',
      live: true
      }
		}
  },

  //这个方法先执行(通常是初始化页面某些属性值)
  created() {
    this.getLiveInfo()
  },

  //这个方法后执行(通常初始化dom节点内容，比如echar图这种)
  mounted() {
    this.$refs.input.focus()
    this.send = this.$start(document.querySelector('.videoPlayer', [0,0.2]))
  },

  methods: {

    getLiveInfo() {
      var hostId = this.$route.query.hostid
      this.loading = true
      getByIdHostInfo(hostId).then(response => {
        this.loading = false
        this.liveinfo = response.data
        this.playerOptions.sources[0].src = this.liveinfo.liuUrl + this.liveinfo.hostLiuname
        if (this.liveinfo.hostFlag === 0) {
          this.videoplayshow = false
          this.hostnoneshow = true
        }
      }).catch(() => {
        this.loading = false
      })
    },

    sendBarrage() {
      this.barragelist.push(this.barragetext)
      this.barragetext = ''
      this.send({
        text: this.barragelist
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
.main-live {
  margin: 0;
  padding: 0;
  width: 100%;
}
.main-live-info {
  margin: 0 3%;
  padding: 10px 0 0 0;
  width: 94%;
  height: 610px;
  vertical-align: middle;
}
.live-info {
  margin: 0;
  padding: 0;
  width: 70%;
  height: 100%;
  float: left;
}
.live-barrage {
  margin: 0;
  padding: 0;
  width: 29%;
  height: 100%;
  float: right;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.live-host {
  margin: 0 0 1% 0;
  padding: 0;
  width: 100%;
  height: 19%;
  float: left;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.live-live {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 80%;
  float: left;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.main-discuss {
  margin: 0;
  padding: 0;
  width: 100%;
}

.main-discuss-info {
  margin: 0 3%;
  padding: 20px 0 0 0;
  width: 94%;
  height: 610px;
  vertical-align: middle;
}
.discuss-info {
  margin: 0;
  padding: 0;
  width: 70%;
  height: 100%;
  float: left;
}
.discuss-host-neighbor {
  margin: 0;
  padding: 0;
  width: 29%;
  height: 100%;
  float: right;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.discuss-guessing {
  margin: 0 0 1% 0;
  padding: 0;
  width: 100%;
  height: 19%;
  float: left;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.discuss-post {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 80%;
  float: left;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.host-logo {
  margin: 0;
  padding: 0;
  height: 100%;
  float: left;
}
.host-title {
  margin: 0;
  padding: 10px 10px 10px 15%;
  height: 30%;
}
.host-title-other {
  margin: 0;
  padding: 0 10px 5px 15%;
  height: 20%;
}
.host-title-midle {
  margin: 0;
  padding: 0;
  float: left;
}
.host-title-midle span {
  margin: 0;
  padding-right: 20px;
}
.host-title-span {
  margin: 0;
  padding: 0;
  float: left;
}
.barrage-title {
  margin: 0;
  padding: 5px 0 5px 0;
  width: 100%;
  border-bottom: 1px solid #E5E4E4;
}
.barrage-title span {
  color: #717479;
  font-size: 18px;
}
.barrage-bar {
  margin: 0 10px 0 10px;
  padding: 0;
  width: calc(100% - 20px);
  height: 88.4%;
  text-align: left;
  overflow: auto;
}
.barrage-list {
  margin: 0;
  padding: 3px 0 3px 0;
}
.barrage-list-user {
  color: #0DBC79;
}
.barrage-list-content {
  color: #717479;
}
.send-bar {
  margin: 0;
  padding: 0;
  width: 100%;
}
</style>
