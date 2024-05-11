package dev.durgesh.Splitwise.service.strategy.settleupStrategy;

import dev.durgesh.Splitwise.entity.Expense;
import dev.durgesh.Splitwise.entity.SettlementTransaction;

import java.util.List;

public interface SettleUpStrategy {
    List<SettlementTransaction> getSettlementTransaction(List<Expense> expenses);
}
