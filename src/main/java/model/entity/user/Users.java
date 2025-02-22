package model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
@Data
@AllArgsConstructor
public class Users {
    private String id;
    private String username;
    private String password;
    private String email;
    private Role role = Role.USER;
    private Date createdAt;
}
