<template>
  <div class="container">
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
              <a href="#">Info</a>
            </td>
            <td>
              <button class="btn btn-primary" type="submit">Delete</button>
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

export default {
  name: "BookComponent",
  data: function() {
    return {
      books: null
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
    }
  }
}
</script>
