<template lang="html">
  <div id="fo">
    <el-container>
      <el-header>
        <el-select v-model="space" placeholder="Please choose">
          <el-option v-for="item in apps" :key="item.appName" :label="item.appName" :value="item.appName"></el-option>
        </el-select>
        <el-button type="primary" @click="getInterfaceData()">Press here</el-button>
      </el-header>
      <el-main>
        <div id="myChart" :style="{width: '300px', height: '300px'}"></div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import axios from 'axios'

let echarts = require('echarts/lib/echarts')
require('echarts/lib/chart/graph')
require('echarts/lib/component/tooltip')
require('echarts/lib/component/legend')
require('echarts/lib/component/title')
export default {
  name: 'Foo',
  data () {
    return {
      apps: [], // get app name list
      space: '',
      chart: '',
      plant: []
    }
  },
  beforeMount () {
    axios.get('http://localhost:8081/application/getAllApps').then((res) => {
      this.apps = res.data
    })
    axios.get('http://localhost:8081/application/getAllPlant').then((res) => {
      this.plant = [...res.data]
    })
  },
  mounted () {
    this.initChart()
  },
  methods: {
    initChart () {
      let myChart = echarts.init(document.getElementById('myChart'))
      let option = {
        backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
          offset: 0,
          color: '#f7f8fa'
        }, {
          offset: 1,
          color: '#cdd0d5'
        }]),
        title: {
          text: '',
          subtext: ''
        },
        tooltip: {
          formatter: function (param) {
            if (param.dataType === 'edge') {
              return param.data.label.formatter
            }
            return param.data.category + ': ' + param.data.name
          }
        },
        legend: [{
          tooltip: {
            show: true
          },
          data: [this.plant] // get all plants
        }],
        toolbox: {
          show: true,
          feature: {
            dataView: {
              show: true,
              readOnly: true
            },
            restore: {
              show: true
            },
            saveAsImage: {
              show: true
            }
          }
        },
        animationDuration: 1500,
        animationEasingUpdate: 'quinticInOut',
        series: [{
          name: 'Source Applications',
          type: 'graph',
          layout: 'force',
          edgeSymbol: ['arrow'],
          force: {
            repulsion: 1000,
            edgeLength: [150, 30]
          },
          data: {}, // get all application names, plant
          links: {}, // get specific interface
          categories: [this.plant], // plant
          focusNodeAdjacency: true,
          roam: true,
          label: {
            normal: {
              show: true,
              position: 'top'
            }
          },
          symbol: 'circle',
          emphasis: {
            lineStyle: {
              width: 2
            }
          },
          lineStyle: {
            normal: {
              width: 1,
              curveness: 0.05
            }
          }
        }]
      }
      myChart.setOption(option)
    },
    getInterfaceData () {
      axios({
        method: 'get',
        url: 'http://localhost:8081/interface/getAll'
      })
        .then(function (response) {
          alert(JSON.stringify(response))
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style lang="css">
</style>
