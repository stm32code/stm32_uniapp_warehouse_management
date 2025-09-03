import request from '@/utils/request'
import {
	getToken
} from '@/utils/auth';
const api_name = '/goods'
export default {


	getUserListByConditionAxios(uname, email, major,page, limit) {
		return request({
			url: '/auth/getUserListByCondition',
			method: 'get',
			params: {
				username:uname, 
				email:email, 
				major:major,
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getUserListAxios(page, limit) {
		return request({
			url: '/auth/selectUserList',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	updateUserAllInfoAxios(uid,uname, pwd,age,sex,major,grade,email) {
	  return request({
	    url: '/auth/updateUserAllInfo',
	    method: 'get',
	    params: {
			changeId:uid,
	      username: uname,
	      pwd: pwd,
		age:age,
		sex:sex,
		major:major,
		grade:grade,
		email:email,
		token: getToken(),
	    }
	  })
	},
	changePwdAxios(uid, newPwd) {
		return request({
				url: '/auth/updatePwdByUid',
				method: 'get',
				params: {
					uid: uid,
					pwd: newPwd,
					token: getToken(),
				}
			})
	},
	
	delUserAxios(uid){
	  return request({
	    url: '/auth/deleteUser',
	    method: 'get',
	    params: {
	      delUid: uid,
			token:getToken(),
	    }
	  })
	},
	
	getSortListAxios(page, limit) {
		return request({
			url: '/auth/goods/sort/selectGoodsSortByPage',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getUserInfoByUidAxios(userId) {
		return request({
			url: '/auth/getUserInfoByUid',
			method: 'get',
			params: {
				userUId: userId,
				token: getToken(),
			}
		})
	},
	getUserInfoByTokenAxios() {
		return request({
			url: '/auth/getUserInfoByToken',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getSortOptionAxios() {
		return request({
			url: '/auth/goods/sort/getSortOption',
			method: 'get',
			params: {

				token: getToken(),
			}
		})
	},
	
	
	addSortAxios(sortName) {
		return request({
			url: '/auth/goods/sort/addGoodsSort',
			method: 'get',
			params: {
				sortName: sortName,
				token: getToken(),
			}
		})
	},
	
	changeSortAxios(id,sortName) {
		return request({
			url: '/auth/goods/sort/updateGoodsSortById',
			method: 'get',
			params: {
				sid: id,
				sortName:sortName,
				token: getToken(),
			}
		})
	},
	delSortAxios(id) {
		return request({
			url: '/auth/goods/sort/delGoodsSortById',
			method: 'get',
			params: {
				sid: id,
				token: getToken(),
			}
		})
	},
	
	getaddressListAxios(page, limit) {
		return request({
			url: '/auth/goods/address/selectGoodsAddressByPage',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	
	getaddressOptionAxios() {
		return request({
			url: '/auth/goods/address/getAddressOption',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	
	
	addAddressAxios(addressName) {
		return request({
			url: '/auth/goods/address/addGoodsAddress',
			method: 'get',
			params: {
				addressName: addressName,
				token: getToken(),
			}
		})
	},
	
	changeAddressAxios(id,addressName) {
		return request({
			url: '/auth/goods/address/updateGoodsAddressById',
			method: 'get',
			params: {
				sid: id,
				addressName:addressName,
				token: getToken(),
			}
		})
	},
	
	delAddressAxios(id) {
		return request({
			url: '/auth/goods/address/delGoodsAddressById',
			method: 'get',
			params: {
				aid: id,
				token: getToken(),
			}
		})
	},
	
	addGoodsInfoAxios(goodsName,sortId,rfidId,addressId,author,press,publicationDate,imageUrl,goodsCount,isbn) {
		// String goodsName,Integer sortId,String rfidId,Integer addressId
		return request({
			url: '/auth/goods/info/addGoodsInfo',
			method: 'get',
			params: {
				goodsName: goodsName,
				sortId: sortId,
				rfidId: rfidId,
				addressId: addressId,
				author:author,
				press:press,
				publicationDate:publicationDate,
				imageUrl:imageUrl,
				goodsCount:goodsCount,
				isbn:isbn,
				token: getToken(),
			}
		})
	},
	updateGoodsInfoByIdAxios(bid,goodsName,sortId,rfidId,addressId,author,press,publicationDate,imageUrl,goodsCount) {
		// String goodsName,Integer sortId,String rfidId,Integer addressId
		return request({
			url: '/auth/goods/info/updateAllGoodsInfoById',
			method: 'get',
			params: {
				bid:bid,
				goodsName: goodsName,
				sortId: sortId,
				rfidId: rfidId,
				addressId: addressId,
				author:author,
				press:press,
				publicationDate:publicationDate,
				imageUrl:imageUrl,
				goodsCount:goodsCount,
				token: getToken(),
			}
		})
	},
	getGoodsInfoCreatListAxios(page, limit) {
		return request({
			url: '/auth/goods/info/getGoodsInfoCreatList',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getGoodsInfoListAxios(page, limit) {
		return request({
			url: '/auth/goods/info/selectGoodsInfoByPage',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	getGoodsInfoByRfidAxios(addreddRfid) {
		return request({
			url: '/auth/goods/info/getGoodsInfoByRfid',
			method: 'get',
			params: {
				rfid:addreddRfid,
				token: getToken(),
			}
		})
	},
	
	selectGoodsInfoConditionByPageAxios(goodsName, author, press,page, limit) {
		return request({
			url: '/auth/goods/info/selectGoodsInfoConditionByPage',
			method: 'get',
			params: {
				goodsName:goodsName, 
				author:author, 
				press:press,
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	
	selectGoodsByRfid(rfid) {
		return request({
			url: '/auth/goods/info/selectGoodsByRfid',
			method: 'get',
			params: {
				rfid:rfid,
				token: getToken(),
			}
		})
	},
	
	updateGoodsAddresssInfoByIdAxios(sid,addressId) {
		return request({
			url: '/auth/goods/info/updateGoodsAddresssInfoById',
			method: 'get',
			params: {
				sid: sid,
				addressId: addressId,
				token: getToken(),
			}
		})
	},
	
	getGoodsInfoByIdAxios(bid) {
		return request({
			url: '/auth/goods/info/getGoodsInfoById',
			method: 'get',
			params: {
				bid: bid,
				token: getToken(),
			}
		})
	},
	
	delGoodsInfo(aid) {
		return request({
			url: '/auth/goods/info/delGoodsInfoById',
			method: 'get',
			params: {
				aid: aid,
				token: getToken(),
			}
		})
	},
	
	borrowGoods(rfidId,endTime,address,oper) {
		return request({
			url: '/auth/goods/borrow/borrowGoods',
			method: 'get',
			params: {
				rfidId: rfidId,
				endTime: endTime,
				address: address,
				oper: oper,
				token: getToken(),
			}
		})
	},
	
	selectBorrowList(page,limit) {
		return request({
			url: '/auth/goods/borrow/selectBorrowList',
			method: 'get',
			params: {
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	selectBorrowListByStatus(status,page,limit) {
		return request({
			url: '/auth/goods/borrow/selectBorrowListByStatus',
			method: 'get',
			params: {
				status:status,
				page: page,
				limit: limit,
				token: getToken(),
			}
		})
	},
	
	returnGoods(rfidId,raters,address,oper) {
		return request({
			url: '/auth/goods/borrow/returnGoods',
			method: 'get',
			params: {
				rfidId: rfidId,
				raters: raters,
				address: address,
				oper: oper,
				token: getToken(),
			}
		})
	},
	getRfif() {
		return request({
			url: '/auth/goods/rfid/getRfid',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getUserInfoChartAxios() {
		return request({
			url: '/auth/echart/getUserInfoChart',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getGoodsTypeInfoChartAxios() {
		return request({
			url: '/auth/echart/getGoodsTypeInfoChart',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getGoodsTypeInfoChartByUidAxios() {
		return request({
			url: '/auth/echart/getGoodsTypeInfoChartByUid',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getBootCountChartAxios() {
		return request({
			url: '/auth/echart/getBootCountChart',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
	getCurrData() {
		return request({
			url: '/user/getData',
			method: 'get',
			params: {
				token: getToken(),
			}
		})
	},
}
