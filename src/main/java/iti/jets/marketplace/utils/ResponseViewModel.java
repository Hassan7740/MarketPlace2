package iti.jets.marketplace.utils;
import iti.jets.marketplace.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
