<template>
    <div class="col-12">
        <div class="form-group">
            <h1>Add book:</h1>
            <div>
                <label for="holder-input">Title:</label>
                <input id="holder-input" name="title" type="text"
                       v-model="bookTitle"/>
            </div>
            <div>
                <label for="authorSelect">Choose author:</label>
                <select id="authorSelect" class="form-control" v-model="selectedAuthor">
                    <option v-for="author in libraryEntities.authors"
                            :value="author">{{ author.name }}
                    </option>
                </select>
            </div>
            <div>
                <label for="genreSelect">Choose genre:</label>
                <select id="genreSelect" class="form-control" v-model="selectedGenre">
                    <option v-for="genre in libraryEntities.genres"
                            :value="genre">{{ genre.name }}
                    </option>
                </select>
            </div>
            <button class="btn btn-primary" v-on:click="addBook()">Save</button>
        </div>
    </div>
</template>

<script>
    import apiService from '@/services/api-service';

    export default {
        name: "BookCreate",
        data: function () {
            return {
                libraryEntities: {},
                bookTitle: '',
                selectedAuthor: {},
                selectedGenre: {}
            }
        },
        mounted: function () {
            this.loadLibraryEntities();
        },
        methods: {
            loadLibraryEntities: function () {
                let that = this;
                apiService.getEditLibraryEntities()
                    .then(function (response) {
                        console.log(response.data);
                        that.libraryEntities = response.data;
                    })
            },
            addBook: function () {
                let bookToAdd = {
                    title: this.bookTitle,
                    author: this.selectedAuthor,
                    genre: this.selectedGenre
                };
                apiService.addBook(bookToAdd)
                    .then(function (response) {
                        console.log(response.data);
                    })
            }
        }
    }
</script>
