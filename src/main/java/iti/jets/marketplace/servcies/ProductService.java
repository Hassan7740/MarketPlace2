package iti.jets.marketplace.servcies;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import iti.jets.marketplace.dtos.ProductDTO;
import iti.jets.marketplace.mappers.ProductMapper;
import iti.jets.marketplace.models.Product;
import iti.jets.marketplace.repos.ProductRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class ProductService {
    
    @Autowired
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    public ResponseViewModel<Product> add(ProductDTO productDTO)
    {
        Product p = productMapper.productDtoToProduct(productDTO);
        productRepo.saveAndFlush(p);
        return ResponseViewModel.<Product>builder().data(p).message("Product added successfully").statusCode(HttpStatus.OK.value()).build();
    }

    public ResponseViewModel<ProductDTO> searchByName(String productName)
    {
        Product p = productRepo.findProductByproductName(productName);
        ProductDTO productDTO = productMapper.producToProductDto(p);
        return ResponseViewModel.<ProductDTO>builder().data(productDTO).message("done").statusCode(HttpStatus.OK.value()).build();

    }

    public ResponseViewModel<Object> deleteProductById(@PathVariable Integer id){
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			productRepo.deleteById(id);
            return ResponseViewModel.<Object>builder().data(null).message("Product Deleted Successfully").statusCode(HttpStatus.OK.value()).build();
		}
		else{
            return ResponseViewModel.<Object>builder().data(null).message("No such product").statusCode(HttpStatus.NOT_FOUND.value()).build();
        }
    }

    public ResponseViewModel<Object> updateProduct(ProductDTO productDTO){
        Optional<Product> productCheck = productRepo.findById(productDTO.getProductId());
        Optional<Product> ProductCategoryCheck = productRepo.findById(productDTO.getCategory().getCategoryId()); 
        if(productCheck.isPresent() && ProductCategoryCheck.isPresent()){
            Product product = productMapper.productDtoToProduct(productDTO);
            productRepo.save(product);
            return ResponseViewModel.<Object>builder().data(null).message("product updated successfully").statusCode(HttpStatus.OK.value()).build();
        }
        else{
            return ResponseViewModel.<Object>builder().data(null).message("Couldn't update product").statusCode(HttpStatus.NOT_FOUND.value()).build();
        }
    }

}
