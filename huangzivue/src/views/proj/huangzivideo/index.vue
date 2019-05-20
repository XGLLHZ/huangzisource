<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="maint">
          <div class="main-photo">
              <el-carousel :interval="3000" type="card" height="200px">
                <el-carousel-item v-for="item in imglist" :key="item.id" style="border-radius: 5px;">
                <el-col><img ref="imgHeight" :src="item.imgsrc"/></el-col>
                </el-carousel-item>
            </el-carousel>
          </div>
          <div class="main-top">
            <div class="main-topt">
              <span style="font-size:28px;color:#555555">英雄联盟</span>
              <span><el-button size="mini" round><span>全部</span></el-button></span>
              <span><el-button size="mini" round><span>网游竞技</span></el-button></span>
              <span><el-button size="mini" round><span>单机热游</span></el-button></span>
              <span><el-button size="mini" round><span>娱乐天地</span></el-button></span>
              <span><el-button size="mini" round><span>手游休闲</span></el-button></span>
            </div>
          </div>
          <div class="main-midle"></div>
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
export default {
  name: 'alllive',
  components: {
    homenav,
    homeaside,
    homefooter
  },
  data() {
      return {
          imglist: [
              {id:0,imgsrc: require('../../../assets/indexpng/1.png')},
              {id:1,imgsrc: require('../../../assets/indexpng/2.png')},
              {id:2,imgsrc: require('../../../assets/indexpng/3.png')},
              {id:3,imgsrc: require('../../../assets/indexpng/4.png')},
              {id:4,imgsrc: require('../../../assets/indexpng/5.png')},
              {id:5,imgsrc: require('../../../assets/indexpng/6.png')}
          ]
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
.main-photo {
  margin: 0;
  padding: 20px 0 0 0;
  width: 100%;
}
.main-top {
  margin: 0;
  padding: 0;
  line-height: 2;
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
  height: 600px;
}
</style>
