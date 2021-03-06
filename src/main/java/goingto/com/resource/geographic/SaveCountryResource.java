package goingto.com.resource.geographic;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveCountryResource {
    @NotNull
    @NotBlank
    @Size(max = 3)
    @Column(unique = true)
    private String shortName;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String fullName;


}
