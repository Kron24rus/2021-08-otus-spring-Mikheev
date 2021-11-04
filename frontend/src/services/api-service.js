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
  getAuthorList () {
    return apiClient.get('/author')
  },
  getGenreList () {
    return apiClient.get('/genre')
  }
}
