package com.resul.ecommerce.dto;

import com.resul.ecommerce.shared.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindStoresDTO extends PageRequest {
    private String namePhrase;
}
