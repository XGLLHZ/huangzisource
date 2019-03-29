<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="main-content">
          <div class="main-content-info">
            <div class="main-header">
              <div class="main-header-title">
                <div class="header-title-name">
                  <span>主播信息管理</span>
                </div>
                <div class="header-title-button">
                  <el-button size="small " type="primary"><i class="el-icon-search" @click="getList()"></i>查询</el-button>
                  <el-button size="small "><i @click="onClear()"></i>清空</el-button>
                </div>
              </div>
              <!--表单-->
              <el-form 
              :inline="true"
              size="mini"
              :model="queryData"
              ref="queryRef">
                <el-row :gutter="0">
                  <!--主播房间号-->
                  <el-col :span="6">
                    <el-form-item label="主播房间号" prop="hostRoom">
                      <el-input size="mini" v-model="queryData.hostRoom"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--直播类别-->
                  <el-col :span="6">
                    <el-form-item label="直播类别" prop="hostType">
                      <el-input size="mini" v-model="queryData.hostType"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--直播状态-->
                  <el-col :span="6">
                    <el-form-item label="直播状态" prop="hostFlag">
                      <el-input size="mini" v-model="queryData.hostFlag"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播姓名-->
                  <el-col :span="6">
                    <el-form-item label="主播姓名" prop="hostName">
                      <el-input size="mini" v-model="queryData.hostName"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="0">
                  <!--主播昵称-->
                  <el-col :span="6">
                    <el-form-item label="主播昵称" prop="hostNickname">
                      <el-input size="mini" v-model="queryData.hostNickname"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播账号-->
                  <el-col :span="6">
                    <el-form-item label="主播账号" prop="hostAccount">
                      <el-input size="mini" v-model="queryData.hostAccount"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播性别-->
                  <el-col :span="6">
                    <el-form-item label="主播性别" prop="hostGender">
                      <el-input size="mini" v-model="queryData.hostGender"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播年龄-->
                  <el-col :span="6">
                    <el-form-item label="主播年龄" prop="hostAge">
                      <el-input size="mini" v-model="queryData.hostAge"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="0">
                  <!--主播身份证号-->
                  <el-col :span="6">
                    <el-form-item label="主播身份证号" prop="hostIdcard">
                      <el-input size="mini" v-model="queryData.hostIdcard"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </div>
            <div class="main-table">
              <!--按钮列表组-->
              <div class="buttonlist" style="margin-bottom:10px">
                <router-link :to="{path:'/hostInfoEdit',query:{opType:'add'}}"><el-button size="small"><i class="el-icon-circle-plus"></i>新增</el-button></router-link>
              </div>
              <!--表格-->
              <main>
                <el-table
                  stripe
                  border
                  highlight
                  height="350px"
                  size="small"
                  style="width:100%"
                  v-loading="loading"
                  :data="tableData">
                  <el-table-column align="center" label="序号" width="50px" type="index"></el-table-column>
                  <!--主播房间号-->
                  <el-table-column align="center" label="主播房间号" min-width="100px" prop="hostRoom">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostRoom}}</span>
                    </template>
                  </el-table-column>
                  <!--直播类别-->
                  <el-table-column align="center" label="直播类别" min-width="100px" prop="hostType">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostType}}</span>
                    </template>
                  </el-table-column>
                  <!--直播状态-->
                  <el-table-column align="center" label="直播状态" min-width="100px" prop="hostFlag">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostFlag}}</span>
                    </template>
                  </el-table-column>
                  <!--直播标题-->
                  <el-table-column align="center" label="直播标题" min-width="150px" prop="hostTitle">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostTitle}}</span>
                    </template>
                  </el-table-column>
                  <!--主播姓名-->
                  <el-table-column align="center" label="主播姓名" min-width="100px" prop="hostName">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostName}}</span>
                    </template>
                  </el-table-column>
                  <!--主播昵称-->
                  <el-table-column align="center" label="主播昵称" min-width="120px" prop="hostNickname">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostNickname}}</span>
                    </template>
                  </el-table-column>
                  <!--主播账号-->
                  <el-table-column align="center" label="主播账号" min-width="150px" prop="hostAccount">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostAccount}}</span>
                    </template>
                  </el-table-column>
                  <!--主播性别-->
                  <el-table-column align="center" label="主播性别" min-width="100px" prop="hostGender">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostGender}}</span>
                    </template>
                  </el-table-column>
                  <!--主播年龄-->
                  <el-table-column align="center" label="主播年龄" min-width="100px" prop="hostAge">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostAge}}</span>
                    </template>
                  </el-table-column>
                  <!--主播身份证号-->
                  <el-table-column align="left" label="主播身份证号" min-width="200px" prop="hostIdcard">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostIdcard}}</span>
                    </template>
                  </el-table-column>
                  <!--主播电话-->
                  <el-table-column align="left" label="主播电话" min-width="150px" prop="hostPhone">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostPhone}}</span>
                    </template>
                  </el-table-column>
                  <!--主播银行账号-->
                  <el-table-column align="left" label="主播银行账号" min-width="200px" prop="hostBank">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostBank}}</span>
                    </template>
                  </el-table-column>
                  <!--主播地址-->
                  <el-table-column align="left" label="主播地址" min-width="300px" prop="hostLoc">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostLoc}}</span>
                    </template>
                  </el-table-column>
                  <!--操作栏-->
                  <el-table-column align="center" label="操作栏" width="150px" fixed="right">
                    <template slot-scope="scope">
                      <router-link :to="{path:'/edit',query:{opType:'update',id:scope.row.id}}"><i class="el-icon-edit"></i></router-link>
                      <i class="el-icon-delete" @click="deleteHostInfo(scope.row)"></i>
                    </template>
                  </el-table-column>
                </el-table>

                <!--分页-->
                <div class="block">
                  <el-pagination
                    layout="total, sizes, prev, pager, next, jumper"
                    :page-sizes="[5, 10, 15, 20]"
                    :total="queryData.total"
                    :current-page="queryData.currentPage"
                    :page-size="queryData.pageSize"
                    @current-change="handleCurrentChange"
                    @size-change="handleSizeChange">
                  </el-pagination>
                </div>
              </main>
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
import { getListHostInfo,deleteHostInfo } from '@/api/proj/base/hostinfo.js'
export default {
  name: 'hostinfo',
  components: {
    homenav,
    homeaside,
    homefooter
  },
  data() {
    return {
      loading: true,
      tableData: [],
      queryData: {
        total: 0,
        currentPage: 1,
        pageSize: 10,
        hostRoom: '',
        hostType: '',
        hostFlag: '',
        hostName: '',
        hostNickname: '',
        hostAccount: '',
        hostGender: '',
        hostAge: '',
        hostIdcard: ''
      },
      opType: '', //编辑类型
      id: 0
    }
  },

  created() {
    this.getList()
  },

  methods: {
    //获取数据列表
    getList() {
      this.loading = true
      var dataPost = JSON.stringify(this.queryData)
      getListHostInfo(dataPost).then(response => {
        this.loading = false
        this.tableData = response.data.list
        this.queryData.total = response.data.total
      }).catch(() => {
        this.loading = false
      })
    },

    //刷新
    doRefresh() {
      this.getList()
    },

    //清空
    onClear() {
      this.queryData.hostRoom = ''
      this.queryData.hostType = ''
      this.queryData.hostFlag = ''
      this.queryData.hostName = ''
      this.queryData.hostNickname = ''
      this.queryData.hostAccount = ''
      this.queryData.hostGender = ''
      this.queryData.hostAge = ''
      this.queryData.hostIdcard = ''
      this.doRefresh()
    },

    //删除
    deleteAudience(row) {
      this.$confirm(
        ("确定删除该主播信息吗？"),
        ("提示"),
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          if(row.id != null){
            var url = '/api/hostinfo/delete'
            this.$axios({
              method: "post",
              url: url,
              data: {
                id: row.id
              }
            }).then(() => {
              this.$notify({
                title: '删除成功',
                message: '删除成功',
                type: 'success',
                position: 'bottom-right'
              });
              this.doRefresh()
            }).catch(() => {
              this.$notify({
                title: '删除失败',
                message: '删除失败',
                type: 'error',
                position: 'bottom-right'
              });
            }) 
          }
        }).catch(() => {
          this.$notify.info({
          title: '删除已取消',
          message: '删除已取消',
          type: 'info',
          position: 'bottom-right'
        });
      });
    },

    //改变当前页
    handleCurrentChange(val) {
      this.queryData.currentPage = val
      this.getList()
    },

    //改变页面大小
    handleSizeChange(val) {
      this.queryData.pageSize = val
      this.getList()
    }

  }
}
</script>

<style>
.huangzi {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
}
.huanzgi-main {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
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
.main-header {  
  margin: 0 0 1% 0;
  padding: 0;
  width: 100%;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.main-header-title {
  display: flow-root;
  margin: 0;
  padding: 0;
  width: 100%;
}
.header-title-name {
  margin: 0;
  padding: 0;
  width: 11%;
  float: left;
  line-height: 3;
}
.header-title-button {
  margin: 0;
  padding: 0;
  width: 15%;
  float: right;
  line-height: 3;
}
.el-form {
  padding: 0 0 0 20px;
  text-align: left;
}
.el-col-6 {
  height: 45px;
}
.main-table {
  margin: 0 0 0 0;
  padding: 0;
  width: 100%;
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.buttonlist {
  margin: 10px 0 0 0;
  padding: 0;
  width: 7%;
}
</style>
