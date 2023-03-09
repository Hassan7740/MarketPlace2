package iti.jets.marketplace.servcies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.AmountDTO;
import iti.jets.marketplace.repos.ProductRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class BuyProductService {
    @Autowired
    ProductRepo productRepo;

    int productAmount;
    AmountDTO buyPrAmountDTO;

    public BuyProductService() {
    }

    public ResponseViewModel<AmountDTO> getProdcutNumber(AmountDTO buyProductDTO) {
        Optional<Integer> prodctAmountOpt = productRepo.findNumberOfproduct(buyProductDTO.getId());
        if (!prodctAmountOpt.isPresent()) {
            return new ResponseViewModel<AmountDTO>("product not found", 400, null);
        } else if (prodctAmountOpt.get() >= buyProductDTO.getAmount()) {
            productRepo.updateNumberOfProduct((prodctAmountOpt.get() - buyProductDTO.getAmount()),
                    buyProductDTO.getId());
                    this.buyPrAmountDTO.setAmount( (prodctAmountOpt.get() - buyProductDTO.getAmount()));
            return new ResponseViewModel<AmountDTO>("the remain amount", 200,this.buyPrAmountDTO);
        } else {
            return new ResponseViewModel<AmountDTO>("amount not available", 200, null);
        }

    }
}
