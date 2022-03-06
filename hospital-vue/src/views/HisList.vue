<template>
    <div>
        <el-card class="box-card">
            <template #header>
                <div class="card-header">
                    <span>地区列表</span>
                </div>
            </template>
            <el-button v-for="region in getRegion" 
            @click="changeRegion(region)" 
            :key="region" 
            class="text item"
            :type='activeRegion==region?"success":""'>{{region}}</el-button>
        </el-card>
        <el-row>
            <el-col>
                <el-row justify="start">
                    <el-col v-for="(history, index) in getHistory"
                    :key="history.name"
                    :span='4'
                    :offset="index % 5 == 0?0:1">                
                        <el-card @click="goHis(history.name)" shadow="hover" :body-style='cardBodyStyle'>
                            <el-row>
                                <el-col :span='20'>
                                    <el-row>
                                        <el-col>
                                            <h4>{{history.name}}</h4>
                                        </el-col>
                                    </el-row>
                                    <el-row>
                                        <el-col :span='10'>
                                            <span class="iconfont icon-gangweijibie "></span>{{history.level}}
                                        </el-col>
                                        <el-col :span='14'>                          
                                            <span class="iconfont icon-dianhua"></span>{{history.phone}}
                                        </el-col>
                                    </el-row>
                                </el-col>
                                <el-col :span='4'>
                                    <el-row>
                                        <el-col>
                                            <el-image src='images/normal.jpg'
                                            fit='contain'></el-image>
                                        </el-col>
                                    </el-row>
                                </el-col>
                            </el-row>
                        </el-card>
                    </el-col>
                </el-row>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    data(){
        return{
            activeRegion: '全部',
            histories:[
                {
                    region: '港北区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '港北区',
                    name: '贵港牡丹妇产医院',
                    level: '未认证',
                    address: '金港大道工商局西侧864和866号(原御龙酒店)',
                    phone: '0775-5963956'
                },
                {
                    region: '港北区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '港北区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '港北区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '港北区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '港北区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '港南区',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '桂平市',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '平南县',
                    name: '贵港市西江农场医院',
                    level: '一级甲等',
                    address: '广西贵港市西江农场部',
                    phone: '0775-4270824'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区五里镇卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区五里镇横贵路43号',
                    phone: '0775-4853377'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区东龙镇中心卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区东龙镇西街282号',
                    phone: '0775-4664304'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区山北乡卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区山北乡山北村',
                    phone: '0775-4970101'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区蒙公乡卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区蒙公乡蒙公街',
                    phone: '0775-465026'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区三里镇卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区三里镇东街104号',
                    phone: '0775-4794120'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区大岭乡卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区大岭乡大岭街',
                    phone: '0775-4752025'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区樟木乡中心卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区樟木乡樟木百花街56号',
                    phone: '0775-4604929'
                },
                {
                    region: '覃塘区',
                    name: '贵港市覃塘区石卡镇中心卫生院',
                    level: '未认证',
                    address: '广西贵港市覃塘区石卡镇石卡街95号',
                    phone: '0775-4683630'
                },
            ],
            cardBodyStyle:{
                padding: '10px',
            }
        }
    },
    computed:{
        getRegion(){
            var regions = ['全部']
            for(let i = 0; i < this.histories.length; i++){
                const re = this.histories[i].region
                if(!regions.includes(re))
                    regions.push(re)
            }
            return regions
        },
        getHistory(){
            var history = []
            if(this.activeRegion=='全部'){
                for(let i = 0; i < this.histories.length; i++){
                    const his = this.histories[i]
                    history.push(his)
                }
            }else{
                for(let i = 0; i < this.histories.length; i++){
                    const his = this.histories[i]
                    if(his.region==this.activeRegion){
                        history.push(his)
                    }
                }
            }
            return history
        }
    },
    methods:{
        changeRegion(region){
            this.activeRegion = region
        },
        goHis(name){
            this.$router.push({path: '/historyDetail', query: {name: name}})
        }
    }
}
</script>

<style scoped>
.el-card{
    margin-bottom: 30px;
    cursor: pointer;
}
/* .el-card:hover{
    border: 2px solid rgb(94, 91, 91);
} */
.el-card h4{
    margin: 0;
}
</style>