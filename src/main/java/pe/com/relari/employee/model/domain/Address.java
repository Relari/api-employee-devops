package pe.com.relari.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
