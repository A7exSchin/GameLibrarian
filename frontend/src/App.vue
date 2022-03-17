<template>
    <div id="app">
        <!-- this navigation will appear on every route -->

        <b-navbar toggleable="lg" type="dark" variant="dark">
            <b-navbar-brand to="/">
                <img alt="Vue logo" src="./assets/logo.png" class="logo" />
                Home
            </b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav class="ml-auto">
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>

        <!-- the different view templates will appear in this HTML element based on the route -->
        <div class="main">
            <router-view></router-view>
        </div>
    </div>
</template>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    color: #2c3e50;
}

.logo {
    height: 35px;
    margin: 0 3px;
}

.main {
    padding: 10px 20px;
}
</style>
