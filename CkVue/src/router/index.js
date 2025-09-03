import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'
import pan_get_file from '../views/file_sharing/pan_get_file'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [{
		path: '/login',
		component: () => import('@/views/login/index'),
		hidden: true
	},

	{
		path: '/404',
		component: () => import('@/views/404'),
		hidden: true
	},

	{
		path: '/',
		component: Layout,
		redirect: '/index/index',
		children: [{
			path: 'index',
			name: 'index',
			component: () => import('@/views/goods/admin_goods'),
			meta: {
				title: '首页',
				icon: 'tree'
			}
		}]
	},

	{
		path: '/index',
		component: Layout,
		redirect: '/goods/admin_goods',
		name: 'index',
		meta: {
			title: '首页',
			icon: 'el-icon-user-solid'
		},
		hidden: true,
		children: [{
			path: 'index',
			name: 'index',
			component: () => import('@/views/goods/admin_goods'),
			meta: {
				title: '首页',
				icon: 'table'
			},
			hidden: true
		}, ]
	},

	{
		path: '/file_sharing/pan_get_file/:code',
		name: 'pan_get_file',
		component: pan_get_file
	},

	// 404 page must be placed at the end !!!
	{
		path: '*',
		redirect: '/404',
		hidden: true
	}
]

export const asyncRoutes = [
	// {
	//   path: '/test',
	//   component: Layout,
	//   redirect: '/test/test',
	//   alwaysShow: true, // will always show the root menu
	//   name: 'test',
	//   meta: {
	//     title: '权限测试',
	//     icon: 'el-icon-user-solid',
	//     roles: ['admin', 'editor','glq'] // you can set roles in root nav
	//   },
	//   children: [
	//     {
	//       path: 'test',
	//       component: () => import('@/views/test/test'),
	//       name: 'test',
	//       meta: {
	//         title: '文件备份-权限测试',
	//         icon:'el-icon-user-solid',
	//         roles: ['admin','glq'] // or you can only set roles in sub nav
	//       }
	//     },
	//   ]
	// },

	{
		path: '/goods',
		component: Layout,
		redirect: '/goods/admin_user',
		name: '管理员管理',
		meta: {
			title: '管理员管理',
			icon: 'el-icon-user-solid',
			roles: ['man']
		},
		children: [{
				path: 'adminUser',
				name: 'AdminUser',
				component: () => import('@/views/goods/admin_user'),
				meta: {
					title: '用户管理',
					icon: 'table',
					roles: ['man']
				}
			},
			{
				path: 'adminSort',
				name: 'adminSort',
				component: () => import('@/views/goods/admin_sort'),
				meta: {
					title: '货物分类管理',
					icon: 'table',
					roles: ['man']
				}
			},
			{
				path: 'adminAddress',
				name: 'AdminAddress',
				component: () => import('@/views/goods/admin_address'),
				meta: {
					title: '仓库地址管理',
					icon: 'table',
					roles: ['man']
				}
			},
			{
				path: 'adminGoods',
				name: 'AdminGoods',
				component: () => import('@/views/goods/admin_goods'),
				meta: {
					title: '货物/库存管理',
					icon: 'table',
					roles: ['man']
				}
			},
			// {
			//   path: 'adminBorrowList',
			//   name: 'AdminBorrowList',
			//   component: () => import('@/views/goods/admin_borrow_list'),
			//   meta: { title: '借阅列表', icon: 'table' , roles: ['man']}
			// },
			{
				path: 'userBorrow',
				name: 'UserBorrow',
				component: () => import('@/views/goods/user_borrow'),
				meta: {
					title: '出库/入库',
					icon: 'table',
					roles: ['man']
				}
			}, {
				path: 'currData',
				name: 'currData',
				component: () => import('@/views/goods/currData'),
				meta: {
					title: '实时数据',
					icon: 'table',
					roles: ['man']
				}
			},
			// {
			// 	path: 'admin_borrow_list',
			// 	name: 'admin_borrow_list',
			// 	component: () => import('@/views/goods/admin_borrow_list'),
			// 	meta: {
			// 		title: '出入库记录',
			// 		icon: 'table',
			// 		roles: ['man']
			// 	}
			// }, 

			{
				path: 'goodsInfo/:id',
				name: 'GoodsInfo',
				hidden: true,
				component: () => import('@/views/goods/goods_info'),
				meta: {
					title: '物品详细信息',
					icon: 'table',
					roles: ['man']
				}
			},

		]
	},
	{
		path: '/goods',
		component: Layout,
		redirect: '/goods/user_goods',
		name: '普通用户管理',
		meta: {
			title: '普通用户管理',
			icon: 'el-icon-user-solid',
			roles: ['pan']
		},
		children: [
			
			{
				path: 'adminGoods',
				name: 'AdminGoods',
				component: () => import('@/views/goods/admin_goods'),
				meta: {
					title: '货物/库存管理',
					icon: 'table',
					roles: ['pan']
				}
			},

			{
				path: 'userBorrow',
				name: 'UserBorrow',
				component: () => import('@/views/goods/user_borrow'),
				meta: {
					title: '出库/入库',
					icon: 'table',
					roles: ['pan']
				}
			}, {
				path: 'currData',
				name: 'currData',
				component: () => import('@/views/goods/currData'),
				meta: {
					title: '实时数据',
					icon: 'table',
					roles: ['pan']
				}
			},  
			// {
			// 	path: 'admin_borrow_list',
			// 	name: 'admin_borrow_list',
			// 	component: () => import('@/views/goods/admin_borrow_list'),
			// 	meta: {
			// 		title: '出入库记录',
			// 		icon: 'table',
			// 		roles: ['pan']
			// 	}
			// }, 
		]
	},
	// 404 page must be placed at the end !!!
	{
		path: '*',
		redirect: '/404',
		hidden: true
	}
]



const createRouter = () => new Router({
	// mode: 'history', // require service support
	scrollBehavior: () => ({
		y: 0
	}),
	routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
	const newRouter = createRouter()
	router.matcher = newRouter.matcher // reset router
}

export default router
