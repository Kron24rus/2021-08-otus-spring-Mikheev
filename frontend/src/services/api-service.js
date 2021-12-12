import apiClient from './api-client'
import EventBus from './event-bus'

function handleError(error) {

    console.log(error.toString());

    if (error.response && error.response.status === 403) {
        EventBus.dispatch('logout');
    }

    return error;
}

export default {
    getBookList() {
        return apiClient.get('/library/book').catch(error => handleError(error));
    },
    getBook(bookId) {
        return apiClient.get(`/library/book/${bookId}`).catch(error => handleError(error));
    },
    deleteBook(bookId) {
        return apiClient.delete(`/library/book/${bookId}`).catch(error => handleError(error));
    },
    getAuthorList() {
        return apiClient.get('/library/author').catch(error => handleError(error));
    },
    getGenreList() {
        return apiClient.get('/library/genre').catch(error => handleError(error));
    },
    getEditLibraryEntities() {
        return apiClient.get('/library/associations').catch(error => handleError(error));
    },
    saveUpdatedBook(data) {
        return apiClient.put('/library/book', data).catch(error => handleError(error));
    },
    addBook(data) {
        return apiClient.post('/library/book', data).catch(error => handleError(error));
    },
    addComment(data) {
        return apiClient.post('/library/comment', data).catch(error => handleError(error));
    },
    saveUpdatedComment(data) {
        return apiClient.put('/library/comment', data).catch(error => handleError(error));
    },
    deleteComment(commentId) {
        return apiClient.delete(`/library/comment/${commentId}`).catch(error => handleError(error));
    }
}
