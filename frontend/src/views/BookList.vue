<template>
    <book-add v-if="isCreateMode"
              @bookAdded="updateBookList"></book-add>
    <div v-else class="col-12">
        <h1>Books</h1>
        <table class="table">
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
                    <router-link :to="{ name: 'Book page', params: { id: book.id }}">Info</router-link>
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
</template>

<script>
    import apiService from '@/services/api-service';
    import BookAdd from '@/components/book/BookAdd.vue';

    export default {
        name: "BookList",

        components: {
            BookAdd
        },

        data: function () {
            return {
                isCreateMode: false,
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

            createBook: function () {
                this.isCreateMode = true;
            },

            updateBookList: function(addedBook) {
                this.books.push(addedBook);
                this.isCreateMode = false;
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
