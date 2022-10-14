package com.example.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserPrivilege DTO class for add permission for user
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPrivilegeDto {
    int userId;
    private boolean addDashboard=false;
    private boolean deleteDashboard=false;
    private boolean modifyDashboard=false;
    private boolean readDashboard=false;

    private boolean addSettings=false;
    private boolean deleteSettings=false;
    private boolean modifySettings=false;
    private boolean readSettings=false;

    private boolean addUsersInformation=false;
    private boolean deleteUsersInformation=false;
    private boolean modifyUsersInformation=false;
    private boolean readUsersInformation=false;

    private boolean addWebPage1=false;
    private boolean deleteWebPage1=false;
    private boolean modifyWebPage1=false;
    private boolean readWebPage1=false;

    private boolean addWebPage2=false;
    private boolean deleteWebPage2=false;
    private boolean modifyWebPage2=false;
    private boolean readWebPage2=false;

    private boolean addWebPage3=false;
    private boolean deleteWebPage3=false;
    private boolean modifyWebPage3=false;
    private boolean readWebPage3=false;
}
