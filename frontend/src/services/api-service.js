import axios from 'axios'

const apiClient = axios.create({
    baseURL: '/api/library',
    withCredentials: false,
    headers: {'Content-Type': 'application/json'}
});

export default {
    getBookList() {
        return apiClient.get('/book');
    },
    getBook(bookId) {
        return apiClient.get('/book/' + bookId);
    },
    deleteBook(bookId) {
        return apiClient.delete('/book/' + bookId);
    },
    getAuthorList() {
        return apiClient.get('/author');
    },
    getGenreList() {
        return apiClient.get('/genre');
    },
    getEditLibraryEntities() {
        return apiClient.get('/book/associations');
    },
    saveUpdatedBook(data) {
        return apiClient.put('/book', data);
    },
    addBook(data) {
        return apiClient.post('/book', data);
    },
    addComment(bookId, data) {
        return apiClient.post('/book/' + bookId + '/comment', data);
    },
    saveUpdatedComment(data) {
        return apiClient.put('/comment', data);
    },
    deleteComment(commentId) {
        return apiClient.delete('/comment/' + commentId);
    }
}
