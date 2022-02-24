<template>
    <div class="appointment">
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">平南县平山镇六峡村卫生室</el-breadcrumb-item>
            <el-breadcrumb-item>输血科</el-breadcrumb-item>
        </el-breadcrumb>
        <h1 class="empty" v-if="activeDoctors.length==0">暂时无号</h1>
        <el-table :row-class-name="tableRowClassName" v-if="activeDoctors.length>0" :data="activeDoctors" style="width: 100%">
            <el-table-column align='center' prop="name" label="姓名" />
            <el-table-column align='center' prop="position" label="职称" />
            <el-table-column align='center' prop="price" label="价格" />
            <el-table-column prop="introduce" label="自我介绍" />
            <el-table-column prop="count" label="剩余" />
            <el-table-column align='center' label="操作">
                <el-button type="success">预约</el-button>
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
    </div>
</template>

<script>
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
            activeDoctors:[]
        }
    },
    methods:{
        pageChange(page){
            this.currentPage = page
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
            // console.log(this.activeDoctors)
        },
        tableRowClassName(){
            for(let i = 0; i<this.activeDoctors.length; i++){
                var count = 0
                for(let j = 0; j < this.activeDoctors[i].signals[0].timeAndCounts.length; j++){
                    count += this.activeDoctors[i].signals[0].timeAndCounts[j].count
                }
                this.activeDoctors[i].count = count
            }
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
</style>