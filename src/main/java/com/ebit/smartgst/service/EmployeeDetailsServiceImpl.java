package com.ebit.smartgst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ebit.smartgst.model.Employee;
import com.ebit.smartgst.repo.EmployeeRepository;
import com.ebit.smartgst.utils.EmployeeDetail;
 
public class EmployeeDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private EmployeeRepository empRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Employee user = empRepository.getEmployeeByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new EmployeeDetail(user);
    }
 
}
