<template>
    <div class="home">
        <h1>Games</h1>
        <b-alert v-bind:show="games.length === 0" variant="warning">
            No games available...!
        </b-alert>
        <b-container fluid>
            <b-table striped hover head-variant="dark" :items="games" :fields="fields">
                <template #cell(size)="games">
                            {{ games.item.size.toFixed(2) }} GB
                </template>
                <template #cell(actions)="games">
                        <div class="btn-toolbar">
                            <div class="btn-group mx-2">
                                <b-button
                                    size="sm"
                                    variant="primary"
                                    v-on:click="showToDo(games.item.id)"
                                > Show Info
                                </b-button>
                            </div>
                            <div class="mb-1">
                                <b-button variant="outline-danger" @click="showMsgBoxTwo(games.item.name, games.item.id)"><b-icon-trash/>Delete game</b-button>
                            </div>
                        </div>
                    </template>

            </b-table>
        </b-container>
        
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
            games: [],
            fields: [
                {
                    key: 'id',
                    label: 'ID'
                },
                {
                    key: 'name',
                    label: 'Title',
                    sortable: true
                },
                {
                    key: 'gameLocation',
                    label: 'Location'
                },
                {
                    key: 'size',
                    label: 'Gamesize',
                    sortable: true
                },
                'actions'
            ]
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
        },
        showMsgBoxTwo(game, id) {
        this.$bvModal.msgBoxConfirm(`Please confirm that you want to delete ${game}.`, {
          title: 'Please Confirm',
          size: 'sm',
          buttonSize: 'sm',
          okVariant: 'danger',
          okTitle: 'YES',
          cancelTitle: 'NO',
          footerClass: 'p-2',
          hideHeaderClose: false,
          centered: true
        })
          .then(value => {
            if (value) {
                this.deleteGame(id);
            }
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
