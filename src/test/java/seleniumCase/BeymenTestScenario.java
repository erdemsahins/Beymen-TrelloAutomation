package seleniumCase;

import org.junit.Test;

public class BeymenTestScenario extends BaseTestKeyword {

    @Test
    public void beymen() {
        beymenTest();
    }

    @Test
    public void girisTest() {
        girisYap("mxj84663@xcoxc.com", "Test1234");
        urunAra("Bilgisayar");
        sepeteEkle();
    }

    @Test
    public void urunAra(){
        urunAra("Telefon");
        sepeteEkle();
    }


}
