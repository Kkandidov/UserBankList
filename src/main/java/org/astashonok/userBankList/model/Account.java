package org.astashonok.userBankList.model;

import java.util.Objects;

public class Account {
    private int account_id;
    private int account;
    private int user_id;

    public Account() {
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account=" + account +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return account_id == account1.account_id &&
                account == account1.account &&
                user_id == account1.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id, account, user_id);
    }
}
