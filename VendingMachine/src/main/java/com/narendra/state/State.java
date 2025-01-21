package com.narendra.state;

import com.narendra.entity.Cash;
import com.narendra.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface State {
    default void insertCash(Cash cash) {
        System.out.println("Can't accept cash now");
    }
    default void productSelected(int productId) {
        System.out.println("Can't select product now");
    }
    default void handleInvalidProduct(int productId) {
        System.out.println("Can't handle invalid product now");
    }
    default void handleOutOfStock(int productId) {
        System.out.println("Can't handle out of stock now");
    }

    default void checkProduct(int productId) {
        System.out.println("Can't check product now");
    }
    default void checkFunds(Product product) {
        System.out.println("Can't check funds now");
    }
    default void dispenseProduct(Product product) {
        System.out.println("Can't dispense a product now");
    }
    default void handleInsufficientFunds(double price, double cash) {
        System.out.println("Can't handle insufficient funds now");
    }
    default List<Cash> cancel() {
        System.out.println("Can't cancel now");
        return new ArrayList<>();
    }

    default List<Cash> ejectCash() {
        System.out.println("Can't eject cash now");
        return new ArrayList<>();
    }

    default void timeout() {
        System.out.println("Timeout not allowed now");
    }
}
