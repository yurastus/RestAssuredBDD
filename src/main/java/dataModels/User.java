package dataModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements IModel{

    private int id;

    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private Address address;
    private Company company;

}