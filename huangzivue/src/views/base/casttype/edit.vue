<!--新增/编辑模板-->
<template>
  <div>

    <!--按钮列表组-->
    <div>
      <el-button type="primary" size="mini" @click="confirm()"><i class="el-icon-success"></i>保存</el-button>
      <el-button size="mini"><i class="el-icon-news"></i>提交审批</el-button>
    </div>

    <!--主体-->
    <div>
      <el-form 
      :inline="true" 
      :model="castTypeObj"
      :rules="rules"
      ref="castTypeRef">
        <el-row :gutter="0">
          <!--观众姓名-->
          <el-col :span="4">
            <el-form-item label="castName" prop="castName">
              <el-input size="mini" v-model="castTypeObj.castName"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
    </div>

  </div>
</template>

<script>
export default {
  name: 'edit',
  data() {
    return {
      castTypeObj: {
        id: '',
        castName: ''
      },
      rules: {
        castName: [
          {
            required: true,
            type: 'string',
            message: '直播种类名称不能为空！',
            trigger: 'blur'
          }
        ]
      }
    }
  },

  created() {
    this.getById()
  },

  methods: {

    //保存
    confirm() {
      if (this.$route.query.opType === 'add') {
        this.$refs.castTypeRef.validate((valid) => {
          if (valid) {
            var url = '/api/casttype/insert'
            this.$axios({
              method: "post",
              url: url,
              data: this.castTypeObj
            }).then(() => {
              this.$notify({
                title: '保存成功',
                message: '保存成功',
                type: 'success',
                position: 'bottom-right'
              });
            }).catch(() => {
              this.$notify({
                title: '保存失败',
                message: '保存失败',
                type: 'error',
                position: 'bottom-right'
              });
            })
          } else {
          }
        });
        this.$router.go(1)
      }
      if (this.$route.query.opType === 'update') {
        this.$refs.castTypeRef.validate((valid) => {
          if (valid) {
            var url = '/api/casttype/update'
            this.$axios({
              method: "post",
              url: url,
              data: this.castTypeObj
            }).then(() => {
              this.$notify({
                title: '修改成功',
                message: '修改成功',
                type: 'success',
                position: 'bottom-right'
              });
            }).catch(() => {
              this.$notify({
                title: '修改失败',
                message: '修改失败',
                type: 'error',
                position: 'bottom-right'
              });
            })
          } else {
          }
        });
      }
      this.$router.go(-1)
    },

    //获取单个观众信息-修改时
    getById() {
      if (this.$route.query.opType === 'update' && this.$route.query.id != null) {
        var url = '/api/casttype/get'
        this.$axios({
          method: 'post',
          url: url,
          data: {
            id: this.$route.query.id
          }
        }).then(response =>{
          this.castTypeObj = response.data
        }).catch(() =>{});
      }
    }

  }
}
</script>

<style>

</style>
