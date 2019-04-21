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
                      :model="roommanagerObj"
                      :rules="rules"
                      label-position="right"
                      label-width="200px"
                      ref="roommanagerRef">
                      <el-row :gutter="0">
                        <span class="el-form-item" style="margin: 10px">房管信息管理>新增</span>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="姓名" prop="roomName">
                            <el-input size="mini" style="width: 152px" placeholder="请与证件姓名保持一致" v-model="roommanagerObj.roomName"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="中华人民共和国居民身份证" prop="roomIdcard">
                            <el-input size="mini" placeholder="请填写有效的证件号码" v-model="roommanagerObj.roomIdcard"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="性别" prop="roomGender">
                            <el-select size="mini" v-model="roommanagerObj.roomGender">
                              <el-option label="男" value="男"></el-option>
                              <el-option label="女" value="女"></el-option>
                            </el-select>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="出生日期" prop="roomAge">
                            <el-date-picker size="mini" placeholder="选择日期" v-model="roommanagerObj.roomAge"></el-date-picker>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="家庭住址" prop="roomLoc">
                            <el-input size="mini" style="width: 300px" placeholder="请与证件信息保持一致" v-model="roommanagerObj.roomLoc"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="联系电话" prop="roomPhone">
                            <el-input size="mini" v-model="roommanagerObj.roomPhone"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="银行账号" prop="roomBank">
                            <el-input size="mini" v-model="roommanagerObj.roomBank"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row :gutter="0">
                        <el-col>
                          <el-form-item label="超管昵称" prop="roomNickname">
                            <el-input size="mini" v-model="roommanagerObj.roomNickname"></el-input>
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
import { addRoomManager, getByIdRoomManager, updateRoomManager } from '@/api/proj/base/roommanager.js'
export default {
  name: 'roommanagerEdit',
  components: {
    homenav,
    homeaside,
    homefooter
  },
  data() {
    return {
      roommanagerObj: {
        roomAccount: this.$store.state.user.userName,
        roomPassword: this.$store.state.user.userPassword,
        roomName: '',
        roomGender: '',
        roomAge: '',
        roomNickname: '',
        roomIdcard: '',
        roomPhone: '',
        roomBank: '',
        roomLoc: ''
      },
      rules: {
        roomName: [
          { required: true, message: '姓名不能为空！', trigger: 'blur' }
        ],
        roomIdcard: [
          { required: true, message: '证件号码不能为空！', trigger: 'blur' },
          { min: 18, max: 18, message: '证件号码格式不正确！', trigger: 'blur' }
        ],
        roomGender: [
          { required: true, message: '性别不能为空！', trigger: 'blur' }
        ],
        roomAge: [
          { required: true, message: '出生日期不能为空！', trigger: 'blur' }
        ],
        superLoc: [
          { required: true, message: '家庭住址不能为空！', trigger: 'blur' }
        ],
        roomPhone: [
          { required: true, message: '联系电话不能为空！', trigger: 'blur' },
          { min: 11, max: 11, message: '手机号格式不正确！', trigger: 'blur' }
        ],
        roomBank: [
          { required: true, message: '银行账号不能为空！', trigger: 'blur' },
          { min: 16, max: 19, message: '银行账号格式不正确！', trigger: 'blur' }
        ],
        roomNickname: [
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
        this.$refs.roommanagerRef.validate((valid) => {
          if (valid) {
            addRoomManager(this.roommanagerObj).then(() => {
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
          this.$refs.roommanagerRef.validate((valid) => {
              if (valid) {
                  updateRoomManager(this.roommanagerObj).then(() => {
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
            getByIdRoomManager(this.$route.query.id).then(response => {
                this.roommanagerObj = response.data
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




