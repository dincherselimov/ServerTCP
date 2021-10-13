package JunitTests.TestServerTCP;

import Config.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class testServerTCPNegative {

    /**
     * Negative test for wrong port
     *
     * @throws IOException
     */
    @Test
    public void serverTCPN() throws IOException {

        int socket_port = Config.getInstance().getPort();

        int expected_port = 79;

        assertEquals(expected_port, socket_port);

        System.out.println("Expected port = " + expected_port + " \n" + "Actual Port = " + socket_port);

    }
}
