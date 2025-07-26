package com.springboot21.demo.controller;

import com.springboot21.demo.dto.AssetDto;
import com.springboot21.demo.dto.MessageResponse;
import com.springboot21.demo.entity.Asset;
import com.springboot21.demo.repository.AssetRepository;
import com.springboot21.demo.service.AssetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("/assets")
public class AssetController {
    private final AssetRepository assetRepository;
    private AssetService assetService;

    @GetMapping("")
    public Iterable<AssetDto> getAssetList(){
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public AssetDto getAsset(@PathVariable Long id){

        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        return assetService.convertToDto(asset);
    }

    @PostMapping("/create")
    public Asset createAsset(@Valid @RequestBody Asset asset){
        return assetRepository.save(asset);
    }

    @PutMapping("/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset asset){
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        if (asset.getCode() != null) {
            existingAsset.setCode(asset.getCode());
        }

        if (asset.getDescription() != null) {
            existingAsset.setDescription(asset.getDescription());
        }

        if (asset.getStatus() != null) {
            existingAsset.setStatus(asset.getStatus());
        }

        if (asset.getType() != null) {
            existingAsset.setType(asset.getType());
        }

        return assetRepository.save(existingAsset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteAsset(@PathVariable Long id){
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        assetRepository.delete(asset);
        return ResponseEntity.ok(new MessageResponse("Asset Deleted"));
    }

}
