<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="main-content">
          <div class="main-content-info">
            <div class="add-info">
              <div class="hostset-side">
                <div class="side-cente"><span>个人中心</span></div>
                <div>
                  <el-menu>
                    <el-menu-item index="1" @click="infoSet(1)">
                      <template slot="title">个人信息</template>
                    </el-menu-item>
                    <el-menu-item index="2" @click="infoSet(2)">
                      <template slot="title">直播信息</template>
                    </el-menu-item>
                  </el-menu>
                </div>
              </div>
              <div class="hostset-main">
                <person v-if="personvisible"></person>
                <liveset v-if="livesetdisible"></liveset>
              </div>
            </div>
          </div> 
        </div>
        <!--<homefooter></homefooter>-->
      </div>
    </div>
  </div>
</template>

<script>
import homenav from '@/components/homes/homenav'
import homeaside from '@/components/homes/homeaside'
import homefooter from '@/components/homes/homefooter'
import person from '@/views/proj/personcenter/person'
import liveset from '@/views/proj/personcenter/liveset'
export default {
  name: 'personcenter',
  components: {
    homenav,
    homeaside,
    homefooter,
    person,
    liveset
  },
  data() {
    return {
      personvisible: false,
      livesetdisible: false
    }
  },

  created() {
  },

  methods: {
    infoSet(index) {
      if(index === 1) {
        this.livesetdisible = false
        this.personvisible = true
      }
      if(index === 2) {
        this.personvisible = false
        this.livesetdisible = true
      }
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
  height: 100%;
  float: right;
  background-color: #F4F5F8;
}
.main-content {
  margin: 0;
  padding: 0;
  width: 100%;
}
.main-content-info {
  margin: 0 1%;
  padding: 10px 0 0 0;
  width: 98%;
  vertical-align: middle;
}
.add-info {  
  margin: 0 0 1% 0;
  padding: 0;
  width: 100%;
  height: 635px;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.el-form-item {
  margin: 0 0 10px 10px;
  float: left;
}
.hostset-side {
  margin: 0;
  padding: 0;
  width: 19.5%;
  height: 635px;
  float: left;
}
.hostset-main {
  margin: 0;
  padding: 0;
  width: 80%;
  height: 635px;
  float: right;
  border-left: 1px solid  #F2F2F2
}
.side-cente {
  margin: 0;
  padding: 20px 0 20px 0 ;
  width: 100%;
  font-size: 18px;
}
</style>


