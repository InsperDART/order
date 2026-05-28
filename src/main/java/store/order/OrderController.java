package store.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "orders", url = "http://orders:8080")
public interface OrderController {
    @GetMapping("/orders")
    ResponseEntity<List<OrderOut>> findAll();

    @GetMapping("/orders/{idOrder}")
    ResponseEntity<OrderOut> findById(
            @PathVariable @NotEmpty @NotNull String idOrder
    );

    @PostMapping("/orders")
    ResponseEntity<OrderOut> create(
            @RequestBody @Valid OrderIn in
    );
}
