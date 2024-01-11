package com.hieucodeg.domain.dto.category;

import com.hieucodeg.domain.entity.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {
    private Long id;

    @NotEmpty(message = "Vui lòng nhập tên loại sản phẩm!")
    @Size(min = 3, max = 30, message = "Loại sản phẩm có độ dài nằm trong khoảng 3 - 30 ký tự.")
    private String title;

    public Category toCategory() {
        return new Category()
                .setId(id)
                .setTitle(title);
    }
}
