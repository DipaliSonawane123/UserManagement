package com.example.usermanagement.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity class for creating userPrivilege table
 */
@Entity
@NoArgsConstructor
@Data
public class UserPrivilege {
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean addDashboard = false;
    private boolean deleteDashboard = false;
    private boolean modifyDashboard = false;
    private boolean readDashboard = false;

    private boolean addSettings = false;
    private boolean deleteSettings = false;
    private boolean modifySettings = false;
    private boolean readSettings = false;

    private boolean addUsersInformation = false;
    private boolean deleteUsersInformation = false;
    private boolean modifyUsersInformation = false;
    private boolean readUsersInformation = false;

    private boolean addWebPage1 = false;
    private boolean deleteWebPage1 = false;
    private boolean modifyWebPage1 = false;
    private boolean readWebPage1 = false;

    private boolean addWebPage2 = false;
    private boolean deleteWebPage2 = false;
    private boolean modifyWebPage2 = false;
    private boolean readWebPage2 = false;

    private boolean addWebPage3 = false;
    private boolean deleteWebPage3 = false;
    private boolean modifyWebPage3 = false;
    private boolean readWebPage3 = false;

    public UserPrivilege(User user, boolean addDashboard, boolean deleteDashboard, boolean modifyDashboard, boolean readDashboard,
                         boolean addSettings, boolean deleteSettings, boolean modifySettings, boolean readSettings,
                         boolean addUsersInformation, boolean deleteUsersInformation, boolean modifyUsersInformation, boolean readUsersInformation,
                         boolean addWebPage1, boolean deleteWebPage1, boolean modifyWebPage1, boolean readWebPage1,
                         boolean addWebPage2, boolean deleteWebPage2, boolean modifyWebPage2, boolean readWebPage2,
                         boolean addWebPage3, boolean deleteWebPage3, boolean modifyWebPage3, boolean readWebPage3) {
        this.user = user;
        this.addDashboard = addDashboard;
        this.deleteDashboard = deleteDashboard;
        this.modifyDashboard = modifyDashboard;
        this.readDashboard = readDashboard;

        this.addSettings = addSettings;
        this.deleteSettings = deleteSettings;
        this.modifySettings = modifySettings;
        this.readSettings = readSettings;

        this.addUsersInformation = addUsersInformation;
        this.deleteUsersInformation = deleteUsersInformation;
        this.modifyUsersInformation = modifyUsersInformation;
        this.readUsersInformation = readUsersInformation;

        this.addWebPage1 = addWebPage1;
        this.deleteWebPage1 = deleteWebPage1;
        this.modifyWebPage1 = modifyWebPage1;
        this.readWebPage1 = readWebPage1;

        this.addWebPage2 = addWebPage2;
        this.deleteWebPage2 = deleteWebPage2;
        this.modifyWebPage2 = modifyWebPage2;
        this.readWebPage2 = readWebPage2;

        this.addWebPage3 = addWebPage3;
        this.deleteWebPage3 = deleteWebPage3;
        this.modifyWebPage3 = modifyWebPage3;
        this.readWebPage3 = readWebPage3;
    }
}