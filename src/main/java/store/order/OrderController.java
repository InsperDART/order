package store.order;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "orders", url = "http://orders:8080")
public interface OrderController {
    @GetMapping("/orders")
    ResponseEntity<List<OrderOut>> findAll(
        @RequestHeader(value = "id-account") String idAccount
    );

    @GetMapping("/orders/{idOrder}")
    ResponseEntity<OrderOut> findById(
        @PathVariable @NotEmpty @NotNull String idOrder,
        @RequestParam @Nullable String currency,
        @RequestHeader(value = "id-account") String idAccount
    );
    @PostMapping("/orders")
    ResponseEntity<OrderOut> create(
        @RequestBody @Valid @NotNull OrderIn in,
        @RequestHeader(value = "id-account") String idAccount
    );

    @PostMapping("/orders/health-check")
    ResponseEntity<Void> healthCheck();
}
