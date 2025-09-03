<template>
	<view>
<!-- 		<view>当前温度：3128</view>
		<view>当前温度：3128</view>
		<view>当前温度：3128</view> -->
		<uni-list-item style="margin-top: 35%;">
			<view slot="header" class="slot-box">
				<text  style="font-size: 20px;margin-right: 10px;">水  温：</text>
			</view>
			<text slot="body" style="font-size: 20px;" class="slot-box slot-text">{{ wd }}</text>
	<!-- 		<template slot="footer">
				<image class="slot-image" src="/static/logo.png" mode="widthFix"></image>
			</template> -->
		</uni-list-item>
		<uni-list-item>
			<view slot="header" class="slot-box">
				<text  style="font-size: 20px;margin-right: 10px;">水 位：</text>
			</view>
			<text slot="body" style="font-size: 20px;" class="slot-box slot-text">{{ sw }}</text>
		<!-- 	<template slot="footer">
				<image class="slot-image" src="/static/logo.png" mode="widthFix"></image>
			</template> -->
		</uni-list-item>
		<uni-list-item>
			<view slot="header" class="slot-box">
				<text  style="font-size: 20px;margin-right: 10px;">浑浊度：</text>
			</view>
			<text slot="body" style="font-size: 20px;" class="slot-box slot-text">{{ hzd }}</text>
			<!-- <template slot="footer">
				<image class="slot-image" src="/static/logo.png" mode="widthFix"></image>
			</template> -->
		</uni-list-item>
		<button  style="margin-top: 20%;" type="default" @click="toMain">返回</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				wd:'正在获取...',
				sw:'正在获取...',
				hzd:'正在获取...',
			}
		},
		onShow() {
			this.getData
			setInterval(this.getData, 3000);
		},
		methods: {
			toMain(){
				uni.reLaunch({
					url: '../main/main',
				});
			},
			getData(){
				// console.log("getData");
				

				uni.request({
					url: 'getCurrentData',
					// data: data,
					success: data => {
						// console.log(data);
						if(data.data.code == 1){
							this.wd = data.data.map.data.tWaterTemperature
							this.sw = data.data.map.data.tWaterLevel
							this.hzd = data.data.map.data.tTurbidity
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
			}
		}
	}
</script>


<style>
	/* 头条小程序组件内不能引入字体 */
	/* #ifdef MP-TOUTIAO */
	@font-face {
		font-family: uniicons;
		font-weight: normal;
		font-style: normal;
		src: url("~@/static/uni.ttf") format("truetype");
	}
	
	/* #endif */
	/* #ifndef APP-NVUE */
	page {
		display: flex;
		flex-direction: column;
		box-sizing: border-box;
		background-color: #efeff4;
		min-height: 100%;
		height: auto;
	}
	
	view {
		font-size: 14px;
		line-height: inherit;
	}
	
	.example {
		padding: 0 15px 15px;
	}
	
	.example-info {
		padding: 15px;
		color: #3b4144;
		background: #ffffff;
	}
	
	.example-body {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: center;
		padding: 0;
		font-size: 14px;
		background-color: #ffffff;
	}
	
	/* #endif */
	.example {
		padding: 0 15px;
	}
	
	.example-info {
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
		padding: 15px;
		color: #3b4144;
		background-color: #ffffff;
		font-size: 14px;
		line-height: 20px;
	}
	
	.example-info-text {
		font-size: 14px;
		line-height: 20px;
		color: #3b4144;
	}
	
	.example-body {
		flex-direction: column;
		padding: 15px;
		background-color: #ffffff;
	}
	
	.word-btn-white {
		font-size: 18px;
		color: #FFFFFF;
	}
	
	.word-btn {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		align-items: center;
		justify-content: center;
		border-radius: 6px;
		height: 48px;
		margin: 15px;
		background-color: #007AFF;
	}
	
	.word-btn--hover {
		background-color: #4ca2ff;
	}
	
	.slot-box {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		align-items: center;
	}
	
	.slot-image {
		/* #ifndef APP-NVUE */
		display: block;
		/* #endif */
		margin-right: 10px;
		width: 30px;
		height: 30px;
	}
	
	.slot-text {
		flex: 1;
		font-size: 14px;
		color: #4cd964;
		margin-right: 10px;
	}
</style>
