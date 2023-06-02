import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SupportView from "@/views/SupportView.vue";
import NewsView from "@/views/NewsView.vue";
import CatalogView from "@/views/CatalogView.vue";
import DubbingView from "@/views/DubbingView.vue";
import PageNotFound from "@/views/PageNotFound.vue";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/news',
    name: 'News',
    component: NewsView
  },
  {
    path: '/catalog',
    name: 'Catalog',
    component: CatalogView
  },
  {
    path: '/dubbing',
    name: 'Dubbing',
    component: DubbingView
  },
  {
    path: '/about',
    name: 'About',
    component: SupportView
  },
  {
    path: '/:catchAll(.*)',
    name: 'PageNotFound',
    component: PageNotFound
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
