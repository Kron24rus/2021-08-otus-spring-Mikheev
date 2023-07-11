package com.mikheev.homework.configuration

import com.fasterxml.jackson.datatype.hibernate5.jakarta.Hibernate5JakartaModule
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.modelmapper.ModelMapper
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.regex.Pattern

@Configuration
class LibraryConfiguration {

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }

    @Bean
    fun hibernate5JakartaModule(): Hibernate5JakartaModule {
        return Hibernate5JakartaModule()
    }

    @Bean
    fun spaRedirectFiler(): FilterRegistrationBean<OncePerRequestFilter> {
        val registration = FilterRegistrationBean<OncePerRequestFilter>()
        registration.filter = createRedirectFilter()
        registration.addUrlPatterns("/*")
        registration.setName("frontendRedirectFiler")
        registration.order = 1
        return registration
    }

    private fun createRedirectFilter(): OncePerRequestFilter {
        return object : OncePerRequestFilter() {
            // Forwards all routes except '/index.html', '/api/library/', '/api/library/**' (caused by history API on frontend)
            private val REGEX = "(?!/api/library|/static|/index\\.html|/favicon\\.ico).*$"
            private val pattern = Pattern.compile(REGEX)

            @Throws(ServletException::class, IOException::class)
            override fun doFilterInternal(
                request: HttpServletRequest, response: HttpServletResponse,
                filterChain: FilterChain
            ) {
                if (pattern.matcher(request.requestURI).matches() && request.requestURI != "/") {
                    val requestDispatcher = request.getRequestDispatcher("/")
                    requestDispatcher.forward(request, response)
                } else {
                    filterChain.doFilter(request, response)
                }
            }
        }
    }
}
