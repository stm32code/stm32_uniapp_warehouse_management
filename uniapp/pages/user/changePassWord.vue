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
						<section class="register_verification">
							<input type="tel" maxlength="40" placeholder="原密码" v-model="pwd">
						</section>
						<section class="register_verification">
							<input type="tel" maxlength="40" placeholder="新密码" password=true v-model="newPwd">
						</section>
						<section class="register_verification">
							<input type="tel" maxlength="40" placeholder="确认密码" password=true v-model="newPwd2">
						</section>

					</div>
					<button class="register_submit" @click="changePwd">修改</button><br />
					<button  type="default" @click="toUser">返回</button>
				</form>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				pwd: undefined,
				newPwd:undefined,
				newPwd2:undefined
			}
		},
		methods: {
			toUser(){
				uni.reLaunch({
					url: '../user/user',
				});
			},
			changePwd(){
				
				if(this.pwd == undefined ||this.newPwd == undefined ||this.newPwd2 == undefined  ){
					
					uni.showToast({
						icon: 'none',
						title: '不能为空',
					});
					return
				}
				if(this.newPwd != this.newPwd2){
					uni.showToast({
						icon: 'none',
						title: '新密码和确认密码不一致',
					});
					return
				}
				
				var token = ""
				uni.getStorage({
					key: 'token',
					success: function(res) {
						console.log("main-onLoadToken:" + res.data);
						token = res.data
					}
				});
				uni.request({
					url: '/auth/changePwd?pwd='+this.pwd +'&newPwd='+this.newPwd+"&token=" + token,
					// data: data,
					success: data => {
						console.log(data);
						if(data.data.code == 20000){
							uni.showToast({
								icon: 'none',
								title: data.data.message,
							});
						}else{
								uni.showToast({
									icon: 'none',
									title: data.data.message,
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
