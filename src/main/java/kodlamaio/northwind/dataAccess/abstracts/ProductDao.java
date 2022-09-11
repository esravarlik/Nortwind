package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.concretes.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    //select * from products where product_name = bisey
    Product getByProductName(String productName);
    //select * from product where product_name = bisey and category_id =  bisey
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    //select * from products where category in(1,2,3,4)
    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    //select * from products where product_name = bisey and categoryId = bisey
    //From Product Entity yapisidir, =: parametre
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    //select p.productId, p.productName, c.categoryName from Category c inner join Product p
    //on c.categoryId = p.categoryId (queryde yer almasına gerek yok)
    // Select bazi alanlari, from tüm alanlari
    @Query("Select new kodlamaio.northwind.entities.concretes.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();



}
