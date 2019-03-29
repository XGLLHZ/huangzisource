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
              <!--直播种类名称-->
              <el-col :span="4">
                <el-form-item label="castName" prop="castName">
                  <el-input size="mini" v-model="queryData.castName"></el-input>
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
        <!--直播种类名称-->
        <el-table-column align="center" label="castName" min-width="100px" prop="castName">
          <template slot-scope="scope">
            <span>{{scope.row.castName}}</span>
          </template>
        </el-table-column>
        <!--操作栏-->
        <el-table-column align="center" label="operation" width="150px" fixed="right">
          <template slot-scope="scope">
            <router-link :to="{path:'/edit',query:{opType:'update',id:scope.row.id}}"><i class="el-icon-edit"></i></router-link>
            <i class="el-icon-delete" @click="deleteCastType(scope.row)"></i>
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
        castName: ''
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
      var url = '/api/casttype/list'
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
      this.queryData.castName = ''
      this.doRefresh()
    },

    //删除
    deleteCastType(row) {
      this.$confirm(
        ("确定删除该类别信息吗？"),
        ("提示"),
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
          center: true
        }).then(() => {
          if(row.id != null){
            var url = '/api/casttype/delete'
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
