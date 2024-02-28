import org.example.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet("Nopal");
    }

    @Test
    public void testKartuKosong() {
        assertTrue(wallet.getListKartu().isEmpty());

        wallet.tambahKartu("KTP");
        wallet.tambahKartu("Kartu ATM");

        assertFalse(wallet.getListKartu().isEmpty());
        assertEquals(2, wallet.getListKartu().size());
    }

    @Test
    public void testKartuHapus() {
        wallet.tambahKartu("SIM");

        String kartuDihapus = wallet.ambilKartu("SIM");

        assertEquals("SIM", kartuDihapus);
        assertTrue(wallet.getListKartu().isEmpty());
    }

    @Test
    public void testUang() {
        wallet.tambahUang(20000);
        wallet.tambahUang(50000);

        List<Integer> expectedUangLembaran = new ArrayList<>();
        expectedUangLembaran.add(20000);
        expectedUangLembaran.add(50000);
        assertEquals(expectedUangLembaran, wallet.getListUangLembaran());
    }

    @Test
    public void testKoin() {
        wallet.tambahUang(500);
        wallet.tambahUang(1000);

        List<Integer> expectedUangKoin = new ArrayList<>();
        expectedUangKoin.add(500);
        expectedUangKoin.add(1000);
        assertEquals(expectedUangKoin, wallet.getListUangKoin());
    }

    @Test
    public void testUangTotal() {
        wallet.tambahUang(5000);
        wallet.tambahUang(1000);
        wallet.tambahUang(20000);

        int totalUang = wallet.tampilkanUang();
        assertEquals(26000, totalUang);
    }

    @Test
    public void testUangAmbil() {
        wallet.tambahUang(50000);

        int uangDiambil = wallet.ambilUang(50000);

        assertEquals(50000, uangDiambil);
        assertTrue(wallet.getListUangLembaran().isEmpty());
    }

    @Test
    public void testUangAmbilKoin() {
        wallet.tambahUang(1000);

        int uangDiambil = wallet.ambilUang(1000);

        assertEquals(1000, uangDiambil);
        assertTrue(wallet.getListUangKoin().isEmpty());
    }


}