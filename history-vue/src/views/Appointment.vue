<template>
    <div class="appointment">
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">平南县平山镇六峡村卫生室</el-breadcrumb-item>
            <el-breadcrumb-item>输血科</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="empty" v-if="activeDoctors.length==0">暂时无号</h1>
        <el-table
        @row-click='rowClick'
         :row-class-name="tableRowClassName" v-if="activeDoctors.length>0" :data="activeDoctors" style="width: 100%">
            <el-table-column align='center' prop="name" label="姓名" />
            <el-table-column align='center' prop="position" label="职称" />
            <el-table-column align='center' prop="price" label="价格" />
            <el-table-column prop="introduce" label="自我介绍" />
            <el-table-column prop="count" label="剩余" />
            <el-table-column align='center' label="操作">
                <el-button @click="displayTime" type="success">预约</el-button>
            </el-table-column>
        </el-table>
        <div class="pagination-block">
            <el-row justify="space-between">
                <el-col
                :span='3'
                v-for="(signalSource, index) in signalSources[currentPage-1]"
                :key="index">
                    <el-card 
                    :body-style='signalBodyStyle'
                    class="box-card"
                    @click="chooseSignal(signalSource.date)">
                        <div 
                        class="text item"
                        >
                            <div class="date">{{ signalSource.date }}</div>
                            <div class="state">{{ signalSource.state }}</div>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
            <el-pagination 
            layout="prev, pager, next" 
            :total="40"
            :current-page='currentPage'
            @current-change='pageChange'></el-pagination>
        </div>

        <!-- 选择时间 对话框 -->
        <el-dialog class="chooseSignalTime" @opened='getAllTime' v-model="timeChooseVisible" title="选择门诊时间">
            <el-collapse v-model="activeTime">
                <el-collapse-item title="上午" name="1">
                    <ul class="allTime">
                        <li
                        @click="confirmInfo"
                        class="allTime-item"
                        v-for="(timeAndCount, index) in timeAndCounts[0]"
                        :key="index">
                            <el-row justify="space-between">
                                <el-col :span='4'>
                                    <span class="dayPeriod">{{timeAndCount.time}}</span>
                                </el-col>
                                <el-col :span='4'>
                                    <span class="signalText">余号<span class="count">{{timeAndCount.count}}</span>个</span>
                                </el-col>
                            </el-row>
                        </li>
                    </ul>
                </el-collapse-item>
                <el-collapse-item title="下午" name="2">
                    <ul class="allTime">
                        <li
                        @click="confirmInfo"
                        class="allTime-item"
                        v-for="(timeAndCount, index) in timeAndCounts[1]"
                        :key="index">
                            <el-row justify="space-between">
                                <el-col :span='4'>
                                    <span class="dayPeriod">{{timeAndCount.time}}</span>
                                </el-col>
                                <el-col :span='4'>
                                    <span class="signalText">余号<span class="count">{{timeAndCount.count}}</span>个</span>
                                </el-col>
                            </el-row>
                        </li>
                    </ul>
                </el-collapse-item>
            </el-collapse>
        </el-dialog>
        <!-- 确认信息对话框 -->
        <el-dialog
            v-model="confirmInfoVisible"
            destroy-on-close
            title="确认信息"
            width="30%"
        >
            <ul>
                <li>
                    <span class="title">医生</span>
                    <span class="content">张三</span>
                </li>
                <li>
                    <span class="title">就诊日期</span>
                    <span class="content"></span>
                </li>
                <li>
                    <span class="title">就诊时间</span>
                    <span class="content">张三</span>
                </li>
                <li>
                    <span class="title">费用</span>
                    <span class="content">张三</span>
                </li>
                <li>
                    <span class="title">就诊地址</span>
                    <span class="content">张三</span>
                </li>
            </ul>
            <el-button @click="signalConfirm" type='success'>确认</el-button>
        </el-dialog>
        <!-- 支付对话框 -->
        <el-dialog
            v-model="payVisible"
            destroy-on-close
            title="确认信息"
            width="30%"
        >
            <h4>使用微信支付40元</h4>
            <img src="/images/weixin.png" alt="">
        </el-dialog>
    </div>
</template>

<script>
import { ref } from '@vue/reactivity'
export default {
    data(){
        return {
            currentCount: 0,
            signalBodyStyle:{
                padding: 0
            },
            currentPage: 1,
            signalSources:[
                [
                    {
                        date: '02月23日',
                        state: '无号'
                    },
                    {
                        date: '03月24日',
                        state: '有号'
                    },
                    {
                        date: '02月25日',
                        state: '约满'
                    },
                    {
                        date: '02月26日',
                        state: '即将放号'
                    },
                    {
                        date: '02月27日',
                        state: '无号'
                    },
                    {
                        date: '02月28日',
                        state: '无号'
                    },
                    {
                        date: '03月01日',
                        state: '无号'
                    },
                ],
                [
                    {
                        date: '03月02日',
                        state: '无号'
                    },
                    {
                        date: '03月03日',
                        state: '有号'
                    },
                    {
                        date: '03月04日',
                        state: '约满'
                    },
                    {
                        date: '03月05日',
                        state: '无号'
                    },
                    {
                        date: '03月06日',
                        state: '无号'
                    },
                    {
                        date: '03月07日',
                        state: '无号'
                    },
                    {
                        date: '03月08日',
                        state: '无号'
                    },
                ],
                [
                    {
                        date: '03月09日',
                        state: '无号'
                    },
                    {
                        date: '03月10日',
                        state: '有号'
                    },
                    {
                        date: '03月11日',
                        state: '约满'
                    },
                    {
                        date: '03月12日',
                        state: '无号'
                    },
                    {
                        date: '03月13日',
                        state: '无号'
                    },
                    {
                        date: '03月14日',
                        state: '无号'
                    },
                    {
                        date: '03月15日',
                        state: '无号'
                    },
                ],
                [
                    {
                        date: '03月16日',
                        state: '无号'
                    },
                    {
                        date: '03月17日',
                        state: '有号'
                    },
                    {
                        date: '03月18日',
                        state: '约满'
                    },
                    {
                        date: '03月19日',
                        state: '无号'
                    },
                    {
                        date: '03月20日',
                        state: '无号'
                    },
                    {
                        date: '03月21日',
                        state: '无号'
                    },
                    {
                        date: '03月22日',
                        state: '无号'
                    },
                ],
            ],
            doctors:[
                {
                    name: '张一山',
                    imgUrl: '/images/normal.jpg',
                    position: '副主任医师',
                    price: '33',
                    signals:[
                        {
                            date: '02月23日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 6
                                }
                            ]
                        },
                        {
                            date: '02月28日',
                            timeAndCounts: [
                                {
                                    time: 9.5,
                                    count: 1
                                },
                                {
                                    time: 15,
                                    count: 6
                                }
                            ]
                        },
                    ],
                    introduce: '我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，！！！'
                },
                {
                    name: '张二山',
                    imgUrl: '/images/normal.jpg',
                    position: '副主任医师',
                    price: '133',
                    signals:[
                        {
                            date: '02月27日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 2
                                }
                            ]
                        },
                        {
                            date: '03月02日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 6
                                }
                            ]
                        },
                    ],
                    introduce: '我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，！！！'
                },
                {
                    name: '张三山',
                    imgUrl: '/images/normal.jpg',
                    position: '副主任医师',
                    price: '321',
                    signals:[
                        {
                            date: '02月26日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 6
                                }
                            ]
                        },
                        {
                            date: '03月12日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 6
                                }
                            ]
                        },
                    ],
                    introduce: '我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，！！！'
                },
                {
                    name: '张四山',
                    imgUrl: '/images/normal.jpg',
                    position: '副主任医师',
                    price: '33',
                    signals:[
                        {
                            date: '02月23日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 6
                                }
                            ]
                        },
                        {
                            date: '02月25日',
                            timeAndCounts: [
                                {
                                    time: 7,//5:01-5:30 5, 5:31-6:00 5.5, 6:01-6:30 6
                                    count: 3
                                },
                                {
                                    time: 14.5,
                                    count: 6
                                }
                            ]
                        },
                    ],
                    introduce: '我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，我的自我介绍，！！！'
                },
            ],
            activeDoctors:[],
            allTime: [
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,],//6点到12点的号,半小时的数量
                [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,],//14点到18点的号
            ],
            activeTime:ref([]),//选择时间的激活列表
            timeChooseVisible: false,
            confirmInfoVisible: false,
            payVisible: false,
            clickAble: false,
            timeAndCounts: [
                [{},{},{},{},{},{},{},{},{},{},{},{},],
                [{},{},{},{},{},{},{},{},{},{},{},{},]               
            ]
        }
    },
    methods:{
        //点击表格行时的回调函数
        rowClick(e){
            //触发此函数时已经知道当前号的日期和医生名字
            
            //清空allTime
            for(let i=0; i<this.allTime[0].length; i++)
                this.allTime[0][i] = 0
            for(let i=0; i<this.allTime[1].length; i++)
                this.allTime[1][i] = 0

            /*
            遍历时间段，根据时间段取得allTime的索引，将allTime对应的值加上数量
            上午：index = 2(t-6)
            下午：index = 2(t-14)
            */
            // console.log(e)
            var timeAndCounts = e.signals[0].timeAndCounts
            for(let i=0; i<timeAndCounts.length; i++){
                var index
                // console.log(timeAndCounts[i])
                //上午：小于12，下午：大于等于14
                if(timeAndCounts[i].time<12){
                    index = 2*(timeAndCounts[i].time-6)
                    this.allTime[0][index] += timeAndCounts[i].count
                    // console.log(0 + ' ' + timeAndCounts[i].time + ' ' + index)
                }
                else{
                    index = 2*(timeAndCounts[i].time-14)
                    this.allTime[1][index] += timeAndCounts[i].count
                    // console.log(1 + ' ' + timeAndCounts[i].time + ' ' + index)
                }
            }
            // console.log(e)
            // console.log(this.allTime)
        },
        pageChange(page){
            this.currentPage = page
        },
        displayTime(){           
            //显示 选择时间 对话框
            this.timeChooseVisible = true
            // this.getAllTime()
        },
        chooseSignal(date){
            this.activeDoctors = []
            for(let i=0; i<this.doctors.length; i++){
                //遍历每一个医生
                var doctor = JSON.parse(JSON.stringify(this.doctors[i]))   
                // var doctor1 = JSON.parse(JSON.stringify(this.doctors[i]))                          
                for(let j=0; j<doctor.signals.length; j++){
                    //遍历每个医生的号源
                    if(doctor.signals[j].date==date){

                        //此处报错，原因未知
                        // var signal = signals[j]
                        // var signals = []
                        // signals.push(signal)

                        // 修改后
                        var signals = [doctor.signals[j]]



                        doctor.signals = signals
                        this.activeDoctors.push(doctor)
                    }
                }
            }
        },
        tableRowClassName(){
            for(let i = 0; i<this.activeDoctors.length; i++){
                var count = 0
                for(let j = 0; j < this.activeDoctors[i].signals[0].timeAndCounts.length; j++){
                    count += this.activeDoctors[i].signals[0].timeAndCounts[j].count
                }
                this.activeDoctors[i].count = count
            }
        },
        getAllTime(){
            var timeAndCounts = [
                [{},{},{},{},{},{},{},{},{},{},{},{},],
                [{},{},{},{},{},{},{},{},{},{},{},{},]               
            ]
            var times = [
                ['6:00-6:30', '6:30-7:00', '7:00-7:30', '7:30-8:00', '8:00-8:30', '8:30-9:00', '9:00-9:30', '9:30-10:00', '10:00-10:30', '10:30-11:00', '11:00-11:30', '11:30-12:00', ],
                ['14:00-14:30', '14:30-15:00', '15:00-15:30', '15:30-16:00', '16:00-16:30', '16:30-17:00', '17:00-17:30', '17:30-18:00', '18:00-18:30', '18:30-19:00', '19:00-19:30', '19:30-20:00', ]
            ]

            for (let index = 0; index < times[0].length; index++) {
                timeAndCounts[0][index].time = times[0][index]
                timeAndCounts[0][index].count = this.allTime[0][index]
            }
            for (let index = 0; index < times[1].length; index++) {
                timeAndCounts[1][index].time = times[1][index]
                timeAndCounts[1][index].count = this.allTime[1][index]
            }

            console.log(timeAndCounts)
            this.timeAndCounts = timeAndCounts;
        },
        confirmInfo(){
            this.timeChooseVisible = false
            this.confirmInfoVisible = true
        },
        signalConfirm(){
            this.payVisible = true,
            this.confirmInfoVisible = false
        }
    },
    computed:{
        
    }
}
</script>

<style scoped>
.appointment{
    width: 1000px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
}
.empty{
    text-align: center;
}
.pagination-block{
    margin-top: 20px;
    text-align: center;
}
.pagination-block .date{
    background-color: #67C23A;
}
ul.allTime{
    height: 200px;
    padding: 0;
    margin: 0;
    list-style: none;
    font-size: 20px;
}
ul.allTime .allTime-item{
    border-top: 1px solid grey;
}
ul.allTime .allTime-item .dayPeriod{
    font-size: 25px;
}
ul.allTime .allTime-item .dayPeriod .signalText{
    font-size: 16px;
    color: gray;
}
ul.allTime .allTime-item .dayPeriod .signalText .count{
    color: red;
}
</style>