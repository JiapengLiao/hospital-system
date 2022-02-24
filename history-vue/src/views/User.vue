<template>
    <div class="user">
        <el-row class="row-bg" justify="space-around">
            <el-col :span="6">
                <el-form
                    class="form"
                    label-position="right"
                    label-width="100px"
                >
                    <h3>
                        <router-link to="/register">注册</router-link> 
                        | 
                        <router-link to="/login">登录</router-link>
                    </h3>
                    <router-view></router-view>
                </el-form>
            </el-col>
        </el-row>
    </div>
</template>

<script setup>
</script>

<style scoped>
.user{
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
h3 a{
    color: black;
    text-decoration: none;
}
h3 a.router-link-active{
    color: cyan;
    text-decoration: cyan;
}
</style>
