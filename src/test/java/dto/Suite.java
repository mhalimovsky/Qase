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

    @SerializedName("Preconditions")
    @Expose
    String Preconditions;

    @SerializedName("id")
    @Expose
    int id;
}
