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
              <!--观众账号-->
              <el-col :span="4">
                <el-form-item label="audienceAccount" prop="audienceAccount">
                  <el-input size="mini" v-model="queryData.audienceAccount"></el-input>
                </el-form-item>
              </el-col>
              <!--观众姓名-->
              <el-col :span="4">
                <el-form-item label="audienceName" prop="audienceName">
                  <el-input size="mini" v-model="queryData.audienceName"></el-input>
                </el-form-item>
              </el-col>
              <!--观众昵称-->
              <el-col :span="4">
                <el-form-item label="audienceNickname" prop="audienceNickname">
                  <el-input size="mini" v-model="queryData.audienceNickname"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row :gutter="0">
              <!--观众性别-->
              <el-col :span="4">
                <el-form-item label="audienceGender" prop="audienceGender">
                  <el-input size="mini" v-model="queryData.audienceGender"></el-input>
                </el-form-item>
              </el-col>
              <!--观众年龄-->
              <el-col :span="4">
                <el-form-item label="audienceIdcard" prop="audienceIdcard">
                  <el-input size="mini" v-model="queryData.audienceIdcard"></el-input>
                </el-form-item>
              </el-col>
              <!--观众身份证号-->
              <el-col :span="4">
                <el-form-item label="audienceNickname" prop="audienceNickname">
                  <el-input size="mini" v-model="queryData.audienceNickname"></el-input>
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
        <!--观众姓名-->
        <el-table-column align="center" label="audienceName" min-width="100px" prop="audienceName">
          <template slot-scope="scope">
            <span>{{scope.row.audienceName}}</span>
          </template>
        </el-table-column>
        <!--观众昵称-->
        <el-table-column align="center" label="audienceNickname" min-width="100px" prop="audienceNickname">
          <template slot-scope="scope">
            <span>{{scope.row.audienceNickname}}</span>
          </template>
        </el-table-column>
        <!--观众账号-->
        <el-table-column align="center" label="audienceAccount" min-width="100px" prop="audienceAccount">
          <template slot-scope="scope">
            <span>{{scope.row.audienceAccount}}</span>
          </template>
        </el-table-column>
        <!--观众性别-->
        <el-table-column align="center" label="audienceGender" min-width="80px" prop="audienceGender">
          <template slot-scope="scope">
            <span>{{scope.row.audienceGender}}</span>
          </template>
        </el-table-column>
        <!--观众年龄-->
        <el-table-column align="center" label="audienceAge" min-width="200px" prop="audienceAge">
          <template slot-scope="scope">
            <span>{{scope.row.audienceAge}}</span>
          </template>
        </el-table-column>
        <!--观众身份证号-->
        <el-table-column align="center" label="audienceIdcard" min-width="120px" prop="audienceIdcard">
          <template slot-scope="scope">
            <span>{{scope.row.audienceIdcard}}</span>
          </template>
        </el-table-column>
        <!--观众电话-->
        <el-table-column align="center" label="audiencePhone" min-width="300px" prop="audiencePhone">
          <template slot-scope="scope">
            <span>{{scope.row.audiencePhone}}</span>
          </template>
        </el-table-column>
        <!--观众银行账号-->
        <el-table-column align="center" label="audienceBank" min-width="300px" prop="audienceBank">
          <template slot-scope="scope">
            <span>{{scope.row.audienceBank}}</span>
          </template>
        </el-table-column>
        <!--观众地址-->
        <el-table-column align="left" label="audienceLoc" min-width="300px" prop="audienceLoc">
          <template slot-scope="scope">
            <span>{{scope.row.audienceLoc}}</span>
          </template>
        </el-table-column>
        <!--操作栏-->
        <el-table-column align="center" label="operation" width="150px" fixed="right">
          <template slot-scope="scope">
            <router-link :to="{path:'/edit',query:{opType:'update',id:scope.row.id}}"><i class="el-icon-edit"></i></router-link>
            <i class="el-icon-delete" @click="deleteAudience(scope.row)"></i>
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
  name: 'audienceinfo',
  components: {},
  data() {
    return {
      loading: true,
      tableData: [],
      queryData: {
        total: 0,
        currentPage: 1,
        pageSize: 10,
        audienceAccount: '',
        audienceName: '',
        audienceNickname: '',
        audienceGender: '',
        audienceAge: '',
        audienceIdcard: ''
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
      var url = '/api/audienceinfo/list'
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
      this.queryData.audienceAccount = ''
      this.queryData.audienceName = ''
      this.queryData.audienceNickname = ''
      this.queryData.audienceGender = ''
      this.queryData.audienceAge = ''
      this.queryData.audienceIdcard = ''
      this.doRefresh()
    },

    //删除
    deleteAudience(row) {
      this.$confirm(
        ("确定删除该观众信息吗？"),
        ("提示"),
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          if(row.id != null){
            var url = '/api/audienceinfo/delete'
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
