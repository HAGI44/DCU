import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class WebSocketExample {
    private static WebSocketClient ws;
    private static int varCaptchaError = 0;
    private static boolean tmpState = true;
    private static String userAuthKey;
    private static String uniqueKey;

    public static void main(String[] args) {
        connectWebSocket();
    }

    private static void connectWebSocket() {
        String host = "sugang.cu.ac.kr";
        int port = 50000;
        try {
            ws = new WebSocketClient(new URI("ws://" + host + ":" + port + "/")) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    System.out.println("ws connection ok");
                }

                @Override
                public void onMessage(String message) {
                    String[] tok = message.split("!$$!");
                    String cmd = tok[0];
                    switch (cmd) {
                        case "LOGINOK":
                            userAuthKey = tok[1];
                            varCaptchaError = 0;
                            // Handle LOGINOK message
                            break;
                        case "CONNOK":
                            writeAlert(tok[1]);
                            break;
                        // Handle other commands similarly
                        case "CAPTCHAERR":
                            varCaptchaError++;
                            writeAlertCaptcha(tok[1] + "\n(오류횟수:" + varCaptchaError + ")");
                            if (varCaptchaError > 9) {
                                writeAlert("오류횟수 초과로 화면을 닫습니다.");
                                clientClose();
                            }
                            break;
                        // Handle other cases
                        default:
                            System.out.println(message);
                    }
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    System.out.println("Connection closed: " + reason);
                    if (tmpState) {
                        System.out.println("Reloading page...");
                        // Implement reloading page if needed
                    } else {
                        System.out.println("Switching to error page...");
                        // Implement switching to error page if needed
                    }
                }

                @Override
                public void onError(Exception ex) {
                    System.err.println("Error: " + ex.getMessage());
                }
            };
            ws.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private static void clientClose() {
        System.out.println("Switching to information page...");
        // Implement switching to information page if needed
    }

    private static void writeAlert(String msg) {
        System.out.println(msg);
        // Implement UI update if needed
    }

    private static void writeAlertCaptcha(String msg) {
        System.out.println(msg);
        // Implement UI update if needed
    }
}
