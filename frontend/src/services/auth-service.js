import axios from 'axios'

const authClient = axios.create({
    baseURL: '/api/auth',
    withCredentials: false,
    headers: {'Content-Type': 'application/json'}
});

export default {
    login(data) {
        return authClient.post('/login', data)
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }
                return response.data;
            });
    }
}