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
                    <span style="font-size:20px;font-weight: bold">冲分：剑指韩服王者</span>  
                  </div>
                  <div class="title-total" style="float:right;line-height:30px">
                    <el-button size="small" round style="width:130px"><span>关注 | 187320</span></el-button>
                  </div> 
                </div>
                <div class="host-title-other">
                  <div class="host-title-midle">
                    <span>1</span><span>国服第一劫</span><span>私信主播</span><span>热度192500</span><span>皇子星火</span>
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
                    <videoPlayer class="vjs-custom-skin videoPlayer" :options="playerOptions"></videoPlayer>
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
                      <span class="barrage-list-user">admin：</span><span class="barrage-list-content">{{item}}</span>
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
        <div class="main-discuss">
          <div class="main-discuss-info">
            <div class="discuss-info">
              <div class="discuss-guessing"></div>
              <div class="discuss-post"></div>
            </div>
            <div class="discuss-host-neighbor"></div>
          </div>
        </div>
        <homefooter></homefooter>
      </div>
    </div>
  </div>
</template>

<script>
import homenav from '@/components/homenav'
import homeaside from '@/components/homeaside'
import homefooter from '@/components/homefooter'
import 'video.js/dist/video-js.css'
import {videoPlayer} from 'vue-video-player'
import 'videojs-flash'
export default {
  name: 'alllive',
  components: {
    homenav,
    homeaside,
    homefooter,
    videoPlayer
  },
  data() {
    return {
      playerOptions: {
			sources: [{
				type: 'rtmp/mp4',
        src: 'rtmp://119.23.234.176:1935/live/my',
        withCredentials: false
			}],
			height: '487',
			techOrder: ['flash'],
			autoplay: true,
      controls: true,
      language: 'zh-CN',
      live: true
      },
      loading: false,
      barragelist: [],
      barragetext: ''
		}
  },

  mounted(){
      this.$refs.input.focus()
      this.send = this.$start(document.querySelector('.videoPlayer', [0,0.2]))
  },

  methods: {
    sendBarrage() {
      this.barragelist.push(this.barragetext)
      this.barragetext = ''
      this.send({
        text: this.barragelist
      })
    }
  }
  //LTAIuyM8p0B3hCZe
  //GxjhCWuK0LfOsGeCP640AMbu5Hf8HB
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
