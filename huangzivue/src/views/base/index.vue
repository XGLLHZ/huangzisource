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
              :model="queryData"
              ref="queryRef">
                <el-row :gutter="0">
                  <!--主播房间号-->
                  <el-col :span="6">
                    <el-form-item label="hostRoom" prop="hostRoom">
                      <el-input size="mini" v-model="queryData.hostRoom"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--直播类别-->
                  <el-col :span="6">
                    <el-form-item label="hostType" prop="hostType">
                      <el-input size="mini" v-model="queryData.hostType"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--直播状态-->
                  <el-col :span="6">
                    <el-form-item label="hostFlag" prop="hostFlag">
                      <el-input size="mini" v-model="queryData.hostFlag"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播姓名-->
                  <el-col :span="6">
                    <el-form-item label="hostName" prop="hostName">
                      <el-input size="mini" v-model="queryData.hostName"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="0">
                  <!--主播昵称-->
                  <el-col :span="6">
                    <el-form-item label="hostNickname" prop="hostNickname">
                      <el-input size="mini" v-model="queryData.hostNickname"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播账号-->
                  <el-col :span="6">
                    <el-form-item label="hostAccount" prop="hostAccount">
                      <el-input size="mini" v-model="queryData.hostAccount"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播性别-->
                  <el-col :span="6">
                    <el-form-item label="hostGender" prop="hostGender">
                      <el-input size="mini" v-model="queryData.hostGender"></el-input>
                    </el-form-item>
                  </el-col>
                  <!--主播年龄-->
                  <el-col :span="6">
                    <el-form-item label="hostAge" prop="hostAge">
                      <el-input size="mini" v-model="queryData.hostAge"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row :gutter="0">
                  <!--主播身份证号-->
                  <el-col :span="6">
                    <el-form-item label="hostIdcard" prop="hostIdcard">
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
                  style="width:100%"
                  v-loading="loading"
                  :data="tableData">
                  <el-table-column align="center" label="Num" width="100px" type="index"></el-table-column>
                  <!--主播房间号-->
                  <el-table-column align="center" label="hostRoom" min-width="100px" prop="hostRoom">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostRoom}}</span>
                    </template>
                  </el-table-column>
                  <!--直播类别-->
                  <el-table-column align="center" label="hostType" min-width="100px" prop="hostType">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostType}}</span>
                    </template>
                  </el-table-column>
                  <!--直播状态-->
                  <el-table-column align="center" label="hostFlag" min-width="100px" prop="hostFlag">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostFlag}}</span>
                    </template>
                  </el-table-column>
                  <!--直播标题-->
                  <el-table-column align="center" label="hostTitle" min-width="80px" prop="hostTitle">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostTitle}}</span>
                    </template>
                  </el-table-column>
                  <!--主播姓名-->
                  <el-table-column align="center" label="hostName" min-width="200px" prop="hostName">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostName}}</span>
                    </template>
                  </el-table-column>
                  <!--主播昵称-->
                  <el-table-column align="center" label="hostNickname" min-width="120px" prop="hostNickname">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostNickname}}</span>
                    </template>
                  </el-table-column>
                  <!--主播账号-->
                  <el-table-column align="center" label="hostAccount" min-width="300px" prop="hostAccount">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostAccount}}</span>
                    </template>
                  </el-table-column>
                  <!--主播性别-->
                  <el-table-column align="center" label="hostGender" min-width="300px" prop="hostGender">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostGender}}</span>
                    </template>
                  </el-table-column>
                  <!--主播年龄-->
                  <el-table-column align="left" label="hostAge" min-width="300px" prop="hostAge">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostAge}}</span>
                    </template>
                  </el-table-column>
                  <!--主播身份证号-->
                  <el-table-column align="left" label="hostIdcard" min-width="300px" prop="hostIdcard">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostIdcard}}</span>
                    </template>
                  </el-table-column>
                  <!--主播电话-->
                  <el-table-column align="left" label="hostPhone" min-width="300px" prop="hostPhone">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostPhone}}</span>
                    </template>
                  </el-table-column>
                  <!--主播银行账号-->
                  <el-table-column align="left" label="hostBank" min-width="300px" prop="hostBank">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostBank}}</span>
                    </template>
                  </el-table-column>
                  <!--主播地址-->
                  <el-table-column align="left" label="hostLoc" min-width="300px" prop="hostLoc">
                    <template slot-scope="scope">
                      <span>{{scope.row.hostLoc}}</span>
                    </template>
                  </el-table-column>
                  <!--操作栏-->
                  <el-table-column align="center" label="operation" width="150px" fixed="right">
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