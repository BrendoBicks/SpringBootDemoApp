package com.springboot21.demo.service;


import com.springboot21.demo.dto.AssetDto;
import com.springboot21.demo.entity.Asset;
import com.springboot21.demo.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetDto> getAllAssets() {
        List<Asset> assets = assetRepository.findAll();
        return assets.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AssetDto convertToDto(Asset asset) {
        return new AssetDto(
                asset.getId(),
                asset.getCode(),
                asset.getStatus(),
                asset.getType()
        );
    }
}