<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="maint">
          <div class="main-top">
            <div class="main-topt">
              <span style="font-size:28px;color:#555555">全部分类</span>
              <span><el-button size="mini" round><span>全部</span></el-button></span>
              <span><el-button size="mini" round><span>网游竞技</span></el-button></span>
              <span><el-button size="mini" round><span>单机热游</span></el-button></span>
              <span><el-button size="mini" round><span>手游休闲</span></el-button></span>
              <span><el-button size="mini" round><span>娱乐天地</span></el-button></span>
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
.maint {
  margin: 0 3%;
  padding: 0;
  width: 94%;
  height: 600px;
}
.main-top {
  margin: 0;
  padding: 0 0 0 30px;
  line-height: 3;
  background-color: antiquewhite;
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
