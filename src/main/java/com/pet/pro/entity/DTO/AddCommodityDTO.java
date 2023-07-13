package com.pet.pro.entity.DTO;

import com.pet.pro.entity.CommodityEntity;
import lombok.Data;

@Data
public class AddCommodityDTO {
    private CommodityEntity commodity;
    private Integer warehouseId;
    private Integer quantity;
}
