package factories;

import entities.provinces.Province;

public class ProvinceFactory {
    private ProvinceFactory() {}

    public static Province createProvince(String provinceName) {
        return new Province(provinceName);
    }
}
