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
        <el-sub-menu index="2">
            <template #title>在线问诊</template>
            <el-menu-item index="2-1">item one</el-menu-item>
            <el-menu-item index="2-2">item two</el-menu-item>
            <el-menu-item index="2-3">item three</el-menu-item>
            <el-sub-menu index="2-4">
                <template #title>item four</template>
                <el-menu-item index="2-4-1">item one</el-menu-item>
                <el-menu-item index="2-4-2">item two</el-menu-item>
                <el-menu-item index="2-4-3">item three</el-menu-item>
            </el-sub-menu>
        </el-sub-menu>
        <el-menu-item index="3">通知通告</el-menu-item>
        <el-sub-menu index="4">
            <template #title>我的</template>
            <el-menu-item index="4-1" @click="myAppointment">我的预约</el-menu-item>
            <el-menu-item index="4-2">item two</el-menu-item>
            <el-menu-item index="4-3">item three</el-menu-item>
        </el-sub-menu>
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