<template>
    <book-edit v-if="editBookMode"
               :book-model="book"
               @bookSaved="updateSavedBook">
    </book-edit>
    <comment-edit v-if="editCommentMode"
                  :comment-model="editedComment"
                  @commentSaved="updateComment">
    </comment-edit>
    <comment-add v-if="addCommentMode"
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
                <th v-if="isAdmin || isModerator">Edit</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>{{ book.id }}</td>
                <td>{{ book.title }}</td>
                <td>{{ book.author.name }}</td>
                <td>{{ book.genre.name }}</td>
                <td v-if="isModerator || isAdmin">
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
                <th v-if="isModerator">Edit</th>
                <th v-if="isModerator">Delete</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(comment, index) in book.comments" v-bind:key="index">
                <td>{{ comment.id }}</td>
                <td>{{ comment.text }}</td>
                <td v-if="isModerator">
                    <a href="#"
                       @click="editComment(comment)">Edit</a>
                </td>
                <td v-if="isModerator">
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
                selectedGenre: {},
                editBookMode: false,
                editCommentMode: false,
                addCommentMode: false,
                loading: false,
                editedComment: {}
            }
        },

        computed: {
            bookPageActive: function () {
                return !(this.editBookMode || this.editCommentMode || this.addCommentMode || this.loading);
            },
            currentUser() {
                return this.$store.state.auth.user;
            },
            isAdmin() {
                if (this.currentUser && this.currentUser['roles']) {
                    return this.currentUser['roles'].includes('ROLE_ADMIN');
                }
            },
            isModerator() {
                if (this.currentUser && this.currentUser['roles']) {
                    return this.currentUser['roles'].includes('ROLE_MODERATOR');
                }
            }
        },

        created: function () {
            this.getBook(this.id);
        },

        methods: {
            getBook: function (bookId) {
                this.loading = true;
                apiService.getBook(bookId)
                    .then(({data}) => {
                        this.book = data;
                        this.loading = false;
                    })
            },

            enableEditMode: function () {
                this.editBookMode = true;
            },

            updateSavedBook: function (savedBook) {
                this.book.title = savedBook.title;
                this.book.author = savedBook.author;
                this.book.genre = savedBook.genre;
                this.editBookMode = false;
            },

            createComment: function () {
                this.addCommentMode = true;
            },

            updateCommentList: function (addedComment) {
                this.book.comments.push(addedComment);
                this.addCommentMode = false;
            },

            editComment: function (comment) {
                this.editCommentMode = true;
                this.editedComment = comment;
            },

            updateComment: function (savedComment) {
                let comments = this.book.comments;
                Object.keys(comments).forEach(key => {
                    if (comments[key].id === savedComment.id) {
                        comments[key].text = savedComment.text;
                    }
                });
                this.editCommentMode = false;
            },

            deleteComment: function (commentId) {
                apiService.deleteComment(commentId)
                    .then(() => {
                        this.updateModelAfterDelete(commentId);
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
