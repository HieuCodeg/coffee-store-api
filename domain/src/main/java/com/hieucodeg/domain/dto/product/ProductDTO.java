package com.hieucodeg.domain.dto.product;

import com.hieucodeg.domain.dto.category.CategoryDTO;
import com.hieucodeg.domain.dto.productImage.ProductImageDTO;
import com.hieucodeg.domain.entity.Category;
import com.hieucodeg.domain.entity.Product;
import com.hieucodeg.domain.entity.ProductImage;
import com.hieucodeg.utils.JsonToMapConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String title;

    private String summary;
    private String description;

    private Map<String,SizeDTO> sizes;
    private CategoryDTO category;
    private ProductImageDTO productImage;

    public ProductDTO(Long id, String title, String description, String summary, String sizes, Category category, ProductImage productImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.summary = summary;
        this.sizes = (Map<String, SizeDTO>) JsonToMapConverter.convertToDatabaseColumn(sizes);
        this.category = category.toCategoryDTO();
        this.productImage = productImage.toProductImageDTO();
    }

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setTitle(title)
                .setDescription(description)
                .setSummary(summary)
                .setSizes(JsonToMapConverter.convertToEntityAttribute(sizes))
                .setCategory(category.toCategory())
                .setProductImage(productImage.toProductImage());
    }
}
