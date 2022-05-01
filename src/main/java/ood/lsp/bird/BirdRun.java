package ood.lsp.bird;

public class BirdRun {
    private Bird bird;

    public BirdRun(Bird bird) {
        this.bird = bird;
    }

    public void run() {
        bird.fly();
    }
}
