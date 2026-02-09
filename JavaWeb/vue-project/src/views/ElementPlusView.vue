<template>
  <div style="padding: 20px">
    <el-row>
      <el-button>默认按钮</el-button>
      <el-button type="primary">主要按钮</el-button>
      <el-button type="success">成功按钮</el-button>
      <el-button type="info">信息按钮</el-button>
      <el-button type="warning">警告按钮</el-button>
      <el-button type="danger">危险按钮</el-button>
    </el-row>

    <br />
    <el-row>
      <el-button round>圆角按钮</el-button>
      <el-button type="primary" round>主要按钮</el-button>
      <el-button type="success" round>成功按钮</el-button>
      <el-button type="info" round>信息按钮</el-button>
      <el-button type="warning" round>警告按钮</el-button>
      <el-button type="danger" round>危险按钮</el-button>
    </el-row>

    <br />
    <h2>用户数据列表</h2>
    <el-table v-bind:data="tableData" border style="width: 80%">
      <el-table-column prop="id" label="ID" width="80" />
      <el-table-column prop="name" label="姓名" width="120" />
      <el-table-column prop="role" label="角色" width="150" />

      <el-table-column prop="status" label="状态">
        <template #default="scope">
          <el-tag v-bind:type="scope.row.status === '在线' ? 'success' : 'info'">
            {{ scope.row.status }}
          </el-tag>
        </template>
      </el-table-column>
    </el-table>

    <el-button link @click="dialogVisible = true">点击打开 Dialog</el-button>

    <el-dialog title="填写信息" v-model="dialogVisible" width="400px" :before-close="handleClose">
      <el-form :model="form" label-width="60px">
        <el-form-item label="ID">
          <el-input v-model="form.id" placeholder="请输入 ID" clearable />
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="form.name" placeholder="请输入姓名" clearable />
        </el-form-item>
      </el-form>
      <template v-slot:footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="handleConfirm">确 定</el-button>
        </span>
      </template>
    </el-dialog>

    <br />
    <router-link to="/test">
      <el-button type="primary">去测试页面</el-button>
    </router-link>
  </div>
</template>

<script lang="ts">
export default {
  // data() 函数返回组件的响应式数据对象
  data() {
    return {
      tableData: [
        { id: 1, name: '陈律', role: 'Java 后端开发', status: '在线' },
        { id: 2, name: '张三', role: '前端实习生', status: '离线' },
        { id: 3, name: '李四', role: '架构师', status: '在线' },
        { id: 4, name: '王五', role: '测试工程师', status: '离线' },
      ],
      dialogVisible: false,
      form: {
        id: '',
        name: '',
      },
    }
  },
  methods: {
    handleClose() {
      this.form.id = ''
      this.form.name = ''
      this.dialogVisible = false
    },
    handleConfirm() {
      alert(`提交的数据：\nID: ${this.form.id}\n姓名: ${this.form.name}`)
      this.form.id = ''
      this.form.name = ''
      this.dialogVisible = false
    },
  },
}
</script>

<style scoped>
h2 {
  margin-bottom: 20px;
  color: #409eff;
}
</style>
