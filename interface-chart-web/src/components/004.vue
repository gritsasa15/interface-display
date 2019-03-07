<template>
  <div class="dashboard">
    <el-row :gutter='5' class='filterbar'>
      <el-col :span='24'>
        <ul>
          <li class="searchItem"><filter-date dateType="month" v-show="vstDataType === '0'">时间:</filter-date></li>
          <!--<li class="searchItem" ><filter-select :ds="selector.week"  stateName="week" :selected="week" placeHolder="请选择" :params="timeParams" :clearable='true' v-if="this.vstDataType === '1'" :choiceOne="true" >周:</filter-select></li>-->
          <li class="searchItem"><filter-cascade :ds="selector.week" stateName="vstCalendar" :selected="vstCalendar" placeHolder="请选择" :clearable='true' :choiceOne='true' v-show="vstDataType === '1'">时间-周:</filter-cascade></li>
          <li class="searchItem"><FilterDropDownTree :ds="selector.regin" stateName="regin" :clearable='true' :checkStrictly="false">管理区域划分:</FilterDropDownTree></li>
          <li class="searchItem" ><filter-select :ds="selector.market"  stateName="market" :selected="market" placeHolder="请选择" :clearable='true' :isMultiple="true" >行政级别:</filter-select></li>
          <li class="searchItem" ><filter-select :ds="selector.channel" stateName="channel" :selected="channel" placeHolder="请选择" :clearable='true' :isMultiple="true" >店型:</filter-select></li>
          <li class="searchItem" ><filter-radio stateName="vstDataType" :data="reportTypeRadio" selected="0"></filter-radio> </li>
          <li class="searchItem button" ><el-button type="primary" @click="init()">查询</el-button></li>
        </ul>
      </el-col>
    </el-row>

    <el-row :gutter='5'>
      <el-col :span="24" style="position:relative">
        <ib-indicator-card :data='chart.card.data1' :indicatortype="2" height="60"></ib-indicator-card>
      </el-col>
    </el-row>

    <el-row :gutter='5'>
      <el-col :span="24">
        <ib-bar-line height="280px" :title="chart.line1.title" :data="chart.line1.data" :min="['0', 'dataMin']" :showDataZoom="false"
                     :showline="chart.line1.showline"></ib-bar-line>
      </el-col>
    </el-row>

    <el-row :gutter='5'>
      <el-col :span="12">
        <ib-bar-line height="280px" :title="chart.barLine1.title" :data="chart.barLine1.data" :min="['0', 'dataMin']" :LabelShowOther="true"  stateName="regionDesc"
                     :showline="chart.barLine1.showline"></ib-bar-line>
      </el-col>
      <el-col :span="12">
        <ib-bar-line height="280px" :title="chart.bar1.title" :data="chart.bar1.data"  :LabelShowOther="true" stateName="areaDesc" ></ib-bar-line>
      </el-col>
    </el-row>

    <el-row :gutter='5'>
      <el-col :span="12">
        <ib-bar-line height="280px" :title="chart.bar2.title" :data="chart.bar2.data"  :LabelShowOther="true" ></ib-bar-line>
      </el-col>
      <el-col :span="12">
        <ib-bar-line height="280px" :title="chart.bar3.title" :data="chart.bar3.data" :LabelShowOther="true" ></ib-bar-line>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { FilterDate, FilterRadio, FilterCascade, FilterSelect, FilterDropDownTree } from '@/components/filter/index.js'
import { IbIndicatorCard, IbBarLine } from '@/components/Charts'
import fetchData from '../../../../api/FetchData'
// import store from '@/store'
// import { initComponentsData } from '@/utils/helper'

export default {
  components: {
    FilterDate,
    FilterRadio,
    FilterCascade,
    FilterSelect,
    IbBarLine,
    IbIndicatorCard,
    FilterDropDownTree
  },
  props: {},
  data () {
    return {
      grid: { left: 10, right: 25, top: 70, bottom: 5, containLabel: true },
      reportTypeRadio: [{ key: '0', value: '月' }, { key: '1', value: '周' }],
      selector: {
        regin: '/filter/vst-selector?selectorFlag=0',
        market: '/filter/vst-selector?selectorFlag=1',
        channel: '/filter/vst-selector?selectorFlag=2',
        week: '/filter/vst-selector?selectorFlag=6'
      },
      chart: {
        card: {
          url: '/report/vst/004/001',
          data1: {},
          data2: {},
          data3: {},
          data4: {},
          data5: {}
        },
        line1: {
          title: '近三年新鲜度净赢率',
          url: '/report/vst/004/002',
          data: {},
          showline: []
        },
        barLine1: {
          title: '新鲜度净赢率：营销总部',
          url: '/report/vst/004/003',
          data: {},
          showline: []
        },
        bar1: {
          title: '新鲜度净赢率：销售区域',
          url: '/report/vst/004/004',
          data: {}
        },
        bar2: {
          title: '新鲜度净赢率：行政级别',
          url: '/report/vst/004/005',
          data: {}
        },
        bar3: {
          title: '新鲜度净赢率：店型',
          url: '/report/vst/004/006',
          data: {}
        }
      }
    }
  },
  computed: {
    timeParams () {
      return {
        date: this.monthDate
      }
    },
    ...mapGetters([
      'monthDate',
      'week',
      'regin',
      'market',
      'channel',
      'vstDataType',
      'vstCalendar',
      'regionDesc',
      'areaDesc'
    ])
  },
  methods: {
    init () {
      this.$store.dispatch('link', { type: 'String', value: '', name: 'regionDesc', method: 'set' })
      this.$store.dispatch('link', { type: 'String', value: '', name: 'areaDesc', method: 'set' })

      const that = this
      that.chart.card.data1.rows = undefined
      that.chart.line1.data.rows = undefined
      that.chart.barLine1.data.rows = undefined
      that.chart.bar1.data.rows = undefined
      that.chart.bar2.data.rows = undefined
      that.chart.bar3.data.rows = undefined
      // 封装参数
      // let params
      const params = {
        date: that.monthDate,
        vstCalendar: that.vstCalendar,
        regin: that.regin,
        market: that.market,
        channel: that.channel,
        vstDataType: that.vstDataType
      }
      // 请求
      fetchData(that.chart.card.url, params).then((result) => {
        that.chart.card.data1 = {
          rows: result.data
        }
      })
      fetchData(that.chart.line1.url, params).then((result) => {
        if (that.vstDataType === '0') {
          that.chart.line1.data = {
            columns: ['月', '当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率'],
            rows: result.data.rows,
            colsUnit: [{ '当年新鲜度净赢率': '%' }, { '去年新鲜度净赢率': '%' }, { '前年新鲜度净赢率': '%' }]
          }
        } else {
          that.chart.line1.data = {
            columns: ['月', '当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率'],
            rows: result.data.rows,
            colsUnit: [{ '当年新鲜度净赢率': '%' }, { '去年新鲜度净赢率': '%' }, { '前年新鲜度净赢率': '%' }]
          }
        }
        that.chart.line1.showline = ['当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率']
      })
      fetchData(that.chart.barLine1.url, params).then((result) => {
        that.chart.barLine1.data = {
          columns: ['分销售区域', '新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }, { '净赢率目标值': '%' }, { '净赢率达标率': '%' }]
        }
        that.chart.barLine1.showline = ['净赢率达标率']
      })
      fetchData(that.chart.bar1.url, params).then((result) => {
        that.chart.bar1.data = {
          columns: ['分销售区域', '新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
      fetchData(that.chart.bar2.url, params).then((result) => {
        that.chart.bar2.data = {
          columns: ['分市场', '当期新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '当期新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
      fetchData(that.chart.bar3.url, params).then((result) => {
        that.chart.bar3.data = {
          columns: ['分渠道', '当期新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '当期新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
    },
    init2 () {
      this.$store.dispatch('link', { type: 'String', value: '', name: 'areaDesc', method: 'set' })
      const that = this
      that.chart.line1.data.rows = undefined
      that.chart.bar1.data.rows = undefined
      that.chart.bar2.data.rows = undefined
      that.chart.bar3.data.rows = undefined
      // 封装参数
      // let params
      const params = {
        date: that.monthDate,
        vstCalendar: that.vstCalendar,
        regin: that.regin,
        market: that.market,
        channel: that.channel,
        vstDataType: that.vstDataType
      }
      // 请求
      fetchData(that.chart.line1.url, params).then((result) => {
        if (that.vstDataType === '0') {
          that.chart.line1.data = {
            columns: ['月', '当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率'],
            rows: result.data.rows,
            colsUnit: [{ '当年新鲜度净赢率': '%' }, { '去年新鲜度净赢率': '%' }, { '前年新鲜度净赢率': '%' }]
          }
        } else {
          that.chart.line1.data = {
            columns: ['月', '当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率'],
            rows: result.data.rows,
            colsUnit: [{ '当年新鲜度净赢率': '%' }, { '去年新鲜度净赢率': '%' }, { '前年新鲜度净赢率': '%' }]
          }
        }
        that.chart.line1.showline = ['当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率']
      })
      fetchData(that.chart.bar1.url, params).then((result) => {
        that.chart.bar1.data = {
          columns: ['分销售区域', '新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
      fetchData(that.chart.bar2.url, params).then((result) => {
        that.chart.bar2.data = {
          columns: ['分市场', '当期新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '当期新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
      fetchData(that.chart.bar3.url, params).then((result) => {
        that.chart.bar3.data = {
          columns: ['分渠道', '当期新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '当期新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
    },
    init3 () {
      const that = this
      that.chart.line1.data.rows = undefined
      that.chart.bar2.data.rows = undefined
      that.chart.bar3.data.rows = undefined
      // 封装参数
      // let params
      const params = {
        date: that.monthDate,
        vstCalendar: that.vstCalendar,
        regin: that.regin,
        market: that.market,
        channel: that.channel,
        vstDataType: that.vstDataType
      }
      // 请求
      fetchData(that.chart.line1.url, params).then((result) => {
        if (that.vstDataType === '0') {
          that.chart.line1.data = {
            columns: ['月', '当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率'],
            rows: result.data.rows,
            colsUnit: [{ '当年新鲜度净赢率': '%' }, { '去年新鲜度净赢率': '%' }, { '前年新鲜度净赢率': '%' }]
          }
        } else {
          that.chart.line1.data = {
            columns: ['月', '当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率'],
            rows: result.data.rows,
            colsUnit: [{ '当年新鲜度净赢率': '%' }, { '去年新鲜度净赢率': '%' }, { '前年新鲜度净赢率': '%' }]
          }
        }
        that.chart.line1.showline = ['当年新鲜度净赢率', '去年新鲜度净赢率', '前年新鲜度净赢率']
      })
      fetchData(that.chart.bar2.url, params).then((result) => {
        that.chart.bar2.data = {
          columns: ['分市场', '当期新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '当期新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
      fetchData(that.chart.bar3.url, params).then((result) => {
        that.chart.bar3.data = {
          columns: ['分渠道', '当期新鲜度净赢率'],
          rows: result.data.rows,
          colsUnit: [{ '当期新鲜度净赢率': '%' }, { '净赢率同比': '%' }, { '净赢率环比': '%' }]
        }
      })
    },
    keepTwoDecimalFull (num) {
      var result = parseFloat(num)
      if (isNaN(result)) {
        alert('传递参数错误，请检查！')
        return false
      }
      result = Math.round(num * 100) / 10
      var s_x = result.toString()
      var pos_decimal = s_x.indexOf('.')
      if (pos_decimal < 0) {
        pos_decimal = s_x.length
        s_x += '.'
      }
      while (s_x.length <= pos_decimal + 1) {
        s_x += '0'
      }
      return s_x
    }
  },
  watch: {
    regionDesc (n, o) {
      this.$store.dispatch('link', { type: 'String', value: n, name: 'regionDesc', method: 'set' })
      this.init2()
    },
    areaDesc (n, o) {
      this.$store.dispatch('link', { type: 'String', value: n, name: 'areaDesc', method: 'set' })
      this.init3()
    }
  },
  created () {

  },
  beforeCreate () {
    this.$store.dispatch('filter', { type: 'String', value: '0', name: 'vstDataType', method: 'init' })
  },
  mounted: function () {
    this.init()
  }
}
</script>

<style scoped>

</style>
