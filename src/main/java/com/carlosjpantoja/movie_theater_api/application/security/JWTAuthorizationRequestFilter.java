package com.carlosjpantoja.movie_theater_api.application.security;

import com.carlosjpantoja.movie_theater_api.domain.exception.AppError;
import com.carlosjpantoja.movie_theater_api.domain.exception.AppException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.AUTH;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppEndpoint.AUTHENTICATE;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.AUTH_02;
import static com.carlosjpantoja.movie_theater_api.domain.constant.AppErrorCode.AUTH_03;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class JWTAuthorizationRequestFilter extends OncePerRequestFilter {

	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String USERNAME_CLAIM_KEY = "username";
	private static final String[] EXCLUDED_PATHS = {"POST " + AUTH + AUTHENTICATE};

	private final UserDetailsService userDetailsService;

	@Value("${server.servlet.context-path}")
	private String contextPath;

	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain
	) throws ServletException, IOException {
		try {
			if (containsToken(request)) {
				String jwt = request.getHeader(AUTHORIZATION).replace(TOKEN_PREFIX, "");
				Claims claims = JWTUtil.decodeJWT(jwt);
				String username = getUsername(claims);
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				filterChain.doFilter(request, response);
			} else {
				createUnauthorizedFilter(
						new AppException(
								UNAUTHORIZED,
								new AppError(
										AUTH_02.name(),
										AUTH_02.getMessage()
								)
						), response);
			}
		} catch (JwtException e) {
			createUnauthorizedFilter(
					new AppException(
							UNAUTHORIZED,
							new AppError(
									AUTH_03.name(),
									AUTH_03.getMessage()
							)
					), response);
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getMethod() + " " + request.getRequestURI().replace(contextPath, "");
		return Arrays.stream(EXCLUDED_PATHS).anyMatch(s -> s.equalsIgnoreCase(path));
	}

	private boolean containsToken(HttpServletRequest request) {
		String authenticationHeader = request.getHeader(AUTHORIZATION);
		return authenticationHeader != null &&
				authenticationHeader.startsWith(TOKEN_PREFIX) &&
				authenticationHeader.length() > TOKEN_PREFIX.length();
	}

	private String getUsername(Claims claims) {
		String value = (String) claims.get(USERNAME_CLAIM_KEY);
		return Optional.ofNullable(value).orElseThrow(() -> new JwtException(""));
	}

	@SneakyThrows
	private void createUnauthorizedFilter(AppException exception, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		AppError error = exception.getError();
		String message = mapper.writeValueAsString(error);
		response.setStatus(exception.getHttpStatus().value());
		response.setContentType(APPLICATION_JSON.toString());
		response.getWriter().write(message);
		response.getWriter().flush();
	}

}