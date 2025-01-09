package com.jai.darkmumin.sga.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.darkmumin.sga.models.Asset;
import com.jai.darkmumin.sga.services.AssetService;

@RestController
@RequestMapping("/api/v1/asset")
public class AssetController {
    private final AssetService assetService;
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }
    // Is the method CRUD for Asset
    @GetMapping
    ResponseEntity <Page<Asset>> getAssets(Pageable pageable) {
        return new ResponseEntity<>(assetService.getAssets(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity <Asset> obtainAssetById(@PathVariable Long id) {
        return new ResponseEntity<>(assetService.obtainAssetById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <Asset> saveAsset(@RequestBody Asset asset) {
        assetService.saveAsset(asset);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity <Asset> deleteAsset(@PathVariable Long id) {
        assetService.deleteAsset(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    ResponseEntity <Asset> updateAsset(@RequestBody Asset asset) {
        assetService.updateAsset(asset);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
