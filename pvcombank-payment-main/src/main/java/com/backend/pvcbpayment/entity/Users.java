package com.backend.pvcbpayment.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(name ="code")
    private String code;
    @Column(name ="name")
    private String name;
    @Column(name ="email")
    private String content;
    @Column(name ="phone")
    private String objectId;
    @Column(name ="avatar")
    private String avatar;
    @Column(name ="address")
    private String address;
    @Column(name ="token")
    private String token;
    @Column(name ="provider")
    private String provider;
    @Column(name ="provider_id")
    private Date providerId;
    @Column(name ="is_agency")
    private int isAgency;
    @Column(name ="date_check_code")
    private Date dateCheckCode;
    @Column(name ="otp")
    private String otp;
    @Column(name ="birthday")
    private String birthday;
    @Column(name ="role_id")
    private int roleId;
    @Column(name ="device_id")
    private String deviceId;

    @Column(name ="password")
    private String password;

    @Column(name ="number_cmtnd")
    private String numberCmtnd;

    @Column(name ="image_cmtnd")
    private String imageCmtnd;

    @Column(name ="image_resident")
    private String imageResident;

    @Column(name ="image_income")
    private String imageIncome;

    @Column(name ="stk")
    private String stk;

    @Column(name ="money")
    private int  money;

    @Column(name = "point")
    private int point;

    @Column(name = "rank_credit_id")
    private String rankCreditId;
    @Column(name = "rankAgencyDown")
    private String rank_agency_down;
    @Column(name = "status")
    private String status;
    @Column(name = "remember_token")
    private String rememberToken;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "province_id")
    private int provinceId;

    // PAPER VERIFY
    @Column(name="user_name_cmt")
    private  String userNameCmt;

    @Column(name="cmt_number")
    private  String cmtNumber;

    @Column(name="address_cmt")
    private  String addressCmt;

    @Column(name="issued_by_cmt")
    private  String issuedByCmt;

    @Column(name="birthday_cmt")
    private  String birthdayCmt;

    @Column(name="date_range_cmt")
    private  String dateRangeCmt;

    @Column(name="image_cmt_front")
    private  String imageCmtFront;

    @Column(name="image_cmt_back")
    private  String imageCmtBack;

    @Column(name="image_portrait")
    private  String imagePortrait;
    @Column(name="district_id")
    private String districtId;
    @Column(name="ward_id")
    private String wardId;
    @Column(name="brand_code")
    private String brandCode;
    @Column(name="customer_code")
    private String customerCode;
    @Column(name="gender")
    private Integer gender;
    @Column(name="information_pdf")
    private String informationPdf;

    @Column(name = "error")
    private String error;


    public String getImagePaperBackId() {
        return imagePaperBackId;
    }

    @Column(name = "image_paper_back_id")
    private String imagePaperBackId;

    @Column(name = "image_paper_front_id")
    private String imagePaperFrontId;

    public void setImagePaperBackId(String imagePaperBackId) {
        this.imagePaperBackId = imagePaperBackId;
    }

    public String getImagePaperFrontId() {
        return imagePaperFrontId;
    }

    public void setImagePaperFrontId(String imagePaperFrontId) {
        this.imagePaperFrontId = imagePaperFrontId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getProviderId() {
        return providerId;
    }

    public void setProviderId(Date providerId) {
        this.providerId = providerId;
    }

    public int getIsAgency() {
        return isAgency;
    }

    public void setIsAgency(int isAgency) {
        this.isAgency = isAgency;
    }

    public Date getDateCheckCode() {
        return dateCheckCode;
    }

    public void setDateCheckCode(Date dateCheckCode) {
        this.dateCheckCode = dateCheckCode;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumberCmtnd() {
        return numberCmtnd;
    }

    public void setNumberCmtnd(String numberCmtnd) {
        this.numberCmtnd = numberCmtnd;
    }

    public String getImageCmtnd() {
        return imageCmtnd;
    }

    public void setImageCmtnd(String imageCmtnd) {
        this.imageCmtnd = imageCmtnd;
    }

    public String getImageResident() {
        return imageResident;
    }

    public void setImageResident(String imageResident) {
        this.imageResident = imageResident;
    }

    public String getImageIncome() {
        return imageIncome;
    }

    public void setImageIncome(String imageIncome) {
        this.imageIncome = imageIncome;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getRankCreditId() {
        return rankCreditId;
    }

    public void setRankCreditId(String rankCreditId) {
        this.rankCreditId = rankCreditId;
    }

    public String getRank_agency_down() {
        return rank_agency_down;
    }

    public void setRank_agency_down(String rank_agency_down) {
        this.rank_agency_down = rank_agency_down;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getUserNameCmt() {
        return userNameCmt;
    }

    public void setUserNameCmt(String userNameCmt) {
        this.userNameCmt = userNameCmt;
    }

    public String getCmtNumber() {
        return cmtNumber;
    }

    public void setCmtNumber(String cmtNumber) {
        this.cmtNumber = cmtNumber;
    }

    public String getAddressCmt() {
        return addressCmt;
    }

    public void setAddressCmt(String addressCmt) {
        this.addressCmt = addressCmt;
    }

    public String getIssuedByCmt() {
        return issuedByCmt;
    }

    public void setIssuedByCmt(String issuedByCmt) {
        this.issuedByCmt = issuedByCmt;
    }

    public String getBirthdayCmt() {
        return birthdayCmt;
    }

    public void setBirthdayCmt(String birthdayCmt) {
        this.birthdayCmt = birthdayCmt;
    }

    public String getDateRangeCmt() {
        return dateRangeCmt;
    }

    public void setDateRangeCmt(String dateRangeCmt) {
        this.dateRangeCmt = dateRangeCmt;
    }

    public String getImageCmtFront() {
        return imageCmtFront;
    }

    public void setImageCmtFront(String imageCmtFront) {
        this.imageCmtFront = imageCmtFront;
    }

    public String getImageCmtBack() {
        return imageCmtBack;
    }

    public void setImageCmtBack(String imageCmtBack) {
        this.imageCmtBack = imageCmtBack;
    }

    public String getImagePortrait() {
        return imagePortrait;
    }

    public void setImagePortrait(String imagePortrait) {
        this.imagePortrait = imagePortrait;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getInformationPdf() {
        return informationPdf;
    }

    public void setInformationPdf(String informationPdf) {
        this.informationPdf = informationPdf;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
