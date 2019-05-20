<template>
    <div class="live-live">
        <div class="video-box">
            <div>
                <videoPlayer class="vjs-custom-skin videoPlayer" :options="playerOptions"></videoPlayer>
            </div>
        </div>
    </div>
</template>

<script>
import 'video.js/dist/video-js.css'
import {videoPlayer} from 'vue-video-player'
import 'videojs-flash'
export default {
    name: 'person',
    components: {
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
            }
		}
    }
  
}
</script>

<style>
</style>



