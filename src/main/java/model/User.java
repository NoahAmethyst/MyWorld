package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int userId;
//    private int deptId;
    private String loginName;
    private String  userName;
    private String roleName;
    private String deptName;
    private String postName;



}
