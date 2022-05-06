package br.com.cccat6;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PlaceOrderInput {
    private String cpf;
    private List<PlaceOrderItemInput> orderItems;
    private String coupon;
}
