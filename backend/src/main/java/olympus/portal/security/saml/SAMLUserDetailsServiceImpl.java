/*
 * Copyright 2016 Vincenzo De Notaris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

package olympus.portal.security.saml;

import java.util.ArrayList;
import java.util.List;

import olympus.portal.data.LoginUser;
import olympus.portal.data.LoginUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SAMLUserDetailsServiceImpl implements SAMLUserDetailsService {

    // Logger
    private static final Logger LOG = LoggerFactory.getLogger(SAMLUserDetailsServiceImpl.class);

    @Autowired
    private LoginUserRepository userRepository;

    // The method is supposed to identify local account of user referenced by
    // data in the SAML assertion and return UserDetails object describing the user.
    public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
        String userId = credential.getNameID().getValue();
        LOG.info(userId + " is logging in");

        LoginUser user = userRepository.findByUsername(userId);
        if(user == null) {
            user = userRepository.save(new LoginUser(userId, ""));
        }
        LOG.info(user + " has logged in");

        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        authorities.add(authority);
        return new User(userId, "<abc123>", true, true, true, true, authorities);
    }

}
