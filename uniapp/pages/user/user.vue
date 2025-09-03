<template>
	<view>

		<uni-list-item style="margin-top: 120px;">
			<view slot="header" >
				<text style="font-size: 20px;margin-right: 10px;">开/关窗户</text>
			</view>

			<template slot="footer">
				<switch @change="switch1Change" :checked="switch1" />
			</template>
		</uni-list-item>
		<uni-list-item>
			<view slot="header" class="slot-box">
				<text style="font-size: 20px;margin-right: 10px;">开/关窗帘</text>
			</view>

			<template slot="footer">
				<switch @change="switch2Change" :checked="switch2" />
			</template>
		</uni-list-item>
		<uni-list-item>
			<view slot="header" class="slot-box">
				<text style="font-size: 20px;margin-right: 10px;">开/关加湿器</text>
			</view>
		
			<template slot="footer">
				<switch @change="switch2Change" :checked="switch2" />
			</template>
		</uni-list-item>
		<uni-list-item>
			<view slot="header" class="slot-box">
				<text style="font-size: 20px;margin-right: 10px;">开/关风扇</text>
			</view>
		
			<template slot="footer">
				<switch @change="switch2Change" :checked="switch2" />
			</template>
		</uni-list-item>

	</view>

</template>

<script>
	import vSwitch from "../../components/v-switch/v-switch";
	export default {
		components: {
			vSwitch
		},
		data() {
			return {
				showPicker: false,
				switch1: false,
				switch2: false


			}
		},
		onShow() {
			this.getData()
		},
		methods: {
			switch1Change: function(e) {
				var token = ""
				uni.getStorage({
					key: 'token',
					success: function(res) {
						console.log("main-onLoadToken:" + res.data);
						token = res.data
					}
				});
				console.log('switch1 发生 change 事件，携带值为', e.target.value)
				uni.request({
					url: 'setSwitch1State?state=' + e.target.value +"&token="+token,
					// data: data,
					success: data => {
						console.log(data);
						if (data.data.code == 1) {
							// this.dataList = data.data.map.data
							uni.showToast({
								icon: 'none',
								title: data.data.desc,
							});
				
						} else {
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
			switch2Change: function(e) {
				var token = ""
				uni.getStorage({
					key: 'token',
					success: function(res) {
						console.log("main-onLoadToken:" + res.data);
						token = res.data
					}
				});
				console.log('switch2 发生 change 事件，携带值为', e.target.value)
				uni.request({
					url: 'setSwitch2State?state=' + e.target.value+"&token="+token ,
					// data: data,
					success: data => {
						console.log(data);
						if (data.data.code == 1) {
							// this.dataList = data.data.map.data
							uni.showToast({
								icon: 'none',
								title: data.data.desc,
							});
				
						} else {
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
			getData() {
				uni.request({
					url: 'getSwitchState' ,
					// data: data,
					success: data => {
						console.log(data);
						if (data.data.code == 1) {
							// this.dataList = data.data.map.data
							console.log(data.data.map.data);
							var list =data.data.map.data
							if(list[0].tSwitchState == 1){
								this.switch1 = true
							}
							if(list[1].tSwitchState == 1){
								this.switch2 = true
							}
							

						} else {
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
			toMain() {
				uni.reLaunch({
					url: '../main/main',
				});
			},
		}
	}
</script>
