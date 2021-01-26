package com.example.moviebooking.controller.admin.userInfo;


import com.example.moviebooking.entity.userInfo.Authority;
import com.example.moviebooking.entity.userInfo.AuthorityRole;
import com.example.moviebooking.entity.userInfo.User;
import com.example.moviebooking.service.authentication.AuthorityService;
import com.example.moviebooking.service.authentication.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "admin.users")
@RestController
@RequestMapping("/admin/users")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PostMapping("{id}/authority")
    public void addAuthority(@PathVariable Long id, @RequestBody AuthorityRole role){
        Authority authority = new Authority();
        authority.setUser(new User(id));
        authority.setRole(role);
        authorityService.save(authority);
    }

    @DeleteMapping("{id}/authority")
    public void deleteByUserAndRole(@PathVariable Long id, @RequestBody AuthorityRole role){
        authorityService.deleteByUserAndRole(id,role);
    }

    @DeleteMapping("{id}/authority/{authorityId}")
    public void deleteByUserAndRole(@PathVariable Long id, @PathVariable long authorityId){
        authorityService.deleteById(authorityId);
    }

    @GetMapping("/role/{role}")
    public List<Authority> findByRole(@PathVariable AuthorityRole role){
        return authorityService.findByRole(role);
    }

}
