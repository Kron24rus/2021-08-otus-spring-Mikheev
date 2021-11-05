<template>
    <div class="col-12">
        <div class="form-group">
            <h1>Edit book</h1>
            <div>
                <label for="id-input">ID:</label>
                <input id="id-input" type="text" readonly="readonly" :value="bookModel.id"/>
            </div>

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
            <button class="btn btn-primary" v-on:click="saveBook()">Save</button>
        </div>
    </div>
</template>

<script>
    import apiService from '../../services/api-service'

    export default {
        name: "BookEdit",
        props: [
            'bookModel'
        ],
        data: function () {
            return {
                libraryEntities: {},
                bookTitle: '',
                selectedAuthor: {},
                selectedGenre: {}
            }
        },
        mounted: function () {
            this.selectedAuthor = this.bookModel.author;
            this.selectedGenre = this.bookModel.genre;
            this.bookTitle = this.bookModel.title;
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
            saveBook: function () {
                let that = this;
                let bookToSave = Object.assign({}, this.bookModel);
                bookToSave.title = this.bookTitle;
                bookToSave.author = this.selectedAuthor;
                bookToSave.genre = this.selectedGenre;
                apiService.saveUpdatedBook(bookToSave)
                    .then(function (response) {
                        that.$emit('bookSaved', response.data);
                    });

            }
        }
    }
</script>