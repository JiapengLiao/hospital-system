<template>
    <div class="myAppointment">
        <div class="card" v-for="n in 10" :key="n">
            <el-row>
                <el-col :span="2" class="imgWrap">
                    <img src="/images/weixin.png">
                </el-col>
                <el-col :span="8">
                    <h3>廖家鹏{{n}}</h3>
                    <span class="introduce">名医主任医师 名医胸外科</span>
                    <br>
                    <span class="address">深圳市人民医院</span>
                </el-col>
                <el-col class="stateWrap" :span="14">
                    <span class="state">待支付</span>
                </el-col>
            </el-row>
            <el-row class="signalInfo">
                <el-col :span='12'>
                    <span class="title">就诊时间:</span> &nbsp;&nbsp;
                    <span class="value">2022-03-03 15:00-15:30</span>
                </el-col>
                <el-col :span='12'>
                    <span class="title">费用:</span> &nbsp;&nbsp;
                    <span class="value">380.0元</span>
                </el-col>
            </el-row>
            <el-row>
                <el-button type='primary'>就诊指引</el-button>
                <el-button type='primary' @click="dialogVisible = true">取消预约</el-button>
                <el-button type='success'>去支付</el-button>
            </el-row>
        </div>

        <!--取消预约对话框-->
        <el-dialog
            v-model="dialogVisible"
            title="取消原因（可选）"
            width="30%"
        >
            <div class="seasonWrap">
                <div
                    v-for="(season, index) in seasons"
                    :key="index" 
                    :class="season.check?seasonActiveClass:seasonClass" 
                    @click="activeSeason(index)">{{season.season}}</div>
            </div>
            <template #footer>
            <span class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click="dialogVisible = false"
                >确认</el-button
                >
            </span>
            </template>
        </el-dialog>
    </div>
</template>

<script>
import { ref } from '@vue/reactivity'
export default {
    data() {
        return{
            dialogVisible: ref(false),
            seasonClass: ['season'],
            seasonActiveClass: ['season', 'seasonActive'],
            seasons: [
                {check: false, season: "不想去了"},
                {check: false, season: "地址填错了"},
                {check: false, season: "价格太贵"},
                {check: false, season: "暂时没时间"},
                {check: false, season: "觉得没救了"},
                {check: false, season: "地址"},
                {check: false, season: "太远了"},
            ],
        }
    },
    methods:{
        activeSeason(index){
            this.seasons[index].check = !this.seasons[index].check;
        }
    }
}
</script>

<style scoped>
.myAppointment{
    width: 1200px;
    margin: 20px auto;
    font-style: "微软雅黑";
}
.myAppointment .card{
    margin-bottom: 20px;
    padding: 10px;
    border-radius: 5px;
    background-color: #fff;
}
.myAppointment .card .imgWrap{
    text-align: center;
    display: flex;
    align-items: center;
}
.myAppointment .card img{
    border-radius: 50%;
    width: 60px;
    height: 60px;
    align-items: center;
}
.myAppointment .card h3{
    margin: 0;
    padding: 0;
    font-weight: bolder;
    font-size: 20px;
}
.myAppointment .card .introduce, .myAppointment .card .address{
    color: gray;
    font-size: 15px;
}
.signalInfo .title{
    font-size: 15px;
    color: gray;
}
.signalInfo .value{
    font-size: 15px;
    color: black;
    font-weight: 800;
}
.stateWrap{
    display: flex;
    align-items: center;
}
.stateWrap .state{
    display: block;
    width: 200px;
    height: 60px;
    text-align: center;
    line-height: 60px;
    border-radius: 10px;
    color: #fff;
    background-color: greenyellow;
    font-weight: bolder;
    font-size: 50px;
}
.seasonWrap{
    display: flex;
    flex-wrap: wrap;
}
.seasonWrap .season{
    border: 1px solid gray;
    border-radius: 5px;
    margin: 10px;
    padding: 5px;
    color: black;
}
.seasonWrap .seasonActive{
    border-color: greenyellow;
    color: greenyellow;
}
</style>