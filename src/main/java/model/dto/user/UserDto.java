package model.dto.user;

import model.entity.user.Role;

import java.sql.Date;

public class UserDto {
    private String id;
    private String username;
    private String email;
    private Role role = Role.USER;
    private Date createdAt;
}
