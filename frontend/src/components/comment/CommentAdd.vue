<template>
    <div class="col-12">
        <div class="form-group">
            <h1>Add comment</h1>
            <div class="row">
                <label for="holder-input">Text:</label>
                <input id="holder-input" name="text" type="text" value=""/>
            </div>
            <button class="btn btn-primary" v-on:click="addComment()">Save</button>
        </div>
    </div>
</template>

<script>
    import apiService from '@/services/api-service';

    export default {
        name: "CommentAdd",
        // data: function () {
        //     return {
        //         libraryEntities: {},
        //         bookTitle: '',
        //         selectedAuthor: {},
        //         selectedGenre: {}
        //     }
        // },
        methods: {
            addComment: function () {
                let that = this;
                that.$emit('commentAdded');
            }
        }
    }
</script>
