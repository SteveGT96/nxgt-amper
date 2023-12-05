package helpers

import com.fasterxml.jackson.databind.ObjectMapper
import services.JwtService
import exceptions.CustomException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtTokenFilter(
	val jwtService: JwtService
) : OncePerRequestFilter() {

	override fun doFilterInternal(
		request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain
	) {
		val debugInfo: MutableMap<String, Any?> = HashMap()
		val token = jwtService.resolveToken(request)
		try {
			if(token != null) {
				jwtService.validateAccessToken(token)
				val auth: Authentication = jwtService.getAuthentication(token)
				SecurityContextHolder.getContext().authentication = auth
			}
			filterChain.doFilter(request, response)
		} catch(e: CustomException) {
			response.status = HttpStatus.OK.value()
			response.contentType = "application/json"
			response.characterEncoding = "UTF-8"
			response.writer.write(ObjectMapper().writeValueAsString(e.message))
		} catch(e: Exception) {
			response.status = HttpStatus.OK.value()
			response.contentType = "application/json"
			response.characterEncoding = "UTF-8"
			response.writer.write(ObjectMapper().writeValueAsString(e.message))
		}
	}
}