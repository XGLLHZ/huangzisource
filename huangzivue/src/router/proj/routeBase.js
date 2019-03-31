const routeBase = [
    {
        path: '/hostInfo',
        name: 'hostinfo',
        component: ()=>import('@/views/base/hostinfo/index'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/hostInfoEdit',
        name: 'name',
        component: ()=>import('@/views/base/hostinfo/edit')
    }
]

export default routeBase
