import com.beust.jcommander.internal.Nullable;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class Info {
    @Nullable
    String uuid;
    @Nullable
    String email;
    @Nullable
    String phone;


}

