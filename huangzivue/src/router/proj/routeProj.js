const routeProj = [
    {
        path: '/person',
        name: 'person',
        component: ()=>import('@/views/proj/personcenter/person'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/personcenter',
        name: 'personcenter',
        component: ()=>import('@/views/proj/personcenter/index'),
        meta: {
            requireAuth: true
        }
    },
    {
        path: '/hostlive',
        name: 'hostlive',
        component: ()=>import('@/views/proj/alllive/hostlive')
    },
    {
        path: '/castkind',
        name: 'castkind',
        component: ()=>import('@/views/proj/kind/castkind')
    }
]

export default routeProj

