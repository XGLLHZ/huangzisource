const routeNav = [
    {
        path: '/alllive',
        name: 'alllive',
        component: ()=>import('@/views/proj/all/index')
    },
    {
        path: '/kind',
        name: 'kind',
        component: ()=>import('@/views/proj/kind/index')
    },
    {
        path: '/huangzivideo',
        name: 'kinhuangzivideod',
        component: ()=>import('@/views/proj/huangzivideo/index')
    }
]

export default routeNav
