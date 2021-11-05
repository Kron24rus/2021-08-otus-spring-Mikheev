<template>
    <div class="col-12">
        <h1>Book info</h1>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Genre</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{ book.id }}</td>
                <td>{{ book.title }}</td>
                <td>{{ book.author.name }}</td>
                <td>{{ book.genre.name }}</td>
                <td>
                    <a href="#">Edit</a>
                </td>
            </tr>
            </tbody>
        </table>
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Text</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(comment, index) in book.comments" v-bind:key="index">
                <td>{{ comment.id }}</td>
                <td>{{ comment.text }}</td>
                <td>
                    <a href="#">Edit</a>
                </td>
                <td>
                    <button class="btn btn-primary" v-on:click="deleteComment(comment.id)">Delete</button>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <a href="#">Add Comment</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import apiService from '../services/api-service'

    export default {
        name: "BookPage",

        props: ['id'],

        data: function () {
            return {
                book: {},
                selectedGenre: {}
            }
        },

        created: function () {
            this.getBook(this.id);
        },

        watch: {
            '$route'() {
                this.getBook(this.id);
            }
        },

        methods: {
            getBook: function (bookId) {
                let that = this;
                apiService.getBook(bookId)
                    .then(function (response) {
                        that.book = response.data;
                    })
            },

            deleteComment: function (commentId) {
                let that = this;
                apiService.deleteComment(commentId)
                    .then(function () {
                        that.updateModelAfterDelete(commentId);
                    })
            },

            updateModelAfterDelete: function (commentId) {
                Object.keys(this.book).forEach(key => {

                })
            }
        }
    }
</script>
