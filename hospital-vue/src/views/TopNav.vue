<template>
    <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    >
        <el-menu-item index="1">预约挂号</el-menu-item>       
        <el-menu-item index="2">通知通告</el-menu-item>
        <el-sub-menu index="3">
            <template #title>我的</template>
            <el-menu-item index="3-1" @click="myAppointment">我的预约</el-menu-item>
            <el-menu-item index="3-2">item two</el-menu-item>
            <el-menu-item index="3-3">item three</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="4" @click="this.$router.push({path: '/login'})">登录</el-menu-item>
    </el-menu>
</template>

<script>
import {ref} from "vue"
export default{
    data(){
        return{
            activeIndex: ref("1")
        }
    },
    methods:{
        myAppointment(){
            this.$router.push({path: "/myAppointment"})
        }
    }
}
</script>

<style scoped>

</style>