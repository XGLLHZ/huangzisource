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
    }
]

export default routeProj

