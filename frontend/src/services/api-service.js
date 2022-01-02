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
        return apiClient.get('/library/book').catch(handleError);
    },
    getBook(bookId) {
        return apiClient.get(`/library/book/${bookId}`).catch(handleError);
    },
    deleteBook(bookId) {
        return apiClient.delete(`/library/book/${bookId}`).catch(handleError);
    },
    getAuthorList() {
        return apiClient.get('/library/author').catch(handleError);
    },
    getGenreList() {
        return apiClient.get('/library/genre').catch(handleError);
    },
    getEditLibraryEntities() {
        return apiClient.get('/library/associations').catch(handleError);
    },
    saveUpdatedBook(data) {
        return apiClient.put('/library/book', data).catch(handleError);
    },
    addBook(data) {
        return apiClient.post('/library/book', data).catch(handleError);
    },
    addComment(data) {
        return apiClient.post('/library/comment', data).catch(handleError);
    },
    saveUpdatedComment(data) {
        return apiClient.put('/library/comment', data).catch(handleError);
    },
    deleteComment(commentId) {
        return apiClient.delete(`/library/comment/${commentId}`).catch(handleError);
    }
}
