package iti.jets.marketplace.utils;
import java.util.List;

import iti.jets.marketplace.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@Value
@Builder
@AllArgsConstructor
public class ResponseViewModel<T> {
    private String message;
    private Integer statusCode;
    private T data;
}
