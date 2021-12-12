import apiClient from './api-client'
import TokenService from './token-service'

export default {
    login(data) {
        return apiClient.post('/auth/login', data)
            .then(response => {
                if (response.data.accessToken) {
                    TokenService.setUser(response.data);
                }
                return response.data;
            });
    },

    logout() {
        TokenService.removeUser();
    }
}
