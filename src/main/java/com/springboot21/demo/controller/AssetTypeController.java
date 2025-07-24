package com.springboot21.demo.controller;

import com.springboot21.demo.dto.MessageResponse;
import com.springboot21.demo.entity.AssetType;
import com.springboot21.demo.repository.AssetTypeRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
@RequestMapping("/asset-type")
public class AssetTypeController {
    private final AssetTypeRepository assetTypeRepository;

    @GetMapping("")
    public Iterable<AssetType> getAssetTypeList(){
        return assetTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public AssetType getAssetType(@PathVariable Long id){
        return assetTypeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));
    }

    @PostMapping("/create")
    public AssetType createAssetType(@Valid @RequestBody AssetType assetType){
        return assetTypeRepository.save(assetType);
    }

    @PutMapping("/{id}")
    public AssetType updateAssetType(@PathVariable Long id, @RequestBody AssetType assetType){
        AssetType existingAssetType = assetTypeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        if (assetType.getName() != null) {
            existingAssetType.setName(assetType.getName());
        }

        if (assetType.getDescription() != null) {
            existingAssetType.setDescription(assetType.getDescription());
        }

        return assetTypeRepository.save(existingAssetType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteAssetType(@PathVariable Long id){
        AssetType assetType = assetTypeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        assetTypeRepository.delete(assetType);
        return ResponseEntity.ok(new MessageResponse("Asset Deleted"));
    }
}
