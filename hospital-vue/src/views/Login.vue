<template>
  <div>
    <el-form-item label="用户名">
      <el-input></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input
          type="password"
          show-password
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="register"><router-link to="/index">登录</router-link></el-button>
    </el-form-item>
  </div>
</template>

<script>
export default {
    methods:{
        register(){
          console.log(123)
        }
    }
}
</script>

<style scoped>
  .form{
      background-color: white;
      margin-top: 100px;
      padding: 50px;
  }
  a{
    text-decoration: none;
    color: #fff;
  }
</style>