<template>
  <div v-if="isBookView" class="container">
    <div class="row">
      <div class="col-md-4 mt-5">
        <h1>Book info:</h1>

        <table class="books">
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

        <table class="books">
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
              <button class="btn btn-primary" type="submit">Delete</button>
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
    </div>
  </div>
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
              <a href="#">Add Book</a>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>
<script>
import apiService from '../services/api-service'
import router from "../router";

export default {
  name: "BookComponent",
  data: function() {
    return {
      isBookView: false,
      books: null,
      book: null
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

    deleteBook: function (bookId) {
      let that = this;
      apiService.deleteBook(bookId)
              .then(function () {
                router.push('/book');
                that.isBookView = false;
              })
    }
  }
}
</script>
