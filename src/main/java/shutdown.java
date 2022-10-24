import functions.player;

import javax.swing.*;

public class shutdown {
    private JButton start;
    private JPanel mainPanel;

    public shutdown() {
        JFrame frame = new JFrame("shutdown");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 400);
        start.addActionListener(e -> {
            try {
                new Thread(() -> {
                    try {
                        player player = new player();
                        player.play(getClass().getResource("/sounds/shutdown.wav"));
                        new Thread(() -> {
                            try {
                                Thread.sleep(6000);
                                for (int i = 0; i < 10; i++) {
                                    System.out.println("Shutdown in T-" + (10 - i));
                                    Thread.sleep(1000);
                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }).start();
                        Thread.sleep(16000);
                        System.out.println("Shutdown");
                        try {
                            String OperatingSystem = System.getProperty("os.name");
                            if (OperatingSystem.contains("Windows")) {
                            Runtime.getRuntime().exec("shutdown -s -t 0");
                            }
                            else {
                                Runtime.getRuntime().exec("shutdown -h now");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }).start();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new shutdown();
    }
}
