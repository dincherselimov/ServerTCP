package JunitTests.TestServerTCP;

import Config.Config;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class testServerTCPPositive {

    /**
     * Positive test for correct port
     * @throws IOException
     */
    @Test
    public void serverTCPP() throws IOException {

        int socket_port = Config.getInstance().getPort();

        int expected_port = 80;

        assertEquals(expected_port,socket_port);

        System.out.println("Expected port = " + expected_port + " \n" + "Actual Port = " + socket_port);

    }
}
