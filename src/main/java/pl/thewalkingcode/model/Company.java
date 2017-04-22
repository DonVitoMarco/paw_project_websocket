package pl.thewalkingcode.model;

import java.math.BigDecimal;

public class Company {

    private String fullName;
    private String code;
    private BigDecimal price;
    private int changeToUp;

    public Company(CompanyBuilder companyBuilder) {
        this.fullName = companyBuilder.fullName;
        this.code = companyBuilder.code;
        this.price = companyBuilder.price;
        this.changeToUp = companyBuilder.changeToUp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getChangeToUp() {
        return changeToUp;
    }

    public void setChangeToUp(int changeToUp) {
        this.changeToUp = changeToUp;
    }

    /* BUILDER */
    public static class CompanyBuilder {

        private String fullName;
        private String code;
        private BigDecimal price;
        private int changeToUp;

        public CompanyBuilder() {
        }

        public CompanyBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public CompanyBuilder code(String code) {
            this.code = code;
            return this;
        }

        public CompanyBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public CompanyBuilder changeToUp(int changeToUp) {
            this.changeToUp = changeToUp;
            return this;
        }

        public Company build() {
            return new Company(this);
        }

    }

}