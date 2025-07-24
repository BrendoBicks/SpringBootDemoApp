package com.springboot21.demo.dto;

import com.springboot21.demo.entity.AssetStatus;
import com.springboot21.demo.entity.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetDto {
    private Long id;
    private String code;
    private AssetStatus status;
    private AssetType type;
}