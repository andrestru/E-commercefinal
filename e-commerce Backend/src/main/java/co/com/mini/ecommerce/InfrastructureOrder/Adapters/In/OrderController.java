package co.com.mini.ecommerce.InfrastructureOrder.Adapters.In;


import co.com.mini.ecommerce.ApplicationOrder.Model.*;
import co.com.mini.ecommerce.ApplicationOrder.Ports.In.*;
import co.com.mini.ecommerce.ApplicationOrder.Ports.Out.OrderRepository;
import co.com.mini.ecommerce.Common.NonEmptyString;
import co.com.mini.ecommerce.Infrastructure.Commons.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderRepository repository;
    private final ListOrderUseCase listOrderUseCase;
    private final ListNumOrderUseCase listNumOrderUseCase;
    private final EditOrderUseCase editOrderUseCase;
    private final ListCCOrderUseCase listCCOrderUseCase;

    public OrderController(UseCaseHttpExecutor useCaseHttpExecutor, CreateOrderUseCase createOrderUseCase, OrderRepository repository, ListOrderUseCase listOrderUseCase, ListNumOrderUseCase listNumOrderUseCase, EditOrderUseCase editOrderUseCase, ListCCOrderUseCase listCCOrderUseCase) {
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.createOrderUseCase = createOrderUseCase;
        this.repository = repository;
        this.listOrderUseCase = listOrderUseCase;
        this.listNumOrderUseCase = listNumOrderUseCase;
        this.editOrderUseCase = editOrderUseCase;
        this.listCCOrderUseCase = listCCOrderUseCase;
    }

    @PostMapping
    public ResponseEntity CreateOrder(
            @RequestBody CreateOrderRequest request
    ){
        return useCaseHttpExecutor.execute(
                createOrderUseCase,
                request
        );
    }

    @GetMapping
    public ResponseEntity ListOrder(){
        return useCaseHttpExecutor.execute(
                listOrderUseCase,
                new ListOrderRequest()
        );
    }

    @DeleteMapping(path = {"/delete/{num_order}"})
    public void DeleteOrder(@PathVariable("num_order") NonEmptyString num_order){
        this.repository.DeleteOrder(num_order);
    }

    @PostMapping(path = {"/listorder"})
    public ResponseEntity responseEntity(
            @RequestBody ListNumOrderRequest request

    ){
        return useCaseHttpExecutor.execute(
                listNumOrderUseCase,
                request
        );
    }

    @PutMapping(path = {"/editorder"})
    public ResponseEntity editorder(
            @RequestBody EditOrderRequest request
            ){
        return useCaseHttpExecutor.execute(
                editOrderUseCase,
                request
        );
    }

    @PutMapping(path = {"/status/{num_order}"})
    public void editstatus(@PathVariable("num_order") NonEmptyString num_order){
        this.repository.EditStatus(num_order);
    }

    @PostMapping(path = {"/listid/"})
    public ResponseEntity listid(
            @RequestBody ListCCOrderRequest request
            ){
        return useCaseHttpExecutor.execute(
                listCCOrderUseCase,
                request
        );
    }

}
