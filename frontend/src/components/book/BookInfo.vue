<template>
    <div class="container">
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
                        <td>{{ bookModel.id }}</td>
                        <td>{{ bookModel.title }}</td>
                        <td>{{ bookModel.author.name }}</td>
                        <td>{{ bookModel.genre.name }}</td>
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
                    <tr v-for="(comment, index) in bookModel.comments" v-bind:key="index">
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
</template>

<script>
    import apiService from '../../services/api-service'

    export default {
        name: "BookInfo",
        props: [
            'bookModel'
        ],

        data: function () {
            return {
                libraryEntities: {},
                selectedGenre: {}
            }
        },

        mounted: function () {
            this.loadLibraryEntities();
            this.selectedGenre = this.bookModel.genre;
        },

        methods: {
            loadLibraryEntities: function () {
                let that = this;
                apiService.getEditLibraryEntities()
                    .then(function (response) {
                        that.libraryEntities = response.data;
                    })
            }
        }
    }
</script>
