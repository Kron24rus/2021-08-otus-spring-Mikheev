<template>
    <book-info :book-model="book" v-if="isBookView">
    </book-info>
    <book-edit :book-model="book" v-if="isBookView">
    </book-edit>
    <div v-else class="container">
        <div class="row">
            <div class="col-md-4 mt-5">
                <h1>Books:</h1>
                <table class="books">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Book page</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="(book, index) in books" v-bind:key="index">
                        <td>{{ book.id }}</td>
                        <td>{{ book.title }}</td>
                        <td>
                            <a href="#" v-on:click="getBook(book.id)">Info</a>
                        </td>
                        <td>
                            <button class="btn btn-primary" v-on:click="deleteBook(book.id)">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <a href="#" @click="createBook()">Add Book</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <book-add></book-add>
    </div>
</template>
<script>
    import apiService from '@/services/api-service';
    import BookEdit from '@/components/book/BookEdit.vue';
    import BookInfo from '@/components/book/BookInfo.vue';
    import BookAdd from '@/components/book/BookAdd.vue';

    export default {
        name: "Book",

        components: {
            'book-edit': BookEdit,
            'book-info': BookInfo,
            'book-add': BookAdd
        },

        data: function () {
            return {
                isBookView: false,
                books: {},
                book: {}
            }
        },

        mounted: function () {
            this.getBookList();
        },

        methods: {
            getBookList: function () {
                let that = this;
                apiService.getBookList()
                    .then(function (response) {
                        that.books = response.data;
                    }).catch(function (error) {
                    //todo: add error message
                })
            },

            getBook: function (bookId) {
                let that = this;
                apiService.getBook(bookId)
                    .then(function (response) {
                        that.book = response.data;
                        that.isBookView = true;
                    })
            },

            createBook: function() {

            },

            deleteBook: function (bookId) {
                let that = this;
                apiService.deleteBook(bookId)
                    .then(function () {
                        that.getBookList();
                        that.isBookView = false;
                    })
            }
        }
    }
</script>
