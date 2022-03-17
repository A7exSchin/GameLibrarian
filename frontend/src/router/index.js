import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

// all frontend routes of the app, i.e. bind a path to a Vue component
const routes = [
    {
        path: "/",
        name: "Home",
        component: Home
    }
];

const router = new VueRouter({
    routes
});

export default router;
