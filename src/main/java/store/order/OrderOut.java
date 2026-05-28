package store.order;

import java.time.LocalDateTime;
import java.util.List;

public record OrderOut(
        String id,
        LocalDateTime date,
        List<ItemOut> items,
        Double total
) {
}
