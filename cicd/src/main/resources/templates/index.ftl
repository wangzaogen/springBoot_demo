<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
</head>
<body>
this is welcome ${welcome}
<div id="app">
    <el-button @click="getTableData()">Button</el-button>
    <el-button @click="createProject()">create</el-button>
    <el-dialog :visible.sync="visible" title="Hello world">
        <p>Try Element</p>
    </el-dialog>
    <template>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    prop="name"
                    label="项目名称"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="groupName"
                    label="groupName"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="packageName"
                    label="包名"
                    width="120">
            </el-table-column>
            <el-table-column
                    label="操作"
                    >
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>
    </template>
</div>
</body>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- import Vue before Element -->
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script>
    new Vue({
        el: '#app',
        data: {
                visible: false,
                tableData: []
        },
        methods:{
            getTableData:function(){
                var self = this;
                axios.post('/queryProject', {
                })
                    .then(function (response) {
                        console.log(response.data)
                        self.tableData = response.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            createProject:function () {
                window.location.href = '/createProject';

                // axios.get('/createProject');
            }

        }
    })
</script>

</html>
