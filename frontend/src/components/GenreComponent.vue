<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4 mt-5">
        <h1>Genres:</h1>
        <table class="books">
          <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(genre, index) in genres" v-bind:key="index">
            <td>{{ genre.id }}</td>
            <td>{{ genre.name }}</td>
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
    name: "GenreComponent",
    data: function() {
      return {
        genres: null
      }
    },

    mounted: function () {
      this.getGenreList();
    },

    methods: {
      getGenreList: function () {
        let that = this;
        apiService.getGenreList()
          .then(function (response) {
            that.genres = response.data;
          }).catch(function (error) {
          //todo: add error message
        })
      }
    }
  }
</script>
