<template>
    <div class="col-12">
        <h1>Authors</h1>
        <table class="table">
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
</template>

<script>
    import apiService from '../services/api-service'

    export default {
        name: "AuthorList",
        data: function () {
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
