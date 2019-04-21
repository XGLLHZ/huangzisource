<template>
  <div class="huangzi">
    <homenav></homenav>
    <div class="huanzgi-main">
      <homeaside style="float:left"></homeaside>
      <div class="main">
        <div class="main-content">
          <div class="main-content-info">
            <div class="add-info">
              <el-form
                      :inline="true"
                      :model="supermanagerObj"
                      :rules="rules"
                      label-position="right"
                      label-width="200px"
                      ref="supermanagerRef">
                      <el-row :gutter="0">
                        <span class="el-form-item" style="margin: 10px">超管信息管理>新增</span>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="姓名" prop="superName">
                            <el-input size="mini" style="width: 152px" placeholder="请与证件姓名保持一致" v-model="supermanagerObj.superName"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="中华人民共和国居民身份证" prop="superIdcard">
                            <el-input size="mini" placeholder="请填写有效的证件号码" v-model="supermanagerObj.superIdcard"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="性别" prop="superGender">
                            <el-select size="mini" v-model="supermanagerObj.superGender">
                              <el-option label="男" value="男"></el-option>
                              <el-option label="女" value="女"></el-option>
                            </el-select>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="出生日期" prop="superAge">
                            <el-date-picker size="mini" placeholder="选择日期" v-model="supermanagerObj.superAge"></el-date-picker>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="家庭住址" prop="superLoc">
                            <el-input size="mini" style="width: 300px" placeholder="请与证件信息保持一致" v-model="supermanagerObj.superLoc"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="联系电话" prop="superPhone">
                            <el-input size="mini" v-model="supermanagerObj.superPhone"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="银行账号" prop="superBank">
                            <el-input size="mini" v-model="supermanagerObj.superBank"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="超管昵称" prop="superNickname">
                            <el-input size="mini" v-model="supermanagerObj.superNickname"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
              </el-form>
              <el-button style="margin: 5px 5pxpx 10px 0px;width:130px" type="primary" @click="confirm()">提交</el-button>
              <el-button style="margin: 5px 0px 10px 10px;width:130px" @click="cancel()">取消</el-button>
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
import { addSuperManager, getByIdSuperManager, updateSuperManager } from '@/api/proj/base/supermanager.js'
export default {
  name: 'supermanagerEdit',
  components: {
    homenav,
    homeaside,
    homefooter
  },
  data() {
    return {
      supermanagerObj: {
        superAccount: this.$store.state.user.userName,
        superPassword: this.$store.state.user.userPassword,
        superName: '',
        superGender: '',
        superAge: '',
        superNickname: '',
        superIdcard: '',
        superPhone: '',
        superBank: '',
        superLoc: ''
      },
      rules: {
        superName: [
          { required: true, message: '姓名不能为空！', trigger: 'blur' }
        ],
        superIdcard: [
          { required: true, message: '证件号码不能为空！', trigger: 'blur' },
          { min: 18, max: 18, message: '证件号码格式不正确！', trigger: 'blur' }
        ],
        superGender: [
          { required: true, message: '性别不能为空！', trigger: 'blur' }
        ],
        superAge: [
          { required: true, message: '出生日期不能为空！', trigger: 'blur' }
        ],
        superLoc: [
          { required: true, message: '家庭住址不能为空！', trigger: 'blur' }
        ],
        superPhone: [
          { required: true, message: '联系电话不能为空！', trigger: 'blur' },
          { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
        ],
        superBank: [
          { required: true, message: '银行账号不能为空！', trigger: 'blur' },
          { min: 16, max: 19, message: '银行账号格式不正确！', trigger: 'blur' }
        ],
        superNickname: [
          { required: true, message: '昵称不能为空！', trigger: 'blur' }
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
        this.$refs.supermanagerRef.validate((valid) => {
          if (valid) {
            addSuperManager(this.supermanagerObj).then(() => {
              this.$notify({
                title: '保存成功',
                message: '保存成功',
                type: 'success',
                position: 'bottom-right'
              });
            this.$router.go(-1)
            }).catch(() => {
              this.$notify({
                title: '保存失败',
                message: '保存失败',
                type: 'error',
                position: 'bottom-right'
              });
            })
          } else {}
        });
      }
      if (this.$route.query.opType === 'update') {
          this.$refs.supermanagerRef.validate((valid) => {
              if (valid) {
                  updateSuperManager(this.supermanagerObj).then(() => {
                        this.$notify({
                        title: '修改成功',
                        message: '修改成功',
                        type: 'success',
                        position: 'bottom-right'
                    });
                    this.$router.go(-1)
                  }).catch(() => {
                      this.$notify({
                        title: '修改失败',
                        message: '修改失败',
                        type: 'error',
                        position: 'bottom-right'
                    });
                  })
              }
          })
      } else {}
    },

    cancel() {
        this.$router.go(-1)
    },

    getById() {
        if(this.$route.query.opType === 'update' && this.$route.query.id != null) {
            getByIdSuperManager(this.$route.query.id).then(response => {
                this.supermanagerObj = response.data
            }).catch(() => {});
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
  border: 1px solid #E5E4E4;
  background-color: white;
  border-radius: 5px;
}
.el-form-item {
  margin: 0 0 10px 10px;
  float: left;
}
</style>


