package br.com.cccat6;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaceOrderItemInput {
    private Long idItem;
    private double quantity;
}
