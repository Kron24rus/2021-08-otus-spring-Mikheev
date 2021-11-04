<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4 mt-5">
        <h1>Authors:</h1>
        <table class="books">
          <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(author, index) in authors" v-bind:key="index">
            <td>{{ author.id }}</td>
            <td>{{ author.name }}</td>
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
    name: "AuthorComponent",
    data: function() {
      return {
        authors: null
      }
    },

    mounted: function () {
      this.getAuthorList();
    },

    methods: {
      getAuthorList: function () {
        let that = this;
        apiService.getAuthorList()
          .then(function (response) {
            that.authors = response.data;
          }).catch(function (error) {
          //todo: add error message
        })
      }
    }
  }
</script>
