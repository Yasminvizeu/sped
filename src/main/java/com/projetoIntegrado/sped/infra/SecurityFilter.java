package com.projetoIntegrado.sped.infra;

import com.projetoIntegrado.sped.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //pega o token e recupera as informações
        var token = this.recoverToken(request);
        if(token != null){
            var cpf = tokenService.validateToken(token);
            UserDetails user = userRepository.findByCpf(cpf);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            //salva no contexto da autenticção o usuario
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        filterChain.doFilter(request, response);


    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        //token apenas o codigo sem a bearer
        return authHeader.replace("Bearer ", "");
    }

}
