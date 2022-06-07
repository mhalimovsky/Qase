package dto;

import com.github.javafaker.Faker;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Project {
    @SerializedName("title")
    @Expose
    String name;

    @SerializedName("code")
    @Expose
    String code;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("counts")
    @Expose(serialize = false)
    Counts counts;

}
