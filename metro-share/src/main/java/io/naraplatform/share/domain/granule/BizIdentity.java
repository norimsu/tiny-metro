package io.naraplatform.share.domain.granule;


import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class BizIdentity implements JsonSerializable {
    //
    private String bizType;             // 업종
    private String bizCategory;         // 업태
    private String bizRegCertificate;   // 사업자 등록번호
    private String companyRegNumber;    // 법인 등록번호

    public BizIdentity(){
        //
    }

    public BizIdentity(String bizType, String bizCategory, String bizRegCertificate, String companyRegNumber) {
        //
        this.bizType = bizType;
        this.bizCategory = bizCategory;
        this.bizRegCertificate = bizRegCertificate;
        this.companyRegNumber = companyRegNumber;
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static BizIdentity getSample() {
        //
        String bizType = "서비스";
        String bizCategory = "온라인 Java교육";
        String bizRegCertificate = "123-45-67891";
        String companyRegNumber = "110111-006243";

        BizIdentity sample = new BizIdentity(bizType, bizCategory, bizRegCertificate, companyRegNumber);

        return sample;
    }

    public static BizIdentity fromJson(String json) {
        //
        return JsonUtil.fromJson(json, BizIdentity.class);
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(String bizCategory) {
        this.bizCategory = bizCategory;
    }

    public String getBizRegCertificate() {
        return bizRegCertificate;
    }

    public void setBizRegCertificate(String bizRegCertificate) {
        this.bizRegCertificate = bizRegCertificate;
    }

    public String getCompanyRegNumber() {
        return companyRegNumber;
    }

    public void setCompanyRegNumber(String companyRegNumber) {
        this.companyRegNumber = companyRegNumber;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
