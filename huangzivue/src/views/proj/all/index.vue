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
                    <span>35</span><span>LOL、摇摆哥</span><span>私信主播</span><span>热度192500</span><span>皇子星火</span>
                  </div>
                </div>
                <div class="host-title-other">
                  <div class="host-title-span">
                    <el-button size="mini" style="width:150px" round><span>国服第一小鱼人</span></el-button>
                  </div>
                </div>
              </div>
              <div class="live-live"></div>
            </div>
            <div class="live-barrage"></div>
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
import homenav from '@/components/homes/homenav'
import homeaside from '@/components/homes/homeaside'
import homefooter from '@/components/homes/homefooter'
export default {
  name: 'alllive',
  components: {
    homenav,
    homeaside,
    homefooter
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
</style>
