<template>
	<div class="registerContainer">
		<div class="registerInner">
			<div class="register_header">
			</div>
			<!-- 内容部分 -->
			<div class="register_content">
				<form @submit="register">
					<!-- 短信登录 -->
					<div>
						<!-- 						<section class="register_message">
							<input type="tel" maxlength="11" placeholder="手机号" v-model="phone" />
							<button :disabled="!rightPhone" class="get_verification" :class="{right_phone:rightPhone}" @click.prevent="getCode">{{computeTime>0 ? `(${computeTime}s)已发送` : '获取验证码'}}</button>
						</section> -->
<!-- 						<section class="register_verification">
							<view class="title" style="height:30px;">上限水位：</view>
							<input type="tel" maxlength="4" placeholder="上限水位" v-model="waterLevelUp">
						</section>
						<section class="register_verification">
							<view class="title" style="height:30px;margin-top: 50px;">下限水位：</view>
							<input type="tel" maxlength="4" placeholder="下限水位" v-model="waterLevelDown">
						</section>
						<section class="register_verification">
							<view class="title" style="height:30px;margin-top: 50px;">浑浊度：</view>
							<input type="tel" maxlength="4" placeholder="浑浊度" v-model="turbidity">
						</section> -->

					</div>
					<button style="margin-top: 80px;" class="register_submit" @click="changeLimit">测试付款</button><br />
					<button type="default" @click="toUser">返回</button>
				</form>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				waterLevelUp: undefined,
				waterLevelDown: undefined,
				turbidity: undefined
			}
		},
		onShow() {
			this.getLimit()
		},
		methods: {
			toUser() {
				uni.reLaunch({
					url: '../main/main',
				});
			},
			changeLimit() {
				var token = ""
				uni.getStorage({
					key: 'token',
					success: function(res) {
						console.log("main-onLoadToken:" + res.data);
						token = res.data
					}
				});
				uni.request({
					url: '/auth/recharge?sort=0&money=10&token=' + token,
					// data: data,
					success: data => {
						console.log(data);
						if (data.data.code == 20000) {
							console.log(data.data.data.data);
							document.querySelector('body').innerHTML = data.data.data.data;
							//调用submit 方法
							document.forms[0].submit()
							// uni.showToast({
							// 	icon: 'none',
							// 	title: data.data.desc,
							// });
						} else {
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
			getLimit() {

				uni.request({
					url: 'gatBoundary',
					// data: data,
					success: data => {
						console.log(data);
						if (data.data.code == 1) { // uni.showToast({

							this.waterLevelUp = data.data.map.data.tWaterLevelUp
							this.waterLevelDown = data.data.map.data.tWaterLevelDown
							this.turbidity = data.data.map.data.tTurbidity
						} else {
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


<style scoped>
	.registerContainer {
		width: 100%;
		height: 100%;
		background: #fff;
	}

	.registerInner {
		width: 80%;
		margin: 0 auto;
		padding-top: 60px;
	}

	.registerInner .register_header .register_logo {
		color: #0faeff;
		font-weight: bolder;
		font-size: 40px;
		text-align: center;
	}

	.register_header .register_header_title {
		text-align: center;
		padding-top: 40px;
	}

	.register_header_title a {
		text-decoration: none;
		font-size: 14px;
		color: #333;
		padding-bottom: 4px;
	}

	.register_header_title a:first-child {
		margin-right: 40px;
	}

	.register_header_title a.on {
		color: #0faeff;
		font-weight: bolder;
		border-bottom: 2px solid #0faeff;
	}

	.register_content form div.on {
		display: block;
	}

	.register_content form input {
		width: 100%;
		height: 100%;
		border: 1px solid #ddd;
		border-radius: 4px;
		outline: none;
		padding-left: 10px;
		box-sizing: border-box;

	}

	.register_content form input:focus {
		border: 1px solid #0faeff;
	}

	.register_message {
		position: relative;
		margin-top: 16px;
		height: 48px;
		font-size: 14px;
		background: #fff;
	}

	.register_message .get_verification {
		position: absolute;
		top: 50%;
		right: 10px;
		transform: translateY(-50%);
		border: none;
		color: #ccc;
		background: transparent;
		font-size: 14px;
	}

	.register_message .get_verification.right_phone {
		color: #000;
	}

	.register_hint {
		text-align: center;
		color: #999;
		margin-top: 12px;
		font-size: 14px;
		line-height: 20px;
	}

	.register_hint a {
		text-decoration: none;
		color: #0faeff;
	}

	.register_verification {
		position: relative;
		margin-top: 16px;
		height: 48px;
		font-size: 14px;
		background: #fff;
	}

	.register_verification .switch_button {
		border: 1px solid #ddd;
		width: 30px;
		height: 16px;
		position: absolute;
		top: 50%;
		right: 10px;
		transform: translateY(-50%);
		border-radius: 8px;
		padding: 0 6px;
		line-height: 16px;
		font-size: 12px;
		transition: background-color 0.3s;

	}

	.register_verification .switch_button.on {
		background: #0faeff;
	}

	.register_verification .switch_button.off {
		background: #fff;
	}

	.switch_button .switch_circle {
		background: #fff;
		border: 1px solid #ddd;
		border-radius: 50%;
		width: 16px;
		height: 16px;
		position: absolute;
		left: -1px;
		top: -1px;
		box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
	}

	.switch_button .switch_circle.right {
		transform: translateX(30px);
	}

	.switch_button .switch_text {
		color: #ddd;
		float: right;
	}

	.register_submit {
		display: block;
		width: 100%;
		height: 42px;
		margin-top: 30px;
		background: #0faeff;
		border-radius: 4px;
		font-size: 16px;
		line-height: 42px;
		color: #fff;
		text-align: center;
		border: none;
	}

	.register_hint {
		color: #999;
		margin-top: 12px;
		font-size: 14px;
		line-height: 20px;
	}

	register_hint a {
		text-decoration: none;
		color: #0faeff;
	}
</style>
