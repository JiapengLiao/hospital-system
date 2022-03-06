<template>
    <div>
        <el-form-item label="用户名">
            <el-input v-model="username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input
                v-model="password"
                type="password"
                show-password
            />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" :plain="true" @click="login">登录</el-button>
        </el-form-item>
    </div>
</template>

<script>
import { ref } from '@vue/reactivity'
import { ElMessage } from 'element-plus'
// import axios from 'axios'
export default {
    data(){
        return{
            username: ref(""),
            password: ref(""),
        }
    },
    methods:{
        login(){
            // 上面的请求也可以这样做
            this.$axios.get('/api/user/login', {
                params: {
                    username: this.username,
                    password: this.password,
                }
            })
            .then(function (response) {
                console.log(response);
                if(response.data=="登陆成功"){
                    ElMessage.success("登录成功")
                }else{
                    ElMessage.error("用户名或密码错误")
                }
            })
            .catch(function (error) {
                console.log(error);
            });
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