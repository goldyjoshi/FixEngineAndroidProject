package com.example.fixengine.services;

import com.example.fixengine.model.SingleOrderRequest;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class OrderServiceTest {


    @InjectMocks
    private OrderService orderService;

    @Mock
    private RetrofitRestClient retrofitRestClient;

    @Mock
    private IOrderSubmissionServiceAPI iOrderSubmissionServiceAPI;

    @Test
    public void setOrdersTest() {
//        orderService.submitOrder( new SingleOrderRequest(), , "Trader" );
    }
}
