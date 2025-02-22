package model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRole {
  private long id;
  private long roleId;
  private String roleName;
}
