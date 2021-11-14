<template>
    <book-edit v-if="isEditBook"
               :book-model="book"
               @bookSaved="updateSavedBook">
    </book-edit>
    <comment-edit v-if="isEditComment"
                  :comment-model="editedComment"
                  @commentSaved="updateComment">
    </comment-edit>
    <comment-add v-if="isAddComment"
                 :book-id="id"
                 @commentAdded="updateCommentList">
    </comment-add>
    <div class="col-12" v-if="bookPageActive">
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
                    <a href="#" @click="enableEditMode()">Edit</a>
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
                    <a href="#"
                       @click="editComment(comment)">Edit</a>
                </td>
                <td>
                    <button class="btn btn-primary"
                            v-on:click="deleteComment(comment.id)">Delete
                    </button>
                </td>
            </tr>
            <tr>
                <td colspan="4">
                    <a href="#"
                       @click="createComment()">Add Comment</a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import apiService from '../services/api-service';
    import BookEdit from '@/components/book/BookEdit.vue';
    import CommentAdd from '@/components/comment/CommentAdd.vue';
    import CommentEdit from '@/components/comment/CommentEdit.vue';

    export default {
        name: "BookPage",

        props: ['id'],

        components: {
            BookEdit,
            CommentAdd,
            CommentEdit
        },

        data: function () {
            return {
                book: {},
                bookModel: {},
                selectedGenre: {},
                isEditBook: false,
                isEditComment: false,
                isAddComment: false,
                isLoading: false,
                editedComment: {}
            }
        },

        computed: {
            bookPageActive: function () {
                return !(this.isEditBook || this.isEditComment || this.isAddComment || this.isLoading);
            }
        },

        created: function () {
            this.getBook(this.id);
        },

        methods: {
            getBook: function (bookId) {
                this.isLoading = true;
                let that = this;
                apiService.getBook(bookId)
                    .then(function (response) {
                        that.bookModel = response.data;
                        that.book = that.bookModel.book;
                        that.book.comments = that.bookModel.comments;
                        that.isLoading = false;
                    })
            },

            enableEditMode: function () {
                this.isEditBook = true;
            },

            updateSavedBook: function (savedBook) {
                this.book.title = savedBook.title;
                this.book.author = savedBook.author;
                this.book.genre = savedBook.genre;
                this.isEditBook = false;
            },

            createComment: function () {
                this.isAddComment = true;
            },

            updateCommentList: function (addedComment) {
                this.book.comments.push(addedComment);
                this.isAddComment = false;
            },

            editComment: function (comment) {
                this.isEditComment = true;
                this.editedComment = comment;
            },

            updateComment: function (savedComment) {
                let comments = this.book.comments;
                Object.keys(comments).forEach(key => {
                    if (comments[key].id === savedComment.id) {
                        comments[key].text = savedComment.text;
                    }
                });
                this.isEditComment = false;
            },

            deleteComment: function (commentId) {
                let that = this;
                apiService.deleteComment(commentId)
                    .then(function () {
                        that.updateModelAfterDelete(commentId);
                    })
            },

            updateModelAfterDelete: function (commentId) {
                let comments = this.book.comments;
                Object.entries(comments).forEach(([key, value]) => {
                    if (value.id === commentId) {
                        comments.splice(key, 1)
                    }
                })
            }
        }
    }
</script>
