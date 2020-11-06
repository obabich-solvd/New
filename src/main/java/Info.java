import com.beust.jcommander.internal.Nullable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;


    @Getter
    @Setter
    @NoArgsConstructor(force = true)
    //@Builder(builderClassName = "InfoBuilder")
   // @JsonDeserialize(builder = Info.InfoBuilder.class)
    @AllArgsConstructor(access = AccessLevel.PACKAGE)

class Info {
        @Nullable String uuid ;
        @Nullable String email;
        @Nullable String phone;

       // @JsonPOJOBuilder(withPrefix = "")
       // public static class InfoBuilder {

       // }
    }

