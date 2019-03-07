<template>
  <div id="myChart" :style="{width: '800px', height: '400px'}"></div>
</template>

<script>
//   import axios from 'axios'
//   export default {
//   name: 'Bar',
//   data () {
//     return {
//       msg: 'Welcome to Your Vue.js App',
//       goods: {}
//     }
//   },
//   mounted () {
//     this.drawLine()
//   },
//   created () {
//     this.$http.get('./static/dat.json').then(res => {
//       const data = res.data
//       this.goods = data
//       console.log(this.goods)
//       console.log(Array.from(this.goods.xAxis.data))
//     })
//   },
//   methods: {
//     drawLine () {
//       // 基于准备好的dom，初始化echarts实例
//       let myChart = this.$echarts.init(document.getElementById('myChart'))
//       // 绘制图表
//       myChart.setOption({
//         title: {}, // {text: '异步数据加载示例'},
//         tooltip: {},
//         xAxis: {
//           data: [] // ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
//         },
//         yAxis: {},
//         series: [{
//           name: '销量',
//           type: 'bar',
//           data: [] // [5, 20, 36, 10, 10, 20]
//         }]
//       })
//       this.$http.get('./static/dat.json').then((res) => {
//         const data = res.data
//         const list = data.series.map(good => {
//           let list = good.data
//           return [...list]
//         })
//         console.log(list)
//         console.log(Array.from(...list))
//         myChart.setOption({
//           title: data.title,
//           xAxis: [{
//             data: data.xAxis.data
//           }],
//           series: [{
//             name: '销量',
//             type: 'bar',
//             data: Array.from(...list) // [5, 20, 36, 10, 10, 20]
//           }]
//         })
//       })
//     }
//   }
// }
</script>
