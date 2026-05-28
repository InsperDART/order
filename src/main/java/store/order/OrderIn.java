package store.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderIn(
        @NotEmpty
        @NotNull
        List<ItemIn> items
){
}
