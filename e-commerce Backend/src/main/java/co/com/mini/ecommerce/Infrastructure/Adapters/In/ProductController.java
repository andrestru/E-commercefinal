package co.com.mini.ecommerce.Infrastructure.Adapters.In;


import co.com.mini.ecommerce.Application.Model.CreateProductRequest;
import co.com.mini.ecommerce.Application.Model.EditProductRequest;
import co.com.mini.ecommerce.Application.Model.IdProductRequest;
import co.com.mini.ecommerce.Application.Model.ListProductRequest;
import co.com.mini.ecommerce.Application.Ports.In.CreateProductUseCase;
import co.com.mini.ecommerce.Application.Ports.In.EditProductUseCase;
import co.com.mini.ecommerce.Application.Ports.In.IdProductUseCase;
import co.com.mini.ecommerce.Application.Ports.In.ListProductUseCase;
import co.com.mini.ecommerce.Application.Ports.Out.ProductRepository;
import co.com.mini.ecommerce.Infrastructure.Commons.UseCaseHttpExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final UseCaseHttpExecutor useCaseHttpExecutor;
    private final ListProductUseCase listProductUseCase;
    private final ProductRepository productRepository;
    private final IdProductUseCase idProductUseCase;
    private final EditProductUseCase editProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, UseCaseHttpExecutor useCaseHttpExecutor, ListProductUseCase listProductUseCase, ProductRepository productRepository, IdProductUseCase idProductUseCase, EditProductUseCase editProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.useCaseHttpExecutor = useCaseHttpExecutor;
        this.listProductUseCase = listProductUseCase;
        this.productRepository = productRepository;
        this.idProductUseCase = idProductUseCase;
        this.editProductUseCase = editProductUseCase;
    }


    @GetMapping
    public  ResponseEntity ListProduct(){
        return useCaseHttpExecutor.execute(
                listProductUseCase,
                new ListProductRequest()
        );
    }

    @PostMapping
    public ResponseEntity CreateProduct(
            @RequestBody CreateProductRequest request
            ){
        return useCaseHttpExecutor.execute(
                createProductUseCase,
                request
        );
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public void delete(
            @PathVariable("id") int id
    ){
        this.productRepository.delete(id);
    }

    @PutMapping(path = {"/editinv/{id}"})
    public void editinventory(
            @PathVariable("id") int id
    ){
        this.productRepository.EditInventory(id);
    }

    @PostMapping(path = {"/listid"})
    public ResponseEntity responseEntity(
            @RequestBody IdProductRequest request
    ){
        return useCaseHttpExecutor.execute(
                idProductUseCase,
                request
        );
    }

    @PutMapping(path = {"/edit"})
    public ResponseEntity responseEntity(
            @RequestBody EditProductRequest request
    ){
        return useCaseHttpExecutor.execute(
                editProductUseCase,
                request
        );
    }
}
