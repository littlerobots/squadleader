package nl.littlerobots.squadleader.verification;

import nl.littlerobots.squadleader.Keep;
import nl.littlerobots.squadleader.KeepName;

public class KeepFieldsTester {
    @KeepName
    // this field will be stripped, since it's unused
    public String unused;
    @Keep
    // this field will be kept, even if it's unused
    public boolean hallo;
}
