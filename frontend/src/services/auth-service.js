import apiClient from './api-client'
import TokenService from './token-service'

export default {
    login(data) {
        return apiClient.post('/auth/login', data)
            .then(({data}) => {
                if (data.accessToken) {
                    TokenService.setUser(data);
                }
                return data;
            });
    },

    logout() {
        TokenService.removeUser();
    }
}
