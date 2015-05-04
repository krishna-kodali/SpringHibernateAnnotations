package com.ccs.ems.svc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ccs.ems.dao.UserDAO;
import com.ccs.ems.model.Roles;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String userFirstName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.ccs.ems.model.User user = userDAO.getUserByFirstName(userFirstName);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoleSet());
 
		return buildUserForAuthentication(user, authorities);
	}
	
	// Converts com.mkyong.users.model.User user to
		// org.springframework.security.core.userdetails.User
		private User buildUserForAuthentication(com.ccs.ems.model.User user, 
			List<GrantedAuthority> authorities) {
			return new User(user.getUserFirstName(), 
				user.getUserLastName(), 
	                        authorities);
		}
	 
		private List<GrantedAuthority> buildUserAuthority(Set<Roles> roleSet) {
	 
			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	 
			// Build user's authorities
			for (Roles userRole : roleSet) {
				setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
			}
	 
			List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
	 
			return Result;
		}

}
