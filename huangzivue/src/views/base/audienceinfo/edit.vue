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
      :model="audienceinfoObj"
      :rules="rules"
      ref="audienceRef">
        <el-row :gutter="0">
          <!--观众姓名-->
          <el-col :span="4">
            <el-form-item label="audienceName" prop="audienceName">
              <el-input size="mini" v-model="audienceinfoObj.audienceName"></el-input>
            </el-form-item>
          </el-col>
          <!--观众昵称-->
          <el-col :span="4">
            <el-form-item label="audienceNickname" prop="audienceNickname">
              <el-input size="mini" v-model="audienceinfoObj.audienceNickname"></el-input>
            </el-form-item>
          </el-col>
          <!--观众账号-->
          <el-col :span="4">
            <el-form-item label="audienceAccount" prop="audienceAccount">
              <el-input size="mini" v-model="audienceinfoObj.audienceAccount"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="0">
          <!--观众性别-->
          <el-col :span="4">
            <el-form-item label="audienceGender" prop="audienceGender">
              <el-input size="mini" v-model="audienceinfoObj.audienceGender"></el-input>
            </el-form-item>
          </el-col>
          <!--观众年龄-->
          <el-col :span="4">
            <el-form-item label="audienceAge" prop="audienceAge">
              <el-input size="mini" v-model="audienceinfoObj.audienceAge"></el-input>
            </el-form-item>
          </el-col>
          <!--观众身份证号-->
          <el-col :span="4">
            <el-form-item label="audienceIdcard" prop="audienceIdcard">
              <el-input size="mini" v-model="audienceinfoObj.audienceIdcard"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="0">
          <!--观众电话-->
          <el-col :span="4">
            <el-form-item label="audiencePhone" prop="audiencePhone">
              <el-input size="mini" v-model="audienceinfoObj.audiencePhone"></el-input>
            </el-form-item>
          </el-col>
          <!--观众银行账号-->
          <el-col :span="4">
            <el-form-item label="audienceBank" prop="audienceBank">
              <el-input size="mini" v-model="audienceinfoObj.audienceBank"></el-input>
            </el-form-item>
          </el-col>
          <!--观众地址-->
          <el-col :span="4">
            <el-form-item label="audienceLoc" prop="audienceLoc">
              <el-input size="mini" v-model="audienceinfoObj.audienceLoc"></el-input>
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
      audienceinfoObj: {
        id: '',
        audienceName: '',
        audienceNickname: '',
        audienceAccount: '',
        audienceGender: '',
        audienceAge: '',
        audienceIdcard: '',
        audiencePhone: '',
        audienceBank: '',
        audienceLoc: ''
      },
      rules: {
        audienceName: [
          {
            required: true,
            type: 'string',
            message: '观众账号不能为空！',
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
        this.$refs.audienceRef.validate((valid) => {
          if (valid) {
            var url = '/api/audienceinfo/insert'
            this.$axios({
              method: "post",
              url: url,
              data: this.audienceinfoObj
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
        this.$refs.audienceRef.validate((valid) => {
          if (valid) {
            var url = '/api/audienceinfo/update'
            this.$axios({
              method: "post",
              url: url,
              data: this.audienceinfoObj
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
        var url = '/api/audienceinfo/get'
        this.$axios({
          method: 'post',
          url: url,
          data: {
            id: this.$route.query.id
          }
        }).then(response =>{
          this.audienceinfoObj = response.data
        }).catch(() =>{});
      }
    }

  }
}
</script>

<style>

</style>
