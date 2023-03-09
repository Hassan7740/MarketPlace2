package iti.jets.marketplace.servcies;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iti.jets.marketplace.dtos.AmountDTO;
import iti.jets.marketplace.repos.ProductRepo;
import iti.jets.marketplace.utils.ResponseViewModel;

@Service
public class AddAmountService {
    @Autowired
    ProductRepo productRepo;
    AmountDTO amountDTO = new AmountDTO(); 
    
    public ResponseViewModel<AmountDTO> addAmount(AmountDTO amountDTO)
    {
      Optional<Integer> amountOp =  productRepo.findNumberOfproduct(amountDTO.getId());
      if(!amountOp.isPresent())
      {
           return new ResponseViewModel<AmountDTO>("the product not found",401,null);
      }
       productRepo.updateNumberOfProduct((amountDTO.getAmount() + amountOp.get()),amountDTO.getId());
       this.amountDTO.setAmount((amountDTO.getAmount() + amountOp.get()));
       this.amountDTO.setId(amountDTO.getId());
       return new ResponseViewModel<AmountDTO>("amount add secessfully",200,this.amountDTO);
    }
}
