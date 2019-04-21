const routeBase = [
    {
        path: '/supermanager',
        name: 'supermanager',
        component: ()=>import('@/views/base/supermanager/index'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/supermanagerEdit',
        name: 'supermanagerEdit',
        component: ()=>import('@/views/base/supermanager/edit')
    },
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
        name: 'hostInfoEdit',
        component: ()=>import('@/views/base/hostinfo/edit'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/roommanager',
        name: 'roommanager',
        component: ()=>import('@/views/base/roommanager/index'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/roommanagerEdit',
        name: 'roommanagerEdit',
        component: ()=>import('@/views/base/roommanager/edit')
    },
    {
        path: '/hostfans',
        name: 'hostfans',
        component: ()=>import('@/views/base/hostfans/index'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/hostfansEdit',
        name: 'hostfansEdit',
        component: ()=>import('@/views/base/hostfans/edit')
    },
    {
        path: '/audience',
        name: 'audience',
        component: ()=>import('@/views/base/audienceinfo/index'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/audienceEdit',
        name: 'audienceEdit',
        component: ()=>import('@/views/base/audienceinfo/edit')
    }
]

export default routeBase
