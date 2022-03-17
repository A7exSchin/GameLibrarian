<template>
    <div class="home">
        <h1>Games</h1>
        <b-alert v-bind:show="games.length === 0" variant="warning">
            No games available...!
        </b-alert>

        <div class="gameBox" v-for="game in games" v-bind:key="game.id">
            <h3>{{ game.name }}</h3>
            <p>Size: X GB</p>
            <p>Evtl. Bildplatz</p>
            <div>
                <b-button
                    variant="primary"
                >
                    Download
                </b-button>
                <b-button
                    variant="danger"
                    v-on:click="deleteGame(game.id)"
                >
                    <b-icon-trash></b-icon-trash> Delete
                </b-button>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";
import config from "@/config";
export default {
    name: "Home",
    components: {
    },
    data() {
        return {
            games: []
        };
    },
    methods: {
        fetchAllGames: function () {
            axios.get(`${config.apiBaseUrl}/games`).then((response) => {
                console.log(response.data);
                this.games = response.data;
            })
        },
        // this function is assigned to the button
        submit: function () {
            this.showToastMessage(
                "Welcome!",
                `Hello ${this.name}! Nice to meet you!`,
                "success"
            );
            this.name = "";
        },
        showToastMessage(title, msg, variant) {
            this.$bvToast.toast(msg, {
                title: title,
                variant: variant,
                solid: true,
                toaster: "b-toaster-top-center",
                autoHideDelay: 4000,
                appendToast: true
            });
        },
        deleteGame(id) {
            axios.delete(`${config.apiBaseUrl}/game/${id}`).then((response) => {
                console.log(response.data)
            })
        }
    },
    created: function () {
        this.fetchAllGames();
    }
};
</script>

<style>
.gameBox {
    padding: 10px;
    margin: 3px;
    border: 1px solid #42b983;
    float: left;
    min-width: 250px;
    text-align: center;
}
.gameLogo {
    height: 200px;
}
.gameBox button {
    margin: 5px;
}
</style>
