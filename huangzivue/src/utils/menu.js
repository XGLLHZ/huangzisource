import { getMenuApi } from '@/api/proj/base/navbar.js'

//初始化菜单
export const initMenu = (router,store) => {
  var username = this.$store.state.user.userName
  if (username != null) {
    getMenuApi(username).then(response => {
      if (response && response.status == 200) {
        var menuRoutes = formatRoutes(response.data)
        router.addRoutes(menuRoutes)
        store.commit('initMenu',menuRoutes)
      }
    })
  }
}

//对后台返回的资源列表中的数据进行处理，即将menuUrl转化成component要求的格式
export const formatRoutes = (routes) => {
  let menuRoutes = [];
  routes.forEach(router => {
    let {
      menuPath,
      menuComname,
      menuUrl,
      menuRequireauth,
      children
    } = router
    if (children && children instanceof Array) {
      children = formatRoutes(children)
    }
    let routers = {
      path: menuPath,
      name: menuComname,
      component(resolve) {
        require([menuUrl + '.vue'],resolve)
      },
      meta: {
        requireAuth: menuRequireauth
      },
      children: children
    }
    menuRoutes.push(routers)
  })
  return menuRoutes
}

