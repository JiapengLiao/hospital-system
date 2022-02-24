import { createRouter, createWebHistory } from 'vue-router'
import Index from '../views/Index.vue'

const routes = [
	{
		path: '/',
		redirect: 'Index'
	},
	{
		path: '/index',
		name: 'Index',
		component: Index,
		redirect: { name: 'HisList' },
		children: [
			{
				path: '/hislist',
				name: 'HisList',
				component: () => import(/* 医院列表页面 */ '../views/HisList.vue')
			},
			{
				path: '/historyDetail',
				name: 'HistoryDetail',
				component: () => import(/* 医院详情页面 */ '../views/HistoryDetail.vue')
			},
			{
				path: '/appointment',
				name: 'Appointment',
				component: () => import(/* 预约页面 */ '../views/Appointment.vue')
			}
		]
	},
	{
		path: '/user',
		component: () => import(/* 账户页面 */ '../views/User.vue'),
		children: [	
			{
				path: '/login',
				name: 'Login',
				component: () => import(/* 登录页面 */ '../views/Login.vue')
			},
			{
				path: '/register',
				name: 'Register',
				component: () => import(/* 注册页面 */ '../views/Register.vue')
			},
		]
	},	
	// {
	// 	path: '/user/:username',
	// 	component: Index
	// },
	{
		path: '/:w+',
		component: () => import(/* 404页面 */ '../views/404.vue')
	}
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
