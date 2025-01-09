package com.jai.darkmumin.sga.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jai.darkmumin.sga.models.Asset;
import com.jai.darkmumin.sga.repository.AssetRepository;

@Service
public class AssetService {
    private final AssetRepository assetRepository;
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }
    // Is the method service CRUD for Asset
    public Page<Asset> getAssets(Pageable pageable) {
        return assetRepository.findAll(pageable);
    }
    public Asset obtainAssetById(Long id) {
        return assetRepository.findById(id).get();
    }
    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }
    public void deleteAsset(Long id) {
        assetRepository.deleteById(id);
    }
    public Asset updateAsset(Asset asset) {
        return assetRepository.save(asset);
    }

}
