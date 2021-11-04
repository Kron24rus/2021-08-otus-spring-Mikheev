import axios from 'axios'

const apiClient = axios.create({
  baseURL: '/api/library',
  withCredentials: false,
  headers: { 'Content-Type': 'application/json' }
})

export default {
  getBookList () {
    return apiClient.get('/book')
  },
  getBook (bookId){
    return apiClient.get('/book/' + bookId)
  },
  deleteBook (bookId) {
    return apiClient.delete('/book/' + bookId)
  },
  getAuthorList () {
    return apiClient.get('/author')
  },
  getGenreList () {
    return apiClient.get('/genre')
  }
}
