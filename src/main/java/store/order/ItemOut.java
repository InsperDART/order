package store.order;

public record ItemOut(
        String id,
        ItemProductOut product,
        Integer quantity,
        Double total
) {
}
