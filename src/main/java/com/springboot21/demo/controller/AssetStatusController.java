package com.springboot21.demo.controller;


import com.springboot21.demo.dto.MessageResponse;
import com.springboot21.demo.entity.AssetStatus;
import com.springboot21.demo.repository.AssetStatusRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@AllArgsConstructor
@RequestMapping("/asset-status")
public class AssetStatusController {
    private final AssetStatusRepository assetStatusRepository;

    @GetMapping("")
    public Iterable<AssetStatus> getAssetStatusList(){
        return assetStatusRepository.findAll();
    }

    @GetMapping("/{id}")
    public AssetStatus getAssetStatus(@PathVariable Long id){
        return assetStatusRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));
    }

    @PostMapping("/create")
    public AssetStatus createAssetStatus(@Valid @RequestBody AssetStatus assetStatus){
        return assetStatusRepository.save(assetStatus);
    }

    @PutMapping("/{id}")
    public AssetStatus updateAssetStatus(@PathVariable Long id, @RequestBody AssetStatus assetStatus){
        AssetStatus existingAssetStatus = assetStatusRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        if (assetStatus.getCode() != null) {
            existingAssetStatus.setCode(assetStatus.getCode());
        }

        if (assetStatus.getDescription() != null) {
            existingAssetStatus.setDescription(assetStatus.getDescription());
        }

        return assetStatusRepository.save(existingAssetStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteAssetStatus(@PathVariable Long id){
        AssetStatus assetStatus = assetStatusRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Asset not found"));

        assetStatusRepository.delete(assetStatus);
        return ResponseEntity.ok(new MessageResponse("Asset Deleted"));
    }

}

