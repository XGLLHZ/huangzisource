const routeBase = [
    {
        path: '/hostInfo',
        name: 'hostinfo',
        component: ()=>import('@/views/base/hostinfo/index')
    },
    {
        path: '/hostInfoEdit',
        name: 'name',
        component: ()=>import('@/views/base/hostinfo/edit')
    }
]

export default routeBase
