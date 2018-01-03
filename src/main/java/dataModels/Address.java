package dataModels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address implements IModel{

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

}