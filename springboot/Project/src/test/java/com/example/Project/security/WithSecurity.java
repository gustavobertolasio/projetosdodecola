package com.example.Project.security;

import com.example.Project.configuration.security.service.TokenAuthenticationService;
import com.example.Project.domain.dto.request.UserCreateRequest;
import com.example.Project.service.SiteUserService;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * WithSecurity
 */
public class WithSecurity {

    private String validToken;

    public WithSecurity(SiteUserService service, UserCreateRequest usrEmail) {

        UserCreateRequest usr = usrEmail;
        service.createUser(usr.getEmail(), usr.getPassword(), usr.getIsAdmin());
        this.validToken = TokenAuthenticationService.generateToken(usr.getEmail());
	}

	public MockHttpServletRequestBuilder AddToken(MockHttpServletRequestBuilder builder) {
        return builder.header("Authorization", "Bearer " + validToken);
    }

} 