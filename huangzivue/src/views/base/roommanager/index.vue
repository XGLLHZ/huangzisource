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
                  <span>房管信息管理</span>
                </div>
                <div class="header-title-button">
                  <el-button size="small " type="primary"><i class="el-icon-search" @click="doRefresh()"></i>查询</el-button>
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
                  <!--房管姓名-->
                  <el-col :span="6">
                    <el-form-item label="房管姓名" prop="roomName">
                      <el-input size="mini" v-model="queryData.roomName"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--房管昵称-->
                  <el-col :span="6">
                    <el-form-item label="房管昵称" prop="roomNickname">
                      <el-input size="mini" v-model="queryData.roomNickname"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--房管账号-->
                  <el-col :span="6">
                    <el-form-item label="房管账号" prop="roomAccount">
                      <el-input size="mini" v-model="queryData.roomAccount"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--房管性别-->
                  <el-col :span="6">
                    <el-form-item label="房管性别" prop="roomGender">
                      <el-input size="mini" v-model="queryData.roomGender"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="0">
                  <!--房管年龄-->
                  <el-col :span="6">
                    <el-form-item label="房管年龄" prop="roomAge">
                      <el-input size="mini" v-model="queryData.roomAge"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--房管身份证号-->
                  <el-col :span="6">
                    <el-form-item label="房管身份证号" prop="roomIdcard">
                      <el-input size="mini" v-model="queryData.roomIdcard"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
              </el-form>
            </div>
            <div class="main-table">
              <!--按钮列表组-->
              <div class="buttonlist" style="margin-bottom:10px">
                <router-link :to="{path:'/roommanagerEdit',query:{opType:'add'}}"><el-button size="small"><i class="el-icon-circle-plus"></i>新增</el-button></router-link>
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
                  <!--房间号-->
                  <el-table-column align="center" label="房间号" min-width="100px" prop="roomRoom">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomRoom}}</span>
                    </template>
                  </el-table-column>
                  <!--房管姓名-->
                  <el-table-column align="center" label="房管姓名" min-width="100px" prop="roomName">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomName}}</span>
                    </template>
                  </el-table-column>
                  <!--房管昵称-->
                  <el-table-column align="center" label="房管昵称" min-width="150px" prop="roomNickname">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomNickname}}</span>
                    </template>
                  </el-table-column>
                  <!--房管账号-->
                  <el-table-column align="center" label="房管账号" min-width="100px" prop="roomAccount">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomAccount}}</span>
                    </template>
                  </el-table-column>
                  <!--房管性别-->
                  <el-table-column align="center" label="房管性别" min-width="100px" prop="roomGender">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomGender}}</span>
                    </template>
                  </el-table-column>
                  <!--房管年龄-->
                  <el-table-column align="center" label="房管年龄" min-width="100px" prop="roomAge">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomAge}}</span>
                    </template>
                  </el-table-column>
                  <!--房管身份证号-->
                  <el-table-column align="center" label="房管身份证号" min-width="200px" prop="roomIdcard">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomIdcard}}</span>
                    </template>
                  </el-table-column>
                  <!--房管电话-->
                  <el-table-column align="center" label="房管电话" min-width="150px" prop="roomPhone">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomPhone}}</span>
                    </template>
                  </el-table-column>
                  <!--房管银行账号-->
                  <el-table-column align="center" label="房管银行账号" min-width="200px" prop="roomBank">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomBank}}</span>
                    </template>
                  </el-table-column>
                  <!--房管地址-->
                  <el-table-column align="center" label="房管地址" min-width="300px" prop="roomLoc">
                    <template slot-scope="scope">
                      <span>{{scope.row.roomLoc}}</span>
                    </template>
                  </el-table-column>
                  <!--操作栏-->
                  <el-table-column align="center" label="操作栏" width="150px" fixed="right">
                    <template slot-scope="scope">
                      <router-link :to="{path:'/roommanagerEdit',query:{opType:'update',id:scope.row.id}}"><i style="margin: 0 10px 0 0" class="el-icon-edit"></i></router-link>
                      <i class="el-icon-delete" style="cursor: pointer;margin: 0 0 0 10px" @click="deleteInfo(scope.row)"></i>
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
import homenav from '@/components/homenav'
import homeaside from '@/components/homeaside'
import homefooter from '@/components/homefooter'
import { getListRoomManager,deleteRoomManager } from '@/api/proj/base/roommanager.js'
export default {
  name: 'roommanager',
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
        roomName: '',
        roomNickname: '',
        roomAccount: '',
        roomGender: '',
        roomAge: '',
        roomIdcard: ''
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
      getListRoomManager(this.queryData).then(response => {
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
      this.queryData.roomName = ''
      this.queryData.roomNickname = ''
      this.queryData.roomAccount = ''
      this.queryData.roomGender = ''
      this.queryData.roomAge = ''
      this.queryData.roomIdcard = ''
      this.doRefresh()
    },

    //删除
    deleteInfo(row) {
      this.$confirm(
        ("确定删除该房管信息吗？"),
        ("提示"),
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          if(row.id != null){
            deleteRoomManager(row.id).then(() => {
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




