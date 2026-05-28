package store.order;

import java.time.LocalDateTime;
import java.util.List;

public record OrdersOut(
        String id,
        LocalDateTime date,
        Double total
) {
}
