const routeNav = [
    {
        path: '/alllive',
        name: 'alllive',
        component: ()=>import('@/views/proj/alllive/index')
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
    },
    {
        path: '/login',
        name: 'login',
        component: ()=>import('@/views/base/logreg/login')
    },
    {
        path: '/register',
        name: 'register',
        component: ()=>import('@/views/base/logreg/register')
    },
    {
        path: '/updatepassword',
        name: 'updatepassword',
        component: ()=>import('@/views/proj/personcenter/updatepassword')
    }
]

export default routeNav
