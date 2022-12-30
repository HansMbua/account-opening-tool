package com.love2code.accountopeningtool.Repository;

import com.love2code.accountopeningtool.Model.CurrentAccount;
import com.love2code.accountopeningtool.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class AccountRepository  {

    List<CurrentAccount> currentAccounts ;

    public AccountRepository(){
        this.currentAccounts = new ArrayList<>(Arrays.asList(

        ));
    }
    public Optional<CurrentAccount> findById(Long id) {

        return currentAccounts.stream().filter(currentAccount -> currentAccount.getCustomerId().equals(id)).findFirst();
    }

    public CurrentAccount save(CurrentAccount currentAccount) {
        currentAccounts.add(currentAccount);
        return currentAccount;
    }

    public void deleteById(Long id) {
        currentAccounts.removeIf(c -> c.getCustomerId().equals(id));
    }

}
