package com.springboot21.demo.dto;


import com.springboot21.demo.entity.Asset;
import com.springboot21.demo.entity.AssetStatus;
import com.springboot21.demo.entity.AssetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetListDto {
    private Iterable<Asset> assets;
    private Iterable<AssetType> assetTypes;
    private Iterable<AssetStatus> assetStatuses;
}
