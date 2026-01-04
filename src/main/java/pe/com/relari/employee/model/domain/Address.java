package pe.com.relari.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.com.relari.employee.model.api.AddressRequest;

/**
 * Class: Address.
 * @author RLR
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Address {

  private String email;
  private String phoneNumber;

  public Address(AddressRequest addressRequest) {
    this.email = addressRequest.getEmail();
    this.phoneNumber = addressRequest.getPhoneNumber();
  }

}
