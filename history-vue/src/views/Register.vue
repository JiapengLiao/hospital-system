<template>
    <div class="register">
        <el-row class="row-bg" justify="space-around">
            <el-col :span="6">
                <el-form
                class="form"
                    :label-position="labelPosition"
                    label-width="100px"
                    :model="formLabelAlign"
                >
                    <h3>用户注册</h3>
                    <el-form-item label="用户名">
                        <el-input v-model="userInfo.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input
                            v-model="userInfo.password"
                            type="password"
                            show-password
                        />
                    </el-form-item>
                    <el-form-item label="重复密码">
                        <el-input
                            v-model="userInfo.passwordAgain"
                            type="password"
                            show-password
                        />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="register">注册</el-button>
                        <el-button @click="reset">重置表单</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script setup>
import {reactive} from 'vue'
import axios from 'axios'
const userInfo = reactive({
    username: '',
    password: '',
    passwordAgain: '',
})
const register = ()=>{
    axios.defaults.baseURL = 'http://localhost:9000'
    axios.post('/user/register?username=' + userInfo.username + '&password=' + userInfo.password, {
        username: userInfo.username,
        password: userInfo.password
    })
    .then(function () {
        console.log("注册成功\n");
        console.log(userInfo);
    })
    .catch(function () {
        console.log("注册失败");
    });
}
const reset = ()=>{
    userInfo.name = ''
    userInfo.password = ''
    userInfo.passwordAgain = ''
}
</script>

<style scoped>
.register{
    width: 100%;
    height: 100%;
    background-color: #E0E4E8;
}
.form{
    background-color: white;
    margin-top: 100px;
    padding: 50px;
}
h3{
    text-align: center;
}
</style>
