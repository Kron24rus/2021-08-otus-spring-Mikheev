<template>
    <div id="nav">
        <router-link to="/">Library Main</router-link>
        |
        <router-link v-if="!currentUser" to="/login">Login</router-link>
        <template v-if="currentUser">
            <router-link to="/book">List of all books</router-link>
            |
            <router-link to="/author">List of all authors</router-link>
            |
            <router-link to="/genre">List of all genres</router-link>
        </template>
        <template v-if="currentUser">|
            <a v-if="currentUser" @click="logOut" href="#">LogOut</a>
        </template>
    </div>
    <div class="container">
        <div class="row">
            <router-view/>
        </div>
    </div>
</template>

<script>
    import EventBus from './services/event-bus';

    export default {
        computed: {
            currentUser() {
                return this.$store.state.auth.user;
            }
        },
        methods: {
            logOut() {
                this.$store.dispatch('auth/logout');
                this.$router.push('/login');
            }
        },
        mounted() {
            EventBus.on('logout', () => {
                this.logOut();
            })
        },
        beforeDestroy() {
            EventBus.remove('logout');
        }
    };
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }
    #nav {
        padding: 30px;
    }
    #nav a {
        font-weight: bold;
        color: #2c3e50;
    }
    #nav a.router-link-exact-active {
        color: #42b983;
    }
</style>
