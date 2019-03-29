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
      :model="hostFansObj"
      :rules="rules"
      ref="hostFansRef">
        <el-row :gutter="0">
          <!--粉丝姓名-->
          <el-col :span="4">
            <el-form-item label="hostFansName" prop="hostFansName">
              <el-input size="mini" v-model="hostFansObj.hostFansName"></el-input>
            </el-form-item>
          </el-col>
          <!--粉丝昵称-->
          <el-col :span="4">
            <el-form-item label="hostFansNickname" prop="hostFansNickname">
              <el-input size="mini" v-model="hostFansObj.hostFansNickname"></el-input>
            </el-form-item>
          </el-col>
          <!--粉丝账号-->
          <el-col :span="4">
            <el-form-item label="hostFansAccount" prop="hostFansAccount">
              <el-input size="mini" v-model="hostFansObj.hostFansAccount"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="0">
          <!--粉丝性别-->
          <el-col :span="4">
            <el-form-item label="hostFansGender" prop="hostFansGender">
              <el-input size="mini" v-model="hostFansObj.hostFansGender"></el-input>
            </el-form-item>
          </el-col>
          <!--粉丝年龄-->
          <el-col :span="4">
            <el-form-item label="hostFansAge" prop="hostFansAge">
              <el-input size="mini" v-model="hostFansObj.hostFansAge"></el-input>
            </el-form-item>
          </el-col>
          <!--粉丝身份证号-->
          <el-col :span="4">
            <el-form-item label="hostFansIdcard" prop="hostFansIdcard">
              <el-input size="mini" v-model="hostFansObj.hostFansIdcard"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="0">
          <!--粉丝电话-->
          <el-col :span="4">
            <el-form-item label="hostFansPhone" prop="hostFansPhone">
              <el-input size="mini" v-model="hostFansObj.hostFansPhone"></el-input>
            </el-form-item>
          </el-col>
          <!--粉丝银行账号-->
          <el-col :span="4">
            <el-form-item label="hostFansBank" prop="hostFansBank">
              <el-input size="mini" v-model="hostFansObj.hostFansBank"></el-input>
            </el-form-item>
          </el-col>
          <!--粉丝地址-->
          <el-col :span="4">
            <el-form-item label="hostFansLoc" prop="hostFansLoc">
              <el-input size="mini" v-model="hostFansObj.hostFansLoc"></el-input>
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
      hostFansObj: {
        id: '',
        hostFansName: '',
        hostFansNickname: '',
        hostFansAccount: '',
        hostFansGender: '',
        hostFansAge: '',
        hostFansIdcard: '',
        hostFansPhone: '',
        hostFansBank: '',
        hostFansLoc: ''
      },
      rules: {
        hostFansName: [
          {
            required: true,
            type: 'string',
            message: '粉丝账号不能为空！',
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
        this.$refs.hostFansRef.validate((valid) => {
          if (valid) {
            var url = '/api/hostfans/insert'
            this.$axios({
              method: "post",
              url: url,
              data: this.hostFansObj
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
        this.$refs.hostFansRef.validate((valid) => {
          if (valid) {
            var url = '/api/hostfans/update'
            this.$axios({
              method: "post",
              url: url,
              data: this.hostFansObj
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
        var url = '/api/hostfans/get'
        this.$axios({
          method: 'post',
          url: url,
          data: {
            id: this.$route.query.id
          }
        }).then(response =>{
          this.hostFansObj = response.data
        }).catch(() =>{});
      }
    }

  }
}
</script>

<style>

</style>
