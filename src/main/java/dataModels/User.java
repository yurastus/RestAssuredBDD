package dataModels;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {

    private int id;

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private Address address;
    private Company company;

}