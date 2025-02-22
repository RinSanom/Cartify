package model.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
@Data
@AllArgsConstructor
public class Category {
    private long categoryId;
    private String categoryName;
    private Date createdAt;
}
