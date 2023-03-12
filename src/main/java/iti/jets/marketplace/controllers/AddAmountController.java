package iti.jets.marketplace.controllers;

import org.apache.logging.log4j.core.impl.ReusableLogEventFactory;
import org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iti.jets.marketplace.dtos.AmountDTO;
import iti.jets.marketplace.servcies.AddAmountService;
import iti.jets.marketplace.utils.ResponseViewModel;
import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/add")
 
// @PreAuthorize("hasRole('ROLE_ADMIN')")
public class AddAmountController {
    @Autowired
    AddAmountService addAmountService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseViewModel<AmountDTO> setAdditionalAmount(@RequestBody AmountDTO amountDTO) {
        return addAmountService.addAmount(amountDTO);
    }
}
