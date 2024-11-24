package com.Axieva.Assignment.security;

import com.Axieva.Assignment.model.Person;
import com.Axieva.Assignment.model.Roles;
import com.Axieva.Assignment.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AxievaUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email=authentication.getName();
        String pwd = authentication.getCredentials().toString();
        System.out.println("email"+email);
        System.out.println("pwd"+pwd);
        Person person = personRepository.readByEmail(email);
        String RoleAssigned = person.getRoles().getRoleName();
        System.out.println("RoleAssigned:"+RoleAssigned);
        String RoleForConditionCheck="ROLE_"+RoleAssigned;
        System.out.println("RoleForConditionCheck:"+RoleForConditionCheck);
        List<GrantedAuthority> grantedAuthoritiescheck = new ArrayList<>();
        grantedAuthoritiescheck= getGrantedAuthorities(person.getRoles());
        System.out.println("grantedAuthoritiescheck "+grantedAuthoritiescheck);

        if (null != person && person.getPersonId() > 0 && person.getPwd().equals(pwd)) {

            return new UsernamePasswordAuthenticationToken(/*person.getName()*/email, pwd, getGrantedAuthorities(person.getRoles()));
        } else {
            throw new BadCredentialsException("Invalid Credentials");
        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(("ROLE_"+roles.getRoleName())));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
