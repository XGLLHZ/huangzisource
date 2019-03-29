<template>
  <div>

    <!--头部-->
    <header style="margin-top:10px">
      <!--表单-->
      <el-form 
      :inline="true"
      :model="queryData"
      ref="queryRef">
        <div>
          <!--查询条件-->
          <div>
            <el-row :gutter="0">
              <!--粉丝姓名-->
              <el-col :span="4">
                <el-form-item label="hostFansName" prop="hostFansName">
                  <el-input size="mini" v-model="queryData.hostFansName"></el-input>
                </el-form-item>
              </el-col>
              <!--粉丝昵称-->
              <el-col :span="4">
                <el-form-item label="hostFansNickname" prop="hostFansNickname">
                  <el-input size="mini" v-model="queryData.hostFansNickname"></el-input>
                </el-form-item>
              </el-col>
              <!--粉丝账号-->
              <el-col :span="4">
                <el-form-item label="hostFansAccount" prop="hostFansAccount">
                  <el-input size="mini" v-model="queryData.hostFansAccount"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="0">
              <!--粉丝性别-->
              <el-col :span="4">
                <el-form-item label="hostFansGender" prop="hostFansGender">
                  <el-input size="mini" v-model="queryData.hostFansGender"></el-input>
                </el-form-item>
              </el-col>
              <!--粉丝年龄-->
              <el-col :span="4">
                <el-form-item label="hostFansAge" prop="hostFansAge">
                  <el-input size="mini" v-model="queryData.hostFansAge"></el-input>
                </el-form-item>
              </el-col>
              <!--粉丝身份证号-->
              <el-col :span="4">
                <el-form-item label="hostFansIdcard" prop="hostFansIdcard">
                  <el-input size="mini" v-model="queryData.hostFansIdcard"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </div>
          <!--按钮-->
          <div>
            <el-button size="mini" type="primary"><i class="el-icon-search" @click="getList()"></i>查询</el-button>
            <el-button size="mini"><i @click="onClear()"></i>清空</el-button>
          </div>
        </div>
      </el-form>
    </header>

    <!--按钮列表组-->
    <div class="buttonlist" style="margin-bottom:10px">
      <router-link :to="{path:'/edit',query:{opType:'add'}}"><el-button size="mini"><i class="el-icon-circle-plus"></i>新增</el-button></router-link>
    </div>

    <!--表格-->
    <main>
      <el-table
        stripe
        border
        highlight
        height="540px"
        style="width:85%"
        v-loading="loading"
        :data="tableData">
        <el-table-column align="center" label="Num" width="100px" type="index"></el-table-column>
        <!--粉丝姓名-->
        <el-table-column align="center" label="hostFansName" min-width="100px" prop="hostFansName">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansName}}</span>
          </template>
        </el-table-column>
        <!--粉丝昵称-->
        <el-table-column align="center" label="hostFansNickname" min-width="100px" prop="hostFansNickname">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansNickname}}</span>
          </template>
        </el-table-column>
        <!--粉丝账号-->
        <el-table-column align="center" label="hostFansAccount" min-width="100px" prop="hostFansAccount">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansAccount}}</span>
          </template>
        </el-table-column>
        <!--粉丝性别-->
        <el-table-column align="center" label="hostFansGender" min-width="80px" prop="hostFansGender">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansGender}}</span>
          </template>
        </el-table-column>
        <!--粉丝年龄-->
        <el-table-column align="center" label="hostFansAge" min-width="200px" prop="hostFansAge">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansAge}}</span>
          </template>
        </el-table-column>
        <!--粉丝身份证号-->
        <el-table-column align="center" label="hostFansIdcard" min-width="120px" prop="hostFansIdcard">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansIdcard}}</span>
          </template>
        </el-table-column>
        <!--粉丝电话-->
        <el-table-column align="center" label="hostFansPhone" min-width="300px" prop="hostFansPhone">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansPhone}}</span>
          </template>
        </el-table-column>
        <!--粉丝银行账号-->
        <el-table-column align="center" label="hostFansBank" min-width="300px" prop="hostFansBank">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansBank}}</span>
          </template>
        </el-table-column>
        <!--粉丝地址-->
        <el-table-column align="left" label="hostFansLoc" min-width="300px" prop="hostFansLoc">
          <template slot-scope="scope">
            <span>{{scope.row.hostFansLoc}}</span>
          </template>
        </el-table-column>
        <!--操作栏-->
        <el-table-column align="center" label="operation" width="150px" fixed="right">
          <template slot-scope="scope">
            <router-link :to="{path:'/edit',query:{opType:'update',id:scope.row.id}}"><i class="el-icon-edit"></i></router-link>
            <i class="el-icon-delete" @click="deleteHostFans(scope.row)"></i>
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
</template>

<script>
export default {
  name: 'hostfans',
  components: {},
  data() {
    return {
      loading: true,
      tableData: [],
      queryData: {
        total: 0,
        currentPage: 1,
        pageSize: 10,
        hostFansName: '',
        hostFansNickname: '',
        hostFansAccount: '',
        hostFansGender: '',
        hostFansAge: '',
        hostFansIdcard: ''
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
      var url = '/api/hostfans/list'
      this.$axios({
        method: "post",
        url: url,
        data: this.queryData
      }).then(response => {
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
      this.queryData.hostFansName = ''
      this.queryData.hostFansNickname = ''
      this.queryData.hostFansAccount = ''
      this.queryData.hostFansGender = ''
      this.queryData.hostFansAge = ''
      this.queryData.hostFansIdcard = ''
      this.doRefresh()
    },

    //删除
    deleteAudience(row) {
      this.$confirm(
        ("确定删除该粉丝信息吗？"),
        ("提示"),
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          if(row.id != null){
            var url = '/api/hostfans/delete'
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

</style>
