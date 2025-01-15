package com.narendra.state;

import com.narendra.entity.Cash;

import java.util.List;

public interface State {
    void initiate();
    void insertCash(List<Cash> cash);
    void cancel();
    void returnCash();
    void selectProduct(int code);
    void dispenseProduct(int code);
    void dispenseChange(double price);
}
