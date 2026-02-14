package com.cdv.CPS.shipping.controller;

import com.cdv.CPS.shipping.dto.QuoteRequest;
import com.cdv.CPS.shipping.dto.QuoteResponse;
import com.cdv.CPS.shipping.service.QuoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuoteController {
    private final QuoteService quoteService;
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }
    @PostMapping("/quote")
    public QuoteResponse quote(@RequestBody QuoteRequest request){
        return quoteService.calculateQuote(request);
    }
}
