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
          <div class="main-midle">
            <ul class="midle-ul">
              <li class="milde-ul-li" v-for="(item,index) in this.casttype">
                <router-link :to="{path: '/castkind',query: {castid:item.id}}">
                  <img class="kind-img" :src="item.castLogo">
                </router-link>
              </li>
            </ul>
            <!--<el-upload
              class="avatar-uploader"
              action=""
              :show-file-list="false"
              :auto-upload="false"
              :on-change="onUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <img :src="imageUrl">-->
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
import { getKindList } from '@/api/proj/yewu/index.js'
export default {
  name: 'kind',
  components: {
    homenav,
    homeaside,
    homefooter
  },
  data() {
    return {
      casttype: [],
      queryData: {
        castTypeName: ''
      },
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
      getKindList(this.queryData).then(response => {
        this.loading = false
        this.casttype = response.data.list
      }).catch(() => {
        this.loading = false
      })
    },

    // beforeUpload(file) {
    //   const imagesize = file.size / 1024 /1024 < 2
    //   if (!imagesize) {
    //     this.$message.error("图片大小不能超过2MB！")
    //   }
    //   return imagesize
    // },

    // onUpload(file, fileList) {
    //   var reader = new FileReader()
    //   var date = new Date()
    //   var year = date.getFullYear().toString()
    //   var month = (date.getMonth() + 1).toString()
    //   var day = date.getDate().toString()
    //   var hh = date.getHours().toString()
    //   var mm = date.getMinutes().toString()
    //   var ss = date.getSeconds().toString()
    //   var fileName = year + month + day + hh + mm + ss
    //   reader.readAsDataURL(file.raw)
    //   reader.onload = function(e) {
    //     var imageBase = this.result
    //     uploadImage(fileName, imageBase).then(response => {
    //       this.imageUrl = response.data.ossUrl
    //       // 这个方法执行完之后imageUrl中的值就不见了，所以后面又获取了一次image-url
    //     }).catch(() => {})
    //   }
    //   // getImageUrl(fileName).then(response => {
    //   //   this.imageUrl = response.data.ossUrl
    //   // })
    // }
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
  background-color: #F4F5F8;
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
.midle-ul img:hover {
  border-color: red;
}
.kind-img {
  margin: 0 15px 15px 0;
  float: left;
  width: 10.5%;
  border-radius: 10px;
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

