package lib;

import java.security.Permission;

public class person extends Permission {

    private String spouseName;
    private String spouseIdNumber;
    private String idNumber;

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = idNumber;
    }
}
