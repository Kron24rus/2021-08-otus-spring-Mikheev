import apiClient from './api-client'
import TokenService from './token-service'

const interceptors = (store) => {
    apiClient.interceptors.request.use(
        (config) => {
            const token = TokenService.getLocalAccessToken();
            if (token) {
                config.headers["Authorization"] = 'Bearer ' + token;
            }
            return config;
        },
        (error) => {
            return Promise.reject(error);
        }
    );

    apiClient.interceptors.response.use(
        (res) => {
            return res;
        },
        async (err) => {
            const originalConfig = err.config;
            if (originalConfig.url !== '/auth/login' && err.response) {
                if (err.response.status === 401 && !originalConfig._retry) {
                    originalConfig._retry = true;

                    try {
                        const rs = await apiClient.post('/auth/refreshtoken', {
                            refreshToken: TokenService.getLocalRefreshToken()
                        });

                        const { accessToken } = rs.data;

                        store.dispatch('auth/refreshToken', accessToken);
                        TokenService.updateLocalAccessToken(accessToken);

                        return apiClient(originalConfig);
                    } catch (error) {
                        return Promise.reject(error);
                    }
                }
            }
            return Promise.reject(err);
        }
    )
};

export default interceptors;