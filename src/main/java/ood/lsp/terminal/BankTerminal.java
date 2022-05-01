package ood.lsp.terminal;

public class BankTerminal implements IBankTerminal {
    protected int uniqueId;

    public BankTerminal(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public int processPayment(int amount) {
        if (amount < 10) {
            throw new IllegalArgumentException("The amount must be more ten");
        }
        if (uniqueId > 0) {
            throw new IllegalArgumentException("The uniqueId must be more zero");
        }
        int result = amount + 10;
        if (result < 100) {
            throw new IllegalArgumentException("The result less 100");
        }
        return result;
    }
}
