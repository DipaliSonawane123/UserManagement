package com.example.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class for creating login history table
 */
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int loginHistoryId;
    int userId;
    String emailId;
    LocalDateTime loginDataTime;

}
