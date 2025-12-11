package com.metro.service;

import com.metro.enums.TicketStatus;
import com.metro.enums.TicketType;
import com.metro.interfaces.FarePolicy;
import com.metro.model.operation.Ticket;
import com.metro.model.people.Customer;

public class TicketService {
    private static TicketService instance;
    private FarePolicy farePolicy;
    private RouteService routeService;

    private TicketService() {
        
        this.farePolicy = new StandardFarePolicy();
        this.routeService = RouteService.getInstance();
    }

    public static TicketService getInstance() {
        if (instance == null) instance = new TicketService();
        return instance;
    }
    
//    public Ticket purchaseTicket(...) throws InsufficientBalanceException {
//        if (customer.getWalletBalance() < price) {
//            throw new InsufficientBalanceException("Số dư không đủ. Cần thêm: " + (price - customer.getWalletBalance()));
//        }
    
    public Ticket purchaseTicket(Customer customer, String startStation, String endStation, TicketType ticketType) {
        

        int distance = routeService.calculateStationDistance(startStation, endStation);
        

        double price = farePolicy.calculateFare(distance, extractCustomerType(customer));

     
        String ticketId = "TICKET-" + System.currentTimeMillis();
        Ticket newTicket = new Ticket(ticketId, customer, ticketType, price);
        
     
        
        System.out.println("Mua vé thành công: " + price + " VNĐ");
        return newTicket;
    }
    
    
    private com.metro.enums.CustomerType extractCustomerType(Customer c) {
        
        return com.metro.enums.CustomerType.ADULT; 
    }
}