<template>
    <div>
        <b-button v-b-modal.deleteModal variant="outline-danger"
        >
            <b-icon-trash></b-icon-trash> Delete Game
        </b-button>
        <b-modal id="deleteModal" centered title="Delete the selected Game">
            <p class="my-4"> Do you really want to delete {{ game }} from disk?</p>
        </b-modal>
    </div>
</template>
<script>
export default {
    data() {
        return {
            game : ""
        }
    }
}
</script>
