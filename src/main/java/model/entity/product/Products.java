package model.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class Products {
    private String productId;
    private String productName;
    private String productDescription;
    private Category productCategory;
    private double productPrice;
    private int productStock;
    private Boolean isSold;
    private Date createdAt;
}
