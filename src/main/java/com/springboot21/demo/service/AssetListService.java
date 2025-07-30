package com.springboot21.demo.service;


import com.springboot21.demo.dto.AssetListDto;
import com.springboot21.demo.entity.Asset;
import com.springboot21.demo.entity.AssetStatus;
import com.springboot21.demo.entity.AssetType;
import com.springboot21.demo.repository.AssetRepository;
import com.springboot21.demo.repository.AssetStatusRepository;
import com.springboot21.demo.repository.AssetTypeRepository;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AssetListService {
    private final AssetRepository assetRepository;
    private final AssetTypeRepository assetTypeRepository;
    private final AssetStatusRepository assetStatusRepository;

    public AssetListDto getAssetListData () {
        Iterable<Asset> assets = assetRepository.findAll();
        Iterable<AssetType> assetTypes = assetTypeRepository.findAll();
        Iterable<AssetStatus> assetStatuses = assetStatusRepository.findAll();

        return new AssetListDto(assets,  assetTypes, assetStatuses);
    }

}
