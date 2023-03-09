package iti.jets.marketplace.servcies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.BuyProductDTO;
import iti.jets.marketplace.repos.ProductRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class BuyProductService {
    @Autowired
    ProductRepo productRepo;

    int productAmount;

    public BuyProductService() {
    }

    public ResponseViewModel<Integer> getProdcutNumber(BuyProductDTO buyProductDTO) {
        Optional<Integer> prodctAmountOpt = productRepo.findNumberOfproduct(buyProductDTO.getId());
        if (!prodctAmountOpt.isPresent()) {
            return new ResponseViewModel<Integer>("product not found", 400, null);
        } else if (prodctAmountOpt.get() >= buyProductDTO.getAmount()) {
            productRepo.updateNumberOfProduct((prodctAmountOpt.get() - buyProductDTO.getAmount()),
                    buyProductDTO.getId());
            return new ResponseViewModel("the remain amount", 200, (prodctAmountOpt.get() - buyProductDTO.getAmount()));
        } else {
            return new ResponseViewModel<Integer>("amount not available", 200, -1);
        }

    }
}
