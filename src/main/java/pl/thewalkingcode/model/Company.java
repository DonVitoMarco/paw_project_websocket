package pl.thewalkingcode.model;

public class Company {

    private String fullName;
    private String code;
    private double price;
    private boolean changeToUp;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isChangeToUp() {
        return changeToUp;
    }

    public void setChangeToUp(boolean changeToUp) {
        this.changeToUp = changeToUp;
    }

    /* BUILDER */
    public static class CompanyBuilder {

        private String fullName;
        private String code;
        private double price;
        private boolean changeToUp;

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

        public CompanyBuilder price(double price) {
            this.price = price;
            return this;
        }

        public CompanyBuilder changeToUp(boolean changeToUp) {
            this.changeToUp = changeToUp;
            return this;
        }

        public Company build() {
            return new Company(this);
        }

    }

}