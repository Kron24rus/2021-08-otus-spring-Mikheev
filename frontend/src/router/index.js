import {createRouter, createWebHistory} from 'vue-router'
import Library from '../views/Library'

const routes = [
    {
        path: '/',
        name: 'Library',
        component: Library
    },
    {
        path: '/book',
        name: 'List of books',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import('../views/BookList.vue')
    },
    {
        path: '/book/:id',
        name: 'Book page',
        component: () => import('../views/BookPage.vue'),
        props: true
    },
    {
        path: '/author',
        name: 'List of authors',
        component: () => import('../views/AuthorList.vue')
    },
    {
        path: '/genre',
        name: 'List of genres',
        component: () => import('../views/GenreList.vue')
    }
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router
