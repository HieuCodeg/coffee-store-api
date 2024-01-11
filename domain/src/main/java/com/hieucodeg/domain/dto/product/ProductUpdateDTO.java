package com.hieucodeg.domain.dto.product;

import com.hieucodeg.domain.entity.Category;
import com.hieucodeg.domain.entity.Product;
import com.hieucodeg.domain.entity.ProductImage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductUpdateDTO {
    private Long id;

    @NotEmpty(message = "Vui lòng nhập tên sản phẩm.")
    @Size(min = 5, max = 50, message = "Tên sản phẩm có độ dài nằm trong khoảng 5 - 50 ký tự.")
    private String title;
    @NotEmpty(message = "Vui lòng nhập mô tả sản phẩm.")
    @Size(min = 5, max = 500, message = "Mô tả sản phẩm có độ dài nằm trong khoảng 5 - 500 ký tự.")
    private String description;

    private String summary;
    private String sizes;

    @NotNull(message = "Vui lòng chọn danh mục sản phẩm.")
    @Pattern(regexp = "^\\d+$", message = "ID danh mục sản phẩm phải là số.")
    private String categoryId;


    public Product toProduct(Category category, ProductImage productImage) {
        return new Product()
                .setId(id)
                .setTitle(title)
                .setDescription(description)
                .setSummary(summary)
                .setCategory(category)
                .setSizes(sizes)
                .setProductImage(productImage);
    }
}
