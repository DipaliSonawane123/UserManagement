package com.example.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPrivilegeDto {
    int userId;
    private boolean addDashboard;
    private boolean deleteDashboard;
    private boolean modifyDashboard;
    private boolean readDashboard;

    private boolean addSettings;
    private boolean deleteSettings;
    private boolean modifySettings;
    private boolean readSettings;

    private boolean addUsersInformation;
    private boolean deleteUsersInformation;
    private boolean modifyUsersInformation;
    private boolean readUsersInformation;

    private boolean addWebPage1;
    private boolean deleteWebPage1;
    private boolean modifyWebPage1;
    private boolean readWebPage1;

    private boolean addWebPage2;
    private boolean deleteWebPage2;
    private boolean modifyWebPage2;
    private boolean readWebPage2;

    private boolean addWebPage3;
    private boolean deleteWebPage3;
    private boolean modifyWebPage3;
    private boolean readWebPage3;
}
