package com.hieucodeg.domain.dto.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@Setter
public class SizeDTO implements Validator, Serializable {

    @NotEmpty(message = "Vui lòng nhập tên size.")
    @Size(min = 1, max = 5, message = "Tên size có độ dài nằm trong khoảng 1-5 ký tự.")
    private String name;

    @Pattern(regexp = "^\\d+$", message = "Giá sản phẩm phải là số.")
    @NotEmpty(message = "Giá sản phẩm không được để trống.")
    private String price;


    @Override
    public boolean supports(Class<?> clazz) {
        return SizeDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SizeDTO sizeDTO = (SizeDTO) target;
        String price = sizeDTO.getPrice();
        if (price != null && price.length() > 0) {
            if (price.length() > 9) {
                errors.rejectValue("price", "price.max", "Giá sản phẩm tối đa là 999.999.999 VNĐ");
                return;
            }

            if (price.length() < 6) {
                errors.rejectValue("price", "price.min", "Giá sản phẩm thấp nhất là 100.000 VNĐ");
                return;
            }

            if (!price.matches("(^$|[0-9]*$)")) {
                errors.rejectValue("price", "price.number", "Giá sản phẩm phải là số.");
            }

        } else {
            errors.rejectValue("price", "price.null", "Vui lòng nhập giá sản phẩm.");
        }
    }
}
