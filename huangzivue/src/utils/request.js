import axios from 'axios'
import { Message } from 'element-ui'

//创建axios实例
const axioseg = axios.create({
  baseURL: process.env.BASE_API,   //api的base_url
  timeout: 50000,   //请求超时时间
  headers: {
   //'Content-Type': "application/json;charset=UTF-8",
   'Access-Control-Allow-Origin': "*"   //解决‘NO Access-Control-Allow-Origin’问题
   //'Access-Control-Allow-Headers': "X-Requested-With,Content-Type",
   //'Access-Control-Allow-Methods': "PUT,POST,GET,DELETE,OPTIONS"
  }
})

axioseg.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'   //注意content-type的配置只能以.post的形式，否则无效

//添加请求拦截器
axioseg.interceptors.request.use(config => {
  return config;
}, error => {
  Message.error({message: '请求超时！'+error});
});

//添加响应拦截器
axioseg.interceptors.response.use(data => {
  if (data.status && data.status == 200 && data.data.status ==500) {
    Message.error({message: data.data.msg});
    return;
  }
  if (data.data.msg) {
    Message.success({message: data.data.msg});
  }
  return data;
}, err => {
  if (err.response.status == 404 || err.response.status == 504) {
    Message.error({message: '服务器死妈了！'});
  } else if (err.response.status == 401) {
    Message.error({message: err.response.data.data.msg});
  } else {
    Message.error({message: '未知错误！'});
  }
});

export default axios
