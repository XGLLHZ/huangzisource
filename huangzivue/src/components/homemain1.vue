<template>
  <div>
    <el-main>
      <div class="index-live">
        <div class="index-live-box">
          <div class="live-video">
            <div>
                <videoPlayer class="vjs-custom-skin videoPlayer" :options="playerOptions"></videoPlayer>
            </div>
          </div>
          <div class="live-kind">
            <ul>
              <li><img src="./../assets/indexpng/lolmin.png"></li>
              <li><img src="./../assets/indexpng/dota2.png"></li>
              <li><img src="./../assets/indexpng/moshou2.png"></li>
              <li><img src="./../assets/indexpng/pubg.png"></li>
              <li><img src="./../assets/indexpng/lushi.png"></li>
            </ul>
          </div>
        </div>
      </div>
    </el-main>
  </div>
</template>

<script>
import 'video.js/dist/video-js.css'
import {videoPlayer} from 'vue-video-player'
import 'videojs-flash'
export default {
  name: 'homemain1',
  components: {
    videoPlayer
  },
  data() {
    return {
      playerOptions: {
        sources: [{
        type: 'rtmp/mp4',
        src: 'rtmp://119.23.234.176:1935/live/huangzi',
        withCredentials: false
            }],
            height: '525',
            techOrder: ['flash'],
            autoplay: true,
        controls: true,
        language: 'zh-CN',
        live: true
      }
    }
  }
}
</script>

<style>
.index-live {
  margin: 60px 0 0 0;
  padding: 10px 0 0 0;
  width: 100%;
  height: 535px;
  background: url(./../assets/indexpng/lol.png);
}
.index-live-box {
  margin: 0 0 0 12%;
  padding: 0;
  width: 76%;
  height: 525px;
  float: left;
}
.live-video {
  margin: 0;
  padding: 0;
  width: 76%;
  height: 100%;
  float: left;
}
.live-kind {
  margin: 0;
  padding: 0;
  width: 24%;
  height: 100%;
  float: right;
}
.live-kind ul {
  list-style: none;
}
</style>
