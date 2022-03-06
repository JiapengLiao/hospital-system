import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import App from './App.vue'
import router from './router'
import axios, { AxiosInstance } from 'axios'
import VueAxios from 'vue-axios'

// declare module '@vue/runtime-core' {
//     interface ComponentCustomProperties {
//         $axios: AxiosInstance
//     }
// }

const app = createApp(App).use(router)
axios.defaults.baseURL = 'http://localhost:8081/'
app.config.globalProperties.$axios = axios
app.use(ElementPlus, {
    locale: zhCn,
})
app.mount('#app')
