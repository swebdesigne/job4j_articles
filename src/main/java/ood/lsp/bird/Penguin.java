package ood.lsp.bird;


public class Penguin extends Bird {
    public int fly() {
        throw new IllegalArgumentException("I can`t fly");
    }

    public int swim() {
        int swimSpeed = 4;
        return swimSpeed;
    }
}
