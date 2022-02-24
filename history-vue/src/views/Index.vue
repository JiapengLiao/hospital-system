<template>
	<el-container>
		<el-header>
			<el-menu
			:default-active="activeIndex"
			class="el-menu-demo"
			mode="horizontal"
			background-color="#545c64"
			text-color="#fff"
			active-text-color="#ffd04b"
			@select="handleSelect"
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
			</el-menu>
		</el-header>
		<el-main><router-view></router-view></el-main>
		<el-footer>Footer</el-footer>
	</el-container>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
// import Hislist from './HisList.vue'

const activeIndex = ref('1')
const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}
</script>

<style scoped>
.el-header, .el-footer {
	background-color: #B3C0D1;
	color: #333;
	text-align: center;
	line-height: 60px;
}
.el-header{
	padding: 0;
} 
.el-footer{
	position: fixed;
	bottom: 0;
	width: 100%;
}
.el-main {
	background-color: #E9EEF3;
	color: #333;
	line-height: 30px;
}
</style>