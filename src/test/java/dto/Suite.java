package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data

public class Suite {
    @SerializedName("title")
    @Expose
    String name;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("preconditions")
    @Expose
    String preconditions;

    @SerializedName("id")
    @Expose
    int id;
}
