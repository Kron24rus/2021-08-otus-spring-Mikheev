import axios from 'axios'
import authHeader from './auth-header'

const apiClient = axios.create({
    baseURL: '/api/library',
    withCredentials: false
});

export default {
    getBookList() {
        return apiClient.get('/book', { headers: authHeader() });
    },
    getBook(bookId) {
        return apiClient.get(`/book/${bookId}`, { headers: authHeader() });
    },
    deleteBook(bookId) {
        return apiClient.delete(`/book/${bookId}`, { headers: authHeader() });
    },
    getAuthorList() {
        return apiClient.get('/author', { headers: authHeader() });
    },
    getGenreList() {
        return apiClient.get('/genre', { headers: authHeader() });
    },
    getEditLibraryEntities() {
        return apiClient.get('/associations', { headers: authHeader() });
    },
    saveUpdatedBook(data) {
        return apiClient.put('/book', data, { headers: authHeader() });
    },
    addBook(data) {
        return apiClient.post('/book', data, { headers: authHeader() });
    },
    addComment(data) {
        return apiClient.post('/comment', data, { headers: authHeader() });
    },
    saveUpdatedComment(data) {
        return apiClient.put('/comment', data, { headers: authHeader() });
    },
    deleteComment(commentId) {
        return apiClient.delete(`/comment/${commentId}`, { headers: authHeader() });
    }
}
