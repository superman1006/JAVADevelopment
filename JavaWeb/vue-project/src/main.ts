import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)

// 挂载到 #app 元素上
// 把所有的 Vue 组件塞进 index.html 里那个 id="app" 的 <div> 标签中
app.mount('#app')
