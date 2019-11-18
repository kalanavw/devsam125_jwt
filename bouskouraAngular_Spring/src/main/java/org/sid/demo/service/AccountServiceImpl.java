package org.sid.demo.service;


import org.sid.demo.dao.AppRoleJpaRepository;
import org.sid.demo.dao.UserRepository;
import org.sid.demo.entities.AppRole;
import org.sid.demo.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AppRoleJpaRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public AppUser saveUser(AppUser u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        return userRepository.save(u);
    }

    @Override
    public AppRole saveRole(AppRole r) {
        // TODO Auto-generated method stub
        return roleRepository.save(r);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser user = userRepository.findByUsername(username);
        AppRole role1 = roleRepository.findByRole(role);
        user.getRoles().add(role1);

    }

}
