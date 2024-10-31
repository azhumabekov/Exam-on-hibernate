package java15.dao;

import java15.entity.Region;

import java.util.List;

public interface RegionDao {
    String save(Region region);
    List<Region> getAllRegions();
    String updateRegion(Long id, Region newRegion);
}
