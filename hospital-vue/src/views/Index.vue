<template>
	<el-container>
		<el-header>
			<top-nav></top-nav>
		</el-header>
		<el-main>
			<main-con></main-con>
		</el-main>
		<el-footer>
			<footer-con></footer-con>
		</el-footer>
	</el-container>
</template>

<script>
import TopNav from './TopNav.vue'
import MainCon from './Main.vue'
import FooterCon from './Footer.vue'
export default{
	components: { 
		TopNav,
		MainCon,
		FooterCon
	},
  
}
</script>

<style scoped>
.el-header {
	background-color: #B3C0D1;
	color: #333;
	text-align: center;
	line-height: 60px;
    padding: 0;
    width: 100%;
}
.el-main {
	background-color: #E9EEF3;
	color: #333;
	line-height: 30px;
	width: 100%;
}
.el-footer {
	background-color: #B3C0D1;
	color: #333;
	text-align: center;
	line-height: 60px;
    position: fixed;
	bottom: 0;
	width: 100%;
}
</style>