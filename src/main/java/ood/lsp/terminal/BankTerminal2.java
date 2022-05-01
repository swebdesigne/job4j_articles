package ood.lsp.terminal;

public class BankTerminal2 extends BankTerminal {
    public BankTerminal2(int uniqueId) {
        super(uniqueId);
    }

    public int processPayment(int amount) {
        if (amount < 10) {
            throw new IllegalArgumentException("The amount must be more ten");
        }
        if (uniqueId > 20) {
            throw new IllegalArgumentException("The uniqueId must be more twenty");
        }
        return amount;
    }
}
