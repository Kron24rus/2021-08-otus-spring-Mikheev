<template>
    <div class="col-12">
        <div class="form-group">
            <h1>Edit comment</h1>
            <div class="row">
                <label for="id-input">ID:</label>
                <input id="id-input" type="text" readonly="readonly" value="1"/>
            </div>
            <div class="row">
                <label for="holder-input">Text:</label>
                <input id="holder-input" name="text" type="text" value="Comment"/>
            </div>
            <button class="btn btn-primary" v-on:click="saveComment()">Save</button>
        </div>
    </div>
</template>

<script>
    import apiService from '../../services/api-service'

    export default {
        name: "CommentEdit",
        // props: [
        //     'bookModel'
        // ],
        // data: function () {
        //     return {
        //         libraryEntities: {},
        //         bookTitle: '',
        //         selectedAuthor: {},
        //         selectedGenre: {}
        //     }
        // },
        // mounted: function () {
        //     this.selectedAuthor = this.bookModel.author;
        //     this.selectedGenre = this.bookModel.genre;
        //     this.bookTitle = this.bookModel.title;
        //     this.loadLibraryEntities();
        // },
        methods: {
            saveComment: function () {
                let that = this;
                this.$emit('commentSaved');
            }
        }
    }
</script>
