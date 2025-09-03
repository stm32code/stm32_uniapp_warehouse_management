<template>
    <view>
        <view class="btn1">
            <button type="primary" style="margin-left: 40px;" @click="onShowDatePicker('rangetime')">选择日期时间范围</button>
        </view>

		<view class="btn2">
			<button type="primary" style="margin-left: 10px;margin-top: 10px;" @click="getData(1)">查询</button>
		</view>
		<view class="btn2">
			<button type="default"  style="margin-left: 10px;margin-top: 10px;" @click="toMain">返回</button>
		</view>
		<br />
        <mx-date-picker :show="showPicker" :type="type" :value="value" :show-tips="true" :begin-text="'开始时间'" :end-text="'结束时间'" :show-seconds="true" @confirm="onSelected" @cancel="onSelected" />
		<view style="margin-left: 20px;color: #007AFF;"  >{{rangetime[0]}} - {{rangetime[1]}}</view>
		<br />
		<hr />
		<view class="">
		
			<Pagination 
			:total="total"
			:pageSize="pageSize"
			:activeItem="activeItem"
			@click="click"
			@leftClick="leftClick"
			@rightClick="rightClick">
			</Pagination>
		</view>
		<hr />

		<uni-list-item v-for="item in dataList">
<!-- 			<view slot="header" class="slot-box">
				<text style="margin-right: 20px;">{{item.dateStr}}  </text>
			</view>
			<view></view> -->
			<text slot="body" class="slot-box slot-text">换水时间：{{ item.dateStr }}</text>
			<template slot="footer">
				
			</template>
		</uni-list-item>
	</view>
</template>

<script>
	import MxDatePicker from "../../components/mx-datepicker/mx-datepicker.vue";
	import Pagination from "../../components/Pagination.vue"
	export default {
	    components: {
	        MxDatePicker,
			Pagination
	    },
	    data() {
	        return {
	            showPicker: false,
	          
	            rangetime: ['2021/01/07 14:00:00','2021/02/09 13:59:00'],
	            type: 'rangetime',
	            value: '',
				dataList:undefined,
				total: 0,
				pageSize: 20,
				activeItem: 1
	        }
	    },
	    methods: {
			click(x) {
				this.activeItem = x
				console.log(x)
				this.getData(x)
			},
			leftClick() {
				if(this.activeItem > 1){
					this.activeItem--
				}
			},
			rightClick(x) {
				if(this.activeItem < x) {
					this.activeItem++
				}
			},
			getData(page = 0){
				this.activeItem = page
				uni.request({
					url: 'getChangeWaterData?startDate='+this.rangetime[0]+"&stopDate="+this.rangetime[1]+"&page="+ page+"&size="+this.pageSize,
					// data: data,
					success: data => {
						console.log(data);
						if(data.data.code == 1){
							this.dataList = data.data.map.data
							this.total = data.data.map.total
						
						}else{
							console.log("获取失败");
								uni.showToast({
									icon: 'none',
									title: data.data.desc,
								});
						}
						
					},
					fail: (data, code) => {
						console.log('fail' + JSON.stringify(data));
					}
				});
			},
			toMain(){
				uni.reLaunch({
					url: '../main/main',
				});
			},
	        onShowDatePicker(type){//显示
	            this.type = type;
	            this.showPicker = true;
	            this.value = this[type];
	        },
	        onSelected(e) {//选择
	            this.showPicker = false;
	            if(e) {
	                this[this.type] = e.value; 
	                //选择的值
	                console.log('value => '+ e.value);
	                //原始的Date对象
	                console.log('date => ' + e.date);
	            }
	        }
	    }
	}
</script>

<style>
    .test{
        text-align: center;
        padding: 10px 0;
    }
    button{
        margin: 20upx;
        font-size: 28upx;
    }
	.btn1 {
			float: left;
		}
	
		.btn2 {
			float: left;
		}
</style>