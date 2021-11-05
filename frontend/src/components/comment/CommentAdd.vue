<template>
    <div class="col-12">
        <div class="form-group">
            <h1>Add comment</h1>
            <div class="row">
                <label for="holder-input">Text:</label>
                <input id="holder-input" name="text" type="text"
                       v-model="commentText"/>
            </div>
            <button class="btn btn-primary"
                    v-on:click="addComment()">Save
            </button>
        </div>
    </div>
</template>

<script>
    import apiService from '@/services/api-service';

    export default {
        name: "CommentAdd",
        props: [
            'bookId'
        ],
        data: function () {
            return {
                commentText: '',
            }
        },
        methods: {
            addComment: function () {
                let that = this;
                let commentToAdd = {
                    text: this.commentText,
                };
                apiService.addComment(this.bookId, commentToAdd)
                    .then(function (response) {
                        that.$emit('commentAdded', response.data);
                    })
            }
        }
    }
</script>
