package goingto.com.model.interaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import goingto.com.model.account.User;
import goingto.com.model.account.UserProfile;
import goingto.com.model.geographic.Locatable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tips")
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "text",length = 100)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "locatable_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Locatable locatable;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_profile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserProfile userProfile;
}
