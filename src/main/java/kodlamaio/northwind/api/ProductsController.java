package kodlamaio.northwind.api;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService){
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product>
    getByProductNameAndCategory_Category(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategory")
    public DataResult<List<Product>>
    getByProductNameOrCategory_CategoryId(@RequestParam String productName, @RequestParam int categoryId){
        return this.productService.getByProductNameOrCategory_CategoryId(productName, categoryId);

    }

    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>>
    getByCategoryIn(@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>>
    getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>>
    getByProductNameStartsWith(@RequestParam String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>>
    getByNameAndCategory(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNumber, int pageSize){
        return this.productService.getAll(pageNumber, pageSize);
    }

    @GetMapping("/getAllAsc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }





}
