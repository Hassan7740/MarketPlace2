package iti.jets.marketplace.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
@Value
@AllArgsConstructor
public class ResponseViewModel<T> {
    private String message;
    private Integer statusCode;
    private T data;
}
