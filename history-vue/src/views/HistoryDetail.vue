<template>
    <div class="hisDetail">
        <div class="title">
            <span class="name">{{history.name}}</span>&nbsp;&nbsp;&nbsp;&nbsp;
            <span class="level"><span class="iconfont icon-gangweijibie"></span>{{history.level}}</span>
        </div>
        <div class="rule">
            <el-descriptions 
            title="挂号规则"
            :column='1'>
                <el-descriptions-item>预约限制：提前{{history.timeOfAppointment}}天</el-descriptions-item>
                <el-descriptions-item>退号限制：诊断前{{history.backNumber}}天</el-descriptions-item>
                <el-descriptions-item>医院工作时间：{{history.workingHours}}</el-descriptions-item>
            </el-descriptions>
            <el-descriptions 
            title="小提示"
            :column='1'>
                <el-descriptions-item
                v-for="(tip, index) in history.tips"
                :key="index">{{index+1}}.{{tip}}</el-descriptions-item>
            </el-descriptions>
        </div>
        <div class="chooseDepartment">
            <span>选择科室</span>
        </div>
        <el-row>
            <el-col :span='4'>
                <el-menu
                default-active="0"
                class="el-menu-vertical-demo"
                >
                    <el-menu-item 
                    v-for="(department, index) in departments"
                    :key="index"
                    :index="index+''">
                        <span>{{department.name}}</span>
                    </el-menu-item>
                </el-menu>
            </el-col>
            <el-col :span='19' :offset='1'>
                <el-descriptions 
                v-for="department in departments"
                :key="department.name"
                :title="department.name"
                :column='4'>
                    <el-descriptions-item 
                    v-for="(d, index) in department.detail"
                    :key="index"
                    style="background-color: red;">
                    <router-link to="/appointment">{{d}}</router-link>
                    </el-descriptions-item>
                </el-descriptions>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    methods:{
        goAppointment(d){
            console.log(d)
            this.$router.push({path: '/appointment', query: {department: d}})
        }
    },
    data(){
        return{
            history:{
                name: '贵港市西江农场医院',
                level: '一级甲等',
                timeOfAppointment: '1',
                workingHours:'周一-周五：8:00-11:30 14:00-17:30 周六-周日：8:00-11:30',
                backNumber: '1',
                tips: [
                    '携带身份证',
                    '同一科室同一天只能预约一个号源'
                ],
            },
            departments: [
                {
                    name: '普通外科医学部',
                    detail: [
                        '结直肠外科门诊',
                        '甲状腺外科门诊',
                        '胃肠肿瘤外科门诊',
                        '胃肠间质瘤门诊',
                        '腹膜后肿瘤外科门诊'
                    ]
                },
                {
                    name: '口腔科',
                    detail: [
                        '口腔内科',
                        '口腔外科',
                        '口腔正畸',
                        '口腔种植',
                        '儿童口腔',
                        '老年口腔',
                        '口腔修复'
                    ]
                },
                {
                    name: '内科',
                    detail: [
                        '内分泌科',
                        '风湿科',
                        '呼吸科',
                    ]
                }
            ]
        }
    }
}
</script>

<style scoped>
a{
    color: black;
    text-decoration: none;
}
.hisDetail{
    width: 1000px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
}
div.title .name{
    font-size: 25px;
    font-weight: bolder;
}
div.title .level{
    color: #999;
}

.chooseDepartment{
    font-weight: 700;
    font-size: 20px;
}
</style>