package Integrador5.demo.controllers;


import Integrador5.demo.modelo.AuthCredentials;
import Integrador5.demo.modelo.AuthResponse;
import Integrador5.demo.security.SecurityService;
import Integrador5.demo.security.TokenUtils;
import Integrador5.demo.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
    public class Authenticate {

        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private UserDetailsService userDetailsService;
        @Autowired
        private TokenUtils tokenUtils;
        @Autowired
        private SecurityService service;

        @PostMapping(value = "/authenticate")
        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthCredentials authCredentials) {

            final UserDetails userDetails = service.validation(authCredentials);
            final String jwt = TokenUtils.createToken(userDetails);

            return ResponseEntity.ok(new AuthResponse((jwt)));
        }

    }

